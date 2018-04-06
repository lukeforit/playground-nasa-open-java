package com.rabbit.green.nasaopen.di;

import com.rabbit.green.nasaopen.feature.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityContributorModule {
    @ContributesAndroidInjector
    abstract MainActivity contributeMainActivity();
}
