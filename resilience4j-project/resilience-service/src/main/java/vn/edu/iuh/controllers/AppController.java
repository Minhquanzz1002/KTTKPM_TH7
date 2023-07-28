package vn.edu.iuh.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.models.Employee;
import vn.edu.iuh.utils.CustomPageImpl;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Log4j2
public class AppController {
    private final RestTemplate restTemplate;

    @GetMapping("/retry/employees")
    @Retry(name = "api", fallbackMethod = "fallback")
    public ResponseEntity<?> getAllWithRetry() {
        return restTemplate.exchange("http://localhost:8082/api/employees", HttpMethod.GET, null, new ParameterizedTypeReference<CustomPageImpl<Employee>>() {});
    }

    @GetMapping("/rate-limiter/employees")
    @RateLimiter(name = "api", fallbackMethod = "fallback")
    public ResponseEntity<?> getAllWithRateLimiter() {
        return restTemplate.exchange("http://localhost:8082/api/employees", HttpMethod.GET, null, new ParameterizedTypeReference<CustomPageImpl<Employee>>() {});
    }

    @GetMapping("/circuit-breaker/employees")
    @CircuitBreaker(name = "api", fallbackMethod = "fallback")
    public ResponseEntity<?> getAllWithCircuitBreaker() {
        return restTemplate.exchange("http://localhost:8082/api/employees", HttpMethod.GET, null, new ParameterizedTypeReference<CustomPageImpl<Employee>>() {});
    }

    public ResponseEntity<Object> fallback(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
