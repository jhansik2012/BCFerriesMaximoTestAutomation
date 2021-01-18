/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 24, 2020
 */

package com.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accelerators.ActionEngine;
import com.accelerators.CredentialManager;
import com.relevantcodes.extentreports.LogStatus;


public class Drills_Scheduler_BCF extends ActionEngine {	
	
	//x-path for creating new Drill Scheduler button
	public static By newDrillScheduler = By.xpath("//img[@id = \"toolactions_INSERT-tbb_image\"]");
	//x-path for saving Drill Schedule button
	public static By saveDrillScheduler = By.xpath("//img[@id = \"toolactions_SAVE-tbb_image\"]");
	//x-path for Clear Drill Schedule Changes button
	public static By clearDrillSchedulerChanges = By.xpath("//img[@id = \"toolactions_CLEAR-tbb_image\"]");
	//x-path for Drill Schedule Change Status button
	public static By changeStatusDrillScheduler = By.xpath("//img[@id = \"toolactions_STATUS-tbb_image\"]");
	//x-path for Drill Scheduler - List Tab
	public static By drillSchedulerListTab = By.xpath("//a[@id = \"m9fa3e414-tab_anchor\"]");
	//x-path for Drill Scheduler - Drill Schedule Tab
	public static By drillSchedulerDrillScheduleTab = By.xpath("//a[@id = \"mbf28cd64-tab_anchor\"]");
	//x-path for Drill Scheduler - Seasonal Dates Tab
	public static By drillSchedulerSeasonalDatesTab = By.xpath("//a[@id = \"m74dc8d73-tab_anchor\"]");
	//x-path for Drill Scheduler - Forecast Drills Tab
	public static By drillSchedulerForecastDrillsTab = By.xpath("//a[@id = \"m2a9c7844-tab_anchor\"]");
	//x-path for Drill Scheduler - Related Drill Logs Tab
	public static By drillSchedulerRelatedDrillLogsTab = By.xpath("//a[@id = \"m15ce98cd-tab_anchor\"]");
		
