package homework1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import practice.BaseTest;

public class Demo_1 extends BaseTest {

    String baseUrl = "https://www.google.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);

    }

    @Test

    public void verifyUserShouldAbleToSeeElectronic() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("demo nopCommerce store");
        driver.findElement(By.xpath("//span[@class='QCzoEc z1asCe MZy1Rb']")).click();
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']")).click();

        String expectedMessage = "Electronics";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),'Electronics')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Electronics Page not found", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldAbleToSeeJewelry() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("demo nopCommerce store");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']")).click();
        //  driver.findElement(By.linkText("jewelry"));
        String expectedMessage = "Jewelry";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text)(),'Jewelry')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("jewelry page not found", expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldAbleToSeeGiftcard() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("demo nopCommerce store");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift card ']")).click();

        //driver.findElement(By.linkText("Gift card"));
        String expectedMessage = "Gift card";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text)(),'Gift card ')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Gift card page not found", expectedMessage, actualMessage);

    }

    @Test
    public void verifyUserShouldAbleToSeeBooks() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("demo nopCommerce store");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']")).click();
        //driver.findElement(By.linkText("Books"));
        String expectedMessage = "Books";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text)(),Books ']"));
        String actualMessage = message.getText();
        Assert.assertEquals("Books page not found", expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldAbleToSeeDigitalDownloads() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("demo nopCommerce store");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital Downloads ']")).click();
       // driver.findElement(By.linkText("Digital downloads"));
        String expectedMessage = "Digital downloads";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),Digital Downloads ')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Digital downloads page not found", expectedMessage, actualMessage);
    }

    @Test
    public void verifyUserShouldAbleToSeeApparel() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("demo nopCommerce store");
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']/center/input[1]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']")).click();

       // driver.findElement(By.linkText("Apparel"));
        String expectedMessage = "Apparel";
        WebElement message = driver.findElement(By.xpath("//h1[contains(text(),Apparel ')]"));
        String actualMessage = message.getText();
        Assert.assertEquals("Apparel page not found", expectedMessage, actualMessage);
    }

}
