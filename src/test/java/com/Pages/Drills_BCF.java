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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accelerators.ActionEngine;
import com.accelerators.CredentialManager;
import com.relevantcodes.extentreports.LogStatus;

public class Drills_BCF extends ActionEngine {	
	
	//x-path for creating new drills button
	public static By newDrills = By.xpath("//img[@id = \"toolactions_INSERT-tbb_image\"]");
	//x-path for saving drills button
	public static By saveDrills = By.xpath("//img[@id = \"toolactions_SAVE-tbb_image\"]");
	//x-path for Clear Drill Changes button
	public static By clearDrillsChanges = By.xpath("//img[@id = \"toolactions_CLEAR-tbb_image\"]");
	//x-path for Drills BCF - List Tab
	public static By drillsListTab = By.xpath("//a[@id = \"m9fa3e414-tab_anchor\"]");
	//x-path for Drills BCF - Drills Tab
	public static By drillsDrillTab = By.xpath("//a[@id = \"mbf28cd64-tab_anchor\"]");
	
	//x-path for New Drill - Drill Field
	public static By newDrills_DrillField = By.xpath("//input[@id = \"m8ee1358-tb\"]");
	//x-path for New Drill - Description Field
	public static By newDrills_DrillDescription = By.xpath("//input[@id = \"m8ee1358-tb2\"]");
	//x-path for New Drill - Attachment Field
	public static By newDrills_Attachments = By.xpath("//img[@id = \"md5bd66d5-ti_img\"]");
	//x-path for New Drill - Attachments - Add New Attachment
	public static By newDrills_Attachments_AddNewAttachmentnode = By.xpath("//span[@id = \"ATTACHMENTS_addnew_a_tnode\"]");
	//x-path for New Drill - Attachments - Add New Attachment - Add New File
	public static By AddNewAttachmentnode_AddNewFile = By.xpath("//span[@id = \"ATTACHMENTS_addnew_sub_addnewfile_a_tnode\"]");
	//x-path for New Drill - Details - Template Type Drop-down
	public static By newDrills_Details_TemplateType_DrpDpwn = By.xpath("//img[@id = \"m11a9087a-img\"]");
	
	//x-path for Attachment - Add New File - Create File Attachment - Select a Folder Dropdown
	public static By newDrills_CreateFileAttachment_SelectFolderDropdown = By.xpath("//img[@id = \"me291f373-img\"]");
	//x-path for Attachment - Add New File - Create File Attachment - Choose File
	public static By newDrills_CreateFileAttachment_ChooseFile = By.xpath("//input[@id = \"file\"]");
	//x-path for Attachment - Add New File - Create File Attachment - Description
	public static By newDrills_CreateFileAttachment_Description = By.xpath("//input[@id = \"mbf25646-tb\"]");
	//x-path for Attachment - Add New File - Create File Attachment - OK Button
	public static By newDrills_CreateFileAttachment_OKBtn = By.xpath("//button[@id = \"m781c76a7-pb\"]");

}
