package com.example.factorialcache;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FactorialCacheService {

    private final Map<Integer, BigDecimal> factorialMap = new ConcurrentHashMap<>();


    public BigDecimal cachedFactorial(int n) {
        return factorialMap.getOrDefault(n, null);
    }

    public void cacheFactorial(int n, BigDecimal result) {
        factorialMap.put(n, result);
    }
}
