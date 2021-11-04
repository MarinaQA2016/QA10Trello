package com.company.tests;

import com.company.pages.BoardsPageHelper;
import com.company.pages.HomePageHelper;
import com.company.pages.LoginPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{


    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests()  {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = new BoardsPageHelper(driver);
        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
    }

    @Test
    public void loginNegativeNoEmail()  {
        loginPage.loginNotAttl("","12345678");

        Assert.assertEquals("Missing email", loginPage.getErrorMessageNotAttl(),
                "The final error-message is not 'Missing email'");
    }

    @Test
    public void loginNegativeLoginNotEmail()  {
        loginPage.loginNotAttl("gjgywggjwhdg","12345678");

        Assert.assertEquals("There isn't an account for this username", loginPage.getErrorMessageNotAttl(),
                "The error-message is not 'There isn't an account for this username'");
    }

    @Test
    public void loginNegativePasswordIncorrect()  {
        loginPage.loginAttl(EMAIL,"incorrect");

        Assert.assertTrue(loginPage.getErrorMessageAttl().contains("Incorrect email address and"),
                "The error message doesn't contain 'Incorrect email address and'");

    }
    @Test
    public void loginPositive()  {
        loginPage.loginAttl(EMAIL,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        Assert.assertTrue(boardsPage.getBordsButtonName().equals("Boards"),
                "The text of the checked button is not 'Boards'");
    }

}
