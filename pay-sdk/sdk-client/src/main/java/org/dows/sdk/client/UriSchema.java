package org.dows.sdk.client;

import lombok.Data;

@Data
public class UriSchema {
    private String orgUri;
    private String method;
    private String url;

    public static UriSchema of(String orgUri) {
        return new UriSchema(orgUri);
    }

    /**
     * https://api.weixin.qq.com/wxa/operationams?action=agency_set_mp_amscategory_blacklist&access_token=ACCESS_TOKEN
     *
     * @param orgUri
     */
    private UriSchema(String orgUri) {
        this.orgUri = orgUri;
        String[] split1 = orgUri.split(" ");
        this.method = split1[0];
        this.url = split1[1].replace("ACCESS_TOKEN", AccessTokenContext.getToken());
        AccessTokenContext.removeToken();
    }

    public boolean isPost() {
        if (orgUri.startsWith("post ") || orgUri.startsWith("POST ")) {
            return true;
        }
        return false;
    }

    public boolean isGet() {
        if (orgUri.startsWith("get ") || orgUri.startsWith("GET ")) {
            return true;
        }
        return false;
    }


    public boolean isPut() {
        if (orgUri.startsWith("put ") || orgUri.startsWith("PUT ")) {
            return true;
        }
        return false;
    }


    public boolean isDelete() {
        if (orgUri.startsWith("delete ") || orgUri.startsWith("DELETE ")) {
            return true;
        }
        return false;
    }


}
