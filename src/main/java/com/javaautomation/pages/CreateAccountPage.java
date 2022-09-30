package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class CreateAccountPage extends BaseDriver {

	// Locators
	@FindBy(xpath = "//h1[normalize-space()='Create an account']")
	WebElement formTitle;
	@FindBy(xpath = "//input[@id='id_gender1']")
	WebElement mr;
	@FindBy(xpath = "//input[@id='id_gender2']")
	WebElement mrs;
	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement firstName;
	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	@FindBy(xpath = "//select[@id='days']")
	WebElement day;
	@FindBy(xpath = "//select[@id='months']")
	WebElement month;
	@FindBy(xpath = "//select[@id='years']")
	WebElement year;
	@FindBy(xpath = "//input[@id='company']")
	WebElement company;
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address;
	@FindBy(xpath = "//input[@id='city']")
	WebElement city;
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement state;
	@FindBy(xpath = "//input[@id='postcode']")
	WebElement postcode;
	@FindBy(xpath = "//select[@id='id_country']")
	WebElement country;
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement phoneMobile;
	@FindBy(xpath = "//span[normalize-space()='Register']")
	WebElement registerBtn;

	public CreateAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean checkCreateAccountPage() {
		return Action.isDisplayed(getDriver(), formTitle);
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
		Action.selectByValue(day, d);
		Action.selectByValue(month, m);
		Action.selectByValue(year, y);
		company.sendKeys(compName);
		address.sendKeys(addr);
		city.sendKeys(cityName);
		Action.selectByVisibleText(state, stateName);
		postcode.sendKeys(zip);
		Action.selectByVisibleText(country, counrtyName);
		phoneMobile.sendKeys(mobilePhone);
	}
	
	public MyAccountPage validateCreateAccount() {
		registerBtn.click();
		return new MyAccountPage();
	}

}
