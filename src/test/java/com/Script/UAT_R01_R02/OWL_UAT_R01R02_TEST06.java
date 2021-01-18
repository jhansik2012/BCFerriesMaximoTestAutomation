/**
 * @Author satish
 * 
 */

package com.Script.UAT_R01_R02;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_UAT_R01R02_TEST06 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_UAT_R01R02_TEST06(String browser, Method method) throws Throwable {

		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));

			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String dailyLogRoute_s = tstData.get("dl_Route");
			String dailyLogLocation_s = tstData.get("dl_Location");
			String dailyLogShift_s = tstData.get("dl_Shift");
			String dailyLogDepartment_s = tstData.get("dl_Department");
			String dailyLogWatch_s = tstData.get("dl_Watch");
			String dailyLogShiftReference_s = tstData.get("dl_ShiftReference");
			String dailyLogShiftStart_s = tstData.get("dl_ShiftStart");
			String dailyLogShiftFinish_s = tstData.get("dl_ShiftFinish");
			String dailyLogSupervisor_s = tstData.get("dl_Supervisor");
			String dailyLogPOA_s = tstData.get("dl_POA");
			String dailyLogNameFilter1_s = tstData.get("dl_NameFilter1");

			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			DailyLog_BCF DailyLog = new DailyLog_BCF();

			// This method is for Initialization method for Daily Log Module
			DailyLog.dailyLogInit(userNameString, passwordString);

			// This Method is used to create new Daily log
			DailyLog.NewDailyLog_CLick();

			// This Method is used to enter data into the Daily log page
			DailyLog.EnterValuesforDailyLog(dailyLogLocation_s, dailyLogShift_s, dailyLogDepartment_s, dailyLogWatch_s,
					dailyLogRoute_s, dailyLogShiftReference_s, dailyLogShiftStart_s, dailyLogShiftFinish_s,
					dailyLogSupervisor_s, dailyLogPOA_s);

			// This Method is used to All people to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_NameFilter(dailyLogNameFilter1_s);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();

			// Read the Daily Log- Shift Log Description and save it to a variable
			String description = DailyLog.DailyLog_ReadReturnShiftLDescription();

			// This Method is used to navigate to Daily log - List Tab
			DailyLog.DailyLog_NavigateToListTab();

			// Enter value in Route filter
			DailyLog.DailyLog_ListPage_Route_Filter(dailyLogRoute_s);

			// Enter value in Description filter
			DailyLog.DailyLog_ListPage_Description_Filter(dailyLogDepartment_s);

			// This Method is used to Open the filtered record in List Tab of Daily Log
			DailyLog.DailyLogListTab_OpenSelectedRecord();

			// This Method is used to click on muster list tab
			DailyLog.DailyLog_NavigateToMusterListTab();

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
