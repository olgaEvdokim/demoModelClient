package com.example.demo.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder().setLenient().create();
    }

    @Bean
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create(gson());
    }
}
