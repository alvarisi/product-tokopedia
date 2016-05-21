package com.tokopedia.producttokopedia.network.reponses;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class BaseResponse {
    private JSONObject jresult;
    private String sresult;
    private Object object;
    private Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();
    public static BaseResponse factory(String response){
        JSONObject jb , jresult;
        try {
            jb = new JSONObject(response);
            jresult = jb.getJSONObject("result");
        }catch (JSONException e){
            e.printStackTrace();
            jresult = null;
        }
        BaseResponse bs = new BaseResponse();
        bs.setJresult(jresult);
        return bs;
    }

    public void setJresult(JSONObject jresult) {
        this.jresult = jresult;
        this.sresult = jresult.toString();
    }
//    @SuppressWarnings("unchecked")
    public <T> T convertResult(Class<T> c){
        Log.v("TKPDRESPONSE", jresult.toString());
        if (object == null){
            try {
                this.object = gson.fromJson(this.sresult, c);
                return (T) object;
            }catch (ClassCastException e){
                e.printStackTrace();
                return null;
            }
        }else{
            return(T) object;
        }
    }
}
