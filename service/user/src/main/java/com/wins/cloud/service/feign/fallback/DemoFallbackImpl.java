package com.wins.cloud.service.feign.fallback;

import com.wins.cloud.service.feign.DemoInterface;
import org.springframework.stereotype.Component;

@Component
public class DemoFallbackImpl implements DemoInterface {

    @Override
    public String hello(String name) {
        return "service fail";
    }
}
