package com.rabbit.green.nasaopen;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class MockResourceProvider implements IResourceProvider {

    private static final String EMPTY_JSON = "{}";

    private final Context context;

    public MockResourceProvider(Context context) {
        this.context = context;
    }

    @Override
    public String getJsonResource(int id) {
        InputStream is = context.getResources().openRawResource(id);
        try {
            byte[] content = new byte[is.available()];
            return is.read(content) >= 0 ? new String(content) : EMPTY_JSON;
        } catch (IOException e) {
            e.printStackTrace();
            return EMPTY_JSON;
        }
    }
}
