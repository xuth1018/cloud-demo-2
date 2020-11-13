package com.wins.cloud.service.feign;

import com.wins.cloud.service.feign.fallback.DemoFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product", fallback = DemoFallbackImpl.class)
//@RequestMapping(path = "/product")
public interface DemoInterface {

    @RequestMapping(value = "/demo/hello", method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

}
