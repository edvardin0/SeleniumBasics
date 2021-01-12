package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework {
    private static boolean flag = true;
    private static WebElement nextButton;
    private static Select select;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aa.com/homePage.do");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.findElement(By.id("aa-leavingOn")).click();
        while (flag) {
            WebElement departureMonth = driver.findElement(By.xpath(
                    "//div[@class = 'ui-datepicker-group ui-datepicker-group-first']//div//div//span"));
            if (departureMonth.getText().equals("July")) {
                List<WebElement> departureDaysList = driver.findElements(By.xpath(
                        "//div[@class = 'ui-datepicker-group ui-datepicker-group-first']//table//tbody//tr//td"));
                for (WebElement depDay : departureDaysList) {
                    if (depDay.getText().equals("4")) {
                        depDay.click();
                        flag = false;
                        break;
                    }
                }
            } else {
                nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
                nextButton.click();
            }
        }

        flag = true;
        driver.findElement(By.id("aa-returningFrom")).click();
        while (flag){
            WebElement arrivalMonth = driver.findElement(By.xpath(
                    "//div[@class = 'ui-datepicker-group ui-datepicker-group-last']//div//div//span"));
            if (arrivalMonth.getText().equals("November")){
                List<WebElement> arrivalDaysList = driver.findElements(By.xpath(
                        "//div[@class = 'ui-datepicker-group ui-datepicker-group-last']//table//tbody//tr//td"));
                for (WebElement arrDay : arrivalDaysList){
                    if (arrDay.getText().equals("23")){
                        arrDay.click();
                        flag =false;
                        break;
                    }
                }
            } else {
                nextButton = driver.findElement(By.xpath("//a[@title = 'Next']"));
                nextButton.click();
            }
        }

        driver.findElement(By.xpath("//a[@data-for = 'reservationFlightSearchForm.originAirport']")).click();
        WebElement countrySelect = driver.findElement(By.id("countryCode"));
        select = new Select(countrySelect);
        select.selectByVisibleText("United States");
        WebElement stateSelect = driver.findElement(By.id("stateCode"));
        select = new Select(stateSelect);
        select.selectByVisibleText("Nevada");
        driver.findElement(By.xpath("//span[text() = 'LAS']")).click();

        driver.findElement(By.xpath("//a[@data-for = 'reservationFlightSearchForm.destinationAirport']")).click();
        countrySelect = driver.findElement(By.id("countryCode"));
        select = new Select(countrySelect);
        select.selectByVisibleText("Djibouti");
        driver.findElement(By.xpath("//span[text() = 'JIB']")).click();

        driver.findElement(By.id("flightSearchForm.button.reSubmit")).click();

        driver.quit();

    }
}
