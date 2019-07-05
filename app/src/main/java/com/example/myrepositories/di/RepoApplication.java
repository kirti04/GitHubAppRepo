package com.example.myrepositories.di;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;


public class RepoApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> androidInjector;



    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApiComponent
                .builder()
                .application(this)
                .build()
                .inject(this);


    }



    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }
}
