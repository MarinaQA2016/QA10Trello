package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class LoginPageHelper extends PageBase {
    @FindBy (id="login")
    WebElement loginButton;
    @FindBy (id ="user")
    WebElement emailField;
    @FindBy (id = "password")
    WebElement passwordNotAttlField;
    @FindBy (css = "#error>p")
    WebElement errorMessage;
    @FindBy (xpath = "//input[@value='Log in with Atlassian']")
    WebElement loginAtlButton;
    @FindBy (id = "password")
    WebElement passwordField;
    @FindBy (id = "login-submit")
    WebElement submitAtlButton;
    @FindBy (id = "login-error")
    WebElement errorMessageAttl;

    public LoginPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginButton,10);
        waitUntilElementIsClickable(passwordNotAttlField,10);
    }

    public void fillEmailField(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void fillPasswordFieldNotAttl(String password) {
        waitUntilElementIsClickable(passwordNotAttlField,5);
        passwordNotAttlField.click();
        passwordNotAttlField.sendKeys(password);
    }

    public void clickLoginButtonNotAttl() {
        waitUntilElementIsClickable(loginButton,10);
        loginButton.click();
    }

    public String getErrorMessageNotAttl() {
        waitUntilElementIsVisible(errorMessage,10);
        return errorMessage.getText();
    }

    public void loginNotAttl(String email, String password) {
        this.fillEmailField(email);
        this.fillPasswordFieldNotAttl(password);
        this.clickLoginButtonNotAttl();

    }

    public void clickLoginAsAttl() {
        waitUntilElementIsClickable(loginAtlButton,10);
        loginAtlButton.click();
    }

    public void fillPasswordAttl(String password) {
        waitUntilElementIsClickable(passwordField,5);
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void submitLoginAttl() {
        waitUntilElementIsClickable(submitAtlButton,5);
        submitAtlButton.click();
    }

    public String getErrorMessageAttl() {
        waitUntilElementIsVisible(errorMessageAttl,10);
        return errorMessageAttl.getText();
    }

    public void loginAttl(String email, String password) {
        this.fillEmailField(email);
        this.clickLoginAsAttl();
        this.fillPasswordAttl(password);
        this.submitLoginAttl();
    }
}
