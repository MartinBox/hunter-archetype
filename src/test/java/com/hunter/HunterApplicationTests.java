package com.hunter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// @TestPropertySource("classpath:pay.properties")
@TestPropertySource(properties = {"a:1"})
class HunterApplicationTests {

    @Value("${a}")
    private String a;

    @Test
    void contextLoads() {
        assertTrue(a.equals("1"));
    }

}
