package com.xiaoqiao.qiaorong.qiaorong.base;

import com.lzy.okgo.model.Response;

import me.xdd.self.basemodule.base.BaseNormalTitleActivity;

/**
 * @author xuandong on 2019/5/17
 */
public class TestBaseActivity extends BaseNormalTitleActivity {
    @Override
    protected boolean isTranslateSystemStatus() {
        return false;
    }

    @Override
    protected int customSystemStatusColor() {
        return 0;
    }

    @Override
    protected boolean isStatusTextColorBlack() {
        return false;
    }


    @Override
    public <T> void onSuccess(Response<T> response) {
        super.onSuccess(response);
    }

    @Override
    public void onStartLoad() {
        super.onStartLoad();
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }
}
