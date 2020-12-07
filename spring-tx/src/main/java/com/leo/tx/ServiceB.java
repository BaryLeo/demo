package com.leo.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceB {

    @Transactional(propagation = Propagation.SUPPORTS)
    public void methodB(){

    }
}
