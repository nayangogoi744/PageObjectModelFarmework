package com.pages.myaccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.Page;
import com.pages.SignInPage;

public class ChangePasswordPage extends Page{

	@FindBy(id = "current-password")
	public WebElement currentPass;
	
	@FindBy(id = "password")
	public WebElement newPass;
	
	@FindBy(id = "password-confirmation")
	public WebElement confirmPass;
	
	@FindBy(xpath = "//button[@title='Save']")
	public WebElement saveBtn;
	
	public ChangePasswordPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public SignInPage changePassword(String currentpass,String newpass) {
		//currentPass.sendKeys(currentpass);
		type(currentPass, currentpass);
		//newPass.sendKeys(newpass);
		type(newPass,newpass);
		//confirmPass.sendKeys(newpass);
		type(confirmPass,newpass);
		//saveBtn.click();
		click(saveBtn);
		return new SignInPage();
		
	}
}
