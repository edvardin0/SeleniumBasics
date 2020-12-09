package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Homework_HW1 {
    static final String url = "https://www.facebook.com/";
    static final String firstName = "Bart";
    static final String lastName = "Simpson";
    static final String mobileNumOrEmail = "1233456789";
    static final String password = "kiss_my_pants";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@name = 'firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys(mobileNumOrEmail);
        driver.findElement(By.xpath("//input[@name = 'reg_passwd__']")).sendKeys(password);

        Select birthMonth = new Select(driver.findElement(By.id("month")));
        birthMonth.selectByVisibleText("Nov");
        Select birthDay = new Select(driver.findElement(By.id("day")));
        birthDay.selectByVisibleText("23");
        Select birthYear = new Select(driver.findElement(By.id("year")));
        birthYear.selectByVisibleText("1905");
        driver.findElement(By.xpath("//input[@value = '2']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[text() = 'Sign Up']")).click();
    }
}
