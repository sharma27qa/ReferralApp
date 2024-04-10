package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccount {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\asharma\\Desktop\\chromedriver_latest\\chromedriver.exe");
		driver= new ChromeDriver();
    }

    @Test
    public void Create_Account() throws InterruptedException {
        driver.get("http://win2012r2s2:4200");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//app-login-form//dx-button[@text=\"Create account\"]")).click();      //createNew_btn
        driver.findElement(By.name("firstname")).sendKeys("Anju");
        driver.findElement(By.name("middlename")).sendKeys("Kumar");
        driver.findElement(By.name("lastname")).sendKeys("Singh");
        driver.findElement(By.xpath("//form//div[@aria-label=\"Select\"]")).click();   //organization dropdown
        driver.findElement(By.xpath("//div[@class='dx-item-content dx-list-item-content']")).click();  // dropdown option
        driver.findElement(By.name("email")).sendKeys("anuj.singh@xyz.com");                //email
		driver.findElement(By.name("password")).sendKeys("123456");                   //password
		driver.findElement(By.name("confirmedPassword")).sendKeys("123456");               ///confirmed password
		driver.findElement(By.xpath("//span[@class='dx-button-text dx-template-wrapper dx-button-content']")).click();        // create a new account btn
    }
    @AfterMethod 
    public void tearDown()
    {
    	driver.quit();
    }
} 

