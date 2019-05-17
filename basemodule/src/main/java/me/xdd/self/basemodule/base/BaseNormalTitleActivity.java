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
 * @author xuandong on 2019/5/17
 */
public abstract class BaseNormalTitleActivity extends BaseActivity {

    private FrameLayout mFrameContent;
    private ImageView mStatusBar;
    private RelativeLayout mRelativeTitle;
    private ImageView mImageLeft;
    private TextView mTextLeft;
    private MarqueeTextView mTextTitle;
    private ImageView mImageRight;
    private TextView mTextRight;
    private View mSingleView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.title_bar_layout);
    }



    @Override
    public void setContentView(int layoutResID) {
        mFrameContent = (FrameLayout) findViewById(R.id.frame_content);
        View v = LayoutInflater.from(this).inflate(layoutResID, null);
        v.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mFrameContent.addView(v);
        mStatusBar = findViewById(R.id.status_bar);
        mRelativeTitle = findViewById(R.id.relative_title);
        mImageLeft = findViewById(R.id.image_left);
        mTextLeft =findViewById(R.id.text_left);
        mTextTitle = findViewById(R.id.text_title);
        mImageRight = findViewById(R.id.image_right);
        mTextRight = findViewById(R.id.text_right);
        mSingleView = findViewById(R.id.single_view);
        hideStatusBar();
        initIntentAndMemData();
        doInitBaseHttp();
    }

    private void hideStatusBar(){
        mStatusBar.setVisibility(View.GONE);
    }

    @Override
    public void initIntentAndMemData() {
        hideRight();
        mImageLeft.setOnClickListener(new OnFinishClickListener());
        mTextLeft.setOnClickListener(new OnFinishClickListener());
        mImageRight.setOnClickListener(new OnRightClickListener());
        mTextRight.setOnClickListener(new OnRightClickListener());
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
        mRelativeTitle.setBackgroundColor(ContextCompat.getColor(this,color));
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
        showTextLeft().setTextColor(ContextCompat.getColor(this,color));
        return mTextLeft;
    }

    protected TextView setTextColorLeft(String txt,int color){
        setTextLeft(txt).setTextColor(ContextCompat.getColor(this,color));
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
        showTextRight().setTextColor(ContextCompat.getColor(this,color));
        return mTextRight;
    }

    protected TextView setTextColorRight(String txt,int color){
        setTextRight(txt).setTextColor(ContextCompat.getColor(this,color));
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

    // 标题
    protected void setTextTitle(String title){
        mTextTitle.setText(title);
    }

    protected void setTextTitleColor(int color){
        mTextTitle.setTextColor(ContextCompat.getColor(this,color));
    }

    protected void setTextTitle(String title,int color){
        setTextTitle(title);
        mTextTitle.setTextColor(ContextCompat.getColor(this,color));
    }
    protected void setTextTitle(String title,int color,int textSize){
        setTextTitle(title,color);
        mTextTitle.setTextSize(textSize);
    }

    protected void showSingleView(){
        mSingleView.setVisibility(View.VISIBLE);
    }


    private class OnFinishClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            finish();
        }
    }

    private class OnRightClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            clickRightEvent();
        }
    }

    public void clickRightEvent(){};

    @Override
    public void refreshUi(boolean refresh) {

    }

    @Override
    public void onViewClicked(View v) {

    }


}
