package com.superc.common.widget.demo.util;

import android.support.annotation.StringRes;

import com.superc.common.widget.demo.application.MyApplication;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    public static boolean isNull(String text) {
        if (text == null || "null".equals(text) || text.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String text) {
        return isNull(text);
    }

    public static String formatString(@StringRes int strId, Object... args) {
        return String.format(MyApplication.getContext().getString(strId), args);
    }

    /**
     * 数组转成用逗号分开的字符串
     */
    public static String arrayToStringAsComma(String[] array) {
        StringBuilder builder = new StringBuilder();
        if (!CheckUtil.checkArrayIsEmpty(array)) {
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i]);
                if (i != array.length - 1) {
                    builder.append(",");
                }
            }
        }
        return builder.toString();
    }

    /**
     * String转成集合
     *
     * @param splitStr 分割符
     */
    public static List<String> stringToList(String content, String splitStr) {
        List<String> list = new ArrayList<>();
        if (!StringUtil.isNull(content)) {
            String[] a = content.split(splitStr);
            for (String s : a) {
                list.add(s);
            }
        }
        return list;
    }

}
