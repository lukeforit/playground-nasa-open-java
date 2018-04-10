package com.rabbit.green.nasaopen;

import com.rabbit.green.nasaopen.data.model.PojoObject;
import com.rabbit.green.nasaopen.data.source.IMyDataRepository;
import com.rabbit.green.nasaopen.data.source.IMyDataRestService;
import com.rabbit.green.nasaopen.di.ApiModule;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private MockWebServer mockWebServer;
    private IMyDataRepository repository;
    private IResourceProvider resourceProvider;

    @Before
    public void setup() {
        mockWebServer = new MockWebServer();
        mockWebServer.url(BuildConfig.baseUrl);

        resourceProvider = new TestRecourceProvider();

        ApiModule apiModule = new ApiModule();
        OkHttpClient client = apiModule.provideOkHttpClient(resourceProvider);
        Retrofit retrofit = apiModule.provideRetrofit(client);
        IMyDataRestService restService = apiModule.provideMyDataRestService(retrofit);
        repository = apiModule.provideMyDataRepository(restService);
    }

    @After
    public void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void apiCallTest() throws Exception {
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(200)
                .setBody(resourceProvider.getJsonResource(R.raw.data));

        PojoObject object = repository.getData();

        assertNotNull(object);
    }
}