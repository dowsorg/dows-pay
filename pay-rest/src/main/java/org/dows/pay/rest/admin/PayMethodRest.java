package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayMethod;
import org.dows.pay.form.PayMethodForm;
import org.dows.pay.service.PayMethodService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付方法(PayMethod)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:53
 */
@Api(tags = "支付方法")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payMethod")
public class PayMethodRest implements MybatisCrudRest<PayMethodForm, PayMethod, PayMethodService> {

    //private final PayMethodBiz payMethodBiz;

}

