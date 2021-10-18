package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TrelloTests {
    WebDriver driver;

    @BeforeMethod
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://trello.com/");
        Thread.sleep(5000);
    }

    @Test
    public void trelloApplStart(){
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void loginNegativePasswordIncorrect() throws InterruptedException {
        // --- Define login button and click ------
        WebElement loginIcon = driver.findElement(By.cssSelector(".btn-link"));
        loginIcon.click();
        Thread.sleep(5000);
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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
