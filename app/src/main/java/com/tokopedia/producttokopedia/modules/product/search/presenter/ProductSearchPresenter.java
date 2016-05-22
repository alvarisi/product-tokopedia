package com.tokopedia.producttokopedia.modules.product.search.presenter;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public interface ProductSearchPresenter {
    void getSearchProduct(String device, String query, String rows);
    void getMoreProduct(String url) throws MalformedURLException, UnsupportedEncodingException;
    void onDestroy();
}
