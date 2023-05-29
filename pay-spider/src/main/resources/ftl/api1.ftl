package ${pkg!""};

/**
 * @description ${descr!""}
 * @author ${author!"lait.zhang@gmail.com"}
 * @date  ${date!.now}
 */
public interface ${name?cap_first!""}{
<#list methods as method>

    /**
     * description: ${method.descr!""}
     * doc: ${method.docUrl!""}
     * api: ${method.weixinUrl!""}
     * <#list method.inputs as input>
     * @param ${(input.name!"")?uncap_first}
     * </#list>
     */
    ${method.output.name?cap_first!""} ${(method.name!"")?uncap_first}(<#list method.inputs as input>${(input.type!"")?cap_first} ${(input.name!"")?uncap_first}</#list>);
</#list>
}