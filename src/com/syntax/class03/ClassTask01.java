package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassTask01 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        driver.findElement(By.xpath("//input[@name = 'ctl00$MainContent$username']")).sendKeys("Tester");
        driver.findElement(By.xpath("//input[@name = 'ctl00$MainContent$password']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
        driver.manage().wait(2000);
        driver.quit();


    }
}
