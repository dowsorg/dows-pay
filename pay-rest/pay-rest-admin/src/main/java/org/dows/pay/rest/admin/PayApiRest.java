package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayApi;
import org.dows.pay.form.PayApiForm;
import org.dows.pay.service.PayApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付通道接口(PayApi)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:51
 */
@Api(tags = "支付通道接口")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payApi")
public class PayApiRest implements MybatisCrudRest<PayApiForm, PayApi, PayApiService> {

    //private final PayApiBiz payApiBiz;

}

