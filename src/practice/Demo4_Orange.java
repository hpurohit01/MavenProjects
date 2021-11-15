package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Demo4_Orange {


    public static void main(String[] args) {

        String  baseUrl= "https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers";

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement xpath= driver.findElement(By.xpath("//div[@id='divLogo']"));
        System.out.println("displayed logo"+xpath);

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.findElement(By.xpath("//input[@id='employee-search,employee-name']")).sendKeys("hpurohit");
        driver.findElement(By.xpath("//input[@id='txtUserid']")).sendKeys("xyz@gmail.com");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        System.out.println("Welcome hpurohit");








    }

}
