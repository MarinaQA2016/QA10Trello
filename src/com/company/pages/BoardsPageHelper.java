package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BoardsPageHelper extends PageBase{

    public BoardsPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Boards')]"),30);
        waitUntilAllElementsAreVisible(By.cssSelector(".board-tile-fade"),15);


    }

    public String getBordsButtonName() {
        WebElement boardsButton = driver.findElement(By.xpath("//span[contains(text(),'Boards')]"));
        return boardsButton.getText();
    }

    public void openCurrentBoard(String bordaTitle) {
        waitUntilElementIsClickable(By
                .xpath("//li[@class = 'boards-page-board-section-list-item'][.//div[@title='QA Haifa10']]"),10);
        // ---- Press on 'QA Haifa10' board -----
        WebElement qaHaifa10BoardButton = driver.findElement(By
                .xpath("//li[@class = 'boards-page-board-section-list-item'][.//div[@title='QA Haifa10']]"));
        qaHaifa10BoardButton.click();

    }
}
