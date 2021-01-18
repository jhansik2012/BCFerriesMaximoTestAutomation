
/**
 * @Author Satish Kumar A
 * @Date April 8, 2020
 */

package com.Script.R04;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.License_And_Certificate_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_416 extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_416(String browser,Method method) throws Throwable {
				
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String LACcategory1 = tstData.get("LACcategory1");					
			String LACcategory2 = tstData.get("LACcategory2");	
			String LACLocation = tstData.get("LACLocation");			
			String LACStatus1 = tstData.get("LACStatus1");				
			String LACStatus2 = tstData.get("LACStatus2");				

			
			
			// Create alias for the Maximo Login Page Method
			MaximoLoginPage MaximoLogin = new MaximoLoginPage();
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();			
			
			// Create alias for the License And Certificate_BCF Page Method
			License_And_Certificate_BCF license_And_Certificate_BCF = new License_And_Certificate_BCF();		
			
			// This method is for Initialization method for Daily Log Module
			MaximoLogin.LogInToMaxima(userNameString, passwordString);
			
			// This method is used to navigate to License and Certification
			StartCenter.navigateToLicenseAndCertificate();			

			//This method is used to Reload the filters in List Page
			license_And_Certificate_BCF.LandC_ListPage_ReloadFilters();			
			
			// This method is used to Search by Location 
			license_And_Certificate_BCF.LandC_Location_Filter(LACLocation);				
			
			// This method is used to get the Record Count
			license_And_Certificate_BCF.LandC_ListPage_RecordCount();			
			
			// This method is used to Clear the filter 
			license_And_Certificate_BCF.LandC_ListPage_ClearFilters();	
			
			// This method is used to Search by Category 
			license_And_Certificate_BCF.LandC_Category_Filter(LACcategory1);				
			
			// This method is used to get the Record Count
			license_And_Certificate_BCF.LandC_ListPage_RecordCount();			
			
			// This method is used to Clear the filter 
			license_And_Certificate_BCF.LandC_ListPage_ClearFilters();	
			
			// This method is used to Search by Category 
			license_And_Certificate_BCF.LandC_Category_Filter(LACcategory2);				
			
			// This method is used to get the Record Count
			license_And_Certificate_BCF.LandC_ListPage_RecordCount();			
			
			// This method is used to Clear the filter 
			license_And_Certificate_BCF.LandC_ListPage_ClearFilters();	
			
			// This method is used to Search by Status 
			license_And_Certificate_BCF.LandC_Status_Filter(LACStatus1);				
			
			// This method is used to get the Record Count
			license_And_Certificate_BCF.LandC_ListPage_RecordCount();			
			
			// This method is used to Clear the filter 
			license_And_Certificate_BCF.LandC_ListPage_ClearFilters();	
			
			// This method is used to Search by Status 
			license_And_Certificate_BCF.LandC_Status_Filter(LACStatus2);			
			
			// This method is used to get the Record Count
			license_And_Certificate_BCF.LandC_ListPage_RecordCount();			
			
			// This method is used to Clear the filter 
			license_And_Certificate_BCF.LandC_ListPage_ClearFilters();
			
			// This Method is used to Log Off from Maximo
       		StartCenter.logOffMaximo();
			
			/**********************
			 * Script Ends here
			 *******************************************/

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
