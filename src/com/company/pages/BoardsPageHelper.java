package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardsPageHelper extends PageBase{

    public BoardsPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(By.xpath("//span[contains(text(),'Boards')]"),30);
    }

    public String getBordsButtonName() {
        WebElement boardsButton = driver.findElement(By.xpath("//span[contains(text(),'Boards')]"));
        return boardsButton.getText();
    }
}
