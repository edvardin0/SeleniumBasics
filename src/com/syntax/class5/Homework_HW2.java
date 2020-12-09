package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework_HW2 {
    static final String url = "https://www.ebay.com/";
    static  final String header = "Computers, Tablets & Network Hardware";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        Select allCategories = new Select(driver.findElement(By.xpath("//select[@aria-label = 'Select a category for search']")));

        List<WebElement> listOfCategories = allCategories.getOptions();
        for (WebElement element : listOfCategories){
            System.out.println(element.getText());
        }

        allCategories.selectByValue("58058");
        driver.findElement(By.xpath("//input[@value = 'Search']")).click();

        System.out.println("Is header matching expected header: " +
                (header.equalsIgnoreCase(driver.findElement(By.xpath("//span[@class = 'b-pageheader__text']")).getText())));

    }
}
