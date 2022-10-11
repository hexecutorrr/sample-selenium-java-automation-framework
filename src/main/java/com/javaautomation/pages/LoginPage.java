package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class LoginPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath="//input[@id='passwd']")
	private WebElement passwordField;
	@FindBy(xpath="//button[@id='SubmitLogin']")
	private WebElement singInBtn;
	@FindBy(xpath="//input[@id='email_create']")
	private WebElement createEmailField;
	@FindBy(xpath="//button[@id='SubmitCreate']")
	private WebElement createAccountBtn;
	
	public LoginPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public MyAccountPage login(String email, String password, MyAccountPage myAccountPage) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		singInBtn.click();
		myAccountPage = new MyAccountPage();
		return myAccountPage;
	}
	
	public AddressPage login(String email, String password, AddressPage addressPage) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		singInBtn.click();
		addressPage = new AddressPage();
		return addressPage;
	}
	
	public CreateAccountPage createAccount(String email) {
		createEmailField.sendKeys(email);
		createAccountBtn.click();
		return new CreateAccountPage();
	}
	
	

}
