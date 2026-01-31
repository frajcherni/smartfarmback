package com.farm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.farm.prj.SmartFarmApplication;  // Import this

// ✅ CRITICAL FIX: Add (classes = SmartFarmApplication.class)
@SpringBootTest(classes = SmartFarmApplication.class)
@ActiveProfiles("test")
class SmartFarmApplicationTests {
    
    @Test
    void contextLoads() {
    }
}