package com.javaautomation.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javaautomation.base.BaseDriver;
import com.javaautomation.dataprovider.DataProviders;
import com.javaautomation.pages.CreateAccountPage;
import com.javaautomation.pages.LoginPage;
import com.javaautomation.pages.MainPage;
import com.javaautomation.pages.MyAccountPage;
import com.javaautomation.utilities.Log;

public class CreateAccountPageTest extends BaseDriver{
	
	private MainPage mainPage;
	private LoginPage loginPage;
	private CreateAccountPage createAccountPage;
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
	
	@Test(dataProvider="email", dataProviderClass=DataProviders.class, groups = "Sanity")
	public void verifyCreateAccountPageTest(String email) {
		Log.startTestCase("verifyCreateAccountPageTest");
		mainPage = new MainPage();
		Log.info("User is going to click on SingIn button");
		loginPage = mainPage.clickSingInBtn();
		Log.info("Enter email and password");
		createAccountPage = loginPage.createAccount(email);
		Log.info("Verifying correct login and open createAccountPage");
		boolean result = createAccountPage.checkCreateAccountPage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@Test(dataProvider="getAccountCreationData", dataProviderClass=DataProviders.class)
	public void createNewAccountTest(HashMap<String,String> hashMapValue) {
		Log.startTestCase("createNewAccountTest");
		mainPage = new MainPage();
		Log.info("User is going to click on SingIn button");
		loginPage = mainPage.clickSingInBtn();
		Log.info("Enter email");
		createAccountPage = loginPage.createAccount(hashMapValue.get("Email"));
		Log.info("Enter other parameters");
		createAccountPage.createNewAccount(hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		Log.info("Click on create account button");
		myAccountPage = createAccountPage.validateCreateAccount();
		Log.info("Verify create account");
		Assert.assertEquals(myAccountPage.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
		Log.endTestCase("createNewAccountTest");
		
		
	}

}
