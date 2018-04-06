package com.rabbit.green.nasaopen.di;

import com.rabbit.green.nasaopen.common.MyApp;

import javax.inject.Singleton;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        MyAppModule.class,
        ActivityContributorModule.class,
        AndroidInjectionModule.class
})
public interface MyAppComponent {
    void inject(MyApp app);

    @Component.Builder
    interface Builder {
        MyAppComponent build();

        @BindsInstance
        Builder myAppModule(MyApp app);
    }

}
