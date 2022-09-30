package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class PaymentPage extends BaseDriver {
	
	//Locators
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement payByBank;
	@FindBy(xpath="//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	public PaymentPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickPayByBank() {
		payByBank.click();
		return new OrderSummaryPage();
	}

}
