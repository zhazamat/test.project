package org.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TimerInfo {

    public static void main(String[] args) {
     /*       Weather weather=new Weather();
        DataSeries dataSeries=new DataSeries();
        dataSeries.setCloudcover(5);
        dataSeries.setSeeing(2);
        List<DataSeries>dataSeries1=new ArrayList<>();
        dataSeries1.add(dataSeries);
        weather.setDataseries(dataSeries1);
        System.out.println(weather.getDataseries());*/

      String baseUrl = "https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0";
        HttpUrl.Builder httpUrl = HttpUrl.parse(baseUrl).newBuilder();

        httpUrl.addQueryParameter("seeing","7");
        String url = httpUrl.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        Response response;
        {
            try {
                System.out.println("Nachali otpravku zaprosa");
                response = call.execute();
                System.out.println("Poluchili otvet");
                String json = response.body().string();
                System.out.println(json);
                ObjectMapper objectMapper=new ObjectMapper();
                Weather weather=objectMapper.readValue(json,Weather.class);

                System.out.printf("product: %s \n",weather.getProduct());
                System.out.printf("init: %s \n",weather.getInit());
                System.out.printf("dataseries: %s \n",weather.getDataseries());



            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
