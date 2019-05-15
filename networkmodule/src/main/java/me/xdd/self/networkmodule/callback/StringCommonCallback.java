package me.xdd.self.networkmodule.callback;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

/**
 * @author xuandong on 2019/5/15
 */
public abstract class StringCommonCallback extends StringCallback {

    @Override
    public void onStart(Request<String, ? extends Request> request) {
        // 主要用于在所有请求之前添加公共的请求头或请求参数
        // 例如登录授权的 token
        // 使用的设备信息
        // 可以随意添加,也可以什么都不传
        // 还可以在这里对所有的参数进行加密，均在这里实现
        //   request.getHeaders().put("token","123456789");

        putHeader(request);
        putParams(request);
        beginLod();
    }

    /**添加参数**/
    public abstract void putParams(Request<String, ? extends Request> request);
    /**添加头部参赛**/
    public abstract void putHeader(Request<String, ? extends Request> request);
    /**开启进度条**/
    public abstract void beginLod();


    @Override
    public void onError(Response<String> response) {
        super.onError(response);
    }

    @Override
    public void onSuccess(Response<String> response) {

    }

    @Override
    public String convertResponse(okhttp3.Response response) throws Throwable {
        return super.convertResponse(response);
    }
}
