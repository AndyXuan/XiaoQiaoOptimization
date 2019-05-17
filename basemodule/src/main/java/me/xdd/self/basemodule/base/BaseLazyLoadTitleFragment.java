package me.xdd.self.basemodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;


/**
 * Viewpager + Fragment情况下，fragment的生命周期因Viewpager的缓存机制而失去了具体意义
 * 该抽象类自定义一个新的回调方法，当fragment可见状态改变时会触发的回调方法
 * @author xuandong on 2019/5/16
 */
public abstract class BaseLazyLoadTitleFragment extends BaseNormalTitleFragment {

    // 是否可见
    private boolean isFragmentVisible;
    //是否第一次加载
    private boolean isFirstVisible;


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //有可能在fragment的生命周期外被调用,不做控制，可能导致空指针异常
        if (getView() == null){
            return;
        }
        //如果第一次可见 并且 fragment 对用户可见
        if (isFirstVisible && isVisibleToUser){
            onFragmentFistVisible();
            isFirstVisible = false;

        }

        if (isVisibleToUser){
            isFragmentVisible = true;
            onFragmentVisibleChange(true);
            return;
        }

        if (isFragmentVisible){
            isFragmentVisible = false;
            onFragmentVisibleChange(false);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initVisible();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!isFirstVisible && getUserVisibleHint()){
            onFragmentVisibleChange(true);
            isFirstVisible = true;
            isFragmentVisible = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        initVisible();
    }

    private void initVisible(){
        isFirstVisible = false;
        isFragmentVisible = false;

    }

    protected void onFragmentFistVisible(){

    }


    protected void onFragmentVisibleChange(boolean isVisible){

    }
}
