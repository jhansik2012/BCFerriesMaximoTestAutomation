/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 17, 2019
 */

package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accelerators.ActionEngine;
import com.accelerators.CredentialManager;
import com.relevantcodes.extentreports.LogStatus;

public class MaximoStartCenter extends ActionEngine {
	
	public static By homeBtn = By.xpath("//button[@id = \"titlebar-tb_homeButton\"]");
	public static By goToBtn = By.xpath("//button[@id = \"titlebar-tb_gotoButton\"]");
	public static By userFullName = By.xpath("//span[@id = \"titlebar-tb_username\"]");
//	public static By searchField = By.xpath("//input[@id = \"nav_search_fld\"]");
	public static By logOutBtn = By.xpath("//td[@id = \"titlebar_hyperlink_8-co_0\"]");
	// x-path for Return button after log off
	public static By logOut_ReturnBtn = By.xpath("//button[@id = \"submit\"]");
//	public static By goToAppLbl = By.xpath("//span[@id = \"nav_search_fld_menu_navSearchItemm7f8f3e49_ns_label_a_tnode\"]");
//	public static By searchItem = By.xpath("//li[@id = \"nav_search_fld_menu_navSearchItemm7f8f3e49_ns_label\"]/following-sibling::li");
	public static By analyticsModuleNode = By.xpath("//span[@id = \"menu0_ANALYTICS_MODULE_a_tnode\"]");
	public static By operationsModuleNode = By.xpath("//span[@id = \"menu0_PLUSGOP_MODULE_a_tnode\"]");
	public static By planningModuleNode = By.xpath("//span[@id = \"menu0_PLANS_MODULE_a_tnode\"]");
	public static By preventiveMaintainenceModuleNode = By.xpath("//span[@id = \"menu0_PM_MODULE_a_tnode\"]");
	public static By selfServiceModuleNode = By.xpath("//span[@id = \"menu0_SSDR_MODULE_a_tnode\"]");
	public static By serviceLevelModuleNode = By.xpath("//span[@id = \"menu0_SLA_MODULE_a_tnode\"]");
	public static By workOrdersModuleNode = By.xpath("//span[@id = \"menu0_WO_MODULE_a_tnode\"]");
	public static By analyticsNodeReportViewer = By.xpath("//span[@id = \"menu0_ANALYTICS_MODULE_sub_changeapp_RPTOUTPUT_a_tnode\"]");
	public static By operationsNodeDailyLog = By.xpath("//span[@id = \"menu0_PLUSGOP_MODULE_sub_changeapp_BCFLOG_a_tnode\"]");
	public static By planningNodeDrills = By.xpath("//span[@id = \"menu0_PLANS_MODULE_sub_changeapp_BCFDRILLJP_a_tnode\"]");
	public static By preventiveMaintainenceNodeDrillScheduler = By.xpath("//span[@id = \"menu0_PM_MODULE_sub_changeapp_BCFDRILLPM_a_tnode\"]");
	public static By workOrdersNodeDrillLog = By.xpath("//span[@id = \"menu0_WO_MODULE_sub_changeapp_BCFDRILLWO_a_tnode\"]");
	
	//x-path for Overdue Drill Chart - Set Chart Options
	public static By overDueDrills_SetChartOptions = By.xpath("//a[@title= \"Set Chart Options\"]");
	
	//x-path for Profile Icon
	public static By profileIcon = By.xpath("//*[@id=\"titlebar_hyperlink_7-lbshowmenu_profile_image\"]");
	
	//x-path for Default information Icon
	public static By personalInformation= By.xpath("//*[text()='Personal Information']");
	
	//x-path for  Vessel ID 
    public static By vesselID= By.xpath("//*[@id=\"m2935cb81-tb\"]");
    
  //x-path for  OK 
    public static By personalOK= By.xpath("//*[@id=\"m4f708175-pb\"]");
    
   //Xpath for safety and quality management
    public static By safetyAndQuaManagment= By.xpath("//*[@id=\"menu0_PLUSGSD_MODULE_a_tnode\"]");
    
