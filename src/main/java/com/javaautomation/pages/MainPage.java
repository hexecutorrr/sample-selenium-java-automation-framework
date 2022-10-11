package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class MainPage extends BaseDriver{
	
	Action action = new Action();
	
	//Locators
	@FindBy(xpath="//a[normalize-space()='Sign in']")
	private WebElement singInBtn;
	@FindBy(xpath="//img[@alt='My Store']")
	private WebElement myStoreLogo;
	@FindBy(xpath="//input[@id='search_query_top']")
	private WebElement searchProductField;
	@FindBy(xpath="//button[@name='submit_search']")
	private WebElement searchBtn;
	
	public MainPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickSingInBtn() {
		singInBtn.click();
		return new LoginPage();
	}
	
	public boolean checkLogo() {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMainPageTitle() {
		String mainPageTitle = getDriver().getTitle();
		return mainPageTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		searchProductField.sendKeys(productName);
		searchBtn.click();
		return new SearchResultPage();
	}
	
}
