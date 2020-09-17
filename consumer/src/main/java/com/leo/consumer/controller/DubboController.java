package com.leo.consumer.controller;

import com.leo.provider.rpc.HelloDubboService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {

    @DubboReference(version = "1.0.0")
    HelloDubboService helloDubboService;

    @GetMapping("/")
    public String hello(){
        return helloDubboService.say("Leo");
    }
}
