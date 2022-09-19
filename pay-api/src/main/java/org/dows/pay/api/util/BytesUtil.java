package org.dows.pay.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Description：
 * @Author：sacher
 * @Create：2022/8/29 11:27 PM
 **/
public class BytesUtil {
    private static final int EOF = -1, BUF_LENGTH = 8192;

    public static void close(final AutoCloseable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception ioe) {
            throw new RuntimeException("close stream error: ", ioe);
        }
    }

    private static String string(final InputStream input, final Charset charset) {
        final StringWriter sw = new StringWriter();
        final InputStreamReader in = new InputStreamReader(input, charset);
        try {
            copyLarge(in, sw, new char[BUF_LENGTH]);
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException("input to string error", e);
        } finally {
            close(in);
            close(sw);
        }
    }
    private static void copyLarge(final Reader input, final Writer output, final char[] buffer) throws IOException {
        int n; while (EOF != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
    }

    public static String string(final InputStream input){
        return string(input, StandardCharsets.UTF_8);
    }

}
