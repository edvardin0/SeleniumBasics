package com.syntax.class07;

import com.sun.rowset.JdbcRowSetResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvanceWindowsHandling {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://syntaxtechs.com/selenium-practice/window-popup-modal-demo.php";

        driver.get(url);
        WebElement instaButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement fbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement instaAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));

        instaButton.click();
        fbButton.click();
        instaAndFbButton.click();

        Set<String> allWindowsHandles = driver.getWindowHandles();
        System.out.println(allWindowsHandles.size());
        Iterator<String> iterator = allWindowsHandles.iterator();
        while (iterator.hasNext()){
            String childHandle = iterator.next();
            driver.switchTo().window(childHandle);
            System.out.println(driver.getTitle());
        }


    }
}
