package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utilities;

import java.util.List;

public class TopMenuTest extends Utilities {


    String baseUrl="https://demo.nopcommerce.com/";

   @Before
   public void setUo(){
       openBrowser(baseUrl);
   }

    public void selectMenu(String menu)throws InterruptedException {

        Thread.sleep(2000);

        if (menu == "Computers") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers']"));
            String expectedMsg = "Computers";
            String actualMsg = getTextFromElement(By.xpath("//h1[text()='Computers']"));
            Assert.assertEquals("Text not match", expectedMsg, actualMsg);
        }else if (menu == "Electronics") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
            String expectedMsg = "Electronics";
            String actualMsg = getTextFromElement(By.xpath("//h1[text()='Electronics']"));
            Assert.assertEquals("Text not match", expectedMsg, actualMsg);
        }else if (menu == "Apparel") {
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
            String expectedMsg = "Apparel";
            String actualMsg = getTextFromElement(By.xpath("//h1[text()='Apparel']"));
            Assert.assertEquals("Text not match", expectedMsg, actualMsg);
        }else if (menu=="Digital downloads"){
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']"));
        String expectedMsg = "Digital downloads";
        String actualMsg = getTextFromElement(By.xpath("//h1[text()='Digital downloads']"));
        Assert.assertEquals("Text not match", expectedMsg,actualMsg);
        }else if (menu=="Books"){
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']"));
            String expectedMsg = "Books";
            String actualMsg = getTextFromElement(By.xpath("//h1[text()='Books']"));
            Assert.assertEquals("Text not match", expectedMsg, actualMsg);
        }else if (menu=="Jewelry"){
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']"));
            String expectedMsg = "Jewelry";
            String actualMsg = getTextFromElement(By.xpath("//h1[text()='Jewelry']"));
            Assert.assertEquals("Text not match", expectedMsg, actualMsg);
        }else if (menu=="Gift Cards"){
            clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']"));
            String expectedMsg = "Gift Cards";
            String actualMsg = getTextFromElement(By.xpath("//h1[text()='Gift Cards']"));
            Assert.assertEquals("Text not match", expectedMsg, actualMsg);
        }


       }
       @Test
    public void verifyPageNavigation()throws InterruptedException{
           List<WebElement>menuItems=driver.findElements(By.xpath("//ul[@class='top=menu notmobile']"));
           for (WebElement item:menuItems);
           selectMenu("Computers");
           selectMenu("Electronics");
           selectMenu("Apparel");
           selectMenu("Books");
           selectMenu("Jewelry");
           selectMenu("Gift Cards");
           selectMenu("Digital downloads");



       }
   }


    


