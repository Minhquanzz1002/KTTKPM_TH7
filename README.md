# KIẾN TRÚC THIẾT KẾ PHẦN MỀM THỰC HÀNH 7
* Docker: Image - Container
* Sử dụng Resilience4j
  * Retry
  * Rate Limiter
  * Circuit Breaker
## Resilience4j
### Retry
```
curl --location 'http://localhost:8080/api/retry/employees'
```
![Retry](https://raw.githubusercontent.com/Minhquanzz1002/KTTKPM_TH7/main/demo/retry.gif)
### Rate Limiter
```
curl --location 'http://localhost:8080/api/rate-limiter/employees'
```
![Rate Limiter](https://raw.githubusercontent.com/Minhquanzz1002/KTTKPM_TH7/main/demo/rate-limiter.gif)
### Circuit Breaker
```
curl --location 'http://localhost:8080/api/circuit-breaker/employees'
```
![Circuit Breaker](https://raw.githubusercontent.com/Minhquanzz1002/KTTKPM_TH7/main/demo/circuit-breaker.gif)
