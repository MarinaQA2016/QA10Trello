package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityMenuPageHelper extends PageBase{
    @FindBy (css = ".phenom-desc")
    List<WebElement> descriptionsActivityList;

    public ActivityMenuPageHelper(WebDriver driver){
        this.driver = driver;
    }

    public void waitUntilPageIsOpened(){
        waitUntiAllElementArePresent(By.cssSelector(".phenom-desc"), 20);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getFirstRecordDescription() {
        return descriptionsActivityList.get(0).getText();
    }
}
