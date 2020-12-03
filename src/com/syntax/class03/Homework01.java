package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String message = "The sky is blue and roses are red";

        driver.get("http://syntaxtechs.com/selenium-practice/index.php");
        driver.findElement(By.xpath("//a[text() = ' Start Practising ']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class = 'list-group']//child::a[text() = 'Simple Form Demo']")).click();
        driver.findElement(By.xpath("//input[@id = 'user-message']")).sendKeys(message);
        driver.findElement(By.xpath("//button[text() = 'Show Message']")).click();
        String displayedMessage = driver.findElement(By.xpath("//span[@id = 'display']")).getText();
        System.out.println(displayedMessage.equals(message));
        Thread.sleep(3000);
        driver.quit();
    }
}
