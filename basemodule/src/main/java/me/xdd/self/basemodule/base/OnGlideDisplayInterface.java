package me.xdd.self.basemodule.base;

import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * glide图片加载管理
 */
public interface OnGlideDisplayInterface {
    /**
     * 显示普通图片
     * @param imageView  要显示的图片
     * @param url        图片url
     */
    void displayNormalImage(ImageView imageView, String url, int errorImg, int placeImg, int fallbackImg);

    /**
     * 显示本地图片
     * @param imageView  要显示的图片
     * @param file       本地图片文件名
     */
    void displayLocalImage(ImageView imageView, File file, int errorImg, int placeImg, int fallbackImg);

    /**
     * 显示 本地资源图片
     * @param imageView
     * @param resource
     */
    void displayResourceImage(ImageView imageView, int resource, int errorImg, int placeImg, int fallbackImg);

    /**
     * 显示 bytes[]
     * @param imageView
     * @param bytes
     */
    void displayByteImage(ImageView imageView, byte[] bytes, int errorImg, int placeImg, int fallbackImg);

    /**
     * 显示 uri
     * @param imageView
     * @param uri
     */
    void displayUriImage(ImageView imageView, Uri uri, int errorImg, int placeImg, int fallbackImg);
}
