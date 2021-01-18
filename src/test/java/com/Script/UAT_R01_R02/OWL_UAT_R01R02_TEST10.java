/**
 * @Author Satish Kumar Adapa
 * @Date Jan 31, 2020
 */

package com.Script.UAT_R01_R02;

import java.lang.reflect.Method;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.Drill_Log_BCF;
import com.Pages.Drills_Scheduler_BCF;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_UAT_R01R02_TEST10 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_UAT_R01R02_TEST10(String browser, Method method) throws Throwable {

		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));

			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String filterSearch_DrillType_str = tstData.get("filterSearchDrillType");

			// Create object for the Maximo Drill Scheduler Page
			Drills_Scheduler_BCF drills_scheduler = new Drills_Scheduler_BCF();
			// Create object for the Maximo Start Center Page
			MaximoStartCenter StartCenter = new MaximoStartCenter();

			// Below line is used for Maximo app login and navigation to Drill Scheduler
			// module
			drills_scheduler.drillSchedulerInit(userNameString, passwordString);

			// This method is used to search for Drill Type in the List page and click on
			// searched record
			drills_scheduler.OpenExistingDrillSchedule_FilterDrillSchedule(filterSearch_DrillType_str);

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
