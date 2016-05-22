package com.tokopedia.producttokopedia.app;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Tokopedia01 on 5/22/2016.
 */
public class ProductTkpdApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ActiveAndroid.initialize(this);
    }
}
