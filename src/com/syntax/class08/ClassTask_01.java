package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassTask_01 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://syntaxtechs.com/selenium-practice/dynamic-elements-loading.php");
        driver.manage().window().maximize();
        WebElement  startButton = driver.findElement(By.id("startButton"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.ByXPath.xpath("//h4[text() = 'Welcome Syntax Technologies']")));
        WebElement textElement = driver.findElement(By.xpath("//h4[text() = 'Welcome Syntax Technologies']"));
        System.out.println(textElement.getText());
    }
}
