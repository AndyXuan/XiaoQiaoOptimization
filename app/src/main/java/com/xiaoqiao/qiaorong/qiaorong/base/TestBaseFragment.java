package com.xiaoqiao.qiaorong.qiaorong.base;

import android.view.View;

import com.lzy.okgo.model.Response;

import me.xdd.self.basemodule.base.BaseNormalTitleFragment;

/**
 * @author xuandong on 2019/5/17
 */
public class TestBaseFragment extends BaseNormalTitleFragment {
    @Override
    public View createContentView() {
        return null;
    }

    @Override
    public void onStartLoad() {
        super.onStartLoad();
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }

    @Override
    public <T> void onSuccess(Response<T> response) {
        super.onSuccess(response);
    }
}
