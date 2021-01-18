/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 02, 2020
 */

package com.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.ImplicitlyWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accelerators.ActionEngine;
import com.accelerators.CredentialManager;
import com.relevantcodes.extentreports.LogStatus;

public class Drill_Log_BCF extends ActionEngine {
	
	//x-path for creating new drill log button
	public static By newDrillLog = By.xpath("//img[@id = \"toolactions_INSERT-tbb_image\"]");
	//x-path for save drill log button
	public static By saveDrillLog = By.xpath("//img[@id = \"toolactions_SAVE-tbb_image\"]");
	//x-path for clear changes in drill log button
	public static By clearChanges = By.xpath("//img[@id = \"toolactions_CLEAR-tbb_image\"]");
	//x-path for previous drill log button
	public static By previousDrillLog = By.xpath("//img[@id = \"toolactions_PREVIOUS-tbb_image\"]");
	//x-path for next drill log button
	public static By nextDrillLog = By.xpath("//img[@id = \"toolactions_NEXT-tbb_image\"]");
	//x-path for complete drill log button
	public static By completeDrillLog = By.xpath("//img[@id = \"toolactions_COMP-tbb_image\"]");
	//x-path for complete drill log button
	public static By completeDrillLog_OkBtn = By.xpath("//button[@id = \"m60bd6d91-pb\"]");
	public static By spinnerImage = By.xpath("//*[@id=\"mca62da72-longop_image\"]");
	//x-path for complete drill log button
	public static By completeDrillLog_ListTab_OkBtn = By.xpath("//button[@id = \"mdb5530cf-pb\"]");
	//x-path for close drill log button
	public static By closeDrillLog = By.xpath("//img[@id = \"toolactions_CLOSE-tbb_image\"]");
	//x-path for the List tab
	public static By listTab = By.xpath("//a[@id = \"m9fa3e414-tab_anchor\"]");
	//x-path for the Drill Log tab
	public static By drillLogTab = By.xpath("//a[@id = \"mbf28cd64-tab_anchor\"]");
	//x-path for the related Records tab
	public static By relatedRecordsTab = By.xpath("//a[@id = \"m4326cf1d-tab_anchor\"]");
	//x-path for advanced search
	public static By advancedSearchText = By.xpath("//a[@id = \"m68d8715f-tbb_text\"]");
	//x-path for Drill Log - List - Advanced Search - Drill Log
	public static By advancedSearchDrillLog = By.xpath("//input[@id = \"m8db33e5c-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Description
	public static By advancedSearchDescription = By.xpath("//input[@id = \"m8ae710a2-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Location
	public static By advancedSearchLocation = By.xpath("//input[@id = \"m14ba6fe6-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Drill Scheduler
	public static By advancedSearchDrillScheduler = By.xpath("//input[@id = \"mde7b18d-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Work Type
	public static By advancedSearchWorkType = By.xpath("//input[@id = \"med325893-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Status
	public static By advancedSearchStatus = By.xpath("//input[@id = \"m449c436f-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Site
	public static By advancedSearchSite = By.xpath("//input[@id = \"m33c39bf-tb\"]");
	//x-path for Drill Log - List - Advanced Search - History
	public static By advancedSearchHistory = By.xpath("//input[@id = \"mdd9512d5-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Drill
	public static By advancedSearchDrill = By.xpath("//input[@id = \"m6cc85995-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Reported By
	public static By advancedSearchReportedBy = By.xpath("//input[@id = \"mfdd9cad3-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Assigned Labor
	public static By advancedSearchAssignedLabour = By.xpath("//input[@id = \"m85abfca0-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Supervisor
	public static By advancedSearchSupervisor = By.xpath("//input[@id = \"m13d7abff-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Reported Date From
	public static By advancedSearchReportedDateFrom = By.xpath("//input[@id = \"m3bb18792-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Reported Date TO
	public static By advancedSearchReportedDateTo = By.xpath("//input[@id = \"ma5d51231-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Target Date From
	public static By advancedSearchTargetDateFrom = By.xpath("//input[@id = \"m3cdc438b-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Target Date To
	public static By advancedSearchTargetFinishTo = By.xpath("//input[@id = \"mac635e1a-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Drill Date From
	public static By advancedSearchDrillDateFrom = By.xpath("//input[@id = \"mdb646e8c-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Drill Date To
	public static By advancedSearchDrillFinishTo = By.xpath("//input[@id = \"md8d7fe4c-tb\"]");
	//x-path for Drill Log - List - Advanced Search - Find Button
	public static By advancedSearchFindBtn = By.xpath("//button[@id = \"m4fd840b0-pb\"]");
	//x-path for Drill Log - List - Advanced Search - Restore Application Default Button
	public static By advancedSearchRestoreAppDefaultsBtn = By.xpath("//button[@id = \"mf29a24de-pb\"]");
	//x-path for Drill Log - List - Advanced Search - Revise Button
	public static By advancedSearchReviseBtn = By.xpath("//button[@id = \"mc3798131-pb\"]");
	//x-path for Drill Log - List - Advanced Search - Cancel Button
	public static By advancedSearchCancelBtn = By.xpath("//button[@id = \"ma1d6219c-pb\"]");	
	
	//x-path for save query
	public static By saveQueryText = By.xpath("//a[@id = \"m86d61073-tbb_text\"]");
	//x-path for Save Current Query - Query Name
	public static By saveQueryText_QueryName = By.xpath("//input[@id = \"m9c6963e4-tb\"]");
	//x-path for Save Current Query - Query Description
	public static By saveQueryText_QueryDescription = By.xpath("//input[@id = \"m9c6963e4-tb2\"]");
	//x-path for Save Current Query - Ok Button
	public static By saveQueryText_OkBtn = By.xpath("//button[@id = \"m9e2fddbd-pb\"]");
	
	//x-path for book-marks
	public static By bookmarksText = By.xpath("//a[@id = \"m81bbd46a-tbb_text\"]");
	//x-path for Drill Log filter button
	public static By drillLogFilterBtn = By.xpath("//span[@id = \"m6a7dfd2f-lb2\"]");
	//x-path for Drill Log Filter Search Button
	public static By drillLogSearchBtn = By.xpath("//img[@id = \"m6a7dfd2f-ti2_img\"]");
	//x-path for Drill Log Clear Filter Button
	public static By drillLogClearFilterBtn = By.xpath("//img[@id = \"m6a7dfd2f-ti3_img\"]");
	//x-path for Drill LOg Reload Filter Button
	public static By drillLogReloadBtn = By.xpath("//img[@id = \"m6a7dfd2f-img5\"]");
	//x-path for Drill Log filter field
	public static By listTabFilterDrillLogId = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");
	//x-path for Description filter field
	public static By listTabFilterDescription = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:2]_txt-tb\"]");
	//x-path for Drill filter field
	public static By listTabFilterDrill = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:3]_txt-tb\"]");
	//x-path for Drill filter Search Button
	public static By listTabFilterDrillSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:3]_txt-img\"]");
	//x-path for Location filter field
	public static By listTabFilterLocation = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:4]_txt-tb\"]");
	//x-path for Drill Log - List Tab - Location field Header
	public static By listTabFilterLocationHeader = By.xpath("//span[@id = \"m6a7dfd2f_ttrow_[C:4]_ttitle-lb\"]");
	//x-path for Drill Log - List Tab - Location field Sort Order
	public static By listTabFilterLocationSortOrder = By.xpath("//img[@id = \"m6a7dfd2f_ttrow_[C:4]_ttitle-si\"]");
	//x-path for Location filter search button
	public static By listTabFilterLocationSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:4]_txt-img\"]");	
	//x-path for POA filter field
	public static By listTabFilterPOA = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:5]_txt-tb\"]");
	//x-path for POA filter search button
	public static By listTabFilterPOASearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:5]_txt-img\"]");
	//x-path for Watch filter field
	public static By listTabFilterWatch = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:6]_txt-tb\"]");
	