	//x-path for Drill Scheduler - Drill Schedule Field
	public static By newDrillSchedulerDrillSchedule = By.xpath("//input[@id = \"maa8ad01-tb\"]");
	//x-path for Drill Scheduler - Description Field
	public static By newDrillSchedulerDescription = By.xpath("//input[@id = \"maa8ad01-tb2\"]");
	//x-path for Drill Scheduler - Department Field
	public static By newDrillSchedulerDepartment = By.xpath("//input[@id = \"m557b9e5d-tb\"]");
	//x-path for Drill Scheduler - Location Field - Search
	public static By newDrillSchedulerLocation = By.xpath("//img[@id = \"m8131f89b-img\"]");
	//x-path for Drill Scheduler - Location Search - Search Field
	public static By newDrillSchedulerLocationSearch_SearchFilter = By.xpath("//input[@id = \"lookup_page1_tfrow_[C:0]_txt-tb\"]");
	//x-path for Drill Scheduler - Location Search - Search Button
	public static By newDrillSchedulerLocationSearch_SearchBtn = By.xpath("//img[@id = \"lookup_page1-ti2_img\"]");
	//x-path for Drill Scheduler - Location Search - Clear Search Button
	public static By newDrillSchedulerLocationSearch_ClearBtn = By.xpath("//img[@id = \"lookup_page1-ti3_img\"]");
	//x-path for Drill Scheduler - Location Search - Selected Value
	public static By newDrillSchedulerLocationSearch_SelectedValue = By.xpath("//span[@id = \"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");
	//x-path for Drill Scheduler - Watch Field
	public static By newDrillSchedulerWatch = By.xpath("//input[@id = \"mcc72cfe7-tb\"]");
	//x-path for Drill Scheduler - Frequency Field
	public static By newDrillSchedulerFrequency = By.xpath("//input[@id = \"m4b4a1d0e-tb\"]");
	//x-path for Drill Scheduler - Frequency Days Field
	public static By newDrillSchedulerFrequencyDays = By.xpath("//input[@id = \"m3b20e981-tb\"]");
	//x-path for Drill Scheduler - Alert Lead Field
	public static By newDrillSchedulerAlertlead = By.xpath("//input[@id = \"md2e7e71a-tb\"]");
	//x-path for Drill Scheduler - Use Last Drill Log's Start Date to Calculate Next Due Date?
    public static By useLastDrillLogStartDateToCalculateNextDueDate= By.xpath("//*[@id=\"m580ba304-cb_img\"]");
	
	
	
	
	//x-path for Drill Scheduler - List Tab - Filter Search Button
	public static By dSListTab_FilterSearchBtn = By.xpath("//img[@id = \"m6a7dfd2f-ti2_img\"]");
	//x-path for Drill Scheduler - List Tab - Clear Filter Button
	public static By dSListTab_ClearFilterBtn = By.xpath("//img[@id = \"m6a7dfd2f-ti3_img\"]");
	//x-path for Drill Scheduler - List Tab
	public static By dSListTab = By.xpath("//*[@id=\"m9fa3e414-tab_anchor\"]");//("//input[@id = \"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");
	//x-path for Drill Scheduler - List Tab - Drill Schedule Field
    public static By dSListTab_DrillSchedule = By.xpath("//*[@id=\"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");//("//input[@id = \"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");
		
	
	//x-path for Drill Scheduler - List Tab - Filtered Record
	public static By dSListTab_FilteredRecord = By.xpath("//span[@id = \"m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]\"]");
	
	
	//x-path for Drill Scheduler - Change Status - New Status Field
	public static By dSChangeStatus_NewStatus = By.xpath("//input[@id = \"mc927149a-tb\"]");
	//x-path for Drill Scheduler - Change Status - New Status - Active
	public static By dSNewStatus_Active = By.xpath("//span[@id = \"menu0_ACTIVE_OPTION_a_tnode\"]");
	//x-path for Drill Scheduler - Change Status - OK Button
	public static By dSChangeStatus_OkBtn = By.xpath("//button[@id = \"m60bd6d91-pb\"]");
	
	
	//x-path for Existing Drill Scheduler - Select Action Dropdown
	public static By existingDrillSchedule_SelectAction = By.xpath("//img[@id = \"toolbar2_tbs_1_tbcb_0_action-img\"]");
	//x-path for Drill Scheduler - Select Action Dropdown - Generate Drill Log
	public static By dSSelectAction_GenerateDrillLog = By.xpath("//*[@id=\"m74daaf83_ns_menu_GENERATEWO_OPTION_a_tnode\"]");//("//span[@id = \"menu0_GENERATEWO_OPTION_a_tnode\"]");
	//x-path for Drill Scheduler - Generate Drill Log - Use Frequency Criteria Checkbox
	public static By dSGenerateDrillLog_UseFrequencyCriteria_Chkbox = By.xpath("//img[@id = \"mc3c4c116-cb_img\"]");
	//x-path for Drill Scheduler - Generate Drill Log - OK Button
	public static By dSGenerateDrillLog_OkBtn = By.xpath("//button[@id = \"m575c541c-pb\"]");	
	//x-path for Drill Scheduler - Generate Drill Log - System Message
	public static By dSGenerateDrillLog_SystemMsg = By.xpath("//label[@id = \"mb_msg\"]");
	//x-path for Drill Scheduler - Generate Drill Log - System Message - OK Button
	public static By dSGenerateDrillLog_SystemMsg_OkBtn = By.xpath("//button[@id = \"m88dbf6ce-pb\"]");
	
