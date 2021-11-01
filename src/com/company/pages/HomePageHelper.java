package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends PageBase{

    public HomePageHelper(WebDriver driver) {
        this.driver=driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Log in')]"),10);
        waitUntilElementIsClickable(By.xpath("//a[@href='/signup']"),10);
        //waitUntilElementIsVisible(By.xpath("//h1"),10);
    }

    public String getLoginIconName() {
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        return loginButton.getText();
    }

    public String getSignUpIconName() {
        WebElement signUpButton = driver.findElement(By.xpath("//a[@href='/signup']"));
        return signUpButton.getText();
    }


    public String getHeader() {
        WebElement header = driver.findElement(By.xpath("//h1"));
        return header.getText();
    }



    public void openLoginPage() {
        WebElement loginIcon = driver.findElement(By.xpath("//a[@href='/login']"));
        loginIcon.click();
    }
}
