package com.rabbit.green.nasaopen.di;

import android.content.Context;

import com.rabbit.green.nasaopen.BuildConfig;
import com.rabbit.green.nasaopen.IResourceProvider;
import com.rabbit.green.nasaopen.LocalClientInterceptor;
import com.rabbit.green.nasaopen.MockResourceProvider;
import com.rabbit.green.nasaopen.data.source.IMyDataRepository;
import com.rabbit.green.nasaopen.data.source.IMyDataRestService;
import com.rabbit.green.nasaopen.data.source.MyDataRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public IResourceProvider provideResourceProvider(Context context) {
        return new MockResourceProvider(context);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(IResourceProvider resourceProvider) {
        return new OkHttpClient.Builder()
                .addInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new LocalClientInterceptor(resourceProvider))
                .build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
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
