package me.xdd.self.basemodule.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author xuandong on 2019/5/16
 */
public class StatusBarUtils {
    /**
     * 21 5.0以上配置通知栏
     *
     * @return
     */
    private static boolean isVersionCodeMoreThan21() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * 19  4.4
     * @return
     */
    private static boolean isVersionCodeMoreThan19() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    /**
     * 23 6.0
     * @return
     */
    private static boolean isVersionCodeMoreThan23(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * 设置状态栏颜色为透明
     * @param activity
     */
    private static void setTranslateStatus(Activity activity){
        if (isVersionCodeMoreThan21()){
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (isVersionCodeMoreThan19()){
            Window window = activity.getWindow();
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }


    /**
     * 修改状态栏颜色，支持4.4 以上版本  半透明 0x04000000
     * @param activity
     * @param colorId
     */
    private static void setStatusBarColor(Activity activity,int colorId){
        if (colorId == 0){
            return;
        }
        if (isVersionCodeMoreThan21()){
            Window window = activity.getWindow();
            window.setStatusBarColor(activity.getResources().getColor(colorId));
        }else if (isVersionCodeMoreThan19()){
            colorId = ContextCompat.getColor(activity,colorId);
            StatusBarCompat.setStatusBarColor(activity,colorId);
        }
    }

    /**
     * 设置状态栏的模式，包括 背景颜色，文字颜色
     * @param activity  上下文
     * @param isTranslate 是否背景改成全透明
     * @param isBlack   是否显示 黑色文字   默认 白色
     * @param colorId   状态栏 背景颜色
     */
    public static void setStatusBarMode(Activity activity,boolean isTranslate,boolean isBlack,int colorId){

        if (isTranslate){
            setTranslateStatus(activity);
        }else{
            setStatusBarColor(activity,colorId);
        }

        if (isBlack) {
            //4.4 以上才能修改状态栏颜色
           if (isVersionCodeMoreThan19()){
               if(OSUtils.isMIUI()) {
                   //小米MIUI系统
                   setMIUIStatusBarTextMode(activity, isBlack);
               } else if(OSUtils.isFlyme()) {
                   //魅族flyme系统
                   setFlymeStatusBarTextMode(activity, isBlack);
               } else if(isVersionCodeMoreThan23()) {
                   //6.0以上，调用系统方法
                   Window window = activity.getWindow();
                   window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                   window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                   window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
               } else {
                   //4.4以上6.0以下的其他系统，暂时没有修改状态栏的文字图标颜色的方法，有可以加上
               }
           }
        }
    }

    /**
     * 设置Flyme系统状态栏的文字图标颜色
     * @param activity
     * @param isDark 状态栏文字及图标是否为深色
     * @return
     */
    private static boolean setFlymeStatusBarTextMode(Activity activity, boolean isDark) {
        Window window = activity.getWindow();
        boolean result = false;
        if (window != null) {
            try {
                WindowManager.LayoutParams lp = window.getAttributes();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField("meizuFlags");
                darkFlag.setAccessible(true);
                meizuFlags.setAccessible(true);
                int bit = darkFlag.getInt(null);
                int value = meizuFlags.getInt(lp);
                if (isDark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt(lp, value);
                window.setAttributes(lp);
                result = true;
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 设置MIUI系统状态栏的文字图标颜色（MIUIV6以上）
     * @param activity
     * @param isDark 状态栏文字及图标是否为深色
     * @return
     */
    private static boolean setMIUIStatusBarTextMode(Activity activity, boolean isDark) {
        boolean result = false;
        Window window = activity.getWindow();
        if (window != null) {
            Class clazz = window.getClass();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt(layoutParams);
                Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
                if (isDark) {
                    extraFlagField.invoke(window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke(window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
                    if (isDark) {
                        activity.getWindow().getDecorView().setSystemUiVisibility(View
                                .SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View
                                .SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    } else {
                        activity.getWindow().getDecorView().setSystemUiVisibility(View
                                .SYSTEM_UI_FLAG_VISIBLE);
                    }
                }
            } catch (Exception e) {

            }
        }
        return result;
    }


}
