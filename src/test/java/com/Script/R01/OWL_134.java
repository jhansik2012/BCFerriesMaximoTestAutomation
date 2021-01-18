
/**
 * @Author Satish Kumar A
 * @Date Feb 20, 2020
 */

package com.Script.R01;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_134 extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_134(String browser,Method method) throws Throwable {
				
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String dailyLogShiftLog_s = tstData.get("dl_ShiftLog");		
			String dailyLogDescription_s = tstData.get("dl_Description");			
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
			String dailyLogIDFilter_ID_1 = tstData.get("dl_ID1");
			String dailyLogIDFilter_ID_2= tstData.get("dl_ID2");
			String dailyLogIDFilter_ID_3 = tstData.get("dl_ID3");
			String dailyLogIDFilter_ID_4= tstData.get("dl_ID4");
			String dailyLogIDFilter_ID_5 = tstData.get("dl_ID5");
			String dailyLogIDFilter_ID_6 = tstData.get("dl_ID6");
			String dailyLogIDFilter_Position_1 = tstData.get("dl_Position1");
			String dailyLogIDFilter_Position_2= tstData.get("dl_Position2");
			String dailyLogIDFilter_Position_3 = tstData.get("dl_Position3");
			String dailyLogIDFilter_Position_4= tstData.get("dl_Position4");
			String dailyLogIDFilter_Position_5 = tstData.get("dl_Position5");
			String dailyLogIDFilter_Position_6 = tstData.get("dl_Position6");
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
			String currentDateWithTime = sdf.format(date);
			
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
			DailyLog.EnterValuesforDailyLog(dailyLogLocation_s, 
					dailyLogShift_s, dailyLogDepartment_s, dailyLogWatch_s, dailyLogRoute_s, 
					dailyLogShiftReference_s, dailyLogShiftStart_s, dailyLogShiftFinish_s, 
					dailyLogSupervisor_s, dailyLogPOA_s);
			
			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();
			
			// Read the Daily Log- Shift Log ID and save it to a variable
			String ShiftLogID_s = DailyLog.DailyLog_ReadReturnShiftLogID();
			
			// This Method is used to navigate to Daily log - List Tab
			DailyLog.DailyLog_NavigateToListTab();
						
			// This Method is used to Filter the data by Shift Log ID in List Tab of Daily Log
			DailyLog.DailyLogListTab_ShiftLogIDFilter(ShiftLogID_s);
			
			// This Method is used to Open the filtered record in List Tab of Daily Log
			DailyLog.DailyLogListTab_OpenSelectedRecord();
			
			// This Method is used to select employee 1  to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_1);
	
			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section 
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();	
			
			// This Method is used to select Employee 2 to Crew/Staff section of Daily Log
			DailyLog.DailyLog_CrewStaffSelectPeople_Employee_IDFilter(dailyLogIDFilter_ID_2);
				
			// This Method is used to Select "All" People in Daily Log - Crew/Staff Section 
			// using Select All Check-box
			DailyLog.DailyLog_CrewStaffSelectPeople_SelectAll();			
			
			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition1_PositionFilter(dailyLogIDFilter_Position_1);
			
			//This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();
			
			// This Method is used to click on position search
			DailyLog.DailyLog_CrewStaffClickPosition2_PositionFilter(dailyLogIDFilter_Position_2);
						
			//This method is used to select position
			DailyLog.DailyLog_CrewStaffClickOnPositionAFterFiltered();

			// This Method is used to save Daily log
			DailyLog.SaveDailyLog_CLick();
			
			//***UI Changed,So Below steps will fail
			// This method is used to click on Generate button
		     DailyLog.Template_Generate();
		     
			//This method is used to enter Description and save the template
			DailyLog.Template_Generate_Description_Enter(currentDateWithTime);
			
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
