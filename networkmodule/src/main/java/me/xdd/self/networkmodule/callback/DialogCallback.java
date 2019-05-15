package me.xdd.self.networkmodule.callback;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;

import com.lzy.okgo.request.base.Request;

/**
 * @author xuandong on 2019/5/15
 */
public abstract class DialogCallback<T> extends JsonCallback<T> {

    private ProgressDialog dialog;
    private Context context;
    private boolean showDialog = false;

    /**
     * 初始化dialog
     *
     * @param activity   上下文
     * @param showDialog 是否显示dialog
     */
    private void initDialog(Context activity, boolean showDialog) {
        this.showDialog = showDialog;
        if (showDialog) {
            dialog = new ProgressDialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCanceledOnTouchOutside(false);
            //可以自定义进度条样式
            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            // 可以自定义进度条的颜色
           // dialog.setIndeterminateDrawable(ContextCompat.getDrawable(activity));
            dialog.setMessage("请求网络中...");
        }

    }

    public DialogCallback(Context activity, boolean showDialog) {
        super();
        this.context = activity;
        initDialog(activity, showDialog);
    }


    /**
     * 头部信息添加、更改、删除等操作
     * 一些公共体都可以放在这里。
     * 和后台定义好后在这里进行传递
     * 例子：这里的四个 就是和后台定义好在每个 接口的头部都要带着些数据，所以就在这里添加了
     * <p>
     * <p>
     * 每个项目的头部都是不同的，根据 需求自行添加
     *
     * @param request
     */
    @Override
    public void putHeader(Request<T, ? extends Request> request) {
        request.getHeaders().put("merchant-portal-token", Init.token);
        request.getHeaders().put("terminal", "MOBILE");
        request.getHeaders().put("pushId", Init.pushId);
        request.getHeaders().put("type", "ANDROID");
    }

    /**
     * 一般不进行处理 但如果每个  接口的 请求体都要加，可以在这里添加
     *
     * @param request
     */
    @Override
    public void putParams(Request<T, ? extends Request> request) {
        //request.getParams().put("client_os_type", 2);
    }

    /**
     * 开启进度条
     */
    @Override
    public void beginLod() {
        if (showDialog) {
            if (dialog != null && !dialog.isShowing()) {
                dialog.show();
            }
        }

    }

    /**
     * 关闭进度条
     */
    @Override
    public void onFinish() {
        if (showDialog) {
            //网络请求结束后关闭对话框
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }

    }
}
