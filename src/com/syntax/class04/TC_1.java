package com.syntax.class04;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TC_1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        int countLinksWithText = 0;

        driver.get("https://www.amazon.com/");

        List<WebElement> list = driver.findElements(By.tagName("a"));

        for (WebElement element : list){
            if(!(element.getText().isEmpty())|| element.getText() != null){
                System.out.println(element.getAttribute("href"));
                countLinksWithText++;
            }
        }
        System.out.println(countLinksWithText);


        driver.close();
        System.out.println(list);

    }
}
