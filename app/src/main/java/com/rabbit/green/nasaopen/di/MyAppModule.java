package com.rabbit.green.nasaopen.di;

import android.content.Context;

import com.rabbit.green.nasaopen.common.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApiModule.class)
public class MyAppModule {
    @Provides
    @Singleton
    public Context provideContext(MyApp app) {
        return app.getApplicationContext();
    }
}
