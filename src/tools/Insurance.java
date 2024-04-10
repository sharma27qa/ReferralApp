package tools;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Insurance {
	public class Roles {
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
		public void toolsuserdpdwn() 
		{
			//Actions act = new Actions(driver);
			driver.findElement(By.xpath("//li/div//div[@class='dx-item-content dx-treeview-item-content'][.='Tools']")).click(); //open tools dropdown.
			driver.findElement(By.xpath("//li[@aria-label='Insurances']")).click();  //click on roles
			/*WebElement dblclck = driver.findElement(By.xpath("//div//tr[@aria-rowindex=\"3\"]")); //click on grid to open
			act.doubleClick(dblclck).perform();
			driver.findElement(By.xpath(" //dx-button[@aria-label='Back']")).click();  */
	} 
		@AfterMethod (enabled= false)
		public void teardown() {
		driver.quit();
		}
	}
}
