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

public class Login_To_Maximo extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void Login_To_Maximo(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");			
			
			MaximoLoginPage Login = new MaximoLoginPage();
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			
			// This Method is Used to Launch the Maximo Application
			Login.maximoLaunchURL(browser);
			
			// This Method is used to verify the Maximo Login Page
			Login.verifyMaximoLoginPage("Welcome to Maximo");
			
			// This Method is used to Login to Maximo
			Login.maximoLogin(userNameString, passwordString);
			
			// This Method is used to Validate the Maximo Start Center
			StartCenter.verifyMaximoStartCenter("Start Center");
			
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
