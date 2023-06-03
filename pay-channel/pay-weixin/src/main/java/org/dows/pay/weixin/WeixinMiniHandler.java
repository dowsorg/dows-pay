package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.request.AlipayOpenMiniVersionAuditApplyRequest;
import com.github.binarywang.wxpay.bean.ecommerce.FinishOrderRequest;
import com.github.binarywang.wxpay.bean.media.ImageUploadResult;
import com.github.binarywang.wxpay.v3.WechatPayUploadHttpPost;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenMaService;
import me.chanjar.weixin.open.bean.ma.WxFastMaCategory;
import me.chanjar.weixin.open.bean.message.WxOpenMaSubmitAuditMessage;
import me.chanjar.weixin.open.bean.result.*;
import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;
import org.apache.commons.codec.digest.DigestUtils;
import org.dows.auth.api.weixin.WeixinTokenApi;
import org.dows.auth.biz.utils.HttpClientResult;
import org.dows.auth.biz.utils.HttpClientUtils;
import org.dows.framework.api.exceptions.BizException;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.MiniUploadRequest;
import org.dows.pay.api.request.TemplateSubmitReq;
import org.dows.pay.bo.WxBaseInfoBo;
import org.dows.pay.bo.WxFastMaCategoryBo;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.*;

/**
 * 小程序相关业务功能
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeixinMiniHandler extends AbstractWeixinHandler {


    private final WeixinTokenApi weixinTokenApi;

    // 上传模板
    private final String WX_API_UPLOAD_TEMPLATE_URL = "https://api.weixin.qq.com/wxa/commit";

    // 提交审核
    private final String WX_API_TEMPLATE_SUBMIT_URL = "https://api.weixin.qq.com/wxa/submit_audit";

    private static final Gson GSON = new GsonBuilder().create();
    /**
     * 上传小程序模板
     * https://opendocs.alipay.com/mini/03l8bz
     * alipay.open.mini.version.upload(小程序基于模板上传版本)
     */
    @PayMapping(method = PayMethods.MINI_UPLOAD)
    public WxOpenResult uploadMini(MiniUploadRequest payRequest) {

        try {
            String authorizerAccessToken = weixinTokenApi.getAuthorizerAccessToken(payRequest.getAuthorizerAppid());
            Map<String, String> param = new HashMap<>();
            param.put("template_id",payRequest.getTemplateId());
            param.put("ext_json",payRequest.getExtJsonObject());
            param.put("user_version",payRequest.getUserVersion());
            param.put("user_desc",payRequest.getUserDesc());
            HttpClientResult uploadTemplateResult = HttpClientUtils.doPost(WX_API_UPLOAD_TEMPLATE_URL + "?component_access_token=" + authorizerAccessToken, param, 1);

            String content = uploadTemplateResult.getContent();
            WxOpenResult wxOpenResult = JSON.parseObject(content, WxOpenResult.class);
            if (Objects.equals(wxOpenResult.getErrcode(),"0")) {
                // 提交审核
                submit(authorizerAccessToken);
            }
            return wxOpenResult;
        }catch (Exception e) {
            log.info("uploadMini fail :",e);
            throw new BizException(e.getMessage());
        }
    }

    private void submit(String authorizerAccessToken) {
        // 提交审核
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("item_list",listSubmitContent());
        log.info("item_list====={}",JSON.toJSONString(paramsMap));
        HttpResponse submitResult = HttpRequest.post(WX_API_TEMPLATE_SUBMIT_URL + "?component_access_token="
                + authorizerAccessToken).body(JSON.toJSONString(paramsMap)).execute();
        log.info("submitResult is {}", submitResult);
        String body = submitResult.body();
        String auditid = JSON.parseObject(body).getString("auditid");
        log.info("auditid is {}",auditid);
        // todo:保存数据库
    }

    private List<TemplateSubmitReq> listSubmitContent() {
        TemplateSubmitReq templateSubmitReq = new TemplateSubmitReq();
        templateSubmitReq.setAddress("index");
        templateSubmitReq.setTag("生活服务");
        templateSubmitReq.setFirst_class("生活服务");
        templateSubmitReq.setSecond_class("跑腿");
        templateSubmitReq.setFirst_id(150);
        templateSubmitReq.setSecond_id(1259);
        templateSubmitReq.setTitle("首页");
        return Collections.singletonList(templateSubmitReq);

    }


    /**
     * 小程序提交审核
     * https://opendocs.alipay.com/mini/03l9bq
     * alipay.open.mini.version.audit.apply(小程序提交审核)
     */
    public WxOpenMaSubmitAuditResult  auditMini(PayRequest payRequest) {
        WxOpenMaSubmitAuditResult response = null;
        WxOpenMaSubmitAuditMessage wxOpenMaSubmitAuditMessage = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), WxOpenMaSubmitAuditMessage.class);
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).submitAudit(
                    wxOpenMaSubmitAuditMessage);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;

    }


    /**
     * 小程序上架
     * https://opendocs.alipay.com/mini/03l21p
     * alipay.open.mini.version.online(小程序上架)
     */
    public WxOpenResult onlineMini(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).releaseAudited();
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }

    /**
     * 小程序二维码查看
     * https://opendocs.alipay.com/mini/03l21p
     * alipay.open.mini.version.online(小程序上架)
     */
    public File getQrcode(PayRequest payRequest) {
        //todo 待实现业务逻辑
        File response = null;
        try {
            response = this.getWxOpenMaClient
                    (payRequest.getAppId()).getTestQrcode(
                            payRequest.getBizModel().getWeixinFeilds().get("pagePath").toString(),
                            GSON.fromJson(payRequest.getBizModel().getWeixinFeilds().get("params").toString(), Map.class)
                    );
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }

    /**
     * 小程序类目管理
     * 获取可设置的所有类目
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY)
    public String getAllCategories(PayRequest payRequest) {
        //todo 待实现业务逻辑
        String response = null;
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().getAllCategories();
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }


    /**
     * 小程序类目管理
     * 添加类目
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY_ADD)
    public WxOpenResult addCategory(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            List<WxFastMaCategory> list = new ArrayList<>();
            WxFastMaCategory wxFastMaCategory = new WxFastMaCategory();
            WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo)payRequest.getBizModel();
            BeanUtil.copyProperties(wxFastMaCategoryBo,wxFastMaCategory);
            list.add(wxFastMaCategory);
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().addCategory(list);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }
    /**
     * 小程序类目管理
     * 删除类目
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY_DEL)
    public WxOpenResult delCategory(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo)payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .deleteCategory(wxFastMaCategoryBo.getFirst(),wxFastMaCategoryBo.getSecond());
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }

    /**
     * 小程序类目管理
     * 获取已设置的所有类目
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY_HANDLED)
    public WxFastMaBeenSetCategoryResult getCategory(PayRequest payRequest)  {
        //todo 待实现业务逻辑
        WxFastMaBeenSetCategoryResult response = null;
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .getCategory();
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
        }

    /**
     * 小程序类目管理
     * 修改类目资质信息
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY_UPDATE)
    public WxOpenResult modifyCategory(PayRequest payRequest)  {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo)payRequest.getBizModel();
            WxFastMaCategory category = new WxFastMaCategory();
            BeanUtil.copyProperties(wxFastMaCategoryBo,category);
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .modifyCategory(category);
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }

    /**
     * 小程序基础信息管理
     * 设置小程序名称
     */
    @PayMapping(method = PayMethods.MINI_BASE_NICKNAME)
    public WxFastMaSetNickameResult setNickName(PayRequest payRequest)  {
        //todo 待实现业务逻辑
        WxFastMaSetNickameResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo)payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .setNickname(wxBaseInfoBo.getNickName()
                            ,upload(wxBaseInfoBo.getLicense(),payRequest).getMediaId()
                            ,upload(wxBaseInfoBo.getIdCard(),payRequest).getMediaId()
                            ,upload(wxBaseInfoBo.getNamingOtherStuff1(),payRequest).getMediaId()
                            ,upload(wxBaseInfoBo.getNamingOtherStuff2(),payRequest).getMediaId());
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }
    /**
     * 小程序基础信息管理
     * 查询小程序名称审核状态
     */
    @PayMapping(method = PayMethods.MINI_BASE_STATUS)
    public WxFastMaQueryNicknameStatusResult getNickNameStatus(PayRequest payRequest)  {
        //todo 待实现业务逻辑
        WxFastMaQueryNicknameStatusResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo)payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().querySetNicknameStatus(wxBaseInfoBo.getAuditId());
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }
    /**
     * 小程序基础信息管理
     * 设置小程序介绍
     */
    @PayMapping(method = PayMethods.MINI_BASE_SIGNATURE)
    public WxOpenResult setSignature(PayRequest payRequest)  {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo)payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().modifySignature(wxBaseInfoBo.getSignature());
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }
    /**
     * 小程序基础信息管理
     * 修改头像
     */
    @PayMapping(method = PayMethods.MINI_BASE_HEADIMAGE)
    public WxOpenResult setHeadImage(PayRequest payRequest)  {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo)payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().modifyHeadImage(
                    upload(wxBaseInfoBo.getHeadImgMediaId(),payRequest).getMediaId(),
                    wxBaseInfoBo.getX1(),
                    wxBaseInfoBo.getY1(),
                    wxBaseInfoBo.getX2(),
                    wxBaseInfoBo.getY2());
        }catch (WxErrorException e) {
            e.printStackTrace();
        }
        return  response;
    }
    /**
     * 小程序上传文件接口
     */
    public ImageUploadResult upload(String fileUrl, PayRequest payRequest){
        String url = String.format("%s/v3/merchant/media/upload", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String result = "";
        try{
            File file = new File(fileUrl);
            FileInputStream s1 = new FileInputStream(file);
            String sha256 = DigestUtils.sha256Hex(s1);
            InputStream s2 = new FileInputStream(file);
            WechatPayUploadHttpPost request = new WechatPayUploadHttpPost.Builder(URI.create(url))
                    .withImage(file.getName(), sha256, s2)
                    .build();
            result = this.getWeixinClient(payRequest.getAppId()).postV3(url, request);

        }catch ( Exception e){
            e.printStackTrace();
        }

        return ImageUploadResult.fromJson(result);
    }
}
