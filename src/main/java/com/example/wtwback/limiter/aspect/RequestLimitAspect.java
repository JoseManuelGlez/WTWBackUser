package com.example.wtwback.limiter.aspect;

import com.example.wtwback.limiter.annotation.RequestLimit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class RequestLimitAspect {
    private Map<String, Integer> requests = new ConcurrentHashMap<>();

    @Around("@annotation(requestLimit)")
    public Object limitRequests(ProceedingJoinPoint joinPoint, RequestLimit requestLimit) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        int limit = requestLimit.value();
        long duration = requestLimit.duration() * 1000L;

        long now = System.currentTimeMillis();
        int count = requests.getOrDefault(methodName, 0);

        if (count < limit) {
            requests.put(methodName, count + 1);
            return joinPoint.proceed();
        } else if (now - duration < requests.get(methodName + "-timestamp")) {
            return new ResponseEntity<>("Too many requests", HttpStatus.TOO_MANY_REQUESTS);
        } else {
            requests.put(methodName, 1);
            requests.put(methodName + "-timestamp", (int) now);
            return joinPoint.proceed();
        }
    }
}
