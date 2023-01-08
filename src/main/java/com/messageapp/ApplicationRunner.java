package com.messageapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;

@SpringBootApplication
@EntityScan(basePackages = "com.messageapp.model")
public class ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    public void handleApplicationStartEvent(ServletWebServerInitializedEvent event){
        int applicationRunningPort = event.getWebServer().getPort();
        System.out.println("use swagger url: http://localhost:"+applicationRunningPort+"/swagger-ui.html");
    }
}
