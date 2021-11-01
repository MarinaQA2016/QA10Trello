package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

public class LoginPageHelper extends PageBase {

    public LoginPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.id("login"),10);
        waitUntilElementIsClickable(By.id("password"),5);
    }

    public void fillEmailField(String email) {
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void fillPasswordFieldNotAttl(String password) {
        waitUntilElementIsClickable(By.id("password"),5);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickLoginButtonNotAttl() {
        waitUntilElementIsClickable(By.id("login"),10);
        driver.findElement(By.id("login")).click();
    }

    public String getErrorMessageNotAttl() {
        waitUntilElementIsVisible(By.cssSelector("#error>p"),10);
        WebElement errorMessage = driver.findElement(By.cssSelector("#error>p"));
        return errorMessage.getText();
    }

    public void loginNotAttl(String email, String password) {
        this.fillEmailField(email);
        this.fillPasswordFieldNotAttl(password);
        this.clickLoginButtonNotAttl();

    }

    public void clickLoginAsAttl() {
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);
        WebElement loginAtlButton = driver.findElement(By.id("login"));
        loginAtlButton.click();
    }

    public void fillPasswordAttl(String password) {
        waitUntilElementIsClickable(By.id("password"),5);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void submitLoginAttl() {
        waitUntilElementIsClickable(By.id("login-submit"),5);
        WebElement logInSubmitButton = driver.findElement(By.id("login-submit"));
        logInSubmitButton.click();
    }

    public String getErrorMessageAttl() {
        waitUntilElementIsVisible(By.id("login-error"),10);
        WebElement errorMessage = driver.findElement(By.id("login-error"));
        return errorMessage.getText();
    }

    public void loginAttl(String email, String password) {
        this.fillEmailField(email);
        this.clickLoginAsAttl();
        this.fillPasswordAttl(password);
        this.submitLoginAttl();
    }
}
