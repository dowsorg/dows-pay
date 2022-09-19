package org.dows.pay.api;

public interface PayClient {

    <T extends PayResponse> T execute(PayRequest<T> var1);

}
