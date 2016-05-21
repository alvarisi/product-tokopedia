package com.tokopedia.producttokopedia.modules.product.search.view;

import android.content.Intent;

import com.tokopedia.producttokopedia.modules.product.search.model.Product;

import java.util.List;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public interface ProductSearchView {
    void setKeywordError();
    void showProgress();
    void hideProgress();
    void setList(List<Product> products);
    void onSearchEvent(Intent intent);
}
