
/**
 * @Author Satish Kumar A
 * @Date April 2, 2020
 */

package com.Script.R03;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.License_And_Certificate_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.Pages.ToDo_BCF;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_118 extends ActionEngine {
	
	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_118(String browser,Method method) throws Throwable {
				
		try {

			/**********************
			 * Script Start from here
			 *******************************************/
			tstData = Data_Provider.getTestData(method.getName(), method.getName());
			test = extent.startTest(method.getName(), tstData.get("Description"));
			
			// Read all the variables from the Test Data sheet
			String userNameString = tstData.get("UserName");
			String passwordString = tstData.get("Password");				
			String ToDoDescription = tstData.get("ToDoDescription");		
			String ToDoAssignee1 = tstData.get("ToDoAssignee1");	
			String ToDoAssignee2 = tstData.get("ToDoAssignee2");
			String ToDoLocation = tstData.get("ToDoLocation");			
			
			
	
			
			
			// Create alias for the Maximo Login Page Method
			MaximoLoginPage MaximoLogin = new MaximoLoginPage();
			
			// Create alias for the Maximo Start Center Page Method
			MaximoStartCenter StartCenter = new MaximoStartCenter();
			
			
			// Create alias for the License And Certificate_BCF Page Method
			ToDo_BCF toDo_BCF = new ToDo_BCF();		
			
			// This method is for Initialization method for Daily Log Module
			MaximoLogin.LogInToMaxima(userNameString, passwordString);
			
			// This method is used to navigate to ToDo
			StartCenter.navigateToToDoList();
			

			//This method is used to click new ToDo
			toDo_BCF.newToDo_CLick();		
			
			// This method is used to enter values in ToDo 
			toDo_BCF.enterValuesforNewToDo(ToDoDescription,ToDoLocation, ToDoAssignee1);
			
			// Read the ToDo- ToDo Log ID and save it to a variable
			String ToDo = toDo_BCF.ToDo_ReadReturnToDo();
			
			// This Method is used to save ToDo
		    toDo_BCF.saveToDo_CLick();
			
			// This Method is used to Filter the data by ToDo Log ID in List Tab of ToDo Log
            toDo_BCF.ToDoListTab_ToDoIDFilter(ToDo);
            
         // This Method is used to Open the filtered record in List Tab of ToDo
         	toDo_BCF.ToDoListTab_OpenSelectedRecord();
         	
         // This Method is used to update assignee
         	toDo_BCF.updateAssignee(ToDoAssignee2);	
   			
			// This Method is used to save ToDo
			toDo_BCF.saveToDo_CLick();
				
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
