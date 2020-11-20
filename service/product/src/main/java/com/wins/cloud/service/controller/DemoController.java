package com.wins.cloud.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @Value("${boo}")
    private String foo;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name){
        System.out.println(foo);
        return "hello "+name;
    }

    @RequestMapping(value = "/hystrixTest", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "testFail")
    public String test(){
        int i = 1/0;
        return "hystrix test";
    }

    public String testFail(){
        return "hystrix test fail";
    }

}
