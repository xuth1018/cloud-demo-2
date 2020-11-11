package com.wins.cloud.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product")
@RequestMapping("/product")
public interface DemoInterface {

    @RequestMapping(value = "/demo/hello", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}
