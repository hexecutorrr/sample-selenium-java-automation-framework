package com.javaautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javaautomation.base.BaseDriver;
import com.javaautomation.dataprovider.DataProviders;
import com.javaautomation.pages.LoginPage;
import com.javaautomation.pages.MainPage;
import com.javaautomation.pages.MyAccountPage;
import com.javaautomation.utilities.Log;

public class MyAccountPageTest extends BaseDriver{
	
	private MainPage mainPage;
	private LoginPage loginPage;
	private MyAccountPage myAccountPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void tearDown() {
		closeApp();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void myVishlistTest(String username, String password) {
		Log.startTestCase("myVishlistTest");
		mainPage = new MainPage();
		Log.info("Click SingIn button");
		loginPage = mainPage.clickSingInBtn();
		//myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Enter login and password");
		myAccountPage = loginPage.login(username, password, myAccountPage);
		Log.info("Click SingIn and verify myVishlist");
		boolean result = myAccountPage.checkMyWishlist();
		Assert.assertTrue(result);
		Log.endTestCase("myVishlistTest");
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class, groups = "Smoke")
	public void orderHistoryDetailsTest(String username, String password) {
		Log.startTestCase("orderHistoryDetailsTest");
		mainPage = new MainPage();
		Log.info("Click SingIn button");
		loginPage = mainPage.clickSingInBtn();
		//myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("Click SingIn and verify myVishlist");
		myAccountPage = loginPage.login(username, password, myAccountPage);
		boolean result = myAccountPage.checkOrderHistoryDetails();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryDetailsTest");
	}

}
