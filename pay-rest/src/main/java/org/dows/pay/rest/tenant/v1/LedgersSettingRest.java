package org.dows.pay.rest.tenant.v1;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dows.framework.api.Response;
import org.dows.pay.biz.LedgersSettingBiz;
import org.dows.pay.form.PayLedgersForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商户账本分帐配置")
@RestController
@RequestMapping(value = "/v1")
@Slf4j
@RequiredArgsConstructor
public class LedgersSettingRest {

    private final LedgersSettingBiz ledgersSettingBiz;

    /**
     * 分账设置
     *
     * @return
     */
    @PostMapping("/ledgerSetting")
    public Response ledgersSetting(@RequestBody PayLedgersForm payLedgersForm) {
        /**
         * 解析参数
         */
        //JSONObject requestParam = HttpRequestUtils.getRequestParam(httpServletRequest);
        // 设置分配
        ledgersSettingBiz.allotSetting(payLedgersForm);
        return Response.ok();
    }


}
