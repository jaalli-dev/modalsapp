package com.example.modals2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Modals2Application {

    public static void main(String[] args) {

//        SpringApplication.run(Modals2Application.class, args);
        SpringApplication application = new SpringApplication(Modals2Application.class);

        application.run(args);
    }

}
