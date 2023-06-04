package org.dows.sdk.client.core;

import lombok.Data;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Data
public class UriSchema {
    private String orgUri;
    private String method;
    private String url;

    /**
     * https://api.weixin.qq.com/wxa/operationams?action=agency_set_mp_amscategory_blacklist&access_token=ACCESS_TOKEN
     * todo 考虑支持更多协议如 ws://
     *
     * @param orgUri
     */
    private UriSchema(String orgUri) {
        this.orgUri = orgUri.toLowerCase();
        // http协议
        if (this.isPost() || this.isGet() || this.isPut() || this.isDelete()) {
            String[] split1 = orgUri.split(" ");
            if (split1.length != 2) {
                this.orgUri = orgUri;
                this.url = orgUri;
                this.method = "post";
            }
            if (orgUri.contains("ACCESS_TOKEN")) {
                this.url = split1[1].replace("ACCESS_TOKEN", ApiAccessTokenContext.getToken());
            } else {
                this.url = split1[1];
            }
            this.method = split1[0];
            ApiAccessTokenContext.removeToken();
            // sql协议
        } else if (this.isSelect() || this.isInsert() || this.isUpdate() || this.isSqlDelete()) {

        }
    }

    public static UriSchema of(String orgUri) {
        return new UriSchema(orgUri);
    }

    /**
     * 对参数进行url编码
     *
     * @param string 待编码的字符串
     * @return 编码后的字符串
     */
    public static String urlEncode(String string) {
        try {
            return URLEncoder.encode(string, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isPost() {
        if (orgUri.startsWith("post ") || orgUri.contains("http")) {
            return true;
        }

        return false;
    }

    public boolean isGet() {
        if (orgUri.startsWith("get ") || orgUri.contains("http")) {
            return true;
        }
        return false;
    }

    public boolean isPut() {
        if (orgUri.startsWith("put ") || orgUri.contains("http")) {
            return true;
        }
        return false;
    }

    public boolean isDelete() {
        if (orgUri.startsWith("delete ") || orgUri.contains("http")) {
            return true;
        }
        return false;
    }

    ////////////////sql///////////////////
    public boolean isSelect() {
        if (orgUri.startsWith("select ") || orgUri.contains("select ")) {
            return true;
        }
        return false;
    }

    public boolean isInsert() {
        if (orgUri.startsWith("insert ") || orgUri.contains("insert ")) {
            return true;
        }
        return false;
    }

    public boolean isUpdate() {
        if (orgUri.startsWith("update ") || orgUri.contains("update ")) {
            return true;
        }
        return false;
    }

    public boolean isSqlDelete() {
        if (orgUri.startsWith("delete ") || orgUri.contains("delete ")) {
            return true;
        }
        return false;
    }


}
