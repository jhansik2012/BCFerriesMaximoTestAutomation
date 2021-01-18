/**
 * @Author Satish Kumar A
 */

package com.Script.UAT_R01_R02;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.Drills_Scheduler_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_QC_R01R02_TEST01 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })

	public void OWL_QC_R01R02_TEST01(String browser, Method method) throws Throwable {

		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));

			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");
			String drillSchedulerDescription_s = tstData.get("ds_Description");
			String drillSchedulerDepartment_s = tstData.get("ds_Department");
			String drillSchedulerLocation_s = tstData.get("ds_Location");
			String drillSchedulerFrequency_s = tstData.get("ds_Frequency");
			String drillSchedulerFrequencyUnits_s = tstData.get("ds_FrequencyUnits");
			String drillSchedulerAlertLead_s = tstData.get("ds_AlertLead");

//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
//			String currentDateWithTime = sdf.format(date);

			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// Create alias for the Maximo Drill Scheduler BCF Page Method
			Drills_Scheduler_BCF DrillScheduler = new Drills_Scheduler_BCF();

			// This method is for Initialization method for Drill Scheduler Module
			DrillScheduler.drillSchedulerInit(userNameString, passwordString);

			// This method is used to create new Drill Schedule
			DrillScheduler.NewDrillScheduler_Click();

			// This method is used enter data in new Drill Schedule
			DrillScheduler.EnterValuesforDrillScheduler(drillSchedulerDescription_s,
					drillSchedulerDepartment_s, drillSchedulerLocation_s);

			// This method used to get value of Drill schedule
			String schedule = DrillScheduler.getXPathValueOfDrillSchedule();

			// This method is used to save Drill Schedule
			DrillScheduler.SaveDrillScheduler_Click();

			// This method is used to click on existing drill schedule
			DrillScheduler.OpenExistingDrillSchedule_FilterDrillSchedule(schedule);

			// This method is used to enter frequency,frequency units and Alert Lead
			DrillScheduler.EnterValuesforDrillSchedule(drillSchedulerFrequency_s, drillSchedulerFrequencyUnits_s,
					drillSchedulerAlertLead_s);

			// This method is used to save Drill Schedule
			DrillScheduler.SaveDrillScheduler_Click();

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