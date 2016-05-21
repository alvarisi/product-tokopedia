package com.tokopedia.producttokopedia.modules.product.search.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tokopedia.producttokopedia.modules.product.search.view.ProductSearchView;
import com.tokopedia.producttokopedia.modules.product.search.interactor.ProductSearchInteractor;
import com.tokopedia.producttokopedia.modules.product.search.interactor.ProductSearchInteractorImpl;
import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class ProductSearchPresenterImpl implements ProductSearchPresenter,
        ProductSearchInteractor.OnKeywordListener {
    private ProductSearchView productSearchView;
    private ProductSearchInteractor productSearchInteractor;
    public ProductSearchPresenterImpl(ProductSearchView productSearchView){
        this.productSearchView = productSearchView;
        this.productSearchInteractor = new ProductSearchInteractorImpl();
    }
    @Override
    public void getSearchProduct(String device, String query, String rows) {
        if (productSearchView != null){
            productSearchView.showProgress();
        }
        this.productSearchInteractor.search(device, query, rows, new ProductSearchInteractor.OnKeywordListener(){

            @Override
            public void onKeywordError() {
                productSearchView.hideProgress();
            }

            @Override
            public void onSuccess(@NonNull ProductSearchResponse product) {
                Log.v("TKPDRESPONSE", "size " + product.toString());
                productSearchView.setList(product.product);
                productSearchView.hideProgress();
            }

            @Override
            public void onError() {
                if (productSearchView != null) {
                    productSearchView.hideProgress();
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        productSearchView = null;
    }

    @Override
    public void onKeywordError() {
        if (productSearchView != null){
            productSearchView.setKeywordError();
            productSearchView.hideProgress();
        }
    }

    @Override
    public void onSuccess(ProductSearchResponse product) {
        productSearchView.setList(product.product);
        productSearchView.hideProgress();
    }

    @Override
    public void onError() {
        if (productSearchView != null) {
            productSearchView.hideProgress();
        }
    }
}
