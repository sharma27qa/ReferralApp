package inboundReferrals;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
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
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.className("dx-button-content")).click();
}
	@Test
	public void Appointment() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Inbound Referrals']")).click(); //open inbound dropdown.
		driver.findElement(By.xpath("//li[@aria-label='Inbound Referrals']//span[normalize-space()='In-Progress']")).click();  //click on requested.
		WebElement dblclck = driver.findElement(By.xpath("//div//tr[@aria-rowindex=\"3\"]")); //click on grid to open
		act.doubleClick(dblclck).perform();
		driver.findElement(By.xpath("//div//dx-button[@text=\"Details\"]")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Appointment']")).click();
	
        WebElement formElement = driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]"));
        // Check if the form is enabled
        if (formElement.isEnabled()) {
           System.out.println("The form is enabled.");
            driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
            Thread.sleep(2000);
    		Alert alert= driver.switchTo().alert();
    		System.out.println(alert);
    		alert.accept();
    		/*driver.findElement(By.xpath("//form-selectbox[@label=\"Status\"]//div[@aria-label='Select']")).click();
    		driver.findElement(By.xpath("//div[@aria-roledescription=\"list\"]//div[@role=\"option\"][1]")).click();       //proposed
    		driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
    		Thread.sleep(5000);
    		Alert alert1= driver.switchTo().alert();
    		System.out.println(alert1);
    		alert1.accept();   
    		
			driver.findElement(By.xpath("//form-selectbox[@label=\"Status\"]//div[@aria-label='Select']")).click();
			driver.findElement(By.xpath("//div[@aria-roledescription=\"list\"]//div[@role=\"option\"][2]")).click();   //pending
			driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
    		Thread.sleep(5000);
    		Alert alert1= driver.switchTo().alert();
    		System.out.println(alert1);
    		alert1.accept();  */
    		WebElement dblclckapptbl = driver.findElement(By.xpath("//table//tr//td[@aria-colindex=\"1\"][.='11']")); //click on grid to open of appointment details to open it.
			act.doubleClick(dblclckapptbl).perform();
    		driver.findElement(By.xpath("//form-selectbox[@label=\"Status\"]//div[@aria-label='Select']")).click();
			driver.findElement(By.xpath("//div[@aria-roledescription=\"list\"]//div[@role=\"option\"][3]")).click();   //booked
			driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
    		Thread.sleep(5000);
    		Alert alert2= driver.switchTo().alert();
    		System.out.println(alert2);
    		alert2.accept();
    		/*
    		driver.findElement(By.xpath("//form-selectbox[@label=\"Status\"]//div[@aria-label='Select']")).click();
			driver.findElement(By.xpath("//div[@aria-roledescription=\"list\"]//div[@role=\"option\"][4]")).click();   //Checked in
			driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
    		Thread.sleep(5000);
    		Alert alert3= driver.switchTo().alert();
    		System.out.println(alert3);
    		alert3.accept();
    		driver.findElement(By.xpath("//form-selectbox[@label=\"Status\"]//div[@aria-label='Select']")).click();
			driver.findElement(By.xpath("//div[@aria-roledescription=\"list\"]//div[@role=\"option\"][5]")).click();   //Arrived
			driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
    		Thread.sleep(5000);
    		Alert alert4= driver.switchTo().alert();
    		System.out.println(alert4);
    		alert4.accept();
    		driver.findElement(By.xpath("//form-selectbox[@label=\"Status\"]//div[@aria-label='Select']")).click();
			driver.findElement(By.xpath("//div[@aria-roledescription=\"list\"]//div[@role=\"option\"][6]")).click();   //Fullfilled
			driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-button[@aria-label=\"Save\"]")).click();
    		Thread.sleep(5000);
    		Alert alert5= driver.switchTo().alert();
    		System.out.println(alert5);
    		alert5.accept();
    		
    		   */
    		
    		// to enter value in date field of appointment
    	      Actions actions = new Actions(driver);
    	      WebElement apptdate = driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-date-box[@type=\"date\"]"));
    	      actions.moveToElement(apptdate).click().sendKeys("12/04/1995").build().perform();
    	      
    	   // to enter value in time field of appointment    
    	      driver.findElement(By.xpath("//dxi-item[@title=\"Appointment\"]//dx-date-box[@type=\"time\"]")).click(); 
    	      Thread.sleep(2000);
    	      selectTimeInDateViewRoller();
    	   // Locate the date view roller element
    	       // WebElement dateViewRoller = driver.findElement(By.xpath("//div[contains(text(),'Select Time')]"));

    	            	          
    	            
    	       
        }
        else {
            System.out.println("The form is disabled.");
            driver.findElement(By.xpath("//dx-button[@aria-label='Edit']")).click();
            driver.findElement(By.xpath("//form-selectbox[@label='Status']")).click();
    		driver.findElement(By.xpath("//div[contains(text(),'In Progress')]")).click();
    		driver.findElement(By.xpath("//form-selectbox[@label='Business Status']")).click();
    		driver.findElement(By.xpath("//div[contains(text(),'Appointment Proposed')]")).click();
    		driver.findElement(By.xpath("//dx-button[@text=\"Save\"]")).click();
        }
		
	}
	public void selectTimeInDateViewRoller() throws InterruptedException {
    	WebElement dateViewRoller = driver.findElement(By.xpath("//div[contains(text(),'Select Time')]"));

        // Example: Select 12:30 PM
        scrollToTimeComponent(dateViewRoller, "hours", "12");
        Thread.sleep(2000);
        scrollToTimeComponent(dateViewRoller, "minutes", "30");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='OK']")).click();
       

        // Other actions or validations as needed
    }

	private void scrollToTimeComponent(WebElement dateViewRoller, String component, String value) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    

	    // Use a more generic scrollTo function that takes the component and value
	    String script = "arguments[0].scrollTo('" + component + "', '" + value + "');";
	    js.executeScript(script, dateViewRoller);
	    
	    // After scrolling, you may need to wait for the changes to take effect
	    // WebDriverWait wait = new WebDriverWait(driver, 10);
	    // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='OK']")));
	    
	    // Click on the "OK" button (assuming it becomes clickable after scrolling) 
	   
	}
}
