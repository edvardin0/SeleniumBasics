package com.syntax.test;

import com.syntax.pages.LoginPage;
import com.syntax.testbase.BaseClass;

public class LoginTest {
    public static void main(String[] args) {
        BaseClass.setUp();
        LoginPage loginPage = new LoginPage();
        loginPage.usernameField.sendKeys("Admin");
        loginPage.passwordField.sendKeys("Hum@nhrm123");
        loginPage.loginButton.click();

        BaseClass.tearDown();
    }
}
