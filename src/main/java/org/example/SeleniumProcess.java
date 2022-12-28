package org.example;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumProcess {
    private final WebDriver driver;
    private final Actions actions;

    SeleniumProcess() {
        System.setProperty("webdriver.gecko.driver","F:\\VOsipov\\JavaProjectTests\\AI\\foxdriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        actions = new Actions(driver);
    }

    public void start(String prompt) {
        driver.get("http://127.0.0.1:7860/");
        wait(3000);
        setSettings(prompt);
        //actions.keyDown(Keys.CONTROL).sendKeys(Keys.RETURN).perform();
    }
    public void endSession() {
        driver.quit();
    }

    private void setSettings(String prompt) {
        tabPress(11);
        actions.sendKeys(prompt);
        tabPress(1);
        actions.sendKeys("neg prompt");
        tabPress(9);
        actions.sendKeys(Keys.NUMPAD5, Keys.NUMPAD0);
        tabPress(3);
        actions.sendKeys(Keys.NUMPAD9, Keys.NUMPAD6, Keys.NUMPAD0);
        tabPress(2);
        actions.sendKeys(Keys.NUMPAD1, Keys.NUMPAD2, Keys.NUMPAD8, Keys.NUMPAD0);
        tabPress(4);
        actions.sendKeys(Keys.SPACE).perform();
        tabPress(11);
        actions.sendKeys(Keys.NUMPAD1, Keys.NUMPAD2).perform();
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
