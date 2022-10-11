package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class OrderSummaryPage extends BaseDriver {
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	private WebElement confirmOrderBtn;
	
	public OrderSummaryPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickConfirmOrderBtn() {
		confirmOrderBtn.click();
		return new OrderConfirmationPage();
	}
		
}
