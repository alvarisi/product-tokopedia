package com.tokopedia.producttokopedia.network.Transformator;

import com.tokopedia.producttokopedia.network.reponses.BaseResponse;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Tokopedia01 on 5/19/2016.
 */
public class BaseTransformator extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if(BaseResponse.class == type){
            return new Converter<ResponseBody, BaseResponse>() {
                @Override
                public BaseResponse convert(ResponseBody value) throws IOException {
                    return BaseResponse.factory(value.string());
                }
            };
        }
        return null;
    }
}
