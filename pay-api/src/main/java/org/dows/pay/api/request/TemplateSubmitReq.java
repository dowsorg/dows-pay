package org.dows.pay.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TemplateSubmitReq implements Serializable {

    private String address;
    private String tag;
    private String first_class;
    private String second_class;
    private Integer first_id;
    private Integer second_id;
    private String title;
}
