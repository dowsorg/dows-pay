package org.dows.pay.rest.user.v1;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.biz.OrderPayBiz;
import org.dows.pay.form.PayPartnerTransactionForm;
import org.dows.pay.form.PayTransactionForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "订单支付接口")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class OrderPayRest {


    private final OrderPayBiz orderPayBiz;

    @PostMapping("/order/topay")
    @ApiOperation(value = "用户支付")
    public Response<PayResponse> toPay(@RequestBody PayTransactionForm payTransactionForm) {
        orderPayBiz.toPay(payTransactionForm);
        return Response.ok();
    }


}
