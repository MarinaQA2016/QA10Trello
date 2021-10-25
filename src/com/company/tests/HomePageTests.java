package com.company.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void trelloApplStart(){
        Assert.assertEquals("Manage Your Team’s Projects From Anywhere | Trello",driver.getTitle(),
                "The title of the application is not corresponds to expected title");
    }

    @Test
    public void checkLogInButton(){
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Log in')]"),10);
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        Assert.assertEquals("Log in",loginButton.getText(),
                "The name of the button is not 'Log in'");
    }

    @Test
    public void checkSignUpButton(){
        waitUntilElementIsClickable(By.xpath("//a[@href='/signup']"),10);
        WebElement signUpButton = driver.findElement(By.xpath("//a[@href='/signup']"));
        Assert.assertEquals("Sign up", signUpButton.getText(),
                "Name of the button is not 'Sign Up'");
    }



    @Test
    public void checkPageHeader(){
        waitUntilElementIsVisible(By.xpath("//h1"),10);
        WebElement header = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals("Trello helps teams move work forward.",header.getText(),
                "The text of the header is not correct");
    }

    private void waitUntilElementIsVisible(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void waitUntilElementIsClickable(By locator, int time) {
        try {
            new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
