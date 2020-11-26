package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework01 {
    public static void main(String[] args) throws InterruptedException {

        String firstName = "Bean";
        String lastName = "Mr";
        String address = "Big Ben";
        String city = "London";
        String state = city;
        int zipCode = 23451;
        String phoneNumber = "+156789567";
        String ssn = "123-45-8975";
        String username = "MrBean";
        String password = "(.)^_^(.)";

        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");

        driver.findElement(By.id("customer.firstName")).sendKeys(firstName);
        driver.findElement(By.id("customer.lastName")).sendKeys(lastName);
        driver.findElement(By.id("customer.address.street")).sendKeys(address);
        driver.findElement(By.id("customer.address.city")).sendKeys(city);
        driver.findElement(By.id("customer.address.state")).sendKeys(state);
        driver.findElement(By.id("customer.address.zipCode")).sendKeys(Integer.toString(zipCode));
        driver.findElement(By.id("customer.phoneNumber")).sendKeys(phoneNumber);
        driver.findElement(By.id("customer.ssn")).sendKeys(ssn);
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys(password);
        driver.findElement(By.id("repeatedPassword")).sendKeys(password);
        driver.findElement(By.id("repeatedPassword")).sendKeys(password);
        driver.findElement(By.linkText("Register")).click();

        Thread.sleep(5000);
        driver.close();

    }
}
