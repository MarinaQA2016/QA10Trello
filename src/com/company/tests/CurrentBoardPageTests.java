package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardPageTests extends TestBase{
    @BeforeMethod
    public void initTests()  {
        // --- Define login button and click ------
        WebElement loginIcon = driver.findElement(By.xpath("//a[@href='/login']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"),10);

        //----- Enter email -----
        WebElement emailField = driver.findElement(By.id("user"));
        emailField.click();
        emailField.sendKeys("marinaqatest2019@gmail.com");
        waitUntilElementIsClickable(By.xpath("//input[@value='Log in with Atlassian']"),10);

        // ------ Press 'Login with Atlassian' button
        WebElement loginAtlButton = driver.findElement(By.id("login"));
        loginAtlButton.click();
        waitUntilElementIsClickable(By.id("password"),5);

        //------ Enter Password -----
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.click();
        passwordField.sendKeys("marinaqa");
        waitUntilElementIsClickable(By.id("login-submit"),5);

        //--- Submit 'Log In' button -----
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Boards')]"),30);

        // ---- Print name of the 'Boards' button ----
        WebElement boardsButton = driver.findElement(By.xpath("//span[contains(text(),'Boards')]"));
        waitUntilElementIsClickable(By
                .xpath("//li[@class = 'boards-page-board-section-list-item'][.//div[@title='QA Haifa10']]"),10);

        // ---- Press on 'QA Haifa10' board -----
        WebElement qaHaifa10BoardButton = driver.findElement(By
                .xpath("//li[@class = 'boards-page-board-section-list-item'][.//div[@title='QA Haifa10']]"));
        qaHaifa10BoardButton.click();
        //---- wait that 'QA Haifa10' menu (header) is loaded ---
        waitUntilElementIsClickable(By.xpath("//h1"),20);
        //------wait that lists list is loaded -----
        waitUntilAllElementsAreVisible(By.cssSelector(".list"),15);
    }

    @Test
    public void createNewList()  {
        // ---- Receive lists quantity before the test
        int listsBegin = driver.findElements(By.cssSelector(".list")).size();
        //--- Press on 'Add list' or 'Add another list' button
        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        addListButton.click();
        waitUntilElementIsClickable(By.cssSelector(".list-name-input"),5);

        //---Fill in list name ----
        WebElement listNameField = driver.findElement(By.cssSelector(".list-name-input"));
        listNameField.sendKeys("New");
        waitUntilElementIsClickable(By.cssSelector(".js-save-edit"),5);

        //---- Press 'Add list' button -----
        WebElement saveListButton = driver.findElement(By.cssSelector(".js-save-edit"));
        saveListButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"),5);

        //----- Press x, cancel edit new list -----
        WebElement cancelEditListButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelEditListButton.click();

        waitUntilElementIsClickable(By.cssSelector(".placeholder"),10);
        // ---- Receive lists quantity finally, after running test
        int listsEnd = driver.findElements(By.cssSelector(".list")).size();

        Assert.assertEquals(listsBegin+1,listsEnd,
                "The final quantity of the lists is not lists quantity at the beginning + 1");

    }
    @Test
    public void addNewCard()  {
        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        //-----Verification of lists quantity by name of addListButton -------
        //if (addListButton.getText().equals("Add a list")) {
        //------Verification by list elements quantity -----
        if (driver.findElements(By.cssSelector(".list")).size()==0){
            addListButton.click();
            waitUntilElementIsClickable(By.cssSelector(".list-name-input"),5);

            //---Fill in list name ----
            WebElement listNameField = driver.findElement(By.cssSelector(".list-name-input"));
            listNameField.sendKeys("New");

            //---- Press 'Add list' button -----
            WebElement saveListButton = driver.findElement(By.cssSelector(".js-save-edit"));
            saveListButton.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"),5);

            //----- Press x, cancel edit new list -----
            WebElement cancelEditListButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
            cancelEditListButton.click();

            waitUntilElementIsClickable(By.cssSelector(".placeholder"),10);
        }
        // ------ Receive cards quantity before the test running -------
        int cardsBegin = driver.findElements(By.cssSelector(".list-card-details")).size();

        WebElement addCard = driver.findElement(By.cssSelector(".js-add-a-card"));
        addCard.click();
        waitUntilElementIsClickable(By.cssSelector(".js-card-title"),5);
        WebElement cardDetailsField = driver.findElement(By.cssSelector(".js-card-title"));
        cardDetailsField.click();
        cardDetailsField.sendKeys("New Card");
        waitUntilElementIsClickable(By.cssSelector(".js-add-card"),5);
        //------Press submit add card button ------
        WebElement submitAddCardButton = driver.findElement(By.cssSelector(".js-add-card"));
        submitAddCardButton.click();
        waitUntilElementIsClickable(By.cssSelector(".js-cancel"),5);

        // ----- Press X-button
        WebElement cancelAddCard = driver.findElement(By.cssSelector(".js-cancel"));
        cancelAddCard.click();
        waitUntilElementIsClickable(By.cssSelector(".js-add-a-card"),5);

        // ------ Receive cards quantity after the test running -------
        int cardsEnd = driver.findElements(By.cssSelector(".list-card-details")).size();

        // ------ refresh the page ---------------
        driver.navigate().refresh();
        waitUntilAllElementsAreVisible(By.cssSelector(".list-card-details"),10);
        cardsEnd = driver.findElements(By.cssSelector(".list-card-details")).size();

        Assert.assertEquals(cardsBegin+1, cardsEnd,
                "The final quantity of the cards is not cards quantity at the beginning + 1 ");
    }
}
