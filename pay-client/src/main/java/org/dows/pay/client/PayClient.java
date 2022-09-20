package org.dows.pay.client;

import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;

public interface PayClient {

    <T extends PayResponse> T execute(PayRequest<T> var1);

}
