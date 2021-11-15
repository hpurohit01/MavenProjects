package practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Demo2_NopCommerce extends BaseTest {

        String  baseUrl = "https://demo.nopcommerce.com/";

        @Before
        public void setUp(){
        openBrowser(baseUrl);

    }
    @Test
    public void verifyRegisterPage(){
        driver.findElement(By.xpath("//input[@class='glFyf gsf1']")).sendKeys("demo nopcommerce store");
        driver.findElement(By.xpath("//input[@class='gNO89b']")).click();
        driver.findElement(By.xpath("//a[@href='https://demo.nopcommerce.com/']")).click();
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Hemal");
        driver.findElement(By.xpath("//input[@id=LastName']")).sendKeys("Purohit");
        driver.findElement(By.xpath("//select[@name=DateOfBirthDay']")).sendKeys("01");
        driver.findElement(By.xpath("//select[@name=DateOfBirthMonth']")).sendKeys("12");
        driver.findElement(By.xpath("//select[@name=DateOfBirthYear']")).sendKeys("1985");

        driver.findElement(By.xpath("//input[@id=Email']")).sendKeys("xyx@gmail.com");
        driver.findElement(By.xpath("//input[@id=Password']")).sendKeys("abc@21");
        driver.findElement(By.xpath("//input[@id=ConfirmPassword']")).sendKeys("abc@21");
        driver.findElement(By.xpath("//input[@id=Company']")).sendKeys("nopcommerce");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        WebElement message=driver.findElement(By.xpath("//div[@class='page-title"));
        String actualMessage= message.getText();
        System.out.println(actualMessage);
         String expectedmsg="Register";
        Assert.assertEquals(expectedmsg,actualMessage);


    }
}
