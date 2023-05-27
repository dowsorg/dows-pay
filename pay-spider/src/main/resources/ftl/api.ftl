package ${pkg!""};

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
<#--import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;-->
<#--import io.swagger.v3.oas.annotations.media.Schema;-->
import lombok.*;

import java.util.Date;
import java.math.BigDecimal;

/**
* @description ${descr!""}
*
* @author ${author!""}
* @date ${date!""}
*/
<#if extendClass??>
@EqualsAndHashCode(callSuper = true)
</#if>
<#--@Data
@NoArgsConstructor-->
<#--@Schema(name = "${parameter.type} 对象", title = "${(parameter.descr!"")}")-->
<#--@ApiModel(value = "${parameter.type} 对象", description = "${(parameter.descr!"")}")-->
public interface ${clazz?cap_first!""}{
<#if apiSchemas?? && (apiSchemas?size >0)>
    <#list apiSchemas as api >
        <#if api??>
    /**
     * ${api.descr!""}
     * @param ${api.method?uncap_first!""}Request
     */
    ${api.method?cap_first!""}Response ${api.method?uncap_first!""}(${api.method?cap_first!""}Request ${api.method?uncap_first!""}Request);
        </#if>
    </#list>

</#if>
}
