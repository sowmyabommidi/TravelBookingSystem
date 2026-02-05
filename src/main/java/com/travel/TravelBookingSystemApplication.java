package com.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.travel.entity")
@EnableJpaRepositories("com.travel.repository")
public class TravelBookingSystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(TravelBookingSystemApplication.class, args);
    }
}
