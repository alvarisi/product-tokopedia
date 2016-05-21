package com.tokopedia.producttokopedia.modules.product.search.interactor;

import android.support.annotation.NonNull;

import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;

import org.json.JSONObject;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public interface ProductSearchInteractor {
    interface OnKeywordListener{
        void onKeywordError();
        void onSuccess(@NonNull ProductSearchResponse product);
        void onError();
    }

    void search(String device, String query, String rows, OnKeywordListener onKeywordListener);
}
