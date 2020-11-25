package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","E:\\school\\selenium\\chromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle() +"\n" + driver.getCurrentUrl());
    }
}