  //Xpath for Licenses and Certificates
    public static By licenseAndCertificates= By.xpath("//*[@id=\"menu0_PLUSGSD_MODULE_sub_changeapp_BCFCERT_a_tnode\"]");
  //*[@id="menu0_PLUSGSD_MODULE_sub_changeapp_BCFSR_a_tnode"]
    
  //Xpath for To Do
    public static By toDo= By.xpath("//*[@id=\"menu0_PLUSGSD_MODULE_sub_changeapp_BCFSR_a_tnode\"]"); 
    
    //Xpath for Lost And Found
    public static By lostAndFound= By.xpath("//*[@id=\"menu0_PLUSGSD_MODULE_sub_changeapp_BCFLANDF_a_tnode\"]"); ////*[@id=\"m7f8f3e49_ns_menu_PLUSGSD_MODULE_sub_changeapp_BCFLANDF_a_tnode\"]
    
    
  //Xpath for Inspections and Meetings 
    public static By InspectionsAndMeetings= By.xpath("//*[@id=\"menu0_PLUSGSD_MODULE_sub_changeapp_BCFINSP_a_tnode\"]");   
 	
    
  
    
    
 	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @Description: Verify the Maximo Start Center
	 * @throws Throwable
	 */
	public void verifyMaximoStartCenter(String actualpageTitle) throws Throwable {
		try {
			
            implicityWait(2);
			//assertTitle(actualpageTitle);
			isElementPresent(homeBtn, "Maximo User Name Field");
			isElementPresent(goToBtn, "Maximo Password Field");
//			isElementPresent(searchField, "Maximo Sign In Button");
			isElementPresent(logOutBtn, "Maximo Sign In Button");
			
			SuccessReportWithScreenshot("Maximo Login Successfull");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
//	/**
//	 * @Description: Search Application in Maximo Start Center
//	 * @throws Throwable
//	 */
//	public void searchForItem(String searchText) throws Throwable {
//		try {
//
//			clear(searchField);	
//			type(searchField, searchText, "Search Text");
//			SuccessReportWithScreenshot("SearchPage");
//			click(searchItem, "Searched Item");
//			SuccessReportWithScreenshot("SearchedItemPage");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	/**
	 * @Description: Navigate to Drill Log from Start Center
	 * @throws Throwable
	 */
	public void navigateToDrillLog() throws Throwable {
		try {

			click(goToBtn, "Menu Go To Button");
			implicityWait(2);
			mouseHoverByJavaScript(workOrdersModuleNode, "Work Order Module");
			implicityWait(2);
			mouseHoverByJavaScript(workOrdersNodeDrillLog, "Drill Log");
			implicityWait(2);
			click(workOrdersNodeDrillLog, "Drill Log");
			implicityWait(2);
			
//			explicityWait(com.Pages.Drill_Log_BCF.newDrillLog);
//			implicityWait(15);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Navigate to Drills module from Start Center
	 * @throws Throwable
	 */
	public void navigateToDrills() throws Throwable {
		try {

			click(goToBtn, "Menu Go To Button");
			implicityWait(2);
			mouseHoverByJavaScript(planningModuleNode, "Planning Module");
			implicityWait(2);
			mouseHoverByJavaScript(planningNodeDrills, "Drills");
			implicityWait(2);
			click(planningNodeDrills, "Drills");
			implicityWait(2);
			
			explicityWait(com.Pages.Drills_BCF.newDrills);
			implicityWait(15);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Navigate to Drill Scheduler (BCF) module from Start Center
	 * @throws Throwable
	 */
	public void navigateToDrillScheduler() throws Throwable {
		try {

			click(goToBtn, "Menu Go To Button");
			implicityWait(2);
			mouseHoverByJavaScript(preventiveMaintainenceModuleNode, "Preventive Maintainence Module");
			implicityWait(2);
			mouseHoverByJavaScript(preventiveMaintainenceNodeDrillScheduler, "Drills Scheduler");
			implicityWait(2);
			click(preventiveMaintainenceNodeDrillScheduler, "Drills Scheduler");
			implicityWait(2);
			
			explicityWait(com.Pages.Drills_Scheduler_BCF.newDrillScheduler);
			implicityWait(12);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @Description: Navigate to Daily Log (BCF) module from Start Center
	 * @throws Throwable
	 */
	public void navigateToDailyLog() throws Throwable {
		try {

			click(goToBtn, "Menu Go To");
			implicityWait(2);
			mouseHoverByJavaScript(operationsModuleNode, "Operations HSE");
			implicityWait(2);
			mouseHoverByJavaScript(operationsNodeDailyLog, "Daily Log");
			implicityWait(2);
			click(operationsNodeDailyLog, "Daily Log");
			implicityWait(2);
			
//			explicityWait(com.Pages.DailyLog_BCF.newDailyLog);
			implicityWait(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * @Description: Logoff From Maximo
	 * @throws Throwable
	 */
	public void logOffMaximo() throws Throwable {
		try {
			//explicityWait_ElementVisible(logOutBtn);
			
			Alert();
			propertyManager = CredentialManager.getProperty("Properties");
			credentialManager = CredentialManager.getProperty(propertyManager.get("Environment"));
//			launchUrl(credentialManager.get("Url"));
			implicityWait(2);
			Alert();
			//click("")
//			pageRefresh();
//			implicityWait(2);
			//Alert();
			
			
			implicityWait(3);
			Alert();
			implicityWait(1);
			click(logOutBtn, "Log Off");	
			implicityWait(2);
			
			SuccessReportWithScreenshot("LogOffMaximo");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	

	public void setVessel(String vesselId)  throws Throwable {
		try {

			click(profileIcon, "Profile");
			implicityWait(2);
			mouseHoverByJavaScript(personalInformation, "Personal Information");
			implicityWait(2);
			click(personalInformation, "Personal Information");	
			implicityWait(2);    
			clear(vesselID);		
			type(vesselID,vesselId);
			implicityWait(2);
			click(personalOK, "OK");
			implicityWait(5); 
			
			
			SuccessReportWithScreenshot("Vessel has been updated successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//StartCenter.navigateToDailyLog();
	
	
	
	
	
	public void clickOnReturnBtn() throws Throwable {
		try {
			
			click(logOut_ReturnBtn, "Return");	
			implicityWait(2);
			
//			SuccessReportWithScreenshot("LogOffMaximo");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	/**

	 * @Description: Navigate to Licenses And Certificates (BCF) module from Start Center
 * @throws Throwable
 */
public void navigateToLicenseAndCertificate() throws Throwable {
	try {

		click(goToBtn, "Menu Go To");
		implicityWait(2);
		mouseHoverByJavaScript(safetyAndQuaManagment, "Safey and Quality Management");
	    implicityWait(2);
		mouseHoverByJavaScript(licenseAndCertificates, "Licenses and Certificates");
		implicityWait(2);
		click(licenseAndCertificates, "Licenses and Certificates");			
		implicityWait(2);

	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void navigateToToDoList() throws Throwable {
	try {

		click(goToBtn, "Menu Go To");
		implicityWait(2);
		mouseHoverByJavaScript(safetyAndQuaManagment, "Safey and Quality Management");
	    implicityWait(2);
		mouseHoverByJavaScript(toDo, "To Do");
		implicityWait(2);
		click(toDo, "TO Do");			
		implicityWait(2);

	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void navigateToLostAndFound() throws Throwable {
	try {

		click(goToBtn, "Menu Go To");
		implicityWait(2);
		mouseHoverByJavaScript(safetyAndQuaManagment, "Safey and Quality Management");
	    implicityWait(1);
		mouseHoverByJavaScript(lostAndFound, "Lost And Found");
		implicityWait(2);
		click(lostAndFound, "Lost And Found");			
		implicityWait(2);

	} catch (Exception e) {
		e.printStackTrace();
	}
}



public void navigateToInspectionsAndMeetings() throws Throwable {
	try {

		click(goToBtn, "Menu Go To");
		implicityWait(2);
		mouseHoverByJavaScript(safetyAndQuaManagment, "Safey and Quality Management");
	    implicityWait(2);
		mouseHoverByJavaScript(InspectionsAndMeetings, "Inspections and Meetings");
		implicityWait(2);
		click(InspectionsAndMeetings, "Inspections and Meetings");			
		implicityWait(10);

	} catch (Exception e) {
		e.printStackTrace();
	}
}








}
