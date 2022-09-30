package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class MyAccountPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My wishlists']")
	WebElement myWishlist;
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	WebElement orderHistoryDetails;
	
	public MyAccountPage(){
		PageFactory.initElements(getDriver(), this);
	}
    
	public boolean checkMyWishlist() {
		return Action.isDisplayed(getDriver(), myWishlist);
	}
	
	public boolean checkOrderHistoryDetails() {
		return Action.isDisplayed(getDriver(), orderHistoryDetails);
	}
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}
}
