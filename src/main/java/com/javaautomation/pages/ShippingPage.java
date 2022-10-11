package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class ShippingPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//input[@id='cgv']")
	private WebElement termsCheckbox;
	@FindBy(xpath="//button[@name='processCarrier']")
	private WebElement checkoutBtn;
	
	public ShippingPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickTermsCheckbox() {
		termsCheckbox.click();
	}
	
	public PaymentPage clickProcessToCheckout() {
		checkoutBtn.click();
		return new PaymentPage();
	}

}
