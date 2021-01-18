
/**
 * @Author Satish Kumar A
 * @Date April 2, 2020
 */

package com.Script.R03;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pages.DailyLog_BCF;
import com.Pages.License_And_Certificate_BCF;
import com.Pages.MaximoLoginPage;
import com.Pages.MaximoStartCenter;
import com.Pages.ToDo_BCF;
import com.accelerators.ActionEngine;
import com.utilities.Data_Provider;

public class OWL_129 extends ActionEngine {

	@SuppressWarnings("static-access")
	@Test
	@Parameters({ "browser" })
	public void OWL_129(String browser, Method method) throws Throwable {

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
			String ToDoLocation = tstData.get("ToDoLocation");
			String ScheduledFinishDate = tstData.get("ScheduledFinishDate");

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

			// This method is used to click new ToDo
			toDo_BCF.newToDo_CLick();

			// This method is used to enter values in ToDo
			toDo_BCF.enterValuesforNewToDo(ToDoDescription, ToDoLocation, ToDoAssignee1);
			
			//toDo_BCF.ToDO_EnterCommentsInDetailsField("sdsads");
	
			// This Method is used to enter Scheduled finish date
			toDo_BCF.enterScheduleDate(ScheduledFinishDate);

			// This Method is will return Days Until Due
			String ToDoDaysUntilDueBeforeSave = toDo_BCF.ToDoDaysUntilDue();

			// This Method is used to save ToDo
			toDo_BCF.saveToDo_CLick();

			// This Method is will return Days Until Due
			String ToDoDaysUntilDueAfterSave = toDo_BCF.ToDoDaysUntilDue();
			assertValueNotEqual(ToDoDaysUntilDueBeforeSave, ToDoDaysUntilDueAfterSave);

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
