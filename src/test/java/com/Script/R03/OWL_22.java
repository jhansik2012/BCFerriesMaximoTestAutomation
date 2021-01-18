
/**
 * @Author Satish Kumar A
 * @Date April 16, 2020
 */

package com.Script.R03;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.License_And_Certificate_BCF;
import com.Pages.Lost_And_Found_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.Pages.ToDo_BCF;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_22 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_22(String browser, Method method) throws Throwable {

		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));

			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String LAFDescription = tstData.get("LAFDescription");
			String LAFClassification = tstData.get("LAFClassification");
			String LAFShift = tstData.get("LAFShift");
			String LostAndFoundLocation = tstData.get("LostAndFoundLocation");
			String details = tstData.get("details");


			// Create alias for the Maximo Login Page Method
			MaximoLoginPage MaximoLogin = new MaximoLoginPage();

			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();

			// Create alias for the Loss And Found_BCF Page Method
			Lost_And_Found_BCF lost_And_Found = new Lost_And_Found_BCF();

			// This method is for login in to Application
			MaximoLogin.LogInToMaxima(userNameString, passwordString);

			// This method is used to navigate to LostAndFound
			StartCenter.navigateToLostAndFound();

			// This method is used to click on Lost And Found List Tab
			lost_And_Found.LostAndFound_NavigateToListTab();

			// This method is used to click new Lost and Found
			lost_And_Found.NewLostAndFound_CLick();

			// This method is used to enter values in Lost and Found
			lost_And_Found.EnterValuesforLostAndFound(LAFDescription, LAFClassification, LAFShift,
					LostAndFoundLocation);

			// Read the LostAndFound- Read lost_And_Found ID
			String lostAndFound = lost_And_Found.LostAndFoundReadReturnID();

			// This Method is used to save Lost and Found
			lost_And_Found.SaveLostAndFound_CLick();

			// This Method is used to Filter the data by lost_And_Found ID
			lost_And_Found.LostAndFound_IDFilter(lostAndFound);

			// This Method is used to Open the filtered record in List Tab of Lost and Found
			lost_And_Found.LostAndFoundListTab_OpenSelectedRecord();

			// This Method is used to enter comments in detailed section
			lost_And_Found.LostAndFound_EnterCommentsInDetailsField(details);

			// This Method is used to save Lost and Found
			lost_And_Found.SaveLostAndFound_CLick();

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
