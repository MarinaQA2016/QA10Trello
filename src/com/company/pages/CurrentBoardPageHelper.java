package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrentBoardPageHelper extends  PageBase{
    String boardTitle;

    public CurrentBoardPageHelper(WebDriver driver, String boardTitle){
        this.driver=driver;
        this.boardTitle = boardTitle;
    }

    public void waitUntilPageIsLoaded() {
        //---- wait that 'QA Haifa10' menu (header) is loaded ---
        waitUntilElementIsClickable(By.xpath("//h1"),20);
        //------wait that lists list is loaded -----
        waitUntilAllElementsAreVisible(By.cssSelector(".list"),20);
        waitUntilAllElementsAreVisible(By.cssSelector(".list-card-details"),20);
    }

    public int getNumberOfLists() {
        return driver.findElements(By.cssSelector(".list")).size();
    }

    public void createNewList(String title) {
        this.pressAddListButton();
        this.fillInListTitle(title);
        this.saveNewList();
        this.cancelCreateNewList();
    }

    public void pressAddListButton() {
        waitUntilElementIsClickable(By.cssSelector(".placeholder"),10);
        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        addListButton.click();
    }

    public void fillInListTitle(String title) {
        waitUntilElementIsClickable(By.cssSelector(".list-name-input"),5);
        WebElement listNameField = driver.findElement(By.cssSelector(".list-name-input"));
        listNameField.sendKeys(title);
    }

    public void saveNewList() {
        waitUntilElementIsClickable(By.cssSelector(".js-save-edit"),5);
        WebElement saveListButton = driver.findElement(By.cssSelector(".js-save-edit"));
        saveListButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancelCreateNewList() {
        waitUntilElementIsClickable(By.cssSelector(".js-cancel-edit"),5);
        WebElement cancelEditListButton = driver.findElement(By.cssSelector(".js-cancel-edit"));
        cancelEditListButton.click();
        waitUntilElementIsClickable(By.cssSelector(".placeholder"),10);
    }

    public int getNumberOfCards() {
        return driver.findElements(By.cssSelector(".list-card-details")).size();
    }

    public void pressAddCardButton() {
        WebElement addCard = driver.findElement(By.cssSelector(".js-add-a-card"));
        addCard.click();
    }

    public void fillInNewCardTitle(String title) {
        waitUntilElementIsClickable(By.cssSelector(".js-card-title"),5);
        WebElement cardDetailsField = driver.findElement(By.cssSelector(".js-card-title"));
        cardDetailsField.click();
        cardDetailsField.sendKeys(title);
    }

    public void submitCreatingCard() {
        waitUntilElementIsClickable(By.cssSelector(".js-add-card"),5);
        WebElement submitAddCardButton = driver.findElement(By.cssSelector(".js-add-card"));
        submitAddCardButton.click();
    }

    public void cancelCreatingNewCard() {
        waitUntilElementIsClickable(By.cssSelector(".js-cancel"),5);
        WebElement cancelAddCard = driver.findElement(By.cssSelector(".js-cancel"));
        cancelAddCard.click();
        waitUntilElementIsClickable(By.cssSelector(".js-add-a-card"),5);
    }

    public void addNewCard(String title) {
        this.pressAddCardButton();
        this.fillInNewCardTitle(title);
        this.submitCreatingCard();
        this.cancelCreatingNewCard();
    }
}
