/**
 * @Author Satish Kumar Adapa
 * @Date Jan 30, 2020
 */

package com.Script.R02;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.Drill_Log_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class SMK_TEST_ACC extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void SMK_TEST_ACC(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString1 = tstData.get("UserName1");
			String userNameString2 = tstData.get("UserName2");
			String userNameString3 = tstData.get("UserName3");
			String userNameString4 = tstData.get("UserName4");
			String userNameString5 = tstData.get("UserName5");
			String userNameString6 = tstData.get("UserName6");
			String userNameString7 = tstData.get("UserName7");
			String userNameString8 = tstData.get("UserName8");
			String userNameString9 = tstData.get("UserName9");
			String userNameString10 = tstData.get("UserName10");
			String userNameString11 = tstData.get("UserName11");
			String userNameString12 = tstData.get("UserName12");
			String userNameString13 = tstData.get("UserName13");
			String passwordString   =   tstData.get("Password");
//			String titleOfPage = tstData.get("Title");
			
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter maximoStartCenter = new MaximoStartCenter();
		    //Create object for MaximoLoginPage
			MaximoLoginPage maximoLoginPage = new MaximoLoginPage();
			
	       //*********user 1************
			System.out.println("*********user 1************");
			maximoLoginPage.launchMaximoURLAndLogin(userNameString1,passwordString);	
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//For log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			

	        //*********user 2************
			System.out.println("*********user 2************");
			//Launch URL
//			maximoLoginPage.launchMaximoURLAndLogin(userNameString2,passwordString);
			maximoLoginPage.maximoLaunchURL(browser);	
			maximoLoginPage.maximoLogin(userNameString2,passwordString);
			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
      		//*********user 3************
			System.out.println("*********user 3************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString3,passwordString);		
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
    		maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 4************
			System.out.println("*********user 4************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString4,passwordString);
			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 5************
			System.out.println("*********user 5************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString5,passwordString);
			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 6************
			System.out.println("*********user 6************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString6,passwordString);		
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
     		//*********user 7************
			System.out.println("*********user 7************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString7,passwordString);
			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 8************
			System.out.println("*********user 8************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString8,passwordString);			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 9************
			System.out.println("*********user 9************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString9,passwordString);
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
	
			//*********user 10************
			System.out.println("*********user 10************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString10,passwordString);		
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 11************
			System.out.println("*********user 11************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString11,passwordString);
			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			//*********user 12************
			System.out.println("*********user 12************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString12,passwordString);			
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			implicityWait(5);
			
			
			//*********user 13************
			System.out.println("*********user 13************");
			//Launch URL
			maximoLoginPage.maximoLaunchURL(browser);
			maximoLoginPage.maximoLogin(userNameString13,passwordString);	
			//Verify user is able to login
			//maximoStartCenter.verifyMaximoStartCenter(titleOfPage);			
			//log off
			maximoStartCenter.logOffMaximo();
			/**********************
			 * Script Ends here
			 *******************************************/

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}