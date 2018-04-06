package com.rabbit.green.nasaopen.feature;

import com.rabbit.green.nasaopen.data.model.PojoObject;
import com.rabbit.green.nasaopen.data.source.IMyDataRepository;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements SingleObserver<PojoObject> {

    @Inject
    IMyDataRepository repository;

    @Inject
    MainViewModel viewModel;

    @Inject
    MainPresenter() {
    }

    void setup() {
        Single.fromCallable(new Callable<PojoObject>() {
            @Override
            public PojoObject call() throws Exception {
                return repository.getData();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(this);
    }

    public MainViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void onSubscribe(Disposable d) {
        viewModel.setStatus("Subscribe");
    }

    @Override
    public void onSuccess(PojoObject pojoObject) {
        viewModel.setObject(pojoObject);
        viewModel.setStatus("Success");
    }

    @Override
    public void onError(Throwable e) {
        viewModel.setStatus(e.toString());
    }
}
