package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayDirective;
import org.dows.pay.form.PayDirectiveForm;
import org.dows.pay.service.PayDirectiveService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付指令集(PayDirective)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:52
 */
@Api(tags = "支付指令集")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payDirective")
public class PayDirectiveRest implements MybatisCrudRest<PayDirectiveForm, PayDirective, PayDirectiveService> {

    //private final PayDirectiveBiz payDirectiveBiz;

}

