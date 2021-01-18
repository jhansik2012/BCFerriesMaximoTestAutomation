/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 10, 2020
 */

package com.Script.R02;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.Drill_Log_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_243 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_243(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String filterSearch_Status_str = tstData.get("dl_StatusFilter");			
			String queryCondition_str = tstData.get("dl_QueryCondition");				
			//String queryName_str = tstData.get("dl_QueryName");			
			String queryDescription_str = tstData.get("dl_QueryDescription");

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
			String queryName_str = sdf.format(date);
			
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);
			
			// This method is used to search for Status in the List page
			DrillLog.DrillLog_ListPage_Status_Filter(filterSearch_Status_str);
			// This method is used to get the count of filtered records
			DrillLog.DrillLog_ListPage_RecordCount();
			// This method is used to clear the filters
			DrillLog.DrillLog_ListPage_ClearFilters();
			
			// This method is used to clear the filters
			DrillLog.DrillLog_ListPage_ClearFilters();
			// This method is used to sort the drill log list in descending order of Drill Date
			DrillLog.DrillLog_ListPage_DrillDate_SortDescending();
			// This method is used to sort the drill log list in descending order of Target Finish Date
			DrillLog.DrillLog_ListPage_TargetFinishDate_SortDescending();
			// This method is used to filter the Target Finish Date field in the List page
			DrillLog.DrillLog_ListPage_TargetFinishDate_Filter(queryCondition_str);
			// This method is used to save the query in the List page
			DrillLog.drillLogSaveQuery(queryName_str, queryDescription_str);
			
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