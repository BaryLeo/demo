package com.example.esdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.esdemo.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.esdemo.config.ElasticSearchConfig.ES_INDEX;

/**
 * @program: es-demo
 * @description:
 * @author: aleo.liu
 * @create: 2021-01-04 19:50
 **/
@RestController
public class IndexController {

    @Autowired
    public RestHighLevelClient restHighLevelClient;


    @GetMapping("/api/create/doc")
    public void createDoc() throws IOException {
        //数据
        User user = new User();
        user.setName("aleo");
        user.setAge(21);
        //创建请求
        IndexRequest indexRequest = new IndexRequest(ES_INDEX);
        //设置规则，put /index-name/_doc-name/id
        //不写id，会生成随机id
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.MINUS_ONE);
        //将数据配置的request中
        indexRequest.source(JSONObject.toJSONString(user),XContentType.JSON);
        //执行请求
        IndexResponse response = restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     * 批量增删改查
     * @throws IOException
     */
    @GetMapping("/api/bulk/delete/doc")
    public void bulkCreateDoc() throws IOException {
        BulkRequest request = new BulkRequest();

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("aleo",18));
        users.add(new User("ximu",18));

        for (int i = 0;i<users.size();i++){
            //不写id，会生成随机id
            //这里的IndexRequest可以缓存对应操作的request，即可完成批量增删改查
            request.add(new IndexRequest(ES_INDEX).id(""+i).source(JSONObject.toJSONString(users.get(i)),XContentType.JSON));
        }

        BulkResponse response = restHighLevelClient.bulk(request,RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @GetMapping("/api/get/doc")
    public void getDoc() throws IOException {
        GetRequest request = new GetRequest(ES_INDEX,"1");
        GetResponse response = restHighLevelClient.get(request,RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @GetMapping("/api/update/doc")
    public void updateDoc() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest(ES_INDEX,"1");
        User user = new User();
        user.setName("Ximu");
        user.setAge(18);

        //填入数据
        updateRequest.doc(JSONObject.toJSONString(user),XContentType.JSON);
        UpdateResponse response = restHighLevelClient.update(updateRequest,RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @GetMapping("/api/delete/doc")
    public void deleteDoc() throws IOException {
        DeleteRequest request = new DeleteRequest(ES_INDEX,"1");

        DeleteResponse response = restHighLevelClient.delete(request,RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    @GetMapping("/api/search/doc")
    public void searchDoc() throws IOException {
        SearchRequest searchRequest = new SearchRequest(ES_INDEX);
        //查询构建器
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置查询条件，其他查询方式也是类似于此
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name","aleo");
        //嵌入查询条件
        sourceBuilder.query(termQueryBuilder);
        //设置查询分页，可做可不做
        sourceBuilder.from(0);
        sourceBuilder.size(15);
        //数据嵌入URL
        searchRequest.source(sourceBuilder);
        //执行查询
        SearchResponse response = restHighLevelClient.search(searchRequest,RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }
}

