package org.example;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String fileContent = "";
        try {
            fileContent = Files.readAllLines(Paths.get("C:\\BotToken.txt")).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TelegramBot bot = new TelegramBot(fileContent);

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