package org.dows.pay.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.dows.framework.crud.mybatis.MybatisCrudMapper;
import org.dows.pay.entity.PayLedgersRecord;

@Mapper
public interface PayLedgersRecordMapper extends MybatisCrudMapper<PayLedgersRecord> {
}
