package com.rabbit.green.nasaopen;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LocalClientInterceptor implements Interceptor {

    private IResourceProvider resourceProvider;

    public LocalClientInterceptor(IResourceProvider resourceProvider) {
        this.resourceProvider = resourceProvider;
    }

    @Override
    public Response intercept(Chain chain) {
        return new Response.Builder()
                .addHeader("content-type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"),
                        resourceProvider.getJsonResource(R.raw.data)))
                .code(200)
                .message("Mock response")
                .protocol(Protocol.HTTP_1_0)
                .request(chain.request())
                .build();
    }
}

