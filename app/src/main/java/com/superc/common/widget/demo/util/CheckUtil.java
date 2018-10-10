package com.superc.common.widget.demo.util;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CheckUtil {

    public static <T> boolean checkNull(T t) {
        return t == null;
    }

    public static <T> T checkNull(T t, String msg) {
        if (t == null) {
            throw new NullPointerException(msg);
        }
        return t;
    }

    public static boolean checkContextNull(Context context) {
        return null == context || (context instanceof Activity && ((Activity) context).isFinishing());
    }

    /**
     * 检测List是否为空和其长度是否为0
     */
    public static <T> boolean checkListIsEmpty(List<T> l) {
        return l == null || l.isEmpty();
    }

    public static <T> boolean checkArrayIsEmpty(T... ts) {
        return ts == null || ts.length == 0;
    }

    public static <T> boolean checkSpareArrayIsEmpty(SparseArray<T> array) {
        return array == null || array.size() == 0;
    }

    public static <T> boolean checkStackIsEmpty(Stack<T> stack) {
        return null == stack || stack.size() == 0;
    }

    public static <K, V> boolean checkMapIsEmpty(Map<K, V> map) {
        return null == map || map.isEmpty();
    }

    public static boolean checkFileExits(String filePath) {
        return !StringUtil.isNull(filePath) && checkFileExits(new File(filePath));
    }

    public static boolean checkFileExits(File file) {
        return null != file && file.exists();
    }
}
