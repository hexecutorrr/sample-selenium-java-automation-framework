package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class OrderConfirmationPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//strong[normalize-space()='Your order on My Store is complete.']")
	WebElement confirmMessage;
	
	public OrderConfirmationPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public String checkConfirmMessage() {
		String message = confirmMessage.getText();
		return message;
	}

}
