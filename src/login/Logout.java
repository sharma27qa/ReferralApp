package login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Logout {
	WebDriver driver;

	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asharma\\Desktop\\chromedriver_latest\\chromedriver.exe");
		driver= new ChromeDriver();
	    driver.get("http://win2012r2s2:4200/#/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("email")).sendKeys("anjali.sharma@nutekds.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.className("dx-button-content")).click();
		driver.findElement(By.xpath("//img[@class='dx-icon']")).click();
}
	@Test (enabled= false)
	public void logout() 
	{ 
        driver.findElement(By.xpath("(//div[@role='option'])[2]")).click();
	}
	
@Test (enabled= false)
public void profile_Edit_Save() throws InterruptedException
{
	driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();
	driver.findElement(By.xpath("//dx-button[@aria-label='Edit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//form-textbox[@label='Middle Name']")).click();
	driver.findElement(By.xpath("//form-textbox[@label='Middle Name']")).sendKeys("nayan");
	driver.findElement(By.xpath("//dx-button[@aria-label='Save']")).click();
	
	
	
	}
@Test (enabled= false)
public void editPP() 
{
	driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();
	driver.findElement(By.id("dropzone-external")).click();
	}

@Test
public void changePassword () throws InterruptedException
{
	////dx-button[@text="Create account"] --> xpath for create account button
	driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();	
	driver.findElement(By.xpath("//dx-button[@text=\"Change Password\"]")).click();
	driver.findElement(By.name("password")).sendKeys("1234");
	driver.findElement(By.name("confirmedPassword")).sendKeys("1234");
	driver.findElement(By.xpath("//span[@class='dx-button-text dx-template-wrapper dx-button-content']")).click();
	//need to add validation msg window handler for successful submission of password.
	//it should get redirected to the login page after changing the password.
	//make changes in the below code for login.
	Thread.sleep(2000);
//	driver.findElement(By.name("email")).sendKeys("anjali.sharma@nutekds.com");
//	driver.findElement(By.name("password")).sendKeys("123456");
//	driver.findElement(By.className("dx-button-content")).click();
	
	
//	//div[text()='Password is required']      --- use this while finding when password is not enetered
	
//	//div[text()='Passwords do not match']    --- use this while finding when password is ENTERED WRONG
	
	}
}


