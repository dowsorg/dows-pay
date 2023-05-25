package org.dows.pay.weixin.mp;

import com.google.common.cache.CacheBuilder;
import org.dows.pay.weixin.mp.base.AppSetting;
import org.dows.pay.weixin.mp.base.WxEndpoint;

import java.util.concurrent.ConcurrentMap;

/**
 *
 */
public class MpWxClientFactory {

    private static final ConcurrentMap<String, WxClient> wxClients = CacheBuilder.newBuilder().initialCapacity(8)
            .maximumSize(128).<String, WxClient>build().asMap();
    private static MpWxClientFactory instance = null;

    private MpWxClientFactory() {
    }

    public synchronized static MpWxClientFactory getInstance() {
        if (instance == null) {
            instance = new MpWxClientFactory();
        }
        return instance;
    }

    public WxClient defaultWxClient() {
        return with(AppSetting.defaultSettings());
    }

    public WxClient with(AppSetting appSetting) {
        if (!wxClients.containsKey(key(appSetting))) {
            String url = WxEndpoint.get("url.token.get");
            String clazz = appSetting.getTokenHolderClass();

            AccessTokenHolder accessTokenHolder = null;
            if (clazz == null || "".equals(clazz)) {
                accessTokenHolder = new DefaultAccessTokenHolder(url, appSetting.getAppId(), appSetting.getSecret());
            } else {
                try {
                    accessTokenHolder = (AccessTokenHolder) Class.forName(clazz).newInstance();
                    accessTokenHolder.setClientId(appSetting.getAppId());
                    accessTokenHolder.setClientSecret(appSetting.getSecret());
                    accessTokenHolder.setTokenUrl(url);
                } catch (Exception e) {
                    accessTokenHolder = new DefaultAccessTokenHolder(url, appSetting.getAppId(), appSetting.getSecret());
                }
            }

            WxClient wxClient = new WxClient(appSetting.getAppId(), appSetting.getSecret(), accessTokenHolder);
            wxClients.putIfAbsent(key(appSetting), wxClient);
        }

        return wxClients.get(key(appSetting));
    }

    private String key(AppSetting appSetting) {
        return appSetting.getAppId() + ":" + appSetting.getSecret();
    }
}

