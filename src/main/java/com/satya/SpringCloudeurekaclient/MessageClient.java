package com.satya.SpringCloudeurekaclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("EUREKA-SERVER-TEST")
public interface MessageClient {

    @RequestMapping(value = "greet", method = RequestMethod.GET)
    String greet();
}
