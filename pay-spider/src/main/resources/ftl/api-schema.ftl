dows:
  sdk:
    weixin:
      api-beans:
        <#list beanSchemas as bean>
        - module: ${bean.module.name!""}
          pkg: ${bean.pkg!""}
          name: ${bean.name!""}
          descr: ${bean.descr!""}
          methods:
            <#list bean.methods as method>
            - name: ${method.name!""}
              overview: ${method.overview!""}
              descr: ${method.descr!""}
              docUrl: ${method.docUrl!""}
              url: ${method.url!""}
              httpMethod: ${method.httpMethod!""}
            </#list>
        </#list>