	//x-path for Watch filter search button
//	public static By listTabFilterWatchSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:5]_txt-img\"]");

	//x-path for Route filter field
	public static By listTabRouteWatch = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:7]_txt-tb\"]");
	//x-path for Shift filter field
	public static By listTabFilterShift = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:8]_txt-tb\"]");
	//x-path for Shift filter search button
	public static By listTabFilterShiftSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:8]_txt-img\"]");
	//x-path for Department filter field
	public static By listTabFilterDepartment = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:9]_txt-tb\"]");
	//x-path for Department filter Search button
	public static By listTabFilterDepartmentSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:9]_txt-img\"]");
	//x-path for Target Date filter field
	public static By listTabFilterTrgtFinishDate = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:10]_txt-tb\"]");
	//x-path for Drill Log - List Tab - Target Finish Date field Header
	public static By listTabFilterTrgtFinishDateHeader = By.xpath("//span[@id = \"m6a7dfd2f_ttrow_[C:10]_ttitle-lb\"]");
	//x-path for Drill Date filter field
	public static By listTabFilterDrillDate = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:11]_txt-tb\"]");
	//x-path for Drill Log - List Tab - Drill Date field Header
	public static By listTabFilterDrillDateHeader = By.xpath("//span[@id = \"m6a7dfd2f_ttrow_[C:11]_ttitle-lb\"]");
	//x-path for Drill Log - List Tab - Drill Date field - Sort Order Tag
	public static By listTabFilterDrillDateSortOrder = By.xpath("//img[@id = \"m6a7dfd2f_ttrow_[C:11]_ttitle-si\"]");
	//x-path for Status filter field
	public static By listTabFilterStatus = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:12]_txt-tb\"]");
	//x-path for Status filter search button
	public static By listTabFilterStatusSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:12]_txt-img\"]");
	//x-path for Site filter field
	public static By listTabFilterSite = By.xpath("//input[@id = \"m6a7dfd2f_tfrow_[C:13]_txt-tb\"]");
	//x-path for Site filter search button
	public static By listTabFilterSiteSearch = By.xpath("//img[@id = \"m6a7dfd2f_tfrow_[C:13]_txt-img\"]");	
	//x-path for Drill Log - List Tab - Record Count
	public static By listTabRecordCount = By.xpath("//label[@id = \"m6a7dfd2f-lb3\"]");	
	//x-path for Drill Log - List Tab - First Record Status Value
	public static By listTab_FirstRecordStatus = By.xpath("//td[@id = \"m6a7dfd2f_tdrow_[C:12]-c[R:0]\"]");
	
		
	//x-path for Select Actions drop-down
	public static By listTabSelectActionsDropDown = By.xpath("//img[@id = \"toolbar2_tbs_1_tbcb_0_action-img\"]");	
	//x-path for Select Actions drop-down - Run Reports
	public static By listTabSelectActionsDropDownRunReports = By.xpath("//*[@id=\"m74daaf83_ns_menu_RUNREPORTS_OPTION_a_tnode\"]");//("//span[@id = \"menu0_RUNREPORTS_OPTION_a_tnode\"]");
	//x-path for Report and Schedules - Report - Drill Log List
	public static By reportAndSchedules_Report_DLList = By.xpath("//span[@id = \"m8a2afd5_tdrow_[C:0]_ttxt-lb[R:0]\"]");
	//x-path for Report and Schedules - Report - Drill Log Participants
	public static By reportAndSchedules_Report_DLParticipants = By.xpath("//span[@id = \"m8a2afd5_tdrow_[C:0]_ttxt-lb[R:1]\"]");
	//x-path for Report and Schedules - Report - Employee Drill Log Report
	public static By reportAndSchedules_Report_EmployeeDLReport = By.xpath("//span[@id = \"m8a2afd5_tdrow_[C:0]_ttxt-lb[R:2]\"]");
	//x-path for Report and Schedules - Create Report
	public static By reportAndSchedules_CreateReport = By.xpath("//button[@id = \"m205ddc3d-pb\"]");
	//x-path for Report and Schedules - Cancel Report button
	public static By reportAndSchedules_CancelReport = By.xpath("//button[@id = \"m575aecab-pb\"]");
	//x-path for Report and Schedules_Drill_Log_List - Cancel Report button
	public static By reportAndSchedules_Drill_Log_List_CancelReport = By.xpath("//*[@id=\"mef81eb6c-pb\"]");
	//x-path for Report and Schedules_Drill_Log_Paticipants - Cancel Report button
    public static By reportAndSchedules_Drill_Log_Participants_CancelReport = By.xpath("//*[@id=\"m2e0f34ac-pb\"]");
	
	
    
	
  
	//x-path for Employee Drill Log Report - Parameters - To Date
	public static By EmployeeDLReport_Param_ToDate = By.xpath("//input[@id = \"m2580bd3-tb\"]");	
	//x-path for Employee Drill Log Report - Parameters - Employee
	public static By EmployeeDLReport_Param_Employee = By.xpath("//input[@id = \"mca897cd3-tb\"]");
	//x-path for Employee Drill Log Report - Parameters - Employee_Email
	public static By EmployeeDLReport_Param_Employee_Email = By.xpath("//*[@id=\"m52950605-ti_img\"]");	
	//x-path for Employee Drill Log Report - Parameters - Employee_Email Text box
	public static By EmployeeDLReport_Param_Employee_Email_TextBox = By.xpath("//*[@id=\"m60f35a6b-tb\"]");
	
	
	//x-path for Employee Drill Log Report - Parameters - Schedule time
	public static By EmployeeDLReport_Param_Schedule_Time = By.xpath("//*[@id=\"m70a9948c-tb\"]");
	//x-path for Employee Drill Log Report - Parameters - Schedule At this TimeRadio button
	public static By EmployeeDLReport_Param_Schedule_At_This_Time = By.xpath("//*[@id=\"m5fd76c07-rb\"]");

	
	//x-path for Employee Drill Log Report - Parameters - From Date
	public static By EmployeeDLReport_Param_FromDate = By.xpath("//input[@id = \"m80dbae90-tb\"]");
	//x-path for Employee Drill Log Report - Schedule - Immediate
	public static By EmployeeDLReport_Schedule_Immediate = By.xpath("//input[@id = \"mb1d90d2b-rb\"]");
	//x-path for Employee Drill Log Report - Schedule - At this Time
	public static By EmployeeDLReport_Schedule_AtThisTime = By.xpath("//input[@id = \"m5fd76c07-rb\"]");
	//x-path for Employee Drill Log Report - Schedule - Recurring
	public static By EmployeeDLReport_Schedule_Recurring = By.xpath("//input[@id = \"mc6de3dbd-rb\"]");
	//x-path for Employee Drill Log Report - Submit Button
	public static By EmployeeDLReport_SubmitBtn = By.xpath("//button[@id = \"md67221eb-pb\"]");
	//x-path for Employee Drill Log Report - View Button
	public static By EmployeeDLReport_ViewBtn = By.xpath("//*[@id=\"ma6207f4-pb\"]");
	//x-path for Employee Drill Log Report - Ok Button
	public static By EmployeeDLReport_OkBtn = By.xpath("//*[@id=\"m781e8a81-pb\"]");
	
	
	
	
	
	
	
		
	//x-path for Drill Log List Report - Parameters - From Date
	public static By ReportDLList_Param_FromDate = By.xpath("//input[@id = \"m855c655d-tb\"]");
	//x-path for Drill Log List Report - Parameters - To Date
	public static By ReportDLList_Param_ToDate = By.xpath("//input[@id = \"md0d2c7a9-tb\"]");
	//x-path for Drill Log List Report - Schedule - Immediate
	public static By ReportDLList_Schedule_Immediate = By.xpath("//input[@id = \"maf103d98-rb\"]");
	//x-path for Drill Log List Report - Submit Button
	public static By ReportDLList_SubmitBtn = By.xpath("//button[@id = \"mc3f833d9-pb\"]");
	
	
	
