package org.dows.sdk.weixin.cloudbase.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @description
 * @date
 */
@Data
@NoArgsConstructor
public class UpdateDatabaseRecordResponse {
    @Schema(title = "错误码")
    private Number errcode;

    @Schema(title = "错误信息")
    private String errmsg;

    @Schema(title = "更新条件匹配到的结果数")
    private Number matched;

    @Schema(title = "修改的记录数，注意：使用set操作新插入的数据不计入修改数目")
    private Number modified;

    @Schema(title = "新插入记录的id，注意：只有使用set操作新插入数据时这个字段会有值")
    private String id;


}
