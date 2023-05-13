package org.dows.pay.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.dows.pay.api.BizForm;
import org.dows.pay.bo.WxFastMaCategoryBo;

import java.util.List;


@ToString
@Builder
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "WxFastMaCategoryForm 表单对象", description = " 支付宝/微信添加类目")
@Data
public class WxFastMaCategoryForm implements BizForm {

    /**
     * 一级类目ID.
     */
    @ApiModelProperty("一级类目ID")
    private int first;

    /**
     * 二级类目ID.
     */
    @ApiModelProperty("二级类目ID")
    private int second;

    /**
     * 资质信息.
     */
    @ApiModelProperty("资质信息")
    private List<WxFastMaCategoryBo.Certificate> certicates;

    @Data
    public static class Certificate {
        @ApiModelProperty("key")
        private String key;
        @ApiModelProperty( "value")
        private String value;
    }

}
