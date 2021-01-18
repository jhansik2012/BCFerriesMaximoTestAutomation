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

public class OWL_399 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_399(String browser, Method method) throws Throwable {

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
			String dailyLogWeather = tstData.get("dl_Weather");
			
			String dailyLogIDFilter_ID_1 = tstData.get("dl_ID1");
			String dailyLogIDFilter_ID_2 = tstData.get("dl_ID2");
			String dailyLogIDFilter_ID_3 = tstData.get("dl_ID3");
			String dailyLogIDFilter_ID_4 = tstData.get("dl_ID4");
			String dailyLogIDFilter_ID_5 = tstData.get("dl_ID5");
			String dailyLogIDFilter_ID_6 = tstData.get("dl_ID6");
			String dailyLogIDFilter_Position_1 = tstData.get("dl_Position1");
			String dailyLogIDFilter_Position_2 = tstData.get("dl_Position2");
			String dailyLogIDFilter_Position_3 = tstData.get("dl_Position3");
			String dailyLogIDFilter_Position_4 = tstData.get("dl_Position4");
			String dailyLogIDFilter_Position_5 = tstData.get("dl_Position5");
			String dailyLogIDFilter_Position_6 = tstData.get("dl_Position6");			

			String dailyLogEntrySummary1_s = tstData.get("dl_LogEntrySummary1");
			String dailyLogEntrySummary2_s = tstData.get("dl_LogEntrySummary2");

			String dailyLogSailingData_Sailing_s = tstData.get("dl_SailingData_Sailing");
			String dailyLogSailingData_PassengerCount_s = tstData.get("dl_SailingData_PassengerCount");
			String dailyLogSailingData_PRA_s = tstData.get("dl_SailingData_PRA");
			String dailyLogSailingData_Type = tstData.get("dl_SailingData_Type");
			String dailyLogSailingData_LicenseType = tstData.get("dl_SailingData_LicenseType");
			
			String dailyLogOverTime_OverTimeCode = tstData.get("dl_OverTime_OverTimeCode");
			String dailyLogOverTime_OverTimeHours = tstData.get("dl_OverTime_OverTimeHours");
			String dailyLogOverTime_OverReason = tstData.get("dl_OverTime_OverReason");

			
			
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

			// This Method is used to select employee 1 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_1);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to select Employee 2 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_2);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to select Employee 3 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_3);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to select Employee 4 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_4);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to select Employee 5 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_5);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to select Employee 6 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_6);

			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();

			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition1_PositionFilter(dailyLogIDFilter_Position_1);

			// This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition2_PositionFilter(dailyLogIDFilter_Position_2);

			// This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition3_PositionFilter(dailyLogIDFilter_Position_3);

			// This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition4_PositionFilter(dailyLogIDFilter_Position_4);

			// This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition5_PositionFilter(dailyLogIDFilter_Position_5);

			// This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition6_PositionFilter(dailyLogIDFilter_Position_6);

			// This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This method is used to select OFA
			DailyLog.DailyLog_CrewStaffSelectOFA();

			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();	
			
			// This Method is used to Click and Enter new row details in Daily Log - Sailing Data
			DailyLog.DailyLog_SailingData_NewRowEnterData(dailyLogSailingData_Sailing_s,dailyLogSailingData_Type,dailyLogSailingData_PassengerCount_s, dailyLogSailingData_PRA_s,dailyLogSailingData_LicenseType);
			
			//DailyLog.SaveDailyLog_CLick();
			
			//This method is used to check start_up check
//			DailyLog.DailyLog_ProceduresChecks_Select_start_upCheck();
			
			// This Method is used to Enter Over Time Data in Daily Log			
			DailyLog.DailyLog_Enter_OverTime(dailyLogOverTime_OverTimeCode,dailyLogOverTime_OverTimeHours,dailyLogOverTime_OverReason);
			
			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();
			
			//This method is used to check shut-down check
//			DailyLog.DailyLog_ProceduresChecks_Select_Shut_downCheck();
			
			// This Method is used to save Daily log
//		    DailyLog.SaveDailyLog_CLick();
		    
            //This method is used to check if Sign_off Date text box is Read only     
//		    DailyLog.verifySign_off_DateTextBoxIsReadOnly("Sign_off Date");
		    
		    //This method is used to check if Sign_off by text box is Read only     
//		    DailyLog.verifySign_off_DateTextBoxIsReadOnly("Sign_off By");
			

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
