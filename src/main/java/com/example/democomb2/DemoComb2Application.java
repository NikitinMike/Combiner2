package com.example.democomb2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DemoComb2Application {
//    @Autowired
    static WordRepo wordRepo;

    public static void main(String[] args) {
//        SpringApplication.run(DemoComb2Application.class, args);
        wordRepo = SpringApplication.run(DemoComb2Application.class).getBean(WordRepo.class);
        System.out.println(wordRepo);
    }

}
