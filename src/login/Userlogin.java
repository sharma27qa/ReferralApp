package login;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Userlogin {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asharma\\Desktop\\chromedriver_latest\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	driver.get("http://win2012r2s2:4200/#/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
		
	@Test (enabled= false)
	public void InValidlogin()
	{
		driver.findElement(By.name("email")).sendKeys("anj.sharma@nutekds.com");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.className("dx-button-content")).click();
		
		}
@Test (enabled= false)
public void Validlogin()
{
	driver.findElement(By.name("email")).sendKeys("anjali.sharma@nutekds.com");
	driver.findElement(By.name("password")).sendKeys("123456");
	driver.findElement(By.className("dx-button-content")).click();
	
	}

@Test
public void forgotPassword()
{
	driver.findElement(By.linkText("Forgot password?")).click();
	 WebElement specificElement = driver.findElement(By.className("description"));
     String elementText = specificElement.getText();
     System.out.println("Text from specific element: " + elementText);
     driver.findElement(By.xpath("//input[@name=\"email\"]")).click();
     driver.findElement(By.xpath("//span[@class='dx-button-text dx-template-wrapper dx-button-content']")).click();  ///rest password button
   //return to sign in can be done by link text "sign in "
     WebElement emailvalidation = driver.findElement(By.xpath("//input[@name=\"email\"]"));
     String elementText2 = emailvalidation.getText();
     System.out.println("Text from specific element: " + elementText2);
	
	}
		}
	
