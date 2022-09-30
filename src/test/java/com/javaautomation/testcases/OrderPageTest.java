package com.javaautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javaautomation.base.BaseDriver;
import com.javaautomation.dataprovider.DataProviders;
import com.javaautomation.pages.MainPage;
import com.javaautomation.pages.OrderPage;
import com.javaautomation.pages.ProductPage;
import com.javaautomation.pages.SearchResultPage;
import com.javaautomation.utilities.Log;

public class OrderPageTest extends BaseDriver {
	
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private ProductPage productPage;
	private OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void tearDown() {
		closeApp();
	}
	
	@Test(dataProvider="getProduct", dataProviderClass=DataProviders.class, groups = "Regression")
	public void verifyTotalPriceTest(String product, String qty, String size) {
		Log.startTestCase("verifyTotalPriceTest");
		mainPage = new MainPage();
		Log.info("Enter search product: " + product);
		searchResultPage = mainPage.searchProduct(product);
		Log.info("Click find button");
		productPage = searchResultPage.clickFindProduct();
		Log.info("Enter quantity: " + qty);
		productPage.enterQuantity(qty);
		Log.info("Enter size: " + size);
		productPage.selectSize(size);
		Log.info("Click AddToCart button");
		productPage.clickOnAddToCart();
		Log.info("Click Checkout and open orderPage");
		orderPage = productPage.clickCheckout();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Integer quantity = orderPage.getQty();
		Double totalActualPrice = (unitPrice*quantity)+2;
		Log.info("Verify total price: " + "total = " + totalPrice +", " + "actualTotal = " + totalActualPrice);
		Assert.assertEquals(totalPrice, totalActualPrice);
		Log.endTestCase("verifyTotalPriceTest");
	}

}
