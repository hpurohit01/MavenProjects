package shopping;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;

public class ShoppingTest extends Utilities {
    String baseUrl = "https://mobile.x-cart.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldPlaceOrderSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        actions.moveToElement(HotDeal).moveToElement(Sale).click().build().perform();

        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should not able to mouse hover to Sale", expectedMessage, actualMessage);
        Thread.sleep(2000);
        mouseHoverAndClickOnElement(By.xpath("//span[@class='sort-by-value']"));


        //List<WebElement>productType=driver.findElements(By.xpath("//div[contains(@class,'sort-box')]//div"));
        //  for(WebElement product:productType){
        //   if (product.getText().equalsIgnoreCase("A to Z")) {
        ///  product.click();
        clickOnElement(By.partialLinkText("Name A-"));
        Thread.sleep(2000);
        mouseHoverAndClickOnElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]"));
        driver.findElement(By.xpath("(//div[@class='content'])[2]"));
        String expectedMessagecart = "Product has been added to your cart";
        String actualMessagecart = getTextFromElement(By.xpath("//div@id='status-message']//ul"));
        Assert.assertEquals("Product unable to add in cart", expectedMessagecart, actualMessagecart);
        clickOnElement(By.xpath("//a[@title='Close']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(1000);

        String expectedMessageincart = "Shopping cart add 1-item";
        String actualMessagecincart = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Item not added in cart", expectedMessageincart, actualMessagecincart);
        System.out.println(actualMessagecincart);
        Thread.sleep(1000);

        sendTextToElement(By.xpath("//input[@id='amount16']"), "2");

        Thread.sleep(1000);
        String expectedSubTotal = "$29.98";
        String actualSubtotal = getTextFromElement(By.xpath("//ur[@class='sums']//li[@class='subtotal']"));
        Assert.assertEquals("Subtotal not right", expectedSubTotal, actualSubtotal);

        String expetedTotal = "$32.88";
        String actualTotal = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total amount not match", expetedTotal, actualTotal);

        clickOnElement(By.xpath("//span[normalize-space()='Go to checkout']"));

        String expectedVerify = "Log in to account";
        String actualVerify = getTextFromElement(By.xpath("//h3[normalize-space()='Log in to your account']"));
        Assert.assertEquals("not able to log in", expectedVerify, actualVerify);
        sendTextToElement(By.xpath("//input[@id='email']"), "xyz@gmail.com");
        clickOnElement(By.xpath("//span[contains(text(),Continue']"));
        String expectedSecure = "Secure Checkout";
        String actualSecure = getTextFromElement(By.xpath("//h1[normalize-space()=Secure Checkout']"));
        Assert.assertEquals("Secure Checkout is failed", expectedSecure, actualSecure);

        sendTextToElement(By.xpath("//input[@id='shippingaddress-firstname']"), "Ram");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-lastname']"), "Patel");
        sendTextToElement(By.xpath("/input[@id='shippingaddress-street']"), "55 High street");
        sendTextToElement(By.xpath("//input[@id='shippingaddress']"), "London");
        Thread.sleep(2000);
        selectByMouseToElement(By.xpath("//select[@id='shippingaddress-country-code']"), "UK");
        selectByMouseToElement(By.xpath("//select[@id=shippingaddress-zipcode']"), "HA3 5DE");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@='create profile']"));
        sendTextToElement(By.xpath("//input[@id='password']"), "abc@123");

        String expectedLasttotal = "$33.95";
        String actualLastTotal = getTextFromElement(By.xpath("//li[@class='total']"));
        Assert.assertEquals("Total Last amount not showing", expectedLasttotal, actualLastTotal);
        clickOnElement(By.xpath("//button[@class='btn regular-button regular-main-button place-order submit']"));
        String expectedThanksMessage = "Thank you for your order";
        String actualThanksMessage = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Thank you for order page not found", expectedThanksMessage, actualThanksMessage);
    }

    @Test
    public void verifyUserShouldClearShoppingCartSuccessfully()throws InterruptedException {
        //mouseHoverAndAction(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
       // mouseHoverAndAction(By.xpath("//ul[@class='nav navbar-new top-main-menu']//span[text()='Bastsellers']")).click();
        Actions actions = new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Bestseller=driver.findElement(By.xpath("//ul[@class='nav navbar-new top-main-menu']//span[text()='Bastsellers']"));
        WebElement Sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        actions.moveToElement(HotDeal).moveToElement(Sale).click().build().perform();
        Thread.sleep(2000);
        String expectedText1="Bestseller";
        String actualText1=getTextFromElement(By.xpath("//h1[text()='Bastsellers']"));
        Assert.assertEquals("Bestseller Test unable to match",expectedText1,actualText1);
        WebElement sortyby=driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));//span[contains(text(),'Sort by:')]
        clickOnElement(By.partialLinkText("Name A-"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[contains(text(),'Products:'9')]"));//span[contains(text(),'Products:')]
        clickOnElement(By.xpath("//button[contains(@class,'regular-button add-to-cart product-add2cart productid-42')]//span[contains(text(),'Add to cart')]"));

        String expectedMessage="Product has been add to cart";
        String actualMessage=getTextFromElement(By.xpath("/li[(text()='Product has to been added to your cart"));
        Assert.assertEquals("Message did not match",expectedMessage,actualMessage);
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='close']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/h1[1]"));
        clickOnElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[4]/div[3]/div[1]/a[1]"));
        String expectedCartItem="1-Item in cart";
        String actualCartItem=getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Item Message not match",expectedCartItem,actualCartItem);
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Empty your cart']"));
        Alert alert=driver.switchTo().alert();
        String expectrdPopup="Are you sure you want to clear cart";
        String actualPopup=alert.getText();
        Assert.assertEquals("Wrong alert",expectedCartItem,actualCartItem);
       // alert(By.xpath("//a[contains(text(),'Empty your cart']"));
        String expectedDeleteMessage="Item deleted from cart";
        String actualDeleteMessage=getTextFromElement(By.xpath("//li(text()='Item()deteted from cart"));
        Assert.assertEquals("Item is not deleted from cart",expectedDeleteMessage,actualDeleteMessage);
        Thread.sleep(1000);
        String expectedEmptyMsg="your cart is empty";
        String actualEmptyMsg=getTextFromElement(By.xpath("//h1[text()='Your cart is empty']"));
        Assert.assertEquals("Cart is not empty",expectedEmptyMsg,actualEmptyMsg);








    }
}

















    



