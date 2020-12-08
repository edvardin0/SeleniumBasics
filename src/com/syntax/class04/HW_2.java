package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String username = "Admin";
        String message = "Password cannot be empty";

        driver.get("http://18.232.148.34/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("btnLogin")).click();
        String actualMessage = driver.findElement(By.id("spanMessage")).getText();
        driver.quit();
        if (message.equals(actualMessage)){
            System.out.println("Message is the same");
        } else{
            System.out.println("Message is different");
        }

    }
}
