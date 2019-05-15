package me.xdd.self.basemodule.base;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.File;

import me.xdd.self.basemodule.R;
import me.xdd.self.basemodule.glidemodule.GlideApp;

/**
 * @author xuandong on 2019/5/15
 */
public abstract class BaseActivity extends AppCompatActivity implements OnGlideDisplayInterface {

    @Override
    public void displayByteImage(ImageView imageView, byte[] bytes, int errorImg, int placeImg, int fallbackImg) {
        if (errorImg !=-1){
            GlideApp.with(this).load(bytes).placeholder(placeImg)
                    .error(errorImg)
                    .fallback(fallbackImg)
                    .into(imageView);
        }else{
            displayByteImage(imageView,bytes);
        }

    }

    @Override
    public void displayLocalImage(ImageView imageView, File file, int errorImg, int placeImg, int fallbackImg) {
        if (errorImg !=-1){
            GlideApp.with(this).load(file).placeholder(placeImg)
                    .error(errorImg)
                    .fallback(fallbackImg)
                    .into(imageView);
        }else{
            displayLocalImage(imageView,file);
        }
    }

    @Override
    public void displayNormalImage(ImageView imageView, String url,int errorImg,int placeImg,int fallbackImg) {
        if (errorImg !=-1){
            GlideApp.with(this).load(url).placeholder(placeImg)
                    .error(errorImg)
                    .fallback(fallbackImg)
                    .into(imageView);
        }else{
            displayNormalImage(imageView,url);
        }
    }

    @Override
    public void displayResourceImage(ImageView imageView, int resource,int errorImg,int placeImg,int fallbackImg) {
        if (errorImg !=-1){
            GlideApp.with(this).load(resource).placeholder(placeImg)
                    .error(errorImg)
                    .fallback(fallbackImg)
                    .into(imageView);
        }else{
            displayResourceImage(imageView,resource);
        }
    }

    @Override
    public void displayUriImage(ImageView imageView, Uri uri, int errorImg, int placeImg, int fallbackImg) {
        if (errorImg !=-1){
            GlideApp.with(this).load(uri).placeholder(placeImg)
                    .error(errorImg)
                    .fallback(fallbackImg)
                    .into(imageView);
        }else{
            displayUriImage(imageView,uri);
        }
    }


    public void displayByteImage(ImageView imageView, byte[] bytes) {
        GlideApp.with(this).load(bytes).placeholder(R.drawable.place_holder_img)
                .error(R.drawable.place_holder_img)
                .fallback(R.drawable.place_holder_img)
                .into(imageView);
    }

    public void displayLocalImage(ImageView imageView, File file) {
        GlideApp.with(this).load(file).placeholder(R.drawable.place_holder_img)
                .error(R.drawable.place_holder_img)
                .fallback(R.drawable.place_holder_img)
                .into(imageView);
    }


    public void displayNormalImage(ImageView imageView, String url) {
        GlideApp.with(this).load(url).placeholder(R.drawable.place_holder_img)
                .error(R.drawable.place_holder_img)
                .fallback(R.drawable.place_holder_img)
                .into(imageView);
    }


    public void displayResourceImage(ImageView imageView, int resource) {
        GlideApp.with(this).load(resource).placeholder(R.drawable.place_holder_img)
                .error(R.drawable.place_holder_img)
                .fallback(R.drawable.place_holder_img)
                .into(imageView);
    }


    public void displayUriImage(ImageView imageView, Uri uri) {
        GlideApp.with(this).load(uri).placeholder(R.drawable.place_holder_img)
                .error(R.drawable.place_holder_img)
                .fallback(R.drawable.place_holder_img)
                .into(imageView);
    }
}
