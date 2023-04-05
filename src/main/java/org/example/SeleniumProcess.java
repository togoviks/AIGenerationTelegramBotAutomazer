package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumProcess {
    private final WebDriver driver;
    private final Actions actions;

    SeleniumProcess() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Manofest\\IdeaProjects\\BrowserTest\\chromedriver.exe");
        driver = new ChromeDriver();
        actions = new Actions(driver);
    }

    public void start(String prompt) {
        driver.get("http://127.0.0.1:7860/");
        wait(3000);
        setSettings(prompt);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).perform();
    }


    public void endSession() {
        driver.quit();
    }

    private void setSettings(String prompt) {
        tabPress(12);
        actions.sendKeys(prompt);
        tabPress(1);
        actions.sendKeys("EasyNegative");
        tabPress(10);
        actions.sendKeys(Keys.NUMPAD2, Keys.NUMPAD0 );
        tabPress(2);
        actions.sendKeys(Keys.NUMPAD5, Keys.NUMPAD1, Keys.NUMPAD2);
        tabPress(2);
        actions.sendKeys(Keys.NUMPAD6, Keys.NUMPAD4, Keys.NUMPAD0);
        tabPress(7);
        actions.sendKeys(Keys.NUMPAD1, Keys.NUMPAD2);
        tabPress(8);
        actions.sendKeys(Keys.SPACE).perform();
    }

    private void tabPress(int num) {
        for (int i = 0; i < num; i++) {
            actions.sendKeys(Keys.TAB).perform();
        }
    }

    private void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
