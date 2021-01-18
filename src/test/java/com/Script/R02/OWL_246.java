/**
 * @Author vijay 
 
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

public class OWL_246 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_246(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String runReport_FromDate_str = tstData.get("rReport_FromDate");				
			String runReport_ToDate_str = tstData.get("rReport_ToDate");		
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);
			
			// This method is used to trigger Run Report Popup
			DrillLog.RunReport_Execute();
			// This method is used click on the Drill Log List Report Type
			DrillLog.RunReport_Click_DrillLogList();
			// This method is used to enter the parameters and schedule for Drill Log List Report
			DrillLog.RunReport_Enter_DrillLogList_ParamAndSchedule(runReport_FromDate_str, runReport_ToDate_str);
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