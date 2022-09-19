package org.dows.pay.api.util;

import cn.hutool.core.util.StrUtil;

import java.util.function.Supplier;

/**
 * @Description：
 * @Author：sacher
 * @Create：2022/8/29 11:30 PM
 **/
public class JvmOSUtil {

    private static volatile String PROJECT_DIR;

    private static String ofValue(String rs, Supplier<String> supplier) {
        if (StrUtil.isBlank(rs)) {
            rs = supplier.get();
        }
        return rs;
    }

    /**
     * 获取工程所在目录
     **/
    public static String projectDir() {
        return ofValue(PROJECT_DIR, () -> System.getProperty("user.dir"));
    }
}
