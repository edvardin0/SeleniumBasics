package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework02 {
    public static void main(String[] args) throws InterruptedException {

        String firstName = "James";
        String lastName = "Bond";
        String mobileNUmber = "007";
        String password = "BondNeverSayNever";

        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("u_0_2")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(mobileNUmber);
        driver.findElement(By.name("reg_passwd__")).sendKeys(password);
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(500);
        driver.findElement(By.id("u_1_9")).click();

        Thread.sleep(3000);
        driver.quit();

    }
}
