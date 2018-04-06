package com.rabbit.green.nasaopen.data.source;

import com.rabbit.green.nasaopen.BuildConfig;
import com.rabbit.green.nasaopen.data.model.PojoObject;

import java.io.IOException;

public class MyDataRepository implements IMyDataRepository {

    private IMyDataRestService dataRestService;

    public MyDataRepository(IMyDataRestService dataRestService) {
        this.dataRestService = dataRestService;
    }

    @Override
    public PojoObject getData() {
        try {
            return dataRestService.getData(BuildConfig.apiKey).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
