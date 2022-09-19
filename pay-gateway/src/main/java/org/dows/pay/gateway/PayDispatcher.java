package org.dows.pay.gateway;

import org.dows.framework.api.Response;
import org.dows.pay.api.PayRequest;
import org.dows.pay.api.PayResponse;
import org.springframework.stereotype.Service;

@Service
public class PayDispatcher {


    public Response<PayResponse> dispatcher(PayRequest payRequest) {

        //payRequest.


        return Response.ok();
    }


}
