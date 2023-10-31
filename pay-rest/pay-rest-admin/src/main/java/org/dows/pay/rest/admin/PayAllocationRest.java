package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayAllocation;
import org.dows.pay.form.PayAllocationForm;
import org.dows.pay.service.PayAllocationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付-分账记录(PayAllocation)表控制层
 *
 * @author lait.zhang
 * @since 2022-10-11 18:37:36
 */
@Api(tags = "支付-分账记录")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payAllocation")
public class PayAllocationRest implements MybatisCrudRest<PayAllocationForm, PayAllocation, PayAllocationService> {

    //private final PayAllocationBiz payAllocationBiz;

}

