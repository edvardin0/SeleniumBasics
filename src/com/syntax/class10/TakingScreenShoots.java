package com.syntax.class10;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TakingScreenShoots extends CommonMethods {
    public static void main(String[] args) {
        setUp();
        driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getPropertyValue("username"));
        driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getPropertyValue("password"));
        driver.findElement(By.id("btnLogin")).click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File("screenshots\\HRMS\\adminLogin.png"));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
