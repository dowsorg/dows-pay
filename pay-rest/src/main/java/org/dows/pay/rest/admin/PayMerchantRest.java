package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayMerchant;
import org.dows.pay.form.PayMerchantForm;
import org.dows.pay.service.PayMerchantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付商户(PayMerchant)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:52
 */
@Api(tags = "支付商户")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payMerchant")
public class PayMerchantRest implements MybatisCrudRest<PayMerchantForm, PayMerchant, PayMerchantService> {

    //private final PayMerchantBiz payMerchantBiz;

}

