package org.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Request;

import java.net.HttpURLConnection;

public class OkHttp {
    String baseUrl="https://api.agify.io";

    Request request=new Request.Builder().url(baseUrl).build();

    ObjectMapper objectMapper=new ObjectMapper();
}
