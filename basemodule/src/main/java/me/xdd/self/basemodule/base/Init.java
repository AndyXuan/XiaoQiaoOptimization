package me.xdd.self.basemodule.base;

import android.view.View;

public interface Init {
    /**
     * 初始化基本参数
     * 如Intent 及 成员变量初始化
     */
     void initIntentAndMemData();

    /**
     * 组件启动时启用网络获取基本数据
     */
     void doInitBaseHttp();

    /**
     * 当控件被点击时
     */
     void onViewClicked(View v);

    /**
     * 基本控件初始化
     */
     void initWidget(View... v);

    /**
     *某些需求下要刷新页面
     * @param refresh
     */
     void refreshUi(boolean refresh);
}
