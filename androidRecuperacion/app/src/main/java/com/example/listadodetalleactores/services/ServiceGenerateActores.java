package com.example.listadodetalleactores.services;

import com.example.listadodetalleactores.models.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerateActores {

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = null;

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    private static  HttpLoggingInterceptor loggin = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static<S> S createService (Class<S> serviceClass){
        if (retrofit == null){
            httpClient.addInterceptor(new Interceptor() {

                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("api_key", Constants.API_KEY)
                            .addQueryParameter("language","es-ES")
                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();

                    return chain.proceed(request);
                }
            });

            httpClient.addInterceptor(loggin);
            builder.client(httpClient.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

}
