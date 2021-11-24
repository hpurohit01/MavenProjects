package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

import java.util.List;

public class TestSuite extends Utilities {

    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }
   @Test
    public void verifyProductArrangeInAlphaBaticalOrder()throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));

       Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
       Thread.sleep(1000);
       selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"),"6");
       String expectedMessage = "Name: Z to A";
       String actualMessage=getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
       Assert.assertEquals("text did not matched",expectedMessage,actualMessage);

       }

       @Test

       public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
           driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")).click();
           driver.findElement(By.xpath("(//a[normalize-space()='Desktops'])[1]")).click();
          // WebElement dropDown = driver.findElement(By.id("products-orderby"));
           WebElement dropDown=driver.findElement(By.id("//select[@id='products-orderby']"));
           Thread.sleep(2000);
           Select select=new Select(dropDown);
           select.selectByIndex(1);
           Thread.sleep(1000);
           List<WebElement>product=driver.findElements(By.className("product-item"));

           for (int i=0;i<product.size();i++) {
               String name = product.get(i).getText();
               if (name.contains("Build your own computer")) {
                   clickOnElement(By.xpath("//button[text('Add to cart']"));
               }
           }
           String expectedMessage="Build  your own computer";
           String actualMessage =driver.findElement(By.xpath("//h1[contains(text(),'Build  your own computer')]")).getText();
           Assert.assertEquals(expectedMessage,actualMessage);

           selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_1']"),"2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
           selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"),"8GB[+$60.00]");
           driver.findElement(By.xpath("//input[@id='produce_attribute_3_7']")).click();
           driver.findElement(By.xpath("//input[@id='produce_attribute_5_12']")).click();
           driver.findElement(By.xpath("//input[@id='produce_attribute_4_9']")).click();
           String expectedPrice="$1,475.00";
           String actualPrice=driver.findElement(By.xpath("//span[contains(text(),'$1,475.00')]")).getText();
           Assert.assertEquals(expectedPrice,actualPrice);
           driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']")).click();
           driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).getText();
          // driver.findElement(By.xpath("//span[@title='Close']")).click();
          // clickOnElement(By.xpath("span[@class='cart-label']"));



          // driver.findElement(By.xpath("//html/body/div[6]/div[3]/div/div[2]/ div/div/form/div[2]/div[1]/div[2]/div[9]/div/button")).getText();
           Assert.assertEquals(expectedPrice,actualPrice);
           driver.findElement(By.xpath("//button[@id=add-to-cart-button-1']")).click();
           String actualAddMsg=driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
           String expectedAddMsg ="The product has been added to your shopping cart";
           Assert.assertEquals(expectedAddMsg,actualAddMsg);
           clickOnElement(By.xpath("//*[@id=\"bar- notification\"]/div/span"));

           //mouseHoverAndClickToElement(By.xpath("//span[contains(text(),Shopping cart')"]),"Go to cart");
           driver.findElement(By.xpath("//button[contains(text(),Go to cart')]")).click();
           Actions actions = new Actions(driver);
           driver.findElement(By.xpath("//html/body/div[6]/div[3]/div/div/div /div[2]/div/form/div[1]/table/tbody/tr/td[5]/input")).sendKeys(Keys.BACK_SPACE);
           driver.findElement(By.xpath("//button[contains(text(),'Update shopping cart')]")).click();

           String expectedMessage2 = driver.findElement(By.xpath("//html/body/div[6]/div[3]/div/div/div /div[2]/div/form/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong")).getText();
           String actualMessage2 = "$2,950.00";
           Assert.assertEquals(expectedMessage2,actualMessage2);

           driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
           driver.findElement(By.xpath("//button[@id='checkout']")).click();
           String expectedMsg2 = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Please Sign In!')]")).getText();

           driver.findElement(By.xpath("//button[contains(text(),'Checkout as Guest')]")).click();
           driver.findElement(By.xpath("//input[@id='BillingNewAddress_First Name'])")).sendKeys("Sam");
           driver.findElement(By.xpath("//input[@id='BillingNewAddress_Last Name')]")).sendKeys("Murphy");
           driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']")).sendKeys("xyz123@gmail.com");
           driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']")).sendKeys("Abba123");
           selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United States");

           driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("NewYork");
           driver.findElement(By.xpath("//input[@='BillingNewAddress_StreetName']")).sendKeys("High street");
           driver.findElement(By.xpath("//input[@='BillingNewAddress_ZipCode']")).sendKeys("NA5 6WK");
           driver.findElement(By.xpath("//input[@='BillingNewAddress_PhoneNumber")).sendKeys("0987654321");
           driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]button[4]")).click();
           driver.findElement(By.cssSelector("/#paymentmethod_1")).click();
           selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"),"Master card");
           driver.findElement(By.xpath("//input[@id='CardNumber']")).sendKeys("12345689123456");
           selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2025");
           selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"01");
           driver.findElement(By.xpath("//inpute[@id='SecurityCody']")).sendKeys("999");
           String actualPaymentMethod="Credit Card";
           String expctedPaymentMethod=driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
           Assert.assertEquals(actualPaymentMethod,expctedPaymentMethod);
           String actualDeliveryMethod="Next Day";
           String expctedDeliveryMethod=driver.findElement(By.xpath("//div[@class='shipping-options-body']//div[2]//div[1]//label[1]")).getText();
           Assert.assertEquals(actualDeliveryMethod,expctedDeliveryMethod);
           String actualTotal="$2,950.00";
           String expectedTotal=driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00']")).getText();
           Assert.assertEquals(actualTotal,expectedTotal);
           driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();
           String actualOrderMsg="Your order has been successfully processed";
           String expectedOrderMsg=driver.findElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed']")).getText();

           Assert.assertEquals(actualOrderMsg,expectedOrderMsg);
           driver.findElement(By.xpath("//button[normalize- space()='Continue']")).click();
           String actualWelcomeMsg = "Welcome to our store";
           String expectedWelcomeMsg = driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).getText();
           Assert.assertEquals(actualWelcomeMsg,expectedWelcomeMsg);
       }
         @After
          public void tearDown(){

         }
}



