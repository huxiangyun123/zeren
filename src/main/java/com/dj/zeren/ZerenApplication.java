package com.dj.zeren;

import com.dj.zeren.utils.ServiceAutoLoad;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZerenApplication {

    public static void main(String[] args) {

        ServiceAutoLoad.initialization();
        SpringApplication.run(ZerenApplication.class, args);
    }

}
