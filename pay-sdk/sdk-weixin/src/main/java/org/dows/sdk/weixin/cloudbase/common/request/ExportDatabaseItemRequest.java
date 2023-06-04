package org.dows.sdk.weixin.cloudbase.common.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description 
*
* @author 
* @date 
*/
@Data
@NoArgsConstructor
public class ExportDatabaseItemRequest{
    @Schema(title = "接口调用凭证，该参数为 URL 参数，非 Body 参数。使用")
    private String access_token;
    @Schema(title = "云环境ID")
    private String env;
    @Schema(title = "导出文件路径（文件会导出到公共的云存储中，可使用getDownloadTcbFileLink接口获取下载链接）")
    private String file_path;
    @Schema(title = "导出文件类型，文件格式参考importDatabaseItem接口的文件格式部分")
    private Integer file_type;
    @Schema(title = "导出条件")
    private String query;

}
