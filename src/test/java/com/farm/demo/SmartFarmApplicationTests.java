package com.farm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.farm.prj.SmartFarmApplication;

// ✅ Add the main application class explicitly

@SpringBootTest
@ActiveProfiles("test")  // Make sure this is present
class SmartFarmApplicationTests {
    
    @Test
    void contextLoads() {
    }
}