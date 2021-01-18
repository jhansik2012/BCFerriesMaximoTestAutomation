/**
 * @Author Satish Kumar A
 * @Date Feb 5, 2020
 */

package com.Script.UAT_R01_R02;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_UAT_R01R02_TEST07 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_UAT_R01R02_TEST07(String browser, Method method) throws Throwable {

		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));

			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String dailyLogDescription_s = tstData.get("dl_Description");
			String dailyLogRoute_s = tstData.get("dl_Route");
			String dailyLogStartDate_From = tstData.get("dl_StartDateFrom");
			String dailyLogStartDate_To = tstData.get("dl_StartDateTo");

			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			DailyLog_BCF DailyLog = new DailyLog_BCF();

			// This method is for Initialization method for Daily Log Module
			DailyLog.dailyLogInit(userNameString, passwordString);

			// This Method is used to display all records in the Daily log grid
			// DailyLog.ReloadDailyLogTable();

			// This Method is used to create new Daily log
			// DailyLog.NewDailyLog_CLick();

			// This Method is used to enter data into the Daily log page
			// DailyLog.EnterValuesforDailyLog(dailyLogLocation_s,
			// dailyLogShift_s, dailyLogDepartment_s, dailyLogWatch_s, dailyLogRoute_s,
			// dailyLogShiftReference_s, dailyLogShiftStart_s, dailyLogShiftFinish_s,
			// dailyLogSupervisor_s, dailyLogPOA_s);

			// This Method is used to save Daily log
			// DailyLog.SaveDailyLog_CLick();

			// Read the Daily Log- Shift Log ID and save it to a variable
			// String ShiftLogID_s = DailyLog.DailyLog_ReadReturnShiftLogID();

			// This Method is used to navigate to Daily log - List Tab
			// DailyLog.DailyLog_NavigateToListTab();

			// This Method is used to Filter the data by Shift Log ID in List Tab of Daily
			// Log
			// DailyLog.DailyLogListTab_ShiftLogIDFilter(ShiftLogID_s);

			// Enter value in Route filter
			DailyLog.DailyLog_ListPage_Route_Filter(dailyLogRoute_s);

			// This method is used to get the count of filtered records
			DailyLog.DailyLog_ListPage_RecordCount();

			// This method is used to clear the filters
			DailyLog.DailyLog_ListPage_ClearFilters();

			// Enter value in Description filter
			DailyLog.DailyLog_ListPage_Description_Filter(dailyLogDescription_s);

			// This method is used to get the count of filtered records
			DailyLog.DailyLog_ListPage_RecordCount();

			// This method is used to clear the filters
			DailyLog.DailyLog_ListPage_ClearFilters();

//			// This method is used to click Advanced Search button
//			DailyLog.DailyLog_ListPage_AdvancedSearch();
//
//			// This method is used to Enter Start dates in More Search Field Pop-up
//			DailyLog.EnterMoreSearchFields(dailyLogStartDate_From, dailyLogStartDate_To);

			// This method is used to click on start date column header
			DailyLog.startDateColumnHeader_Click();

			// This method is used to click on start date column header again
			DailyLog.startDateColumnHeader_Click();

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
