package com.javaautomation.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.javaautomation.utilities.CustomFileReader;

public class DataProviders {
	
	CustomFileReader cfr = new CustomFileReader();
	
	//Test Case--> loginTest, myVishlistTest, orderHistoryDetailsTest
	@DataProvider(name="credentials")
	public Object[][] getCredentials() {
		int row = cfr.getRowNumber("Credentials");
		int col = cfr.getColNumber("Credentials");
		
		Object[][] data = new Object[row - 1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = cfr.getCellData("Credentials", j, i);
			}
		}
		return data;
	}
	
	//Test Case--> verifyCreateAccountPageTest
	@DataProvider(name="email")
	public Object[][] getEmail() {
		int row = cfr.getRowNumber("Email");
		int col = cfr.getColNumber("Email");
		
		Object[][] data = new Object[row - 1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = cfr.getCellData("Email", j, i);
			}
		}
		return data;
	}
	
	//Test Case--> verifyTotalPriceTest, endToEndBuyProductTest, addToCartTest
	@DataProvider(name="getProduct")
	public Object[][] getProduct() {
		int row = cfr.getRowNumber("ProductDetails");
		int col = cfr.getColNumber("ProductDetails");
		
		Object[][] data = new Object[row - 1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = cfr.getCellData("ProductDetails", j, i);
			}
		}
		return data;
	}
	
	//Test Case--> varifySearchProductTestt
	@DataProvider(name="getProductName")
	public Object[][] getProductName() {
		int row = cfr.getRowNumber("SearchProduct");
		int col = cfr.getColNumber("SearchProduct");
		
		Object[][] data = new Object[row - 1][col];
		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				data[i - 1][j] = cfr.getCellData("SearchProduct", j, i);
			}
		}
		return data;
	}
	
	@DataProvider(name="getAccountCreationData")
	public Object[][] getAccountCreationData() {
		int row = cfr.getRowNumber("AccountCreationData");
		int col = cfr.getColNumber("AccountCreationData");
		
		Object[][] data = new Object[row - 1][1];
		for (int i = 1; i < row; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < col; j++) {
				hashMap.put(cfr.getCellData("AccountCreationData", j, 0), cfr.getCellData("AccountCreationData", j, i));
			}
			data[i-1][0] = hashMap;
		}
		return data;
	}
	
	

}
