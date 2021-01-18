
/**
 * @Author Satish Kumar A
 * @Date April 21, 2020
 */

package com.Script.R05;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.InspectionsAndMeetings_BCF;
import com.Pages.License_And_Certificate_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.Pages.ToDo_BCF;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_375 extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_375(String browser,Method method) throws Throwable {
				
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String Description = tstData.get("Description");		
			String Type = tstData.get("Type");	
			String Department= tstData.get("Department");
			String Location = tstData.get("Location");
			String InspectionDate = tstData.get("InspectionDate");	
			String ItemCode = tstData.get("ItemCode");
			String Finding = tstData.get("Finding");
			String CorrectiveAction = tstData.get("CorrectiveAction");
			String Summary = tstData.get("Summary");
			String Details = tstData.get("Details");
			String ItemCode1 = tstData.get("ItemCode1");
			String Finding1 = tstData.get("Finding1");
			String CorrectiveAction1 = tstData.get("CorrectiveAction1");
			String ItemCode2 = tstData.get("ItemCode2");
			String Finding2 = tstData.get("Finding2");
			String CorrectiveAction2 = tstData.get("CorrectiveAction2");
			
			
			// Create alias for the Maximo Login Page Method
			MaximoLoginPage MaximoLogin = new MaximoLoginPage();
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			
			// Create alias for the Inspections  And Meetings Page Method
			InspectionsAndMeetings_BCF InspectionsAndMeetings = new InspectionsAndMeetings_BCF();		
			
			// This method is for Initialization method for Daily Log Module
			MaximoLogin.LogInToMaxima(userNameString, passwordString);
			
			// This method is used to navigate to InspectionsAndMeetings
			StartCenter.navigateToInspectionsAndMeetings();
			
			
			//This method is used to click InspectionAndMeeting
			InspectionsAndMeetings.newInspectionAndMeeting_CLick();
			
			//This Method is used to Enter New inspection and meeting details
			InspectionsAndMeetings.enterValuesforNewInspectionAndMeeting(Description, Type, Location, Department);

			// This Method is used to Enter Inspection date
			InspectionsAndMeetings.EnterInspectionDate(InspectionDate);
			
			// This Method is used to Enter Findings
			InspectionsAndMeetings.AddFindings(ItemCode1,ItemCode2, Finding1,Finding2,CorrectiveAction1,CorrectiveAction2);	

			// This Method is used to save Inspection and meeting item
			InspectionsAndMeetings.save_InspectionAndMeeting_CLick();	

//			// This Method is used to Change Status to Active
//			InspectionsAndMeetings.ChangeStatusto_Active();		
			
			// This Method is used to Enter Findings
			InspectionsAndMeetings.AddLogs(Summary, Details);

			// This Method is used to save Inspection and meeting item
			InspectionsAndMeetings.save_InspectionAndMeeting_CLick();	

			// This Method is used to Change Status to Completed
			InspectionsAndMeetings.ChangeStatusto_Completed();			
			
				
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
