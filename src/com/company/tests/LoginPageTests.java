package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
        // --- Define login button and click ------
        WebElement loginIcon = driver.findElement(By.xpath("//a[@href='/login']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"),10);
    }

    @Test
    public void loginNegativeNoEmail() throws InterruptedException {

        // --- Fill in email field ------
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("");
        waitUntilElementIsClickable(By.id("password"),5);
        // ---- Fill in password field ----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("12345678");
        waitUntilElementIsClickable(By.id("login"),10);
        //--- Press 'Log in' button ----
        driver.findElement(By.id("login")).click();
        waitUntilElementIsVisible(By.cssSelector("#error>p"),10);
        // ----Print error message ----------
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        Assert.assertEquals("Missing email", errorMessage.getText(),
                "The final error-message is not 'Missing email'");
    }
    @Test
    public void loginNegativeLoginNotEmail() throws InterruptedException {

        // --- Fill in email field ------
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("gjgywggjwhdg");
        waitUntilElementIsClickable(By.id("password"),5);
        // ---- Fill in password field ----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("12345678");
        waitUntilElementIsClickable(By.id("login"),10);
        //--- Press 'Log in' button ----
        driver.findElement(By.id("login")).click();
        waitUntilElementIsVisible(By.cssSelector("#error>p"),10);

        // ----Print error message ----------
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        Assert.assertEquals("There isn't an account for this username", errorMessage.getText(),
                "The error-message is not 'There isn't an account for this username'");
    }

    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
        //----- Enter email -----
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("marinaqatest2019@gmail.com");
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);

        // ------ Press 'Login with Atlassian' button
        WebElement loginAtlButton = driver.findElement(By.id("login"));
        loginAtlButton.click();
        waitUntilElementIsClickable(By.id("password"),5);

        //------ Enter Password -----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("incorrect");
        waitUntilElementIsClickable(By.id("login-submit"),5);
        //---- Press 'Log in' button -------
        WebElement logInSubmitButton = driver.findElement(By.id("login-submit"));
        logInSubmitButton.click();
        waitUntilElementIsVisible(By.id("login-error"),10);

        // --- Print error message -------
        WebElement errorMessage = driver.findElement(By.id("login-error"));
        Assert.assertTrue(errorMessage.getText().contains("Incorrect email address and"),
                "The error message doesn't contain 'Incorrect email address and'");

    }
    @Test
    public void loginPositive() throws InterruptedException {
        //----- Enter email -----
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("marinaqatest2019@gmail.com");
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);

        // ------ Press 'Login with Atlassian' button
        WebElement loginAtlButton = driver.findElement(By.id("login"));
        loginAtlButton.click();
        waitUntilElementIsClickable(By.id("password"),5);

        //------ Enter Password -----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("marinaqa");
        waitUntilElementIsClickable(By.id("login-submit"),5);

        //--- Submit 'Log In' button -----
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Boards')]"),30);
        // ---- Print name of the 'Boards' button ----
        WebElement boardsButton = driver.findElement(By.xpath("//span[contains(text(),'Boards')]"));
        Assert.assertTrue(boardsButton.getText().equals("Boards"),
                "The text of the checked button is not 'Boards'");
    }

}
