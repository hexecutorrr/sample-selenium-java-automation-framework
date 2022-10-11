package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class AddressPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//button[@name='processAddress']")
	private WebElement checkoutBtn;
	
	public AddressPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickcheckoutBtn() {
		checkoutBtn.click();
		return new ShippingPage();
	}
	

}
