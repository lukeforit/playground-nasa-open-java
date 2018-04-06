package com.rabbit.green.nasaopen.feature;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.rabbit.green.nasaopen.BR;
import com.rabbit.green.nasaopen.data.model.PojoObject;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MainViewModel extends BaseObservable {

    private PojoObject object;
    private String status;

    @Inject
    MainViewModel() {
    }


    public PojoObject getObject() {
        return object;
    }

    public void setObject(PojoObject object) {
        this.object = object;
        notifyPropertyChanged(BR.title);
        notifyPropertyChanged(BR.explanation);
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getTitle() {
        return object == null ? "" : object.getTitle();
    }

    @Bindable
    public String getExplanation() {
        return object == null ? "" : object.getExplanation();
    }

    @Bindable
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public String getUrl() {
        return object == null ? "" : object.getUrl();
    }

    @BindingAdapter("bind:url")
    public static void bindUrl(ImageView imageView, String url) {
        if (!TextUtils.isEmpty(url)) {
            Picasso.get().load(url).fit().centerCrop().into(imageView);
        }
    }
}
