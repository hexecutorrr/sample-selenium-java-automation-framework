package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class AdressPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//button[@name='processAddress']")
	WebElement checkoutBtn;
	
	public AdressPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickcheckoutBtn() {
		checkoutBtn.click();
		return new ShippingPage();
	}
	

}
