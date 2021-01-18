/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

package com.accelerators;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.support.HtmlReportSupport;
import com.support.ReportStampSupport;
import com.utilities.Data_Provider;
import com.utilities.SendMail;

import junit.framework.Assert;

public class TestEngine extends SendMail {

	public static Logger logger = Logger.getLogger(TestEngine.class.getName());
	public static HashMap<String, String> tstData = null;
	public static HashMap<String, String> credentialManager = null;
	public static HashMap<String, String> propertyManager = null;
	public static HashMap<String, String> executionData = null;
	public String currentSuite = "";
	public String method = "";
	public boolean flag = false;
	public static WebDriver webDriver = null;
	public static WebDriver d = null;
	public static EventFiringWebDriver driver = null;
	public static int stepHeaderNum = 0;
	public static int stepNum = 0;
	public static int PassNum = 0;
	public static int FailNum = 0;
	public static int SkipNum = 0;
	public static int passCounter = 0;
	public static int failCounter = 0;
	public static int skipcounter = 0;
	public String testName = "";
	public String testCaseExecutionTime = "";
	public StringBuffer x = new StringBuffer();
	public String finalTime = "";
	public boolean isSuiteRunning = false;
	public static String testCaseDescription = "";
	public static Map<String, String> testDescription = new LinkedHashMap<String, String>();
	public static Map<String, String> testResults = new LinkedHashMap<String, String>();
	public static Map<String, String[]> testResultsData = new LinkedHashMap<String, String[]>();
	public String url = null;
	public int countcompare = 0;
	public static String projectName = "d2l";
	public static String browserName;
	static int len = 0;
	static int i = 0;
	public static ITestContext itc;
	public static String groupNames = null;
	public static String rpSumDt = null;
	public static File file = null;
	public static String application = null;
	public static String rStartDate = null;
	public static String suiteName = "";
	public static String folderName = null;
	public static String chartName = null;
	public static String buildNumer_Jenkins;
	public static String strJenkinsExecution;
	public static boolean TestCaseFlag = false;

	/**
	 * Initializing browser requirements, Test Results file path and Database
	 * requirements from the configuration file
	 * 
	 * @Revision History
	 * 
	 */
	// Before Suite
	@BeforeSuite(alwaysRun = true)
	public void first(ITestContext context) throws Throwable {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || first 1 param ~~~~~~~~~~~~~~~~~~~~");


		try {
			// Reads all the values from the Credential Manager Properties Sheet
			propertyManager = CredentialManager.getProperty("Properties");
			// Reads all the values from Given Environment Sheet in Credential Manager
			credentialManager = CredentialManager.getProperty(propertyManager.get("Environment"));

			SimpleDateFormat rpSumDtSDT = new SimpleDateFormat("MMM_dd_yyyy_z_HH_mm_ss");
			rpSumDtSDT.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
			rpSumDt = rpSumDtSDT.format(new Date());
			rStartDate = rpSumDtSDT.format(new Date());
			ReportStampSupport.calculateSuiteStartTime();
			Map<String, String> suiteParameters = context.getCurrentXmlTest().getSuite().getParameters();
			String testParameters = context.getCurrentXmlTest().getSuite().getTests().toString();
			System.out.println("~~~~~~~~Before Suite~~~~~~~~");
			Configuration.PutProperty("CurrentApplication", suiteParameters.get("CurrentApplication"));
			Configuration.PutProperty("browser", suiteParameters.get("browser"));
			browserName = suiteParameters.get("browser");

			suiteName = context.getCurrentXmlTest().getSuite().getName().replace(" ", "_").trim();

			String log4jConfigFile = System.getProperty("user.dir") + File.separator + "src" 
					+ File.separator + "main" + File.separator + "resources" + File.separator 
					+ "properties" + File.separator + "log4j.properties";
			PropertyConfigurator.configure(log4jConfigFile);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			logger.info(
					"################################################################################################");
			// logger.info("***Release
			// Version***"+propertyManager.get("ReleaseVersion") );
			// logger.info("PSFT URL:"+credentialManager.get("PSFT_URL"));
			// logger.info("D2L URL:"+credentialManager.get("D2L_URL"));
			logger.info("Execution Date: " + dateFormat.format(date));
			logger.info(
					"################################################################################################");

		} catch (Exception ex) {

		}
	}

