package outboundReferrals;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

public class Workflow {
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
		}
	@Test 
	public void draft_to_unknown() throws InterruptedException
	{	
		driver.findElement(By.xpath("//span[normalize-space()='Draft']")).click();  // to click on draft
		//Actions act = new Actions(driver);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//li[@aria-label='Accepted']//span")).click();        //accepted nav
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"12\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();   
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//dx-button[@text='Add External']")).click();      //to click on add external button
		
		Duration timeout = Duration.ofSeconds(10);

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement ExternalSpecialty = driver.findElement(By.xpath("//form-textbox[@label=\"External Specialty\"]"));
		WebElement ExternalProvider = driver.findElement(By.xpath("//form-textbox[@label=\"External Provider\"]"));
		// Check if ExternalSpecialty field is enabled
		if (ExternalSpecialty.isEnabled()) {
		    System.out.println("ExternalSpecialty field is enabled.");
		  Actions actions = new Actions(driver);
		  actions.moveToElement(ExternalSpecialty).click().sendKeys("Cardiologist").build().perform();
  	      actions.moveToElement(ExternalProvider).click().sendKeys("Pritesh Gupta").build().perform();
		  driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();     
		  Thread.sleep(5000);
  		Alert save= driver.switchTo().alert();
  		save.accept();
  		driver.findElement(By.xpath("//dx-button[@aria-label='Back']")).click();   
		}
		else {
		    System.out.println("ExternalSpecialty field is disabled.");
		}

	}
	@Test
	public void draft_to_Requested() throws InterruptedException 
	{
		driver.findElement(By.xpath("//span[normalize-space()='Draft']")).click();  // to click on draft
		driver.findElement(By.xpath("//table//tr//td[@aria-colindex=\"1\"][.='17101']")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//referraledit-form//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();       //task status
		driver.findElement(By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[3]")).click();   //requested
		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();      //business status dropdown
		driver.findElement(By.xpath("//div[contains(text(),'Referred')]")).click();        //business status-Referred
		driver.findElement(By.xpath("//dx-button[@aria-label='Lookup']")).click();    //lookup
		driver.findElement(By.xpath("//td[normalize-space()='Ari Jefferson']")).click();   // change the name for selection
		Thread.sleep(2000);
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(5000);
		Alert tasksaved= driver.switchTo().alert();
		tasksaved.accept();
		driver.findElement(By.xpath("//dx-button[@text=\"Back\"]")).click();   //back button
		}	
	
	@Test 
	public void draft_to_Cancelled() throws InterruptedException {
		/*WebElement row = driver.findElement(By.xpath("//table//tr//td[@aria-colindex=\"1\"][.='17182']"));
		scrollIntoView(driver, row);

		// Click using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", row);
*/
		driver.findElement(By.xpath("//span[normalize-space()='Draft']")).click();  // to click on draft
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"12\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();       //task status
		driver.findElement(By.xpath("(//div[@class='dx-item-content dx-list-item-content'])[1]")).click();   //cancelled
		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();      //business status dropdown
		driver.findElement(By.xpath("//div[contains(text(),'Order Cancelled')]")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(5000);
		Alert tasksaved= driver.switchTo().alert();
		tasksaved.accept();
		driver.findElement(By.xpath("//form-selectbox[@label='Reason']//div[@class='dx-button-content']")).click();
		driver.findElement(By.xpath("(//div[@role='option'])[10]")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(5000);
		Alert tasksaved1= driver.switchTo().alert();
		tasksaved1.accept();
		driver.findElement(By.xpath("//dx-button[@text=\"Back\"]")).click();   //back button
	}
	@Test 
	public void Cancelled_to_CreateNew() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Cancelled']")).click();  // to click on draft
		driver.findElement(By.xpath("//tbody//tr[@aria-rowindex=\"12\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
	driver.findElement(By.xpath("//dx-button[@aria-label='Create New']")).click();
	Thread.sleep(2000);
	Alert newreferral= driver.switchTo().alert();
	newreferral.accept();
	driver.findElement(By.xpath("//dx-form//dx-button[@text=\"Save\"]")).click();
	Thread.sleep(2000);
	Alert newreferraldraft= driver.switchTo().alert();
	newreferraldraft.accept();
	}
	@AfterMethod
	public void close() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
}

	
