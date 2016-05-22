package com.tokopedia.producttokopedia.modules.product.search.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class Product implements Parcelable {
    @SerializedName("shop_id")
    public int shopId;
    @SerializedName("shop_lucky")
    public String shopLucky;
    @SerializedName("product_id")
    public int productId;
    @SerializedName("condition")
    public String condition;
    @SerializedName("product_price")
    public String productPrice;
    @SerializedName("product_review_count")
    public String productReview;
    @SerializedName("product_sold_count")
    public String productSoldCount;
    @SerializedName("product_name")
    public String productName;
    @SerializedName("product_wholesale")
    public String productWholeSale;
    @SerializedName("preorder")
    public String preorder;
    @SerializedName("product_url")
    public String productUrl;
    @SerializedName("shop_name")
    public String shopName;
    @SerializedName("product_talk_count")
    public String productTalk;
    @SerializedName("shop_location")
    public String shopLocation;
    @SerializedName("is_owner")
    public String isOwner;
    @SerializedName("rate")
    public String rate;
    @SerializedName("product_image")
    public String productImage;
    @SerializedName("shop_url")
    public String shopUrl;
    @SerializedName("product_image_full")
    public String productImageFull;
    @SerializedName("shop_gold_status")
    public String shopGold;

    public Product(){}

    public Product(int shopId, String shopLucky, int productId, String condition,
                   String productPrice, String productReview, String productSoldCount,
                   String productName, String productWholeSale, String preorder,
                   String productUrl, String shopName, String productTalk,
                   String shopLocation, String isOwner, String rate, String productImage,
                   String shopUrl, String productImageFull, String shopGold) {
        this.shopId = shopId;
        this.shopLucky = shopLucky;
        this.productId = productId;
        this.condition = condition;
        this.productPrice = productPrice;
        this.productReview = productReview;
        this.productSoldCount = productSoldCount;
        this.productName = productName;
        this.productWholeSale = productWholeSale;
        this.preorder = preorder;
        this.productUrl = productUrl;
        this.shopName = shopName;
        this.productTalk = productTalk;
        this.shopLocation = shopLocation;
        this.isOwner = isOwner;
        this.rate = rate;
        this.productImage = productImage;
        this.shopUrl = shopUrl;
        this.productImageFull = productImageFull;
        this.shopGold = shopGold;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopLucky() {
        return shopLucky;
    }

    public void setShopLucky(String shopLucky) {
        this.shopLucky = shopLucky;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductReview() {
        return productReview;
    }

    public void setProductReview(String productReview) {
        this.productReview = productReview;
    }

    public String getProductSoldCount() {
        return productSoldCount;
    }

    public void setProductSoldCount(String productSoldCount) {
        this.productSoldCount = productSoldCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductWholeSale() {
        return productWholeSale;
    }

    public void setProductWholeSale(String productWholeSale) {
        this.productWholeSale = productWholeSale;
    }

    public String getPreorder() {
        return preorder;
    }

    public void setPreorder(String preorder) {
        this.preorder = preorder;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProductTalk() {
        return productTalk;
    }

    public void setProductTalk(String productTalk) {
        this.productTalk = productTalk;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public String getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(String isOwner) {
        this.isOwner = isOwner;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    public String getProductImageFull() {
        return productImageFull;
    }

    public void setProductImageFull(String productImageFull) {
        this.productImageFull = productImageFull;
    }

    public String getShopGold() {
        return shopGold;
    }

    public void setShopGold(String shopGold) {
        this.shopGold = shopGold;
    }

    public static final Parcelable.Creator<Product> CREATOR
            = new Product.Creator<Product>(){
        public Product createFromParcel(Parcel in){
            return  new Product(in);
        }
        public Product[] newArray(int size){
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.shopId);
        dest.writeString(this.shopLucky);
        dest.writeInt(this.productId);
        dest.writeString(this.condition);
        dest.writeString(this.productPrice);
        dest.writeString(this.productReview);
        dest.writeString(this.productSoldCount);
        dest.writeString(this.productName);
        dest.writeString(this.productWholeSale);
        dest.writeString(this.preorder);
        dest.writeString(this.productUrl);
        dest.writeString(this.shopName);
        dest.writeString(this.productTalk);
        dest.writeString(this.shopLocation);
        dest.writeString(this.isOwner);
        dest.writeString(this.rate);
        dest.writeString(this.productImage);
        dest.writeString(this.shopUrl);
        dest.writeString(this.productImageFull);
        dest.writeString(this.shopGold);
    }
    private Product(Parcel in) {
        this.shopId = in.readInt();
        this.shopLucky = in.readString();
        this.productId = in.readInt();
        this.condition = in.readString();
        this.productPrice = in.readString();
        this.productReview = in.readString();
        this.productSoldCount = in.readString();
        this.productName = in.readString();
        this.productWholeSale = in.readString();
        this.preorder = in.readString();
        this.productUrl = in.readString();
        this.shopName = in.readString();
        this.productTalk = in.readString();
        this.shopLocation = in.readString();
        this.isOwner = in.readString();
        this.rate = in.readString();
        this.productImage = in.readString();
        this.shopUrl = in.readString();
        this.productImageFull = in.readString();
        this.shopGold = in.readString();
    }
}
