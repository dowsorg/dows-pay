package org.dows.sdk.client;

import lombok.extern.slf4j.Slf4j;
import org.dows.sdk.weixin.ams.AdBlackApi;
import org.dows.sdk.weixin.ams.request.GetBlackListRequest;
import org.dows.sdk.weixin.ams.request.SetAmsCategoryBlackListRequest;
import org.dows.sdk.weixin.ams.response.GetBlackListResponse;
import org.dows.sdk.weixin.ams.response.SetAmsCategoryBlackListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ClinetTest {

    @Autowired
    private AdBlackApi adBlackApi;

    @Test
    public void testInit() {
//        GetBlackListRequest getBlackListRequest = new GetBlackListRequest();
//
//        GetBlackListResponse blackList = adBlackApi.getBlackList(getBlackListRequest);


        SetAmsCategoryBlackListRequest setAmsCategoryBlackListRequest = new SetAmsCategoryBlackListRequest();
        setAmsCategoryBlackListRequest.setAms_category("dddd");

        SetAmsCategoryBlackListResponse setAmsCategoryBlackListResponse = adBlackApi.setAmsCategoryBlackList(setAmsCategoryBlackListRequest);

        log.info("");
    }

}
