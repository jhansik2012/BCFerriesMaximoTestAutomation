/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 30, 2020
 */

package com.Script.UAT_R01_R02;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_UAT_R01R02_TEST04 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_UAT_R01R02_TEST04(String browser, Method method) throws Throwable {

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
			String dailyLogEntrySummary2_s = tstData.get("dl_LogEntrySummary2");
			String dailyLogSailingData_Sailing_s = tstData.get("dl_SailingData_Sailing");
			String dailyLogSailingData_PassengerCount_s = tstData.get("dl_SailingData_PassengerCount");
			String dailyLogSailingData_PRA_s = tstData.get("dl_SailingData_PRA");
			String dailyLogSailingData_Type = tstData.get("dl_SailingData_Type");
			String dailyLogSailingData_LicenseType = tstData.get("dl_SailingData_LicenseType");
			

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

			// This Method is used to Click on New Row button of Daily Log - Log Entry
			DailyLog.DailyLog_LogEntry_NewRow();

			// This Method is used to Enter First Log Summary in Daily Log - Log Entry
			DailyLog.DailyLog_LogEntry_EnterFirstSummary(dailyLogEntrySummary1_s);

			// This Method is used to Click on New Row button of Daily Log - Log Entry
			DailyLog.DailyLog_LogEntry_NewRow();

			// This Method is used to Enter First Log Summary in Daily Log - Log Entry
			DailyLog.DailyLog_LogEntry_EnterFirstSummary(dailyLogEntrySummary2_s);

			// // This Method is used to enter "Enter/Return" key
			// Enter(DailyLog.newDailyLog_LogEntries_LogSummary);
			//
			// // This Method is used to Enter Second Log Summary in Daily Log - Log Entry
			// DailyLog.DailyLog_LogEntry_EnterScndSummary(dailyLogEntrySummary2_s);

			// This Method is used to save the daily log
			DailyLog.SaveDailyLog_CLick();

			// This Method is used to Navigate to More Actions - Modify/Delete Entry Logs in
			// Daily Log
			DailyLog.DailyLog_MoreActionsModDelEntryLogs();

			// This Method is used to Delete the latest log in More Actions - Modify/Delete
			// Entry Logs in Daily Log
			DailyLog.DailyLog_MoreActionsModDelEntryLogs_DeleteLatestLog();

			// This Method is used to Click the "Carry Over?" check-box for the latest log
			// in Daily Log - Log Entries
			DailyLog.DailyLog_LogEntries_CarryOverClick();

			// This Method is used to save the daily log
			DailyLog.SaveDailyLog_CLick();

			DailyLog.ScrollToSailingDetails("SailingDetails");
			
			// This Method is used to Click and Enter new row details in Daily Log - Sailing Data
			DailyLog.DailyLog_SailingData_NewRowEnterData(dailyLogSailingData_Sailing_s,dailyLogSailingData_Type,dailyLogSailingData_PassengerCount_s, dailyLogSailingData_PRA_s,dailyLogSailingData_LicenseType);


			// This Method is used to save the daily log
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
