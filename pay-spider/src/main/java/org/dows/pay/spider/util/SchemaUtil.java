package org.dows.pay.spider.util;

import cn.hutool.core.util.StrUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class SchemaUtil {
    public static String getPingYin(String src) {
        char[] charArray = src.toCharArray();
        // 单个字的多个音组成的数组
        String[] multiPinYinArray;
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuilder result = new StringBuilder();
        try {
            for (char c : charArray) {
                //判断是否为汉字字符
                if (Character.toString(c).matches("[\\u4E00-\\u9FA5]+")) {
                    multiPinYinArray =
                            PinyinHelper.toHanyuPinyinStringArray(c, format);
                    String word = multiPinYinArray[0];
                    result.append(word.substring(0, 1).toUpperCase())
                            .append(word.substring(1));
                } else {
                    result.append(c);
                }
            }
            return result.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return result.toString();
    }

    // 返回中文的首字母
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    public static String filterBeanNameChar(String name) {
        if (StrUtil.isBlank(name)) {
            return "";
        }
        return name.trim().
                replaceAll(" ", "")
                .replaceAll("（", "")
                .replaceAll("）", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("-", "_")
                .replaceAll("\\.","");
    }

    public static String filterBeanPkgChar(String pkg) {
        if (StrUtil.isBlank(pkg)) {
            return "";
        }
        return pkg.trim().toLowerCase()
                .replaceAll(" ", "")
                .replaceAll("（", "")
                .replaceAll("）", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                //.replaceAll("-", "_")
                .replaceAll("/", ".")
                .replaceAll("-", ".");
    }
}
