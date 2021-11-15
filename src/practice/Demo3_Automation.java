package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo3_Automation {
    public static void main(String[] args) {

        String  baseUrl= "http://automationpractice.com/index.php";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement signInLink =driver.findElement(By.linkText("Sign in"));
        signInLink.click();

        WebElement emailField = driver.findElement(By.cssSelector("email"));
        emailField.sendKeys("xyz@gmail.com");
        WebElement signInBtn = driver.findElement(By.cssSelector("password submit"));
        signInBtn.click();

        WebElement emailField1 = driver.findElement(By.cssSelector("input[id=email]"));
        emailField1.sendKeys("Admin123");
        System.out.println("Error:User unable to log in ");
        driver.close();


    }
}
