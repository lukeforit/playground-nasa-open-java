package com.rabbit.green.nasaopen.di;

import com.rabbit.green.nasaopen.BuildConfig;
import com.rabbit.green.nasaopen.data.source.IMyDataRepository;
import com.rabbit.green.nasaopen.data.source.IMyDataRestService;
import com.rabbit.green.nasaopen.data.source.MyDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public IMyDataRestService provideMyDataRestService(Retrofit retrofit) {
        return retrofit.create(IMyDataRestService.class);
    }

    @Provides
    @Singleton
    public IMyDataRepository provideMyDataRepository(IMyDataRestService service) {
        return new MyDataRepository(service);
    }

}
