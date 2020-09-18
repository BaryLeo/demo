package com.leo.consumer.controller;

import com.leo.provider.rpc.HelloDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    /**
     * 一般只需要指定版本即可
     * 远程调用的接口，必须是和provider同一个包的接口，这里直接引用provider的项目，一般是引入一个service的jar包
     */
    @DubboReference(version = "1.0.0" )
    HelloDubboService helloDubboService;

    @GetMapping("/")
    public String hello(){
        return helloDubboService.say("Leo");
    }
}
