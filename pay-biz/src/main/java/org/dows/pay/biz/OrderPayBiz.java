package org.dows.pay.biz;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.api.PayResponse;
import org.dows.pay.api.enums.PayMethods;
import org.dows.pay.api.event.OrderPaySuccessEvent;
import org.dows.pay.api.request.OrderPayRequest;
import org.dows.pay.bo.*;
import org.dows.pay.entity.PayAllocation;
import org.dows.pay.entity.PayLedgers;
import org.dows.pay.form.*;
import org.dows.pay.gateway.PayDispatcher;
import org.dows.pay.service.PayAllocationService;
import org.dows.pay.service.PayLedgersService;
import org.dows.pay.service.PayTransactionService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;
import org.springframework.util.SimpleIdGenerator;

import java.util.List;


/**
 * 支付业务
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderPayBiz {

    private final PayDispatcher payDispatcher;

    private final PayTransactionService payTransactionService;

    private final PayAllocationService payAllocationService;

    private final PayLedgersService payLedgersService;

    private final IdGenerator idGenerator = new SimpleIdGenerator();

    public Response toPay(PayTransactionForm payTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayTransactionBo payTransactionBo = BeanUtil.copyProperties(payTransactionForm, PayTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_ORDER_PAY.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payTransactionForm);
        // 填充参数openid
        orderPayRequest.setSubOpenid(payTransactionForm.getSubOpenid());
        // 请求分发
        Response<PayResponse> response = null;
        try {
            response = payDispatcher.dispatcher(orderPayRequest);
        } catch (Exception e) {
            return Response.fail(e.getMessage());
        }
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response toPayNoAcc(PayTransactionForm payTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayTransactionBo payTransactionBo = BeanUtil.copyProperties(payTransactionForm, PayTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_ORDER_PAY_NoAcc.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payTransactionForm);
        // 填充参数openid
        orderPayRequest.setSubOpenid(payTransactionForm.getSubOpenid());
        // 请求分发
        Response<PayResponse> response = null;
        try {
            response = payDispatcher.dispatcher(orderPayRequest);
        } catch (Exception e) {
            return Response.fail(e.getMessage());
        }
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response toCombinePay(PayCombineTransactionForm payCombineTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayCombineTransactionBo payCombineTransactionBo = BeanUtil.copyProperties(payCombineTransactionForm, PayCombineTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_COMBINE_ORDER_PAY.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payCombineTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payCombineTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response queryOrder(PayPartnerTransactionsQueryForm payPartnerTransactionsQueryForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayPartnerTransactionsQueryBo payPartnerTransactionsQueryBo = BeanUtil.copyProperties(payPartnerTransactionsQueryForm, PayPartnerTransactionsQueryBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_QUERY_ORDER.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payPartnerTransactionsQueryBo);
        // 填充公共参数
        orderPayRequest.autoSet(payPartnerTransactionsQueryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    public Response queryCombineOrder(PayCombineTransactionForm payCombineTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayCombineTransactionBo payCombineTransactionBo = BeanUtil.copyProperties(payCombineTransactionForm, PayCombineTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_COMBINE_QUERY_ORDER.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payCombineTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payCombineTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    public Response closeOrder(PayPartnerTransactionsQueryForm payPartnerTransactionsQueryForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayPartnerTransactionsQueryBo payPartnerTransactionsQueryBo = BeanUtil.copyProperties(payPartnerTransactionsQueryForm, PayPartnerTransactionsQueryBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_CLOSE_ORDER.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payPartnerTransactionsQueryBo);
        // 填充公共参数
        orderPayRequest.autoSet(payPartnerTransactionsQueryForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    public Response closeCombineOrder(PayCombineTransactionForm payCombineTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayCombineTransactionBo payCombineTransactionBo = BeanUtil.copyProperties(payCombineTransactionForm, PayCombineTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_COMBINE_CLOSE_ORDER.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payCombineTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payCombineTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    public Response refunds(PayRefundsTransactionForm payRefundsTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayRefundsTransactionBo payRefundsTransactionBo = BeanUtil.copyProperties(payRefundsTransactionForm, PayRefundsTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_REFUNDS_ORDER.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payRefundsTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payRefundsTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }

    public Response queryRefundByRefundId(PayRefundsTransactionForm payRefundsTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PayRefundsTransactionBo payRefundsTransactionBo = BeanUtil.copyProperties(payRefundsTransactionForm, PayRefundsTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_REFUNDS_QUERY_ORDER.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(payRefundsTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(payRefundsTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response subWithdraw(PaySubWithDrawTransactionForm paySubWithDrawTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PaySubWithDrawTransactionBo paySubWithDrawTransactionBo = BeanUtil.copyProperties(paySubWithDrawTransactionForm, PaySubWithDrawTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_SUB_WITHDRAW_APPLY.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(paySubWithDrawTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(paySubWithDrawTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response querySubWithdrawByOutRequestNo(PaySubWithDrawTransactionForm paySubWithDrawTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PaySubWithDrawTransactionBo paySubWithDrawTransactionBo = BeanUtil.copyProperties(paySubWithDrawTransactionForm, PaySubWithDrawTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_SUB_WITHDRAW_QUERY_APPLY.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(paySubWithDrawTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(paySubWithDrawTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response spWithdraw(PaySpWithDrawTransactionForm paySpWithDrawTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PaySpWithDrawTransactionBo paySpWithDrawTransactionBo = BeanUtil.copyProperties(paySpWithDrawTransactionForm, PaySpWithDrawTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_SP_WITHDRAW_APPLY.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(paySpWithDrawTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(paySpWithDrawTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    public Response querySpWithdrawByOutRequestNo(PaySpWithDrawTransactionForm paySpWithDrawTransactionForm) {
        OrderPayRequest orderPayRequest = new OrderPayRequest();
        PaySpWithDrawTransactionBo paySpWithDrawTransactionBo = BeanUtil.copyProperties(paySpWithDrawTransactionForm, PaySpWithDrawTransactionBo.class);
        // 设置请求方法
        orderPayRequest.setMethod(PayMethods.TRADE_SP_WITHDRAW_QUERY_APPLY.getNamespace());
        // 设置业务参数对象bizModel
        orderPayRequest.setBizModel(paySpWithDrawTransactionBo);
        // 填充公共参数
        orderPayRequest.autoSet(paySpWithDrawTransactionForm);
        // 请求分发
        Response<PayResponse> response = payDispatcher.dispatcher(orderPayRequest);
        PayResponse data = response.getData();
        log.info("返回结果:{}", data);
        return response;
    }
    @EventListener(value = {OrderPaySuccessEvent.class})
    public String onPaySuccessEvent(OrderPaySuccessEvent orderPaySuccessEvent) {
        doOrderAllocation(orderPaySuccessEvent);
        return null;
    }


    private void doOrderAllocation(OrderPaySuccessEvent orderPaySuccessEvent) {
        // if 成功 3
        /*PayTransaction updatePayTransaction = new PayTransaction();
        updatePayTransaction.setStatus(3);
        //if 失败4
        updatePayTransaction.setStatus(4);
        payTransactionService.updateById(updatePayTransaction);*/
        // todo 修改订单状态（该事件需要解耦通知其他域），在前一步做了
        // todo 插入预分账记录，
        //查询分账账本
        LambdaQueryChainWrapper<PayLedgers> payTransactionWrapper = payLedgersService.lambdaQuery()
                .eq(PayLedgers::getAppId, null)//appId 从哪里来
                .eq(PayLedgers::getState,0)
                .eq(PayLedgers::getDeleted,false);
        List<PayLedgers> payLedgersList = payLedgersService.list(payTransactionWrapper);
        if(CollectionUtil.isNotEmpty(payLedgersList)){
            List<PayAllocation> payAllocations = BeanUtil.copyProperties(payLedgersList, List.class);
            for(PayAllocation payAllocation : payAllocations){
                payAllocation.setPayOrderId(orderPaySuccessEvent.getOrderId());
                payAllocation.setAllotId(idGenerator.generateId().toString());
            }
        /*PayAllocation payAllocation = PayAllocation.builder()
                .build();*/
            payAllocationService.saveBatch(payAllocations);
            // todo 根据当前支付（orderId:分账时间[支付成功时间+holdingTime]） 推送到队列(顺序规则，批量规则，定时规则) 设置并启动该比支付的分账定时任务
            // todo 计算分账任务执行时间 订单号 + 通道 + 分账时间[paySuccessTime+holdingTime ]
        }

    }
}
