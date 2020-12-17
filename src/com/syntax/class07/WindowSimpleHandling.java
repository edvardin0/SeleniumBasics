package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowSimpleHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://accounts.google.com/signup";

        driver.get(url);
        String mainPageHandle = driver.getWindowHandle();
        System.out.println("Parent Handle " + mainPageHandle);
        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());
        Iterator<String> iterator = allWindowHandles.iterator();
        mainPageHandle = iterator.next();
        String childHandle = iterator.next();
        System.out.println("Child Handle " + childHandle);
        driver.switchTo().window(mainPageHandle);

    }
}
