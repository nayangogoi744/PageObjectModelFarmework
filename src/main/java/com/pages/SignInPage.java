package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.Page;
import com.pages.myaccount.CreateNewAccountPage;

public class SignInPage extends Page{
	
	@FindBy(xpath = "//a[@class='action remind']//span")
	public WebElement forgotPass;
	
	@FindBy(xpath = "//a[@class='action create primary']//span")
	public WebElement createAcc;
	
	@FindBy(id="email")
	public WebElement emailField;
	
	@FindBy(id="pass")
	public WebElement pass;
	
	@FindBy(id="send2")
	public WebElement send2;
	
	public SignInPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public LandingPage performSignIn(String email,String password) {
		//emailField.sendKeys(email);
		type(emailField, email);
		//pass.sendKeys(password);
		type(pass, password);
		//send2.click();
		click(send2);
		return new LandingPage();
	}
	
	public void goToForgotPassword() {
		//forgotPass.click();
		click(forgotPass);
	}
	
	public CreateNewAccountPage createAnAccount() {
		//createAcc.click();
		click(createAcc);
		return new CreateNewAccountPage();
	}
}
