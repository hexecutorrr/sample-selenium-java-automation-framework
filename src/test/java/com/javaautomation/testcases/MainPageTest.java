package com.javaautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javaautomation.base.BaseDriver;
import com.javaautomation.pages.MainPage;
import com.javaautomation.utilities.Log;

public class MainPageTest extends BaseDriver{
	
	private MainPage mainPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups = {"Sanity", "Regression", "Smoke"})
	public void tearDown() {
		closeApp();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogoTest() {
		Log.startTestCase("verifyLogoTest");
		mainPage = new MainPage();
		boolean result = mainPage.checkLogo();
		Assert.assertTrue(result, "Logo is incorrect");
		Log.endTestCase("verifyLogoTest");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitleTest() {
		Log.startTestCase("verifyTitleTest");
		String actualTitle = mainPage.getMainPageTitle();
		Assert.assertEquals(actualTitle, "My Store");
		Log.endTestCase("verifyTitleTest");
	}

}
