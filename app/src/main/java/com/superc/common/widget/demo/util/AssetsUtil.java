package com.superc.common.widget.demo.util;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.superc.common.widget.demo.application.MyApplication;

import java.io.IOException;
import java.io.InputStream;

public class AssetsUtil {
    private Object IOException;

    //    *     * 从Assets中读取图片     */    
    public static Bitmap getImageFromAssetsFile(String fileName) {
        Bitmap image = null;
        AssetManager am = MyApplication.getContext().getResources().getAssets();
        try {
            InputStream is = null;
            is = am.open(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
