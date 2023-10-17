package org.dows.pay.rest.admin;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.crud.mybatis.MybatisCrudRest;
import org.dows.pay.entity.PayChannel;
import org.dows.pay.form.PayChannelForm;
import org.dows.pay.service.PayChannelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付通道(PayChannel)表控制层
 *
 * @author lait.zhang
 * @since 2022-09-25 09:39:52
 */
@Api(tags = "支付通道")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("payChannel")
public class PayChannelRest implements MybatisCrudRest<PayChannelForm, PayChannel, PayChannelService> {

    //private final PayChannelBiz payChannelBiz;

}

