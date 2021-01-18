/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 10, 2020
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

public class OWL_229 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_229(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String filterSearch_Description_str = tstData.get("filterSearch_Description");			
			String filterSearch_DrillType_str = tstData.get("filterSearch_DrillType");			
			String filterSearch_Department_str = tstData.get("filterSearch_Department");			
			String advSearch_Drill_str = tstData.get("advSearch_Drill");			
			String advSearch_Status_str = tstData.get("advSearch_Status");	
						
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);			
			// This method is used to search for Description in the List page
			DrillLog.DrillLog_ListPage_Description_Filter(filterSearch_Description_str);
//			implicityWait(100);
			// This method is used to get the count of filtered records
			DrillLog.DrillLog_ListPage_RecordCount();
			// This method is used to clear the filters
			DrillLog.DrillLog_ListPage_ClearFilters();
			
			// This method is used to search for Drill Type in the List page
			DrillLog.DrillLog_ListPage_DrillType_Filter(filterSearch_DrillType_str);
//			implicityWait(20);
			// This method is used to get the count of filtered records
			DrillLog.DrillLog_ListPage_RecordCount();
			// This method is used to clear the filters
			DrillLog.DrillLog_ListPage_ClearFilters();

			// This method is used to search for Department in the List page
			DrillLog.DrillLog_ListPage_Department_Filter(filterSearch_Department_str);
//			implicityWait(20);
			// This method is used to get the count of filtered records
			DrillLog.DrillLog_ListPage_RecordCount();
			// This method is used to clear the filters
			DrillLog.DrillLog_ListPage_ClearFilters();
			
//			// This method is used to advanced search for Drill Type in the List page
//			DrillLog.DrillLog_ListPage_AdvancedSearch_DrillType(advSearch_Drill_str);
//			// This method is used to get the count of filtered records
//			DrillLog.DrillLog_ListPage_RecordCount();
//
//			// This method is used to advanced search for Status in the List page
//			DrillLog.DrillLog_ListPage_AdvancedSearch_Status(advSearch_Status_str);
//			// This method is used to get the count of filtered records
//			DrillLog.DrillLog_ListPage_RecordCount();
			
			
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