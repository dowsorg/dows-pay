dows:
  sdk:
    weixin:
<#list beanSchemas as bs>
    <#list methods as method>
      "${bs.pkg!""}${bs.name?cap_first!""}.${method.name?uncap_first!""}": ${method.url!""}
    </#list>
</#list>
      "org.dows.sdk.weixin.ams.AdBlackApi.setAmsCategoryBlackList": POST https://api.weixin.qq.com/tcb/wxpayopenauth?access_token=${rt*access_token}