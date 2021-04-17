package tech.anteeone.beatsell.repositories.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tech.anteeone.beatsell.utils.exceptions.ApiException;

import java.io.IOException;

@Repository
public class ApiRepositoryImpl implements  ApiRepository {

    private static final String API_URL =
            "https://binaryjazz.us/wp-json/genrenator/v1/genre/";

    @Autowired
    OkHttpClient okHttpClient;

    @Autowired
    Logger logger;

    public String get() throws ApiException {
        Request request = new Request
                .Builder()
                .url(API_URL)
                .build();
        try(Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            logger.error("Api Error",e);
            throw new ApiException(e);
        }
    }

}
