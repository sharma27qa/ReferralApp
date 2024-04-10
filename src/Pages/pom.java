package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pom {

	@FindBy(xpath="//div//dx-button[@text=\"Details\"]")
	WebElement Details_Button;
	
	@FindBy(xpath="//span[normalize-space()='Inbound Referrals']")
	WebElement Inbound_Referrals;
	
	@FindBy(xpath="//div//dx-button[@text=\"Edit\"]")
	WebElement Edit_Button;
	
	@FindBy(xpath="//form-selectbox[@label='Status']")
	WebElement TaskStatus_Dropdown;
	
	@FindBy(xpath="//form-selectbox[@label='Business Status']")
	WebElement BusinessStatus_Dropdown;
	
	@FindBy(xpath="//dx-button[@text=\"Save\"]")
	WebElement Save_Button;
	
	@FindBy(xpath="//dx-button[@text=\"Cancel\"]")
	WebElement Cancel_Button;
	
	@FindBy(xpath="//dx-button[@aria-label='Back']")
	WebElement Back_Button;
}
