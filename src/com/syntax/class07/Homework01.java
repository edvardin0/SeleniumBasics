package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Homework01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String url = "https://demoqa.com/browser-windows";

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String mainPageHandle = driver.getWindowHandle();

        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        WebElement newWindowButton = driver.findElement(By.id("windowButton"));
        WebElement newMessageWindowButton = driver.findElement(By.id("messageWindowButton"));

        newTabButton.click();
        String tabButtonHandle = "";
        Set<String> allHandles =driver.getWindowHandles(); // 1st Set of window handles
        for(String handle : allHandles){
            if ( !handle.equals(mainPageHandle)){
                tabButtonHandle = handle;
            }
        }
        driver.switchTo().window(tabButtonHandle);
        String messageNewTab = driver.findElement(By.id("sampleHeading")).getText();
        String titleFromTabButton = driver.getTitle();
        System.out.println(messageNewTab);

        driver.switchTo().window(mainPageHandle);
        newWindowButton.click();
        String windowButtonHandle = "";
        Set<String> newHandles = driver.getWindowHandles(); // 2nd Set of Window handles
        newHandles.removeAll(allHandles); // finding that 1 handle needed
        for(String handle : newHandles){
            windowButtonHandle = handle;
        }
        allHandles.add(windowButtonHandle); //updating 1st Set of window handles
        driver.switchTo().window(windowButtonHandle);
        String messageNewWindow = driver.findElement(By.id("sampleHeading")).getText();
        String titleFromWindowButton = driver.getTitle();
        System.out.println(messageNewWindow);

        driver.switchTo().window(mainPageHandle);
        newMessageWindowButton.click();
        String messageButtonHandle = "";
        newHandles = driver.getWindowHandles(); //updating window handles after opening new window
        newHandles.removeAll(allHandles); // finding that 1 handle needed
        for(String handle : newHandles){
            messageButtonHandle = handle;
        }
        allHandles.add(messageButtonHandle); //updating 1st Set of window handles with all handles
        driver.switchTo().window(messageButtonHandle);
        String textFromMessageButton = driver.findElement(By.tagName("body")).getText();
        System.out.println(textFromMessageButton);
        String titleFromMessageButton = driver.getTitle();

         driver.switchTo().window(mainPageHandle);
         printTitle(titleFromMessageButton);
         printTitle(titleFromTabButton);
         printTitle(titleFromWindowButton);
         driver.quit();
    }
    public static void printTitle(String title){
        if (title.length() > 0){
            System.out.println(title);
        } else {
            System.out.println("Title is EMPTY");
        }
    }
}
