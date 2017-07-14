package com.bthnapaydin.caffeine.configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.Ticker;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfiguration {


    @Bean
    public CacheManager cacheManager() {
        CaffeineCache instruments = caffeineCache("instruments", ticker(), 30);

        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(Arrays.asList(instruments));
        return simpleCacheManager;
    }


    private CaffeineCache caffeineCache(String name, Ticker ticker, int minuteToExpire) {
        return new CaffeineCache(name, Caffeine.newBuilder().
                expireAfterWrite(minuteToExpire, TimeUnit.MINUTES).
                maximumSize(100).
                ticker(ticker).
                build());
    }


    @Bean
    public Ticker ticker() {
        return Ticker.systemTicker();
    }
}
