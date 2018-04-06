package com.rabbit.green.nasaopen;

import com.rabbit.green.nasaopen.data.model.PojoObject;
import com.squareup.moshi.Moshi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by lbogusz on 14/03/2018.
 */

public class LocalClientInterceptor  implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        PojoObject object = new PojoObject();
        object.setTitle("Fake Item");
        object.setExplanation("This fake item comes from dev flavor, provided by API module dedicated to this flavor without Retrofit");
        object.setUrl("http://milkywaytimes.com/wp-content/uploads/2017/08/PIA17563-1920x1200.jpg");

        Moshi moshi = new Moshi.Builder().build();
        String json = moshi.adapter(PojoObject.class).toJson(object);

        return new Response.Builder()
                .addHeader("content-type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"),
                        json))
                .code(200)
                .message("Mock response")
                .protocol(Protocol.HTTP_1_0)
                .request(chain.request())
                .build();
    }
}

