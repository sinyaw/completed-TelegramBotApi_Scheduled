package com.example.telegrambotapi_w_scheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class TelegramBotApiWScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApiWScheduledApplication.class, args);
    }

}
