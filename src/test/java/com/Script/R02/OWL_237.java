/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 10, 2020
 */

package com.Script.R02;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.Drill_Log_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_237 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_237(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String drillLogDescription_s = tstData.get("dl_Description");			
			String drillLogDepartment_s = tstData.get("dl_Department");			
			String drillLogLocation_s = tstData.get("dl_Location");			
			String drillLogWatch_s = tstData.get("dl_Watch");				
			String drillLogPOA_s = tstData.get("dl_POA");			
			String drillLogRoute_s = tstData.get("dl_Route");			
			String drillLogShift_s = tstData.get("dl_Shift");			
			String drillLogDrillType_s = tstData.get("dl_DrillType");			
			String drillLogDrillDate_s = tstData.get("dl_DrillDate");	
			String drillLogDepartment_New_str = tstData.get("dl_Department_New");
			String drillLogWatch_New_str = tstData.get("dl_Watch_New");
			String drillLogShift_New_str = tstData.get("dl_Shift_New");
			String drillLogCommentSummary_str = tstData.get("dl_Comments_Summary");	
					
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);	
			
			// This Method is used to create new drill log
			DrillLog.NewDrillLog_CLick();
			System.out.println("drillLogDescription_s"+drillLogDescription_s);
			// This Method is used to enter data into the drill log page
			DrillLog.EnterValuesforDrillLog(drillLogDescription_s, drillLogDepartment_s, drillLogLocation_s, 
					drillLogWatch_s, drillLogShift_s, drillLogDrillType_s, drillLogDrillDate_s,
					drillLogPOA_s, drillLogRoute_s);
			
			// This Method is used to save drill log
			DrillLog.SaveDrillLog_CLick();
			
			// Read the Drill Log- Drill ID and save it to a variable
			String DrillIDstr = DrillLog.DrillLog_ReadReturnDrillID();
			
			// Navigate to Drill Log - List tab
			DrillLog.DrillLog_ListTab_CLick();
									
			// This Method is used to Search for Drill Log List with Status
			DrillLog.DrillLog_ListPage_DrillID_Filter(DrillIDstr);
			
			// This Method is used to click on the first record and open it
			DrillLog.DrillLog_ListPage_ClickFirstRecord();
			
			// This Method is used to update the opened record
			DrillLog.DrillLog_UpdateDrillRecord_OWL_237(drillLogDepartment_New_str, 
					drillLogWatch_New_str, drillLogShift_New_str);
			
			// This Method is used to save the updated record
			DrillLog.SaveDrillLog_CLick();		
			
			//Change the status of the drill log to Completed
			DrillLog.CompleteDrillLog_CLick();
			
			// This Method is used to click on the first record and open it
			DrillLog.DrillLog_AddComments(DrillIDstr, drillLogCommentSummary_str);
			
			// This Method is used to save the updated record
			DrillLog.SaveDrillLog_CLick();
			
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