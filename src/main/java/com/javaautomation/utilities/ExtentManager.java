package com.javaautomation.utilities;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	private static String reportFileName = "Test-Automaton-Report.html";
	private static String reportPath = System.getProperty("user.dir") + "\\TestReport";
	private static String configPath = System.getProperty("user.dir") + "\\extent-config.xml";

	public static void setExtent() throws IOException {

		sparkReporter = new ExtentSparkReporter(reportPath + "\\" + reportFileName);
		sparkReporter.loadXMLConfig(configPath);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "AutomationFramework");
		extent.setSystemInfo("Tester", "Alex");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}

}
