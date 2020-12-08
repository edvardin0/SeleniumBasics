package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskHW {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String username = "Admin";
        String password = "Hum@nhrm123";

        driver.get("http://18.232.148.34/humanresources/symfony/web/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id ='txtUsername']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id ='txtPassword']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id ='btnLogin']")).click();
        boolean isLogoDisplayed = driver.findElement(By.xpath("//img[@alt ='OrangeHRM']")).isDisplayed();
        driver.quit();

        if (isLogoDisplayed){
            System.out.println("Logo is displayed");
        } else {
            System.out.println("Logo isn`t displayed");
        }
    }
}
