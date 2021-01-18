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

public class OWL_235 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_235(String browser,Method method) throws Throwable {
		
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");			
			String drillLogLocationFilter1 = tstData.get("dl_LocationFilter1");
			String drillLogLocationFilter2 = tstData.get("dl_LocationFilter2");
			String drillLogLocationFilter3 = tstData.get("dl_LocationFilter3");
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Log BCF Page Method
			Drill_Log_BCF DrillLog = new Drill_Log_BCF();
			
			// This method is for Initialization method for Drill Log Module
			DrillLog.drillLogInit(userNameString, passwordString);
						
			// This Method is used to Search for Drill Log List with Location
			DrillLog.DrillLog_ListPage_Location_Filter(drillLogLocationFilter1);
			// This Method is used to Get the count of records after the search
			DrillLog.DrillLog_ListPage_RecordCount();
			// This Method is used to Search for Drill Log List with Location
			DrillLog.DrillLog_ListPage_Location_Filter(drillLogLocationFilter2);
			// This Method is used to Get the count of records after the search
			DrillLog.DrillLog_ListPage_RecordCount();
			// This Method is used to Search for Drill Log List with Location
			DrillLog.DrillLog_ListPage_Location_Filter(drillLogLocationFilter3);
			// This Method is used to Get the count of records after the search
			DrillLog.DrillLog_ListPage_RecordCount();
			// This Method is used to clear the filters in List Page
			DrillLog.DrillLog_ListPage_ClearFilters();
			// This Method is used to reload the records from the database
			DrillLog.ReloadDrillLog_CLick();
			// This Method is used to sort the searched list in ascending order of Location
			DrillLog.DrillLog_ListPage_Location_SortAscending();
			
			implicityWait(10);
			
			// This Method is used to sort the searched list in descending order of Location
			DrillLog.DrillLog_ListPage_Location_SortAscDescending();					
						
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