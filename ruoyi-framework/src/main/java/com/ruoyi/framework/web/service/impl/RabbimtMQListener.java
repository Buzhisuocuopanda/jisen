package com.ruoyi.framework.web.service.impl;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruoyi.system.domain.GsGoodsSn;
import com.ruoyi.system.domain.vo.InwuquVo;
import lombok.SneakyThrows;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RabbimtMQListener {
    @Resource
    protected RestHighLevelClient restHighLevelClient;



    @SneakyThrows
    @RabbitListener(queues = "boot_queue")
    public void ListenerQueue(@Payload GsGoodsSn gs) {
        //System.out.println(message);

   //     List<GsGoodsSn> stringList1 = JSON.parseObject(s).getJSONArray("data").toJavaList(GsGoodsSn.class);

        //json字符串转成Java对象
        List<GsGoodsSn> gsGoodsSns=new ArrayList<>();
        gsGoodsSns.add(gs);
        add(gsGoodsSns);

        System.out.println(gs);

    }


    private void add( List<GsGoodsSn> gsGoodsSns){
        BulkRequest bulkRequest = new BulkRequest();
        gsGoodsSns.stream().forEach(x -> {
            bulkRequest.add(new IndexRequest("888").source(JSON.toJSONString(x), XContentType.JSON));
        });
        BulkResponse responses=null;
        try {
            responses = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
