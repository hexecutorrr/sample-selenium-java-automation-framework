package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class LoginPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//input[@id='email']")
	WebElement emailField;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement passwordField;
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement singInBtn;
	@FindBy(xpath="//input[@id='email_create']")
	WebElement createEmailField;
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement createAccountBtn;
	
	public LoginPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public MyAccountPage login(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		singInBtn.click();
		return new MyAccountPage();
	}
	
	public AdressPage login1(String email, String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		singInBtn.click();
		return new AdressPage();
	}
	
	public CreateAccountPage createAccount(String email) {
		createEmailField.sendKeys(email);
		createAccountBtn.click();
		return new CreateAccountPage();
	}
	
	

}
