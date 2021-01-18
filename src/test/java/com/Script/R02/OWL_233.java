/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 09, 2020
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

public class OWL_233 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_233(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");			
			String drillLogDrillDateFilter1 = tstData.get("dl_DrillDateFilter1");
			String drillLogDrillDateFilter2 = tstData.get("dl_DrillDateFilter2");
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);
						
			// This Method is used to Search for Drill Log List with Drill Date
			DrillLog.DrillLog_ListPage_DrillDate_Filter(drillLogDrillDateFilter1);
			// This Method is used to Get the count of records after the search
			DrillLog.DrillLog_ListPage_RecordCount();
			// This Method is used to Search for Drill Log List with Drill Date
			DrillLog.DrillLog_ListPage_DrillDate_Filter(drillLogDrillDateFilter2);
			// This Method is used to Get the count of records after the search
			DrillLog.DrillLog_ListPage_RecordCount();
			// This Method is used to reload the records from the database
			DrillLog.ReloadDrillLog_CLick();
			// This Method is used to sort the searched list in ascending order of Drill Date
			DrillLog.DrillLog_ListPage_DrillDate_SortAscending();
			// This Method is used to sort the searched list in descending order of Drill Date
			DrillLog.DrillLog_ListPage_DrillDate_SortAscDescending();					
						
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