	//x-path for Drill Scheduler - Related Drill Logs Tab - Latest Created Drill log ID
	public static By dS_RelatedDrillLog_DrillLogID = By.xpath("//input[@id = \"m9dc9520d_tdrow_[C:0]_txt-tb[R:0]\"]");
	
	
	
	
	/**
	 * @Description: Drill Scheduler Initialize
	 * @throws Throwable
	 */
	public void drillSchedulerInit(String userNameString, String passwordString) throws Throwable {
		try {

			// Create alias for the Maximo Login Page Method
			MaximoLoginPage Login = new MaximoLoginPage();
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			// This Method is Used to Launch the Maximo Application
			Login.maximoLaunchURL(browser);
			// This Method is used to verify the Maximo Login Page
			Login.verifyMaximoLoginPage("Welcome to Maximo");
			// This Method is used to Login to Maximo
			Login.maximoLogin(userNameString, passwordString);
			//SuccessReportWithScreenshot("Maximo Login Successfull");
			// This Method is used to navigate to "Drill Scheduler" in the Applications
			StartCenter.navigateToDrillScheduler();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
		
	/**
	 * @Description: Click on New Drill Scheduler button
	 * @throws Throwable
	 */
	public void NewDrillScheduler_Click() throws Throwable {
		try {

//			isElementPresent(newDrillLog, "New Drill Log");
			click(newDrillScheduler, "New Drill Scheduler");
			implicityWait(2);
			//explicityWait_ElementVisible(newDrillSchedulerDrillSchedule);
			SuccessReportWithScreenshot("New Drill Scheduler record opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Enter values for a Drill Scheduler
	 * @throws Throwable
	 */
	public void EnterValuesforDrillScheduler(String ds_Description, 
			String ds_Department, String ds_Location) throws Throwable {
		
//		, String ds_Frequency, String ds_AlertLead, String ds_FrequencyUnits, String ds_Watch
		
		try {
			
			implicityWait(4);
//			click(newDrillSchedulerDrillSchedule, "Click Drill Scheduler");
//			implicityWait(2);
//			clear(newDrillSchedulerDrillSchedule);	
//			type(newDrillSchedulerDrillSchedule, ds_DrillScheduler, "Drill Scheduler");
//			System.out.println("*****ds_DrillScheduler****"+ds_DrillScheduler);
			
			click(newDrillSchedulerDescription, "Click Description");
			implicityWait(2);
			clear(newDrillSchedulerDescription);	
			type(newDrillSchedulerDescription, ds_Description, "Description");
			
			click(newDrillSchedulerDepartment, "Click Department");
			implicityWait(2);
			clear(newDrillSchedulerDepartment);	
			type(newDrillSchedulerDepartment, ds_Department, "Department");
			
			click(newDrillSchedulerLocation, "Click Location Search");
			implicityWait(2);
			clear(newDrillSchedulerLocationSearch_SearchFilter);	
			type(newDrillSchedulerLocationSearch_SearchFilter, ds_Location, "Location");
			click(newDrillSchedulerLocationSearch_SearchBtn, "Click Location Search");
			implicityWait(2);
			click(newDrillSchedulerLocationSearch_SelectedValue, "Select Location");
			implicityWait(2);
//			click(newDrillSchedulerWatch, "Click Watch");
//			clear(newDrillSchedulerWatch);	
//			type(newDrillSchedulerWatch, ds_Watch, "Watch");
			
//			click(newDrillSchedulerFrequency, "Click Frequency");
//			clear(newDrillSchedulerFrequency);	
//			type(newDrillSchedulerFrequency, ds_Frequency, "Frequency");
//			
//			click(newDrillSchedulerAlertlead, "Click Alert Lead");
//			clear(newDrillSchedulerAlertlead);	
//			type(newDrillSchedulerAlertlead, ds_AlertLead, "Alert Lead");
//			
//			click(newDrillSchedulerFrequencyDays, "Click Frequency Units");
//			clear(newDrillSchedulerFrequencyDays);	
//			type(newDrillSchedulerFrequencyDays, ds_FrequencyUnits, "Frequency Units");
			
			SuccessReportWithScreenshot("Successfully Entered data for New Drill Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	/**
	 * @Description: Enter values for a Drill Scheduler
	 * @throws Throwable
	 */
	public void EnterValuesforDrillSchedule(String ds_Frequency, String ds_FrequencyUnits, 
			String ds_AlertLead) throws Throwable {
		
//		, String ds_Frequency, String ds_AlertLead, String ds_FrequencyUnits, String ds_Watch
		
		try {
			
		click(newDrillSchedulerFrequency, "Click Frequency");
		implicityWait(2);
		clear(newDrillSchedulerFrequency);	
		type(newDrillSchedulerFrequency, ds_Frequency, "Frequency");

		click(newDrillSchedulerFrequencyDays, "Click Frequency Units");
		implicityWait(2);
		clear(newDrillSchedulerFrequencyDays);	
		type(newDrillSchedulerFrequencyDays, ds_FrequencyUnits, "Frequency Units");
		
		click(newDrillSchedulerAlertlead, "Click Alert Lead");
		implicityWait(2);
		clear(newDrillSchedulerAlertlead);	
		type(newDrillSchedulerAlertlead, ds_AlertLead, "Alert Lead");
		click(useLastDrillLogStartDateToCalculateNextDueDate,"Uncheck the 'Use Last Drill Log's Start Date to Calculate Next Due Date'");
		implicityWait(2);
	    SuccessReportWithScreenshot("Successfully Entered data for  Drill Schedule");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Click on Save Drill Scheduler button
	 * @throws Throwable
	 */
	public void SaveDrillScheduler_Click() throws Throwable {
		try {

			click(saveDrillScheduler, "Save Drill Scheduler");
			implicityWait(15);
			SuccessReportWithScreenshot("Successfully Saved a Drill Scheduler");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Filter and Open an existing Drill Schedule
	 * @throws Throwable
	 */
	public void OpenExistingDrillSchedule_FilterDrillSchedule(String ds_DrillSchedule) throws Throwable {
		try {

			click(dSListTab, "List Tab");
			implicityWait(2);
			clear(dSListTab_DrillSchedule);	
			type(dSListTab_DrillSchedule, ds_DrillSchedule, "Drill Schedule");
			
			click(dSListTab_FilterSearchBtn, "Search Drill Schedules");
			implicityWait(3);//explicityWait(dSListTab_DrillSchedule);

			click(dSListTab_FilteredRecord, "Filtered Drill Schedule");
			implicityWait(6);
			//explicityWait(newDrillSchedulerDrillSchedule);			
			SuccessReportWithScreenshot("Successfully Opened Drill Schedule");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Change Status of Drill Schedule to Active
	 * @throws Throwable
	 */
	public void DrillScheduler_ChangeStatusActive() throws Throwable {
		try {

			click(changeStatusDrillScheduler, "Change Status");	
			implicityWait(2);	
//			explicityWait_ElementVisible(dSChangeStatus_NewStatus);
			click(dSChangeStatus_NewStatus, "Select Status");
			implicityWait(1);
			click(dSNewStatus_Active, "Active");
			implicityWait(1);
			click(dSChangeStatus_OkBtn, "Ok");
			implicityWait(1);
//			explicityWait_ElementVisible(newDrillSchedulerDrillSchedule);	

			SuccessReportWithScreenshot("Successfully Changed Status of Drill Schedule");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/* @Description: Change Status of Drill Schedule to Active
	 * @throws Throwable
	 */
	public void DrillScheduler_GenerateAndValidateDrillLogs() throws Throwable {
		try {

//			click(existingDrillSchedule_SelectAction, "Select Action");
//			implicityWait(1);
			click(dSSelectAction_GenerateDrillLog, "Generate Drill Log");
			implicityWait(2);
			explicityWait_ElementVisible(dSGenerateDrillLog_UseFrequencyCriteria_Chkbox);
			click(dSGenerateDrillLog_UseFrequencyCriteria_Chkbox, "Use Frequency Criteria");
			implicityWait(2);
			click(dSGenerateDrillLog_OkBtn, "Ok");
			implicityWait(2);
//			explicityWait_ElementVisible(dSGenerateDrillLog_SystemMsg);
			SuccessReportWithScreenshot("Successfully Generated Drill Logs");
			String sDSystemMessage_Str = getXPathValue(dSGenerateDrillLog_SystemMsg);
			
			System.out.println("sDSystemMessage_Str: " + sDSystemMessage_Str);
			
			click(dSGenerateDrillLog_SystemMsg_OkBtn, "Ok");	
			implicityWait(2);		
//			explicityWait(newDrillSchedulerDrillSchedule);	
			
			click(drillSchedulerRelatedDrillLogsTab, "Related Drill Logs Tab");
			implicityWait(2);

			SuccessReportWithScreenshot("Successfully Validated Created Drill Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Read and Return the Generated Drill Log ID
	 * @throws Throwable
	 */
	public String ReadAndReturnGeneratedDrillLogID() throws Throwable {
		String generatedDrillLog_Str = "";
		try {

			generatedDrillLog_Str = getXPathAttribute(dS_RelatedDrillLog_DrillLogID, "value");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generatedDrillLog_Str;
	}
	
		// Get the Text of a specific field using the xPath
				public String getXPathValueOfDrillSchedule() {
					String selected = "";
					try {
						//ExplicitWaitOnElementToBeClickable(newDrillSchedulerDrillSchedule);
						Thread.sleep(7000);
						selected = driver.findElement(newDrillSchedulerDrillSchedule).getAttribute("value");
					} catch (Exception e) {
					}
					return selected;
				}
				
	
	
	
}
