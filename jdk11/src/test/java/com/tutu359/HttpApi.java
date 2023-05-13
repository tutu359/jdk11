package com.tutu359;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HttpApi {

    @Test
    public void test1() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com/")).build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = httpClient.send(request, bodyHandler);

        String body = response.body();
        System.out.println("body = " + body);
    }

    @Test
    public void test2() throws InterruptedException, ExecutionException, TimeoutException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com/")).build();

        HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandlers.ofString();

        CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, bodyHandler);

        HttpResponse<String> response = future.get(5, TimeUnit.SECONDS);

        String body = response.body();
        System.out.println("body = " + body);
    }

}
