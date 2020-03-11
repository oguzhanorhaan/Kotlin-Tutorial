package com.oguzhanorhan.dagger2codingwithmitchtutorial.di;

import android.app.Application;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.oguzhanorhan.dagger2codingwithmitchtutorial.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//we instantiate instances like retrofit, glide here. They not change and used on whole app
@Module
public class AppModule {

    @Singleton
    @Provides
    static RequestOptions provideRequestOptions() {
        return RequestOptions
                .placeholderOf(R.drawable.sacai1)
                .error(R.drawable.sacai1);
    }

    @Singleton
    @Provides
    static RequestManager provideGlide(Application application, RequestOptions requestOptions) {
        return Glide.with(application)
                .setDefaultRequestOptions(requestOptions);
    }

    @Singleton
    @Provides
    static Drawable provideAppDrawable(Application application) {
        return ContextCompat.getDrawable(application, R.drawable.sacai2);
    }

}
