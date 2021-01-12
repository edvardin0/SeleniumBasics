package com.syntax.class11;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSExecutorDemo extends CommonMethods {
    public static void main(String[] args) {
        setUp();
        WebElement usernameTextBox = driver.findElement(By.cssSelector("input#txtUsername"));
        usernameTextBox.sendKeys(ConfigsReader.getPropertyValue("username"));
        WebElement passwordTextBox = driver.findElement(By.cssSelector("input#txtPassword"));
        passwordTextBox.sendKeys(ConfigsReader.getPropertyValue("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
       // loginButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor = 'red'", passwordTextBox);

        js.executeScript("arguments[0].click()",loginButton);
    }
}
