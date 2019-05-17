package me.xdd.self.networkmodule.callback;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.base.Request;

import me.xdd.self.networkmodule.model.BaseBean;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author xuandong on 2019/5/15
 */
public abstract class JsonCallback<T> extends AbsCallback<T> {
    public HandleResponse mHandleResponse;

    public interface HandleResponse {
        void onStartLoad();

        void onFinish();

        <T> void onSuccess(com.lzy.okgo.model.Response<T> response);
    }
    public Class<T> tClass;

    public JsonCallback(Class<T> tClass) {
        this.tClass = tClass;
    }

    public JsonCallback() {

    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
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

    /**
     * 添加请求参数
     **/
    public abstract void putParams(Request<T, ? extends Request> request);

    /**
     * 添加头部参赛
     **/
    public abstract void putHeader(Request<T, ? extends Request> request);

    /**
     * 开启进度条
     **/
    public abstract void beginLod();


    /**
     * 注意、注意、注意、这里返回的格式要统一，要统一
     *
     *
     * 至少----至少----要符合以下格式才能使用
     *
     *        {
     *            "status": "success",
     *            "message":"成功",
     *            “data”:T
     *        }
     *
     *        T  是泛型   可以  是  八大基本数据类型，也可以是 Object.
     *
     *        基于以上格式，这个方法中的代码就不用动了
     *
     *
     *
     *
     *
     * 此代码在 现金贷 app 、好学习 app 、聚合宝 app 中已经试用成功了。
     * 这里进行了对返回数据的处理。根据后台返回的数据进行整合。
     * 目前而言，我这里已经做了处理了。可以通用不用更改。
     *
     * @param response
     * @return
     * @throws Throwable
     */
    @Override
    public T convertResponse(Response response) throws Throwable {

        ResponseBody responseBody = response.body();
        if (responseBody == null) return null;

        //这里的代码是因为 后台返回的 token 存放在header 中，我这里把他取出来，
        //以 key 为  userToken 的形式存放到 json 中。
        //再重新组合成 jsonReader流 转换成 基类 BaseResponse
//        String jsonData = new String(responseBody.bytes(), "utf-8");
//        JSONObject jsonObject = new JSONObject(jsonData);
//        jsonObject.put("userToken", response.header("merchant-portal-token"));
//        String ss = jsonObject.toString();
//        Reader reader = new StringReader(ss);
//        JsonReader jsonReader = new JsonReader(reader);


        JsonReader jsonReader = new JsonReader(responseBody.charStream());

        Gson gson = new Gson();
        // 通过 gson 将 jsonReader流 转化成对应的tClass实体。这样就做到了统一
        BaseBean baseResponse = gson.fromJson(jsonReader, tClass);
        response.close();
        return (T) baseResponse;

    }

    /**
     * 处理错误信息，一般都是网络错误信息
     * @param response
     */
    @Override
    public void onError(com.lzy.okgo.model.Response<T> response) {
        super.onError(response);
    }
}
