package com.leo.tx;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceA {

    @Transactional
    public void methodA(){

    }
}
