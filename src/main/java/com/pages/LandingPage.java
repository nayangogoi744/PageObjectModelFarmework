package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.page.Page;
import com.pages.myaccount.MyAccountPage;

public class LandingPage extends Page{

	@FindBy(xpath = "//div[@class='panel header']//span[@class='not-logged-in']")
	public WebElement notLoggedIn;
	
	@FindBy(xpath = "//div[@class='panel header']//button[@class='action switch']")
	public WebElement myAccDropDown;
	
	@FindBy(xpath = "//div[@class='panel header']//div[@class='customer-menu']//li[1]")
	public WebElement menu;
	
	@FindBy(css = ".panel.header>ul>li:nth-child(1) > span")
	public WebElement welcomemsg;
	
	
	public LandingPage() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verify(String message) throws InterruptedException {
		wait.until(ExpectedConditions.invisibilityOf(notLoggedIn));
		String str = welcomemsg.getText();
		if(str.contains(message)) {
			return true;
		}
		return false;
	}
	
	public void verifyWelcomeTxtPresent(String message) throws InterruptedException {
		
		if(verify(message)==true) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Something went wrong");
		}
	}
	
	public MyAccountPage goToMyAccount() {
		myAccDropDown.click();
		menu.click();
		return new MyAccountPage();
		
	}
	public void goToMyWishList() {
			
		}
	public void logOut() {
		
	}
}
