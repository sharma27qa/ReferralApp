package tools;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Users {
	WebDriver driver;

	@BeforeMethod
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
	}
	
	@Test
	public void toolsuserdpdwn () throws InterruptedException
	{
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//li/div//div[@class='dx-item-content dx-treeview-item-content'][.='Tools']")).click(); //open tools dropdown.
		driver.findElement(By.xpath("//span[normalize-space()='Users']")).click();  //click on users
		WebElement dblclck = driver.findElement(By.xpath("//div//table//tr[@aria-rowindex='3']")); //click on grid to open
		act.doubleClick(dblclck).perform();
		driver.findElement(By.xpath(" //dx-button[@aria-label='Back']")).click();
		WebElement dblclck1 = driver.findElement(By.xpath("//div//table//tr[@aria-rowindex='3']")); //click on grid to open
		act.doubleClick(dblclck1).perform();
		driver.findElement(By.xpath("//dx-button[@aria-label='Edit']")).click();
		WebElement Middlename= driver.findElement(By.xpath("//dx-text-box[@id='midName']//input[@role='textbox']"));
		Middlename.click();
		Middlename.sendKeys("kumar");
		//driver.findElement(By.id("midName")).sendKeys("kumar");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        WebElement firstNameTextBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("midName")));
//		Thread.sleep(10000);
//
//	    // Clear existing text and insert new text
//	    firstNameTextBox.clear();
//	    firstNameTextBox.sendKeys("YourFirstName");
		driver.quit();
	}
	
	@Test()
	public void userEntry()
	{
		driver.findElement(By.xpath("//li/div//div[@class='dx-item-content dx-treeview-item-content'][.='Tools']")).click(); //open tools dropdown.
		driver.findElement(By.xpath("//span[normalize-space()='Users']")).click();  //click on users
		driver.findElement(By.xpath("//div//dx-button[@text='Add User']")).click();
		//Alert alert= driver.switchTo().alert();
		//driver.findElement(By.xpath("//div//dx-button[@aria-label='Save']")).click();
		driver.findElement(By.xpath("(//input[@role='textbox'])[2]")).sendKeys("Priya");
		driver.findElement(By.xpath("(//input[@role='textbox'])[3]")).sendKeys(".");
		driver.findElement(By.xpath("(//input[@role='textbox'])[4]")).sendKeys("Dhawan");
		driver.findElement(By.xpath("(//input[@role='textbox'])[5]")).sendKeys("Priya.dhwan@drt.com");
		driver.findElement(By.xpath("(//input[@role='textbox'])[6]")).sendKeys("123456789");
		driver.findElement(By.xpath("//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']")).click();
		Select role = new Select(driver.findElement(By.xpath("//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']")));
		//role.selectByVisibleText("Office");
		role.selectByValue("1");
		//driver.findElement(By.xpath("//div//dx-button[@aria-label='Save']")).click();
	}
	@AfterMethod (enabled= false)
	public void teardown() {
	driver.quit();
	}
	}