//	//x-path for Employee Drill Log Report - Parameters - To Date
//	public static By EmployeeDLReport_Param_ToDate = By.xpath("");
//	//x-path for Employee Drill Log Report - Parameters - To Date
//	public static By EmployeeDLReport_Param_ToDate = By.xpath("");
//	//x-path for Employee Drill Log Report - Parameters - To Date
//	public static By EmployeeDLReport_Param_ToDate = By.xpath("");
		
	
	
	
	//x-path for New Drill Log Id field
	public static By drillLogId = By.xpath("//input[@id = \"mad3161b5-tb\"]");
	//x-path for New Drill Log Description field
	public static By drillLogDescription = By.xpath("//input[@id = \"mad3161b5-tb2\"]");
	//x-path for New Drill Log department field
	public static By drillLogDepartment = By.xpath("//input[@id = \"m557b9e5d-tb\"]");
	//x-path for New Drill Log Attachments section
//	public static By drillLogAttachments = By.xpath("//img[@id = \"md5bd66d5-ti_img\"]");
	//x-path for New Drill Log Location field
	public static By drillLogLocation = By.xpath("//input[@id = \"m7b0033b9-tb\"]");
	//x-path for New Drill Log location field search button
	public static By drillLogLocationSearch = By.xpath("//img[@id = \"m7b0033b9-img\"]");
	//x-path for New Drill Log location field search - Pop-up search window - Location field
	public static By drillLogLocationSearch_PopupLocation = By.xpath("//input[@id = \"lookup_page1_tfrow_[C:0]_txt-tb\"]");
	//x-path for New Drill Log location field search - Pop-up search window - Cancel Button
	public static By drillLogLocationSearch_CancelBtn = By.xpath("//button[@id = \"m507211d4-pb\"]");
	//x-path for New Drill Log location field search - Pop-up search window - Search Button
	public static By drillLogLocationSearch_SearchBtn = By.xpath("//img[@id = \"lookup_page1-ti2_img\"]");
	//x-path for New Drill Log location field search - Pop-up search window - Clear Button
	public static By drillLogLocationSearch_ClearBtn = By.xpath("//img[@id = \"lookup_page1-ti3_img\"]");	
	//x-path for New Drill Log location field search - Pop-up search window - Value Select
	public static By drillLogLocationSearch_ValueSelect = By.xpath("//span[@id = \"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");	
	//x-path for New Drill Log Watch field
	public static By drillLogWatch = By.xpath("//input[@id = \"mcc72cfe7-tb\"]");
	//x-path for New Drill Log Watch field search button
	public static By drillLogWatchSearch = By.xpath("//img[@id = \"mcc72cfe7-img\"]");
	//x-path for New Drill Log status field
	public static By drillLogstatus = By.xpath("//input[@id = \"md3801d08-tb\"]");
	//x-path for New Drill Log Route field
	public static By drillLogRoute = By.xpath("//input[@id = \"mbc183b68-tb\"]");
	//x-path for New Drill Log POA field
	public static By drillLogPOA = By.xpath("//input[@id = \"m25116ad2-tb\"]");	
	//x-path for New Drill Log Shift field
	public static By drillLogShift = By.xpath("//input[@id = \"m1a37b76f-tb\"]");
	//x-path for New Drill Log Shift field search button
	public static By drillLogShiftSearch = By.xpath("//img[@id = \"m1a37b76f-img\"]");
	//x-path for New Drill Log Drill Type field
	public static By drillLogDrillType = By.xpath("//input[@id = \"m4030e09b-tb\"]");
	//x-path for New Drill Log Drill Type field search button
	public static By drillLogDrillTypeSearch = By.xpath("//img[@id = \"m4030e09b-img\"]");
	//x-path for New Drill Log Target Finish Date field
	public static By drillLogTargetFinishDate = By.xpath("//input[@id = \"mfc15570a-tb\"]");
	//x-path for New Drill Log target finish date field date picker button
	public static By drillLogTargetFinishDatePicker = By.xpath("//img[@id = \"mfc15570a-img\"]");
	//x-path for New Drill Log Drill Date field
	public static By drillLogDrillDate = By.xpath("//input[@id = \"mfb789313-tb\"]");
	//x-path for New Drill Log Drill date field date picker button
	public static By drillLogDrillDatePicker = By.xpath("//img[@id = \"mfb789313-img\"]");
	//x-path for New Drill Log Supervisor field
	public static By drillLogSupervisor = By.xpath("//input[@id = \"mb2eb834-tb\"]");
	//x-path for New Drill Log Supervisor field picker button
	public static By drillLogSupervisorPicker = By.xpath("//img[@id = \"mb2eb834-img\"]");

	//x-path for New Drill Log - Complete - Ok button
	public static By drillLogCompleteOkBtn = By.xpath("//button[@id = \"m60bd6d91-pb\"]");
	
	//x-path for New Drill - Drill Participants - Filter text
	public static By filterDrillParticipantsText = By.xpath("//span[@id = \"m4dfd8aef-lb2\"]");
	//x-path for New Drill - Drill Participants - Filter - Name field
	public static By drillParticipantsFilterName = By.xpath("//input[@id = \"m4dfd8aef_tfrow_[C:1]_txt-tb\"]");
	//x-path for New Drill - Drill Participants - Filter Search button
	public static By drillParticipantsFilterSearch = By.xpath("//img[@id = \"m4dfd8aef-ti2_img\"]");
	//x-path for New Drill - Drill Participants - Filter Clear button
	public static By drillParticipantsFilterClear = By.xpath("//img[@id = \"m4dfd8aef-ti3_img\"]");
	//x-path for New Drill - Drill Participants - Select Participants button
	public static By drillParticipantsSelectParticipantsBtn = By.xpath("//button[@id = \"m4dfd8aef_bg_button_selectlaborondrill-pb\"]");
		//x-path for Select Participants pop-up - Name field
		public static By selectParticipants_NameFilter = By.xpath("//input[@id = \"m4352f762_tfrow_[C:2]_txt-tb\"]");
		//x-path for Select Participants pop-up - Search Button
		public static By selectParticipants_SearchBtn = By.xpath("//img[@id = \"m4352f762-ti2_img\"]");
		//x-path for Select Participants pop-up - Select All Users Check-box
		public static By selectParticipants_SelectAllCheckbox = By.xpath("//img[@id = \"m4352f762_ttrow_[C:0]_ttselallrows-ti_img\"]");
		//x-path for Select Participants pop-up - OK Button
		public static By selectParticipants_OkBtn = By.xpath("//button[@id = \"m5000dcb2-pb\"]");
		//xpath for Import Muster List
		public static By importMusterList = By.xpath("//*[@id=\"m4dfd8aef_bg_button_showmusterlist-pb\"]");
		//xpath for select all check box
	    public static By SelectAllCheckBox = By.xpath("//*[@id=\"mee8b2bb4_ttrow_[C:0]_ttselallrows-ti_img\"]");
	    //xpath for click ok
	    public static By selectCrewOk = By.xpath("//*[@id=\"mc479a47c-pb\"]");
	    boolean b = true;
		
		
		
		
		
		
		
	
	//x-path for New Drill - Drill Participants - import muster list button
	public static By drillParticipantsImportMusterListBtn = By.xpath("//button[@id = \"m4dfd8aef_bg_button_showmusterlist-pb\"]");
	//x-path for New Drill - Comments - Filter text
	public static By commentsFilterText = By.xpath("//span[@id = \"m524afe2e-lb2\"]");
	//x-path for New Drill - Comments - Filter Search button
	public static By commentsFilterSearch = By.xpath("//img[@id = \"m524afe2e-ti2_img\"]");
	//x-path for New Drill - Comments - Filter Clear button
	public static By commentsClearFilter = By.xpath("//img[@id = \"m524afe2e-ti3_img\"]");
	//x-path for New Drill - Comments - Filter - Recorded by field
	public static By commentsFilterRecordedBy = By.xpath("//input[@id = \"m524afe2e_tfrow_[C:1]_txt-tb\"]");
	//x-path for New Drill - Comments - Filter - Date field
	public static By commentsFilterDate = By.xpath("//input[@id = \"m524afe2e_tfrow_[C:2]_txt-tb\"]");
	//x-path for New Drill - Comments - Filter - Summary field
	public static By commentsFilterSummary = By.xpath("//input[@id = \"m524afe2e_tfrow_[C:3]_txt-tb\"]");
	//x-path for New Drill - Comments - Filter - Details field
	public static By commentsFilterDetails = By.xpath("//input[@id = \"m524afe2e_tfrow_[C:4]_txt-tb\"]");
	//x-path for New Drill - Comments - New Comments button
	public static By commentsNewCommentBtn = By.xpath("//button[@id = \"m524afe2e_bg_button_addrow-pb\"]");
	//x-path for New Drill - Comments - New Comments button
	public static By commentsNewCommentSummary = By.xpath("//input[@aria-labelledby=\"m524afe2e_ttrow_[C:3]-c\" and not(@aria-readonly=\"true\")]");
	//x-path for New Drill - Comments - New Comments button
	public static By commentsNewCommentDetails = By.xpath("//textarea[starts-with(@id, \"m524afe2e_tdrow_[C:4]_multilinetextbox-ta[R:\") and not(@aria-readonly=\"true\")]");
	//x-path for Related Records - Work Order ID
	public static By rrTabWorkOrder = By.xpath("//input[@id = \"maeb5b5db-tb\"]");
	//x-path for Related Records - Work Order Description
	public static By rrTabWorkOrderDescription = By.xpath("//input[@id = \"maeb5b5db-tb2\"]");
	//x-path for Drill Log - List - The very first record
	public static By listVeryFirstRecord = By.xpath("//span[@id = \"m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]\"]");
	//x-path for Drill Log - List - Attachments
