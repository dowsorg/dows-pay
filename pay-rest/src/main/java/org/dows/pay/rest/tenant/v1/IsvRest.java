package org.dows.pay.rest.tenant.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.biz.IsvBiz;
import org.dows.pay.form.IsvCreateForm;
import org.dows.pay.form.IsvCreateTyForm;
import org.dows.pay.form.IsvQueryForm;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "isv服务商相关接口")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class IsvRest {

    private final IsvBiz isvBiz;

    @PostMapping("/isv/create")
    @ApiOperation(value = "代商户创建小程序")
    public Response<PayResponse> create(@Validated @RequestBody IsvCreateForm isvCreateForm) {
        isvBiz.isvCreate(isvCreateForm);
        return Response.ok();
    }
    @PostMapping("/isv/ty/create")
    @ApiOperation(value = "代商户创建特约商户小程序")
    public Response<PayResponse> create(@Validated @RequestBody IsvCreateTyForm isvCreateTyForm) {
        isvBiz.isvTyCreate(isvCreateTyForm);
        return Response.ok();
    }

    @PostMapping("/isv/query")
    @ApiOperation(value = "代商户查询小程序")
    public Response<PayResponse> query(@RequestBody IsvQueryForm isvQueryForm) {
        isvBiz.isvQuery(isvQueryForm);
        return Response.ok();
    }


}
