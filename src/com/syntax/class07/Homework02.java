package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Homework02 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://www.uitestpractice.com/Students/Contact";

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='This is a Ajax link']")).click();

        String text = driver.findElement(By.xpath("//div[@class='ContactUs']")).getText();
        System.out.println(text);
        driver.quit();
    }
}
