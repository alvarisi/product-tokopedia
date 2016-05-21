package com.tokopedia.producttokopedia.modules.product.search.interactor;

import android.text.TextUtils;

import com.tokopedia.producttokopedia.modules.product.search.interactor.ProductSearchInteractor;
import com.tokopedia.producttokopedia.network.reponses.BaseResponse;
import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;
import com.tokopedia.producttokopedia.network.services.ProductService;

import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class ProductSearchInteractorImpl implements ProductSearchInteractor {
    private final ProductService productService;
    private final CompositeSubscription subscription;
    public ProductSearchInteractorImpl(){
        this.productService = new ProductService();
        this.subscription = new CompositeSubscription();
    }
    @Override
    public void search(String device, String query, String rows, final OnKeywordListener onKeywordListener) {
        boolean error = false;
        if(TextUtils.isEmpty(query)){
            onKeywordListener.onKeywordError();
            error = true;
        }
        if (!error){
            Observable<Response<BaseResponse>> prObservable = productService.getApi().getProducts(device, query, rows)
                    ;
            Subscriber<Response<BaseResponse>> subscriber = new Subscriber<Response<BaseResponse>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {
                    e.printStackTrace();
                }

                @Override
                public void onNext(Response<BaseResponse> response) {
                    if (response.isSuccessful()){
                        onKeywordListener.onSuccess(response.body().convertResult(ProductSearchResponse.class));
                    }
                }
            };
            subscription.add(prObservable.subscribeOn(Schedulers.newThread())
                        .unsubscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber))
                        ;
        }
    }

}
