package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class NewStudent {
    final String Name;
    final String number;
    final String grupa;
    @JsonCreator
    public NewStudent(@JsonProperty("name") String name,
                      @JsonProperty("number") String number, @JsonProperty("grupa") String grupa) {
        this.Name = name;
        this.number = number;
        this.grupa = grupa;
    }
}
