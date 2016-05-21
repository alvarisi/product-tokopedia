package com.tokopedia.producttokopedia.network.services;


import com.tokopedia.producttokopedia.network.constants.ProductTkpd;

import retrofit2.Retrofit;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class ProductService extends BaseApi<ProductApi> {

    public ProductService(){
        super();
        /*RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(requestInterceptor)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        productApi = restAdapter.create(ProductApi.class);*/
    }

    @Override
    protected void constructApi(Retrofit retrofit) {
        api = retrofit.create(ProductApi.class);
    }

    @Override
    protected String getUrl() {
        return ProductTkpd.BASE_DOMAIN;
    }

    public ProductApi getApi(){
        return api;
    }
}
