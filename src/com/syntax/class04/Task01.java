package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task01 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://syntaxtechs.com/selenium-practice/index.php");
        driver.findElement(By.cssSelector("a#btn_basic_example")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("div.list-group>a[href = 'basic-first-form-demo.php']")).click();
        driver.findElement(By.cssSelector("input#user-message")).sendKeys("SKY");
        driver.findElement(By.cssSelector("button[onclick ^= 'showInput()']")).click();



    }
}
