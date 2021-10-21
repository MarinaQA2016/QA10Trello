package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void trelloApplStart(){
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void checkLogInButton(){
        WebElement loginButton = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        System.out.println("Name of the 'LogIn' button is " + loginButton.getText());
    }

    @Test
    public void checkSignUpButton(){
        WebElement signUpButton = driver.findElement(By.xpath("//a[@href='/signup']"));
        System.out.println("Name of the 'SignUp' button is " + signUpButton.getText());
    }

    @Test
    public void checkPageHeader(){
        WebElement header = driver.findElement(By.xpath("//h1"));
        System.out.println("Header is " + header.getText());
    }


}
