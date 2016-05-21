package com.tokopedia.producttokopedia.network.services;

import com.tokopedia.producttokopedia.network.Transformator.BaseTransformator;
import com.tokopedia.producttokopedia.network.constants.ProductTkpd;
import com.tokopedia.producttokopedia.network.reponses.BaseResponse;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public abstract class BaseApi<T> {
    protected T api;
    public BaseApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getUrl())
                .addConverterFactory(new BaseTransformator())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        constructApi(retrofit);
    }
    protected abstract void constructApi(Retrofit retrofit);
    protected abstract String getUrl();
}
