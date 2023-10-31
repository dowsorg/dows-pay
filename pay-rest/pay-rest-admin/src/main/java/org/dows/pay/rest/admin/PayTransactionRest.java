package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayTransaction;
import org.dows.pay.form.PayTransactionForm;
import org.dows.pay.service.PayTransactionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付交易(PayTransaction)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:53
 */
@Api(tags = "支付交易")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payTransaction")
public class PayTransactionRest implements MybatisCrudRest<PayTransactionForm, PayTransaction, PayTransactionService> {

    //private final PayTransactionBiz payTransactionBiz;

}

