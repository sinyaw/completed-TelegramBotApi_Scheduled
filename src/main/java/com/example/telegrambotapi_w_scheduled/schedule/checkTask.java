package com.example.telegrambotapi_w_scheduled.schedule;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.UUID;


@Component
@Slf4j
public class checkTask {

     //https://www.baeldung.com/spring-scheduled-tasks
     /** "sec min hr date mth ?"
     * this "1 * * * * ?" mean when step on time 01 sec will do.
     * this "0/1 * * * * ?" mean 1 sec will do.
     */
    @Scheduled(cron = "1 * * * * ?")
    public void message() {

        //https://core.telegram.org/bots/samples
        //https://github.com/pengrad/java-telegram-bot-api
        TelegramBot bot = new TelegramBot("5325758873:AAHJHxcnSiERy8VuxOPqPjQ5qfIHrmOpi8M");

        String test = "Now it is " + LocalTime.now() + ": " + UUID.randomUUID();
        //log.info("check message:{}", test);

        SendMessage request = new SendMessage("1564501412", test)
                .parseMode(ParseMode.HTML)
                .disableWebPagePreview(true)
                .disableNotification(true)
                .replyToMessageId(1)
                .replyMarkup(new ForceReply());

// sync
        SendResponse sendResponse = bot.execute(request);
        boolean ok = sendResponse.isOk();
        if (ok) {
            Message message = sendResponse.message();
            log.info("check message:{}",message.text());
        }

// async
//        bot.execute(request, new Callback<SendMessage, SendResponse>() {
//            @Override
//            public void onResponse(SendMessage request, SendResponse response) {
//
//            }
//
//            @Override
//            public void onFailure(SendMessage request, IOException e) {
//
//            }
//        });
    }
}
