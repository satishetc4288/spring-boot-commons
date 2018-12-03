package com.satish.exp.service;

import org.springframework.stereotype.Service;

@Service
public class Accumulator {

    public Integer accumulate(Integer number){
        return number*3;
    }
}