	// Before Class
	@Parameters({ "browser" })
	@BeforeClass(alwaysRun = true)
	public void first(ITestContext ctx, String browser) throws Throwable {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ Test Case Execution Starts ~~~~~~~~~~~~~~~~~~~~");
		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || first 2 param ~~~~~~~~~~~~~~~~~~~~");
		//		

		System.out.println("~~~~~~~~Before Class~~~~~~~~");
	}

	/**
	 * De-Initializing and closing all the connections
	 * 
	 * @throws Throwable
	 */

	// After Suite
	@Parameters({ "browser" })
	@AfterSuite(alwaysRun = true)
	public void tearDown(ITestContext ctx, String browser) throws Throwable {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || tearDown 2 param ~~~~~~~~~~~~~~~~~~~~");


		System.out.println("~~~~~~~~After Suite~~~~~~~~");
		ReportStampSupport.calculateSuiteExecutionTime();
		closeSummaryReport(browser);
		String SummaryReportPath = System.getProperty("user.dir") + "\\" + TestEngine.filePath() + "\\Summary_Results_"
				+ TestEngine.rpSumDt + ".html";

		// System.out.println(SummaryReportPath);
		File file = new File(SummaryReportPath);

		Desktop desktop = Desktop.getDesktop();

		try {
			desktop.browse(file.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (propertyManager.get("MailTransfer").equalsIgnoreCase("True"))
			SendMail.attachReportsToEmail();
	}

	/**
	 * Write results to Browser specific path
	 * 
	 * @Revision History
	 * 
	 */
	// @Parameters({"browserType"})
	public static String filePath() {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || String filePath ~~~~~~~~~~~~~~~~~~~~");


		String strDirectoy = "";
		String strDirectoy_local = "";
		String result = "";
		strDirectoy_local = TestEngine.folderName.trim() + "_" + rStartDate;
		strDirectoy = TestEngine.folderName.trim();
		buildNumer_Jenkins = System.getProperty("BuildNumber");
		// buildNumer_Jenkins="2";
		String buildNumer = "BCFerries_Automation_" + buildNumer_Jenkins;
		if (buildNumer_Jenkins != null) {
			new File(configProps.getProperty("screenShotPath") + buildNumer).mkdirs();
			File strDirectoy1 = new File(configProps.getProperty("screenShotPath") + buildNumer + "/" + strDirectoy);
			// strDirectoy = TestEngine.folderName.trim() + "_" + rStartDate;
			if (!strDirectoy1.exists()) {
				strDirectoy1.mkdirs();
			}
			File resultSet = new File(
					configProps.getProperty("screenShotPath") + buildNumer + "/" + strDirectoy + "/" + "Screenshots");
			if (!resultSet.exists()) {
				resultSet.mkdir();
				HtmlReportSupport.copyLogos();
			}
			result = configProps.getProperty("screenShotPath") + buildNumer + "/" + strDirectoy;
		} else {
			if (strDirectoy_local != "") {
				new File(configProps.getProperty("screenShotPath") + strDirectoy_local).mkdirs();
			}

			File results = new File(
					configProps.getProperty("screenShotPath") + strDirectoy_local + "/" + "Screenshots");
			if (!results.exists()) {
				results.mkdir();
				HtmlReportSupport.copyLogos();
			}
			result = configProps.getProperty("screenShotPath") + strDirectoy_local;
		}

		return result;
	}

	// Before Method
	@SuppressWarnings({ "static-access", "deprecation" })
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void reportHeader(Method method, ITestContext ctx, String browser) throws Throwable {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || reportHeader ~~~~~~~~~~~~~~~~~~~~");


		System.out.println("~~~~~~~~Before Method~~~~~~~~");
		strJenkinsExecution = System.getProperty("JenkinsExecution");
		System.out.println("Execute from Jenkins :: " + strJenkinsExecution);
		itc = ctx;

		tc_name = method.getName().toString() + "-" + browser;
		tstData = Data_Provider.getTestData("TestData", tc_name.replace("-" + browser, ""));

		if (tstData.get("TestCaseName").equalsIgnoreCase(tc_name.replace("-" + browser, ""))
				&& tstData.get("ExecuteStatus").equalsIgnoreCase("No")) {

			System.out.println(tstData.get("TestCaseName") + " -> Test Case Skippped");
			throw new SkipException("Skipping this exception");
		}
		System.out.println(tstData.get("TestCaseName") + " -> Test Case Not Skipped");

		if (browser.equalsIgnoreCase("firefox")) {

			Thread.sleep(2000);
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + 
					File.separator + "src" + File.separator + "main" + File.separator + "resources" 
					+ File.separator + "drivers" + File.separator + "geckodriver.exe");
			
			ProfilesIni allProfiles = new ProfilesIni();
			FirefoxProfile profile = allProfiles.getProfile("default-release");
			profile.setAcceptUntrustedCertificates(true);
			profile.setAssumeUntrustedCertificateIssuer(false);
			
			FirefoxOptions options = new FirefoxOptions();
	        options.setProfile(profile);
	        
	        webDriver = new FirefoxDriver(options);
						
//			Thread.sleep(2000);
//			if (strJenkinsExecution == null) {
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + 
//						File.separator + "src" + File.separator + "main" + File.separator + "resources" 
//						+ File.separator + "drivers" + File.separator + "geckodriver.exe");
//				webDriver = new FirefoxDriver();
//			} else {
//				DesiredCapabilities caps = DesiredCapabilities.firefox();
//				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + 
//						File.separator + "src" + File.separator + "main" + File.separator + "resources" 
//						+ File.separator + "drivers" + File.separator + "geckodriver.exe");
//				webDriver = new FirefoxDriver();
//				webDriver = new RemoteWebDriver(new URL("http://usv-bmsapp-01.us.umuc.edu:4444/wd/hub"), caps);
//			}

		} else if (browser.equalsIgnoreCase("ie")) {
			
			
			
			
			// Create object of DesiredCapabilities class

//			DesiredCapabilities cap= DesiredCapabilities.internetExplorer();

			// Set ACCEPT_SSL_CERTS  variable to true
//			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//			cap.setCapability("acceptSslCerts",true);
			// Set INITIAL_BROWSER_URL  variable to blank
//			cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");


			// Set the driver path
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + File.separator 
					+ "src" + File.separator + "main" + File.separator + "resources" + File.separator 
					+ "drivers" + File.separator + "IEDriverServer_64.exe");
			
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
			caps.setCapability("ie.enableFullPageScreenshot", false);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
			caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
			caps.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			caps.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			caps.setCapability("IE.binary", "C:/Program Files/Internet Explorer/iexplore.exe");
			caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

			caps.setCapability("acceptSslCerts",true);
			caps.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
			caps.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, 1);
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setJavascriptEnabled(true);

			// Open browser with capability
			webDriver = new InternetExplorerDriver(caps);
							
			
			i = i + 1;

		} else if (browser.equalsIgnoreCase("chrome")) {	

			Thread.sleep(2000);

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + 
					File.separator + "src" + File.separator + "main" + File.separator + "resources" 
					+ File.separator + "drivers" + File.separator + "chromedriver.exe");
			Thread.sleep(2000);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-popup-blocking");
			options.addArguments("enable-automation");
//			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-extensions");
			options.addArguments("--dns-prefetch-disable");
			options.addArguments("--disable-gpu");
			options.addArguments("--ignore-certificate-errors");
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
//			webDriver = new ChromeDriver();					// For normal Chrome Automation
			
