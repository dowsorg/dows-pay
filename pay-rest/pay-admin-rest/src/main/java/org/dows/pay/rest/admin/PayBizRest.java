package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayBiz;
import org.dows.pay.form.PayBizForm;
import org.dows.pay.service.PayBizService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付业务(PayBiz)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:51
 */
@Api(tags = "支付业务")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payBiz")
public class PayBizRest implements MybatisCrudRest<PayBizForm, PayBiz, PayBizService> {

    //private final PayBizBiz payBizBiz;

}

