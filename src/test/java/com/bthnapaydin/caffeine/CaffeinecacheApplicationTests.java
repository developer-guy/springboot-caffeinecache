package com.bthnapaydin.caffeine;

import com.bthnapaydin.caffeine.service.MusicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CaffeinecacheApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(CaffeinecacheApplicationTests.class);

    @Autowired
    @Qualifier("musicServiceImpl1")
    private MusicService musicService;

    @Test
    public void contextLoads() {
        logger.info("Context load successfully::");
        assertNotNull(musicService);
    }

    @Test
    public void testingCache() {
        musicService.play("trambone");
        musicService.play("guitar");
        String trambone = musicService.play("trambone");
        int tramboneCount = Integer.parseInt(trambone.split(":")[1]);
        assertThat(tramboneCount, is(1));
    }

}
