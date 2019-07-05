package com.example.myrepositories.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context ProvideApplication(RepoApplication application)
    {
        return application.getApplicationContext();
    }
}
