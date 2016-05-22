package com.tokopedia.producttokopedia.modules.product.search.interactor;

import android.support.annotation.NonNull;

import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public interface ProductSearchInteractor {
    interface OnKeywordListener{
        void onKeywordError();
        void onSuccess(@NonNull ProductSearchResponse product);
        void onError();
    }
    interface onLoadMoreListener{
        void onSuccess(@NonNull ProductSearchResponse product);
        void onError();
    }

    void search(String device, String query, String rows, OnKeywordListener onKeywordListener);
    void moreProduct(String url, onLoadMoreListener listener) throws MalformedURLException, UnsupportedEncodingException;
}
