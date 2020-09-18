package com.leo.provider.rpc;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * 将这个接口作为暴露出去被调用的类
 * 需要加入spring的容器中
 */
@DubboService(version = "1.0.0",timeout = 1000,interfaceClass = HelloDubboService.class)
@Component
public class HelloDubboServiceImpl implements HelloDubboService {
    @Override
    public String say(String name) {
        return "dubbo: hello"+name;
    }
}
