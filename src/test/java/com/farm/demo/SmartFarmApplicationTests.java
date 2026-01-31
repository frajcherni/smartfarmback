package com.farm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.farm.prj.SmartFarmApplication;

@SpringBootTest(classes = SmartFarmApplication.class)  // ✅ ADD THIS
@ActiveProfiles("test")
class SmartFarmApplicationTests {
    
    @Test
    void contextLoads() {
    }
}