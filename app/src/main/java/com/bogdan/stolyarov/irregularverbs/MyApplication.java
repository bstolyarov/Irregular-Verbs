package com.bogdan.stolyarov.irregularverbs;

import android.app.Application;

/**
 * Created by bogdan on 14.04.2016.
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Application wasn't initialized!");
        }
        return instance;
    }
}
