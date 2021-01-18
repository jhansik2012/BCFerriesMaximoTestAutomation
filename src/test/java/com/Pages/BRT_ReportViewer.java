/**
 * @Author Venkata Vijay Raju P
 * @Date Jan 28, 2020
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

public class BRT_ReportViewer extends ActionEngine {
		
	//x-path for Days from Last Drill value
	public static By bRTReport_DaysFromLastDrill = By.xpath("//*[@id=\"__bookmark_1\"]/tbody/tr[6]/td[9]/div");//("//td[@class = \"style_13\"]/following-sibling::td[8]");
	public static By bRTReport_DaysFromLastDrillvalue = By.xpath("//td[@class = \"style_13\"]/following-sibling::td[8]/div");

}
