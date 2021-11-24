package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

import java.util.Random;

public class ElectronicsTest extends Utilities {

    String baseUrl="https://demo.nopcommerce.com/";

    @Before
   public void setUp(){
        openBrowser(baseUrl);

    }
    @Test
    public void verifyUserShouldNavigateToCellPhoneSuccessfully()throws InterruptedException{


        //mouseHoverAndClickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()=='Electronics ']"));
      //  mouseHoverAndClickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        driver.findElement(By.xpath("//html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
        String expectedMsg="Cell Phone";
        String actualMsg=driver.findElement(By.xpath("//h1[normalize-space()='Cell phones']")).getText();
        Assert.assertEquals("Cell Phone not found",expectedMsg,actualMsg);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]")).click();
        String expectedMsg1="Nokia Lumia 1020";
        String actualMsg1=getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("User not able to click Nokia Lumia 1020",expectedMsg1,actualMsg1);


    }
    @Test
    public void verifyThatProductAddSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException{

        driver.findElement(By.xpath("//html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]")).click();
        clickOnElement(By.xpath("//div[@class='picture']//img[@title='Show details for Nokia Lumia 1020']"));
        String expectedMsg="Cell Phone";
        String actualMsg=driver.findElement(By.xpath("//h1[normalize-space()='Cell phones']")).getText();
        Assert.assertEquals("Cell Phone not found",expectedMsg,actualMsg);
        String expectedPrice="$349.00";
        String actualPrice=getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Nokia Lumia Price not correct",expectedPrice,actualPrice);
        Thread.sleep(1000);
        clearValue(By.xpath("//input[@id='product_enteredQuantity_20']"));
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Assert.assertEquals("The product has been added to your shopping cart",expectedMsg,actualMsg);
        //mouseHoverAndClick(By.xpath("//button[@id='add-to-cart-button-20']"));
        String expectedMsg1="Add to Card";
        String actualMsg1=getTextFromElement(By.xpath("(//input[@id='product_enteredQuantity_20'])[1]"));
        Assert.assertEquals("The product is not added to your shopping cart",expectedMsg1,actualMsg1);
        clickOnElement(By.xpath("(//input[@id='product_enteredQuantity_20'])[1]"));
        clickOnElement(By.xpath("//span[@class='close']"));
        mouseHoverAndClickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[normalize-space()='Go to cart']"));

        String expectedText2 ="Shopping cart";
        String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User should not able to see product in shopping cart",expectedText2,actualText2);
        String expectedText4 ="$698.00";
        String actualText4 = getTextFromElement(By.xpath("//tr[@class='order-total']//strong[text()='$698.00']"));
        Assert.assertEquals("User should not able to see price $698.00",expectedText4,actualText4);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        clickOnElement(By.xpath("//button[@id='checkout']"));
        String expectedText5 ="Welcome, Please Sign In!";
        String actualText5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Text did not match",expectedText5,actualText5);


        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        String expectedText6 ="Register";
        String actualText6 = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Text did not match",expectedText6,actualText6);
        sendTextToElement(By.id("FirstName"),"Jose");
         sendTextToElement(By.id("LastName"),"Murphy");

        Thread.sleep(1000);

        Random random = new Random();
        int randomNum = random.nextInt(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"),"abc"+randomNum+"@yahoo.com");
        sendTextToElement(By.xpath("//input[@id='Company']"),"xyz");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"),"xyz123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"xyz123");


        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@name='register-button']"));

        String expectedMessage7 = "Your registration completed";
        String actualMessage7 = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Message did not match",expectedMessage7,actualMessage7);


        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        String expectedText8 = "Shopping cart";
        String actualText8 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Message did not match",expectedText8,actualText8);

        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        clickOnElement(By.xpath("//button[@id='checkout']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"Jose");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Murphy");
        clearValue(By.xpath("//input[@id='BillingNewAddress_Email']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"xyz@gmail.com");
        sendTextToElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"United Kingdom");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"35-43 High street");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"HA3 5DE");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"02088881234");
        Thread.sleep(500);


        mouseHoverAndClickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        Thread.sleep(1000);


        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        mouseHoverAndClickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//div[@class='payment-details']//label[text()='Credit Card']"));
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='CreditCardType']"),"visa");

        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr Josh Murphy");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"12345612345678");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"08");
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2023");

        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"999");

        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]"));

        String expectedText9 = "Credit Card";
        String actualText9 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Text verify",expectedText9,actualText9);

        String expectedText10 = "2nd Day Air";
        String actualText10 = getTextFromElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"));
        Assert.assertEquals("Text verify",expectedText10,actualText10);

        String expectedText11 = "$698.00";
        String actualText11 = getTextFromElement(By.xpath("//tr[@class='order-total']//strong[text()='$698.00']"));
        Assert.assertEquals("Text verify",expectedText11,actualText11);

        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        String expectedText12 = "Thank you";
        String actualText12 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Text verify",expectedText12,actualText12);

        String expectedText13 = "Your order has been successfully processed!";
        String actualText13 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Text verify",expectedText13,actualText13);

        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        String expectedText14 = "Welcome to our store";
        String actualText14 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Text verify",expectedText14,actualText14);

        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        String expectedUrl ="https://demo.nopcommerce.com/";
        String actualUrl ="baseUrl";
        Assert.assertEquals("Url verify",expectedUrl,actualUrl);
        System.out.println(actualUrl);

    }
}


