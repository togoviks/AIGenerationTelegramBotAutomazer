package org.example;
import java.io.File;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;

public class Processor{
    private TelegramBot bot;

    public Processor(TelegramBot newBot) {
        this.bot = newBot;
    }

    public void process(Update update) {
        Long id = update.message().chat().id();
        String text = update.message().text();

        SeleniumProcess generate = new SeleniumProcess();
        generate.start(text);
        bot.execute(new SendMessage(id, "Генерация началась"));
        wait(5000);
        File photo = new File("F:\\VOsipov\\JavaProjectTests\\AI\\stable-diffusion-webui\\log\\123.png");
        bot.execute(new SendPhoto(id, photo));
        generate.endSession();
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

