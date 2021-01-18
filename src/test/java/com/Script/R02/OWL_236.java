/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 22, 2020
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

public class OWL_236 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_236(String browser,Method method) throws Throwable {
		
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
			String drillLogSelectParticipantNameFilter_s = tstData.get("dl_SelectParticipantNameFilter");					
			String runReport_EmployeeDR_str = tstData.get("rReport_Employee");					
			String runReport_DateDiff_str = tstData.get("rReport_DateDiff");	
			String runReport_EmployeeEmail=  tstData.get("rReport_Email");
			String runReport_Schedule_Time=  tstData.get("runReport_ScheduleTime");
			

			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);
			
			// This Method is used to create new drill log
			DrillLog.NewDrillLog_CLick();

			// This Method is used to enter data into the drill log page
			DrillLog.EnterValuesforDrillLog(drillLogDescription_s, drillLogDepartment_s, drillLogLocation_s, 
					drillLogWatch_s, drillLogShift_s, drillLogDrillType_s, drillLogDrillDate_s,
					drillLogPOA_s, drillLogRoute_s);

			// This Method is used to save drill log
			DrillLog.SaveDrillLog_CLick();
						
			// This Method is used to select Participants for Drill Log
			DrillLog.drillLogAddParticipants_NameFilter(drillLogSelectParticipantNameFilter_s);
			
			
			//Change the status of the drill log to Completed
			DrillLog.CompleteDrillLog_CLick();			
			
			// This method is used to trigger Run Report Popup
			DrillLog.RunReport_Execute();
			// This method is used click on the Employee Drill Log Report Type
			DrillLog.RunReport_Click_EmployeeDrillLog();	
			// This method is used to enter the parameters and schedule for Employee Drill Log Report
			String daysFromLastDrill = DrillLog.RunReport_Enter_ParamAndSchedule(runReport_EmployeeDR_str);	
			// This method is used to Validate if 2 values match
//			System.out.println("*********runReport_DateDiff_str*****"+runReport_DateDiff_str);
//			System.out.println("*********daysFromLastDrill*****"+daysFromLastDrill);
//			assertValueEqual(runReport_DateDiff_str, daysFromLastDrill);
			
			// This method is used click on the Employee Drill Log Report Type
			DrillLog.RunReport_Click_EmployeeDrillLog();
			// This method is used to enter the parameters and schedule for Employee Drill Log Report and will send report to employee Email
		    DrillLog.RunReport_Enter_ParamAndSchedules(runReport_EmployeeDR_str,runReport_EmployeeEmail,runReport_Schedule_Time);		
			// This method is used to click on Cancel button in Reports and Schedules
		    DrillLog.RunReport_ClickCancel();
			
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