package com.example.esdemo.controller;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static com.example.esdemo.config.ElasticSearchConfig.ES_INDEX;

/**
 * @program: es-demo
 * @description:
 * @author: aleo.liu
 * @create: 2021-01-04 19:52
 **/
@RestController
public class DocController {
    @Autowired
    public RestHighLevelClient restHighLevelClient;

    @GetMapping("/api/create/index")
    public void createIndex() throws IOException {
        //创建索引 请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(ES_INDEX);
        //执行请求
        CreateIndexResponse response = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 索引类似于库，只能判断存不存在
     * @throws IOException
     */
    @GetMapping("/api/get/index")
    public void getIndex() throws IOException {
        //创建请求
        GetIndexRequest getIndexRequest = new GetIndexRequest(ES_INDEX);
        //执行请求
        boolean response = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @GetMapping("/api/delete/index")
    public void deleteIndex() throws IOException {
        //创建请求
        DeleteIndexRequest indexRequest = new DeleteIndexRequest(ES_INDEX);
        //执行请求
        AcknowledgedResponse response = restHighLevelClient.indices().delete(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }
}

