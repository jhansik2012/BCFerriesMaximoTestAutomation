/**
 * @Author Satish Kumar A
 * @Date Jan 06, 2020
 */

package com.Script.UAT_R01_R02;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.Drill_Log_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_UAT_R01R02_TEST05 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_UAT_R01R02_TEST05(String browser, Method method) throws Throwable {

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
			String dailyLogNameFilter_s = tstData.get("dl_NameFilter");

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

			// Read the Daily Log- Shift Log ID and save it to a variable
			String ShiftLogID_s = DailyLog.DailyLog_ReadReturnShiftLogID();

			// This Method is used to navigate to Daily log - List Tab
			DailyLog.DailyLog_NavigateToListTab();

			// This Method is used to Filter the data by Shift Log ID in List Tab of Daily
			// Log
			DailyLog.DailyLogListTab_ShiftLogIDFilter(ShiftLogID_s);

			// This Method is used to Open the filtered record in List Tab of Daily Log
			DailyLog.DailyLogListTab_OpenSelectedRecord();

			// This Method is used to All people to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_NameFilter(dailyLogNameFilter_s);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();

			// This method is used to click on Generate button
			DailyLog.Template_Generate();

			// Read the Daily Log - Template ID and save it to a variable
			String GeneratedTemplateID_s = DailyLog.DailyLog_ReadReturnTemplateID();

			// This method is used to enter Description and save the template
			DailyLog.Template_Generate_Description_Enter(ShiftLogID_s);

			// This method is used to click on Edit button
			DailyLog.Template_Edit();

			// Search for saved template
			DailyLog.searchSavedTemplate(GeneratedTemplateID_s);

			// Click on view details Arrow button of saved template
			DailyLog.viewDetailsArrowBtn_Click();

			// Select first record OFA
			DailyLog.selectFirstRecordOFA_CheckBox();

			// Select first record OF Unselect
			DailyLog.selectFirstRecordOFA_CheckBox();

			// Select first record OF select
			DailyLog.selectFirstRecordOFA_CheckBox();

			// Click on Ok
			DailyLog.okBtn_Click();

			// This method is used to click on Apply button
			DailyLog.Template_Apply();

			// This method is used to search for saved template in Apply Template Window
			DailyLog.searchSavedTemplateInApplyTemWindow(GeneratedTemplateID_s);

			// Click on Saved template
			DailyLog.selectRecordsAndClickOk();

			// //Verify Pop-up Message
			// DailyLog.verifyConfirmationMsg();

			// This Method is used to Log Off from
			StartCenter.logOffMaximo();

			/**********************
			 * Script Ends here
			 *******************************************/

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
