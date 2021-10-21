package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void initTests() throws InterruptedException {
        // --- Define login button and click ------
        WebElement loginIcon = driver.findElement(By.xpath("//a[@href='/login']"));
        loginIcon.click();
        Thread.sleep(5000);
    }

    @Test
    public void loginNegativeNoEmail() throws InterruptedException {

        // --- Fill in email field ------
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("");
        Thread.sleep(2000);
        // ---- Fill in password field ----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("12345678");
        Thread.sleep(3000);
        //--- Press 'Log in' button ----
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        // ----Print error message ----------
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        System.out.println("Error message text: " + errorMessage.getText());
    }
    @Test
    public void loginNegativeLoginNotEmail() throws InterruptedException {

        // --- Fill in email field ------
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("gjgywggjwhdg");
        Thread.sleep(2000);
        // ---- Fill in password field ----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("12345678");
        Thread.sleep(3000);
        //--- Press 'Log in' button ----
        driver.findElement(By.id("login")).click();
        Thread.sleep(3000);
        // ----Print error message ----------
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        System.out.println("Error message text: " + errorMessage.getText());
    }

    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
        //----- Enter email -----
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("marinaqatest2019@gmail.com");
        Thread.sleep(2000);
        // ------ Press 'Login with Atlassian' button
        WebElement loginAtlButton = driver.findElement(By.id("login"));
        loginAtlButton.click();
        Thread.sleep(3000);
        //------ Enter Password -----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("incorrect");
        Thread.sleep(2000);
        //---- Press 'Log in' button -------
        WebElement logInSubmitButton = driver.findElement(By.id("login-submit"));
        logInSubmitButton.click();
        Thread.sleep(3000);
        // --- Print error message -------
        WebElement errorMessage = driver.findElement(By.id("login-error"));
        System.out.println("Error message: " + errorMessage.getText());

    }
    @Test
    public void loginPositive() throws InterruptedException {
        //----- Enter email -----
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("marinaqatest2019@gmail.com");
        Thread.sleep(2000);
        // ------ Press 'Login with Atlassian' button
        WebElement loginAtlButton = driver.findElement(By.id("login"));
        loginAtlButton.click();
        Thread.sleep(3000);
        //------ Enter Password -----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("marinaqa");
        Thread.sleep(2000);
        //--- Submit 'Log In' button -----
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        Thread.sleep(20000);
        // ---- Print name of the 'Boards' button ----
        WebElement boardsButton = driver.findElement(By.xpath("//span[contains(text(),'Boards')]"));
        System.out.println("Name of the 'Boards' button is " + boardsButton.getText());

    }

}
