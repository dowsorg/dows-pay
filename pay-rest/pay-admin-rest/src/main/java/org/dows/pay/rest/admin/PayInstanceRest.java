package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayInstance;
import org.dows.pay.form.PayInstanceForm;
import org.dows.pay.service.PayInstanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付通道实例(PayInstance)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:52
 */
@Api(tags = "支付通道实例")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payInstance")
public class PayInstanceRest implements MybatisCrudRest<PayInstanceForm, PayInstance, PayInstanceService> {

    //private final PayInstanceBiz payInstanceBiz;

}

