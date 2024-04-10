package outboundReferrals;

import java.time.Duration;

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


public class Tabs {
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
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.className("dx-button-content")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Outbound Referrals']")).click(); //open outbound dropdown.
		driver.findElement(By.xpath("//span[normalize-space()='Draft']")).click();   //click on draft. 
}
	
	@Test (enabled=false)
	public void patients() throws InterruptedException
	{
		//no functionality other than Refresh button
		//Actions act = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.id("dx-70e5eb7d-125f-2571-a95a-d12e7a1bda41")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Referesh\"]")).click();
		
		
	}
	@Test (enabled=false)
	public void callLog() throws InterruptedException
	{
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Call Logs']")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Add\"]")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//form//div//dx-button[@text=\"Save\"]")).click();
	    Alert alert= driver.switchTo().alert(); System.out.println(alert);
		alert.accept();
		driver.findElement(By.xpath("//form//div//dx-button[@text=\"Cancel\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//dx-button[@text=\"Add\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//dx-text-area[@label='Call Comment']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//driver.findElement(By.xpath("//dx-text-area[@label='Call Comment']")).sendKeys("Call test");
		WebElement callCommentField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//dx-text-area[@label='Call Comment']")));
		callCommentField.sendKeys("Call test"); 
	}
	
	@Test (enabled=false)
	public void preauth() throws InterruptedException
	{
		//to enable pre auth.
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();  // change this everytime row list.
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Pre-Auth']")).click();
		driver.findElement(By.xpath("//dx-button[@aria-label='Edit']")).click();
		/*driver.findElement(By.xpath("(//div[@aria-label='Select'])[3]")).click();    //business status dropdown
		driver.findElement(By.xpath("//div[text()='Pre Authorization Request']")).click();      // select business status  
		driver.findElement(By.xpath("//dx-button[@aria-label='Save']")).click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		System.out.println(alert);
		alert.accept(); */
		
		//Pre auth functionality 
		driver.findElement(By.xpath("(//dx-button[@aria-label='Clear'])[2]")).click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		System.out.println(alert);
		alert.accept();
		driver.findElement(By.xpath("(//dx-button[@aria-label='Save'])[2]")).click();
		Thread.sleep(2000);
		Alert alertsave= driver.switchTo().alert();
		System.out.println(alertsave);
		alertsave.accept();
		driver.findElement(By.xpath("//dx-button[@aria-label='Insurance Lookup']")).click();  //insurance lookup
		
	}
	@Test (enabled=false)
	public void appoitment()
	{
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Appointment']")).click();
	}
	@Test (enabled=false)
	public void providers() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Providers']")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Delete\"]")).click();
		Thread.sleep(2000);
		Alert alertdelete= driver.switchTo().alert();
		System.out.println(alertdelete);
		alertdelete.accept();
		driver.findElement(By.xpath("//dxi-item[@title=\"Providers\"]//dx-button[@text=\"Add\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form//div//dx-button[@aria-label=\"Save\"]")).click();
		Thread.sleep(2000);
		 Alert alert= driver.switchTo().alert(); System.out.println(alert);
	    alert.accept();
	    driver.findElement(By.xpath("(//div[@class='dx-dropdowneditor-icon'])[2]")).click();
	    driver.findElement(By.xpath("//div[@class=\"dx-item dx-list-item\"][1]")).click();     //Admitting Physician
		/*
		 * driver.findElement(By.xpath("//div[@class=\"dx-item dx-list-item\"][2]")).
		 * click(); //Attending Physician
		 * driver.findElement(By.xpath("//div[@class=\"dx-item dx-list-item\"][3]")).
		 * click(); //Consulting Physician
		 * driver.findElement(By.xpath("//div[@class=\"dx-item dx-list-item\"][4]")).
		 * click(); //Other Physician
		 * driver.findElement(By.xpath("//div[@class=\"dx-item dx-list-item\"][5]")).
		 * click(); //Primary Care Physician
		 */	
	   driver.findElement(By.xpath("//div//form//dx-button[@text=\"Lookup\"]")).click();

	   driver.findElement(By.xpath("//td[normalize-space()='Dominik English']")).click();
	  Thread.sleep(5000);
	    driver.findElement(By.xpath("//form//div//dx-button[@aria-label=\"Cancel\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//dxi-item[@title=\"Providers\"]//dx-button[@text=\"Add\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='dx-dropdowneditor-icon'])[2]")).click();
	    driver.findElement(By.xpath("//div[@class=\"dx-item dx-list-item\"][1]")).click(); 
	    driver.findElement(By.xpath("//div//form//dx-button[@text=\"Lookup\"]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//td[@class='dx-cell-focus-disabled'][normalize-space()='Ari Jefferson']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//form//div//dx-button[@aria-label=\"Save\"]")).click();
		Thread.sleep(2000);
		 Alert alertsave= driver.switchTo().alert(); System.out.println(alertsave);
		 alertsave.accept();
		 
	    }
	@Test (enabled=false)
	public void insurance() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Insurances']")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Delete\"]")).click();
		Thread.sleep(2000);
		Alert alertdelete= driver.switchTo().alert();
		System.out.println(alertdelete);
		alertdelete.accept();
		driver.findElement(By.xpath("//dxi-item[@title=\"Insurances\"]//dx-button[@text=\"Add\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form//div//dx-button[@aria-label=\"Save\"]")).click();
		Thread.sleep(2000);
		 Alert alert= driver.switchTo().alert(); System.out.println(alert);
	    alert.accept();
	 

	    driver.findElement(By.xpath("//form-textbox[@label='Member Number*']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//form-textbox[@label='Member Number*']")).sendKeys("78458");
	}
	@Test (enabled=false)
	public void notes()
	{
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Notes']")).click();
		driver.findElement(By.xpath("//dxi-item[@title=\"Notes\"]//dx-button[@text=\"Add\"]")).click();
		driver.findElement(By.xpath("//dx-text-area[@label=\"Note Details\"]")).click();
		driver.findElement(By.xpath("//dx-text-area[@label=\"Note Details\"]")).sendKeys("notes");
	}
	@Test (enabled=false)
	public void documents()
	{
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"7\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Documents']")).click();
	}
	
	@AfterMethod (enabled=false)
	public void Close()
	{
		driver.quit();
	}
}
