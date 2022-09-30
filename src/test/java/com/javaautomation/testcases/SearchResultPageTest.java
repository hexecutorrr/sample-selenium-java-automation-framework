package com.javaautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.javaautomation.base.BaseDriver;
import com.javaautomation.dataprovider.DataProviders;
import com.javaautomation.pages.MainPage;
import com.javaautomation.pages.SearchResultPage;
import com.javaautomation.utilities.Log;

public class SearchResultPageTest extends BaseDriver {

	private MainPage mainPage;
	private SearchResultPage searchResultPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void setup(String browser) {
		launchApp(browser);
	}

	@AfterMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void tearDown() {
		closeApp();
	}

	@Test(dataProvider="getProductName", dataProviderClass=DataProviders.class, groups = "Smoke")
	public void varifySearchProductTest(String product) {
		Log.startTestCase("varifySearchProductTest");
		mainPage = new MainPage();
		Log.info("Enter product name: " + product + " and click find button");
		searchResultPage = mainPage.searchProduct(product);
		boolean result = searchResultPage.checkFindProduct();
		Log.info("Verify search result");
		Assert.assertTrue(result);
		Log.endTestCase("varifySearchProductTest");
	}

}
