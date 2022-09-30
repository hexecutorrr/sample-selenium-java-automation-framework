package com.javaautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.javaautomation.base.BaseDriver;
import com.javaautomation.dataprovider.DataProviders;
import com.javaautomation.pages.MainPage;
import com.javaautomation.pages.ProductPage;
import com.javaautomation.pages.SearchResultPage;
import com.javaautomation.utilities.Log;

public class ProductPageTest extends BaseDriver{
	
	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private ProductPage productPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void tearDown() {
		closeApp();
	}
	
	@Test(dataProvider="getProduct", dataProviderClass=DataProviders.class, groups = {"Regression", "Sanity"})
	public void addToCartTest(String product, String qty, String size) {
		Log.startTestCase("addToCartTest");
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
		Log.info("Check add product to cart");
		productPage.checkAddToCart();
		boolean result = productPage.checkAddToCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}

}
