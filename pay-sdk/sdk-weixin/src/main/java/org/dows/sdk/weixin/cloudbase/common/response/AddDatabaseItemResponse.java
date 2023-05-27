package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class AddDatabaseItemResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "插入成功的数据集合主键_id")
    private List<String> id_list;


}
