package com.leo.provider.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService(version = "1.0.0",timeout = 1000,interfaceClass = HelloDubboService.class)
@Component
public class HelloDubboServiceImpl implements HelloDubboService {
    @Override
    public String say(String name) {
        return "dubbo: hello"+name;
    }
}
