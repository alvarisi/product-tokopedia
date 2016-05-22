package com.tokopedia.producttokopedia.modules.product.search.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tokopedia.producttokopedia.modules.product.search.view.ProductSearchView;
import com.tokopedia.producttokopedia.modules.product.search.interactor.ProductSearchInteractor;
import com.tokopedia.producttokopedia.modules.product.search.interactor.ProductSearchInteractorImpl;
import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class ProductSearchPresenterImpl implements ProductSearchPresenter{
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
                productSearchView.setList(product);
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
    public void getMoreProduct(String url)  {
        try {
            this.productSearchInteractor.moreProduct(url, new ProductSearchInteractor.onLoadMoreListener() {
                @Override
                public void onSuccess(@NonNull ProductSearchResponse product) {
                    productSearchView.setMoreList(product);
                    productSearchView.hideProgress();
                }

                @Override
                public void onError() {
                    Log.v("TKPD", "GAGAGAL");
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDestroy() {
        productSearchView = null;
    }

}
