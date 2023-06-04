package org.dows.sdk.client.core;

import lombok.Data;

@Data
public class ApiAccessTokenContext {

    private static ThreadLocal<String> TOKEN = new ThreadLocal<>();

    public static void addToken(String token) {
        TOKEN.set(token);
    }

    public static String getToken() {
        return TOKEN.get();
    }

    public static void removeToken() {
        TOKEN.remove();
    }


}
