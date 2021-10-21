package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CurrentBoardPageTests extends TestBase{
    @BeforeMethod
    public void initTests() throws InterruptedException {
        // --- Define login button and click ------
        WebElement loginIcon = driver.findElement(By.xpath("//a[@href='/login']"));
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
        passwordField.sendKeys("marinaqa");
        Thread.sleep(2000);
        //--- Submit 'Log In' button -----
        WebElement submitButton = driver.findElement(By.id("login-submit"));
        submitButton.click();
        Thread.sleep(20000);
        // ---- Print name of the 'Boards' button ----
        WebElement boardsButton = driver.findElement(By.xpath("//span[contains(text(),'Boards')]"));
        System.out.println("Name of the 'Boards' button is " + boardsButton.getText());

        // ---- Press on 'QA Haifa10' board -----
        WebElement qaHaifa10BoardButton = driver.findElement(By
                .xpath("//li[@class = 'boards-page-board-section-list-item'][.//div[@title='QA Haifa10']]"));
        qaHaifa10BoardButton.click();
        Thread.sleep(5000);
    }

    @Test
    public void createNewList() throws InterruptedException {
        //--- Press on 'Add list' or 'Add another list' button
        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        addListButton.click();
        Thread.sleep(1000);

        //---Fill in list name ----
        WebElement listNameField = driver.findElement(By.cssSelector(".list-name-input"));
        listNameField.sendKeys("New");

        //---- Press 'Add list' button -----
        WebElement saveListButton = driver.findElement(By.cssSelector(".js-save-edit"));
        saveListButton.click();
        Thread.sleep(2000);

        //----- Press x, cancel edit new list -----
        WebElement cancelEditListButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelEditListButton.click();

        Thread.sleep(2000);

    }
}
