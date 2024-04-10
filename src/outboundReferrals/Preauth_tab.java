package outboundReferrals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Preauth_tab {
	WebDriver driver;

	@Test
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\asharma\\Desktop\\chromedriver_latest\\chromedriver.exe");
		driver= new ChromeDriver();
	    driver.get("http://win2012r2s2:4200/referral-edit/17241/477/17241/1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//div[@class='dx-item dx-treeview-item dx-state-hover']//span[contains(text(),'Pre Authorization')]   xpath for pre auth naigation from outbound referral
		
		////div[@class='dx-item dx-treeview-item dx-state-hover']//span[contains(text(),'Requested')]    xapth for requested from outbound referral.
		
	}
}

