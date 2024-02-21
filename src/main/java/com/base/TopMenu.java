package com.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.page.Page;

public class TopMenu extends Page{


	@FindBy(css = "#ui-id-4")
	public WebElement womenLink;
	@FindBy(css = "#ui-id-5")
	public WebElement menLink;
	@FindBy(css = "#ui-id-6")
	public WebElement gearLink;
	
	public TopMenu() {
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToWomenSection() {
		womenLink.click();
	}
	public void goToMenSection() {
		menLink.click();
	}
	public void goToGearSection() {
		gearLink.click();
	}
	public void goToTrainingSection() {
		
	}
	public void goToCart() {
		
	}
	public void searchForProduct() {
		
	}
	
	

}