//	public static By listAttachments = By.xpath("//*[@id=\"md5bd66d5-ti_img\"]");
	//x-path for Drill Log - List - Add new attachments
	public static By listAddNewAttachments = By.xpath("//*[text()=\'Add New Attachments\']");
	//x-path for Drill Log - List - Add new File
	public static By listAddNew = By.xpath("//*[@id=\"ATTACHMENTS_addnew_sub_addnewfile_a\"]/img");
		
	
	

		
		
		 
	 
	
	/**
	 * @Description: Verify the Drill Log (BCF) Page
	 * @throws Throwable
	 */
	public void verifyDrillLog_BCF(String actualpageTitle) throws Throwable {
		try {

			assertTitle(actualpageTitle);
			isElementPresent(newDrillLog, "New Drill Log button");
			isElementPresent(saveDrillLog, "Save Drill Log button");
			isElementPresent(previousDrillLog, "Previous Drill Log button");
			isElementPresent(nextDrillLog, "Next Drill Log button");
			
			SuccessReportWithScreenshot("Successfully Navigated to Drill Log (BCF) Page");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * @Description: Click on New Drill Log button
	 * @throws Throwable
	 */
	public void NewDrillLog_CLick() throws Throwable {
		try {

//			isElementPresent(newDrillLog, "New Drill Log");
			click(newDrillLog, "New Drill Log");
			implicityWait(25);//drillLogDescription);
			SuccessReportWithScreenshot("New Drill Log record opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Click on Complete Drill Log button
	 * @throws Throwable
	 */
	public void CompleteDrillLog_CLick() throws Throwable {
		try {

//			isElementPresent(completeDrillLog, "Complete Drill Log");
			implicityWait(6);
			click(completeDrillLog, "Complete Drill Log");	
			implicityWait(2);
			SuccessReportWithScreenshot("Complete Drill Log button clicked Successfully");
//			isElementPresent(completeDrillLog_OkBtn, "Complete Drill Log - OK");
			
			//explicityWait(completeDrillLog_OkBtn);
			
			click(completeDrillLog_OkBtn, "Complete Drill Log - OK");
			implicityWait(40);
			//explicityWait(completeDrillLog);
			
			SuccessReportWithScreenshot("Drill Record Updated Successfully Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	/**
	 * @Description: Click on Complete Drill Log button gtom List Tab
	 * @throws Throwable
	 */
	public void CompleteDrillLog_ListTab_CLick() throws Throwable {
		try {

//			isElementPresent(completeDrillLog, "Complete Drill Log");
			click(completeDrillLog, "Complete Drill Log");
			implicityWait(1);
			SuccessReportWithScreenshot("Complete Drill Log button clicked Successfully");
//			isElementPresent(completeDrillLog_OkBtn, "Complete Drill Log - OK");
			implicityWait(3);
			//explicityWait(completeDrillLog_ListTab_OkBtn);
			
			click(completeDrillLog_ListTab_OkBtn, "OK");
			implicityWait(3);
			//explicityWait(completeDrillLog);
			
			SuccessReportWithScreenshot("Drill Record Updated Successfully Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/* @Description: Click on Save Drill Log button
	 * @throws Throwable
	 */
	public void SaveDrillLog_CLick() throws Throwable {
		try {

//			implicityWait(15);
//			isElementPresent(saveDrillLog, "Save Drill Log");
			implicityWait(3);
			click(saveDrillLog, "Save Drill Log");
			implicityWait(80);
			//explicityWait_ElementInvisible(saveDrillLog);
//			explicityWait(drillLogDescription);
			
			SuccessReportWithScreenshot("Successfully Saved a Drill Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Click on Clear Drill Log button
	 * @throws Throwable
	 */
	public void ClearDrillLog_CLick() throws Throwable {
		try {

//			isElementPresent(clearChanges, "Clear Drill Log");
			click(clearChanges, "Clear Drill Log");
			
			SuccessReportWithScreenshot("Successfully cleared content in Drill Log Page");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Click on Refresh/Reload Drill Log list button
	 * @throws Throwable
	 */
	public void ReloadDrillLog_CLick() throws Throwable {
		try {

			click(drillLogReloadBtn, "Reload Drill Log");
			implicityWait(10);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Click on Filter Drill Log list button
	 * @throws Throwable
	 */
	public void DrillLog_Filter_CLick() throws Throwable {
		try {
			implicityWait(2);
			click(drillLogSearchBtn, "Filter");
			//explicityWait_ElementVisible(drillLogClearFilterBtn);	
			implicityWait(15);
			SuccessReportWithScreenshot("Successfully Entered data for New Drill Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Click on Drill Log - List Tab
	 * @throws Throwable
	 */
	public void DrillLog_ListTab_CLick() throws Throwable {
		try {
			
			//explicityWait(listTab);
			implicityWait(3);
			click(listTab, "List Tab");
			implicityWait(2);
			//explicityWait(drillLogDescription);
//			implicityWait(15);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
			
	
//	
//	/**
//	 * @Description: Enter values for a Drill Log
//	 * @throws Throwable
//	 */
//	public void EnterValuesforDrillLog(String dl_Description, String dl_Department, String dl_Location, 
//			String dl_Watch, String dl_Shift, String dl_DrillType, String dl_DrillDate, String dl_POA,
//			String dl_Route) throws Throwable {
//		try {
//
////			isElementPresent(drillLogDescription, "Drill Log - Description");
////			isElementPresent(drillLogDepartment, "Drill Log - Department");
////			isElementPresent(drillLogLocation, "Drill Log - Location");
////			isElementPresent(drillLogWatch, "Drill Log - Watch");
////			isElementPresent(drillLogShift, "Drill Log - Shift");
////			isElementPresent(drillLogDrillType, "Drill Log - Drill Type");
////			isElementPresent(drillLogDrillDate, "Drill Log - Drill Date");
////			isElementPresent(drillLogPOA, "Drill Log - POA");
////			isElementPresent(drillLogRoute, "Drill Log - Route");
//			
//			click(drillLogDescription, "Click Description");
//			implicityWait(2);
//			clear(drillLogDescription);	
//			type(drillLogDescription, dl_Description, "Description");
//			
//			click(drillLogDepartment, "Click Department");
//			implicityWait(2);
//			clear(drillLogDepartment);	
//			type(drillLogDepartment, dl_Department, "Department");
//			
//			click(drillLogLocationSearch, "Click Location Search");
//			implicityWait(2);
//			clear(drillLogLocationSearch_PopupLocation);	
//			type(drillLogLocationSearch_PopupLocation, dl_Location, "Location");
//			click(drillLogLocationSearch_SearchBtn, "Click Location Search");
//			implicityWait(2);
//			click(drillLogLocationSearch_ValueSelect, "Select Location");
//			implicityWait(3);
//			
//			click(drillLogWatch, "Click Watch");
//			implicityWait(1);
//			clear(drillLogWatch);	
//			type(drillLogWatch, dl_Watch, "Watch");
//			
//			click(drillLogPOA, "Click POA");
//			implicityWait(1);
//			clear(drillLogPOA);	
//			type(drillLogPOA, dl_POA, "POA");
//			
////			click(drillLogRoute, "Click Route");
//			implicityWait(1);
//			clear(drillLogRoute);	
//			type(drillLogRoute, dl_Route, "Route");
//			
////			click(drillLogShift, "Click Shift");
//			implicityWait(1);
//			clear(drillLogShift);	
//			type(drillLogShift, dl_Shift, "Shift");
//			
////			click(drillLogDrillType, "Click Drill Type");
//			implicityWait(1);
//			clear(drillLogDrillType);	
//			type(drillLogDrillType, dl_DrillType, "Drill Type");
//			
////			click(drillLogDrillDate, "Click Drill Date");
//			implicityWait(1);
//			clear(drillLogDrillDate);	
//			type(drillLogDrillDate, dl_DrillDate, "Drill Date");
//			
//			
//			SuccessReportWithScreenshot("Successfully Entered data for New Drill Log");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	/**
	 * @Description: Enter values for a Drill Log
	 * @throws Throwable
	 */
	public void EnterValuesforDrillLog(String dl_Description, String dl_Department, String dl_Location, 
			String dl_Watch, String dl_Shift, String dl_DrillType, String dl_DrillDate, String dl_POA,
			String dl_Route) throws Throwable {
		try {
		//isElementPresent(drillLogRoute, "Drill Log - Route");
			
			implicityWait(10);
			click(drillLogDescription, "Click Description");
			implicityWait(2);
			clear(drillLogDescription);	
			implicityWait(1);
			type(drillLogDescription, dl_Description, "Description");

			implicityWait(2);
			click(drillLogDepartment, "Click Department");
			implicityWait(2);
			clear(drillLogDepartment);	
			type(drillLogDepartment, dl_Department, "Department");

			implicityWait(2);
			click(drillLogLocationSearch, "Click Location Search");
			implicityWait(3);
			clear(drillLogLocationSearch_PopupLocation);	
			type(drillLogLocationSearch_PopupLocation, dl_Location, "Location");
			click(drillLogLocationSearch_SearchBtn, "Click Location Search");
			implicityWait(3);		
			click(drillLogLocationSearch_ValueSelect, "Select Location");
			implicityWait(5);			
			click(drillLogPOA, "Click POA");
			implicityWait(2);
//			clear(drillLogPOA);	
			type(drillLogPOA, dl_POA, "POA");
			implicityWait(2);
			
			click(drillLogWatch, "Click Watch");
			implicityWait(2);
//			clear(drillLogWatch);	
			type(drillLogWatch, dl_Watch, "Watch");
			implicityWait(2);
			
//			click(drillLogRoute, "Click Route");
			clear(drillLogRoute);	
			type(drillLogRoute, dl_Route, "Route");
			implicityWait(2);	
			
//			click(drillLogDrillType, "Click Drill Type");
			clear(drillLogDrillType);	
			type(drillLogDrillType, dl_DrillType, "Drill Type");
			implicityWait(2);
			
//			click(drillLogDrillDate, "Click Drill Date");
			clear(drillLogDrillDate);	
			type(drillLogDrillDate, dl_DrillDate, "Drill Date");
			implicityWait(5);
			
//			System.out.println("dl_Shift" + dl_Shift);
			click(drillLogShift, "Click Shift");
			implicityWait(2);			
			clear(drillLogShift);	
			type(drillLogShift, dl_Shift, "Shift");
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Entered data for New Drill Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	
	
	/* @Description: Filter records on Drill Date field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_DrillDate_Filter(String dl_DrillDateFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterDrillDate, "Drill Date");
			clear(listTabFilterDrillDate);	
			type(listTabFilterDrillDate, dl_DrillDateFilter, "Drill Date Filter");
			click(drillLogSearchBtn, "Drill Date Search");
			implicityWait(20);
//			explicityWait(listTabFilterDrillDate);
			
//			implicityWait(25);
			
			SuccessReportWithScreenshot("List filtered by Drill Date");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Filter records on Status field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Status_Filter(String dl_StatusFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterStatus, "Drill Date");
			clear(listTabFilterStatus);	
			type(listTabFilterStatus, dl_StatusFilter, "Status Filter");
			click(drillLogSearchBtn, "Status Search");
			
			//explicityWait(listTabFilterStatus);
			implicityWait(100);
			
			SuccessReportWithScreenshot("List filtered by Status");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Filter records on Target Finish Date field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_TargetFinishDate_Filter(String dl_TargetFinishDateFilter) throws Throwable {
		try {
			implicityWait(6);
			clear(listTabFilterTrgtFinishDate);	
			type(listTabFilterTrgtFinishDate, dl_TargetFinishDateFilter, "Target Finish Date Filter");
			click(drillLogSearchBtn, "Target Finish Date Search");
			
			implicityWait(40);//(listTabFilterTrgtFinishDate);
			
			SuccessReportWithScreenshot("List filtered by Target Finish Date");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/* @Description: Filter records on Location field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Location_Filter(String dl_LocationFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterLocation, "Location");
			clear(listTabFilterLocation);	
			type(listTabFilterLocation, dl_LocationFilter, "Location Filter");
			click(drillLogSearchBtn, "Location Search");
			implicityWait(30);
			
//			explicityWait(listTabFilterLocation);
			
//			implicityWait(25);
			
			SuccessReportWithScreenshot("List filtered by Location");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Filter records on Drill ID field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_DrillID_Filter(String dl_DrillIDFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterDrillLogId, "Drill ID");
			clear(listTabFilterDrillLogId);	
			type(listTabFilterDrillLogId, dl_DrillIDFilter, "Drill ID Filter");
			click(drillLogSearchBtn, "Drill ID Search");
			implicityWait(17);
			
			//explicityWait_ElementVisible(listTabFilterDrillLogId);
//			implicityWait(25);
			
			SuccessReportWithScreenshot("List filtered by Drill ID");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public boolean DrillLog_ListPage_Verify_Drill_Log_Status(String text, String locatorName) throws Throwable {
		boolean flag = false;

		try {

			String vtxt = getText(listTab_FirstRecordStatus,locatorName);
			vtxt.trim().equals(text.trim());
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (!flag) {
				failureReport("VerifyText :: ", text + ", is not present in the location ---> " + locatorName);
				flag = true;
			} else if (b && flag) {
				SuccessReport("VerifyText :: ", text + ", is present in the location ---> " + locatorName);
				flag = false;
			}
		}
	}
	

	/* @Description: Filter records on Description field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Description_Filter(String dl_DescriptionFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterDescription, "Description");
			clear(listTabFilterDescription);	
			type(listTabFilterDescription, dl_DescriptionFilter, "Description Filter");
			click(drillLogSearchBtn, "Search");
			implicityWait(120);
			
//			explicityWait(drillLogSearchBtn);
			
			SuccessReportWithScreenshot("List filtered by Description");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Filter records on Department field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Department_Filter(String dl_DepartmentFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterDepartment, "Department");
			clear(listTabFilterDepartment);	
			type(listTabFilterDepartment, dl_DepartmentFilter, "Department Filter");
			click(drillLogSearchBtn, "Department Search");
			implicityWait(90);
						
//			explicityWait(listTabFilterDepartment);
			
//			implicityWait(25);
			
			SuccessReportWithScreenshot("List filtered by Department");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Filter records using Advanced Search - Drill field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_AdvancedSearch_DrillType(String dl_DrillTypeFilter) throws Throwable {
		try {
			
			click(advancedSearchText, "Advanced Search");
			implicityWait(2);
			
//			explicityWait(advancedSearchRestoreAppDefaultsBtn);
			
			click(advancedSearchRestoreAppDefaultsBtn, "Restore Application Defaults");
			implicityWait(2);
			
//			explicityWait(advancedSearchDrill);
			
//			isElementPresent(advancedSearchDrill, "Drill Type");
			clear(advancedSearchDrill);	
			type(advancedSearchDrill, dl_DrillTypeFilter, "Drill Type Filter");
			click(advancedSearchFindBtn, "Find");
			implicityWait(30);
			
//			explicityWait(listTabFilterDescription);

//			implicityWait(25);
			
			SuccessReportWithScreenshot("List filtered by Drill Type");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Filter records using Advanced Search - Status in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_AdvancedSearch_Status(String dl_StatusFilter) throws Throwable {
		try {
			
			click(advancedSearchText, "Advanced Search");
			implicityWait(2);
			
//			explicityWait(advancedSearchRestoreAppDefaultsBtn);
			
			click(advancedSearchRestoreAppDefaultsBtn, "Restore Application Defaults");
			implicityWait(3);
			
//			explicityWait(advancedSearchStatus);
			
//			isElementPresent(advancedSearchStatus, "Status");
			clear(advancedSearchStatus);	
			type(advancedSearchStatus, dl_StatusFilter, "Status");
			implicityWait(2);
			
//			explicityWait(advancedSearchFindBtn);
			click(advancedSearchFindBtn, "Find");
			implicityWait(80);
			
//			explicityWait(listTabFilterDescription);
			
//			implicityWait(25);
			
			SuccessReportWithScreenshot("List filtered by Status");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/* @Description: Filter records on Drill Type field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_DrillType_Filter(String dl_DrillTypeFilter) throws Throwable {
		try {

//			isElementPresent(listTabFilterDrill, "Drill Type");
			clear(listTabFilterDrill);	
			type(listTabFilterDrill, dl_DrillTypeFilter, "Drill Type Filter");
			click(drillLogSearchBtn, "Drill Type Search");
			implicityWait(120);
			
//			explicityWait(listTabFilterDrill);
			
			SuccessReportWithScreenshot("List filtered by Drill Type");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/* @Description: Sort records by Ascending Order on Drill Date field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_DrillDate_SortAscending() throws Throwable {
		try {

//			isElementPresent(listTabFilterDrillDateHeader, "Drill Date Header");
			click(listTabFilterDrillDateHeader, "Drill Date Header");
			implicityWait(10);
			
//			implicityWait(5);
			
			SuccessReportWithScreenshot("List Sorted by Ascending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Sort records by Ascending Order and then Descending Order
	 * on Drill Date field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_DrillDate_SortAscDescending() throws Throwable {
		try {

			click(listTabFilterDrillDateHeader, "Drill Date Header");
			implicityWait(10);
			
//			implicityWait(5);
			
			SuccessReportWithScreenshot("List Sorted by Descending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Sort records by Descending Order on Drill Date field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_DrillDate_SortDescending() throws Throwable {
		try {

//			isElementPresent(listTabFilterDrillDateHeader, "Drill Date Header");
			click(listTabFilterDrillDateHeader, "Drill Date Header");
			implicityWait(20);
			
			click(listTabFilterDrillDateHeader, "Drill Date Header");
			implicityWait(10);
			
			SuccessReportWithScreenshot("List Sorted by Descending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Sort records by Descending Order on Drill Date field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_TargetFinishDate_SortDescending() throws Throwable {
		try {

//			isElementPresent(listTabFilterTrgtFinishDateHeader, "Target Finish Date Header");
			click(listTabFilterTrgtFinishDateHeader, "Target Finish Date Header");
			implicityWait(10);
			
			click(listTabFilterTrgtFinishDateHeader, "Target Finish Date Header");
			implicityWait(10);
			
			SuccessReportWithScreenshot("List Sorted by Descending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Sort records by Ascending Order on Location field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Location_SortAscending() throws Throwable {
		try {

//			isElementPresent(listTabFilterLocationHeader, "Location Header");
			implicityWait(5);
			click(listTabFilterLocationHeader, "Location Header");			
			implicityWait(20);
			
//			implicityWait(5);
			
			SuccessReportWithScreenshot("List Sorted by Ascending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Sort records by Ascending Order and then Descending Order
	 * on Location field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Location_SortAscDescending() throws Throwable {
		try {

			click(listTabFilterLocationHeader, "Location Header");
			implicityWait(20);
			
//			implicityWait(5);
			
			SuccessReportWithScreenshot("List Sorted by Descending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Sort records by Descending Order on Location field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_Location_SortDescending() throws Throwable {
		try {

//			isElementPresent(listTabFilterLocationHeader, "Location Header");
			click(listTabFilterLocationHeader, "Location Header");
			
//			implicityWait(5);
			
			click(listTabFilterLocationHeader, "Location Header");
			
//			implicityWait(5);
			
			SuccessReportWithScreenshot("List Sorted by Descending Order");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Read the count of records in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_RecordCount() throws Throwable {
		try {
			
			//explicityWait_ElementVisible(listTabRecordCount);
//			isElementPresent(listTabRecordCount, "Location Header");
			SuccessReportWithScreenshot(getXPathValue(listTabRecordCount));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Clear the filters in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_ClearFilters() throws Throwable {
		try {

//			click(drillLogSearchBtn, "Drill Type Search");
//			implicityWait(30);
			click(drillLogClearFilterBtn, "Clear Filters");
			implicityWait(3);
			
//			explicityWait(drillLogSearchBtn);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Filter records on Status field in List Page
	 * @throws Throwable
	 */
	public void DrillLog_ListPage_ClickFirstRecord() throws Throwable {
		try {

//			isElementPresent(listVeryFirstRecord, "First Record");
			click(listVeryFirstRecord, "First Record Clicked");
			implicityWait(3);
			//explicityWait(drillLogDescription);
			
			SuccessReportWithScreenshot("First Record Opened");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/* @Description: Update Drill Record for OWL_237
	 * @throws Throwable
	 */
	public void DrillLog_UpdateDrillRecord_OWL_237(String dl_Department, String dl_Watch, 
			String dl_Shift) throws Throwable {
		try {

//			isElementPresent(drillLogDepartment, "Department");
//			isElementPresent(drillLogWatch, "Watch");
//			isElementPresent(drillLogShift, "Shift");
			
			click(drillLogDepartment, "Department");
			implicityWait(1);
			clear(drillLogDepartment);	
			type(drillLogDepartment, dl_Department, "Department");
			
//			click(drillLogWatch, "Watch");
//			implicityWait(1);
			clear(drillLogWatch);	
			type(drillLogWatch, dl_Watch, "Watch");
			
			click(drillLogShift, "Click Shift");
			implicityWait(1);
			clear(drillLogShift);	
			type(drillLogShift, dl_Shift, "Shift");
			
//			click(drillLogDrillDate, "Drill Date");
//			implicityWait(1);
			
			String date = sendKeys_CtrlC(drillLogDrillDate);
			String format = "dd/MMM/yyyy hh:mm a";
			SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
			java.text.DateFormat df = new java.text.SimpleDateFormat(format);
		    java.util.Calendar calendar = java.util.Calendar.getInstance();
		    
		    calendar.setTime(df.parse(date));
	        calendar.add(java.util.Calendar.DAY_OF_MONTH, -1);
	        String formatted = simpleFormat.format(calendar.getTime());        
			
			click(drillLogDrillDate, "Click Drill Date");
			implicityWait(1);
			clear(drillLogDrillDate);	
			type(drillLogDrillDate, formatted, "Drill Date");
			

			SuccessReportWithScreenshot("Drill Log Record Updated");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/* @Description: Read and return Drill ID of a Drill Record
	 * @throws Throwable
	 */
	public String DrillLog_ReadReturnDrillID() throws Throwable {
		String drillIdStr = "";
		try {

//			isElementPresent(drillLogId, "Drill ID");
			
			drillIdStr = getXPathAttribute(drillLogId, "value");			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drillIdStr;
	}
	
	
	
	/* @Description: Add the comments for the Drill Record
	 * @throws Throwable
	 */
	public void DrillLog_AddComments(String newCommentsDetails_str, String newCommentsSummary_str) throws Throwable {
		try {

//			isElementPresent(commentsNewCommentBtn, "New Comment Button");
			click(commentsNewCommentBtn, "New Comment Button");
			implicityWait(3);
			
			click(commentsNewCommentDetails, "Comment Details");
			implicityWait(2);
			clear(commentsNewCommentDetails);	
			type(commentsNewCommentDetails, newCommentsDetails_str, "Comment Details");
			
			click(commentsNewCommentSummary, "Comment Summary");
			implicityWait(2);
			clear(commentsNewCommentSummary);	
			type(commentsNewCommentSummary, newCommentsSummary_str, "Comment Summary");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Click on Complete Drill Log button in the Drill Log Record
	 * @throws Throwable
	 */
	public void DrillLog_CompleteDrillLog_CLick() throws Throwable {
		try {

//			isElementPresent(completeDrillLog, "Complete Drill Log");
			click(completeDrillLog, "Complete Drill Log");	
			implicityWait(2);
//			isElementPresent(drillLogCompleteOkBtn, "Complete Drill Log - Ok Button");
			click(drillLogCompleteOkBtn, "Complete Drill Log - Ok Button");
			implicityWait(5);
			//explicityWait(drillLogDescription);
//			implicityWait(15);
			
			SuccessReportWithScreenshot("Complete Drill Log button clicked Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description: Check and assert the value of the Drill Record Status
	 * @throws Throwable
	 */
	public void DrillLog_AssertStatus(String expValue) throws Throwable {
		try {

			assertTextPresent(expValue);
			SuccessReportWithScreenshot("Asserted Staus value to Completed Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	/**
//	 * @Description: Launch Run Report popup from Drill Log Module
//	 * @throws Throwable
//	 */
//	public void RunReport_Execute() throws Throwable {
//		try {
//
//			
////			isElementPresent(listTabSelectActionsDropDown, "Select Actions");
//			click(listTabSelectActionsDropDown, "Select Actions");	
//			implicityWait(2);
//			click(listTabSelectActionsDropDownRunReports, "Run Reports");
//			implicityWait(2);
////			implicityWait(5);
//			
//			SuccessReportWithScreenshot("Run Report Clicked Successfully");
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
	public void RunReport_Execute() throws Throwable {
		try {

			click(listTabSelectActionsDropDownRunReports, "Run Reports");
			implicityWait(2);
//			implicityWait(5);
			
			SuccessReportWithScreenshot("Run Report Clicked Successfully");

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

//			isElementPresent(reportAndSchedules_CancelReport, "Cancel");
			click(reportAndSchedules_CancelReport, "Cancel");
			implicityWait(7);
//			implicityWait(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Launch Employee Drill Log Report
	 * @throws Throwable
	 */
	public void RunReport_Click_EmployeeDrillLog() throws Throwable {
		try {

			
//			isElementPresent(reportAndSchedules_Report_EmployeeDLReport, "Employee Drill Log Report");
			click(reportAndSchedules_Report_EmployeeDLReport, "Employee Drill Log Report");		
			implicityWait(2);
//			implicityWait(5);		
			
			SuccessReportWithScreenshot("Employee Drill Log Report Clicked Successfully");
			
//			implicityWait(20);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Launch Drill Log List Report
	 * @throws Throwable
	 */
	public void RunReport_Click_DrillLogList() throws Throwable {
		try {
			
//			isElementPresent(reportAndSchedules_Report_DLList, "Drill Log List");
			click(reportAndSchedules_Report_DLList, "Drill Log List");		
			implicityWait(2);
//			implicityWait(5);		
			
			SuccessReportWithScreenshot("Drill Log List Clicked Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * @Description: Employee Drill Log Report - Execute with Parameter
     * @throws Throwable
     */
     public String RunReport_Enter_ParamAndSchedule(String p_Employee) throws Throwable {
            String daysFromLastDrill = "";
            try {

                   
//                isElementPresent(EmployeeDLReport_Param_Employee, "Employee");
                   clear(EmployeeDLReport_Param_Employee); 
                   type(EmployeeDLReport_Param_Employee, p_Employee, "Employee");
                   click(EmployeeDLReport_Schedule_Immediate, "Immediate");
                   implicityWait(2);
                   click(EmployeeDLReport_SubmitBtn, "Submit");         
                   implicityWait(2);
//                implicityWait(15);  
                   switchNewChromeTab();
                   implicityWait(15);
                   
                   SuccessReportWithScreenshot("Employee Drill Log Report Created Successfully");
                   
                   daysFromLastDrill = getXPathValue(com.Pages.BRT_ReportViewer.bRTReport_DaysFromLastDrill);         
                   closeChromeTab();

            } catch (Exception e) {
                   e.printStackTrace();
            }
            
            return daysFromLastDrill;
     }
     

	
	/**
	 * @Description: Employee Drill Log Report - Execute with Parameter
	 * @throws Throwable
	 */
	public String RunReport_Enter_ParamAndSchedules(String p_Employee,String email,String ScheduleTime) throws Throwable {
		String daysFromLastDrill = "";
		try {

			
//			isElementPresent(EmployeeDLReport_Param_Employee, "Employee");
			clear(EmployeeDLReport_Param_Employee);	
			type(EmployeeDLReport_Param_Employee, p_Employee, "Employee");
//			click(EmployeeDLReport_Schedule_Immediate, "Immediate");
//			implicityWait(2);
			click(EmployeeDLReport_Param_Schedule_At_This_Time,"Schedule At this Time");
			implicityWait(2);
			clear(EmployeeDLReport_Param_Schedule_Time);
			type(EmployeeDLReport_Param_Schedule_Time, ScheduleTime, "Schedule Time");
//			implicityWait(2);
//			click(EmployeeDLReport_Param_Employee_Email, "Email Button");
			implicityWait(5);
			clear(EmployeeDLReport_Param_Employee_Email_TextBox);
			type(EmployeeDLReport_Param_Employee_Email_TextBox, email, "Email");			
			click(EmployeeDLReport_SubmitBtn, "Submit");		
			implicityWait(2);
			click(EmployeeDLReport_ViewBtn, "View");
			implicityWait(2);
			click(EmployeeDLReport_OkBtn, "Ok");
            SuccessReportWithScreenshot("Employee Drill Log Report Created and has been sent to email Successfully");
	

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return daysFromLastDrill;
	}
	
	
	/**
	 * @Description: Drill Log List - Execute with Parameter
	 * @throws Throwable
	 */
	public void RunReport_Enter_DrillLogList_ParamAndSchedule(String p_FromDate, String p_ToDate) throws Throwable {
		try {

			
//			isElementPresent(ReportDLList_Param_FromDate, "From Date");
			clear(ReportDLList_Param_FromDate);	
			type(ReportDLList_Param_FromDate, p_FromDate, "From Date");
//			isElementPresent(ReportDLList_Param_ToDate, "To Date");
			clear(ReportDLList_Param_ToDate);	
			type(ReportDLList_Param_ToDate, p_ToDate, "To Date");
			click(ReportDLList_Schedule_Immediate, "Immediate");
			implicityWait(2);
			click(ReportDLList_SubmitBtn, "Submit");
			implicityWait(2);
			
//			implicityWait(15);	
			switchNewChromeTab();
			implicityWait(15);
			
			SuccessReportWithScreenshot("Drill Log List Report Created Successfully");
			
			closeChromeTab();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Drill Log Initialize
	 * @throws Throwable
	 */
	public void drillLogInit(String userNameString, String passwordString) throws Throwable {
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
			// This Method is used to navigate to "Drill Log" in the Applications
			StartCenter.navigateToDrillLog();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Save a Query
	 * @throws Throwable
	 */
	public void drillLogSaveQuery(String dl_QueryName, String dl_QueryDescription) throws Throwable {
		try {
			implicityWait(5);
			click(saveQueryText, "Save Query");
			implicityWait(5);
			//explicityWait(saveQueryText_QueryName);
			
			SuccessReportWithScreenshot("Successfully clicked Save Query");			
			
			type(saveQueryText_QueryName, dl_QueryName);
			type(saveQueryText_QueryDescription, dl_QueryDescription);
			click(saveQueryText_OkBtn, "OK");
			implicityWait(2);
			
			//explicityWait(saveQueryText);
			
			SuccessReportWithScreenshot("Successfully Saved Query");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Drill Log - Add Participants using Name Filter
	 * @throws Throwable
	 */
	public void drillLogAddParticipants_NameFilter(String dl_ParticipantFilter) throws Throwable {
		try {
			
			implicityWait(5);
			click(drillParticipantsSelectParticipantsBtn, "Select Participants");
			implicityWait(10);
			
			click(selectParticipants_NameFilter, "Name");
			implicityWait(2);
			
			clear(selectParticipants_NameFilter);
			type(selectParticipants_NameFilter, dl_ParticipantFilter);
			
			click(selectParticipants_SearchBtn, "Search");
			implicityWait(15);
			//explicityWait_ElementVisible(selectParticipants_SelectAllCheckbox);
			
			click(selectParticipants_SelectAllCheckbox, "Select All");			
			implicityWait(10);
			
			click(selectParticipants_OkBtn, "OK");
			implicityWait(5);
			
			SuccessReportWithScreenshot("Successfully Entered Drill Log Participants");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void RunReport_Click_DrillLogParticipants() throws Throwable {
		try {
			
//			isElementPresent(reportAndSchedules_Report_DLList, "Drill Log List");
			click(reportAndSchedules_Report_DLParticipants, "Drill Log Participants");		
			implicityWait(2);
//			implicityWait(5);		
			
			SuccessReportWithScreenshot("Drill Log Participants Clicked Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void click_CompleteDrillLog() throws Throwable {
		try {

//			isElementPresent(completeDrillLog, "Complete Drill Log");
			click(completeDrillLog, "Complete Drill Log");			
			SuccessReportWithScreenshot("Complete Drill Log button clicked Successfully");
//			isElementPresent(completeDrillLog_OkBtn, "Complete Drill Log - OK");
			 WebElement ele = driver.findElement(By.xpath("//*[@id=\"mca62da72-longop_image\"]"));
			 
			 if(ele.isDisplayed()) {
				 
				 explicityWait_ElementVisible(spinnerImage);
					explicityWait_ElementInvisible(spinnerImage);
					//explicityWait(completeDrillLog_OkBtn);		
					click(completeDrillLog_OkBtn, "Complete Drill Log - OK");	
					explicityWait(completeDrillLog);	
					SuccessReportWithScreenshot("Drill Record Updated Successfully Successfully");	 
				 
			 }
			 else {
				 isElementPresent(completeDrillLog, "Complete Drill Log");			
					explicityWait(completeDrillLog_OkBtn);
					click(completeDrillLog_OkBtn, "Complete Drill Log - OK");		
					explicityWait(completeDrillLog);		
					SuccessReportWithScreenshot("Drill Record Updated Successfully Successfully");
				 				 
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void RunReport_Drill_Log_List_ClickCancel() throws Throwable {
		try {
			click(reportAndSchedules_Drill_Log_List_CancelReport, "Cancel");
			implicityWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void RunReport_Drill_Log_Participants_ClickCancel() throws Throwable {
		try {
			click(reportAndSchedules_Drill_Log_Participants_CancelReport, "Cancel");
			implicityWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void drillLogAddParticipants_Imort_Muster_List() throws Throwable {
		try {

			click(importMusterList, "Import Muster List");
			implicityWait(2);
			click(SelectAllCheckBox, "SelectAll");	
			implicityWait(2);	
			click(selectCrewOk, "OK");
			implicityWait(10);
			
			SuccessReportWithScreenshot("Successfully selected Labor");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
//	public void drillLogAttachNewAttachments() throws Throwable {
//		try {
//
//			click(listAttachments, "Attachments");
//			implicityWait(2);
//			click(listAddNewAttachments, "New Attachments");	
//			implicityWait(2);
//			mouseHoverByJavaScript(listAddNew, "New File");
//			implicityWait(2);
//			click(listAddNew,"New File");
//			implicityWait(10);
//			WebElement element =driver.findElement(By.id("file"));
//			System.out.println(element);
//			element.sendKeys("C:\\Users\\sadapa\\Desktop\\u.txt");
//	        implicityWait(2);
//	        
//	        
//	        
//			SuccessReportWithScreenshot("Successfully file has been uploaded");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
}
