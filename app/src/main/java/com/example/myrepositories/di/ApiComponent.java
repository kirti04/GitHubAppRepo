package com.example.myrepositories.di;

import com.example.myrepositories.View.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

    @Singleton
    @Component(modules = {AppModule.class, AndroidSupportInjectionModule.class,BuildersModule.class})
    public interface ApiComponent {
        @Component.Builder

        interface Builder{
            @BindsInstance
            Builder application(RepoApplication application);
            ApiComponent build();
        }
        void inject(RepoApplication repoApplication);




}
