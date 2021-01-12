package com.syntax.class09;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Homework extends CommonMethods {
    public static void main(String[] args) {
        setUp();
        driver.findElement(By.id("txtUsername")).sendKeys(ConfigsReader.getPropertyValue("username"));
        driver.findElement(By.id("txtPassword")).sendKeys(ConfigsReader.getPropertyValue("password"));
        driver.findElement(By.id("btnLogin")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement leaveButton = driver.findElement(By.linkText("Leave"));
        js.executeScript("arguments[0].click();", leaveButton);
        WebElement leaveListButton = driver.findElement(By.linkText("Leave List"));
        js.executeScript("arguments[0].click();", leaveListButton);

        driver.findElement(By.id("calFromDate")).click();
        Select FromMonthListSelect = new Select(driver.findElement(By.className("ui-datepicker-month")));
        FromMonthListSelect.selectByVisibleText("Mar");
        Select fromYearsListSelect = new Select(driver.findElement(By.className("ui-datepicker-year")));
        fromYearsListSelect.selectByVisibleText("2021");
        List<WebElement> fromDaysElements = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//tbody/tr/td"));
        for (WebElement day : fromDaysElements) {
            if (day.getText().equals("14")) {
                day.click();
                break;
            }
        }

        driver.findElement(By.id("calToDate")).click();
        Select toMonthListSelect = new Select(driver.findElement(By.className("ui-datepicker-month")));
        toMonthListSelect.selectByVisibleText("May");
        Select toYearsListSelect = new Select(driver.findElement(By.className("ui-datepicker-year")));
        toYearsListSelect.selectByVisibleText("2021");
        List<WebElement> toDaysElements = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']//tbody/tr/td"));
        for (WebElement day : toDaysElements) {
            if (day.getText().equals("1")) {
                day.click();
                break;
            }
        }
        WebElement rejectedCheckbox = driver.findElement(By.xpath("//label[text() = 'Rejected']//following-sibling::input"));
        if (!rejectedCheckbox.isSelected()) {
            rejectedCheckbox.click();
        }
        WebElement cancelledCheckbox = driver.findElement(By.xpath("//label[text() = 'Cancelled']//following-sibling::input"));
        if (!cancelledCheckbox.isSelected()) {
            cancelledCheckbox.click();
        }
        WebElement pendingApprCheckbox = driver.findElement(By.xpath("//label[text() = 'Pending Approval']//following-sibling::input"));
        if (pendingApprCheckbox.isSelected()) {
            pendingApprCheckbox.click();
        }

        Select subUnitDD = new Select(driver.findElement(By.id("leaveList_cmbSubunit")));
        subUnitDD.selectByVisibleText("IT Support");

        driver.findElement(By.id("btnSearch")).click();

        tearDown();
    }
}
