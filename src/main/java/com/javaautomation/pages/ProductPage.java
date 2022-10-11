package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.actiondriver.Action;
import com.javaautomation.base.BaseDriver;

public class ProductPage extends BaseDriver{
	
	Action action = new Action();
	
	//Locators
	@FindBy(xpath="//input[@id='quantity_wanted']")
	private WebElement productQuantity;
	@FindBy(xpath="//select[@id='group_1']")
	private WebElement productSize;
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	private WebElement addToCartBtn;
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	private WebElement addToCartMassage;
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	private WebElement checkoutBtn;
	
	public ProductPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String number) {
		productQuantity.clear();
		productQuantity.sendKeys(number);
	}
	
	public void selectSize(String size) {
		action.selectByVisibleText(productSize, size);
	}
	
	public void clickOnAddToCart() {
		addToCartBtn.click();
	}
	
	public boolean checkAddToCart() {
		action.fluentWait(getDriver(), addToCartMassage, 10);
		return action.isDisplayed(getDriver(), addToCartMassage);
	}
	
	public OrderPage clickCheckout() {
		checkoutBtn.click();
		return new OrderPage();
	}
}
