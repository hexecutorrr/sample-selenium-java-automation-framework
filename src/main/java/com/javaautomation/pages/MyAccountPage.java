package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class MyAccountPage extends BaseDriver{
	
	Action action = new Action();
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My wishlists']")
	private WebElement myWishlist;
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	private WebElement orderHistoryDetails;
	
	public MyAccountPage(){
		PageFactory.initElements(getDriver(), this);
	}
    
	public boolean checkMyWishlist() {
		return action.isDisplayed(getDriver(), myWishlist);
	}
	
	public boolean checkOrderHistoryDetails() {
		return action.isDisplayed(getDriver(), orderHistoryDetails);
	}
	
	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}
}
