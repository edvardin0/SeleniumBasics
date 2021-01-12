package com.syntax.class11;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sun.rmi.runtime.Log;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class LastSeleniumHW {

    WebDriver driver;
    Actions actions;
    JavascriptExecutor jsExecutor;
    List<String> resultsOfTest;
    boolean testChecker;
    Select select;


    LastSeleniumHW() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        resultsOfTest = new ArrayList<>();
        driver.get("http://www.uitestpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        LastSeleniumHW homework = new LastSeleniumHW();
        homework.go();
    }

    void go() {
        Instant beginning = Instant.now();

        controlsPageTest();
        homePageTest();
        ajaxCallPageTest();
        formPageTest();
        widgetsPageTest();
        actionsPageTest();
        switchToPageTest();
        selectPageTest();

        driver.quit();
        Instant end = Instant.now();
        System.out.println(Duration.between(beginning, end));
        printResults();
    }

    void testCase(boolean testChecker, String testCaseName) {
        if (testChecker) {
            resultsOfTest.add("PASS: " + testCaseName);
        } else {
            resultsOfTest.add("FAIL: " + testCaseName);
        }
    }

    void printResults() {
        for (String test : resultsOfTest) {
            System.out.println(test);
        }
    }

    void controlsPageTest() {
        resultsOfTest.add("-----------Control Page Test cases-----------");

        driver.findElement(By.linkText("Controls")).click();
        WebElement draggableBox = driver.findElement(By.id("draggable"));
        WebElement dropBox = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggableBox, dropBox).build().perform();
        testChecker = driver.findElement(By.xpath("//div[@id = 'droppable']/p")).getText().equals("Dropped!");
        testCase(testChecker, "Drag and Drop control");

        WebElement doubleClickContainer = driver.findElement(By.xpath("//div[@class = 'container red']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", doubleClickContainer);
        actions.doubleClick(driver.findElement(By.xpath("//button[text() = 'Double Click ME !']"))).build().perform();
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        testChecker = alertMessage.equals("Double Clicked !!");
        testCase(testChecker, "Button Double Click");


        driver.switchTo().frame("iframe_a");
        WebElement textBox = driver.findElement(By.id("name"));
        String str = "Test";
        textBox.sendKeys(str);
        testChecker = textBox.getAttribute("value").equals(str);
        testCase(testChecker, "Iframe textBox check");
        driver.switchTo().defaultContent();
    }

    void homePageTest() {
        resultsOfTest.add("-----------Home Page Test cases-----------");

        driver.findElement(By.linkText("Home")).click();
        String deletionFullName = driver.findElement(By.xpath("//table/tbody/tr/td[1]")).getText() +
                driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
        driver.findElement(By.xpath("(//button[text()= 'DELETE'])[1]")).click();
        driver.findElement(By.xpath("//input[@value= 'Delete']")).click();
        String nextFullName = driver.findElement(By.xpath("//table/tbody/tr/td[1]")).getText() +
                driver.findElement(By.xpath("//table/tbody/tr/td[2]")).getText();
        testChecker = !deletionFullName.equals(nextFullName);
        testCase(testChecker, "Deletion element from the table");
    }

    void ajaxCallPageTest() {
        resultsOfTest.add("-----------AjaxCall Page Test cases-----------");

        driver.findElement(By.linkText("AjaxCall")).click();
        driver.findElement(By.linkText("This is a Ajax link")).click();
        try {
            driver.findElement(By.xpath("//div[@class= 'ContactUs']"));
            testChecker = true;
        } catch (Exception c) {
            testChecker = false;
        }
        testCase(testChecker, "Ajax link text is reachable");
    }

    void formPageTest() {
        resultsOfTest.add("-----------Form Page Test cases-----------");

        driver.findElement(By.linkText("Form")).click();
        String[] testData = {"Homer", "Simpson", "Afghanistan", "911", "JSimpson", "JSimpson@springfield.com", "I love beer", "1moreBeerPlease"};
        List<WebElement> list;

        //setting first name
        WebElement firstNameTBox = driver.findElement(By.id("firstname"));
        firstNameTBox.sendKeys(testData[0]);
        testChecker = firstNameTBox.getAttribute("value").equals(testData[0]);
        testCase(testChecker, "Accepting and displaying First Name");

        //setting last name
        WebElement lastNameTBox = driver.findElement(By.id("lastname"));
        lastNameTBox.sendKeys(testData[1]);
        testChecker = lastNameTBox.getAttribute("value").equals(testData[1]);
        testCase(testChecker, "Accepting and displaying Last Name");

        // Married status select
        WebElement martialStCheckBox = driver.findElement(By.xpath("//label[text()='Martial Status:']//following-sibling::label/input"));
        martialStCheckBox.click();
        testChecker = martialStCheckBox.isSelected();
        testCase(testChecker, "Martial Status Married isSelectable");

        //selecting hobby checkBoxes
        list = driver.findElements(By.xpath("//label[text()='Hobby :']//following-sibling::label/input"));
        int counter = list.size();
        for (WebElement checkBox : list) {
            checkBox.click();
            testChecker = checkBox.isSelected();
            counter--;
            if (testChecker) {
                if (counter == 0) {
                    testCase(true, "All Hobby check boxes selectable");
                }
            } else {
                testCase(false, "All Hobby check boxes selectable");
            }
        }

        //Selecting country from provided data
        select = new Select(driver.findElement(By.id("sel1")));
        select.selectByVisibleText(testData[2]);
        List<WebElement> country = select.getAllSelectedOptions();
        testChecker = country.get(0).getAttribute("value").equals(testData[2]);
        testCase(testChecker, "Country is selectable");

        //setting a date of birth
        WebElement dateOfBirthBox = driver.findElement(By.id("datepicker"));
        dateOfBirthBox.click();
        select = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
        select.selectByValue("10");
        select = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
        select.selectByVisibleText("1975");
        driver.findElement(By.linkText("21")).click();
        testChecker = dateOfBirthBox.getAttribute("value").equals("11/21/1975");
        testCase(testChecker, "Date Of Birth is Selectable and displayed");

        //setting phone number
        WebElement phoneNumTextBox = driver.findElement(By.id("phonenumber"));
        phoneNumTextBox.sendKeys(testData[3]);
        testChecker = phoneNumTextBox.getAttribute("value").equals(testData[3]);
        testCase(testChecker, "Phone Number text box interactive and info is displayed");

        //setting username
        WebElement userNameTextBox = driver.findElement(By.id("username"));
        userNameTextBox.sendKeys(testData[4]);
        testChecker = userNameTextBox.getAttribute("value").equals(testData[4]);
        testCase(testChecker, "User Name text box interactive and info is displayed");

        //setting email
        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.sendKeys(testData[5]);
        testChecker = emailTextBox.getAttribute("value").equals(testData[5]);
        testCase(testChecker, "Email text box interactive and info is displayed");


        // setting comment about yourself
        WebElement aboutYourselfTextBox = driver.findElement(By.id("comment"));
        aboutYourselfTextBox.sendKeys(testData[6]);
        testChecker = aboutYourselfTextBox.getAttribute("value").equals(testData[6]);
        testCase(testChecker, "About Yourself text box interactive and info is displayed");

        // setting password
        WebElement passwordTextBox = driver.findElement(By.id("pwd"));
        passwordTextBox.sendKeys(testData[7]);
        testChecker = passwordTextBox.getAttribute("value").equals(testData[7]);
        testCase(testChecker, "Password text box interactive and password is displayed");

        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        firstNameTBox = driver.findElement(By.id("firstname"));
        testChecker = firstNameTBox.getAttribute("value").equals("");
        testCase(testChecker, "Submit button works, fields were reset");
    }

    void widgetsPageTest() {
        resultsOfTest.add("-----------Widget Page Test cases-----------");

        driver.findElement(By.linkText("Widgets")).click();
        driver.findElement(By.id("image_file")).sendKeys("E:/downloads/ctHomerSimpson.jpg");

        testChecker = driver.findElement(By.id("preview")).isDisplayed();
        testCase(testChecker, "Image can be selected and displayed");

        driver.findElement(By.xpath("//input[@value ='Upload']")).click();
        WebElement successText = driver.findElement(By.xpath("//div[@id ='upload_response']/div/p"));
        testChecker = successText.getText().equals("File Successfully Uploaded");
        testCase(testChecker, "Image successfully uploaded");

    }

    void actionsPageTest() {
        resultsOfTest.add("-----------Actions Page Test cases-----------");

        driver.findElement(By.linkText("Actions")).click();

        //click me button
        testChecker = false;
        try {
            actions.click(driver.findElement(By.xpath("//button[text() ='Click Me !']"))).perform();
            String clickMeAlertMessage = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            testChecker = clickMeAlertMessage.equals("Clicked !!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        testCase(testChecker, "Click Me! button clicked alert message is correct");

        //double click me button
        testChecker = false;
        try {
            actions.doubleClick(driver.findElement(By.xpath("//button[text() ='Double Click Me !']"))).build().perform();
            String doubleClickMeAlertMessage = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            testChecker = doubleClickMeAlertMessage.equals("Double Clicked !!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        testCase(testChecker, "Double Clicked !! button clicked alert message is correct");

        // drag and drop
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(draggable, droppable).perform();
        testChecker = driver.findElement(By.xpath("//div[@id = 'droppable']/p")).getText().equals("Dropped!");
        testCase(testChecker, "draggable box is dropped in droppable");

        //when cursor in on box color is changed
        WebElement coloredBox = driver.findElement(By.id("div2"));
        String coloredBoxColorBefore = coloredBox.getAttribute("style");
        actions.moveToElement(coloredBox).perform();
        String coloredBoxColorAfter = coloredBox.getAttribute("style");
        testChecker = !(coloredBoxColorBefore.equals(coloredBoxColorAfter));
        testCase(testChecker, "Color of box is changed when cursor is on");

        // All numbers are selectable
        List<WebElement> elements = driver.findElements(By.xpath("//ol[@id = 'selectable']/li"));
        int count = 12;
        String selectedClass = "ui-state-default ui-selectee ui-selected";

        for (WebElement element : elements) {
            element.click();
            String elementClass = element.getAttribute("class");
            if (elementClass.equals(selectedClass)) {
                count--;
            }
        }
        if (count == 0) {
            testChecker = true;
        } else {
            testChecker = false;
        }
        testCase(testChecker, "All numbers from box are selectable");
    }

    void switchToPageTest() {
        resultsOfTest.add("-----------Switch to Page Test cases-----------");

        driver.findElement(By.linkText("Switch to")).click();

        //alert button
        String text = null;
        try {
            driver.findElement(By.id("alert")).click();
            text = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        testChecker = !(text.equals(null));
        testCase(testChecker, "Alert button is enabled Alert with message is present");

        // confirm button
        text = null;
        try {
            driver.findElement(By.id("confirm")).click();
            text = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        testChecker = !(text.equals(null));
        testCase(testChecker, "Confirm button is enabled Alert with message is present");

        //prompt button
        text = "Testing";
        testChecker = false;
        try {
            driver.findElement(By.id("prompt")).click();
            driver.switchTo().alert().sendKeys(text);
            testChecker = !(text.equals(driver.switchTo().alert().getText()));
            driver.switchTo().alert().accept();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        testCase(testChecker, "Alert button is enabled Alert with message is present");

        //launch modal button
        text = null;
        try {
            driver.findElement(By.xpath("//button[@data-toggle= 'modal']")).click();
            text = driver.findElement(By.xpath("//div[@class= 'modal-body']")).getText();
            driver.findElement(By.xpath("//button[text()= 'Ok']")).click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        testChecker = !(text.equals(null));
        testCase(testChecker, "Launch modal button is enabled and modal window with text present");

        //Basic Authentication
        text = null;
        testChecker = false;
        try {
            driver.findElement(By.id("basicAuthentication")).click();
            driver.switchTo().alert().accept();
            testChecker = true;
        } catch (Exception exception) {
            exception.getMessage();
        }
        testCase(testChecker, "Basic Authentication button works alert is present");

        //iframe
        text = "Testing";
        driver.switchTo().frame("iframe_a");
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys(text);
        testChecker = text.equals(textBox.getAttribute("value"));
        testCase(testChecker, "Iframe text box is intractable");
        driver.switchTo().defaultContent();

        // link opens in a new window
        testChecker = false;
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Opens in a new window")).click();
        Set<String> allWindows = driver.getWindowHandles();
        if (allWindows.size() == 2) {
            testChecker = true;
            for (String tempWindow : allWindows) {
                if (!(tempWindow.equals(mainWindow))) {
                    driver.switchTo().window(tempWindow);
                    driver.close();
                }
            }
        }
        driver.switchTo().window(mainWindow);
        testCase(testChecker, "New Window opens");
    }

    void selectPageTest() {
        resultsOfTest.add("-----------Select Page Test cases-----------");

        driver.findElement(By.linkText("Select")).click();
        String target = "England";
        String target2 = "China";

        // drop down
        select = new Select(driver.findElement(By.id("countriesSingle")));
        select.selectByVisibleText(target);
        testChecker = target.toLowerCase().equals(driver.findElement(By.id("countriesSingle")).getAttribute("value"));
        System.out.println();
        testCase(testChecker, "England is Selected");

        // multiple select
        testChecker = false;
        select = new Select(driver.findElement(By.id("countriesMultiple")));
        select.selectByVisibleText(target);
        select.selectByVisibleText(target2);
        List<WebElement> multiSelectList = driver.findElements(By.xpath("//select[@id = 'countriesMultiple']/option"));
        int counter = 2;
        for (WebElement element : multiSelectList) {
            if (element.getText().equals(target) || element.getText().equals(target2)) {
                counter--;
            }
        }
        if (counter == 0) {
            testChecker = true;
        }
        testCase(testChecker, "Multi select works. England and China were selected");

        // drop down button
        driver.findElement(By.id("dropdownMenu1")).click();
        driver.findElement(By.linkText("England")).click();
        testChecker = target.equals(driver.findElement(By.id("dropdownMenu1")).getText());
        testCase(testChecker, "England is selected from button drop down");
    }
}
