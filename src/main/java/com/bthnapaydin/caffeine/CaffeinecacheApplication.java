package com.bthnapaydin.caffeine;

import com.bthnapaydin.caffeine.configuration.CacheConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CacheConfiguration.class)
public class CaffeinecacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaffeinecacheApplication.class, args);
    }
}
