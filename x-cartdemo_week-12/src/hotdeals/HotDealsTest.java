package hotdeals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;

public class HotDealsTest extends Utilities {

    String baseUrl="https://mobile.x-cart.com/";

    @Before

    public void setUp(){
        openBrowser(baseUrl);

    }
    @Test

    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement HotDeal=driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Sale=driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        actions.moveToElement(HotDeal).moveToElement(Sale).click().build().perform();

        String expectedMessage ="Sale";
        String actualMessage =getTextFromElement(By.id("title"));
        Assert.assertEquals("User should not able to mouse hover to Sale",expectedMessage,actualMessage);
       // mouseHoverAndAction(By.xpath("//span[@class='sort-by-value']"));
        driver.findElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
        WebElement sortby= driver.findElement(By.xpath("//span[@class='sort-by-label']"));
        driver.findElement(By.xpath("//div[contains(@class,'sort-box')]//div")).click();
        WebElement Addtocart=driver.findElement(By.xpath("(//span[contains(text(),'Add to cart')])[1]"));
        //button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')]
        //WebElement dropDown1 = driver.findElement(By.xpath("//span[contains(text(),'Sort by:')]"));
       // Thread.sleep(3000);
       // Select select = new Select(dropDown1);
        //select.selectByIndex(4);
        selectByVisibleTextFromDropDown(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='main-wrapper']/div[@id='main']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")," Name A - Z");
        expectedMessage= " Name A to Z";
        actualMessage=getTextFromElement(By.xpath("//a[normalize-space()='Name A - Z']"));
        Assert.assertEquals("not sorted by alphabet order",actualMessage,expectedMessage);


    }
    @Test

    public void verifySaleProductsPriceArrangeLowToHigh() {
        Actions actions = new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        actions.moveToElement(HotDeal).moveToElement(Sale).click().build().perform();

        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should no able to mouse hover to Sale", expectedMessage, actualMessage);

        WebElement sortby = driver.findElement(By.xpath("//span[@class='sort-by-label']"));
        WebElement dropDown=driver.findElement(By.id("Price"));
       // Thread.sleep(3000);
       // Select select=new Select(dropDown);
       // select.selectByIndex(2);

        WebElement Price= driver.findElement(By.xpath("//a[normalize-space()='Price Low - High']"));


    }@Test
    public void verifySalesProductsArrangeByRates(){
        Actions actions=new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Sale = driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        actions.moveToElement(HotDeal).moveToElement(Sale).click().build().perform();

        String expectedMessage = "Sale";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User unable to reach Sale", expectedMessage, actualMessage);
        //mouseHoverAndAction(By.xpath("//span[@class='sort-by-value']"));
        clickOnElement(By.partialLinkText("Name Z-"));
        WebElement Sortby = driver.findElement(By.xpath("//span[@class='sort-by-value']"));
        WebElement Rates=driver.findElement(By.xpath("//div[@class='content'])[2]"));
    }
    @Test
    public void verifyBestSellersProductArrangeByZToA() {
        Actions actions = new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Bestsellers = driver.findElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        actions.moveToElement(HotDeal).moveToElement(Bestsellers).click().build().perform();

        String expectedMessage = "Bestsellers";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should no able to mouse hover to BestSeller", expectedMessage, actualMessage);
        WebElement sotyby=driver.findElement(By.xpath("//(//span[@class='sort-by-label'])[1]']"));
        WebElement Price= driver.findElement(By.xpath("//a[normalize-space()='Name Z - A']"));


    }
    @Test
    public void verifyBestSellersProductPriceArrangeByHighToLow() {

        Actions actions = new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Bestsellers = driver.findElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        actions.moveToElement(HotDeal).moveToElement(Bestsellers).click().build().perform();

        String expectedMessage = "BestSellers";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should no able to mouse hover to BestSellers", expectedMessage, actualMessage);
        WebElement sotyby = driver.findElement(By.xpath("//(//span[@class='sort-by-label'])[1]']"));
        WebElement Price = driver.findElement(By.xpath("//a[normalize-space()='Price High - Low']"));
        Assert.assertEquals("Product not coming High to Low price range",actualMessage,expectedMessage);

    }
    @Test
    public void verifyBestSellersProductArrangeByRates() {

        Actions actions = new Actions(driver);
        WebElement HotDeal = driver.findElement((By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']")));
        WebElement Bestsellers = driver.findElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"));
        actions.moveToElement(HotDeal).moveToElement(Bestsellers).click().build().perform();

        String expectedMessage = "BestSellers";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should no able to mouse hover to BestSellers", expectedMessage, actualMessage);
        WebElement sotyby = driver.findElement(By.xpath("//(//span[@class='sort-by-label'])[1]']"));
        WebElement Price = driver.findElement(By.xpath("//a[normalize-space()='Price High - Low']"));
        Assert.assertEquals("Product not coming by arrange Rates",actualMessage,expectedMessage);

    }
}
