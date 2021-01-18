
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

public class ToDo_BCF extends ActionEngine {
	
	

	    //Xpath for To Do(BCF)-->List Tab 
        public static By ListTab = By.xpath("//*[@id=\"m9fa3e414-tab_anchor\"]");
    
        //Xpath for To Do(BCF)--> To Do Tab 
        public static By  ToDoTab = By.xpath("//*[@id=\"mbf28cd64-tab_anchor\"]");
 
        //Xpath for To Do(BCF)--> NewTo Do List 
        public static By  newToDo = By.xpath("//*[@id=\"toolactions_INSERT-tbb_image\"]");
        
      //Xpath for To Do(BCF)-->All Open TO-DOs Assigned to Me  
        public static By  AllOpenTODOsAssignedtoMe = By.xpath("//*[@id=\"m9e1854a7_ns_menu_queryMenuItem_1_a_tnode\"]");
        
        //Xpath for To Do(BCF)-->Overdue TODOs Assigned to Me  
        public static By  OverdueTODOsAssignedtoMe = By.xpath("//*[@id=\"m9e1854a7_ns_menu_queryMenuItem_2_a_tnode\"]");  
        
      
        
      //Xpath for To Do(BCF)--> NewTo Do-->Save button 
        public static By  newToDoSaveBtn = By.xpath("//*[@id=\"toolactions_SAVE-tbb_image\"]");
        
        //Xpath for To Do(BCF)--> ToDo Id 
        public static By  ToDoId = By.xpath("//*[@id=\"me5a2983-tb\"]"); 
        
      //x-path for ToDo Log - List Tab - ToDo Field
        public static By  ToDoListTab_Log = By.xpath("//*[@id=\"m6a7dfd2f_tfrow_[C:0]_txt-tb\"]");
        
      //x-path for ToDo Log - List Tab - ToDo FilterBtn
        public static By  toDo_ListTab_FilterTableBtn = By.xpath("//*[@id=\"m6a7dfd2f-ti2_img\"]");
        
      //x-path for ToDo Log - List Tab - Select First Record
        public static By  toDo_ListTab_SelectedRecord = By.xpath("//*[@id=\"m6a7dfd2f_tdrow_[C:0]_ttxt-lb[R:0]\"]");
        
        
        
        
        
        
        
       
        
      
        
        //Xpath for To Do(BCF)--> ToDo TextBox 
        public static By  ToDoTestBox = By.xpath("//*[@id=\"me5a2983-tb\"]");
        
