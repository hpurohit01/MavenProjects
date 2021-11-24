package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class TopMenuTest extends Utilities {

    String baseUrl = " https://mobile.x-cart.com/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldNavigateTOShippingPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//li[@class='leaf']//a[@href='shipping.html']//span[contains(text(),'Shipping')]"));
        String expectedMessage = "Shipping";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should not able to open shipping page", expectedMessage, actualMessage);
    }

    @Test

    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.xpath("//body/div[@id='page-wrapper']/div[@id='page']/div[@id='header-area']/div[@class='desktop-header affix']/div[@class='container']/div[@role='navigation']/div[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav top-main-menu']/li[1]/a[1]"));
        String expectedMessage = "New";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should not able to open New page", expectedMessage, actualMessage);

    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Coming soon')]"));
        String expectedMessage = "Coming soon";
        String actualMessage = getTextFromElement(By.id("title"));
        Assert.assertEquals("User should not able to open Coming soon  page", expectedMessage, actualMessage);

    }
    @Test

    public void verifyUserShouldNavigateToContactusPageSuccessfully(){
        clickOnElement(By.xpath("//span[contains(text(),'Contact us')])[2]"));
        String expectedMessage = "Contact us";
        String actualMessage = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("User should not able to open Contact us page", expectedMessage, actualMessage);

    }
}



