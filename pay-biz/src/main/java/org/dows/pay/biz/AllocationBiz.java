package org.dows.pay.biz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.pay.gateway.PayDispatcher;
import org.springframework.stereotype.Service;

/**
 * 分账业务
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class AllocationBiz {

    private final PayDispatcher payDispatcher;

}
