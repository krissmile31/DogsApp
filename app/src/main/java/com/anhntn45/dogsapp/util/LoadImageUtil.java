package com.anhntn45.dogsapp.util;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.anhntn45.dogsapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class LoadImageUtil {

    public static void loadImage(ImageView imageView, String url, CircularProgressDrawable circularProgressDrawable) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(circularProgressDrawable)
                .error(R.mipmap.ic_dog_icon);
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(requestOptions)
                .load(url)
                .circleCrop()
                .into(imageView);
    }

    public static  CircularProgressDrawable circularProgressDrawable(Context context) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(context);
        circularProgressDrawable.setStrokeWidth(10f);
        circularProgressDrawable.setCenterRadius(50f);
        circularProgressDrawable.start();
        return circularProgressDrawable;
    }
}
