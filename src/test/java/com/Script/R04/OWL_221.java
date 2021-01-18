
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

public class OWL_221 extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_221(String browser,Method method) throws Throwable {
				
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String LACcategory = tstData.get("LACcategory");		
			String LACLocation = tstData.get("LACLocation");			
			String LACissueDate = tstData.get("LACissueDate");			
			String LAcexpiryDate = tstData.get("LAcexpiryDate");			
			String LAcawardedBy = tstData.get("LAcawardedBy");
			String LAClicense_CertificateNumber = tstData.get("LAClicense_CertificateNumber");
			String LACowner = tstData.get("LACowner");
			String Comments = tstData.get("Comments");

			
	
			
			
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
			

			//This method is used to click new certification
			license_And_Certificate_BCF.NewCertification_CLick();
			
			// This method is used to enter values in License and Certification 
			license_And_Certificate_BCF.EnterValuesforLicenseAndCertificate(LACcategory, LACLocation,LACowner,LACissueDate, LAcexpiryDate, LAcawardedBy,LAClicense_CertificateNumber);
			
			
			// This method is used to enter comments in Details Field
			license_And_Certificate_BCF.LicenseAndCertificate_EnterCommentsInDetailsField(Comments);
			
			
			
			// This Method is used to save Certification
			license_And_Certificate_BCF.SaveCertification_CLick();
			
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
