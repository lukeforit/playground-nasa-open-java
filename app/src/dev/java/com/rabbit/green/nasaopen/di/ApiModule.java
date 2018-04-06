package com.rabbit.green.nasaopen.di;

import com.rabbit.green.nasaopen.BuildConfig;
import com.rabbit.green.nasaopen.LocalClientInterceptor;
import com.rabbit.green.nasaopen.data.source.IMyDataRepository;
import com.rabbit.green.nasaopen.data.source.IMyDataRestService;
import com.rabbit.green.nasaopen.data.source.MyDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LocalClientInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.baseUrl)
                .client(client)
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
