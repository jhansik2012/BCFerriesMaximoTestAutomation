/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 17, 2019
 */

package com.Script;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class Open_Drill_Logs extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void Open_Drill_Logs(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");	
			String searchString = tstData.get("searchString");
			
			MaximoLoginPage Login = new MaximoLoginPage();
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			
			// This Method is Used to Launch the Maximo Application
			Login.maximoLaunchURL(browser);
			
			// This Method is used to verify the Maximo Login Page
			Login.verifyMaximoLoginPage("Welcome to Maximo");
			
			// This Method is used to Login to Maximo
			Login.maximoLogin(userNameString, passwordString);
			
			SuccessReportWithScreenshot("Maximo Login Successfull");
			
			// This Method is used to Search for Drill Lohs in the Applications
			StartCenter.navigateToDrillLog();
			
			// This Method is used to Log Off from Maximo
			StartCenter.logOffMaximo();
			
			/**********************
			 * Script Ends here
			 *******************************************/

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
