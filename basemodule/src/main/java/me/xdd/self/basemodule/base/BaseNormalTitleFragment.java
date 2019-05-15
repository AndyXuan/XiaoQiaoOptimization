package me.xdd.self.basemodule.base;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.annotation.NonNull;
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mStatusBar = mView.findViewById(R.id.status_bar);
        mRelativeTitle = mView.findViewById(R.id.relative_title);
        mImageLeft = mView.findViewById(R.id.image_left);
        mTextLeft = mView.findViewById(R.id.text_left);
        mTextTitle = mView.findViewById(R.id.text_title);
        mImageRight = mView.findViewById(R.id.image_right);
        mTextRight = mView.findViewById(R.id.text_right);
        mSingleView = mView.findViewById(R.id.single_view);
        initWidget();
        initIntentAndMemData();
    }

    @Override
    public void initWidget(View... v) {
       hideLeft();
       hideRight();
    }



    //导航栏
    public void hideTitleBar(){
        mRelativeTitle.setVisibility(View.GONE);
    }
    private void showTitleBar(){
        mRelativeTitle.setVisibility(View.VISIBLE);
    }
    public void hideTitleBarAndStatusBar(){
        hideTitleBar();
        mStatusBar.setVisibility(View.VISIBLE);
    }
    public void setTitleBarBackgroundByColor(int color){
        showTitleBar();
        mRelativeTitle.setBackgroundColor(ContextCompat.getColor(getActivity(),color));
    }

    public void setTitleBarBackgroundByRes(int resId){
        showTitleBar();
        mRelativeTitle.setBackgroundResource(resId);
    }


    // 左边返回键文字

    public void hideLeft() {
        hideTextLeft();
        hideImageLeft();
    }

    public void hideImageLeft() {
        mImageLeft.setVisibility(View.GONE);
    }

    public void hideTextLeft() {
        mTextLeft.setVisibility(View.GONE);
    }


    public TextView showTextLeft(){
        hideImageLeft();
        mTextLeft.setVisibility(View.VISIBLE);
        return mTextLeft;
    }

    public TextView setTextLeft(String txt){
        showTextLeft().setText(txt);
        return mTextLeft;
    }

    public TextView setTextColorLeft(int color){
        showTextLeft().setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextLeft;
    }

    public TextView setTextColorLeft(String txt,int color){
        setTextLeft(txt).setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextLeft;
    }


    // 左边图片
    public ImageView showImageLeft(){
        hideTextLeft();
        mImageLeft.setVisibility(View.VISIBLE);
        return mImageLeft;
    }

    public void setImageLeftRes(int resId){
        showImageLeft().setImageResource(resId);
    }



    //右边文字，图片
    public void hideRight() {
        hideTextRight();
        hideImageRight();
    }

    public void hideTextRight() {
        mTextRight.setVisibility(View.GONE);
    }

    public void hideImageRight() {
        mImageRight.setVisibility(View.GONE);
    }



    public TextView showTextRight(){
        hideImageRight();
        mTextRight.setVisibility(View.VISIBLE);
        return mTextRight;
    }

    public TextView setTextRight(String txt){
        showTextRight().setText(txt);
        return mTextRight;
    }

    public TextView setTextColorRight(int color){
        showTextRight().setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextRight;
    }

    public TextView setTextColorRight(String txt,int color){
        setTextRight(txt).setTextColor(ContextCompat.getColor(getActivity(),color));
        return mTextRight;
    }


    // 右边图片
    public ImageView showImageRight(){
        hideTextRight();
        mImageLeft.setVisibility(View.VISIBLE);
        return mImageLeft;
    }

    public void setImageRightRes(int resId){
        showImageRight().setImageResource(resId);
    }

    //标题


    @Override
    public void setTextTitle(String title) {
        fragmentTitle = title;
        mTextTitle.setText(fragmentTitle);
    }

    public void setTextTitleColor(int color){
        mTextTitle.setTextColor(ContextCompat.getColor(getActivity(),color));
    }

    public void setTextTitle(String title,int color){
        setTextTitle(title);
        mTextTitle.setTextColor(ContextCompat.getColor(getActivity(),color));
    }
    public void setTextTitle(String title,int color,int textSize){
        setTextTitle(title,color);
        mTextTitle.setTextSize(textSize);
    }


    @Override
    public void initIntentAndMemData() {
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
