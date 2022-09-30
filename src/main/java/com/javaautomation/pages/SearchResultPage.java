package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class SearchResultPage extends BaseDriver{
	
	@FindBy(xpath="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean checkFindProduct() {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public ProductPage clickFindProduct() {
		productResult.click();
		return new ProductPage();
	}
}
