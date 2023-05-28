package org.dows.sdk.weixin.cloudbase.batch.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
 *
 * @description 
 * @author @author lait.zhang@gmail.com
 * @date 2023年5月28日 下午9:55:33
 */
@Data
@Schema(name = "DbindexManageRequest", title = "DbindexManageRequest")
public class DbindexManageRequest{
    @Schema(title = "")
    private String access_token;
    @Schema(title = "create")
    private String action;
    @Schema(title = "环境ID")
    private String env;
    @Schema(title = "集合名称")
    private String collection_name;
    @Schema(title = "索引信息")
    private List<Object> indexes;
}

