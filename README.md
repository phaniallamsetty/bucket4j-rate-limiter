# bucket4j-rate-limiter

This project makes use of the library Bucket4J for rate limiting. It is used to configure the rate limiter provided OOTB to the number of tokens to be refilled and the duration for which the tokens are valid. This approach uses a Token Bucket algorithm of rate limiting under the hood.

For testing, I have set 10 as the maximum tokens allowed and we are adding 10 new tokens for every 1 minute. This resets the count of the tokens to 10 each minute, which means within a minute only 10 requests are allowed. If more than 10 requests are made in a span of 1 minute, the RateLimitExceededException is thrown.

- In order to test this service, clone this repo, and run the Java application.
- Once the application is running, use Postman or curl command to make a call to http://localhost:8080/api/getData
- It returns "Here is your data!" as response.
- Repeatedly call the API 10 times. After the 10th time, it will throw the RateLimitExceededException with the message "Too Many Requests" which means any further calls within the span of a minute will be rate limited and will not be allowed.

The repository also has logic to containerize the application using Docker, build it using GitHub Actions, and deploy to GKE.
