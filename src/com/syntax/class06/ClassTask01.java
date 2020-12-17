package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask01 {
    static final String url = "http://syntaxtechs.com/selenium-practice/bootstrap-iframe.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.switchTo().frame("FrameOne");
        String text = driver.findElement(By.xpath("//a[@href = './index.php']")).getText();
        boolean isDisplayed = driver.findElement(By.xpath("//a[@href = './index.php']")).isDisplayed();
        if (isDisplayed) {
            System.out.println(text);
        } else {
            System.out.println("nothing displayed");
        }
        driver.switchTo().defaultContent();

        driver.switchTo().frame("FrameTwo");
        boolean buttonIsEnabled = driver.findElement(By.xpath("//a[@class = 'enroll-btn']")).isEnabled();
        if (buttonIsEnabled) {
            System.out.println("Button is enabled");
        } else {
            System.out.println("Button is disabled");
        }
        driver.switchTo().defaultContent();
    }
}
