package com.mslearning.user.service.controller;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Objects;

public class DeleteMe {

    public static void main(String args[]){
        String s;
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode root = objectMapper.readTree("{ \"Tag\" : \"value\"}");

            System.out.println(root.path("tag"));
            String value = Objects.requireNonNull(root.path("Tag").asText(),"null");
            System.out.println(value);
            System.out.println("hello world");
        } catch (JsonProcessingException e) {
            System.out.println(e.toString());
        }

    }
}
