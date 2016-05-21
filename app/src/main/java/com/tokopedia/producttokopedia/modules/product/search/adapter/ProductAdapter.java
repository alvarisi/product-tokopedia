package com.tokopedia.producttokopedia.modules.product.search.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tokopedia.producttokopedia.R;
import com.tokopedia.producttokopedia.modules.product.search.model.Product;

import java.util.List;

/**
 * Created by Tokopedia01 on 5/21/2016.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    List<Product> products;
    public ProductAdapter(List<Product> products){
        this.products = products;
    }
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent,
                false);
        ProductViewHolder pv = new ProductViewHolder(v);
        return pv;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.tvName.setText(this.products.get(position).getProductName());
        holder.tvPrice.setText(this.products.get(position).getProductPrice());
        holder.tvShopName.setText(this.products.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return this.products.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImage;
        LinearLayout llBadge;
        TextView tvName;
        TextView tvPrice;
        TextView tvShopName;
        public ProductViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
            llBadge = (LinearLayout) itemView.findViewById(R.id.llBadgeContainer);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvShopName = (TextView) itemView.findViewById(R.id.tvShopName);
        }
    }
}