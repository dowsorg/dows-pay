package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayApply;
import org.dows.pay.form.PayApplyForm;
import org.dows.pay.service.PayApplyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付接入申请(PayApply)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:51
 */
@Api(tags = "支付接入申请")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payApply")
public class PayApplyRest implements MybatisCrudRest<PayApplyForm, PayApply, PayApplyService> {

    //private final PayApplyBiz payApplyBiz;

}

