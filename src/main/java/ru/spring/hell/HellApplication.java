package ru.spring.hell;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellApplication {

    private static final Log log = LogFactory.getLog(HellApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HellApplication.class, args);
    }

}
