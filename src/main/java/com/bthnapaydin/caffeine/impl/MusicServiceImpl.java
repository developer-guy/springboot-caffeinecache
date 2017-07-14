package com.bthnapaydin.caffeine.impl;

import com.bthnapaydin.caffeine.service.MusicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"directory", "instruments"})
public class MusicServiceImpl implements MusicService {

    private static Logger log = LoggerFactory.getLogger(MusicServiceImpl.class);
    private static int counter = 0;

    @Cacheable(condition = "#instrument.equals('trambone')")
    @Override
    public String play(String instrument) {
        counter++;
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "playing " + instrument + ":" + counter;
    }
}
