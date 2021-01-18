/**
 * @Author Satish Kumar A
 * @Date Feb 20, 2020
 */

package com.Script.R01;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_170 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_170(String browser, Method method) throws Throwable {

		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));

			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String dailyLogLocation_s = tstData.get("dl_Location");
			String dailyLogShift_s = tstData.get("dl_Shift");
			String dailyLogDepartment_s = tstData.get("dl_Department");
			String dailyLogWatch_s = tstData.get("dl_Watch");
			String dailyLogRoute_s = tstData.get("dl_Route");
			String dailyLogShiftReference_s = tstData.get("dl_ShiftReference");
			String dailyLogShiftStart_s = tstData.get("dl_ShiftStart");
			String dailyLogShiftFinish_s = tstData.get("dl_ShiftFinish");
			String dailyLogSupervisor_s = tstData.get("dl_Supervisor");
			String dailyLogPOA_s = tstData.get("dl_POA");
			
			String dailyLogEntrySummary1_s = tstData.get("dl_LogEntrySummary1");
			String dailyLogEntrySummary_s = tstData.get("dl_LogEntrySummary");
			String dailyLogWeather = tstData.get("dl_Weather");

			
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			DailyLog_BCF DailyLog = new DailyLog_BCF();

			// This method is for Initialization method for Daily Log Module
			DailyLog.dailyLogInit(userNameString, passwordString);

			// This Method is used to display all records in the Daily log grid
			DailyLog.ReloadDailyLogTable();

			// This Method is used to create new Daily log
			DailyLog.NewDailyLog_CLick();

			// This Method is used to enter data into the Daily log page
			DailyLog.EnterValuesforDailyLog(dailyLogLocation_s, dailyLogShift_s, dailyLogDepartment_s, dailyLogWatch_s,
					dailyLogRoute_s, dailyLogShiftReference_s, dailyLogShiftStart_s, dailyLogShiftFinish_s,
				 	dailyLogSupervisor_s, dailyLogPOA_s);
			
            //This method is used to enter Weather
			DailyLog.EnterWeather(dailyLogWeather);
			
			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();
			
			// This Method is used to Click on New Row button of Daily Log - Log Entry
			DailyLog.DailyLog_LogEntry_NewRow();

			// This Method is used to Enter First Log Summary in Daily Log - Log Entry
			DailyLog.DailyLog_LogEntry_EnterFirstSummary(dailyLogEntrySummary1_s);
				        
			
			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();

//			// Read the Daily Log- Shift Log ID and save it to a variable
//			String ShiftLogID_s = DailyLog.DailyLog_ReadReturnShiftLogID();
//
//			// This Method is used to navigate to Daily log - List Tab
//			DailyLog.DailyLog_NavigateToListTab();
//
//			// This Method is used to Filter the data by Shift Log ID in List Tab of Daily
//			// Log
//			DailyLog.DailyLogListTab_ShiftLogIDFilter(ShiftLogID_s);
//
//			// This Method is used to Open the filtered record in List Tab of Daily Log
//			DailyLog.DailyLogListTab_OpenSelectedRecord();
			
			//This Method is used to search Logs
            DailyLog.DailyLog_LogEntry_Logs_FilterSearch(dailyLogEntrySummary_s);;
			
            //This method is used to verify Logs after searching.
            DailyLog.validateLogsIsAddedOrNot();
					
			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();

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