        //Xpath for To Do(BCF)--> ToDo Description 
        public static By  ToDoTestBoxDesc = By.xpath("//*[@id=\"me5a2983-tb2\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--locationArrow 
        public static By  ToDolocationArrow = By.xpath("//*[@id=\"m6b67125c-img\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--SelectLocValue 
        public static By  ToDolocationSelectValue = By.xpath("//*[@id=\"LOCATIONS_locations0_a_tnode\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--SelectLocValue-->Location
        public static By  ToDoSelectValuelocation = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:0]_txt-tb\"]");
        
      //Xpath for To Do(BCF)--> New ToDo--SelectLocValue-->Location Search button
        public static By  ToDoLocationSearchbtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--SelectLocValue-->select first record
        public static By  ToDoLocation_firstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:0]_ttxt-lb[R:0]\"]");
        
        
      //Xpath for To Do(BCF)--> New ToDo--AssigneeArrow 
        public static By  ToDoAssigneeArrow = By.xpath("//*[@id=\"ma1ac36c4-img\"]");
       
        
        //Xpath for To Do(BCF)--> New ToDo--SelectLocValue-->Location
        public static By  ToDoPersonTextBox = By.xpath("//*[@id=\"lookup_page1_tfrow_[C:1]_txt-tb\"]");
        
      //Xpath for To Do(BCF)--> New ToDo--SelectLocValue-->Assignee Search button
        public static By  ToDoAssigneeSearchbtn = By.xpath("//*[@id=\"lookup_page1-ti2_img\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--SelectAssigneeValue-->select first record
        public static By  ToDoAssignee_firstRecord = By.xpath("//*[@id=\"lookup_page1_tdrow_[C:1]_ttxt-lb[R:0]\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--Scheduled Finish Date
        public static By  ToDoScheduledDate = By.xpath("//*[@id=\"m6580baa0-tb\"]");
        
        //Xpath for To Do(BCF)--> New ToDo--Days Until Due
        public static By  ToDoDaysUntilDue = By.xpath("//*[@id=\"m3b77e371-tb\"]");

      //Xpath for To Do(BCF)--> New ToDo--Detail Field
        public static By  DetailField = By.xpath("//*[@id=\"dijitEditorBody\"]");
        
      //Xpath for To Do(BCF)--> New ToDo--FontChange Drop Down
        public static By  FontStyle = By.xpath("//*[@id=\"widget_dijit__editor_plugins__FontNameDropDown_2_select\"]/div[1]/input");
        
        
        //Xpath for To Do(BCF)--> New ToDo--Fantsy font
          public static By  FontStyleFantasy = By.xpath("//*[@id=\"dijit__editor_plugins__FontNameDropDown_2_select_popup4\"]");
 
        
        
           
        
        
      
        
        
      
        
      
        
      
        
        
        

     
        
        
      

      

      
        
	    
	     
	     
	     
	     
	
//	    
//	    public void LogInToMaxima(String userNameString, String passwordString) throws Throwable {
//			try {
//
//				// Create alias for the Maximo Login Page Method
//				MaximoLoginPage Login = new MaximoLoginPage();
//				// Create alias for the Maximo Start Center Page Method
//				MaximoStartCenter StartCenter = new MaximoStartCenter();
//				// This Method is Used to Launch the Maximo Application
//				Login.maximoLaunchURL(browser);
//				// This Method is used to verify the Maximo Login Page
//				Login.verifyMaximoLoginPage("Welcome to Maximo");
//				// This Method is used to Login to Maximo
//				Login.maximoLogin(userNameString, passwordString);
//				//SuccessReportWithScreenshot("Maximo Login Successfull");
//				// This Method is used to navigate to "Daily Log" in the Applications
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	    
	
//	    public void ReloadLicenseAndCertifications() throws Throwable {
//			try {
//
//				click(LACListTab_ReloadTableBtn, "Reload License and certifications ");
//				implicityWait(5);
//
//				SuccessReportWithScreenshot("Successfully displayed all License and certifications");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		/**
		 * @Description: Click on New ToDo button
		 * @throws Throwable
		 */
		public void newToDo_CLick() throws Throwable {
			try {

				click(newToDo, "New ToDo");
				implicityWait(10);
				
				SuccessReportWithScreenshot("New ToDo opened Successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		/**
		 * @Description: Click on All Open TODOs Assigned to Me
		 * @throws Throwable
		 */
		public void allOpenTODOsAssignedtoMe_CLick() throws Throwable {
			try {

				click(AllOpenTODOsAssignedtoMe, "All Open TODOs Assigned to Me");
				implicityWait(4);
				
				SuccessReportWithScreenshot("All Open TODOs Assigned to Me page has been opened Successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * @Description: Click on All Open TODOs Assigned to Me
		 * @throws Throwable
		 */
		public void OverdueTODOsAssignedtoMe() throws Throwable {
			try {

				click(OverdueTODOsAssignedtoMe, "Overdue TO-DOs Assigned to Me");
				implicityWait(4);
				
				SuccessReportWithScreenshot("Overdue TO-DOs Assigned to Me page has been opened Successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * @Description: Click on Save Certification
		 * @throws Throwable
		 */
		public void saveToDo_CLick() throws Throwable {
			try {		
				click(newToDoSaveBtn, "Save");
				implicityWait(10);	
				SuccessReportWithScreenshot("New ToDo saved successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    
		/**
		 * @Description: Enter values for New ToDo
		 * @throws Throwable
		 */
		public void enterValuesforNewToDo( 
				String ToDoDescription,String ToDoLocation,String ToDoAssignee) throws Throwable {
			try {	
				
				
				//clear(ToDoDescription);	
				type(ToDoTestBoxDesc,ToDoDescription, "Description");	
				implicityWait(2);
				
				click(ToDolocationArrow, "Location button");
				implicityWait(2);
//				mouseHoverByJavaScript(ToDolocationSelectValue, "Select Value");
//			    implicityWait(2);
//				//mouseHoverByJavaScript(toDo, "To Do");
//				click(ToDolocationSelectValue, "Select Value");			
				implicityWait(3);
				type(ToDoSelectValuelocation,ToDoLocation, "Enter Location");				
			    implicityWait(1);
			    click(ToDoLocationSearchbtn, "Location Search Button");
				implicityWait(2);
				click(ToDoLocation_firstRecord, "Location");	
				implicityWait(3);
				
				click(ToDoAssigneeArrow, "Assignee Arrow Button");	
				implicityWait(2);
				type(ToDoPersonTextBox,ToDoAssignee, "Enter Person");				
			    implicityWait(2);
			    click(ToDoAssigneeSearchbtn, "Search Button");
				implicityWait(20);
				click(ToDoAssignee_firstRecord, "Person");	
				implicityWait(4);
				
				SuccessReportWithScreenshot("Successfully Entered data for ToDo");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		/* @Description: Read and return ToDo  - ToDo  ID
		 * @throws Throwable
		 */
		public String ToDo_ReadReturnToDo() throws Throwable {
			String toDoId = "";
			try {

				toDoId = getXPathAttribute(ToDoId, "value");			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return toDoId;
		}
		/* @Description: Filter the data by ToDo Log ID in List Tab of ToDo Log
		 * @throws Throwable
		 */
		public void ToDoListTab_ToDoIDFilter(String ToDoID) throws Throwable {
			try {
				click(ListTab, "List Tab");	
				implicityWait(2);
				clear(ToDoListTab_Log);
				type(ToDoListTab_Log, ToDoID);
				click(toDo_ListTab_FilterTableBtn, "Filter");		
				implicityWait(2);	
				
				SuccessReportWithScreenshot("Successfully Filtered the ToDo Log");			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/* @Description: Open the filtered record in List Tab of ToDo 
		 * @throws Throwable
		 */
		public void ToDoListTab_OpenSelectedRecord() throws Throwable {
			try {
				click(toDo_ListTab_SelectedRecord, "Selected Record");		
				implicityWait(5);
				
				SuccessReportWithScreenshot("Successfully opened selected ToDo Record");			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * @Description: Update assignee
		 * @throws Throwable
		 */
		public void updateAssignee(String ToDoAssignee) throws Throwable {
			try {	
				
				click(ToDoAssigneeArrow, "Assignee Arrow Button");	
				implicityWait(2);
				type(ToDoPersonTextBox,ToDoAssignee, "Enter Person");				
			    implicityWait(1);
			    click(ToDoAssigneeSearchbtn, "Search Button");
				implicityWait(2);
				click(ToDoAssignee_firstRecord, "Person");	
				implicityWait(2);
							
				SuccessReportWithScreenshot("Assignee has been updated successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
		
		
		//*[@id="m74daaf83_ns_menu_RUNREPORTS_OPTION_a"]
		/**
		 * @Description: Scheduled finish
		 * @throws Throwable
		 */
		public void enterScheduleDate(String scheduledFinishDate) throws Throwable {
			try {		
				implicityWait(2);
				type(ToDoScheduledDate,scheduledFinishDate, "Enter scehduled Finish Date");				
			    implicityWait(2);				
				SuccessReportWithScreenshot("Scheduled Finish date has been entered successfully");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} 

		/* @Description: Read and return DaysUntilDue 
		 * @throws Throwable
		 */
		public String ToDoDaysUntilDue() throws Throwable {
			String toDoDaysUntilDue = "";
			try {
			toDoDaysUntilDue = getXPathAttribute(ToDoDaysUntilDue,"value");
			toDoDaysUntilDue=toDoDaysUntilDue.trim();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return toDoDaysUntilDue;
		}
		
			
		/* @Description: Enter Comments in details field
		 * @throws Throwable
		 */
		public void ToDO_EnterCommentsInDetailsField(String Comments) throws Throwable {
			try {
				//click(DetailsField, "Details Field");
				//type(DetailField, Comments);
				//JSEnter(DetailsField, Comments);
				WebElement frame = driver.findElement(By.id("m1f7bb5c6-rte_iframe"));
				driver.switchTo().frame(frame);
				WebElement messagebox = driver.findElement(By.id("dijitEditorBody"));
				messagebox.clear();
				messagebox.click();
				messagebox.sendKeys(Comments);
				driver.switchTo().window(driver.getWindowHandle());

				implicityWait(2);				
				SuccessReportWithScreenshot("Comments has been entered successfully");			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/* @Description: Change font options in details screen
		 * @throws Throwable
		 */
		public void ToDO_ChangeFontOptions() throws Throwable { 
			try {
				implicityWait(2);
				click(FontStyle, "Font change Drop down");
				implicityWait(2);
				mouseHoverByJavaScript(FontStyleFantasy, "Safey and Quality Management");
			    implicityWait(1);
				click(FontStyleFantasy,"fantasy");
				//type(FontSize, fontStyle);
				SuccessReportWithScreenshot("Font style has been changed successfully");			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
}
	
	
	
	
	
	
	
	
	
	
