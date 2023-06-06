package org.dows.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.dows.framework.crud.mybatis.MybatisCrudServiceImpl;
import org.dows.pay.mapper.PayAccountMapper;
import org.dows.pay.entity.PayAccount;
import org.dows.pay.service.PayAccountService;
import org.springframework.stereotype.Service;


/**
 * 支付通道账号(PayAccount)表服务实现类
 *
 * @author lait.zhang
 * @since 2022-09-25 09:55:42
 */
@Service("payAccountService")
public class PayAccountServiceImpl extends MybatisCrudServiceImpl<PayAccountMapper, PayAccount> implements PayAccountService {

    @Override
    public PayAccount getByMerchantNo(String merchantNo) {
        LambdaQueryWrapper<PayAccount> queryWrapper = new LambdaQueryWrapper<PayAccount>()
                .eq(PayAccount::getMerchantNo, merchantNo)
                .eq(PayAccount::getDeleted, false)
                .last(" limit 1");
        return getOne(queryWrapper);
    }
}

