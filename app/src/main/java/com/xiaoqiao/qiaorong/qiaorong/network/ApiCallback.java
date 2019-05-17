package com.xiaoqiao.qiaorong.qiaorong.network;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import me.xdd.self.networkmodule.callback.Init;
import me.xdd.self.networkmodule.callback.JsonCallback;

/**
 * @author xuandong on 2019/5/16
 */
public class ApiCallback<T> extends JsonCallback<T> {
    private boolean showLoading;
    public ApiCallback(Context context,boolean showLoading,Class<T> tClass) {
        mHandleResponse = (HandleResponse) context;
        this.showLoading = showLoading;
        this.tClass = tClass;
    }


    @Override
    public void putParams(Request<T, ? extends Request> request) {
        //request.getParams().put("client_os_type", 2);
    }

    @Override
    public void putHeader(Request<T, ? extends Request> request) {
        request.getHeaders().put("merchant-portal-token", Init.token);
        request.getHeaders().put("terminal", "MOBILE");
        request.getHeaders().put("pushId", Init.pushId);
        request.getHeaders().put("type", "ANDROID");
    }

    @Override
    public void beginLod() {
        mHandleResponse.onStartLoad();
    }

    @Override
    public void onFinish() {
        mHandleResponse.onFinish();
    }

    @Override
    public void onError(Response<T> response) {
        super.onError(response);
    }

    @Override
    public void onSuccess(Response<T> response) {
        mHandleResponse.onSuccess(response);
    }


}
