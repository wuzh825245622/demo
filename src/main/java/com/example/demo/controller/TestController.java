package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestController.class);
    @GetMapping("/test")
    public  String  test(){
        log.info("2222222222请求成功22222222！");
        return "hello----20210329--89894444333";
    }

}
