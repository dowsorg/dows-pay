package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayWater;
import org.dows.pay.form.PayWaterForm;
import org.dows.pay.service.PayWaterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付流水(PayWater)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:53
 */
@Api(tags = "支付流水")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payWater")
public class PayWaterRest implements MybatisCrudRest<PayWaterForm, PayWater, PayWaterService> {

    //private final PayWaterBiz payWaterBiz;

}

