package com.pages.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.Page;

public class MyAccountPage extends Page{

	@FindBy(xpath = "//div[@class='block block-dashboard-info']//span[contains(text(),'Edit')]")
	public WebElement editLink;
	
	@FindBy(xpath = "//a[@class='action change-password']")
	public WebElement chngPass;
	
	public MyAccountPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public EditAccountPage editContactInfo() {
		editLink.click();
		return new EditAccountPage();
	}
	
	public ChangePasswordPage clickchangePassword() {
		chngPass.click();
		return new ChangePasswordPage();	
	}
	
	public void manageAddressess() {
		
	}
}
