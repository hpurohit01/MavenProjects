package utilities;

import homepage.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utilities extends BaseTest {


    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }


    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByIndex(By by, int args0) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
    }

    public void selectGetTextFromAlert(By by, String text) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void mouseHoverAndClick(By by, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    public void mouseHoverAndAction(By by,String text){
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void selectByMouseToElement(By by, String text) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).moveToElement(driver.findElement(by)).click().build().perform();
    }

    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void selectAcceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void selectDismissedAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void selectRightClick(By by, String text) {
        Actions actions = new Actions(driver);
        WebElement button = driver.findElement(by);
        actions.contextClick().build().perform();
    }

    public void selectByIndexFromDropDown(By by, int value) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(value);


    }

    public void dropDownExampleWithList() {
        List<WebElement> productType = driver.findElements(By.xpath(""));
        for (WebElement product : productType) {
            if (product.getText().equalsIgnoreCase("")) {
                product.click();
            }}

        }
        public void selectByValueFromDropDown (By by, String text){

            Select select = new Select(driver.findElement(by));
            select.selectByValue(text);
        }





}

