/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 29, 2020
 */

package com.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.events.ImplicitTuple;

import com.accelerators.ActionEngine;
import com.accelerators.CredentialManager;
import com.relevantcodes.extentreports.LogStatus;

public class DailyLog_BCF extends ActionEngine {
	
	//x-path for creating new daily Log button
	public static By newDailyLog = By.xpath("//img[@id = \"toolactions_INSERT-tbb_image\"]");
	//x-path for saving new daily log button
	public static By saveDailyLog = By.xpath("//img[@id = \"toolactions_SAVE-tbb_image\"]");
	//x-path for changing status of daily log button
	public static By changeStatusDailyLog = By.xpath("//img[@id = \"toolactions_STATUS-tbb_image\"]");
		//x-path for Change Status - New Status Field
		public static By changeStatus_NewStatus = By.xpath("//input[@id = \"m25ca600f-tb\"]");
		//x-path for Change Status - Active Status
		public static By changeStatus_StatusActive = By.xpath("//span[@id = \"menu0_ACTIVE_OPTION_a_tnode\"]");
		//x-path for Change Status - Complete Status
		public static By changeStatus_StatusComplete = By.xpath("//span[@id = \"menu0_COMPLETE_OPTION_a_tnode\"]");
		//x-path for Change Status - Draft Status
		public static By changeStatus_StatusDraft = By.xpath("//span[@id = \"menu0_DRAFT_OPTION_a_tnode\"]");
		//x-path for Change Status - Ok Button
		public static By changeStatus_OkBtn = By.xpath("//button[@id = \"m6a3cf9ef-pb\"]");
	
