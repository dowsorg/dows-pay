package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.form.PayAccountForm;
import org.dows.pay.service.PayAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付通道账号(PayAccount)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:51
 */
@Api(tags = "支付通道账号")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payAccount")
public class PayAccountRest implements MybatisCrudRest<PayAccountForm, PayAccount, PayAccountService> {

    //private final PayAccountBiz payAccountBiz;

}

