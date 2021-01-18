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

public class OWL_379 extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_379(String browser,Method method) throws Throwable {
				
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
//			
//			System.out.println("dailyLogSailingData_PassengerCount_s"+dailyLogSailingData_PassengerCount_s);
			
			// This Method is used to enter data into the Daily log page
			DailyLog.EnterValuesforDailyLog(dailyLogLocation_s, 
					dailyLogShift_s, dailyLogDepartment_s, dailyLogWatch_s, dailyLogRoute_s, 
					dailyLogShiftReference_s, dailyLogShiftStart_s, dailyLogShiftFinish_s, 
					dailyLogSupervisor_s, dailyLogPOA_s);
			
			DailyLog.ScrollToSailingDetails("SailingDetails");

			// This Method is used to Click and Enter new row details in Daily Log - Sailing Data
			DailyLog.DailyLog_SailingData_NewRowEnterData(dailyLogSailingData_Sailing_s,dailyLogSailingData_Type,dailyLogSailingData_PassengerCount_s, dailyLogSailingData_PRA_s,dailyLogSailingData_LicenseType);

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
