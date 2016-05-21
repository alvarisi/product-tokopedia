package com.tokopedia.producttokopedia.network.reponses;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Tokopedia01 on 5/20/2016.
 */
public class PagingResponse implements Parcelable {
    @SerializedName("uri_next")
    public String uriNext;
    @SerializedName("uri_previous")
    public String uriPrevious;

    public PagingResponse() {
    }
    public PagingResponse(Parcel in) {
        this.uriNext = in.readString();
        this.uriPrevious = in.readString();
    }

    public String getUriNext() {
        return uriNext;
    }

    public void setUriNext(String uriNext) {
        this.uriNext = uriNext;
    }

    public String getUriPrevious() {
        return uriPrevious;
    }

    public void setUriPrevious(String uriPrevious) {
        this.uriPrevious = uriPrevious;
    }
    public static final Parcelable.Creator<PagingResponse> CREATOR
            = new PagingResponse.Creator<PagingResponse>(){
        public PagingResponse createFromParcel(Parcel in){
            return  new PagingResponse(in);
        }
        public PagingResponse[] newArray(int size){
            return new PagingResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uriNext);
        dest.writeString(this.uriPrevious);
    }
}
