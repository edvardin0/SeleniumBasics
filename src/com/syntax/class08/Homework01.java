package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class Homework01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/dynamic_controls";

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //WebDriverWait wait = new WebDriverWait(driver,10);

        try{
        WebElement checkbox = driver.findElement(By.xpath("//input[@label = 'blah']"));
        checkbox.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[text() = 'Remove']"));
        removeButton.click();
        WebElement removalMessage = driver.findElement(By.id("message"));
        System.out.println(removalMessage.getText());

        WebElement textEnablDisablButton = driver.findElement(By.xpath("//button[@onclick = 'swapInput()']"));
        textEnablDisablButton.click();
        WebElement textBox = driver.findElement(By.xpath("//form[@id = 'input-example']//input"));
        System.out.println("Is text box enabled: " + textBox.isEnabled());
        while (!textBox.isEnabled()){} // for some reason implicit didn't wait
        textBox.sendKeys("Nokia... connecting people");
        textEnablDisablButton.click();
        System.out.println("Is text box enabled: " + textBox.isEnabled());
        }

        catch (Exception e) { e.printStackTrace(); }
        finally { driver.quit(); }

    }
}
