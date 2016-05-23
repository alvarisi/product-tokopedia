package com.tokopedia.producttokopedia.modules.product.search.activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.support.v7.widget.SearchView;
import com.tokopedia.producttokopedia.R;
import com.tokopedia.producttokopedia.modules.product.search.adapter.ProductAdapter;
import com.tokopedia.producttokopedia.modules.product.search.presenter.ProductSearchPresenter;
import com.tokopedia.producttokopedia.modules.product.search.presenter.ProductSearchPresenterImpl;
import com.tokopedia.producttokopedia.modules.product.search.view.ProductSearchView;
import com.tokopedia.producttokopedia.modules.product.search.model.Product;
import com.tokopedia.producttokopedia.network.reponses.PagingResponse;
import com.tokopedia.producttokopedia.network.reponses.ProductSearchResponse;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductSearchActivity extends AppCompatActivity implements ProductSearchView,
        SearchView.OnQueryTextListener, ProductAdapter.EndlessScrollListener
{
    final private static String DEVICE = "android",
                                ROWS = "2"
            ;
    private String keyword;
    private List<Product> products = new ArrayList<Product>();
    private PagingResponse pagingResponse = new PagingResponse();



    @Bind(R.id.pbProgress)
    ProgressBar progressBar;
    @Bind(R.id.rvListProduct)
    RecyclerView rvListProduct;

    private ProductSearchPresenter presenter;
    private ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new ProductSearchPresenterImpl(this);
        adapter = new ProductAdapter(getApplicationContext(), this.products);
        adapter.setEndlessScrollListener(this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        rvListProduct.setLayoutManager(layoutManager);
        rvListProduct.setItemAnimator(new DefaultItemAnimator());
        rvListProduct.setHasFixedSize(true);
        rvListProduct.setAdapter(adapter);

        if (getIntent()!=null)
            onSearchEvent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        onSearchEvent(intent);
    }

    @Override
    public void setKeywordError() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setList(ProductSearchResponse productSearchResponse) {
        if (productSearchResponse != null)
        {
            if (productSearchResponse.getProduct().size() > 0){
                this.products.clear();
                this.products.addAll(productSearchResponse.getProduct());
                adapter.notifyDataSetChanged();
                this.pagingResponse = productSearchResponse.getPagingResponse();
            }
        }

    }

    @Override
    public void onSearchEvent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())){
            keyword = intent.getStringExtra(SearchManager.QUERY);
            presenter.getSearchProduct(DEVICE, keyword, ROWS);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem menuItem = menu.findItem(R.id.search);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView sv = (SearchView) menuItem.getActionView();
        sv.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        sv.setIconifiedByDefault(true);
        sv.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
    @Override
    public void setMoreList(ProductSearchResponse productSearchResponse) {
        if (productSearchResponse != null)
        {
            if (productSearchResponse.getProduct().size() > 0){
                this.products.addAll(productSearchResponse.getProduct());
                int curSize = adapter.getItemCount();
                adapter.notifyDataSetChanged();
                this.pagingResponse = productSearchResponse.getPagingResponse();
            }
        }
    }

    @Override
    public boolean onLoadMore(int position) throws MalformedURLException, UnsupportedEncodingException {
        if (!pagingResponse.getUriNext().isEmpty())
            presenter.getMoreProduct(pagingResponse.getUriNext());
        return false;
    }
}
