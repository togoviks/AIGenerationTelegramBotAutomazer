package org.example;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

public class Main {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("5895685856:AAHT2hlqoX4iOcncSf3Ad1ivLtiB6G52Rxw");

        Processor processor = new Processor(bot);

        bot.setUpdatesListener(list -> {
            try {
                list.forEach(processor::process);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
        System.out.println();
    }
}