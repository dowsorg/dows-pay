package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayCode;
import org.dows.pay.form.PayCodeForm;
import org.dows.pay.service.PayCodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付通道状态码(PayCode)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:52
 */
@Api(tags = "支付通道状态码")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payCode")
public class PayCodeRest implements MybatisCrudRest<PayCodeForm, PayCode, PayCodeService> {

    //private final PayCodeBiz payCodeBiz;

}

