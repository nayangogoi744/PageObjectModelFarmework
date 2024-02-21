package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.Page;
import com.pages.myaccount.MyAccountPage;

public class HomePage extends Page{

	
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement singInLink;
	
	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Create an Account')]")
	public WebElement createAccLink;
	
	public HomePage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignInPage goToSignInPage() {
		singInLink.click();
		//topmenu.goToWomenSection();
		return new SignInPage();
	}
	
	public MyAccountPage goToCreateAccountPage() {
		createAccLink.click();
		return new MyAccountPage();
	}
	
}
