package com.pallamsetty.bucket4j_rate_limiter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
public class RateLimitExceededException extends RuntimeException {
    public RateLimitExceededException() {
        super("Rate limit exceeded. Please try again later.");
    }
}
