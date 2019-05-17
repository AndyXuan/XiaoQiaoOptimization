package com.xiaoqiao.qiaorong.qiaorong;


import android.os.Bundle;
import android.view.View;

import com.xiaoqiao.qiaorong.qiaorong.base.TestBaseActivity;
import com.xiaoqiao.qiaorong.qiaorong.demo.pickview.PickViewDemoActivity;

import butterknife.ButterKnife;
import me.xdd.self.basemodule.base.BaseNormalTitleActivity;

public class MainActivity extends TestBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void initIntentAndMemData() {
        super.initIntentAndMemData();
        hideLeft();
        setTextTitle("主页",R.color.colorBlack,20);
    }

    @Override
    public void onViewClicked(View v) {
        super.onViewClicked(v);
        switch (v.getId()){
            case R.id.pick_view_demo:
                startActivity(PickViewDemoActivity.newIntent(this));
                break;
        }
    }

    /**
     * 如果 要 自定义系统状态栏颜色  isTranslateSystemStatus 返回 fasle
     * @return
     */
    @Override
    protected int customSystemStatusColor() {
        return R.color.colorBlack;
    }


}
