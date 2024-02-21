package com.pages.myaccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.Page;

public class EditAccountPage extends Page{

	@FindBy(id = "firstname")
	public WebElement firstname;

	@FindBy(xpath = "//button[@title='Save']")
	public WebElement saveBtn;
	
	public EditAccountPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public MyAccountPage changeAccInfo(String name) {
		//firstname.clear();
		clear(firstname);
		//firstname.sendKeys(name);
		type(firstname, name);
		//saveBtn.click();
		click(saveBtn);
		return new MyAccountPage();
	}
}
