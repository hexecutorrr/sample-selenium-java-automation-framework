package com.javaautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaautomation.base.BaseDriver;

public class OrderPage extends BaseDriver{
	
	//Locators
	@FindBy(xpath="//span[starts-with(@id,'product_price')]")
	private WebElement unitPrice;
	@FindBy(xpath="//span[@id='total_price']")
	private WebElement totalPrice;
	@FindBy(xpath="//input[starts-with(@name,'quantity')]")
	private WebElement quantity;
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	private WebElement checkoutBtn;
	
	public OrderPage(){
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		String unitPrice1 = unitPrice.getText();
		String unitReplace = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double result = Double.parseDouble(unitReplace);
		return result/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1 = totalPrice.getText();
		String totalReplace = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double result = Double.parseDouble(totalReplace);
		return result/100;
	}
	
	public int getQty() {
		int result = Integer.parseInt(quantity.getAttribute("value"));
		return result;
	}
	
	public LoginPage clickCheckoutBtn() {
		checkoutBtn.click();
		return new LoginPage();
	}
	
	

}
