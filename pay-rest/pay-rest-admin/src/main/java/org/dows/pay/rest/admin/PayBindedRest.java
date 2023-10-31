package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayBinded;
import org.dows.pay.form.PayBindedForm;
import org.dows.pay.service.PayBindedService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付卡号绑定（后期放在钱包模块）(PayBinded)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:51
 */
@Api(tags = "支付卡号绑定（后期放在钱包模块）")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payBinded")
public class PayBindedRest implements MybatisCrudRest<PayBindedForm, PayBinded, PayBindedService> {

    //private final PayBindedBiz payBindedBiz;

}

