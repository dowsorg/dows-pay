package ${pkg!""};

/**
 * ${name!""}
 * @descr ${descr!""}
 * @author ${author!"lait.zhang@gmail.com"}
 * @date  ${date!.now}
 */
public interface ${code?cap_first!""}{
<#list methods as method>

    /**
     * ${method.name!""}
     * descr: ${method.descr!""}
     * doc: ${method.docUrl!""}
     * api: ${method.weixinUrl!""}
     * <#list method.inputs as input>
     * @param ${(input.code!"")?uncap_first}
     * </#list>
     */
    ${method.output.code?cap_first!""} ${(method.code!"")?uncap_first}(<#list method.inputs as input>${(input.type!"")?cap_first} ${(input.code!"")?uncap_first}</#list>);
</#list>
}