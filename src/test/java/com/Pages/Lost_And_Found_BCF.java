/**
 * @Satish Kumar A
 * @Date April 16, 2020
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

public class Lost_And_Found_BCF extends ActionEngine {

	// Xpath for Lost and Found-->List Tab
	public static By LostAndFound_ListTab = By.xpath("//*[@id=\"m9fa3e414-tab_anchor\"]");

	// Xpath for Lost and Found-->Lost and Found Tab
	public static By LostandFoundTab = By.xpath("//*[@id=\"mbf28cd64-tab_anchor\"]");

	// Xpath for Lost and Found-ID
	public static By LostAndFoundID = By.xpath("//*[@id=\"me5a2983-tb\"]");

	// Xpath for Lost and Found-ID Description
	public static By LostAndFoundDescription = By.xpath("//*[@id=\"me5a2983-tb2\"]");

	// Xpath for Lost and Found-Location Arrow button
	public static By LostAndFoundArrow = By.xpath("//*[@id=\"m6b67125c-img\"]");

	// x-path for Lost and Found-select value
	public static By LostAndFoundSelectValue = By.xpath("//*[@id=\"LOCATIONS_locations0_a_tnode\"]");

	// Xpath for Lost and Found-->SelectLocValue-->Location
	public static By LostAndFoundSelectValuelocation = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");
	
	// Xpath for Lost and Found-->SelectLocValue-->Location Description
		public static By LostAndFoundLocationDescription = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:1]_txt-tb\"]");
	
	

	// Xpath for Lost and Found--SelectLocValue-->Location Search button
	public static By LostAndFoundLocationSearchbtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");

	// Xpath for Lost and Found--SelectLocValue-->select first record
	public static By LostAndFoundLocation_firstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");

	// Xpath for Lost and Found--Classification Search Popup
	public static By LostAndFound_ClassficationSearchPopup = By.xpath("//*[@id=\"md40357ff-img\"]");
		// Xpath for Lost and Found--Classification Search
		public static By LostAndFound_ClassficationSearch = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");
		// Xpath for Lost and Found--Classification Search Button
		public static By LostAndFound_ClassficationSearchBtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");
		// Xpath for Lost and Found--Classification Search - First Record
		public static By LostAndFound_ClassficationSearch_FirstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");

	// Xpath for Lost and Found-- Shift
	public static By LostAndFoundShift = By.xpath("//*[@id=\"m8cd5681e-tb\"]");

	// Xpath for Lost and Found-- Details
	public static By LostAndFoundVesselDetailsTextBox = By.xpath("//*[@id=\"dijitEditorBody\"]");

	// Xpath for Lost and Found-- New Lost And Found Btn
	public static By NewLostAndFoundBtn = By.xpath("//*[@id=\"toolactions_INSERT-tbb_image\"]");

	// Xpath for Lost and Found-- New Lost And Found Save Btn
	public static By LostAndFoundSaveBtn = By.xpath("//*[@id=\"toolactions_SAVE-tbb_image\"]");

	// Xpath for Lost and Found-- Filter text box
	public static By LostAndFoundFilterTextBox = By.xpath("//*[@id=\"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");
	
	// Xpath for Lost and Found-- Filter Table Button
	public static By LAF_ListTab_FilterTableBtn = By.xpath("//*[@id=\"m6a7dfd2f-ti2_img\"]");
	
	// Xpath for Lost and Found-- Run Reports
		public static By LAF_RunReports = By.xpath("//*[@id=\"m74daaf83_ns_menu_RUNREPORTS_OPTION_a_tnode\"]");
		

		// Xpath for Lost and Found-- Run Reports --> Lost and Found Items - All Vessels
		public static By LAF_LostAndFoundItemAllVessels = By.xpath("//*[@id=\"m311791ed_tdrow_[C:0]_ttxt-lb[R:0]\"]");
		
		// Xpath for Lost and Found-- Run Reports --> Submit
				public static By LAF_Reports_Submit = By.xpath("//*[@id=\"m342e09f3-pb\"]");
		
				// Xpath for Lost and Found-- Run Reports --> Cancel
				public static By LAF_ReportsCancel = By.xpath("//*[@id=\"ma7a2510c-pb\"]");		
				
		
	// Xpath for Lost and Found-- First Record
	public static By LAF_FirstRecord = By.xpath("//*[@id=\"m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]\"]");
	
	// Xpath for Lost and Found--Report Date
	public static By ReportDate = By.xpath("//*[@id=\"mfc89eb1a-tb\"]");
	
	
	
	/**
	 * @Description: Click on New Lost and Found button
	 * @throws Throwable
	 */
	public void NewLostAndFound_CLick() throws Throwable {
		try {

			click(NewLostAndFoundBtn, "New Lost and Found");
			implicityWait(10);

			SuccessReportWithScreenshot("New Lost and Found has been opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Click on Save Lost and Found
	 * @throws Throwable
	 */
	public void SaveLostAndFound_CLick() throws Throwable {
		try {
			click(LostAndFoundSaveBtn, "Save");
			implicityWait(4);
			SuccessReportWithScreenshot("Details has been saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Enter values for a New Lost and Found
	 * @throws Throwable
	 */
	public void EnterValuesforLostAndFound(String LAFDescription, String LAFClassification, String LAFShift,
			String LostAndFoundLocation) throws Throwable {
		try {

			implicityWait(2);
			clear(LostAndFoundDescription);
			type(LostAndFoundDescription, LAFDescription, "Description");
			implicityWait(2);
			
			click(LostAndFoundArrow, "Location Search");
			implicityWait(3);
//			clear(LostAndFoundSelectValuelocation);
			type(LostAndFoundSelectValuelocation, LostAndFoundLocation, "Enter Location");
			implicityWait(1);					
			
			click(LostAndFoundLocationSearchbtn, "Location Search Button");
			implicityWait(10);
			click(LostAndFoundLocation_firstRecord, "Location");
			implicityWait(3);

			click(LostAndFound_ClassficationSearchPopup, "Classification Popup");
			implicityWait(2);
			type(LostAndFound_ClassficationSearch, LAFClassification, "Classification");
			click(LostAndFound_ClassficationSearchBtn, "Search");
			implicityWait(2);
			click(LostAndFound_ClassficationSearch_FirstRecord, "Select Record");
			implicityWait(2);
			
			
			clear(LostAndFoundShift);
			implicityWait(1);
			type(LostAndFoundShift, LAFShift, "Shift");
			implicityWait(2);
			SuccessReportWithScreenshot("Successfully Entered data for Lost and Found");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//
//	/*
//	 * @Description: Change status of the License And Certificate record to Active
//	 * 
//	 * @throws Throwable
//	 */
//	public void LicenseAndCertificate_ChangeStatustoActive() throws Throwable {
//		try {
//
//			click(changeStatus, "ChangeStatus");
//			implicityWait(2);
//			click(changeStatus_NewStatus, "New Status");
//			implicityWait(1);
//			click(changeStatus_StatusActive, "Active");
//			implicityWait(1);
//			click(changeStatus_OkBtn, "Ok");
//			implicityWait(5);
//			SuccessReportWithScreenshot("Status has been changed successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/*
//	 * @Description: Change status of the License And Certificate record to Expired
//	 * 
//	 * @throws Throwable
//	 */
//	public void LicenseAndCertificate_ChangeStatustoExpired() throws Throwable {
//		try {
//
//			click(changeStatus, "ChangeStatus");
//			implicityWait(2);
//			click(changeStatus_NewStatus, "New Status");
//			implicityWait(1);
//			click(changeStatus_StatusExpired, "Expired");
//			implicityWait(1);
//			click(changeStatus_OkBtn, "Ok");
//			implicityWait(5);
//			SuccessReportWithScreenshot("Status has been changed successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/*
//	 * @Description: Change status of the License And Certificate record to RENEW
//	 * 
//	 * @throws Throwable
//	 */
//	public void LicenseAndCertificate_ChangeStatustoRENEW() throws Throwable {
//		try {
//
//			click(changeStatus, "ChangeStatus");
//			implicityWait(2);
//			click(changeStatus_NewStatus, "New Status");
//			implicityWait(1);
//			click(changeStatus_StatusRENEW, "RENEW");
//			implicityWait(1);
//			click(changeStatus_OkBtn, "Ok");
//			implicityWait(5);
//			SuccessReportWithScreenshot("Status has been changed successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
	/*
	 * @Description: Lost and Found- ID
	 * 
	 * @throws Throwable
	 */
	public String LostAndFoundReadReturnID() throws Throwable {
		String lostAndFoundD = "";
		try {

			lostAndFoundD = getXPathAttribute(LostAndFoundID, "value");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lostAndFoundD;
	}

	/*
	 * @Description: Filter the data by ID in List Tab
	 * 
	 * @throws Throwable
	 */
	public void LostAndFound_IDFilter(String LostAnFoundID) throws Throwable {
		try {
			click(LostAndFound_ListTab, "List Tab");
			implicityWait(2);
			clear(LostAndFoundFilterTextBox);
			
			type(LostAndFoundFilterTextBox, LostAnFoundID);
			click(LAF_ListTab_FilterTableBtn, "Filter");
			implicityWait(4);
			SuccessReportWithScreenshot("Successfully Filtered the Records");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Open the filtered record in List Tab of Lost And Found
	 * List
	 * 
	 * @throws Throwable
	 */
	public void LostAndFoundListTab_OpenSelectedRecord() throws Throwable {
		try {
			implicityWait(2);
			click(LAF_FirstRecord, "Selected Record");
			implicityWait(5);

			SuccessReportWithScreenshot("Successfully opened selected  Record");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Description: Navigate to List Tab 
	 * 
	 * @throws Throwable
	 */
	public void LostAndFound_NavigateToListTab() throws Throwable {
		try {

			click(LostAndFound_ListTab, "List Tab");
			implicityWait(2);

			SuccessReportWithScreenshot("Successfully Navigate to List Tab");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//
//	/*
//	 * @Description: Enter Renewal notification (Days)
//	 * 
//	 * @throws Throwable
//	 */
//	public void LicenseAndCertificate_RenewalNotification(String renewalNotification) throws Throwable {
//		try {
//			clear(Renewalnotification);
//			type(Renewalnotification, renewalNotification);
//			implicityWait(2);
//			SuccessReportWithScreenshot("Renewal notification has been entered successfully");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
	/*
	 * @Description: Enter Comments in details field
	 * 
	 * @throws Throwable
	 */
	public void LostAndFound_EnterCommentsInDetailsField(String Comments) throws Throwable {
		try {

			WebElement frame = driver.findElement(By.id("m1f7bb5c6-rte_iframe"));
			driver.switchTo().frame(frame);
			WebElement messagebox = driver.findElement(By.id("dijitEditorBody"));
			messagebox.click();
			messagebox.sendKeys(Comments);
			driver.switchTo().window(driver.getWindowHandle());

			// richTextType(iFrame_DetailsField, DetailsField, Comments, "Comments");

			implicityWait(2);
			SuccessReportWithScreenshot("Comments has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description: Run reports 
	 * @throws Throwable
	 */
	public void generateReport() throws Throwable {
		try {	
			
			click(LAF_RunReports, "Run Repor Button");	
			implicityWait(2);
		    click(LAF_LostAndFoundItemAllVessels, "'Lost and Found Items - All Vessels'  Button");
			implicityWait(2);
			click(LAF_Reports_Submit, "Submit");	
			implicityWait(6);	
			switchNewChromeTab();
			SuccessReportWithScreenshot("Reports has been generated  successfully");
			closeChromeTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	/**
	 * @Description: Cancel reports 
	 * @throws Throwable
	 */
	public void reportsCancel() throws Throwable {
		try {	
			
			click(LAF_ReportsCancel, "Cancel Button");	
			implicityWait(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifyLostAndFoundRecords() throws Throwable {
		try {
			List rows = driver.findElements(By.xpath("//table[@id='m6a7dfd2f_tbod-tbd']//tr"));

			int count = rows.size();
			System.out.println("******Rows Count*******" + count);
			if (count > 1) {
				SuccessReport("Verify ", " Successfully displayed searched record ");
			} else {

				failureReport("Verify ", "Record not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void LostAndFound_FilterTableBtn() throws Throwable {
		try {
			implicityWait(2);
			click(LAF_ListTab_FilterTableBtn, "Filter"); 
			implicityWait(20);

			SuccessReportWithScreenshot("Successfully Clicked on filter Table Button");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	             

	
	public void verifySearchedRecord() throws Throwable {
		try {

			List rows = driver.findElements(By.xpath("//table[@id='m6a7dfd2f_tbod-tbd']//tr"));

			int count = rows.size();
			System.out.println("******Rows Count*******" + count);
			if (count > 4 ) {
				SuccessReport("Verify ", " Successfully displayed searched record ");
			} else {

				failureReport("Verify ", "Record not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * @Description: Update Classification
	 * 
	 * @throws Throwable
	 */
	public void EnterClassification(String classification) throws Throwable {
		try {

			click(LostAndFound_ClassficationSearchPopup, "Classification Popup");
			implicityWait(2);
			type(LostAndFound_ClassficationSearch, classification, "Classification");
			click(LostAndFound_ClassficationSearchBtn, "Search");
			implicityWait(2);
			click(LostAndFound_ClassficationSearch_FirstRecord, "Select Record");
			implicityWait(2);
			
			SuccessReportWithScreenshot("Classification has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * @Description: Update Report Date
	 * 
	 * @throws Throwable
	 */
	public void UpdateReportDate() throws Throwable {
		try {
         String ReportDates;
			ReportDates = getXPathAttribute(ReportDate, "value");
			System.out.println(ReportDates);
			clear(ReportDate);
            type(ReportDate, ReportDates);
			implicityWait(2);
			SuccessReportWithScreenshot("ReportDate has been entered successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/* @Description: Read and return ReportDate
	 * @throws Throwable
	 */
	public String ReportDate() throws Throwable {
		String reportDate = "";
		try {
			reportDate = getXPathAttribute(ReportDate,"value");
			reportDate=reportDate.trim();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportDate;
	}
}
