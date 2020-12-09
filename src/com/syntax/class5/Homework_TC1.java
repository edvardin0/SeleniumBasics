package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Homework_TC1 {
    static final String url = "https://www.facebook.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();
        Thread.sleep(1000);

        Select monthSelect = new Select(driver.findElement(By.name("birthday_month")));
        Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
        Select yearSelect = new Select((driver.findElement(By.name("birthday_year"))));

        List<WebElement> monthList = monthSelect.getOptions();
        List<WebElement> dayList = daySelect.getOptions();
        List<WebElement> yearList = yearSelect.getOptions();

        System.out.println("month dd has 12 month options " + (monthList.size() == 12));
        System.out.println("day dd has 31 day options " + (dayList.size() == 31));
        System.out.println("year dd has 115 year options " + (yearList.size() == 115));

        monthSelect.selectByVisibleText("Nov");
        Thread.sleep(500);
        daySelect.selectByVisibleText("23");
        Thread.sleep(500);
        yearSelect.selectByVisibleText("1905");


        driver.quit();
    }
}
