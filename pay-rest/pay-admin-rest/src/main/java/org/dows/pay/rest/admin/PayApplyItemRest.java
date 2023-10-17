package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayApplyItem;
import org.dows.pay.form.PayApplyItemForm;
import org.dows.pay.service.PayApplyItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付接入申请明细(PayApplyItem)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:51
 */
@Api(tags = "支付接入申请明细")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payApplyItem")
public class PayApplyItemRest implements MybatisCrudRest<PayApplyItemForm, PayApplyItem, PayApplyItemService> {

    //private final PayApplyItemBiz payApplyItemBiz;

}

