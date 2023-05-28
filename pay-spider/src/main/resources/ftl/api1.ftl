package ${pkg!""};

/**
 * @description ${descr!""}
 * @author ${author!"lait.zhang@gmail.com"}
 * @date  ${date!.now}
 */
public interface ${name?cap_first!""}{
<#list methods as method>

    /**
     * ${method.descr!""}
     * ${method.weixinUrl!""}
     * <#list method.inputs as input>
     * @param ${input.name!""}
     * </#list>
     */
    ${method.output.name?cap_first!""} ${method.name!""}(<#list method.inputs as input>${input.type!""} ${input.name!""}</#list>);
</#list>
}