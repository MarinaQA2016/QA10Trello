package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CurrentBoardPageHelper extends  PageBase{
    @FindBy (xpath = "//h1")
    WebElement boardHeader;
    @FindBy (css = ".list")
    List<WebElement>   toDoList;
    @FindBy (css = ".list-card-details")
    List<WebElement> cardsList;
    @FindBy (css = ".placeholder")
    WebElement addListButton;
    @FindBy (css = ".list-name-input")
    WebElement listNameField;
    @FindBy (css = ".js-save-edit")
    WebElement saveListButton;
    @FindBy (css = ".js-cancel-edit")
    WebElement cancelEditListButton;
    @FindBy (css = ".js-add-a-card")
    WebElement addCard;
    @FindBy (css = ".js-card-title")
    WebElement cardDetailsField;
    @FindBy (css = ".js-add-card")
    WebElement submitAddCardButton;
    @FindBy (css = ".js-cancel")
    WebElement cancelAddCard;
    @FindBy (css = ".js-open-header-member-menu")
    WebElement acoountPanelMenuButton;


    String boardTitle;

    public CurrentBoardPageHelper(WebDriver driver, String boardTitle){
        this.driver=driver;
        this.boardTitle = boardTitle;
        PageFactory.initElements(driver,this);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(boardHeader,20);
        waitUntilAllElementsAreVisible(toDoList,20);
        waitUntilAllElementsAreVisible(cardsList, 20);
    }

    public int getNumberOfLists() {
        return toDoList.size();
    }

    public void createNewList(String title) {
        this.pressAddListButton();
        this.fillInListTitle(title);
        this.saveNewList();
        this.cancelCreateNewList();
    }

    public void pressAddListButton() {
        waitUntilElementIsClickable(addListButton,10);
        addListButton.click();
    }

    public void fillInListTitle(String title) {
        waitUntilElementIsClickable(listNameField,5);
        listNameField.sendKeys(title);
    }

    public void saveNewList() {
        waitUntilElementIsClickable(saveListButton,10);
        saveListButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancelCreateNewList() {
        waitUntilElementIsClickable(cancelEditListButton,5);
        cancelEditListButton.click();
        waitUntilElementIsClickable(By.cssSelector(".placeholder"),10);
    }

    public int getNumberOfCards() {
        return cardsList.size();
    }

    public void pressAddCardButton() {
        addCard.click();
    }

    public void fillInNewCardTitle(String title) {
        waitUntilElementIsClickable(cardDetailsField, 5);
        cardDetailsField.click();
        cardDetailsField.sendKeys(title);
    }

    public void submitCreatingCard() {
        waitUntilElementIsClickable(submitAddCardButton,10);
        submitAddCardButton.click();
    }

    public void cancelCreatingNewCard() {
        waitUntilElementIsClickable(cancelAddCard,10);
        cancelAddCard.click();
        waitUntilElementIsClickable(By.cssSelector(".js-add-a-card"),5);
    }

    public void addNewCard(String title) {
        this.pressAddCardButton();
        this.fillInNewCardTitle(title);
        this.submitCreatingCard();
        this.cancelCreatingNewCard();
    }

    public void openAccountPanelPage() {
        waitUntilElementIsClickable(acoountPanelMenuButton,10);
        acoountPanelMenuButton.click();
    }
}
