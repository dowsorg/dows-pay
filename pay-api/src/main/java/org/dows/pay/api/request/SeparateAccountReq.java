package org.dows.pay.api.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class SeparateAccountReq implements Serializable {

    private String appid;

    private String transaction_id;

    private String out_order_no;

    private Boolean unfreeze_unsplit;
    private Boolean finish;

    private String sub_mchid;

    private List<Receivers> receivers;




    @Data
    @Builder
    public static class Receivers{
        private String type;

        private String account;

        private String name;

        private Integer amount;

        private String description;
    }
}
