package com.rabbit.green.nasaopen;

public class TestRecourceProvider implements IResourceProvider {
    @Override
    public String getJsonResource(int id) {
        return "{\n" +
                "  \"copyright\": \"Someone\", \n" +
                "  \"date\": \"2018-04-10\", \n" +
                "  \"explanation\": \"Text\", \n" +
                "  \"hdurl\": \"https://sample.com/sample.jpg\", \n" +
                "  \"media_type\": \"image\", \n" +
                "  \"service_version\": \"v1\", \n" +
                "  \"title\": \"Title\", \n" +
                "  \"url\": \"https://sample.com/sample.jpg\"\n" +
                "}";
    }
}
