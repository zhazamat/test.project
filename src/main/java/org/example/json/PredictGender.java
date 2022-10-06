package org.example.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class PredictGender { static Scanner scanner=new Scanner(System.in);
public  static void getGenderizeIO(){
    String baseUrl = "https://api.genderize.io/";
    HttpUrl.Builder httpUrl = HttpUrl.parse(baseUrl).newBuilder();
    httpUrl.addQueryParameter("name",scanner.nextLine());
    String url = httpUrl.build().toString();

    Request request = new Request.Builder()
            .url(url)
            .build();
    OkHttpClient okHttpClient = new OkHttpClient();
    Call call = okHttpClient.newCall(request);
    Response response;
    {
        try {
            response = call.execute();
            String json = response.body().string();
           // System.out.println(json);
            ObjectMapper objectMapper=new ObjectMapper();
            Person person=objectMapper.readValue(json,Person.class);
            System.out.printf("person name: %s \n",person.getName());
            System.out.printf("count: %s \n",person.getCount());
            System.out.printf("probability: %s \n",person.getProbability());
            if(person.getGender().equals("female")){
                System.out.printf("gender: %s \n","J");
            }else{
                System.out.printf("gender: %s \n","M");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
public static void getAgeIO(){
    String baseUrl = "https://api.agify.io/";
    HttpUrl.Builder httpUrl = HttpUrl.parse(baseUrl).newBuilder();

    httpUrl.addQueryParameter("name",scanner.nextLine());
    String url = httpUrl.build().toString();

    Request request = new Request.Builder()
            .url(url)
            .build();
    OkHttpClient okHttpClient = new OkHttpClient();
    Call call = okHttpClient.newCall(request);
    Response response;
    {
        try {
        //    System.out.println("Nachali otpravku zaprosa");
            response = call.execute();
       //     System.out.println("Poluchili otvet");
            String json = response.body().string();
         //   System.out.println(json);
            ObjectMapper objectMapper=new ObjectMapper();
            Person person=objectMapper.readValue(json,Person.class);
            System.out.printf("person name: %s \n",person.getName());
            System.out.printf("count: %s \n",person.getCount());
            System.out.printf("age: %s \n",person.getAge());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
  public static void main(String[] args) {
      System.out.println("---------------Gender------------------");
     getGenderizeIO();
      System.out.println("---------------Age---------------------");
     getAgeIO();
  }
}
