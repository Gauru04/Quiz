package com.example.SpringTest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    private Integer id;
    private String response;


    public String getResponse() {
        return response;
    }
}