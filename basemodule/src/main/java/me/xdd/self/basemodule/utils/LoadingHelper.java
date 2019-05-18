package me.xdd.self.basemodule.utils;

import android.content.Context;

import me.xdd.self.basemodule.R;
import me.xdd.self.basemodule.base.BaseActivity;
import xiaoqiao.qiaorong.com.uimodule.tdialog.TDialog;


public class LoadingHelper {
    private static LoadingHelper instance = null;

    private LoadingHelper() {
    }

    public static LoadingHelper getInstance() {
        if (instance == null) {
            synchronized (LoadingHelper.class) {
                if (instance == null) {
                    instance = new LoadingHelper();
                }
            }
        }
        return instance;
    }




    private TDialog dialog = null;
    private boolean isCancelable = true;

    public boolean isCancelable() {
        return isCancelable;
    }

    public TDialog showLoading(Context context) {

        return returnShowLoading((BaseActivity) context,true);
    }

    public TDialog showLoading(Context context, boolean isCancelable) {
        this.isCancelable = isCancelable;
        return returnShowLoading((BaseActivity) context,isCancelable);
    }

    private TDialog returnShowLoading(BaseActivity activity, boolean isCancelable){
        try {
            if (dialog ==null){
                dialog = new TDialog.Builder(activity.getSupportFragmentManager())
                        .setLayoutRes(R.layout.dialog_loading)
                        .setHeight(300)
                        .setWidth(300)
                        .setDimAmount(0.7f)
                        .setCancelableOutside(isCancelable)
                        .create()
                        .show();
            }
        }catch (Exception e){

        }
        return dialog;
    }




    public TDialog cancelLoading() {
        try {
            isCancelable = true;
            if (dialog != null && dialog.isDetached()) {
                dialog.dismiss();
            }
            dialog = null;

        }catch (Exception e){
            dialog = null;

        }
        return dialog;
    }
}
