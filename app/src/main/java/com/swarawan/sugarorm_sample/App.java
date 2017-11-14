package com.swarawan.sugarorm_sample;

import android.app.Application;

import com.orm.SugarContext;

/**
 * Created by rioswarawan on 11/14/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        SugarContext.init(this);
    }
}
