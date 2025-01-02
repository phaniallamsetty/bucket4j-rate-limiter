package com.pallamsetty.bucket4j_rate_limiter.controllers;

import com.pallamsetty.bucket4j_rate_limiter.exceptions.RateLimitExceededException;
import com.pallamsetty.bucket4j_rate_limiter.ratelimiter.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    private final RateLimiterService rateLimiter;

    @Autowired
    public HelloWorldController(RateLimiterService rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/data")
    public String getData() {
        if(rateLimiter.tryConsume()) {
            return "Here is the data!";
        }
        throw new RateLimitExceededException();
    }
}
