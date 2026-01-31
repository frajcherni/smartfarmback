package com.farm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.farm.prj.SmartFarmApplication;

// ✅ Add the main application class explicitly
@SpringBootTest(classes = SmartFarmApplication.class)
class SmartFarmApplicationTests {
    
    @Test
    void contextLoads() {
    }
}