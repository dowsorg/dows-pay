package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.binarywang.wxpay.bean.media.ImageUploadResult;
import com.github.binarywang.wxpay.v3.WechatPayUploadHttpPost;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.open.api.WxOpenMaBasicService;
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
    // 设置小程序名称
    private final String WX_SET_NICK_NAME = "https://api.weixin.qq.com/wxa/setnickname";
    // 设置小程序介绍
    private final String WX_SET_SIGN_ATURE = "https://api.weixin.qq.com/cgi-bin/account/modifysignature";


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
            param.put("template_id", payRequest.getTemplateId());
            param.put("ext_json", payRequest.getExtJsonObject());
            param.put("user_version", payRequest.getUserVersion());
            param.put("user_desc", payRequest.getUserDesc());
            HttpClientResult uploadTemplateResult = HttpClientUtils.doPost(WX_API_UPLOAD_TEMPLATE_URL + "?component_access_token=" + authorizerAccessToken, param, 1);

            String content = uploadTemplateResult.getContent();
            return JSON.parseObject(content, WxOpenResult.class);
        } catch (Exception e) {
            log.info("uploadMini fail :", e);
            throw new BizException(e.getMessage());
        }
    }


    /**
     * 小程序提交审核
     * https://opendocs.alipay.com/mini/03l9bq
     * alipay.open.mini.version.audit.apply(小程序提交审核)
     */
    public WxOpenMaSubmitAuditResult auditMini(PayRequest payRequest) {
        WxOpenMaSubmitAuditResult response = null;
        WxOpenMaSubmitAuditMessage wxOpenMaSubmitAuditMessage = GSON.fromJson
                (GSON.toJson(payRequest.getBizModel().getWeixinFeilds()), WxOpenMaSubmitAuditMessage.class);
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).submitAudit(
                    wxOpenMaSubmitAuditMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;

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
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
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
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
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
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
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
            WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo) payRequest.getBizModel();
            BeanUtil.copyProperties(wxFastMaCategoryBo, wxFastMaCategory);
            list.add(wxFastMaCategory);
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().addCategory(list);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
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
            WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo) payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .deleteCategory(wxFastMaCategoryBo.getFirst(), wxFastMaCategoryBo.getSecond());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 小程序类目管理
     * 获取已设置的所有类目
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY_HANDLED)
    public WxFastMaBeenSetCategoryResult getCategory(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxFastMaBeenSetCategoryResult response = null;
        try {
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .getCategory();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 小程序类目管理
     * 修改类目资质信息
     */
    @PayMapping(method = PayMethods.MINI_CATEGORY_UPDATE)
    public WxOpenResult modifyCategory(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo) payRequest.getBizModel();
            WxFastMaCategory category = new WxFastMaCategory();
            BeanUtil.copyProperties(wxFastMaCategoryBo, category);
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
                    .modifyCategory(category);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 小程序基础信息管理
     * 设置小程序名称
     */
    @PayMapping(method = PayMethods.MINI_BASE_NICKNAME)
    public WxFastMaSetNickameResult setNickName(PayRequest payRequest) throws Exception {
        //todo 待实现业务逻辑
        WxFastMaSetNickameResult response = null;
        WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo) payRequest.getBizModel();
        String licenseMediaId = null;
        String idCardMediaId = null;
        String namingOtherStuff1MediaId = null;
        String namingOtherStuff2MediaId = null;
        if (wxBaseInfoBo.getLicense() != null) {
            File financeLicensePicsFile = new File(getFilePath(wxBaseInfoBo.getLicense()));
            licenseMediaId = upload(financeLicensePicsFile, payRequest).getMediaId();
        }
        if (wxBaseInfoBo.getIdCard() != null) {
            File financeLicensePicsFile = new File(getFilePath(wxBaseInfoBo.getIdCard()));
            idCardMediaId = upload(financeLicensePicsFile, payRequest).getMediaId();
        }
        if (wxBaseInfoBo.getNamingOtherStuff1() != null) {
            File financeLicensePicsFile = new File(getFilePath(wxBaseInfoBo.getNamingOtherStuff1()));
            namingOtherStuff1MediaId = upload(financeLicensePicsFile, payRequest).getMediaId();
        }

        if (wxBaseInfoBo.getNamingOtherStuff2() != null) {
            File financeLicensePicsFile = new File(getFilePath(wxBaseInfoBo.getNamingOtherStuff2()));
            namingOtherStuff2MediaId = upload(financeLicensePicsFile, payRequest).getMediaId();
        }
//        WxOpenMaBasicService basicService = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService();
//        basicService.setNickname(wxBaseInfoBo.getNickName(), licenseMediaId, idCardMediaId, namingOtherStuff1MediaId,
//                namingOtherStuff2MediaId);
//        response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService()
//                    .setNickname(wxBaseInfoBo.getNickName(), licenseMediaId, idCardMediaId, namingOtherStuff1MediaId,
//                            namingOtherStuff2MediaId);
        Map<String, String> param = new HashMap<>();
        param.put("nick_name", wxBaseInfoBo.getNickName());
        param.put("license", licenseMediaId);
        param.put("id_card", idCardMediaId);
        param.put("naming_other_stuff_1", namingOtherStuff1MediaId);
        param.put("naming_other_stuff_2", namingOtherStuff2MediaId);
        HttpClientResult uploadTemplateResult = HttpClientUtils.doPost(WX_SET_NICK_NAME +
                "?access_token=" + payRequest.getAuthorizerAccessToken(), param, 1);
        String content = uploadTemplateResult.getContent();
        response = WxOpenGsonBuilder.create().fromJson(content, WxFastMaSetNickameResult.class);

        return response;
    }

    /**
     * 小程序基础信息管理
     * 查询小程序名称审核状态
     */
    @PayMapping(method = PayMethods.MINI_BASE_STATUS)
    public WxFastMaQueryNicknameStatusResult getNickNameStatus(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxFastMaQueryNicknameStatusResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo) payRequest.getBizModel();
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().querySetNicknameStatus(wxBaseInfoBo.getAuditId());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 小程序基础信息管理
     * 设置小程序介绍
     */
    @PayMapping(method = PayMethods.MINI_BASE_SIGNATURE)
    public WxOpenResult setSignature(PayRequest payRequest) throws Exception {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo) payRequest.getBizModel();
//            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().modifySignature(wxBaseInfoBo.getSignature());
        Map<String, String> param = new HashMap<>();
        param.put("signature", wxBaseInfoBo.getSignature());
        HttpClientResult uploadTemplateResult = HttpClientUtils.doPost(WX_SET_SIGN_ATURE +
                "?access_token=" + payRequest.getAuthorizerAccessToken(), param, 1);
        String content = uploadTemplateResult.getContent();
        response = WxOpenGsonBuilder.create().fromJson(content, WxOpenResult.class);
        log.info("设置介绍,返回结果：{}", JSONObject.toJSONString(content));
        return response;
    }

    /**
     * 小程序基础信息管理
     * 修改头像
     */
    @PayMapping(method = PayMethods.MINI_BASE_HEADIMAGE)
    public WxOpenResult setHeadImage(PayRequest payRequest) {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo) payRequest.getBizModel();
            File idCardNationalFile = new File(getFilePath(wxBaseInfoBo.getHeadImgMediaId()));
            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().modifyHeadImage(
                    upload(idCardNationalFile, payRequest).getMediaId(),
                    wxBaseInfoBo.getX1(),
                    wxBaseInfoBo.getY1(),
                    wxBaseInfoBo.getX2(),
                    wxBaseInfoBo.getY2());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * 小程序上传文件接口
     */
    public ImageUploadResult upload(File file, PayRequest payRequest) {
        String url = String.format("%s/v3/merchant/media/upload", this.getWeixinClient(payRequest.getAppId()).getPayBaseUrl());
        String result = "";
        try {
            FileInputStream s1 = new FileInputStream(file);
            String sha256 = DigestUtils.sha256Hex(s1);
            InputStream s2 = new FileInputStream(file);
            WechatPayUploadHttpPost request = new WechatPayUploadHttpPost.Builder(URI.create(url))
                    .withImage(file.getName(), sha256, s2)
                    .build();
            result = this.getWeixinClient(payRequest.getAppId()).postV3(url, request);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ImageUploadResult.fromJson(result);
    }

    public static String getFilePath(String path) {
        String arrPath[] = path.split(DateUtil.formatDate(DateUtil.date()));
        if (ObjectUtil.isNotEmpty(arrPath) && arrPath.length > 1) {
            path = arrPath[1];
            path = "E:\\有星科技相关\\image\\" + path;
        }
        return path;
    }

    /**
     * 获取文件路径
     */
//    public static String getFilePath(String path) {
//        String arrPath[] = path.split(DateUtil.formatDate(DateUtil.date()));
//        if (ObjectUtil.isNotEmpty(arrPath) && arrPath.length > 1) {
//            path = arrPath[1];
//            path = "/tmp" + path;
//        }
//        return path;
//    }
}
