package com.tokopedia.producttokopedia.modules.product.search.presenter;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public interface ProductSearchPresenter {
    void getSearchProduct(String device, String query, String rows);
    void onDestroy();
}
