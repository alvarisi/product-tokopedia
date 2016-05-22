package com.tokopedia.producttokopedia.network.services;

import com.tokopedia.producttokopedia.network.constants.ProductTkpd;
import com.tokopedia.producttokopedia.network.reponses.BaseResponse;


import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public interface ProductApi {
    @GET(ProductTkpd.Product.SEARCH)
    Observable<Response<BaseResponse>> getProducts(@Query("device") String device,
                                                   @Query("q") String q,
                                                   @Query("rows") String rows
                                            );
    @GET(ProductTkpd.Product.SEARCH)
    Observable<Response<BaseResponse>> moreProduct(@Query("device") String device,
                                                   @Query("q") String q,
                                                   @Query("rows") String rows,
                                                   @Query("start") String start
                                                   );
}