package com.tokopedia.producttokopedia.modules.product.search.interactor;

import android.text.TextUtils;
import android.util.Log;

import com.tokopedia.producttokopedia.db.table.ProductSearchTbl;
import com.tokopedia.producttokopedia.modules.product.search.interactor.ProductSearchInteractor;
import com.tokopedia.producttokopedia.network.reponses.BaseResponse;
import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;
import com.tokopedia.producttokopedia.network.services.ProductService;
import com.tokopedia.producttokopedia.utils.GeneralUtils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

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
    public void search(String device, final String query, String rows, final OnKeywordListener onKeywordListener) {
        boolean error = false;
        if(TextUtils.isEmpty(query)){
            onKeywordListener.onKeywordError();
            error = true;
        }
        if (!error){
            ProductSearchTbl productSearchTbl = new ProductSearchTbl();
            productSearchTbl = ProductSearchTbl.getResult(query);
            if (productSearchTbl == null){
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
                            String sresult = response.body().getOriginResult();
                            if (!sresult.isEmpty()){
                                ProductSearchTbl ps = new ProductSearchTbl();
                                ps.setKeyword(query);
                                ps.setResutl(sresult);
                                ps.save();
                            }
                        }
                    }
                };
                subscription.add(prObservable.subscribeOn(Schedulers.newThread())
                        .unsubscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subscriber))
                ;
            }else {
                BaseResponse br = BaseResponse.factory(productSearchTbl.getResutl());
                onKeywordListener.onSuccess(br.convertResult(ProductSearchResponse.class));
            }
        }
    }

    @Override
    public void moreProduct(String url, final onLoadMoreListener listener) {
        String device = "", q = "", rows = "", start = "";
        try{
            Map<String, String> maps = GeneralUtils.splitQuery(new URL(url));
            for (Map.Entry<String, String> map: maps.entrySet()){
                switch (map.getKey()){
                    case "device":
                        device = map.getValue();
                        break;
                    case "q":
                        q = map.getValue();
                        break;
                    case "rows":
                        rows = map.getValue();
                        break;
                    case "start":
                        start = map.getValue();
                        break;
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        Observable<Response<BaseResponse>> prObservable = productService.getApi().moreProduct(device,
                q, rows, start)
                ;
        Subscriber<Response<BaseResponse>> subscriber = new Subscriber<Response<BaseResponse>>() {
            @Override
            public void onCompleted() {
                Log.v("TKPD", "Selsai");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Response<BaseResponse> response) {
                if (response.isSuccessful()){
                    listener.onSuccess(response.body().convertResult(ProductSearchResponse.class));
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
