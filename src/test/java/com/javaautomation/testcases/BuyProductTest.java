package com.javaautomation.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.javaautomation.base.BaseDriver;
import com.javaautomation.dataprovider.DataProviders;
import com.javaautomation.pages.AddressPage;
import com.javaautomation.pages.LoginPage;
import com.javaautomation.pages.MainPage;
import com.javaautomation.pages.OrderConfirmationPage;
import com.javaautomation.pages.OrderPage;
import com.javaautomation.pages.OrderSummaryPage;
import com.javaautomation.pages.PaymentPage;
import com.javaautomation.pages.ProductPage;
import com.javaautomation.pages.SearchResultPage;
import com.javaautomation.pages.ShippingPage;
import com.javaautomation.utilities.Log;

public class BuyProductTest extends BaseDriver {

	private MainPage mainPage;
	private SearchResultPage searchResultPage;
	private ProductPage productPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummaryPage orderSummaryPage;
	private OrderConfirmationPage orderConfirmationPage;

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
	public void endToEndBuyProductTest(String product, String quantity, String size) {
		Log.startTestCase("endToEndBuyProductTest");
		mainPage = new MainPage();
		Log.info("Search product");
		searchResultPage = mainPage.searchProduct(product);
		productPage = searchResultPage.clickFindProduct();
		Log.info("Enter quantity");
		productPage.enterQuantity(quantity);
		Log.info("Enter size");
		productPage.selectSize(size);
		Log.info("Click AddToCart button");
		productPage.clickOnAddToCart();
		Log.info("Click Checkout button");
		orderPage = productPage.clickCheckout();
		Log.info("Click Checkout button");
		loginPage = orderPage.clickCheckoutBtn();
		Log.info("Enter login and password");
		addressPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), addressPage);
		Log.info("Click Checkout button");
		shippingPage = addressPage.clickcheckoutBtn();
		Log.info("Select checkBox and click ProcessToCheckout");
		shippingPage.clickTermsCheckbox();
		paymentPage = shippingPage.clickProcessToCheckout();
		Log.info("Click PayByBank button");
		orderSummaryPage = paymentPage.clickPayByBank();
		Log.info("Click ConfirmOrder button");
		orderConfirmationPage = orderSummaryPage.clickConfirmOrderBtn();
		Log.info("Verify result");
		String actualMessage = orderConfirmationPage.checkConfirmMessage();
		Assert.assertEquals(actualMessage, "Your order on My Store is complete.");
		Log.endTestCase("endToEndBuyProductTest");
		
	}

}
