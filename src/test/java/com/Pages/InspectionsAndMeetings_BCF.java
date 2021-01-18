
/**
 * @Satish Kumar A
 * @Date April 20, 2020
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

public class InspectionsAndMeetings_BCF extends ActionEngine {

	// Xpath for Inspection and Meeting(BCF)-->List Tab
	public static By ListTab = By.xpath("//*[@id=\"m9fa3e414-tab_anchor\"]");

	// Xpath for Inspection and Meeting(BCF)--> Inspection and Meeting Tab
	public static By InsMeetTab = By.xpath("//*[@id=\"mbf28cd64-tab_anchor\"]");

	// Xpath for Inspection and Meeting(BCF)--> Inspection and Meeting List
	public static By NewInspectionAndMeetingBtn = By.xpath("//*[@id=\"toolactions_INSERT-tbb_image\"]");

	// Xpath for Inspection and Meeting(BCF)-->Save button
	public static By InspectionAndMeetingSaveBtn = By.xpath("//*[@id=\"toolactions_SAVE-tbb_image\"]");

	// x-path for Inspection and Meeting(BCF) - List Tab - ID Field
	public static By InspectionAndMeeting_ListTab_IDtextField = By.xpath("//*[@id=\"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");

	// x-path for Inspection and Meeting -> List Tab - Inspection and Meeting
	// FilterBtn
	public static By InspectionAndMeeting_ListTab_FilterTableBtn = By.xpath("//*[@id=\"m6a7dfd2f-ti2_img\"]");

	// x-path for Inspection and Meeting -> - List Tab - Select First Record
	public static By InspectionAndMeeting_ListTab_SelectedRecord = By
			.xpath("//*[@id=\"m6a7dfd2f_tdrow_[C:1]-c[R:0]\"]");

	// Xpath for To New Inspection and Meeting->ID
	public static By newInspectionAndMeetingID = By.xpath("//*[@id=\"m4c2c028b-tb\"]");

	// Xpath for Inspection and Meeting ->Description
	public static By InspectionAndMeetingDesc = By.xpath("//*[@id=\"m4c2c028b-tb2\"]");

	// Xpath for Inspection and Meeting(BCF)--> New Inspection and Meeting->Type
	// text box
	public static By InspectionAndMeetingType = By.xpath("//*[@id=\"md5255331-tb\"]");

	// Xpath for Inspection and Meeting(BCF)--> New Inspection and Meeting->Dep text
	// box
	public static By InspectionAndMeetingDep = By.xpath("//*[@id=\"md8dd6276-tb\"]");

	// Xpath for Inspection and Meeting(BCF)--> New Inspection and
	// Meeting->inspection Date
	public static By InspectionAndMeetingInspecDate = By.xpath("//*[@id=\"m54dce586-tb\"]");

	// Xpath for Findings --> New Row Btn
	public static By NewRowBtn = By.xpath("//*[@id=\"m5214faa_bg_button_addrow-pb\"]");

	// Xpath for Findings --> Completed Checkbox1
	public static By CompletedCheckboxRow1 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:4]_checkbox-cb[R:0]_img\"]");

	// Xpath for Findings --> Completed Checkbox2
	public static By CompletedCheckboxRow2 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:4]_checkbox-cb[R:1]_img\"]");

	// Xpath for Findings -->Item Code Text Box
	public static By itemCoderow1 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:1]_txt-tb[R:0]\"]");

	// Xpath for Findings -->Finding Text Box
	public static By FindingTextBoxRow1 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:2]_multilinetextbox-ta[R:0]\"]");

	// Xpath for Findings -->Corrective Action Text Box
	public static By CorrectiveActionTextBoxRow1 = By
			.xpath("//*[@id=\"m5214faa_tdrow_[C:3]_multilinetextbox-ta[R:0]\"]");

	// Xpath for Findings -->Item Code Text Box
	public static By itemCoderow2 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:1]_txt-tb[R:1]\"]");

	// Xpath for Findings -->Finding Text Box
	public static By FindingTextBoxRow2 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:2]_multilinetextbox-ta[R:1]\"]");

	// Xpath for Findings -->Corrective Action Text Box
	public static By CorrectiveActionTextBoxRow2 = By
			.xpath("//*[@id=\"m5214faa_tdrow_[C:3]_multilinetextbox-ta[R:1]\"]");

	// Xpath for Findings --> Action Owner 1
	public static By ActionOwnerRow1 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:5]_txt-tb[R:0]\"]");

	/// Xpath for Findings --> Action Owner 2
	public static By ActionOwnerRow2 = By.xpath("//*[@id=\"m5214faa_tdrow_[C:5]_txt-tb[R:1]\"]");

	// Xpath for Inspection and Meeting(BCF) --> Location Arrow
	public static By LocationArrow = By.xpath("//*[@id=\"m304d2750-img\"]");

	// Xpath for Inspection and Meeting(BCF) --> Location Select Value
	public static By SelectValue = By.xpath("//*[@id=\"PLUSGLOCATIONS_plusglocations_1_a_tnode\"]");

	// Xpath for Inspection and Meeting(BCF) --Location Text box
	public static By LocationTextBox = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");

	// Xpath for Inspection and Meeting(BCF) --> Location text box
	public static By SelectFirstLocation = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");

	// Xpath for Inspection and Meeting(BCF) --> Filter Search
	public static By FilterSearchButton = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");

	// Xpath for Inspection and Meeting(BCF) -->Inspection Date
	public static By InspectionDate = By.xpath("//*[@id=\"m54dce586-tb\"]");

	// Xpath for Inspection and Meeting(BCF) -->Meeting Date
	public static By MeetingDate = By.xpath("//*[@id=\"mf2ea392b-tb\"]");

	// Xpath for Inspection and Meeting(BCF) --> External Audit Check box
	public static By ExternalAudit = By.xpath("//*[@id=\"m718e570f-cb_img\"]");

	// Xpath for Inspection and Meeting(BCF) -->External Agency
	public static By ExternalAgency = By.xpath("//*[@id=\"m6896799-tb\"]");

	// Xpath for Inspection and Meeting(BCF) -->Auditor
	public static By Auditor = By.xpath("//*[@id=\"mae29b2f3-tb\"]");

	// Xpath for New Inspection and Meeting(BCF) - Logs - New Row
	public static By Logs_NewRow = By.xpath("//*[@id=\"m29a1c6ae_bg_button_addrow-pb\"]");
	// Xpath for New Inspection and Meeting(BCF) - Logs - New Row - Summary
	public static By Logs_NewRow_Summary = By.xpath("//*[@id=\"m29a1c6ae_tdrow_[C:3]_txt-tb[R:0]\"]");
	// Xpath for New Inspection and Meeting(BCF) - Logs - New Row - Details
	public static By Logs_NewRow_Details = By.xpath("//*[@id=\"m29a1c6ae_tdrow_[C:4]_multilinetextbox-ta[R:0]\"]");

	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees - Select
	// People
	public static By Attendees_SelectPeople = By.xpath("//*[@id=\"md97d2ae2_bg_button_plusgmeetingattendees-pb\"]");//("//*[@id=\"md97d2ae2_bg_button_plusgselectpeople-pb\"]");
	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees - Select
	// People - Select All
	public static By Attendees_SelectPeople_SelectAll = By
			.xpath("//*[@id=\"md8e06538_ttrow_[C:0]_ttselallrows-ti_img\"]");
	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees - Select
	// People - OK
	public static By Attendees_SelectPeople_OkBtn = By.xpath("//*[@id=\"m39ae843f-pb\"]");

	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees Role -
	// Person 1
	public static By Attendees_Role_Person1 = By.xpath("//*[@id=\"md97d2ae2_tdrow_[C:2]_txt-tb[R:0]\"]");//("//*[@id=\"md97d2ae2_tdrow_[C:3]_txt-tb[R:0]\"]");
	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees Role -
	// Person 2
	public static By Attendees_Role_Person2 = By.xpath("//*[@id=\"md97d2ae2_tdrow_[C:2]_txt-tb[R:1]\"]");//("//*[@id=\"md97d2ae2_tdrow_[C:3]_txt-tb[R:1]\"]");
	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees Role -
	// Person 3
	public static By Attendees_Role_Person3 = By.xpath("//*[@id=\"md97d2ae2_tdrow_[C:2]_txt-tb[R:2]\"]");//("//*[@id=\"md97d2ae2_tdrow_[C:3]_txt-tb[R:2]\"]");
	// Xpath for New Inspection and Meeting(BCF) - Meetings - Attendees Role -
	// Person 4
	public static By Attendees_Role_Person4 = By.xpath("//*[@id=\"md97d2ae2_tdrow_[C:2]_txt-tb[R:3]\"]");//("//*[@id=\"md97d2ae2_tdrow_[C:3]_txt-tb[R:3]\"]");

	// Xpath for New Inspection and Meeting(BCF) - Past Due Inspections
	public static By PastDueInspections = By.xpath("//*[@id = \"m9e1854a7_ns_menu_queryMenuItem_1_a_tnode\"]");

	// Xpath for New Inspection and Meeting(BCF) - Change Status
	public static By ChangeStatus = By.xpath("//*[@id = \"toolactions_STATUS-tbb_image\"]");
	// Xpath for New Inspection and Meeting(BCF) - Change Status - Status Drop-down
	public static By ChangeStatus_Dropdown = By.xpath("//*[@id = \"m25ca600f-img\"]");
	// Xpath for New Inspection and Meeting(BCF) - Change Status - Status Drop-down
	// - Active
	public static By ChangeStatus_Dropdown_Active = By.xpath("//*[@id = \"menu0_ACTIVE_OPTION_a_tnode\"]");
	// Xpath for New Inspection and Meeting(BCF) - Change Status - Status Drop-down
	// - Completed
	public static By ChangeStatus_Dropdown_Completed = By.xpath("//*[@id = \"menu0_COMP_OPTION_a_tnode\"]");
	// Xpath for New Inspection and Meeting(BCF) - Change Status - OK
	public static By ChangeStatus_OK = By.xpath("//*[@id = \"m6a3cf9ef-pb\"]");

	/**
	 * @Description: Change Status to Completed
	 * @throws Throwable
	 */
	public void ChangeStatusto_Completed() throws Throwable {
		try {

			click(ChangeStatus, "Change Status");
			implicityWait(5);
			click(ChangeStatus_Dropdown, "Change Status Dropdown");
			implicityWait(2);
			click(ChangeStatus_Dropdown_Completed, "Completed Status");
			implicityWait(2);
			click(ChangeStatus_OK, "OK");
			implicityWait(5);

			SuccessReportWithScreenshot("Successfully changed status to Completed");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Change Status to Active
	 * @throws Throwable
	 */
	public void ChangeStatusto_Active() throws Throwable {
		try {

			click(ChangeStatus, "Change Status");
			implicityWait(5);
			click(ChangeStatus_Dropdown, "Change Status Dropdown");
			implicityWait(2);
			click(ChangeStatus_Dropdown_Active, "Active Status");
			implicityWait(2);
			click(ChangeStatus_OK, "OK");
			implicityWait(5);

			SuccessReportWithScreenshot("Successfully changed status to Active");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Click on Past Due Inspections
	 * @throws Throwable
	 */
	public void PastDueInspections_CLick() throws Throwable {
		try {

			click(PastDueInspections, "Click on Past Due Inspections");
			implicityWait(10);

			SuccessReportWithScreenshot("Clicked on Past Due Inspections Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Click on New Inspection And Meeting button
	 * @throws Throwable
	 */
	public void newInspectionAndMeeting_CLick() throws Throwable {
		try {

			click(NewInspectionAndMeetingBtn, "New Inspection And Meeting");
			implicityWait(4);

			SuccessReportWithScreenshot("New Inspection And Meeting opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Click on Save Inspection And Meeting
	 * @throws Throwable
	 */
	public void save_InspectionAndMeeting_CLick() throws Throwable {
		try {
			click(InspectionAndMeetingSaveBtn, "Save");
			implicityWait(4);
			SuccessReportWithScreenshot("New Inspection And Meeting saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Enter values for New Inspection And Meeting
	 * @throws Throwable
	 */
	public void enterValuesforNewInspectionAndMeeting(String Description, String Type, String Location,
			String Department) throws Throwable {
		try {

			clear(InspectionAndMeetingDesc);
			type(InspectionAndMeetingDesc, Description, "Description");
			implicityWait(1);
			clear(InspectionAndMeetingType);
			type(InspectionAndMeetingType, Type, "Type");
			click(LocationArrow, "Location button");
			implicityWait(2);
			mouseHoverByJavaScript(SelectValue, "Select Value");
			implicityWait(2);
			click(SelectValue, "Select Value");
			implicityWait(3);
			type(LocationTextBox, Location, "Enter Location");
			implicityWait(1);
			click(FilterSearchButton, "Location Search Button");
			implicityWait(3);
			click(SelectFirstLocation, "Location");
			implicityWait(3);
			clear(InspectionAndMeetingDep);
			type(InspectionAndMeetingDep, Department, "Department");
			SuccessReportWithScreenshot("Successfully Entered data for Inspection and Meeting");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Read and return Inspection And Meeting - ToDo ID
	 * 
	 * @throws Throwable
	 */
	public String InspectionAndMeeting_ReadReturnID() throws Throwable {
		String Id = "";
		try {

			Id = getXPathAttribute(newInspectionAndMeetingID, "value");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Id;
	}

	/*
	 * @Description: Filter the data by ToDo Log ID in List Tab of Inspection And
	 * Meeting
	 * 
	 * @throws Throwable
	 */
	public void ToDoListTab_ToDoIDFilter(String InsAndMeetID) throws Throwable {
		try {
			click(ListTab, "List Tab");
			implicityWait(2);
			clear(InspectionAndMeeting_ListTab_IDtextField);
			type(InspectionAndMeeting_ListTab_IDtextField, InsAndMeetID);
			click(InspectionAndMeeting_ListTab_FilterTableBtn, "Filter");
			implicityWait(2);

			SuccessReportWithScreenshot("Successfully Filtered the ToDo Log");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Enter Inspection Date
	 * 
	 * @throws Throwable
	 */
	public void EnterInspectionDate(String inspectionDate) throws Throwable {
		try {
			clear(InspectionDate);
			type(InspectionDate, inspectionDate);
			implicityWait(2);

			SuccessReportWithScreenshot("Inspection Date has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Enter Meeting Date
	 * 
	 * @throws Throwable
	 */
	public void EnterMeetingDate(String meetingDate) throws Throwable {
		try {
			clear(MeetingDate);
			type(MeetingDate, meetingDate);
			implicityWait(2);

			SuccessReportWithScreenshot("Meeting Date has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Verify Inspection Date not visible
	 * 
	 * @throws Throwable
	 */
	public void VerifyInspectionDateNotVisible() throws Throwable {
		try {
			isElementNotPresent(InspectionDate, "Inspection Date");

			SuccessReportWithScreenshot("Inspection Date not visble successfully");

		} catch (Exception e) {
		}
	}

	/*
	 * @Description: Verify Inspection Date visible
	 * 
	 * @throws Throwable
	 */
	public void VerifyInspectionDateVisible() throws Throwable {
		try {
			isElementPresent(InspectionDate, "Inspection Date");

			SuccessReportWithScreenshot("Inspection Date visble successfully");

		} catch (Exception e) {
		}

	}

	/*
	 * @Description: Verify Meeting Date not visible
	 * 
	 * @throws Throwable
	 */
	public void VerifyMeetingDateNotVisible() throws Throwable {
		try {
			isElementNotPresent(MeetingDate, "Meeting Date");

			SuccessReportWithScreenshot("Meeting Date not visble successfully");

		} catch (Exception e) {
		}
	}

	/*
	 * @Description: Verify Meeting Date visible
	 * 
	 * @throws Throwable
	 */
	public void VerifyMeetingDateVisible() throws Throwable {
		try {
			isElementPresent(MeetingDate, "Meeting Date");

			SuccessReportWithScreenshot("Meeting Date visble successfully");

		} catch (Exception e) {
		}

	}

	/*
	 * @Description: Open the filtered record in List Tab of ToDo
	 * 
	 * @throws Throwable
	 */
	public void ListTab_OpenSelectedRecord() throws Throwable {
		try {
			click(InspectionAndMeeting_ListTab_SelectedRecord, "Selected Record");
			implicityWait(5);

			SuccessReportWithScreenshot("Successfully opened selected  Record");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// /**
	// * @Description: Update assignee
	// * @throws Throwable
	// */
	// public void updateAssignee(String ToDoAssignee) throws Throwable {
	// try {
	//
	// click(ToDoAssigneeArrow, "Assignee Arrow Button");
	// implicityWait(2);
	// type(ToDoPersonTextBox, ToDoAssignee, "Enter Person");
	// implicityWait(1);
	// click(ToDoAssigneeSearchbtn, "Search Button");
	// implicityWait(2);
	// click(ToDoAssignee_firstRecord, "Person");
	// implicityWait(2);
	//
	// SuccessReportWithScreenshot("Assignee has been updated successfully");
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// /**
	// * @Description: Scheduled finish
	// * @throws Throwable
	// */
	// public void enterScheduleDate(String scheduledFinishDate) throws Throwable {
	// try {
	// implicityWait(2);
	// type(ToDoScheduledDate, scheduledFinishDate, "Enter scehduled Finish Date");
	// implicityWait(2);
	// SuccessReportWithScreenshot("Scheduled Finish date has been entered
	// successfully");
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	// /*
	// * @Description: Read and return DaysUntilDue
	// *
	// * @throws Throwable
	// */
	// public String ToDoDaysUntilDue() throws Throwable {
	// String toDoDaysUntilDue = "";
	// try {
	// toDoDaysUntilDue = getXPathAttribute(ToDoDaysUntilDue, "value");
	// toDoDaysUntilDue = toDoDaysUntilDue.trim();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return toDoDaysUntilDue;
	// }

	/*
	 * @Description: Enter Findings
	 * 
	 * @throws Throwable
	 */
	public void AddFindings(String itemCode1, String itemCode2, String finding1, String finding2,
			String correctiveAction1, String correctiveAction2) throws Throwable {
		try {

			click(NewRowBtn, "New Row Button");
			implicityWait(5);
			clear(itemCoderow1);
			type(itemCoderow1, itemCode1);
			implicityWait(2);
			clear(FindingTextBoxRow1);
			type(FindingTextBoxRow1, finding1);
			implicityWait(2);
			clear(CorrectiveActionTextBoxRow1);
			type(CorrectiveActionTextBoxRow1, correctiveAction1);
			implicityWait(2);
			click(CompletedCheckboxRow1, "Completed checkbox");

			click(NewRowBtn, "New Row Button");
			implicityWait(5);
			clear(itemCoderow2);
			type(itemCoderow2, itemCode2);
			implicityWait(2);
			clear(FindingTextBoxRow2);
			type(FindingTextBoxRow2, finding2);
			implicityWait(2);
			clear(CorrectiveActionTextBoxRow2);
			type(CorrectiveActionTextBoxRow2, correctiveAction2);
			implicityWait(2);
			click(CompletedCheckboxRow2, "Completed checkbox");

			SuccessReportWithScreenshot("Findings has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Enter Action Owner
	 * 
	 * @throws Throwable
	 */
	public void EnterActionOwner(String Owner1, String Owner2) throws Throwable {
		try {
			clear(ActionOwnerRow1);
			type(ActionOwnerRow1, Owner1);
			implicityWait(2);
			clear(ActionOwnerRow2);
			type(ActionOwnerRow2, Owner2);
			implicityWait(2);

			SuccessReportWithScreenshot("Action Owner has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Enter Externaland Agency Auditor
	 * 
	 * @throws Throwable
	 */
	public void EnterExternalAgencyAndAuditor(String externalAgency, String auditor) throws Throwable {
		try {
			click(ExternalAudit, "External Audit");
			implicityWait(2);
			clear(ExternalAgency);
			type(ExternalAgency, externalAgency);
			implicityWait(2);
			clear(Auditor);
			type(Auditor, auditor);
			implicityWait(2);

			SuccessReportWithScreenshot("External Agency And Auditor has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Enter Logs
	 * 
	 * @throws Throwable
	 */
	public void AddLogs(String Summary, String Details) throws Throwable {
		try {

			click(Logs_NewRow, "Logs - New Row Button");
			implicityWait(2);
			clear(Logs_NewRow_Summary);
			type(Logs_NewRow_Summary, Summary);
			implicityWait(2);
			clear(Logs_NewRow_Details);
			type(Logs_NewRow_Details, Details);
			implicityWait(2);

			SuccessReportWithScreenshot("Logs added successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Add Attendees
	 * 
	 * @throws Throwable
	 */
	public void AddAttendees() throws Throwable {
		try {

			click(Attendees_SelectPeople, "Select People");
			implicityWait(5);
			click(Attendees_SelectPeople_SelectAll, "Select All");
			implicityWait(5);
			click(Attendees_SelectPeople_OkBtn, "OK");
			implicityWait(10);

//			click(Attendees_Role_Person1,"Role");
//			implicityWait(1);
			type(Attendees_Role_Person1, "ASSESSOR");
			implicityWait(2);
//			click(Attendees_Role_Person2,"Role");
//			implicityWait(1);
			type(Attendees_Role_Person2, "AUDIT LEADER");
			implicityWait(2);
//			click(Attendees_Role_Person3,"Role");
//			implicityWait(1);
			type(Attendees_Role_Person3, "INSPECTOR");
			implicityWait(2);
//			click(Attendees_Role_Person4,"Role");
//			implicityWait(1);
			type(Attendees_Role_Person4, "PARTICIPANT");
			implicityWait(2);

			SuccessReportWithScreenshot("Attendees added successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
