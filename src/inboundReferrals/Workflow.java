package inboundReferrals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Workflow {
	WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asharma\\Desktop\\chromedriver_latest\\chromedriver.exe");
		driver= new ChromeDriver();
	    driver.get("https://referraltrack.azurewebsites.net/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("email")).sendKeys("anjali.sharma@nutekds.com");
		driver.findElement(By.name("password")).sendKeys("1234");
		driver.findElement(By.className("dx-button-content")).click();
}
	@Test
	public void basicflow() throws InterruptedException
	{
		//Actions act = new Actions(driver);
		driver.findElement(By.xpath("//span[normalize-space()='Outbound Referrals']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Draft']")).click();  // to click on draft
		driver.findElement(By.xpath("//div//tr[@aria-rowindex=\"10\"]")).click();
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
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Inbound Referrals']")).click();   //open inbound dropdown.
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@aria-label=\"Inbound Referrals\"]//li[@aria-label=\"Requested\"]")).click();  //click on requested.
		driver.findElement(By.xpath("//div//tr[@aria-rowindex=\"1\"]")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Received')]")).click();  //Click on received
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Order Received')]")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(2000);
		Alert tasksavedreceived= driver.switchTo().alert();
		tasksavedreceived.accept();
		//driver.findElement(By.xpath(" //dx-button[@aria-label='Back']")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='Received']")).click();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Accepted')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Order Accepted')]")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(2000);
		Alert tasksavedaccepted= driver.switchTo().alert();
		tasksavedaccepted.accept();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'In Progress')]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Collection Finalized')]")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(2000);
		Alert tasksavedprogress= driver.switchTo().alert();
		tasksavedprogress.accept();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Edit\"]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Completed')]")).click();
		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(),'Service Request Complete')]")).click();
		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
		Thread.sleep(2000);
		Alert tasksavedcompleted= driver.switchTo().alert();
		tasksavedcompleted.accept();
		driver.findElement(By.xpath("//dx-button[@text=\"Back\"]")).click(); 
		
	}
	@Test
	public void Requested_to_Cancelled() throws InterruptedException
	{
		
		
}}
