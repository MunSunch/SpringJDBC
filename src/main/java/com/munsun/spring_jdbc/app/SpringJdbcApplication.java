package com.munsun.spring_jdbc.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("munsun " + "admin " + "ADMIN " + "ACTIVE");
        System.out.println("kol2023 " + "12345 " + "USER " + "ACTIVE");
        System.out.println("lololo " + "lololo " + "USER " + "REMOVED");
        System.out.println();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);
    }
}
