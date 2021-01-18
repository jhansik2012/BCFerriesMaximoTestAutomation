/**
 * @Satish Kumar A
 * @Date April 01, 2020
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

public class License_And_Certificate_BCF extends ActionEngine {



	//Xpath for License and Certificate-->List Tab 
	public static By ListTab = By.xpath("//*[@id=\"m9fa3e414-tab_anchor\"]");



	//Xpath for License and Certificate Tab
	public static By licenseAndCertificateTab = By.xpath("//*[@id=\"mbf28cd64-tab_anchor\"]");

	//Xpath for License and Certificate Tab-ID Description
	public static By LACDescription = By.xpath("//*[@id=\"m4c2c028b-tb2\"]");

	//Xpath for License and Certificate Tab- Category
	public static By LACCategory = By.xpath("//*[@id=\"md5255331-tb\"]");

	//Xpath for License and Certificate Tab- Classification
	public static By LACclassification = By.xpath("//*[@id=\"mb8b96f5e-tb\"]");

	//Xpath for License and Certificate Tab- Location
	public static By LAClocation = By.xpath("//*[@id=\"m90efcec7-tb\"]");

	//Xpath for License and Certificate Tab- LocationSearch
	public static By LAClocationSearch = By.xpath("//*[@id=\"m90efcec7-img\"]");

	//Xpath for License and Certificate Tab- LocationTextBox
	public static By LAClocationTextBox = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");

	//Xpath for License and Certificate Tab- LocationTextBox
	public static By LAClocationSearchBtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");

	//Xpath for License and Certificate Tab- First Location
	public static By LACLocationSearch_SelectFirstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]-c[R:0]\"]");

	//Xpath for License and Certificate-Save Certificaion
	public static By LACcertificationSaveBtn = By.xpath("//*[@id=\"toolactions_SAVE-tbb_image\"]");

	//x-path for changing status
	public static By changeStatus = By.xpath("//*[@id=\"toolactions_STATUS-tbb_image\"]");
	//x-path for Change Status - New Status Field
	public static By changeStatus_NewStatus = By.xpath("//*[@id=\"m25ca600f-tb\"]");
	//x-path for Change Status - Active Status
	public static By changeStatus_StatusActive = By.xpath("//*[@id=\"menu0_ACTIVE_OPTION_a_tnode\"]");

	//x-path for Change Status - Expired Status
	public static By changeStatus_StatusExpired = By.xpath("//*[@id=\"menu0_EXPIRED_OPTION_a_tnode\"]");

	//x-path for Change Status - RENEW Status
	public static By changeStatus_StatusRENEW = By.xpath("//*[@id=\"menu0_RENEW_OPTION_a_tnode\"]");
	
	//x-path for Change Status - Endorsed Status
	public static By changeStatus_StatusEndorsed = By.xpath("//*[@id=\"menu0_ENDORSED_OPTION_a_tnode\"]");
	
	//x-path for Change Status - Ok Button
	public static By changeStatus_OkBtn = By.xpath("//*[@id=\"m6a3cf9ef-pb\"]");
	//Xpath for License and Certificate-ID
	public static By LACcertificationID = By.xpath("//*[@id=\"m4c2c028b-tb\"]");

	//x-path for LAC - List Tab -  Field
	public static By  LACcertificationListTab = By.xpath("//*[@id=\"m6a7dfd2f_tfrow_[C:1]_txt-tb\"]");

	//x-path for LAC - List Tab - LAC FilterBtn
	public static By  LAC_ListTab_FilterTableBtn = By.xpath("//*[@id=\"m6a7dfd2f-ti2_img\"]");

	//x-path for LAC - List Tab - Select First Record
	public static By  LAC_ListTab_SelectedRecord = By.xpath("//*[@id=\"m6a7dfd2f_tdrow_[C:1]_ttxt-lb[R:0]\"]");

	//x-path for LAC - List Tab
	public static By  LicenseAndCertificateListTab_ListTab = By.xpath("//*[@id=\"m9fa3e414-tab_anchor\"]"); 




	//Xpath for License and Certificate Tab- Location Description
	public static By LAClocationDescription = By.xpath("//*[@id=\"m90efcec7-tb2\"]");

	//Xpath for License and Certificate Tab- Owner
	public static By LACowner = By.xpath("//*[@id=\"m53b1219f-tb\"]");



	//Xpath for License and Certificate Tab- Issue Date
	public static By LACIssueDate = By.xpath("//*[@id=\"m55953036-tb\"]");

	//Xpath for License and Certificate Tab- Expiry Date
	public static By LACexpiryDate = By.xpath("//*[@id=\"m229200a0-tb\"]");

	//Xpath for License and Certificate Tab- certification Details- Awarded by Popup
	public static By LACawarded_ClickPopup = By.xpath("//*[@id=\"m9e69f7d-img\"]");
		//Xpath for License and Certificate Tab- certification Details- Awarded by - Search
		public static By LACawarded_Search = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");
		//Xpath for License and Certificate Tab- certification Details- Awarded by - Search Button
		public static By LACawarded_SearchBtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");
		//Xpath for License and Certificate Tab- certification Details- Awarded by - Select First Record
		public static By LACawarded_SelectFirstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");

	//Xpath for License and Certificate Tab- License Certificate Number
	public static By LACLicense_CertificateNumber = By.xpath("//*[@id=\"m3c46f604-tb\"]");

	//Xpath for License and Certificate Tab- certification Details Description
	public static By LACLicense_certificationDetailsDes = By.xpath("//*[@id=\"dijitEditorBody\"]");

	//x-path for License and Certificate - List Tab - Reload Table Button
	public static By LACListTab_ReloadTableBtn = By.xpath("//img[@id = \"m6a7dfd2f-img5\"]");

	//x-path for License and Certificate - New Certification button
	public static By LACNewCertificationBtn = By.xpath("//*[@id=\"toolactions_INSERT-tbb_anchor\"]");

	//x-path for License and Certificate - Renewal notification
	public static By Renewalnotification = By.xpath("//*[@id=\"mbcf69503-tb\"]");

	//x-path for License and Certificate - Frame for Details Field
	public static By iFrame_DetailsField= By.xpath("//*[@id = \"dm5ba8b3d-rte_iframe\"]");

	//x-path for License and Certificate - Details Field
	public static By DetailsField= By.xpath("//*[@id = \"dijitEditorBody\"]");//("//div[@aria-label=\"Details:\"]");

	//x-path for License and Certificate - Table rows count
	public static By noOfRows= By.xpath("//table[@id='m6a7dfd2f_tbod-tbd']//tr");



	//x-path for License and Certificate - View Certification History
	public static By viewCertificationHistory = By.xpath("//*[@id = \"m74daaf83_ns_menu_PLUSGVWHST_OPTION_a_tnode\"]");
	
	//x-path for License and Certificate - Upcoming Renewals
	public static By viewUpcomingRenewals = By.xpath("//*[@id = \"m9e1854a7_ns_menu_queryMenuItem_1_a_tnode\"]");

	//x-path for License and Certificate - Select Owner
	public static By selectOwner = By.xpath("//*[@id=\"m53b1219f-img\"]");//("//*[@id =\"md86fe08f_ns_menu_PLUSGOWNER_OPTION_a_tnode\"]");
		//x-path for License and Certificate - Select Owner - Filter label
		public static By selectOwner_FilterLabel = By.xpath("//*[@id =\"m87669070-lb2\"]");
		//x-path for License and Certificate - Select Owner - Person field
		public static By selectOwner_Person = By.xpath("//*[@id =\"m87669070_tfrow_[C:1]_txt-tb\"]");
		//x-path for License and Certificate - Select Owner - Search Label
		public static By selectOwner_SearchLabel = By.xpath("//*[@id =\"m87669070-ti2_img\"]");
		//x-path for License and Certificate - Select Owner - Select Person
		public static By selectOwner_SelectPerson = By.xpath("//*[@id =\"m87669070_tdrow_[C:1]_ttxt-lb[R:0]\"]");



	//x-path for License and Certificate - Classification
	public static By licesneAndCert_Classification = By.xpath("//*[@id = \"mb8b96f5e-img\"]");	
		//x-path for License and Certificate - Classification - Classify
		public static By licesneAndCert_Classification_Classify = By.xpath("//*[@id = \"CLASSIFICATION_classification_1_a\"]");	
		//x-path for License and Certificate - Classification - Classify - Expand
		public static By licesneAndCert_Classification_Classify_Expand = By.xpath("//*[@id = \"m6b48ba09_7943-trn_state_image\"]");	
		//x-path for License and Certificate - Classification - Classify - Regulatory
		public static By licesneAndCert_Classification_Classify_Regulatory = By.xpath("//*[@id = \"m6b48ba09_7945-trn_select_image\"]");			
		//x-path for License and Certificate - Classification - Classify - Safety
		public static By licesneAndCert_Classification_Classify_Safety = By.xpath("//*[@id = \"m6b48ba09_7944-trn_select_image\"]");	
		
		
	//x-path for License and Certificate - List Tab - Location Filter
	public static By licesneAndCert_ListTab_LocationFilter = By.xpath("//*[@id = \"m6a7dfd2f_tfrow_[C:3]_txt-tb\"]");	
	//x-path for License and Certificate - List Tab - Category Filter
	public static By licesneAndCert_ListTab_CategoryFilter = By.xpath("//*[@id = \"m6a7dfd2f_tfrow_[C:4]_txt-tb\"]");		
	//x-path for License and Certificate - List Tab - Status Filter
	public static By licesneAndCert_ListTab_StatusFilter = By.xpath("//*[@id = \"m6a7dfd2f_tfrow_[C:9]_txt-tb\"]");	
	//x-path for License and Certificate - List Tab - Search Button
	public static By licesneAndCert_ListTab_SearchBtn = By.xpath("//*[@id = \"m6a7dfd2f-ti2_img\"]");	
	//x-path for License and Certificate - List Tab - Clear Button
	public static By licesneAndCert_ListTab_ClearBtn = By.xpath("//*[@id = \"m6a7dfd2f-ti3_img\"]");	
	//x-path for License and Certificate - List Tab - Reload Button
	public static By licesneAndCert_ListTab_ReloadBtn = By.xpath("//*[@id = \"m6a7dfd2f-img5\"]");	
	//x-path for License and Certificate - List Tab - Record Count
	public static By licesneAndCert_ListTab_RecordCount = By.xpath("//*[@id = \"m6a7dfd2f-lb3\"]");
		
		
	
	
	
	
	
	
	/* @Description: Reload the filters in List Page
	 * @throws Throwable
	 */
	public void LandC_ListPage_ReloadFilters() throws Throwable {
		try {

			implicityWait(10);
			click(licesneAndCert_ListTab_ReloadBtn, "Reload Filters");
			implicityWait(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/* @Description: Clear the filters in List Page
	 * @throws Throwable
	 */
	public void LandC_ListPage_ClearFilters() throws Throwable {
		try {

			click(licesneAndCert_ListTab_ClearBtn, "Clear Filters");
			implicityWait(5);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Read the count of records in List Page
	 * @throws Throwable
	 */
	public void LandC_ListPage_RecordCount() throws Throwable {
		try {
			
			SuccessReportWithScreenshot(getXPathValue(licesneAndCert_ListTab_RecordCount));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Filter records on Status field in List Page
	 * @throws Throwable
	 */
	public void LandC_Status_Filter(String lac_StatusFltr) throws Throwable {
		try {

			clear(licesneAndCert_ListTab_StatusFilter);	
			type(licesneAndCert_ListTab_StatusFilter, lac_StatusFltr, "Status");
			click(licesneAndCert_ListTab_SearchBtn, "Search");
			implicityWait(10);
			
			
			SuccessReportWithScreenshot("List filtered by Status");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* @Description: Filter records on Category field in List Page
	 * @throws Throwable
	 */
	public void LandC_Category_Filter(String lac_CategoryFltr) throws Throwable {
		try {

			clear(licesneAndCert_ListTab_CategoryFilter);	
			type(licesneAndCert_ListTab_CategoryFilter, lac_CategoryFltr, "Category");
			click(licesneAndCert_ListTab_SearchBtn, "Search");
			implicityWait(10);
			
			
			SuccessReportWithScreenshot("List filtered by Category");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/* @Description: Filter records on Location field in List Page
	 * @throws Throwable
	 */
	public void LandC_Location_Filter(String lac_LocationFltr) throws Throwable {
		try {

			clear(licesneAndCert_ListTab_LocationFilter);	
			type(licesneAndCert_ListTab_LocationFilter, lac_LocationFltr, "Location");
			click(licesneAndCert_ListTab_SearchBtn, "Search");
			implicityWait(10);
			
			
			SuccessReportWithScreenshot("List filtered by Location");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	
		
		/**
		 * @Description: License and Certificate - Select Classification
		 * @throws Throwable
		 */
		public void selectClassification(String Classification) throws Throwable {
			try {

				click(licesneAndCert_Classification, "Classification");
				implicityWait(2);
				click(licesneAndCert_Classification_Classify, "Classify");
				implicityWait(5);
				click(licesneAndCert_Classification_Classify_Expand, "Expand");
				implicityWait(2);
				
				if (Classification.equalsIgnoreCase("regulatory")) {
					click(licesneAndCert_Classification_Classify_Regulatory, "Regulatory");
					implicityWait(5);
				}else if (Classification.equalsIgnoreCase("safety")) {
					click(licesneAndCert_Classification_Classify_Safety, "Safety");
					implicityWait(5);
				}
				
				SuccessReportWithScreenshot("Classification Selected");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

		/**
		 * @Description: License and Certificate - Change Owner
		 * @throws Throwable
		 */
		public void changeOwner_CLick(String Owner) throws Throwable {
			try {

				click(selectOwner, "Select Owner");
				implicityWait(5);
				click(selectOwner_FilterLabel, "Select Owner");
				implicityWait(2);
				clear(selectOwner_Person);	
				type(selectOwner_Person, Owner, "Person");	
				click(selectOwner_SearchLabel, "Search");
				implicityWait(2);
				click(selectOwner_SelectPerson, "Select Owner");
				implicityWait(5);

				SuccessReportWithScreenshot("Owner Selected");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}



	
	/**
	 * @Description: Click on License and Certificate - Upcoming Renewals
	 * @throws Throwable
	 */
	public void viewUpcomingRenewals_CLick() throws Throwable {
		try {

			click(viewUpcomingRenewals, "Upcoming Renewals");
			implicityWait(10);

			SuccessReportWithScreenshot("Upcoming Renewals opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	/**
	 * @Description: Click on License and Certificate - View Certification History
	 * @throws Throwable
	 */
	public void viewCertificationHistory_CLick() throws Throwable {
		try {

			click(viewCertificationHistory, "View Certification History");
			implicityWait(5);

			SuccessReportWithScreenshot("View Certification History opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	public void ReloadLicenseAndCertifications() throws Throwable {
		try {

			click(LACListTab_ReloadTableBtn, "Reload License and certifications ");
			implicityWait(5);

			SuccessReportWithScreenshot("Successfully displayed all License and certifications");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	/**
	 * @Description: Click on New License and Certification Log button
	 * @throws Throwable
	 */
	public void NewCertification_CLick() throws Throwable {
		try {

			click(LACNewCertificationBtn, "New Certification");
			implicityWait(4);

			SuccessReportWithScreenshot("New Certification opened Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	/**
	 * @Description: Click on Save Certification
	 * @throws Throwable
	 */
	public void SaveCertification_CLick() throws Throwable {
		try {		
			click(LACcertificationSaveBtn, "Save");
			implicityWait(4);	
			SuccessReportWithScreenshot("Certification saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description: Enter values for a Daily Log
	 * @throws Throwable
	 */
	public void EnterValuesforLicenseAndCertificate(String LACcategory, 
			String LACLocation,String LAcowner,String LACissueDate,String LAcexpiryDate,String LAcawardedBy,String LAClicense_CertificateNumber) throws Throwable {
		try {			

			//click(, "Location Search");
			implicityWait(2);
			clear(LACCategory);	
			type(LACCategory, LACcategory, "Category");		
			implicityWait(2);
			clear(LACIssueDate);	
			type(LACIssueDate, LACissueDate, "LACIssueDate");

			implicityWait(2);
			clear(LACexpiryDate);	
			type(LACexpiryDate, LAcexpiryDate, "Expiry Date");
			implicityWait(2);
			click(LAClocationSearch, "Location Search");
			implicityWait(2);
			type(LAClocationTextBox,LACLocation, "Enter Location");

			implicityWait(1);
			click(LAClocationSearchBtn, "Location Search Button");
			implicityWait(2);
			click(LACLocationSearch_SelectFirstRecord, "Location");

//			implicityWait(2);
//			clear(LACawarded);	
//			type(LACawarded, LAcawardedBy,"LACawarded");
			
			implicityWait(2);	
			click(LACawarded_ClickPopup, "Awarded By Popup");
			implicityWait(2);
			type(LACawarded_Search, LAcawardedBy, "Awarded By");
			click(LACawarded_SearchBtn, "Search");
			implicityWait(2);
			click(LACawarded_SelectFirstRecord, "Select Record");

			implicityWait(1);
			clear(LACLicense_CertificateNumber);	
			type(LACLicense_CertificateNumber, LAClicense_CertificateNumber, "License Certificate Number");

			implicityWait(2);
			//clear(LACowner);	
			//type(LACowner, LAcowner, "Owner");
			SuccessReportWithScreenshot("Successfully Entered data for License certification");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/* @Description: Change status of the License And Certificate record to Active
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_ChangeStatustoActive() throws Throwable {
		try {

			click(changeStatus, "ChangeStatus");		
			implicityWait(2);
			click(changeStatus_NewStatus, "New Status");	
			implicityWait(1);
			click(changeStatus_StatusActive, "Active");	
			implicityWait(1);
			click(changeStatus_OkBtn, "Ok");		
			implicityWait(5);			
			SuccessReportWithScreenshot("Status has been changed successfully");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/* @Description: Change status of the License And Certificate record to Expired
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_ChangeStatustoExpired() throws Throwable {
		try {

			click(changeStatus, "ChangeStatus");		
			implicityWait(2);
			click(changeStatus_NewStatus, "New Status");	
			implicityWait(1);
			click(changeStatus_StatusExpired, "Expired");	
			implicityWait(1);
			click(changeStatus_OkBtn, "Ok");		
			implicityWait(5);			
			SuccessReportWithScreenshot("Status has been changed successfully");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 


	/* @Description: Change status of the License And Certificate record to RENEW
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_ChangeStatustoRENEW() throws Throwable {
		try {

			click(changeStatus, "ChangeStatus");		
			implicityWait(2);
			click(changeStatus_NewStatus, "New Status");	
			implicityWait(1);
			click(changeStatus_StatusRENEW, "RENEW");	
			implicityWait(1);
			click(changeStatus_OkBtn, "Ok");		
			implicityWait(5);			
			SuccessReportWithScreenshot("Status has been changed successfully");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	/* @Description: Change status of the License And Certificate record to Endorsed
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_ChangeStatustoEndorsed() throws Throwable {
		try {

			click(changeStatus, "ChangeStatus");		
			implicityWait(2);
			click(changeStatus_NewStatus, "New Status");	
			implicityWait(1);
			click(changeStatus_StatusEndorsed, "ENDORSED");	
			implicityWait(1);
			click(changeStatus_OkBtn, "Ok");		
			implicityWait(5);			
			SuccessReportWithScreenshot("Status has been changed successfully");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}






	/* @Description: License And Certificate ID
	 * @throws Throwable
	 */
	public String LicenseAndCertificateReadReturnID() throws Throwable {
		String certificationID = "";
		try {

			certificationID = getXPathAttribute(LACcertificationID, "value");			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return certificationID;
	}

	/* @Description: Filter the data by ID in List Tab 
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_IDFilter(String lacID) throws Throwable {
		try {
			click(ListTab, "List Tab");		
			implicityWait(2);
			clear(LACcertificationListTab);
			type(LACcertificationListTab, lacID);
			click(LAC_ListTab_FilterTableBtn, "Filter");		
			implicityWait(2);				
			SuccessReportWithScreenshot("Successfully Filtered the Records");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* @Description: Open the filtered record in List Tab of License And Certificate List 
	 * @throws Throwable
	 */
	public void LicenseAndCertificateListTab_OpenSelectedRecord() throws Throwable {
		try {
			implicityWait(2); 
			click(LAC_ListTab_SelectedRecord, "Selected Record");		
			implicityWait(5);

			SuccessReportWithScreenshot("Successfully opened selected  Record");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* @Description: Navigate to List Tab in Daily Log
	 * @throws Throwable
	 */
	public void LicenseAndCertificateListTab_NavigateToListTab() throws Throwable {
		try {

			click(LicenseAndCertificateListTab_ListTab, "List Tab");
			implicityWait(2);

			SuccessReportWithScreenshot("Successfully Navigate to List Tab");	

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* @Description: Enter Renewal notification (Days)
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_RenewalNotification(String renewalNotification) throws Throwable {
		try {
			clear(Renewalnotification);
			type(Renewalnotification, renewalNotification);	
			implicityWait(2);				
			SuccessReportWithScreenshot("Renewal notification has been entered successfully");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* @Description: Enter Comments in details field
	 * @throws Throwable
	 */
	public void LicenseAndCertificate_EnterCommentsInDetailsField(String Comments) throws Throwable {
		try {

			WebElement frame = driver.findElement(By.id("m5ba8b3d-rte_iframe"));
			driver.switchTo().frame(frame);
			WebElement messagebox = driver.findElement(By.id("dijitEditorBody"));
			messagebox.click();
			messagebox.sendKeys(Comments);
			driver.switchTo().window(driver.getWindowHandle());

			//			richTextType(iFrame_DetailsField, DetailsField, Comments, "Comments");

			implicityWait(2);				
			SuccessReportWithScreenshot("Comments has been entered successfully");			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyCerticate() throws Throwable {
		try {

			List rows = driver.findElements(By.xpath("//table[@id='m6a7dfd2f_tbod-tbd']//tr"));

			int count =rows.size();
			System.out.println("******Rows Count*******"+count);
			if(count>4) {				  
				SuccessReport("Verify "," Successfully displayed searched record ");    				  
			}
			else {

				failureReport("Verify ","Record not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}




}
