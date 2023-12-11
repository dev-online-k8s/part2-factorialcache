package com.example.factorialcache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class FactorialCacheController {

    @Value("${factorial.language}")
    private String language;

    @Value("${factorial.api-key}")
    private String apiKey;

    @GetMapping("/factorial/{n}")
    public String calculateFactorial(@PathVariable("n") int n, @RequestParam(value = "key", required = false) String key) {
        if (n>10) {
            if (!apiKey.equals(key)) {
                throw new IncorrectApiKeyException("To calculate more than 10 factorials, you need the correct api-key");
            }
        }

        BigDecimal result = BigDecimal.ONE;

        return switch (language) {
            case "ko" -> n + " 팩토리얼은 " + result + " 입니다";
            case "en" -> "the factorial of " + n + " is " + result;
            default -> "Unsupported Language";
        };
    }
}
