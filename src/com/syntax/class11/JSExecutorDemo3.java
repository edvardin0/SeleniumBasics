package com.syntax.class11;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExucutorDemo3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open();");
        driver.navigate().to("http://google");
    }
}
