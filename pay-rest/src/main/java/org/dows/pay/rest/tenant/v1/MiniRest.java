package org.dows.pay.rest.tenant.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayApi;
import org.dows.pay.api.PayResponse;
import org.dows.pay.biz.MiniBiz;
import org.dows.pay.form.SetWxBaseInfoForm;
import org.dows.pay.form.WxBaseInfoForm;
import org.dows.pay.form.WxFastMaCategoryForm;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "isv服务商相关接口")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class MiniRest {
    private final MiniBiz miniBiz;

    private final PayApi payApi;

    @PostMapping("/mini/addCategory")
    @ApiOperation(value = "代商户添加小程序条目")
    public Response<PayResponse> addCategory(@Validated @RequestBody WxFastMaCategoryForm wxFastMaCategoryForm) {
        miniBiz.addCategory(wxFastMaCategoryForm);
        return Response.ok();
    }

    @PostMapping("/mini/category")
    @ApiOperation(value = "代商户查询小程序条目")
    public Response<PayResponse> category(@Validated @RequestBody WxFastMaCategoryForm wxFastMaCategoryForm) {
        miniBiz.category(wxFastMaCategoryForm);
        return Response.ok();
    }

    @PostMapping("/mini/updateCategory")
    @ApiOperation(value = "代商户更新小程序条目")
    public Response<PayResponse> updateCategory(@Validated @RequestBody WxFastMaCategoryForm wxFastMaCategoryForm) {
        miniBiz.updateCategory(wxFastMaCategoryForm);
        return Response.ok();
    }

    @PostMapping("/mini/delCategory")
    @ApiOperation(value = "代商户删除小程序条目")
    public Response<PayResponse> delCategory(@Validated @RequestBody WxFastMaCategoryForm wxFastMaCategoryForm) {
        miniBiz.delCategory(wxFastMaCategoryForm);
        return Response.ok();
    }

    @PostMapping("/mini/handledCategory")
    @ApiOperation(value = "代商户查询已设置小程序条目")
    public Response<PayResponse> getCategory(@Validated @RequestBody WxFastMaCategoryForm wxFastMaCategoryForm) {
        miniBiz.getCategory(wxFastMaCategoryForm);
        return Response.ok();
    }

    @PostMapping("/mini/setnickname")
    @ApiOperation(value = "代商户设置小程序名称")
    public Response<PayResponse> setNickName(@Validated @RequestBody WxBaseInfoForm wxBaseInfoForm) {
        miniBiz.setNickName(wxBaseInfoForm);
        return Response.ok();
    }

    @PostMapping("/mini/getNickNameStatus")
    @ApiOperation(value = "查询小程序名称审核状态")
    public Response<PayResponse> getNickNameStatus(@Validated @RequestBody WxBaseInfoForm wxBaseInfoForm) {
        miniBiz.getNickNameStatus(wxBaseInfoForm);
        return Response.ok();
    }

    @PostMapping("/mini/setSignature")
    @ApiOperation(value = "设置小程序介绍")
    public Response<PayResponse> setSignature(@Validated @RequestBody WxBaseInfoForm wxBaseInfoForm) {
        miniBiz.setSignature(wxBaseInfoForm);
        return Response.ok();
    }

    @PostMapping("/mini/setHeadImage")
    @ApiOperation(value = "修改头像")
    public Response<PayResponse> setHeadImage(@Validated @RequestBody WxBaseInfoForm wxBaseInfoForm) {
        miniBiz.setHeadImage(wxBaseInfoForm);
        return Response.ok();
    }

    @GetMapping("/mini/queryApplymentStatus")
    @ApiOperation(value = "查询小程序申请支付权限结果")
    public Response<PayResponse> queryApplymentStatus(@RequestParam("applymentId") String applymentId) {
        Response response = payApi.queryApplymentStatus(applymentId);
        return response;
    }

    @PostMapping("/mini/setWxinApplyInfo")
    @ApiOperation(value = "设置小程序相关信息(微信or支付宝)")
    public Response<PayResponse> setWxinApplyInfo(@Validated @RequestBody SetWxBaseInfoForm setWxBaseInfoForm) {
        try {
            if (setWxBaseInfoForm.getMerchantAppId() == null) {
                return Response.failed("缺少商户appId");
            }
            Response response;
            if (setWxBaseInfoForm.getChannel().equals("weixin")) {
                // 微信
                response = miniBiz.setWxinApplyInfo(setWxBaseInfoForm);
            } else {
                // 支付宝
                response = miniBiz.miniVersionAuditApply(setWxBaseInfoForm);
            }
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failed(e.getMessage());
        }
    }


    @PostMapping("/mini/queryIsvCategory")
    @ApiOperation(value = "查询类目信息（支付宝）")
    public Response<PayResponse> queryIsvCategory(@Validated @RequestBody WxBaseInfoForm setWxBaseInfoForm) {
        try {
            // 微信
            Response   response = miniBiz.queryAlipayIsvCategory(setWxBaseInfoForm);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failed(e.getMessage());
        }
    }
}
