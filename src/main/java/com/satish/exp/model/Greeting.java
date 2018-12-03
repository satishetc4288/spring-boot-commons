package com.satish.exp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting {

    private  long id;
    private  String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }
}