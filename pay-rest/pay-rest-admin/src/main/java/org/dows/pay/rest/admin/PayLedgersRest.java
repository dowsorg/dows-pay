package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.form.PayLedgersForm;
import org.dows.pay.service.PayLedgersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付-分账账本(PayLedgers)表控制层
 *
 * @author lait.zhang
 * @since 2022-10-11 18:37:37
 */
@Api(tags = "支付-分账账本")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payLedgers")
public class PayLedgersRest implements MybatisCrudRest<PayLedgersForm, PayLedgers, PayLedgersService> {

    //private final PayLedgersBiz payLedgersBiz;

}

