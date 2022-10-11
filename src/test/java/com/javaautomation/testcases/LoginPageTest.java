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

public class LoginPageTest extends BaseDriver{
	
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
	
	@Test(dataProvider="credentials", dataProviderClass=DataProviders.class, groups = {"Smoke", "Sanity"})
	public void loginTest(String username, String password) {
		Log.startTestCase("loginTest");
		mainPage = new MainPage();
		Log.info("User is going to click on SingIn button");
		loginPage = mainPage.clickSingInBtn();
		Log.info("Enter email and password");
		//myAccountPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		myAccountPage = loginPage.login(username, password, myAccountPage);
		String actualUrl = myAccountPage.getCurrentUrl();
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualUrl, "http://automationpractice.com/index.php?controller=my-account");
		Log.info("Login is success");
		Log.endTestCase("loginTest");
	}
	
	

}
