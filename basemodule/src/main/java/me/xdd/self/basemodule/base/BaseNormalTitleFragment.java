package me.xdd.self.basemodule.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import me.xdd.self.basemodule.R;
import me.xdd.self.basemodule.widget.MarqueeTextView;

/**
 * @author xuandong on 2019/5/15
 */
public abstract class BaseNormalTitleFragment extends BaseFragment {
    private boolean isInit = false;  //是否初始化过

    private View mView;
    private FrameLayout mFrameContent;
    private ImageView mStatusBar;
    private RelativeLayout mRelativeTitle;
    private ImageView mImageLeft;
    private TextView mTextLeft;
    private MarqueeTextView mTextTitle;
    private ImageView mImageRight;
    private TextView mTextRight;
    private View mSingleView;
    public abstract View createContentView();

    @Nullable
    @Override
    public View getView() {
        return mView;
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.title_bar_layout,container,false);
        View childView = createContentView();
        if (childView != null) {
            mFrameContent = mView.findViewById(R.id.frame_content);
            if (childView.getParent() != null) {
                ((ViewGroup) childView.getParent()).removeView(childView);
            }
            mFrameContent.addView(childView);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (!isInit){
            mStatusBar = mView.findViewById(R.id.status_bar);
            mRelativeTitle = mView.findViewById(R.id.relative_title);
            mImageLeft = mView.findViewById(R.id.image_left);
            mTextLeft = mView.findViewById(R.id.text_left);
            mTextTitle = mView.findViewById(R.id.text_title);
            mImageRight = mView.findViewById(R.id.image_right);
            mTextRight = mView.findViewById(R.id.text_right);
            mSingleView = mView.findViewById(R.id.single_view);
            hideTitleBarAndStatusBar();
            init();
            isInit = true;
        }

    }

    protected void init(){
        initIntentAndMemData();
        doInitBaseHttp();
    }




    //导航栏
    protected void hideTitleBar(){
        mRelativeTitle.setVisibility(View.GONE);
    }
    private void showTitleBar(){
        mRelativeTitle.setVisibility(View.VISIBLE);
    }
    protected void hideTitleBarAndStatusBar(){
        hideTitleBar();
        mStatusBar.setVisibility(View.VISIBLE);
    }
    protected void setTitleBarBackgroundByColor(int color){
        showTitleBar();
        mRelativeTitle.setBackgroundColor(ContextCompat.getColor(getActivity(),color));
    }

    protected void setTitleBarBackgroundByRes(int resId){
        showTitleBar();
        mRelativeTitle.setBackgroundResource(resId);
    }


    // 左边返回键文字

    protected void hideLeft() {
        hideTextLeft();
        hideImageLeft();
    }

    protected void hideImageLeft() {
        mImageLeft.setVisibility(View.GONE);
    }

    protected void hideTextLeft() {
        mTextLeft.setVisibility(View.GONE);
    }


    protected TextView showTextLeft(){
        hideImageLeft();
        mTextLeft.setVisibility(View.VISIBLE);
        return mTextLeft;
    }

    protected TextView setTextLeft(String txt){
        showTextLeft().setText(txt);
        return mTextLeft;
    }

    protected TextView setTextColorLeft(int color){
        showTextLeft().setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextLeft;
    }

    protected TextView setTextColorLeft(String txt,int color){
        setTextLeft(txt).setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextLeft;
    }


    // 左边图片
    protected ImageView showImageLeft(){
        hideTextLeft();
        mImageLeft.setVisibility(View.VISIBLE);
        return mImageLeft;
    }

    protected void setImageLeftRes(int resId){
        showImageLeft().setImageResource(resId);
    }



    //右边文字，图片
    protected void hideRight() {
        hideTextRight();
        hideImageRight();
    }

    protected void hideTextRight() {
        mTextRight.setVisibility(View.GONE);
    }

    protected void hideImageRight() {
        mImageRight.setVisibility(View.GONE);
    }



    protected TextView showTextRight(){
        hideImageRight();
        mTextRight.setVisibility(View.VISIBLE);
        return mTextRight;
    }

    protected TextView setTextRight(String txt){
        showTextRight().setText(txt);
        return mTextRight;
    }

    protected TextView setTextColorRight(int color){
        showTextRight().setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextRight;
    }

    protected TextView setTextColorRight(String txt,int color){
        setTextRight(txt).setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextRight;
    }


    // 右边图片
    protected ImageView showImageRight(){
        hideTextRight();
        mImageLeft.setVisibility(View.VISIBLE);
        return mImageLeft;
    }

    protected void setImageRightRes(int resId){
        showImageRight().setImageResource(resId);
    }

    //标题


    @Override
    public void setTextTitle(String title) {
        fragmentTitle = title;
        mTextTitle.setText(fragmentTitle);
    }

    protected void setTextTitleColor(int color){
        mTextTitle.setTextColor(ContextCompat.getColor(getActivity(),color));
    }

    protected void setTextTitle(String title,int color){
        setTextTitle(title);
        mTextTitle.setTextColor(ContextCompat.getColor(getActivity(),color));
    }
    protected void setTextTitle(String title,int color,int textSize){
        setTextTitle(title,color);
        mTextTitle.setTextSize(textSize);
    }

    protected void showSingleView(){
        mSingleView.setVisibility(View.VISIBLE);
    }


    @Override
    public void initIntentAndMemData() {
        hideLeft();
        hideRight();
        mImageLeft.setOnClickListener(new OnFinishClickListener());
        mTextLeft.setOnClickListener(new OnFinishClickListener());
        mImageRight.setOnClickListener(new OnRightClickListener());
        mTextRight.setOnClickListener(new OnRightClickListener());
    }

    private class OnFinishClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            getActivity().finish();
        }
    }

    private class OnRightClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            clickRightEvent();
        }
    }

    public void clickRightEvent(){};
}
