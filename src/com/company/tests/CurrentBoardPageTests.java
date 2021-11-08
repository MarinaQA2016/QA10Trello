package com.company.tests;

import com.company.pages.BoardsPageHelper;
import com.company.pages.CurrentBoardPageHelper;
import com.company.pages.HomePageHelper;
import com.company.pages.LoginPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardPageTests extends TestBase{
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;
    CurrentBoardPageHelper qa10HaifaCurrentBoard;

    @BeforeMethod
    public void initTests()  {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        boardsPage = PageFactory.initElements(driver,BoardsPageHelper.class);
        qa10HaifaCurrentBoard = new CurrentBoardPageHelper(driver,"QA Haifa10");

        homePage.waitUntilPageIsLoaded();
        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginAttl(EMAIL,PASSWORD);
        boardsPage.waitUntilPageIsLoaded();
        boardsPage.openCurrentBoard("QA Haifa10");
        qa10HaifaCurrentBoard.waitUntilPageIsLoaded();
    }

    @Test
    public void createNewList()  {
        // ---- Receive lists quantity before the test
        int listsBegin = qa10HaifaCurrentBoard.getNumberOfLists();
        qa10HaifaCurrentBoard.createNewList("New");

        // ---- Receive lists quantity finally, after running test
        int listsEnd = qa10HaifaCurrentBoard.getNumberOfLists();

        Assert.assertEquals(listsBegin+1,listsEnd,
                "The final quantity of the lists is not lists quantity at the beginning + 1");

    }
    @Test
    public void addNewCard()  {
        if (qa10HaifaCurrentBoard.getNumberOfLists()==0){
            qa10HaifaCurrentBoard.createNewList("firstList");
        }
        // ------ Receive cards quantity before the test running -------
        int cardsBegin = qa10HaifaCurrentBoard.getNumberOfCards();
        qa10HaifaCurrentBoard.addNewCard("New Card");


        // ------ Receive cards quantity after the test running -------
        int cardsEnd = qa10HaifaCurrentBoard.getNumberOfCards();

        // ------ refresh the page ---------------
        qa10HaifaCurrentBoard.refreshPage();
        qa10HaifaCurrentBoard.waitUntilPageIsLoaded();

        cardsEnd = qa10HaifaCurrentBoard.getNumberOfCards();

        Assert.assertEquals(cardsBegin+1, cardsEnd,
                "The final quantity of the cards is not cards quantity at the beginning + 1 ");
    }
}
