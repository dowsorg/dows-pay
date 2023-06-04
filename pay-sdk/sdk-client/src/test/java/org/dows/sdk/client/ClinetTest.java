package org.dows.sdk.client;

import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.client.core.ApiAccessTokenContext;
import org.dows.sdk.weixin.bak.ams.AdBlackApi;
import org.dows.sdk.weixin.open.dsfptdypz.DiSanFangPingTaiDiaoYongPingZhengApi;
import org.dows.sdk.weixin.open.dsfptdypz.request.HuoQuLingPaiRequest;
import org.dows.sdk.weixin.open.dsfptdypz.response.HuoQuLingPaiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ClinetTest {

    @Autowired(required = false)
    private AdBlackApi adBlackApi;

    @Autowired
    private DiSanFangPingTaiDiaoYongPingZhengApi diSanFangPingTaiDiaoYongPingZhengApi;

    @Test
    public void testInit() {
//        GetBlackListRequest getBlackListRequest = new GetBlackListRequest();
//
//        GetBlackListResponse blackList = adBlackApi.getBlackList(getBlackListRequest);


        ApiAccessTokenContext.addToken("sss");

        HuoQuLingPaiRequest huoQuLingPaiRequest = new HuoQuLingPaiRequest();
        huoQuLingPaiRequest.setComponent_appid("dxz");
        HuoQuLingPaiResponse huoQuLingPaiResponse = diSanFangPingTaiDiaoYongPingZhengApi.huoQuLingPai(huoQuLingPaiRequest);

        log.info("huoQuLingPaiResponse:{}", huoQuLingPaiResponse);
//        SetAmsCategoryBlackListRequest setAmsCategoryBlackListRequest = new SetAmsCategoryBlackListRequest();
//        setAmsCategoryBlackListRequest.setAms_category("dddd");
//
//        SetAmsCategoryBlackListResponse setAmsCategoryBlackListResponse = adBlackApi.setAmsCategoryBlackList(setAmsCategoryBlackListRequest);
//
//        log.info("setAmsCategoryBlackListResponse:{}", setAmsCategoryBlackListResponse);
    }

}
