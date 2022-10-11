package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class CreateAccountPage extends BaseDriver {
    
	Action action = new Action();
	
	// Locators
	@FindBy(xpath = "//h1[normalize-space()='Create an account']")
	private WebElement formTitle;
	@FindBy(xpath = "//input[@id='id_gender1']")
	private WebElement mr;
	@FindBy(xpath = "//input[@id='id_gender2']")
	private WebElement mrs;
	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='customer_lastname']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='passwd']")
	private WebElement password;
	@FindBy(xpath = "//select[@id='days']")
	private WebElement day;
	@FindBy(xpath = "//select[@id='months']")
	private WebElement month;
	@FindBy(xpath = "//select[@id='years']")
	private WebElement year;
	@FindBy(xpath = "//input[@id='company']")
	private WebElement company;
	@FindBy(xpath = "//input[@id='address1']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='city']")
	private WebElement city;
	@FindBy(xpath = "//select[@id='id_state']")
	private WebElement state;
	@FindBy(xpath = "//input[@id='postcode']")
	private WebElement postcode;
	@FindBy(xpath = "//select[@id='id_country']")
	private WebElement country;
	@FindBy(xpath = "//input[@id='phone_mobile']")
	private WebElement phoneMobile;
	@FindBy(xpath = "//span[normalize-space()='Register']")
	private WebElement registerBtn;

	public CreateAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean checkCreateAccountPage() {
		return action.isDisplayed(getDriver(), formTitle);
	}

	public void createNewAccount(String gender, String fName, 
			String lName, 
			String pswd, 
			String d, 
			String m, 
			String y, 
			String compName, 
			String addr, 
			String cityName, 
			String stateName, 
			String zip, 
			String counrtyName, 
			String mobilePhone) {
		if (gender.equalsIgnoreCase("Mr")) {
			mr.click();
		} else {
			mrs.click();
		}
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		password.sendKeys(pswd);
		action.selectByValue(day, d);
		action.selectByValue(month, m);
		action.selectByValue(year, y);
		company.sendKeys(compName);
		address.sendKeys(addr);
		city.sendKeys(cityName);
		action.selectByVisibleText(state, stateName);
		postcode.sendKeys(zip);
		action.selectByVisibleText(country, counrtyName);
		phoneMobile.sendKeys(mobilePhone);
	}
	
	public MyAccountPage validateCreateAccount() {
		registerBtn.click();
		return new MyAccountPage();
	}

}
