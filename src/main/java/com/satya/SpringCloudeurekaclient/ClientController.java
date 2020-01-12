package com.satya.SpringCloudeurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired //For Feign
    private MessageClient messageClient;

    @GetMapping("get-greet")
    public String getGreeting() {
        return restTemplate.getForEntity("//EUREKA-SERVER-TEST/greet", String.class).getBody();
    }

    @GetMapping("/services")
    public List<ServiceInstance> getDiscoveryClients() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("EUREKA-SERVER-TEST");

        return serviceInstanceList;
    }

    @GetMapping("get-greet/feign")
    public String getGreetFeign() {
        return messageClient.greet();
    }
}
