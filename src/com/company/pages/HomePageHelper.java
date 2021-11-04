package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageHelper extends PageBase{

    @FindBy (xpath = "//a[@href='/signup']")
    WebElement signUpButton;
    @FindBy (xpath = "//a[@href='/login']")
    WebElement loginIcon;

    public HomePageHelper(WebDriver driver) {
        this.driver=driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(loginIcon,10);
        waitUntilElementIsClickable(signUpButton,10);
    }

    public String getLoginIconName() {
        return loginIcon.getText();
    }

    public String getSignUpIconName() {
        return signUpButton.getText();
    }

    public String getHeader() {
        WebElement header = driver.findElement(By.xpath("//h1"));
        return header.getText();
    }


    public void openLoginPage() {
        loginIcon.click();
    }
}
