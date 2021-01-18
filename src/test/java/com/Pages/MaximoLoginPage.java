/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 17, 2019
 */

package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Parameters;

import com.accelerators.ActionEngine;
import com.accelerators.CredentialManager;
import com.relevantcodes.extentreports.LogStatus;
import com.Pages.MaximoStartCenter;

public class MaximoLoginPage extends ActionEngine {

	public static By userName = By.xpath("//input[@id = \"j_username\"]");
	public static By password = By.xpath("//input[@id = \"j_password\"]");
	public static By signInBtn = By.xpath("//button[@id = \"loginbutton\"]");
	
	// To accommodate/override the SSL Issue in Internet Explorer
	public static By infoBlockIDImage = By.xpath("//img[@id = \"infoBlockIDImage\"]");
	public static By newDrillLog = By.xpath("//a[@id = \"overridelink\"]");
	
	/**
	 * @Description: Launching Maximo URL
	 * @throws Throwable
	 */
	@Parameters({ "browser" })
	public void maximoLaunchURL(String browser) throws Throwable {
		try {

			propertyManager = CredentialManager.getProperty("Properties");
			credentialManager = CredentialManager.getProperty(propertyManager.get("Environment"));

			launchUrl(credentialManager.get("Url"));
			implicityWait(2);
//			pageRefresh();
//			implicityWait(4);
//			explicityWait(signInBtn);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Verify the Maximo Login Page
	 * @throws Throwable
	 */
	public void verifyMaximoLoginPage(String actualpageTitle) throws Throwable {
		try {

			assertTitle(actualpageTitle);
			isElementPresent(userName, "Maximo User Name Field");
			isElementPresent(password, "Maximo Password Field");
			isElementPresent(signInBtn, "Maximo Sign In Button");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Enter UserName and Password
	 * @throws Throwable
	 */
	public void maximoLogin(String userNameString, String passwordString) throws Throwable {
		try {
			
			click(userName, "Click User Name");
			implicityWait(1);
			clear(userName);	
			type(userName, userNameString, "User Name");
			click(password, "Click User Name");
			implicityWait(1);
			clear(password);	
			type(password, passwordString, "Password");
			JSClick(signInBtn, "Maximo Sign In button");
			implicityWait(2);
			pageRefresh();
			implicityWait(7);
			//Alert();
			///Alert();
			//explicityWait_ElementVisible(com.Pages.MaximoStartCenter.overDueDrills_SetChartOptions);
//			Thread.sleep(15000);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void launchMaximoURLAndLogin(String userNameString, String passwordString) throws Throwable {
		try {
			
			// Create alias for the Maximo Login Page Method
			MaximoLoginPage Login = new MaximoLoginPage();
            Login.maximoLaunchURL(browser);	
			Login.verifyMaximoLoginPage("Welcome to Maximo");
			Login.maximoLogin(userNameString, passwordString);	
			//explicityWait(com.Pages.MaximoStartCenter.overDueDrills_SetChartOptions);
			implicityWait(2);
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

    
    public void LogInToMaxima(String userNameString, String passwordString) throws Throwable {
		try {

			// Create alias for the Maximo Login Page Method
			MaximoLoginPage Login = new MaximoLoginPage();
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// This Method is Used to Launch the Maximo Application
			Login.maximoLaunchURL(browser);
			// This Method is used to verify the Maximo Login Page
			Login.verifyMaximoLoginPage("Welcome to Maximo");
			// This Method is used to Login to Maximo
			Login.maximoLogin(userNameString, passwordString);
			//SuccessReportWithScreenshot("Maximo Login Successfull");
			// This Method is used to navigate to "Daily Log" in the Applications
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	
	
}