	//x-path for Daily Log - List Tab
	public static By dailyLog_ListTab = By.xpath("//a[@id = \"m9fa3e414-tab_anchor\"]");
		//x-path for Daily Log - List Tab - Filter Table Button
		public static By dailyLog_ListTab_FilterTableBtn = By.xpath("//img[@id = \"m6a7dfd2f-ti2_img\"]");
		//x-path for Daily Log - List Tab - Clear Table Button
		public static By dailyLog_ListTab_ClearTableBtn = By.xpath("//img[@id = \"m6a7dfd2f-ti3_img\"]");
		//x-path for Daily Log - List Tab - Reload Table Button
		public static By dailyLog_ListTab_ReloadTableBtn = By.xpath("//img[@id = \"m6a7dfd2f-img5\"]");
		//x-path for Dsaily Log - List Tab - Log Field
		public static By dailyLog_ListTab_Log = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");
		//x-path for Daily Log - List Tab - Selected Record
		public static By dailyLog_ListTab_SelectedRecord = By.xpath("//span[@id = \"m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]\"]");
		//x-path for Drill Log - List Tab - Record Count
		public static By listTabRecordCount = By.xpath("//label[@id = \"m6a7dfd2f-lb3\"]");	
		//x-path for Description filter field
		public static By listTabFilterDescription = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:2]_txt-tb\"]");
		//x-path for advanced search
		public static By advancedSearchBtn = By.xpath("//*[@id=\"m68d8715f-tbb_text\"]");
		//x-path for  More Search Field
		public static By moreSearchFields = By.xpath("//*[@id=\"menuholdertd\"]");	
		//x-path for  Shift Log Field
        public static By shiftLogField = By.xpath("//*[@id=\"m8db33e5c-tb\"]");
         //x-path for From Start date
        public static By startDateFrom = By.xpath("//*[@id=\"m3bb18792-tb\"]");
        //x-path for To Start date
        public static By startDateTo = By.xpath("//*[@id=\"ma5d51231-tb\"]");
        //x-path for Find Button
        public static By findBtn = By.xpath("//*[@id=\"m4fd840b0-pb\"]");
        //x-path for Start Date Header
        public static By startDateColumnHeader = By.xpath("//*[@id=\"m6a7dfd2f_ttrow_[C:6]_ttitle-lb\"]");
        //x-path for Route Filter Field
        public static By listTabFilterRoute = By.xpath("//*[@id=\"m6a7dfd2f_tfrow_[C:7]_txt-tb\"]");//("//*[@id=\"m6a7dfd2f_tfrow_[C:5]_txt-tb\"]");
        
        
      
        //x-path for Daily Log - Readings Tab
    	public static By dailyLog_ReadingsTab = By.xpath("//*[@id=\"mfee8016-tab_anchor\"]");
    	//x-path for Readings Tab-First Record Description
    	public static By ReadingdTab_FirstRecord_Description = By.xpath("//*[@id=\"m2756d253_tdrow_[C:1]-c[R:0]\"]");
    	//x-path for New reading first text box
    	public static By ReadingdTab_FirstRecord_NewReadingTextbox = By.xpath("//*[@id=\"m2756d253_tdrow_[C:3]_txt-tb[R:0]\"]");
    	//x-path for New reading Date First text box
    	public static By ReadingdTab_FirstRecord_NewReadingDateTextbox = By.xpath("//*[@id=\"m2756d253_tdrow_[C:4]_txt-tb[R:0]\"]");
    	
    	
    	//x-path for Readings Tab-Second Record Description
    	public static By ReadingdTab_SecondRecord_Description = By.xpath("//*[@id=\"m2756d253_tdrow_[C:2]-c[R:1]\"]");
    	//x-path for New reading second text box
    	public static By ReadingdTab_SecondRecord_NewReadingTextbox = By.xpath("//*[@id=\"m2756d253_tdrow_[C:3]_txt-tb[R:1]\"]");
    	//x-path for New reading Date Second text box
    	public static By ReadingdTab_SecondRecord_NewReadingDateTextbox = By.xpath("//*[@id=\"m2756d253_tdrow_[C:4]_txt-tb[R:1]\"]");
    	
    	
    	//****Run Reports*****
        //Xpath for Run Reports
    	public static By RunReportsBtn = By.xpath("//*[@id=\"m74daaf83_ns_menu_RUNREPORTS_OPTION_a_tnode\"]");
    	//x-path for Report and Schedules - Cancel Report button
    	public static By reportAndSchedules_CancelReport = By.xpath("//*[@id=\"m8f8a09b4-pb\"]");
    	
    	//Xpath for Crew Competencies Report
    	public static By CrewCompetenciesReport = By.xpath("//*[@id=\"mb72ef8eb_tdrow_[C:0]_ttxt-lb[R:0]\"]");
    	//Xpath for Crew Competencies Report--Submit
    	public static By CrewCompetenciesReportSubmit = By.xpath("//*[@id=\"m3c1a069b-pb\"]");
    	//Xpath for Crew Competencies Report--Cancel
    	public static By CrewCompetenciesReportCancel = By.xpath("//*[@id=\"m70aaf3df-pb\"]");
    	
    	
    	
    	//Xpath for Daily Log Summary Report
    	public static By DailyLogSummaryReport = By.xpath("//*[@id=\"mb72ef8eb_tdrow_[C:0]_ttxt-lb[R:1]\"]");    	
    	//Xpath for Daily Log Summary Report Submit
    	public static By DailyLogSummaryReportSubmit = By.xpath("//*[@id=\"m74fa08ff-pb\"]");
    	//Xpath for Daily Log Summary Report Cancel
    	public static By DailyLogSummaryReportCancel = By.xpath("//*[@id=\"m1fd5f9d-pb\"]");
    	  	
    	
    	//Xpath for Muster List report
    	public static By MusterListReport = By.xpath("//*[@id=\"mb72ef8eb_tdrow_[C:0]_ttxt-lb[R:0]\"]");
    	//Xpath for Muster List report Submit
    	public static By MusterListReportSubmit = By.xpath("//*[@id=\"mfa750f1c-pb\"]");
    	//Xpath for Muster List report Cancel
    	public static By MusterListReportCancel = By.xpath("//*[@id=\"m981f399c-pb\"]");
    	
    	
    	//Xpath for Passengers Counts By Date 
    	public static By PassengersCountsByDate = By.xpath("//*[@id=\"mb72ef8eb_tdrow_[C:0]_ttxt-lb[R:1]\"]");	
    	//Xpath for Passengers Counts By Date Submit
    	public static By PassengersCountsByDateSubmit = By.xpath("//*[@id=\"mb2950178-pb\"]");
    	//Xpath for Passengers Counts By Date Cancel
    	public static By PassengersCountsByDateCancel = By.xpath("//*[@id=\"me94895de-pb\"]");
    	
    	//Xpath for Ramp Assignment Report 
    	public static By RampAssignmentReport = By.xpath("//*[@id=\"mb72ef8eb_tdrow_[C:0]_ttxt-lb[R:4]\"]");
    	//Xpath for Ramp Assignment Report Submit 
    	public static By RampAssignmentReportSubmit = By.xpath("//*[@id=\"mb8500861-pb\"]");
    	//Xpath for Ramp Assignment Report 
    	public static By RampAssignmentReportCancel = By.xpath("//*[@id=\"mc073805d-pb\"]");
    	
    	
    	
    	
 
    	
    	
    	
    
      
		
		
	
	//x-path for Daily Log - Daily Log Tab
	public static By dailyLog_DailyLogTab = By.xpath("//a[@id = \"mbf28cd64-tab_anchor\"]");
	//x-path for Daily Log - Muster List Tab
	public static By dailyLog_MusterListTab = By.xpath("//a[@id = \"mbeb11f78-tab_anchor\"]");
		//x-path for Daily Log - Muster List Tab - EDN Field
		public static By dailyLog_MusterListTab_EDN = By.xpath("//input[@id = \"meb3b7ada_tfrow_[C:1]_txt-tb\"]");
	
	//x-path for New Daily Log - Shift Log Field
	public static By newDailyLog_ShiftLog = By.xpath("//*[@id=\"mcb0e2a34-tb\"]");////input[@id = \"m9a601806-tb\"]
	//x-path for New Daily Log - Description Field
	public static By newDailyLog_Description = By.xpath("//*[@id=\"mcb0e2a34-tb2\"]");
	//x-path for New Daily Log - Location Search
	public static By newDailyLog_LocationSearchBtn = By.xpath("//*[@id=\"me02379f7-img\"]");////img[@id = \"m5bf44435-img\"]
		//x-path for New Daily Log - Location Search - Location Field
		public static By newDLLocationSearch_Location = By.xpath("//input[@id = \"lookup_page1_tfrow_[C:0]_txt-tb\"]");
		//x-path for New Daily Log - Location Search - Location Search
		public static By newDLLocationSearch_SearchBtn = By.xpath("//img[@id = \"lookup_page1-ti2_img\"]");
		//x-path for New Daily Log - Location Search - Select First Record
		public static By newDLLocationSearch_SelectFirstRecord = By.xpath("//span[@id = \"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");
	
	//x-path for New Daily Log - Shift Reference Field
	public static By newDailyLog_ShiftReference = By.xpath("//input[@id = \"m1e3bcc17-tb\"]");
	//x-path for New Daily Log - POA Search
	public static By newDailyLog_POASearchBtn = By.xpath("//img[@id = \"mbda62ac9-img\"]");
		//x-path for New Daily Log - POA Search - Value Field
		public static By newDailyLog_POAValue = By.xpath("//input[@id = \"lookup_page1_tfrow_[C:0]_txt-tb\"]");
		//x-path for New Daily Log - POA Search - POA Search
		public static By newDailyLog_SearchBtn = By.xpath("//img[@id = \"lookup_page1-ti2_img\"]");
		//x-path for New Daily Log - POA Search - Select First Record
		public static By newDailyLog_SelectFirstRecord = By.xpath("//span[@id = \"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");	
		
	//x-path for New Daily Log - Shift Start Field
	public static By newDailyLog_ShiftStart = By.xpath("//input[@id = \"m36949bc-tb\"]");
	//x-path for New Daily Log - Shift Finish Field
	public static By newDailyLog_ShiftFinish = By.xpath("//input[@id = \"m746e792a-tb\"]");
	//x-path for New Daily Log - Shift Field
	public static By newDailyLog_Shift = By.xpath("//input[@id = \"mbe75c2fd-tb\"]");
	//x-path for New Daily Log - Department Field
	public static By newDailyLog_Department = By.xpath("//input[@id = \"m369a3582-tb\"]");
	//x-path for New Daily Log - Supervisor Search
	public static By newDailyLog_SupervisorSearchBtn = By.xpath("//*[@id=\"ma17a5577-img\"]");////img[@id = \"mea0aec89-img\"]
		//x-path for New Daily Log - Supervisor Search - Person Field
		public static By newDLSupervisorSearch_Person = By.xpath("//input[@id = \"lookup_page1_tfrow_[C:1]_txt-tb\"]");
		//x-path for New Daily Log - Supervisor Search - Search Button
		public static By newDLSupervisorSearch_SearchBtn = By.xpath("//img[@id = \"lookup_page1-ti2_img\"]");
		//x-path for New Daily Log - Supervisor Search - Select First Record
		public static By newDLSupervisorSearch_SelectFirstRecord = By.xpath("//span[@id = \"lookup_page1_tdrow_[C:1]_ttxt-lb[R:0]\"]");
	
	//x-path for New Daily Log - Watch Field
	public static By newDailyLog_Watch = By.xpath("//input[@id = \"m5613ac7c-tb\"]");
	//x-path for New Daily Log - Route Field
	public static By newDailyLog_Route = By.xpath("//input[@id = \"mcd0c2d32-tb\"]");
	
	//x-path for New Daily Log - Weather Field
		public static By newDailyLog_Weather = By.xpath("//*[@id=\"m14b2a5e7-tb\"]");
	
	
	
	
	//x-path for New Daily Log - Log Entries - New Row
	public static By newDailyLog_LogEntries_NewRow = By.xpath("//button[@id = \"m676a031e_bg_button_addrow-pb\"]");
		//x-path for New Daily Log - Log Entries - New Row - Log Summary
		public static By newDailyLog_LogEntries_LogSummary = By.xpath("//input[@id = \"m342e87b2-tb\"]");
		//x-path for New Daily Log - Log Entries - New Row - Log Carry Over Check-box
		public static By newDailyLog_LogEntries_LocCarryOverCheckbox = By.xpath("//*[@id=\"mb432bc7e-cb_img\"]");//("//*[@id=\"m676a031e_tdrow_[C:6]_checkbox-cb[R:0]_img\"]");//("//img[@id = \"m676a031e_tdrow_[C:5]_checkbox-cb[R:0]_img\"]");
		//x-path for New Daily Log - Log Entries - New Row - Log Summary 2
		public static By newDailyLog_LogEntries_LogSummary2 = By.xpath("//input[@id = \"m676a031e_tdrow_[C:4]_txt-tb[R:1]\"]");
		
		//x-path for New Daily Log - Log Entries - Filter
		public static By newDailyLog_LogEntries_Filter = By.xpath("//*[@id=\"m676a031e-lb2\"]");
		
		//x-path for New Daily Log - Log Entries - Log summary Search Text box
		public static By newDailyLog_LogEntries_LogSummary_Search_TextBox = By.xpath("//*[@id=\"m676a031e_tfrow_[C:4]_txt-tb\"]");//("//*[@id=\"m676a031e_tfrow_[C:5]_txt-tb\"]");	
		
		
		
		

	//x-path for New Daily Log - Crew/Staff section - Select People
	public static By newDailyLog_CrewStaff_SelectPeopleBtn = By.xpath("//button[@id = \"m55c8acd_bg_button_plusgselectteammember-pb\"]");
		//x-path for New Daily Log - Crew/Staff section - Select People - Name Field
		public static By newDLCrewStaffSelectPeople_Name = By.xpath("//input[@id = \"m529e69d1_tfrow_[C:2]_txt-tb\"]");
		//x-path for New Daily Log - Crew/Staff section - Select People - Filter Button
		public static By newDLCrewStaffSelectPeople_FilterBtn = By.xpath("//img[@id = \"m529e69d1-ti2_img\"]");
		//x-path for New Daily Log - Crew/Staff section - Select People - Select All CheckBox
		public static By newDLCrewStaffSelectPeople_SelectAllCheckbox = By.xpath("//img[@id = \"m529e69d1_ttrow_[C:0]_ttselallrows-ti_img\"]");
		//x-path for New Daily Log - Crew/Staff section - Select People - Ok Button
		public static By newDLCrewStaffSelectPeople_OkBtn = By.xpath("//button[@id = \"me750f800-pb\"]");
		//x-path for New Daily Log - Crew/Staff section - Select People - Cancel Button
		public static By newDLCrewStaffSelectPeople_CancelBtn = By.xpath("//button[@id = \"m7e59a9ba-pb\"]");
		//x-path for New Daily Log - Crew/Staff section - Select People - Employee Field
		public static By newDLCrewStaffSelectPeople_EmployeeID= By.xpath("//*[@id=\"m529e69d1_tfrow_[C:1]_txt-tb\"]");	
		
		
		
	//x-path for New Daily Log - Crew/Staff section - Last Shift Crew
	public static By newDailyLog_CrewStaff_LastShiftCrew = By.xpath("//*[@id = \"m55c8acd_bg_button_plusgselectteamlastshift-pb\"]");
		//x-path for New Daily Log - Crew/Staff section - Last Shift Crew - Select All CheckBox
		public static By newDLCrewStaffLastShiftCrew_SelectAllCheckbox = By.xpath("//*[@id = \"m513a3988_ttrow_[C:0]_ttselallrows-ti_img\"]");
		//x-path for New Daily Log - Crew/Staff section - Last Shift Crew - Ok Button
		public static By newDLCrewStaffLastShiftCrew_OkBtn = By.xpath("//*[@id = \"m1a32eef5-pb\"]");
			
		
		
		
		//Xpath for Crew/staff position
		//x-path for New Daily Log - Crew/Staff section - Select position 1
		public static By newDailyLog_CrewStaff_SelectpostionBtn1 = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:3]_txt-img[R:0]\"]");
		//x-path for New Daily Log - Crew/Staff section - Select position 2
				public static By newDailyLog_CrewStaff_SelectpostionBtn2 = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:3]_txt-img[R:1]\"]");
				//x-path for New Daily Log - Crew/Staff section - Select position 3
				public static By newDailyLog_CrewStaff_SelectpostionBtn3 = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:3]_txt-img[R:2]\"]");
				//x-path for New Daily Log - Crew/Staff section - Select position 4
				public static By newDailyLog_CrewStaff_SelectpostionBtn4 = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:3]_txt-img[R:3]\"]");
				//x-path for New Daily Log - Crew/Staff section - Select position 5
				public static By newDailyLog_CrewStaff_SelectpostionBtn5 = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:3]_txt-img[R:4]\"]");
				//x-path for New Daily Log - Crew/Staff section - Select position 6
				public static By newDailyLog_CrewStaff_SelectpostionBtn6 = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:3]_txt-img[R:5]\"]");
				
		
		
		
		
		
			//x-path for New Daily Log - Crew/Staff section - Select Position - position Field
			public static By newDLCrewStaffSelectPosition_PositionFilter = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");
			//x-path for New Daily Log - Crew/Staff section - Select Position - Filter Button
			public static By newDLCrewStaffSelectPosition_FilterBtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");
			//x-path for New Daily Log - Crew/Staff section - Select Position - Select All CheckBox
			public static By newDLCrewStaffSelectPosition_FirstPosition = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");
		
		
			//Xpath for Crew/staff OFA
			public static By newDLCrewStaffCheckBoxOFA = By.xpath("//*[@id=\"m55c8acd_tdrow_[C:5]_checkbox-cb[R:3]_img\"]");
			
			

			
		
	  //x-path for New Daily Log - Sailing Data - New Row
	  public static By newDailyLog_SailingData_NewRow = By.xpath("//button[@id = \"m1447ee02_bg_button_addrow-pb\"]");
		//x-path for New Daily Log - Sailing Data - New Row - Sailing
		public static By newDailyLog_SailingData_Sailing = By.xpath("//input[@id = \"m1447ee02_tdrow_[C:0]_txt-tb[R:0]\"]");
		
		//x-path for New Daily Log - Sailing Data - New Row - Type
		public static By newDailyLog_SailingData_Type = By.xpath("//*[@id=\"m1447ee02_tdrow_[C:1]_txt-tb[R:0]\"]");
		
		//x-path for New Daily Log - Sailing Data - New Row - License Type
		public static By newDailyLog_SailingData_LicenseType = By.xpath("//*[@id=\"m1447ee02_tdrow_[C:4]_txt-tb[R:0]\"]");
				
		
		
		
		//x-path for New Daily Log - Sailing Data - New Row - Passenger Count
		public static By newDailyLog_SailingData_PassengerCount = By.xpath("//*[@id=\"m1447ee02_tdrow_[C:2]_txt-tb[R:0]\"]");//("//input[@id = \"m1447ee02_tdrow_[C:1]_txt-tb[R:0]\"]");
		//x-path for New Daily Log - Sailing Data - New Row - PRA
		public static By newDailyLog_SailingData_PRA = By.xpath("//*[@id=\"m1447ee02_tdrow_[C:3]_txt-tb[R:0]\"]");//("//input[@id = \"m1447ee02_tdrow_[C:2]_txt-tb[R:0]\"]");
			
	    //x-path for New Daily Log - Briefing Topics Field
	    public static By newDailyLog_BriefingTopics = By.xpath("//textarea[@id = \"m65c747f7-ta\"]");
	
	
	
	
	    //x-path for New Daily Log - OverTime_OverTimeCode_Search Button
		public static By newDailyLog_Overtime_OverTimeCode_Search = By.xpath("//*[@id=\"m8dcd3fb0-img\"]");	
		//x-path for New Daily Log - OverTime_OverTimeCode_Premium Pay Code
		public static By newDailyLog_Overtime_OverTimeCode_PremiumPayCode = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");
		
		//x-path for New Daily Log - OverTime_OverTimeCode_Premium Pay Code Search Button
		public static By newDailyLog_Overtime_OverTimeCode_PremiumPayCode_searchBtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");
		
		

		//x-path for New Daily Log - OverTime_OverTimeCode_Premium Pay Code_1st record
		public static By newDailyLog_Overtime_OverTimeCode_PremiumPayCode_FirstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");	
				
		
	//x-path for New Daily Log - OverTime_OverTimeHours
		public static By newDailyLog_Overtime_OverTimeHours = By.xpath("//*[@id=\"m6a279112-tb\"]");
	//x-path for New Daily Log - OverTime_OverTimeReason
		public static By newDailyLog_Overtime_OverTimeReason = By.xpath("//*[@id=\"mabe742a-tb\"]");	
		
	//*******************************Procedures Checks*********************************	
		//x-path for New Daily Log - ProceduresChecks_Start-up Check
		public static By newDailyLog_ProceduresChecks_StartUpCheck = By.xpath("//*[@id=\"m76946818-cb_img\"]");	
		
		//x-path for New Daily Log - ProceduresChecks_Shut-Down Check
		public static By newDailyLog_ProceduresChecks_ShutDownpCheck = By.xpath("//*[@id=\"m7fd0716c-cb_img\"]");	
	
	
	
	
	
	//x-path for Select Action Drop-down
	public static By dailyLog_SelectActionDrpdwn = By.xpath("//img[@id = \"toolbar2_tbs_1_tbcb_0_action-img\"]");
		//x-path for Select Action Drop-down - Modify/Delete Log Entry
		public static By dailyLogSA_ModDelLogEntry = By.xpath("//*[@id=\"m74daaf83_ns_menu_PLUSGMODLE_OPTION_a_tnode\"]");//("//span[@id = \"menu0_PLUSGMODLE_OPTION_a_tnode\"]");
		//x-path for Select Action Drop-down - Modify/Delete Log Entry - Delete Latest Record
		public static By dailyLogSA_ModDelLogEntry_DeleteLatestRecord = By.xpath("//img[@id = \"m28141c0b_tdrow_[C:9]_toggleimage-ti[R:0]_img\"]");
		//x-path for Select Action Drop-down - Modify/Delete Log Entry - Ok Button
		public static By dailyLogSA_ModDelLogEntry_OKButton = By.xpath("//button[@id = \"m6bcbfaaa-pb\"]");
		
		//x-path for Select Actions drop-down
		public static By listTabSelectActionsDropDown = By.xpath("//img[@id = \"toolbar2_tbs_1_tbcb_0_action-img\"]");	
		//x-path for Select Actions drop-down - Template
		public static By listTabSelectActionsDropDownTemplate = By.xpath("//*[@id=\"m74daaf83_ns_menu_AM40_HEADER_a_tnode\"]");//("//*[@id=\"menu0_AM40_HEADER_a_tnode\"]");
		//x-path for Select Actions drop-down - Generate
		public static By listTabSelectActionsDropDownGenerate = By.xpath("//*[@id=\"m74daaf83_ns_menu_AM40_HEADER_sub_PLUSGGENTP_OPTION_a_tnode\"]");//("//*[@id=\"menu0_AM40_HEADER_sub_PLUSGGENTP_OPTION_a_tnode\"]");
			//x-path for New Daily Log - Generated Template ID Field
			public static By generatedTemplateID = By.xpath("//*[@id=\"ma0221e14-tb\"]");
		//x-path for Select Actions drop-down - Edit
		public static By listTabSelectActionsDropDownEdit = By.xpath("//*[@id=\"m74daaf83_ns_menu_AM40_HEADER_sub_PLUSGEDTTP_OPTION_a_tnode\"]");//("//*[@id=\"menu0_AM40_HEADER_sub_PLUSGEDTTP_OPTION_a_tnode\"]");
		//x-path for Select Actions drop-down - Apply 
	    public static By listTabSelectActionsDropDownApply = By.xpath("//*[@id=\"m74daaf83_ns_menu_AM40_HEADER_sub_PLUSGAPPTP_OPTION_a_tnode\"]");///*[@id=\"menu0_AM40_HEADER_sub_PLUSGAPPTP_OPTION_a_tnode\"]");
	    //x-path for Select Actions drop-down -Template-->Generate--->Description
	    public static By listTabSelectActionsDescription = By.xpath("//*[@id=\"ma0221e14-tb2\"]");
	    //x-path for Select Actions drop-down -Template-->Edit--->OK
	    public static By listTabSelectActionsOk = By.xpath("//*[@id=\"m8d12c181-pb\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->Filter
	    public static By listTabSelectActionsFilter = By.xpath("//*[@id=\"m5c4fdd3f-lb2\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->Description
	    public static By listTabSelectActions_TemplateID = By.xpath("//*[@id=\"m5c4fdd3f_tfrow_[C:1]_txt-tb\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->viewDetailsArrow
	    public static By listTabSelectActionsViewDetailsArrow = By.xpath("//*[@id=\"m5c4fdd3f_tdrow_[C:0]_tgdet-ti[R:0]_img\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->Ok
	    public static By listTabSelectActionsEdit_Ok = By.xpath("//*[@id=\"mace02a19-pb\"]");
	    //x-path for Select Actions drop-down -Template-->Apply-->Filter
	    public static By listTabSelectActionsApplyFilter = By.xpath("//*[@id=\"m9f3fde23-lb2\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->Description
	    public static By listTabSelectActionsApply_TemplateID = By.xpath("//*[@id=\"m9f3fde23_tfrow_[C:0]_txt-tb\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->Ok
	    public static By listTabSelectActionsApply_Ok = By.xpath("//*[@id=\"m1675d8e0-pb\"]");
	    //x-path for Select Actions drop-down -Template-->Edit-->Ok
	    public static By editTemplateOFA= By.xpath("//*[@id=\"m5d7bd079_tdrow_[C:5]_checkbox-cb[R:0]_img\"]");//("//*[@id=\"m5d7bd079_tdrow_[C:6]_checkbox-cb[R:0]_img\"]");
	    
	    
	    
	    //x-path for Select Actions drop-down -Template-->Edit-->First record position search button
	    public static By positiontextBoxFirstRecord= By.xpath("//*[@id=\"m5d7bd079_tdrow_[C:4]_txt-tb[R:0]\"]");
	    
	  //x-path for Select Actions drop-down -Template-->Edit-->Second record position search button
	    public static By positiontextBoxSecondRecord= By.xpath("//*[@id=\"m5d7bd079_tdrow_[C:4]_txt-tb[R:1]\"]");
	  
	    
	    //x-path for Search Icon in Apply Template window
	    public static By searchBtn= By.xpath("//*[@id=\"m9f3fde23-ti2_img\"]");
	    //x-path for Search Icon in edit Template window
	    public static By seachBtnEdittemplateWindow= By.xpath("//*[@id=\"m5c4fdd3f-ti2_img\"]");
	    //x-path for FirstSearchedRecord
	    public static By listTabSelectActionsApply_firstRecord = By.xpath("//*[@id=\"m9f3fde23_tdrow_[C:0]-c[R:0]\"]");
	    //Xpath for Button Yes
	    public static By yes = By.xpath("//*[@id=\"me1720906-pb\"]");
	    //Xpath for Confirmation message
	    public static By message = By.xpath("//*[@id=\"mb_msg\"]");
	    
	  
	
	    
	  
	    
	    
	    

	    

	    
	  
	    
	    
	    
	  
	    

	    
	  
	    
	  
	 
	/**
	 * @Description: Daily Log Initialize
	 * @throws Throwable
	 */
	public void dailyLogInit(String userNameString, String passwordString) throws Throwable {
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
			// This Method is used to navigate to "Daily Log" in the Applications
			StartCenter.navigateToDailyLog();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Click on Refresh/Reload Daily Log list button
	 * @throws Throwable
	 */
	public void ReloadDailyLogTable() throws Throwable {
		try {

			click(dailyLog_ListTab_ReloadTableBtn, "Reload Daily Log");
			implicityWait(20);

			SuccessReportWithScreenshot("Successfully displayed all Daily Logs");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Click on New Daily Log button
	 * @throws Throwable
	 */
	public void NewDailyLog_CLick() throws Throwable {
		try {

			click(newDailyLog, "New Daily Log");
			implicityWait(4);
			
			SuccessReportWithScreenshot("New Daily Log record opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Update Supervisor in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_UpdateSupervisor(String dl_Supervisor) throws Throwable {
		try {

			click(newDailyLog_SupervisorSearchBtn, "Supervisor Search");
			implicityWait(2);
			clear(newDLSupervisorSearch_Person);	
			type(newDLSupervisorSearch_Person, dl_Supervisor, "Person");
			click(newDLSupervisorSearch_SearchBtn, "Person Search");
			implicityWait(20);
			click(newDLSupervisorSearch_SelectFirstRecord, "Select Supervisor");
			implicityWait(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Update POA in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_UpdatePOA(String dl_POA) throws Throwable {
		try {

			click(newDailyLog_POASearchBtn, "POA Search");
			implicityWait(2);
			clear(newDailyLog_POAValue);	
			type(newDailyLog_POAValue, dl_POA, "Value");
			click(newDailyLog_SearchBtn, "Value Search");
			implicityWait(2);
			click(newDailyLog_SelectFirstRecord, "Select POA");
			implicityWait(4);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @Description: Update Briefing Topics in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_UpdateBriefingTopics(String dl_BriefingTopics) throws Throwable {
		try {

			clear(newDailyLog_BriefingTopics);	
			type(newDailyLog_BriefingTopics, dl_BriefingTopics, "Briefing Topics");
			
			SuccessReportWithScreenshot("Successfully updated Briefing Topics field");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		

	/**
	 * @Description: Enter values for a Daily Log
	 * @throws Throwable
	 */
	public void EnterValuesforDailyLog(String dl_Location, 
			String dl_Shift, String dl_Department, String dl_Watch, String dl_Route, 
			String dl_ShiftReference, String dl_ShiftStart, String dl_ShiftFinish, 
			String dl_Supervisor, String dl_POA) throws Throwable {
		try {			
			
			click(newDailyLog_LocationSearchBtn, "Location Search");
			implicityWait(2);
			clear(newDLLocationSearch_Location);	
			type(newDLLocationSearch_Location, dl_Location, "Location");
			click(newDLLocationSearch_SearchBtn, "Location Search");
			implicityWait(2);
			click(newDLLocationSearch_SelectFirstRecord, "Select Location");
			
			implicityWait(2);
			clear(newDailyLog_Department);	
			type(newDailyLog_Department, dl_Department, "Department");

			implicityWait(2);
			clear(newDailyLog_Shift);	
			type(newDailyLog_Shift, dl_Shift, "Shift");

			implicityWait(2);
			clear(newDailyLog_Watch);	
			type(newDailyLog_Watch, dl_Watch, "Watch");

			implicityWait(2);
			clear(newDailyLog_Route);	
			type(newDailyLog_Route, dl_Route, "Route");	

			implicityWait(2);
			clear(newDailyLog_ShiftStart);	
			type(newDailyLog_ShiftStart, dl_ShiftStart, "Shift Start");

			implicityWait(2);
			clear(newDailyLog_ShiftFinish);	
			type(newDailyLog_ShiftFinish, dl_ShiftFinish, "Shift Finish");

			implicityWait(2);
			DailyLog_UpdatePOA(dl_POA);
			implicityWait(2);

			implicityWait(2);
			DailyLog_UpdateSupervisor(dl_Supervisor);
			
			SuccessReportWithScreenshot("Successfully Entered data for New Daily Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/* @Description: Enter weather
	 * @throws Throwable
	 */
	public void EnterWeather(String dl_Weather) throws Throwable {
		try {
			clear(newDailyLog_Weather);	
			type(newDailyLog_Weather, dl_Weather, "Shift Finish");
			SuccessReportWithScreenshot("Successfully Entered Weather");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/* @Description: Scroll to Sailing Details
	 * @throws Throwable
	 */
	public void ScrollToSailingDetails(String locatorName) throws Throwable {
		try {
			JSScrollTo(newDailyLog_SailingData_NewRow,locatorName);
			SuccessReportWithScreenshot("Successfully scrolled till Sailing Details visible");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/* @Description: Click on Save Daily Log button
	 * @throws Throwable
	 */
	public void SaveDailyLog_CLick() throws Throwable {
		try {
			implicityWait(2);
			click(saveDailyLog, "Save Daily Log");
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Saved a Daily Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* @Description: Click on Readings Tab
	 * @throws Throwable
	 */
	public void Readings_CLick() throws Throwable {
		try {
			implicityWait(2);
			click(saveDailyLog, "Save Daily Log");
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Saved a Daily Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/* @Description: Read and return 1st Record Description-Readings
	 * @throws Throwable
	 */
	public String Readings_ReadFirstRecordDescription() throws Throwable {
		String firstRecordDescriptionStr = "";
		try {

			//firstRecordDescriptionStr = getXPathAttribute(ReadingdTab_FirstRecord_Description, "value");
			firstRecordDescriptionStr = getXPathValue(ReadingdTab_FirstRecord_Description);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return firstRecordDescriptionStr;
	}
	
	/* @Description: Read and return Second Record Description-Readings
	 * @throws Throwable
	 */
	public String Readings_ReadFSecondtRecordDescription() throws Throwable {
		String secondRecordDescriptionStr = "";
		try {

			secondRecordDescriptionStr = getXPathValue(ReadingdTab_SecondRecord_Description);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return secondRecordDescriptionStr;
	}
	
	
	
	/* @Description: Read and return Daily Log - Shift Log ID
	 * @throws Throwable
	 */
	public String DailyLog_ReadReturnShiftLogID() throws Throwable {
		String dailyLog_ShiftLogIdStr = "";
		try {

			dailyLog_ShiftLogIdStr = getXPathAttribute(newDailyLog_ShiftLog, "value");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyLog_ShiftLogIdStr;
	}
	
	/* @Description: Read and return Daily Log - Shift Log Description
	 * @throws Throwable
	 */
	public String DailyLog_ReadReturnShiftLDescription() throws Throwable {
		String dailyLog_ShiftDescription = "";
		try {

			dailyLog_ShiftDescription = getXPathAttribute(newDailyLog_Description, "value");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyLog_ShiftDescription;
	}
	

	
	/* @Description: Read and return Daily Log - Generated Template ID
	 * @throws Throwable
	 */
	public String DailyLog_ReadReturnTemplateID() throws Throwable {
		String dailyLog_TemplateIdStr = "";
		try {

			dailyLog_TemplateIdStr = getXPathAttribute(generatedTemplateID, "value");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dailyLog_TemplateIdStr;
	}
	
	
	
	
	/* @Description: Navigate to List Tab in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_NavigateToListTab() throws Throwable {
		try {

			click(dailyLog_ListTab, "List Tab");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Successfully Navigate to List Tab");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Navigate to Muster List Tab in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_NavigateToMusterListTab() throws Throwable {
		try {

			click(dailyLog_MusterListTab, "Muster List Tab");	
			implicityWait(2);	
			
			SuccessReportWithScreenshot("Successfully Navigate to Muster List Tab");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/* @Description: Navigate to Daily Log Tab in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_NavigateToDailyLogTab() throws Throwable {
		try {

			click(dailyLog_DailyLogTab, "Daily Log Tab");	
			implicityWait(2);	
			
			SuccessReportWithScreenshot("Successfully Navigate to Daily Log Tab");	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Filter the data by Shift Log ID in List Tab of Daily Log
	 * @throws Throwable
	 */
	public void DailyLogListTab_ShiftLogIDFilter(String dl_ShiftLogID) throws Throwable {
		try {

			clear(dailyLog_ListTab_Log);
			type(dailyLog_ListTab_Log, dl_ShiftLogID);
			click(dailyLog_ListTab_FilterTableBtn, "Filter");		
			implicityWait(7);	
			
			SuccessReportWithScreenshot("Successfully Filtered the Daily Log");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Open the filtered record in List Tab of Daily Log
	 * @throws Throwable
	 */
	public void DailyLogListTab_OpenSelectedRecord() throws Throwable {
		try {
			
			click(dailyLog_ListTab_SelectedRecord, "Selected Record");		
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully opened selected Daily Log");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Change status of the Daily Log record to Active
	 * @throws Throwable
	 */
	public void DailyLog_ChangeStatustoActive() throws Throwable {
		try {
			
			click(changeStatusDailyLog, "ChangeStatus");		
			implicityWait(2);
			click(changeStatus_NewStatus, "New Status");	
			implicityWait(1);
			click(changeStatus_StatusActive, "Active");	
			implicityWait(1);
			click(changeStatus_OkBtn, "Ok");		
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Changed Daily Log Status to Active");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Change status of the Daily Log record to Active
	 * @throws Throwable
	 */
	public void DailyLog_ChangeStatustoComplete() throws Throwable {
		try {
			
			click(changeStatusDailyLog, "ChangeStatus");		
			implicityWait(2);
			click(changeStatus_NewStatus, "New Status");	
			implicityWait(1);
			click(changeStatus_StatusComplete, "Complete");	
			implicityWait(1);
			click(changeStatus_OkBtn, "Ok");		
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Changed Daily Log Status to Active");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Change status of the Daily Log record to Draft
	 * @throws Throwable
	 */
	public void DailyLog_ChangeStatustoDraft() throws Throwable {
		try {
			
			click(changeStatusDailyLog, "ChangeStatus");		
			explicityWait(changeStatus_NewStatus);
			click(changeStatus_NewStatus, "New Status");
			click(changeStatus_StatusDraft, "Draft");
			click(changeStatus_OkBtn, "Ok");		
			explicityWait(newDailyLog_Description);
			
			SuccessReportWithScreenshot("Successfully Changed Daily Log Status to Draft");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Select People based on a Name filter to Daily Log - Crew/Staff Section
	 * @throws Throwable
	 */
	public void DailyLog_CrewStaffSelectPeople_NameFilter(String dl_CreqStaffFilter) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectPeopleBtn, "Select People");	
			implicityWait(2);		
			clear(newDLCrewStaffSelectPeople_Name);	
			type(newDLCrewStaffSelectPeople_Name, dl_CreqStaffFilter, "Name");
			click(newDLCrewStaffSelectPeople_FilterBtn, "Filter");	
			implicityWait(14);
			
			SuccessReportWithScreenshot("Successfully Filtered Persons by Name");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	

	/**
	 * @Description: Select last shift crew to Daily Log - Crew/Staff Section
	 * @throws Throwable
	 */
	public void DailyLog_CrewStaffSelectPeople_LastShiftCrew() throws Throwable {
		try {

			click(newDailyLog_CrewStaff_LastShiftCrew, "Last Shift Crew");	
			implicityWait(2);	
			click(newDLCrewStaffLastShiftCrew_SelectAllCheckbox, "Select All");	
			implicityWait(2);
			click(newDLCrewStaffLastShiftCrew_OkBtn, "OK");	
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Filtered Persons by Name");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * @Description: Select People based on a Name filter to Daily Log - Crew/Staff Section
	 * @throws Throwable
	 */
	public void DailyLog_CrewStaffSelectPeople_Employee_IDFilter(String dl_Employee_ID_Filter) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectPeopleBtn, "Select People");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPeople_EmployeeID);			
			clear(newDLCrewStaffSelectPeople_EmployeeID);	
			type(newDLCrewStaffSelectPeople_EmployeeID, dl_Employee_ID_Filter, "ID");
			click(newDLCrewStaffSelectPeople_FilterBtn, "Filter");
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Filtered Persons by ID");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Close the Select People pop-up for Daily Log - Crew/Staff Section
	 * @throws Throwable
	 */
	public void DailyLog_CrewStaffSelectPeople_Cancel() throws Throwable {
		try {
			
			click(newDLCrewStaffSelectPeople_CancelBtn, "Cancel");	
			implicityWait(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * @Description: Select "All" People in Daily Log - Crew/Staff Section using Select All Check-box
	 * @throws Throwable
	 */
	public void DailyLog_CrewStaffSelectPeople_SelectAll() throws Throwable {
		try {

//			implicityWait(5);
			click(newDLCrewStaffSelectPeople_SelectAllCheckbox, "Select All");	
			implicityWait(2);
			click(newDLCrewStaffSelectPeople_OkBtn, "Ok");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Successfully Selected All the filtered persons");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Select "All" People in Daily Log - Crew/Staff Section using Select All Check-box
	 * @throws Throwable
	 */
	public void DailyLog_CrewStaffSelectOFA() throws Throwable {
		try {

		click(newDLCrewStaffCheckBoxOFA, "OFA");
		implicityWait(2);
		SuccessReportWithScreenshot("Successfully Selected OFA");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/**
	 * @Description: Click New Row in Daily Log - Log Entry
	 * @throws Throwable
	 */
	public void DailyLog_LogEntry_NewRow() throws Throwable {
		try {

			click(newDailyLog_LogEntries_NewRow, "New Row");
			implicityWait(3);
			
			SuccessReportWithScreenshot("Successfully Clicked New Row in Log Entry");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Enter First Log Summary in Daily Log - Log Entry
	 * @throws Throwable
	 */
	public void DailyLog_LogEntry_EnterFirstSummary(String dl_LogEntrySummary) throws Throwable {
		try {

			clear(newDailyLog_LogEntries_LogSummary);
			type(newDailyLog_LogEntries_LogSummary, dl_LogEntrySummary, "Log Summary");
			implicityWait(3);
						
			SuccessReportWithScreenshot("Successfully Entered Log Summary");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @Description: Enter Second Log Summary in Daily Log - Log Entry
	 * @throws Throwable
	 */
	public void DailyLog_LogEntry_EnterSecondtSummary(String dl_LogEntrySummary) throws Throwable {
		try {

			clear(newDailyLog_LogEntries_LogSummary);
			type(newDailyLog_LogEntries_LogSummary, dl_LogEntrySummary, "Log Summary");
			implicityWait(3);
						
			SuccessReportWithScreenshot("Successfully Entered Log Summary");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * @Description: Enter First Log Summary in Daily Log - Log Entry
	 * @throws Throwable
	 */
	public void DailyLog_LogEntry_Logs_FilterSearch(String dl_LogEntrySummary) throws Throwable {
		try {
			click(newDailyLog_LogEntries_Filter, "Log Entries Filter");
			implicityWait(3);
			clear(newDailyLog_LogEntries_LogSummary_Search_TextBox);
			type(newDailyLog_LogEntries_LogSummary_Search_TextBox, dl_LogEntrySummary, "Log Summary");
			implicityWait(3);
			click(newDailyLog_LogEntries_Filter, "Log Entries Filter");
			implicityWait(2);
			SuccessReportWithScreenshot("Successfully Entered Log Summary");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void validateLogsIsAddedOrNot() throws Throwable {
		try {
			   
			List rows = driver.findElements(By.xpath("//table[@id='m676a031e_tbod-tbd']/tbody/tr"));
			
			  int s =rows.size();
			  System.out.println("******Rows Count*******"+s);
			  if(s>3) {				  
				  SuccessReport("Verify "," Successfully displayed Logs ");    				  
			  }
			  else {
				  
				  failureReport("Verify ","Logs not displayed");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	
	
//	
//	/**
//	 * @Description: Navigate to More Actions - Modify/Delete Entry Logs in Daily Log
//	 * @throws Throwable
//	 */
//	public void DailyLog_MoreActionsModDelEntryLogs() throws Throwable {
//		try {
//
//			click(dailyLog_SelectActionDrpdwn, "More Actions");
//			implicityWait(2);
//			click(dailyLogSA_ModDelLogEntry, "Modify-Delete Log Entry");
//			implicityWait(2);
//						
//			SuccessReportWithScreenshot("Successfully Clicked Modify-Delete Log Entry");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	
	/**
	 * @Description: Navigate to More Actions - Modify/Delete Entry Logs in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_MoreActionsModDelEntryLogs() throws Throwable {
		try {

//			click(dailyLog_SelectActionDrpdwn, "More Actions");
//			implicityWait(2);
			click(dailyLogSA_ModDelLogEntry, "Modify-Delete Log Entry");
			implicityWait(2);
						
			SuccessReportWithScreenshot("Successfully Clicked Modify-Delete Log Entry");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Delete the latest log in More Actions - Modify/Delete Entry Logs in Daily Log
	 * @throws Throwable
	 */
	public void DailyLog_MoreActionsModDelEntryLogs_DeleteLatestLog() throws Throwable {
		try {
			
			click(dailyLogSA_ModDelLogEntry_DeleteLatestRecord, "Delete");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Successfully Deleted Log Entry");

			click(dailyLogSA_ModDelLogEntry_OKButton, "Ok");
			implicityWait(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @Description: Click the "Carry Over?" check-box for the latest log in Daily Log - Log Entries
	 * @throws Throwable
	 */
	public void DailyLog_LogEntries_CarryOverClick() throws Throwable {
		try {
			
			click(newDailyLog_LogEntries_LocCarryOverCheckbox, "Carry Over");
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Checked Carry Over Flag");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Click and Enter new row details in Daily Log - Sailing Data
	 * @throws Throwable
	 */
	public void DailyLog_SailingData_NewRowEnterData(String dl_SailingData_Sailing,String dl_SailingData_Type,String dl_SailingData_PassengerCount, 
			String dl_SailingData_PRA,String dl_SailingData_LicenseType) throws Throwable {
		try {
			
			//click(newDailyLog_SailingData_NewRow, "New Row");
			implicityWait(5);
			//click(newDailyLog_SailingData_NewRow, "New Row");
			//implicityWait(2);
			//click(newDailyLog_SailingData_NewRow, "New Row");
			JSClick(newDailyLog_SailingData_NewRow,"New Row");
			
			implicityWait(7);
			
			//clear(newDailyLog_SailingData_Sailing);
			type(newDailyLog_SailingData_Sailing, dl_SailingData_Sailing);
			implicityWait(2);
			
			//clear(newDailyLog_SailingData_Type);
			type(newDailyLog_SailingData_Type, dl_SailingData_Type);
			implicityWait(3);
			
			//clear(newDailyLog_SailingData_PassengerCount);
			type(newDailyLog_SailingData_PassengerCount, dl_SailingData_PassengerCount);
			implicityWait(3);
			//clear(newDailyLog_SailingData_PassengerCount);
			type(newDailyLog_SailingData_PassengerCount, dl_SailingData_PassengerCount);
			implicityWait(3);
			
//			click(newDailyLog_SailingData_PRA, "PRA");
//			implicityWait(2);
			//clear(newDailyLog_SailingData_PRA);
			type(newDailyLog_SailingData_PRA, dl_SailingData_PRA);
			implicityWait(1);
			
			//clear(newDailyLog_SailingData_LicenseType);
			type(newDailyLog_SailingData_LicenseType, dl_SailingData_LicenseType);
			implicityWait(1);
			
			
			SuccessReportWithScreenshot("Successfully Entered New row in Sailing Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Select start-up check
	 * @throws Throwable
	 */
	public void DailyLog_ProceduresChecks_Select_start_upCheck() throws Throwable {
		try {

//			implicityWait(5);
			click(newDailyLog_ProceduresChecks_StartUpCheck, "Start-up CheckBox");	
			implicityWait(2);				
			SuccessReportWithScreenshot("Successfully Selected Start-up check box");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Select ShutDown check
	 * @throws Throwable
	 */
	public void DailyLog_ProceduresChecks_Select_Shut_downCheck() throws Throwable {
		try {

//			implicityWait(5);
			click(newDailyLog_ProceduresChecks_ShutDownpCheck, "Shut-Down CheckBox");	
			implicityWait(2);				
			SuccessReportWithScreenshot("Successfully Selected Shut-Down check box");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Description: Click and Enter Overtime in Daily Log - overtime
	 * @throws Throwable
	 */
	public void DailyLog_Enter_OverTime(String dl_OvertimeData_OverTimeCode, String dl_OvertimeData_OverTimeHours, 
			String dl_OvertimeData_OverTimeReason) throws Throwable {
		try {
//			click
//			clear(newDailyLog_Overtime_OverTimeCode);
//			type(newDailyLog_Overtime_OverTimeCode, dl_OvertimeData_OverTimeCode);
//			implicityWait(2);
			
			click(newDailyLog_Overtime_OverTimeCode_Search, "Over Time code");
			implicityWait(2);
			clear(newDailyLog_Overtime_OverTimeCode_PremiumPayCode);	
			type(newDailyLog_Overtime_OverTimeCode_PremiumPayCode, dl_OvertimeData_OverTimeCode, "Over Time Code");
			click(newDailyLog_Overtime_OverTimeCode_PremiumPayCode_searchBtn, "Time Code Search");
			implicityWait(2);
			click(newDailyLog_Overtime_OverTimeCode_PremiumPayCode_FirstRecord, "Select Over Time Code");
			implicityWait(2);
			clear(newDailyLog_Overtime_OverTimeHours);
			type(newDailyLog_Overtime_OverTimeHours, dl_OvertimeData_OverTimeHours);
			implicityWait(2);
			clear(newDailyLog_Overtime_OverTimeReason);
			type(newDailyLog_Overtime_OverTimeReason, dl_OvertimeData_OverTimeReason);
			
			SuccessReportWithScreenshot("Successfully Entered Over Time Data");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* @Description: Clear the filters in List Page
	 * @throws Throwable
	 */
	public void DailyLog_ListPage_ClearFilters() throws Throwable {
		try {
			
			click(dailyLog_ListTab_ClearTableBtn, "Clear Filters");
			implicityWait(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void DailyLog_ListPage_RecordCount() throws Throwable {
		try {

			isElementPresent(listTabRecordCount, "Location Header");
			SuccessReportWithScreenshot(getXPathValue(listTabRecordCount));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/* @Description: Filter records on Description field in List Page
	 * @throws Throwable
	 */
	public void DailyLog_ListPage_Description_Filter(String dl_DescriptionFilter) throws Throwable {
		try {

          
			clear(listTabFilterDescription);	
			type(listTabFilterDescription, dl_DescriptionFilter, "Description Filter");
			click(dailyLog_ListTab_FilterTableBtn, "Search");
			implicityWait(4);
			
			SuccessReportWithScreenshot("List filtered by Description");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void DailyLog_ListPage_AdvancedSearch() throws Throwable {
		try {
			
			click(advancedSearchBtn, "Advanced Search");
			implicityWait(2);
			
			SuccessReportWithScreenshot("clicked on Advanced Search Button");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Enter values for a Daily Log
	 * @throws Throwable
	 */
	public void EnterMoreSearchFields(String dl_startDateFrom, String dl_startDateTo)
			 throws Throwable {
		try {			
			
			
			
			clear(startDateFrom);	
			type(startDateFrom, dl_startDateFrom, "Shift Start");
			
			clear(startDateTo);	
			type(startDateTo, dl_startDateTo, "Shift Finish");
			click(findBtn, "Find Button");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Successfully Entered data in More Search Field pop-ups");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void startDateColumnHeader_Click()
			 throws Throwable {
		try {			
			
			click(startDateColumnHeader, "Start Date Column Header");		
			implicityWait(2);
			
			SuccessReportWithScreenshot("Successfully Clicked on Start Date Column Header");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	/**
//	 * @Description: Launch Run Report popup from Drill Log Module
//	 * @throws Throwable
//	 */
//	public void Template_Generate() throws Throwable {
//		try {
//
//			
////			isElementPresent(listTabSelectActionsDropDown, "Select Actions");
//			click(listTabSelectActionsDropDown, "Select Actions");
//			implicityWait(2);
//			click(listTabSelectActionsDropDownTemplate, "Template");
//			implicityWait(2);
//			click(listTabSelectActionsDropDownGenerate, "Generate");
//			implicityWait(2);
//			
////			implicityWait(5);
//			
//			SuccessReportWithScreenshot("Clicked on Generate button Successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	/**
	 * @Description: Launch Run Report popup from Drill Log Module
	 * @throws Throwable
	 */
	public void Template_Generate() throws Throwable {
		try {

			click(listTabSelectActionsDropDownTemplate, "Template");
			implicityWait(2);
			click(listTabSelectActionsDropDownGenerate, "Generate");
			implicityWait(4);
			
//			implicityWait(5);
			
			SuccessReportWithScreenshot("Clicked on Generate button Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
//	
//	public void Template_Edit() throws Throwable {
//		try {
//
//			
////			isElementPresent(listTabSelectActionsDropDown, "Select Actions");
//			click(listTabSelectActionsDropDown, "Select Actions");	
//			implicityWait(2);		
//			click(listTabSelectActionsDropDownTemplate, "Template");
//			implicityWait(2);
//			click(listTabSelectActionsDropDownEdit, "Edit");
//			implicityWait(2);
//			
////			implicityWait(5);
//			
//			SuccessReportWithScreenshot("Clicked on Edit button Successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public void Template_Edit() throws Throwable {
		try {	
			click(listTabSelectActionsDropDownTemplate, "Template");
			implicityWait(2);
			click(listTabSelectActionsDropDownEdit, "Edit");
			implicityWait(2);
			SuccessReportWithScreenshot("Clicked on Edit button Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Click  on Run Reports
	 * @throws Throwable
	 */
	public void ClickOnRunReports() throws Throwable {
		try {	
			click(RunReportsBtn, "Template");
			implicityWait(2);
			SuccessReportWithScreenshot("Clicked on Run Reports Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * @Description: Click Cancel button on Reports and Schedules
	 * @throws Throwable
	 */
	public void RunReport_ClickCancel() throws Throwable {
		try {
			click(reportAndSchedules_CancelReport, "Cancel");
			implicityWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GenerateCrewCompetenciesReport() throws Throwable {
		try {	
			String daysFromLastDrill = "";
			click(CrewCompetenciesReport, "Crew Competencies Report");
			implicityWait(4);
			click(CrewCompetenciesReportSubmit, "Submit");			
			implicityWait(10);	
			switchNewChromeTab();
			implicityWait(5);			
			SuccessReportWithScreenshot("Crew Competencies Report Generated Successfully");				
			closeChromeTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GenerateDailyLogSummaryReport() throws Throwable {
		try {	
			click(DailyLogSummaryReport, "Daily Log Summary Report");
			implicityWait(2);
			click(DailyLogSummaryReportSubmit, "Submit");
			implicityWait(10);	
			switchNewChromeTab();
			implicityWait(5);			
			SuccessReportWithScreenshot("Daily Log Summary Report Generated Successfully");				
			closeChromeTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GenerateMusterListReport() throws Throwable {
		try {	
			click(MusterListReport, "Muster List Report");
			implicityWait(2);
			click(MusterListReportSubmit, "Submit");
			implicityWait(10);	
			switchNewChromeTab();
			implicityWait(5);			
			SuccessReportWithScreenshot("Muster List Report Generated Successfully");				
			closeChromeTab();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GeneratePassengersCountsByDateReport() throws Throwable {
		try {	
			click(PassengersCountsByDate, "Passengers Counts By Date");
			implicityWait(2);
			click(PassengersCountsByDateSubmit, "Submit");
			implicityWait(10);	
			switchNewChromeTab();
			implicityWait(5);			
			SuccessReportWithScreenshot("Passengers Counts By Date Report Generated Successfully");				
			closeChromeTab();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void GenerateRampAssignmentReportReport() throws Throwable {
		try {	
			click(RampAssignmentReport, "Ramp Assignment Report");
			implicityWait(2);
			click(RampAssignmentReportSubmit, "Submit");
			implicityWait(10);	
			switchNewChromeTab();
			implicityWait(5);			
			SuccessReportWithScreenshot("Ramp Assignment Report Generated Successfully");				
			closeChromeTab();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	public void Template_Apply() throws Throwable {
//		try {
//
//			
////			isElementPresent(listTabSelectActionsDropDown, "Select Actions");
//			click(listTabSelectActionsDropDown, "Select Actions");
//			implicityWait(2);			
//			click(listTabSelectActionsDropDownTemplate, "Template");
//			implicityWait(2);
//			click(listTabSelectActionsDropDownApply, "Apply");
//			implicityWait(2);
//			
////			implicityWait(5);
//			
//			SuccessReportWithScreenshot("Clicked on Apply button Successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	public void Template_Apply() throws Throwable {
		try {			
			click(listTabSelectActionsDropDownTemplate, "Template");
			implicityWait(2);
			click(listTabSelectActionsDropDownApply, "Apply");
			implicityWait(2);
			SuccessReportWithScreenshot("Clicked on Apply button Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void Template_Generate_Description_Enter(String dl_Generate_description) throws Throwable {
		try {

			clear(listTabSelectActionsDescription);	
			type(listTabSelectActionsDescription, dl_Generate_description, "Description");
			click(listTabSelectActionsOk, "Ok");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Description entered and saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void searchSavedTemplate(String dl_TemplateID) throws Throwable {
		try {
			
            click(listTabSelectActionsFilter,"Filter");
			implicityWait(3);
			clear(listTabSelectActions_TemplateID);	
			type(listTabSelectActions_TemplateID, dl_TemplateID, "Template");
			click(seachBtnEdittemplateWindow,"Search Icon");		
			implicityWait(5);
			
			SuccessReportWithScreenshot("Previously saved template Displayed successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void viewDetailsArrowBtn_Click() throws Throwable {
		try {
			
			click(listTabSelectActionsViewDetailsArrow,"Arrow");
			implicityWait(6);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void enterPositionForFirstRecord(String position) throws Throwable {
		try {
			implicityWait(2);
			type(positiontextBoxFirstRecord, position, "position");
			implicityWait(4);

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void enterPositionForSecondRecord(String position) throws Throwable {
		try {
			//click(positiontextBoxSecondRecord,"position text box");
			type(positiontextBoxSecondRecord, position, "position");
			implicityWait(2);

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void selectFirstRecordOFA_CheckBox() throws Throwable {
		try {
			
			click(editTemplateOFA,"OFA check Box");
			implicityWait(4);

		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	public void okBtn_Click() throws Throwable {
		try {
			
			click(listTabSelectActionsEdit_Ok,"Ok");
			implicityWait(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void okBtnInApplyTemplate_Click() throws Throwable {
		try {
			
			click(listTabSelectActionsApply_Ok,"Ok");
			implicityWait(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public void searchSavedTemplateInApplyTemWindow(String  dl_TemplateID) throws Throwable {
		try {
			
			click(listTabSelectActionsApplyFilter,"Filter");
			implicityWait(2);
			clear(listTabSelectActionsApply_TemplateID);	
			type(listTabSelectActionsApply_TemplateID, dl_TemplateID, "Template");
			click(searchBtn,"Search Icon");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Previously saved template Displayed successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void selectRecordsAndClickOk() throws Throwable {
		try {
			
			click(listTabSelectActionsApply_firstRecord,"Template");
			implicityWait(2);
			okBtnInApplyTemplate_Click();
//			click(yes,"Yes");
			implicityWait(2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyConfirmationMsg() throws Throwable {
		String msg ="Do you want to apply/re-apply a template";
		try {
			isElementPresent(message,msg);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifySign_off_DateTextBoxIsReadOnly(String locatorName) throws Throwable {
		By newDailyLog_Procedurechecks_Sign_off_Date= By.xpath("(//*[@id='m9f0f36e-tb' and @aria-readonly='true'])");	
		try {
			isElementPresent(newDailyLog_Procedurechecks_Sign_off_Date,locatorName);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void verifySign_off_ByTextBoxIsReadOnly(String locatorName) throws Throwable {
		By newDailyLog_Procedurechecks_Sign_off_By= By.xpath("(//*[@id='m7370a05e-tb' and @aria-readonly='true'] )");	
		
		try {
			isElementPresent(newDailyLog_Procedurechecks_Sign_off_By,locatorName);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* @Description: Filter records on Route field in List Page
	 * @throws Throwable
	 */
	public void DailyLog_ListPage_Route_Filter(String dl_RouteFilter) throws Throwable {
		try {

          
			clear(listTabFilterRoute);	
			type(listTabFilterRoute, dl_RouteFilter, "Route Filter");
			click(dailyLog_ListTab_FilterTableBtn, "Search");
			implicityWait(4);			
			SuccessReportWithScreenshot("List filtered by Route");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 

	/**
	 * @Description: Filter position for crew/staff
	 * @throws Throwable
	 */
	//DailyLog_CrewStaffSelectPostion
	
	
	
	public void DailyLog_CrewStaffClickPosition1_PositionFilter(String Position) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectpostionBtn1, "Click Position");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPosition_PositionFilter);			
			clear(newDLCrewStaffSelectPosition_PositionFilter);	
			type(newDLCrewStaffSelectPosition_PositionFilter, Position, "Position");
			click(newDLCrewStaffSelectPosition_FilterBtn, "Filter");
			implicityWait(5);
			SuccessReportWithScreenshot("Successfully filtered the positions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void DailyLog_CrewStaffClickPosition2_PositionFilter(String Position) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectpostionBtn2, "Click Position");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPosition_PositionFilter);			
			clear(newDLCrewStaffSelectPosition_PositionFilter);	
			type(newDLCrewStaffSelectPosition_PositionFilter, Position, "Position");
			click(newDLCrewStaffSelectPosition_FilterBtn, "Filter");
			implicityWait(5);
			SuccessReportWithScreenshot("Successfully filtered the positions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DailyLog_CrewStaffClickPosition3_PositionFilter(String Position) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectpostionBtn3, "Click Position");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPosition_PositionFilter);			
			clear(newDLCrewStaffSelectPosition_PositionFilter);	
			type(newDLCrewStaffSelectPosition_PositionFilter, Position, "Position");
			click(newDLCrewStaffSelectPosition_FilterBtn, "Filter");
			implicityWait(5);
			SuccessReportWithScreenshot("Successfully filtered the positions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DailyLog_CrewStaffClickPosition4_PositionFilter(String Position) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectpostionBtn4, "Click Position");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPosition_PositionFilter);			
			clear(newDLCrewStaffSelectPosition_PositionFilter);	
			type(newDLCrewStaffSelectPosition_PositionFilter, Position, "Position");
			click(newDLCrewStaffSelectPosition_FilterBtn, "Filter");
			implicityWait(5);
			SuccessReportWithScreenshot("Successfully filtered the positions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DailyLog_CrewStaffClickPosition5_PositionFilter(String Position) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectpostionBtn5, "Click Position");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPosition_PositionFilter);			
			clear(newDLCrewStaffSelectPosition_PositionFilter);	
			type(newDLCrewStaffSelectPosition_PositionFilter, Position, "Position");
			click(newDLCrewStaffSelectPosition_FilterBtn, "Filter");
			implicityWait(5);
			SuccessReportWithScreenshot("Successfully filtered the positions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void DailyLog_CrewStaffClickPosition6_PositionFilter(String Position) throws Throwable {
		try {

			click(newDailyLog_CrewStaff_SelectpostionBtn6, "Position");
			implicityWait(2);
//			explicityWait_ElementVisible(newDLCrewStaffSelectPosition_PositionFilter);			
			clear(newDLCrewStaffSelectPosition_PositionFilter);	
			type(newDLCrewStaffSelectPosition_PositionFilter, Position, "Position");
			click(newDLCrewStaffSelectPosition_FilterBtn, "Filter");
			implicityWait(5);
			SuccessReportWithScreenshot("Successfully filtered the positions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @Description: Filter position for crew/staff
	 * @throws Throwable
	 */
	//DailyLog_CrewStaffSelectPostion
	
	
	
	public void DailyLog_CrewStaffClickOnPositionAFterFiltered() throws Throwable {
		try {
			click(newDLCrewStaffSelectPosition_FirstPosition, "Position");
			implicityWait(2);		
			SuccessReportWithScreenshot("Successfully selected the postions");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Sorting sample
	 * @throws Throwable
	 */
	
	public void DailyLog_SortingSample() throws Throwable {
		try {

			 List<WebElement> column3 = driver.findElements(By.xpath("//*[@id='m6a7dfd2f_tbod-tbd']/tbody/tr/td[5]"));
			  System.out.println("NUMBER OF ROWS IN THIS TABLE = "+ column3 .size());
			  int row_num=1;
			  for (WebElement tdElement : column3 )
			  {
			        System.out.println("row # " + row_num + ", col #3 text=" +tdElement.getText());
			   row_num++;
			  }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ReadingsTab_EnterFirstRecordNewReadAndNewReadDate(String NewReading) throws Throwable {
		try {
			click(dailyLog_ReadingsTab, "Click Reading Tab");
		    implicityWait(2);
		    clear(ReadingdTab_FirstRecord_NewReadingTextbox);
		    type(ReadingdTab_FirstRecord_NewReadingTextbox,NewReading,"New Reading text box ");
			implicityWait(1);
			SuccessReportWithScreenshot("Successfully entered the first Record New Reading and New Reading Date");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void ReadingsTab_EnterSecondRecordNewReadAndNewReadDate(String NewReading) throws Throwable {
		try {
	        //click(ReadingdTab_SecondRecord_NewReadingTextbox, "");
//			implicityWait(2);
//		    clear(ReadingdTab_SecondRecord_NewReadingTextbox);
			click(ReadingdTab_SecondRecord_NewReadingTextbox, "");
		    implicityWait(3);
		    type(ReadingdTab_SecondRecord_NewReadingTextbox,NewReading,"New Reading text box ");
		    implicityWait(2);
		    
			SuccessReportWithScreenshot("Successfully entered the first Record New Reading and New Reading Date");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	


}
