package com.tokopedia.producttokopedia.network.reponses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.tokopedia.producttokopedia.modules.product.search.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class ProductSearchResponse implements Parcelable {
    @SerializedName("products")
    public List<Product> product;
    @SerializedName("search_url")
    public String searchUrl;
    @SerializedName("share_url")
    public String shareUrl;
    @SerializedName("st")
    public String st;
    @SerializedName("has_catalog")
    public String hasCatalog;
    @SerializedName("hashtag")
    public String hashtag;
    @SerializedName("breadcrumb")
    public String breadcrumb;
    @SerializedName("department_id")
    public String departmentId;
    @SerializedName("locations")
    public String locations;
    @SerializedName("paging")
    public PagingResponse pagingResponse;

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public ProductSearchResponse(List<Product> product, String searchUrl,
                                 String shareUrl, String st, String hasCatalog, String hashtag,
                                 String breadcrumb, String departmentId, String locations,
                                 PagingResponse pagingResponse) {
        this.product = product;
        this.searchUrl = searchUrl;
        this.shareUrl = shareUrl;
        this.st = st;
        this.hasCatalog = hasCatalog;
        this.hashtag = hashtag;
        this.breadcrumb = breadcrumb;
        this.departmentId = departmentId;
        this.locations = locations;
        this.pagingResponse = pagingResponse;
    }

    public PagingResponse getPagingResponse() {
        return pagingResponse;
    }

    public void setPagingResponse(PagingResponse pagingResponse) {
        this.pagingResponse = pagingResponse;
    }



    public String getSearchUrl() {
        return searchUrl;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getHasCatalog() {
        return hasCatalog;
    }

    public void setHasCatalog(String hasCatalog) {
        this.hasCatalog = hasCatalog;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getBreadcrumb() {
        return breadcrumb;
    }

    public void setBreadcrumb(String breadcrumb) {
        this.breadcrumb = breadcrumb;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.product);
        dest.writeString(this.searchUrl);
        dest.writeString(this.st);
        dest.writeString(this.hasCatalog);
        dest.writeString(this.hashtag);
        dest.writeString(this.breadcrumb);
        dest.writeString(this.departmentId);
        dest.writeString(this.locations);
        dest.writeString(this.hashtag);
        dest.writeParcelable(this.pagingResponse, flags);
    }
    public static final Parcelable.Creator<ProductSearchResponse> CREATOR
            = new ProductSearchResponse.Creator<ProductSearchResponse>(){
        public ProductSearchResponse createFromParcel(Parcel in){
            return  new ProductSearchResponse(in);
        }
        public ProductSearchResponse[] newArray(int size){
            return new ProductSearchResponse[size];
        }
    };
    public ProductSearchResponse(Parcel in) {
        this.product = new ArrayList<Product>();
        in.readTypedList(this.product, Product.CREATOR);
        this.searchUrl = in.readString();
        this.st = in.readString();
        this.hasCatalog = in.readString();
        this.hashtag = in.readString();
        this.breadcrumb = in.readString();
        this.departmentId = in.readString();
        this.locations = in.readString();
        this.hashtag = in.readString();
        this.pagingResponse = in.readParcelable(PagingResponse.class.getClassLoader());
    }
}
