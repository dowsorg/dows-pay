package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayRule;
import org.dows.pay.form.PayRuleForm;
import org.dows.pay.service.PayRuleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付规则(PayRule)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:53
 */
@Api(tags = "支付规则")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payRule")
public class PayRuleRest implements MybatisCrudRest<PayRuleForm, PayRule, PayRuleService> {

    //private final PayRuleBiz payRuleBiz;

}

