package com.example.esdemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: es-demo
 * @description:
 * @author: aleo.liu
 * @create: 2021-01-04 19:40
 **/
@Configuration
public class ElasticSearchConfig {

    public static final String ES_INDEX = "aleo_index";
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        return new RestHighLevelClient(
                //看是不是集群，每台实例配置一个HttpHost
                RestClient.builder(
                        new HttpHost("localhost",9200,"http"),
                        new HttpHost("localhost",9201,"http")
                )
        );
    }
}

