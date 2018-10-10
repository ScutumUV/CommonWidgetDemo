package com.superc.common.widget.demo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;

import java.io.File;

/**
 * Created by SuperChen on 2018/6/29.
 * Description:图片加载工具
 */
public class GlideUtil {

    public static RequestOptions getOptions() {
        return new RequestOptions()
                .priority(Priority.HIGH)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
    }

    public static String addStandardUrl(String url) {
        if (url.contains("http") && !url.contains("jpg") && !url.contains("png") &&
                !url.contains("gif")) {
            url += ".jpg";
        }
        return url;
    }

    /**
     * 图片加载
     */
    public static void loadImg(Context context, ImageView imageView, Uri uri, RequestOptions options) {
        if (imageView == null) return;
        try {
            Glide.with(context)
                    .load(uri)
                    .apply(options)
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.e("加载图片异常：" + e.getMessage());
        }
    }

    /**
     * 加载本地图片
     */
    public static void loadBitmap(Context context, ImageView imageView, Bitmap bitmap, RequestOptions options) {
        if (CheckUtil.checkContextNull(context) || imageView == null) return;
        try {
            Glide.with(context)
                    .load(bitmap)
                    .apply(options)
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.e("加载图片异常：" + e.getMessage());
        }
    }

    /**
     * 加载本地图片
     */
    public static void loadBitmapGif(Context context, ImageView imageView, Bitmap bitmap, RequestOptions options) {
        if (CheckUtil.checkContextNull(context) || imageView == null) return;
        try {
            Glide.with(context)
                    .asGif()
                    .load(bitmap)
                    .apply(options)
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.e("加载图片异常：" + e.getMessage());
        }
    }

    /**
     * 加载图片（自定义错误图片）
     */
    public static void loadImg(Context context, ImageView imageView, String imgUrl, RequestOptions options) {
        if (CheckUtil.checkContextNull(context) || imageView == null) return;
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .apply(options)
                    .into(imageView);
        } catch (Exception e) {
            LogUtils.e("加载图片异常：" + e.getMessage());
        }
    }

    /**
     * 图片加载
     */
    public static void loadBitmap(Context context, ImageView imageView, Bitmap bitmap) {
        loadBitmap(context, imageView, bitmap, getOptions());
    }

    /**
     * 图片加载
     */
    public static void loadBitmapGif(Context context, ImageView imageView, Bitmap bitmap) {
        loadBitmapGif(context, imageView, bitmap, getOptions());
    }

    /**
     * 加载图片（自定义错误图片）
     */
    public static void loadImg(Context context, ImageView imageView, String imgUrl, int errorImgRes, int defaultImgRes) {
        loadImg(context, imageView, imgUrl, getOptions().error(errorImgRes).placeholder(defaultImgRes));
    }

    /**
     * 图片加载
     */
    public static void loadImg(Context context, ImageView imageView, String imgUrl) {
        loadImg(context, imageView, imgUrl, getOptions());
    }

    /**
     * 加载头像（自定义错误图片）
     */
    public static void loadPortrait(Context context, ImageView imageView, String imgUrl) {
        loadImg(context, imageView, imgUrl, getOptions());
    }

    /**
     * 图片加载
     */
    public static void loadImgCenterCrop(Context context, ImageView imageView, String imgUrl) {
        loadImg(context, imageView, imgUrl, getOptions().centerCrop());
    }

    /**
     * 加载图片（自定义错误图片）
     */
    public static void loadImgNoCache(Context context, ImageView imageView, String imgUrl) {
        loadImg(context, imageView, imgUrl, getOptions().skipMemoryCache(true).
                diskCacheStrategy(DiskCacheStrategy.NONE));
    }

    /**
     * 下载
     */
    public static <Y extends Target<File>> void downloadOnly(Context context, String imgUrl, Y target) {
        if (null == context) return;
        Glide.with(context)
                .asFile()
                .load(imgUrl)
                .into(target);
    }

    /**
     * 下载
     */
    public static <Y extends Target<Bitmap>> void bitmapOnly(Context context, String imgUrl, Y target) {
        if (null == context) return;
        Glide.with(context)
                .asBitmap()
                .load(imgUrl)
                .into(target);
    }

}
