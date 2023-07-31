package org.dows.pay.weixin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.InputStreamResource;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.github.binarywang.wxpay.bean.ecommerce.ApplymentsRequest;
import com.github.binarywang.wxpay.bean.media.ImageUploadResult;
import com.github.binarywang.wxpay.service.WxPayService;
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
import org.apache.commons.io.FileUtils;
import org.dows.auth.api.weixin.WeixinTokenApi;
import org.dows.auth.biz.utils.HttpClientResult;
import org.dows.auth.biz.utils.HttpClientUtils;
import org.dows.framework.api.exceptions.BizException;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.annotation.PayMapping;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.request.MiniUploadRequest;
import org.dows.pay.bo.Categories;
import org.dows.pay.bo.UploadBo;
import org.dows.pay.bo.WxBaseInfoBo;
import org.dows.pay.bo.WxFastMaCategoryBo;
import org.dows.pay.form.WxFastMaCategoryForm;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
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
    // 查询小程序名称审核状态
    private final String WX_GET_NICK_NAME_STATUS = "https://api.weixin.qq.com/wxa/api_wxa_querynickname";
    // 设置小程序介绍
    private final String WX_SET_SIGN_ATURE = "https://api.weixin.qq.com/cgi-bin/account/modifysignature";
    // 添加类目
    private final String WX_SET_ADD_CATEGORY = "https://api.weixin.qq.com/cgi-bin/wxopen/addcategory";
    // 添加类目
    private final String WX_SET_FILED_URL = "https://api.weixin.qq.com/cgi-bin/media/upload";


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
    public WxOpenResult addCategory(PayRequest payRequest) throws Exception {
        //todo 待实现业务逻辑
        WxOpenResult response = null;
        List<WxFastMaCategory> list = new ArrayList<>();
        WxFastMaCategory wxFastMaCategory = new WxFastMaCategory();
        WxFastMaCategoryBo wxFastMaCategoryBo = (WxFastMaCategoryBo) payRequest.getBizModel();
        log.info("设置小程序类目入参，：{}", wxFastMaCategoryBo);
        // 类目资质
        List<WxFastMaCategoryBo.Certificate> certicates = wxFastMaCategoryBo.getCerticates();
        if (!ObjectUtil.isEmpty(certicates)) {
            certicates.forEach(x -> {
                if (!ObjectUtil.isEmpty(x.getValue())) {
                    File uboIdDocCopyFile;
                    if (x.getValue().startsWith("http")) {
                        String path = x.getValue();
                        String substringPath = path.substring(path.lastIndexOf(StringPool.SLASH, path.lastIndexOf(StringPool.SLASH) - 1));
                        uboIdDocCopyFile = new File("/opt/dows/tenant/image" + substringPath);
//                        URL url = null;
//                        try {
//                            String replaceUrl = x.getValue().replaceAll("https:/", "https://");
//                            url = new URL(replaceUrl);
//                            String tempPath = replaceUrl.substring(replaceUrl.lastIndexOf('/'));
//                            File mediaFile = new File("/opt/dows/tenant/image"+tempPath);
//                            FileUtils.copyURLToFile(url, mediaFile);
//                        } catch (Exception e) {
//                            System.out.println("url convert error:"+e);
//                            log.error("url convert error:",e);
//                        }
                    } else {
                        String filePath = getFilePath(x.getValue());
                        uboIdDocCopyFile = new File(filePath);
                    }
                    String uploadimg = uploadimg(uboIdDocCopyFile, payRequest.getAuthorizerAccessToken());
                    log.info("新增类目MediaId：{}", uploadimg);
                    if (null != uploadimg) {
                        UploadBo uploadBo = JSONObject.parseObject(uploadimg, UploadBo.class);
                        log.info("=========转换文件上传，{}", uploadBo);
                        x.setValue(uploadBo.getMedia_id());
                    }
                }
            });
        }
        BeanUtil.copyProperties(wxFastMaCategoryBo, wxFastMaCategory);
        list.add(wxFastMaCategory);

        Categories categories = new Categories();
        categories.setCategories(list);
        String categoriesJson = JSONObject.toJSONString(categories);
        log.info("====================上传类目请求入参：{}", categoriesJson);
        System.out.println("====================上传类目请求入参:"+categoriesJson);
        String post = HttpUtil.post(WX_SET_ADD_CATEGORY +
                "?access_token=" + payRequest.getAuthorizerAccessToken(), categoriesJson);
        System.out.println("上传类目请求结果:"+post);
        response = WxOpenGsonBuilder.create().fromJson(post, WxOpenResult.class);
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
        log.info("设置小程序名称入：{}", wxBaseInfoBo);
        String licenseMediaId = null;
        String idCardMediaId = null;
        String namingOtherStuff1MediaId = null;
        String namingOtherStuff2MediaId = null;
        if (wxBaseInfoBo.getLicense() != null) {
            String filePath = getFilePath(wxBaseInfoBo.getLicense());
            File financeLicensePicsFile = new File(filePath);
            if (!financeLicensePicsFile.exists()) {
                System.out.println("financeLicensePicsFile不存在");
            }
            licenseMediaId = upload(financeLicensePicsFile, payRequest).getMediaId();
            log.info("设置名称===licenseMediaId：{}", licenseMediaId);
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
    public WxFastMaQueryNicknameStatusResult getNickNameStatus(PayRequest payRequest) throws Exception {
        //todo 待实现业务逻辑
        WxFastMaQueryNicknameStatusResult response = null;
        try {
            WxBaseInfoBo wxBaseInfoBo = (WxBaseInfoBo) payRequest.getBizModel();
//            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().querySetNicknameStatus(wxBaseInfoBo.getAuditId());
            Map<String, String> param = new HashMap<>();
            param.put("audit_id", wxBaseInfoBo.getAuditId());
            HttpClientResult uploadTemplateResult = HttpClientUtils.doPost(WX_GET_NICK_NAME_STATUS +
                    "?access_token=" + payRequest.getAuthorizerAccessToken(), param, 1);
            String content = uploadTemplateResult.getContent();
            response = WxOpenGsonBuilder.create()
                    .fromJson(content, WxFastMaQueryNicknameStatusResult.class);
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
        log.info("设置小程序简介入参：{}", wxBaseInfoBo);
//            response = this.getWxOpenMaClient(payRequest.getAppId()).getBasicService().modifySignature(wxBaseInfoBo.getSignature());
        Map<String, String> param = new HashMap<>();
        param.put("signature", wxBaseInfoBo.getSignature());
        HttpClientResult uploadTemplateResult = HttpClientUtils.doPost(WX_SET_SIGN_ATURE +
                "?access_token=" + payRequest.getAuthorizerAccessToken(), param, 1);
        String content = uploadTemplateResult.getContent();
        response = WxOpenGsonBuilder.create().fromJson(content, WxOpenResult.class);
        log.info("设置介绍,返回结果");
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
            log.info("上传文件================：入参{}", request);
            result = this.getWeixinClient(payRequest.getAppId()).postV3(url, request);
            log.info("上传文件================：返回结果{}", result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ImageUploadResult.fromJson(result);
    }


    /**
     * 小程序上传文件接口
     *
     * @param fileSystemResource
     */
    public String uploadimg(File fileSystemResource, String authorizerAccessToken) {
        RestTemplate restTemplate = new RestTemplate();
        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.weixin.qq.com/cgi-bin/media/upload")
                .queryParam("access_token", authorizerAccessToken)
                .queryParam("type", "image")
                .build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        ContentDisposition build = ContentDisposition.builder("form-data")
                .filename(Objects.requireNonNull(fileSystemResource.getName()))
                .build();
        headers.setContentDisposition(build);
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("media", new FileSystemResource(fileSystemResource));
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(uri, requestEntity, String.class);
    }

//    public static String getFilePath(String path) {
//        String arrPath[] = path.split(DateUtil.formatDate(DateUtil.date()));
//        if (ObjectUtil.isNotEmpty(arrPath) && arrPath.length > 1) {
//            path = arrPath[1];
//            path = "E:\\有星科技相关\\image\\" + path;
//        }
//        return path;
//    }

    /**
     * 获取文件路径
     */
    public static String getFilePath(String path) {
//        String arrPath[] = path.split(DateUtil.formatDate(DateUtil.date()));
//        if (ObjectUtil.isNotEmpty(arrPath) && arrPath.length > 1) {
//            path = arrPath[1];
//        }
        String jPath = "/opt/dows/tenant" + path;
        log.info("图片绝对路径 ：{}", jPath);
        return jPath;
    }
}
