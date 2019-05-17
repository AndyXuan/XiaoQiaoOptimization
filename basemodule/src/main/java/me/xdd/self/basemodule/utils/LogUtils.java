package me.xdd.self.basemodule.utils;

import android.util.Log;

/**
 * Created by 2017JuFan-Android on 2018/1/18.
 */

public class LogUtils {
    public static  boolean DEBUG = true;

    /**
     * 打印debug
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg){
        if (DEBUG){
            Log.d("-LogUtils--"+tag+"-->","-------------begin----------------\n");
            Log.d("-LogUtilsBody->",msg);
            Log.d("-LogUtils--"+tag+"-->","----------------end----------------\n");
        }
    }

    /**
     * 打印error
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg){
        if (DEBUG){
            Log.e("-LogUtils--"+tag+"-->","-------------begin----------------\n");
            Log.e(tag+"-LogUtilsBody->",msg);
            Log.e("-LogUtils--"+tag+"-->","----------------end----------------\n");
        }
    }
}