			webDriver = new ChromeDriver(options);			// For Chrome Automation with Options like headless mode etc
			

		}
		
		driver = new EventFiringWebDriver(webDriver);

		Thread.sleep(2000);
		//options.addArguments("--disable-popup-blocking");
		try {
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			// FolderCreation
			reportCreater();
			currentSuit = ctx.getCurrentXmlTest().getSuite().getName();


		} catch (Exception e1) {
			System.out.println(e1);
		}
		// ===============================

		itc = ctx;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		sdf.format(date);

		calculateTestCaseStartTime();

		flag = false;

		// tc_name = method.getName().toString() + "-" + browser;

		//		tstData = Data_Provider.getTestData("TestData", tc_name);

		tstData = Data_Provider.getTestData("TestData", tc_name.replace("-" + browser, ""));
		String[] ts_Name = this.getClass().getName().toString().split("\\.");
		packageName = ts_Name[0] + "." + ts_Name[1] + "." + ts_Name[2];

		testHeader(tc_name.replace("-" + browser, ""));


		stepNum = 0;
		PassNum = 0;
		FailNum = 0;
		testName = method.getName();

		String[] tmp = testName.split("_");
		String desc = "";
		if ((this.testCaseDescription != null) && (!this.testCaseDescription.isEmpty())) {
			desc = this.testCaseDescription;
		} else {
			for (int i = 0; i < tmp.length; i++) {
				desc = desc + " " + tmp[i];
			}
		}
		testDescription.put(testName + "-" + browser, desc);

	}

	// /~~~~~~~~After Method~~~~~~~~
	@Parameters({ "browser" })
	@AfterMethod(alwaysRun = true)
	public void tearDown(String browser) throws Exception {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || tearDown ~~~~~~~~~~~~~~~~~~~~");


		System.out.println("~~~~~~~~After Method~~~~~~~~");
		calculateTestCaseExecutionTime();
		// closeDetailedReport(browser);


		if (FailNum != 0) {
			testResults.put(tc_name.replace("-" + browser, ""), "FAIL");
			map.put(tc_name.replace("-" + browser, ""), "FAIL");
			String[] testData = { tstData.get("TestCaseID"), tstData.get("Module"), tstData.get("TestCaseName"),
					strTestName.split("-")[0] + "_" + rpTime };
			testResultsData.put(tc_name.replace("-" + browser, ""), testData);
			failCounter = failCounter + 1;
			extent.endTest(test);
			extent.flush();
		} else if (tstData.get("ExecuteStatus").trim().equalsIgnoreCase("No")) {
			testResults.put(tc_name.replace("-" + browser, ""), "SKIP");
			map.put(tc_name.replace("-" + browser, ""), "SKIP");
			String[] testData = { tstData.get("TestCaseID"), tstData.get("Module"), tstData.get("TestCaseName") };
			testResultsData.put(tc_name.replace("-" + browser, ""), testData);
			executionTime.put(tc_name.replace("-" + browser, ""), "N/A");
			skipcounter = skipcounter + 1;
		} else if (FailNum == 0 && tstData.get("ExecuteStatus").trim().equalsIgnoreCase("Yes")) {
			testResults.put(tc_name.replace("-" + browser, ""), "PASS");
			map.put(tc_name.replace("-" + browser, ""), "PASS");
			String[] testData = { tstData.get("TestCaseID"), tstData.get("Module"), tstData.get("TestCaseName"),
					strTestName.split("-")[0] + "_" + rpTime };
			testResultsData.put(tc_name.replace("-" + browser, ""), testData);
			passCounter = passCounter + 1;
			extent.endTest(test);
			extent.flush();




			//			System.out.println("testData == " + testData);


		}




		//		System.out.println("testResultsData == " + testResultsData);




		System.out.println(tc_name + "->" + new Date());
		driver.quit();
		Thread.sleep(5000);
		// Writing Execution Data to Log
		createLogFileWithExecutionData();
	}

	// ~~~~~~~~After Class~~~~~~~~
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void close(String browser) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || close ~~~~~~~~~~~~~~~~~~~~");


		System.out.println("~~~~~~~~After Class~~~~~~~~");
	}

	public void reportCreater() throws Throwable {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || reportCreater ~~~~~~~~~~~~~~~~~~~~");


		int intReporterType = Integer.parseInt(configProps.getProperty("reportsType"));

		switch (intReporterType) {
		case 1:
			break;
		case 2:
			break;
		default:
			htmlCreateReport();
			break;
		}
	}

	public void calculateTestCaseStartTime() {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || calculateTestCaseStartTime ~~~~~~~~~~~~~~~~~~~~");


		iStartTime = System.currentTimeMillis();
	}

	/***
	 * This method is supposed to be used in the @AfterMethod to calculate the
	 * total test case execution time to show in Reports by taking the start
	 * time from the calculateTestCaseStartTime method.
	 */
	public void calculateTestCaseExecutionTime() {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || calculateTestCaseExecutionTime ~~~~~~~~~~~~~~~~~~~~");


		iEndTime = System.currentTimeMillis();
		iExecutionTime = (iEndTime - iStartTime);
		TimeUnit.MILLISECONDS.toSeconds(iExecutionTime);
		HtmlReportSupport.executionTime.put(tc_name.replace("-" + browserName, ""),
				String.valueOf(TimeUnit.MILLISECONDS.toSeconds(iExecutionTime)));
		// System.out.println(tc_name+";Time
		// :"+String.valueOf(TimeUnit.MILLISECONDS.toSeconds(iExecutionTime)));
	}

	public void onSuccess(String strStepName, String strStepDes) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || onSuccess 2 param ~~~~~~~~~~~~~~~~~~~~");


		onSuccess(strStepName, strStepDes, "");
	}

	public void onSuccess(String strStepName, String strStepDes, String stepTime) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || onSuccess 3 param ~~~~~~~~~~~~~~~~~~~~");


		file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"
		Writer writer = null;
		stepNum = stepNum + 1;

		try {
			if (!map.get(tc_name).equals("FAIL")) {
				map.put(tc_name, "PASS");
			}
			writer = new FileWriter(file, true);
			writer.write("<tr class='content2' >");
			writer.write("<td>" + stepNum + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes.replace("[", "<b>").replace("]", "</b>") + "</td> ");
			writer.write(
					"<td class='Pass' align='center'><font size='2' color='green'><B>Pass</B></font><img  src='./Screenshots/passed.ico' width='18' height='18'/></td> ");
			PassNum = PassNum + 1;
			String strPassTime = ReportStampSupport.getTime();
			writer.write("<td><small>" + strPassTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeStep() {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || closeStep ~~~~~~~~~~~~~~~~~~~~");


		if (stepHeaderNum > 0) {

			try {
				File file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"
				Writer writer = null;
				writer = new FileWriter(file, true);
				writer.write("</tbody>");
				writer.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void addStep(String strStepDes) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || addStep ~~~~~~~~~~~~~~~~~~~~");


		closeStep();
		File file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"
		Writer writer = null;

		stepHeaderNum = stepNum + 1;
		String sheaderId = "Header_" + stepHeaderNum;
		try {

			writer = new FileWriter(file, true);
			writer.write("<tbody><tr class='section'>");
			writer.write("<td colspan='5' onclick=toggleMenu('" + sheaderId + "')>+ ");
			writer.write(strStepDes.replace("[", "<b>").replace("]", "</b>") + "</td></tr></tbody>");
			writer.write("<tbody id='" + sheaderId + "' style='display:table-row-group'>");

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onWarning(String strStepName, String strStepDes) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || onWarning 2 param ~~~~~~~~~~~~~~~~~~~~");


		onWarning(strStepName, strStepDes, "");
	}

	public void onWarning(String strStepName, String strStepDes, String stepTime) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || onWarning 3 param ~~~~~~~~~~~~~~~~~~~~");


		Writer writer = null;
		try {
			File file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"

			writer = new FileWriter(file, true);
			stepNum = stepNum + 1;

			writer.write("<tr class='content2' >");
			writer.write("<td>" + stepNum + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");
			writer.write("<td class='justified'>" + strStepDes + "</td> ");
			FailNum = FailNum + 1;

			writer.write("<td class='Fail'  align='center'><a  href='" + "./Screenshots" + "/"
					+ strStepDes.replace(" ", "_").replace("[", "").replace("]", "") + stepTime + ".jpeg'"
					+ " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><img src='./Screenshots/warning.ico' width='18' height='18'/></a></td>");

			String strFailTime = ReportStampSupport.getTime();
			writer.write("<td><small>" + strFailTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();

		} catch (Exception e) {

		}

	}

	public void onFailure(String strStepName, String strStepDes, String stepTime) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || onFailure ~~~~~~~~~~~~~~~~~~~~");


		Writer writer = null;
		try {
			File file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"

			writer = new FileWriter(file, true);
			stepNum = stepNum + 1;

			writer.write("<tr class='content2' >");
			writer.write("<td>" + stepNum + "</td> ");
			writer.write("<td class='justified'>" + strStepName + "</td>");

			writer.write("<td class='justified'>" + strStepDes.replace("[", "<b>").replace("]", "</b>") + "</td> ");

			FailNum = FailNum + 1;

			writer.write("<td class='Fail' align='center'><a  href='" + "./Screenshots" + "/"
					+ strStepDes.replace(" ", "_").replace("[", "").replace("]", "") + stepTime + ".jpeg'"
					+ " alt= Screenshot  width= 15 height=15 style='text-decoration:none;'><font size='2' color='red'><B>Fail</B></font><img  src='./Screenshots/failed.ico' width='18' height='18'/></a></td>");

			String strFailTime = ReportStampSupport.getTime();
			writer.write("<td><small>" + strFailTime + "</small></td> ");
			writer.write("</tr> ");
			writer.close();
			if (map.get(tc_name).equals("PASS")) {
				// map.put(packageName + ":" + tc_name + ":", "FAIL");
				Assert.assertTrue(false);
				// map.put(TestTitleDetails.x.toString(),
				// TestEngine.testDescription.get(TestTitleDetails.x.toString()));
			}
		} catch (Exception e) {

		}

	}

	public void closeDetailedReport(String browser) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || closeDetailedReport ~~~~~~~~~~~~~~~~~~~~");


		try {
			closeStep();

			File file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"
			Writer writer = null;
			writer = new FileWriter(file, true);
			writer.write("</table>");
			writer.write("<table id='footer'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("<col style='width: 25%' />");
			writer.write("</colgroup>");
			writer.write("<tfoot>");
			writer.write("<tr class='heading'> ");
			writer.write("<th colspan='4'>Execution Time In Seconds (Includes Report Creation Time) : "
					+ executionTime.get(tc_name) + "&nbsp;</th> ");
			writer.write("</tr> ");
			writer.write("<tr class='content'>");
			writer.write("<td class='pass'>&nbsp;Steps Passed&nbsp;:</td>");
			writer.write("<td class='pass'> " + PassNum + "</td>");
			writer.write("<td class='fail'>&nbsp;Steps Failed&nbsp;: </td>");
			writer.write("<td class='fail'>" + FailNum + "</td>");
			writer.write("</tr>");
			writer.close();
		} catch (Exception e) {

		}
	}

	public void closeSummaryReport(String browser) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || closeSummaryReport ~~~~~~~~~~~~~~~~~~~~");


		if (TestEngine.buildNumer_Jenkins != null) {
			file = new File(TestEngine.filePath() + "/" + "Summary_Results_" + TestEngine.buildNumer_Jenkins + ".html");// "SummaryReport.html"
		} else {
			file = new File(TestEngine.filePath() + "/" + "Summary_Results_" + TestEngine.rpSumDt + ".html");// "SummaryReport.html"
		}
		// file = new File(TestEngine.filePath() + "/" + "Summary_Results_" +
		// TestEngine.rpSumDt + ".html");// "SummaryReport.html"
		Writer writer = null;
		try {

			writer = new FileWriter(file, true);
			writer.write("<table id='footer'>");
			writer.write("<colgroup>");
			writer.write("<col style='width: 17%' />");
			writer.write("<col style='width: 17%' />");
			writer.write("<col style='width: 17%' />");
			writer.write("<col style='width: 17%' /> ");
			writer.write("<col style='width: 16%' /> ");
			writer.write("<col style='width: 16%' /> ");
			writer.write("</colgroup> ");
			writer.write("<tfoot>");
			writer.write("<tr class='heading'>");
			writer.write("<th colspan='6'>Total Duration  In Seconds (Including Report Creation) : "
					+ ((int) iSuiteExecutionTime) + "</th>");
			writer.write("</tr>");
			writer.write("<tr class='content'>");
			writer.write("<td class='pass'>&nbsp;Tests Passed&nbsp;:</td>");
			writer.write("<td class='pass'> " + passCounter + "</td> ");
			writer.write("<td class='fail'>&nbsp;Tests Failed&nbsp;:</td>");
			writer.write("<td class='fail'> " + failCounter + "</td> ");
			writer.write("<td class='skip'>&nbsp;Tests Skipped&nbsp;:</td>");
			writer.write("<td class='skip'> " + skipcounter + "</td> ");
			writer.write("</tr>");
			writer.write("</tfoot>");
			writer.write("</table> ");
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reportStep(String StepDesc) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || reportStep ~~~~~~~~~~~~~~~~~~~~");


		StepDesc = StepDesc.replaceAll(" ", "_");
		File file = new File(TestEngine.filePath() + "/" + strTestName.split("-")[0] + "_" + rpTime + ".html");// "SummaryReport.html"
		Writer writer = null;

		try {
			writer = new FileWriter(file, true);
			if (BFunctionNo > 0) {
				writer.write("</tbody>");
			}
			writer.write("<tbody>");
			writer.write("<tr class='section'> ");
			writer.write("<td colspan='5' onclick=toggleMenu('" + StepDesc + stepNum + "')>+ " + StepDesc + "</td>");
			writer.write("</tr> ");
			writer.write("</tbody>");
			writer.write("<tbody id='" + StepDesc + stepNum + "' style='display:table-row-group'>");
			writer.close();
			BFunctionNo = BFunctionNo + 1;
		} catch (Exception e) {

		}
	}

	/**
	 * killBrowserInstance :: It kills the browser processes running if any.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void killBrowserInstance() throws InterruptedException {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || killBrowserInstance ~~~~~~~~~~~~~~~~~~~~");


		try {
			System.out.println("..");
			if (System.getProperty("os.name").contains("Windows"))
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			else {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver");
			}
			// Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Thread.sleep(10000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void killBrowserInstance_ie() throws InterruptedException {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || killBrowserInstance_ie ~~~~~~~~~~~~~~~~~~~~");


		try {
			System.out.println("..");
			if (System.getProperty("os.name").contains("Windows"))
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			// SuccessReportWithScreenshot("Close All IEDriverServer instances",
			// "Sucessfully Closed all existing IEDriverServer instances");
			else {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer");
			}
			// Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			Thread.sleep(10000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ClosBrowserHistory() throws Throwable {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || ClosBrowserHistory ~~~~~~~~~~~~~~~~~~~~");


		String IEDriverServer = "taskkill /f /im IEDriverServer.exe";

		try {
			Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255");
			Thread.sleep(40);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public void CloseIEDriverServerinstances() throws Throwable {
	 * 
	 * String IEDriverServer="taskkill /f /im IEDriverServer.exe";
	 * 
	 * try
	 * 
	 * {
	 * 
	 * System.out.println("Close all existing IEDriverServer instances");
	 * SuccessReportWithScreenshot("Close All IEDriverServer instances",
	 * "Sucessfully  Closed all existing IEDriverServer instances"); Process
	 * process = Runtime.getRuntime().exec(IEDriverServer);
	 * 
	 * 
	 * } catch (IOException e)
	 * 
	 * {
	 * 
	 * e.printStackTrace(); failureReport("Close All IEDriverServer instances",
	 * "Failed to Close all existing IEDriverServer instances"); }
	 */

	// }
	/**
	 * Used for Results Folder creation with TestName froM XML
	 * 
	 * @param testContext
	 */

	@BeforeTest(alwaysRun = true)
	public void startTest(final ITestContext testContext) {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || startTest ~~~~~~~~~~~~~~~~~~~~");


		iTestStartTime = System.currentTimeMillis();
		application = testContext.getCurrentXmlTest().getParameter("CurrentApplication").trim();
		chartName = propertyManager.get("ReleaseVersion") + "ExecutionStatus";
		failCounter = 0;
		passCounter = 0;
		serialNo = 0;
		folderName = testContext.getName().trim();

		System.out.println("~~~~~~~~Before Test~~~~~~~~");
		System.out.println(folderName); // it prints "Check name test"

	}

	/**
	 * Closing the SummaryReport
	 * 
	 * @throws IOException
	 */

	@Parameters({ "browser" })
	@AfterTest(alwaysRun = true)
	public void closeTest() throws IOException {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || closeTest ~~~~~~~~~~~~~~~~~~~~");


		ReportStampSupport.calculateTestExecutionTime();

		System.out.println("~~~~~~~~After Test~~~~~~~~");

		if (configProps.getProperty("ChartType").trim().equalsIgnoreCase("Pie")
				|| configProps.getProperty("ChartType").trim().contains("Pie")
				|| configProps.getProperty("ChartType").trim().contains("pie"))
			createPieChartForReport(chartName, passCounter, failCounter, 0);
		else
			System.out.println("Currently Supports only Pie Graph");
		// createBarChartForReport(chartName, passCounter, failCounter, 0);

		try {
			HtmlReportSupport.createHtmlSummaryReport(browserName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// closeSummaryReport(browser);
		// File_Html_RelativePath1=File_Html_RelativePath;
		// System.out.println("~~~~~~~~After Test~~~~~~~~");
		// System.out.println(File_Html_RelativePath1);
		// driver.get(File_Html_RelativePath);

	}

	/**
	 * Used to Create Pie Chart for Report
	 * 
	 * @param suiteName
	 * @param passCount
	 * @param failCount
	 * @param skipCount
	 */
	public void createPieChartForReport(String chartName, int passCounter, int failCounter, int skipCounter)
			throws IOException {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || createPieChartForReport ~~~~~~~~~~~~~~~~~~~~");


		DefaultPieDataset dataset = new DefaultPieDataset();

		// Data Set Values
		dataset.setValue("Pass " + passCounter, new Double(passCounter));
		dataset.setValue("Fail " + failCounter, new Double(failCounter));
		dataset.setValue("Skip " + skipCounter, new Double(skipCounter));

		JFreeChart chart = ChartFactory.createPieChart(chartName, dataset, true, true, true);

		// LegendTitle legend = chart.getLegend();
		// legend.setFrame(new BlockBorder(Color.white));

		PiePlot ColorConfigurator = (PiePlot) chart.getPlot();
		ColorConfigurator.setSimpleLabels(true);
		ColorConfigurator.setLabelLinksVisible(true);
		ColorConfigurator.setSectionOutlinesVisible(false);
		ColorConfigurator.setShadowPaint(null);
		ColorConfigurator.setLabelGenerator(null);

		// Percentage Values
		ColorConfigurator.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));

		// Customized Colors
		Color pass_color = new Color(200, 57, 35);
		Color fail_color = new Color(231, 222, 21);
		Color skip_color = new Color(83, 180, 29);

		ColorConfigurator.setSectionPaint("Skip " + skipCounter, fail_color);
		ColorConfigurator.setSectionPaint("Fail " + failCounter, pass_color);
		ColorConfigurator.setSectionPaint("Pass " + passCounter, skip_color);

		int width = 400;
		int height = 400;
		try {

			/*
			 * ChartUtilities.saveChartAsJPEG(new File( TestEngine.filePath() +
			 * File.separator + "Screenshots" + File.separator + chartName +
			 * ".jpg"), chart, width, height);
			 */ } catch (Exception e) {
				 e.printStackTrace();
			 }

	}

	/**
	 * Used to Create Log File with Execution Data
	 */
	public void createLogFileWithExecutionData() {


		//		System.out.println("~~~~~~~~~~~~~~~~~~~ TestEnginec || createLogFileWithExecutionData ~~~~~~~~~~~~~~~~~~~~");


		try {

			String[] className = this.getClass().getName().toString().split("\\.");

			logger.info("================================================");
			logger.info("Class Name" + " : " + className[(className.length) - 1]);
			logger.info("================================================");
			if (executionData != null) {
				Iterator<Entry<String, String>> entries = executionData.entrySet().iterator();
				while (entries.hasNext()) {
					Entry<String, String> entry = entries.next();
					if (entry.getKey().trim().equalsIgnoreCase("ClassName"))
						continue;
					logger.info(entry.getKey() + " : " + entry.getValue());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
