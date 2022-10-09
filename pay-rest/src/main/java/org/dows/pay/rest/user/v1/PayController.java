package org.dows.pay.rest.user.v1;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.request.PayIsvRequest;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "支付接口")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class PayController {


    private final PayDispatcher payDispatcher;


    @PostMapping("/test")
    @ApiOperation(value = "支付路由")
    public Response<PayResponse> dispatcher(@RequestBody PayIsvRequest payRequest) {
       return payDispatcher.dispatcher(payRequest);
    }


}
