/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.xdd.self.basemodule.base;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


/**
 * -
 * -注1: 如果是与ViewPager一起使用，调用的是setUserVisibleHint。
 * ------可以调用mViewPager.setOffscreenPageLimit(size),若设置了该属性 则viewpager会缓存指定数量的Fragment
 * -注2: 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
 * -注3: 针对初始就show的Fragment 为了触发onHiddenChanged事件 达到lazy效果 需要先hide再show
 */


public abstract class BaseFragment extends Fragment implements Init,OnGlideDisplayInterface{
    public String fragmentTitle;  //fragment标题

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void refreshUi(boolean refresh) {

    }

    @Override
    public void initIntentAndMemData() {

    }

    @Override
    public void doInitBaseHttp() {

    }

    @Override
    public void initWidget(View... v) {

    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onViewClicked(final View v) {

    }


    public String getTextTitle() {
        return TextUtils.isEmpty(fragmentTitle) ? "" : fragmentTitle;
    }

    public void setTextTitle(String title) {
        fragmentTitle = title;
    }


    public void showToast(String msg){
        Toast.makeText(getContext(),msg, Toast.LENGTH_LONG).show();
    }


    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }


    public void displayByteImage(ImageView imageView, byte[] bytes,int errorImg,int placeImg,int fallbackImg) {
        getBaseActivity().displayByteImage(imageView,bytes,errorImg,placeImg,fallbackImg);

    }


    public void displayLocalImage(ImageView imageView, File file,int errorImg,int placeImg,int fallbackImg) {
        getBaseActivity().displayLocalImage(imageView,file,errorImg,placeImg,fallbackImg);
    }


    public void displayNormalImage(ImageView imageView, String url,int errorImg,int placeImg,int fallbackImg) {
        getBaseActivity().displayNormalImage(imageView,url,errorImg,placeImg,fallbackImg);
    }


    public void displayResourceImage(ImageView imageView, int resource,int errorImg,int placeImg,int fallbackImg) {
        getBaseActivity().displayResourceImage(imageView,resource,errorImg,placeImg,fallbackImg);
    }


    public void displayUriImage(ImageView imageView, Uri uri,int errorImg,int placeImg,int fallbackImg) {
        getBaseActivity().displayUriImage(imageView,uri,errorImg,placeImg,fallbackImg);
    }


    public void displayByteImage(ImageView imageView, byte[] bytes) {
        getBaseActivity().displayByteImage(imageView,bytes);
    }

    public void displayLocalImage(ImageView imageView, File file) {
        getBaseActivity().displayLocalImage(imageView,file);
    }


    public void displayNormalImage(ImageView imageView, String url) {
        getBaseActivity().displayNormalImage(imageView,url);
    }


    public void displayResourceImage(ImageView imageView, int resource) {
        getBaseActivity().displayResourceImage(imageView,resource);
    }


    public void displayUriImage(ImageView imageView, Uri uri) {
        getBaseActivity().displayUriImage(imageView,uri);
    }

}
