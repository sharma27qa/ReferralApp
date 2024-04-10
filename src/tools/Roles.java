package tools;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	@Test(enabled= false)
	public void toolsuserdpdwn() 
	{
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//li/div//div[@class='dx-item-content dx-treeview-item-content'][.='Tools']")).click(); //open tools dropdown.
		driver.findElement(By.xpath("//li[@aria-label='Roles']//span")).click();  //click on roles
		WebElement dblclck = driver.findElement(By.xpath("//div//tr[@aria-rowindex=\"3\"]")); //click on grid to open
		act.doubleClick(dblclck).perform();
		driver.findElement(By.xpath(" //dx-button[@aria-label='Back']")).click();
} 
	@Test
	public void roleEntry() throws InterruptedException
	{
		driver.findElement(By.xpath("//li/div//div[@class='dx-item-content dx-treeview-item-content'][.='Tools']")).click(); //open tools dropdown.
		driver.findElement(By.xpath("//li[@aria-label='Roles']//span")).click();  //click on users
		driver.findElement(By.xpath("//dx-button[@aria-label='Add Roles']")).click();
		//driver.findElement(By.xpath("//div//dx-button[@aria-label='Save']")).click();
		
		 driver.findElement(By.xpath("//input[@class='form-editor-input dx-texteditor-input']")).sendKeys("test");
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanMoveToArchiveOrWork')]")).click();
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanManagePatientEntry')]")).click();
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanDeletePatientEntry')]")).click();
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanManageDataEntry')]")).click();
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanUpdateMasters')]")).click(); 
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanManageUsers')]")).click(); 
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanViewArchive')]")).click(); 
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanSendEmail')]")).click(); 
		 driver.findElement(By.xpath("//dx-check-box[contains(.,'CanUndoRedo')]")).click(); 
		 driver.findElement(By.cssSelector("div[class='dx-last-row dx-field-item dx-col-1 dx-field-item-optional dx-flex-layout'] span[class='dx-checkbox-text']")).click(); 
		 driver.findElement(By.xpath("(//span[@class='dx-checkbox-text'])[11]")).click();
		// driver.findElement(By.xpath("//dx-button[@text=\"Cancel\"]")).click();   //to click on cancel button
		driver.findElement(By.xpath("//div//dx-button[@aria-label='Save']")).click();    //to click on save button.
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();  // to save new entry.
		
		 	}
@AfterMethod (enabled= false)
public void teardown() {
driver.quit();
}
}

