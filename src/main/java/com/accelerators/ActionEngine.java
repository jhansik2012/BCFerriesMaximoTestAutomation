/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

package com.accelerators;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.LogStatus;

import com.utilities.GetScreenShot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ActionEngine extends TestEngine {

	public WebDriverWait wait;
	public Alert newAlert;
	boolean b = true;

	/**
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 * @return --boolean (true or false)
	 * @throws Throwable
	 */

	public boolean clear(By locator) throws Throwable {

		ExplicitWaitOnElementToBeClickable(locator);
		boolean flag = false;
		try {
			driver.findElement(locator).clear();
			flag = true;
//			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Clear Field " );
				FailNum = FailNum + 1;
				return true;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Clear Field");
			}
		}
		return flag;
	}


	/**
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 * @return --boolean (true or false)
	 * @throws Throwable
	 */

	public boolean click(By locator, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			ExplicitWaitOnElementToBeClickable(locator);
			driver.findElement(locator).click();
			flag = true;
//			Thread.sleep(8000);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to click on " + locatorName);
				FailNum = FailNum + 1;
				return true;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Successfully clicked on " + locatorName);
			}
		}
		return flag;
	}

	
	/**
	 * This method returns check existence of element
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Textbox, checkbox etc)
	 * @return: Boolean value(True or False)
	 * @throws NoSuchElementException
	 */
	public boolean isElementPresent(By by, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			driver.findElement(by);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (!flag) {
				failureReport("Element Present :: ", locatorName + " is not present on the page");
			} else if (b && flag) {
				SuccessReport("Element Present :: ", locatorName + " present on the page");
			}

		}
	}

	
	public boolean isElementNotPresent(By by, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			driver.findElement(by);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (!flag) {
				SuccessReport("Element Present :: ", locatorName + " is not present on the page");
			} else if (b && flag) {
				failureReport("Element Present :: ", locatorName + " is  present on the page");

			}

		}
	}


	/**
	 * This method used type value in to text box or text area
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param testdata
	 *            : Value wish to type in text box / text area
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Textbox,Text Area etc..)
	 * 
	 * @throws NoSuchElementException
	 */
	public boolean type(By locator, String testdata, String locatorName) throws Throwable {
		ExplicitWaitOnElementToBeClickable(locator);
		boolean flag = false;
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).click();
			driver.findElement(locator).sendKeys(testdata);
			flag = true;

		} catch (Exception e) {
			// FailureReportWithScreenshot("LoginPage");
		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to find --> " + locatorName + ", with data ---> " + testdata.replace(":", "")
				+ test.addScreenCapture(GetScreenShot.captureScreenshot(driver, locatorName)));
				FailNum++;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Able to enter data in -->  " + locatorName + ", with data ---> " 
						+ testdata.replace(":", ""));

			}
		}
		return flag;
	}
	
	
	
	
	/**
	 * This method used type value in to rich text area
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param testdata
	 *            : Value wish to type in text box / text area
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Textbox,Text Area etc..)
	 * 
	 * @throws NoSuchElementException
	 */
	public boolean richTextType(By iframelocator, By locator, String testdata, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement frame = driver.findElement(iframelocator);
	        driver.switchTo().frame(frame);
	        WebElement messagebox = driver.findElement(locator);
	        messagebox.click();
	        messagebox.sendKeys(testdata);
	        driver.switchTo().window(driver.getWindowHandle());
			flag = true;

		} catch (Exception e) {
			// FailureReportWithScreenshot("LoginPage");
		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to Enter data in --> " + locatorName + 
						test.addScreenCapture(GetScreenShot.captureScreenshot(driver, locatorName)));
				FailNum++;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Able to enter data in -->  " + locatorName);

			}
		}
		return flag;
	}
	
	

	/**
	 * This method used type value in to text box or text area
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param testdata
	 *            : Value wish to type in text box / text area
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Textbox,Text Area etc..)
	 * 
	 * @throws NoSuchElementException
	 */
	public boolean type(By locator, String testdata) throws Throwable {
		ExplicitWaitOnElementToBeClickable(locator);
		boolean flag = false;
		try {
			driver.findElement(locator).sendKeys(testdata);
			flag = true;

		} catch (Exception e) {
			
		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to find --> " + testdata + ", with data ---> " + testdata.replace(":", "")
				+ test.addScreenCapture(GetScreenShot.captureScreenshot(driver, testdata)));
				FailNum++;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Able to enter --> " + testdata + ", with data ---> " + testdata.replace(":", ""));
			}
		}
		return flag;
	}



	/**
	 * To right click on an element
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 * 
	 * @throws Throwable
	 */

	public boolean rightclick(By by, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			WebElement elementToRightClick = driver.findElement(by);
			Actions clicker = new Actions(driver);
			clicker.contextClick(elementToRightClick).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				failureReport("RightClick :: ", "RightClick action is not perform on " + locatorName);

			} else if (b && flag) {
				SuccessReport("RightClick :: ", "RightClick Action is Done on " + locatorName);
			}
		}
	}


	/**
	 * Wait for an element
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 */

	public boolean waitForTitlePresent(By locator) throws Throwable {

		boolean flag = false;
		boolean bValue = false;
		
		try {
			for (int i = 0; i < 200; i++) {
				if (driver.findElements(locator).size() > 0) {					
					flag = true;
					bValue = true;
					break;
				} else {
					driver.wait(50);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				failureReport("WaitForTitlePresent :: ", "Title is wrong");

			} else if (b && flag) {
				SuccessReport("WaitForTitlePresent :: ", "Expected Title ");
			}
		}
		return bValue;
	}

	/**
	 * Wait for an ElementPresent
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @return Whether or not the element is displayed
	 */
	public boolean waitForElementPresent(By by, String locator) throws Throwable {
		boolean flag = false;
		try {
			for (int i = 0; i < 500; i++) {
				if (driver.findElement(by).isDisplayed()) {
					flag = true;
					return true;

				} else {
//					Thread.sleep(500);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (!flag) {
				failureReport("WaitForElementPresent :: ", "Falied to locate element ---> " + locator);
			} else if (b && flag) {
				SuccessReport("WaitForElementPresent :: ", "Successfully located element ---> " + locator);
			}
		}

		return flag;

	}

	/**
	 * This method Click on element and wait for an element
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param waitElement
	 *            : Element name wish to wait for that (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 */
	public boolean clickAndWaitForElementPresent(By locator, By waitElement, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			click(locator, locatorName);
			waitForElementPresent(waitElement, locatorName);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (!flag) {
				failureReport("ClickAndWaitForElementPresent :: ",
						"Failed to perform clickAndWaitForElementPresent action");
			} else if (b && flag) {
				SuccessReport("ClickAndWaitForElementPresent :: ",
						"successfully performed clickAndWaitForElementPresent action");
			}
		}
	}

	/**
	 * Select a value from Dropdown using send keys
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param value
	 *            : Value wish type in dropdown list
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Year Dropdown, items
	 *            Listbox etc..)
	 * 
	 */
	public boolean selectBySendkeys(By locator, String value, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			driver.findElement(locator).sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				failureReport("Select :: ", value + " is Not Select from the DropDown ---> " + locatorName);

			} else if (flag) {
				SuccessReport("Select :: ", value + " is Selected from the DropDown ---> " + locatorName);
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param index
	 *            : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Year Dropdown, items
	 *            Listbox etc..)
	 * 
	 */
	public boolean selectByIndex(By locator, int index, String locatorName) throws Throwable {
		ExplicitWaitOnElementToBeClickable(locator);
		boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				failureReport("Select ", "Option at index --> " + index + ", is Not Select from the DropDown ---> " + locatorName);

			} else if (b && flag) {
				SuccessReport("Select ", "Option at index --> " + index + ", is Selected from the DropDown ---> " + locatorName);
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param value
	 *            : Value wish to select from dropdown list.
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Year Dropdown, items
	 *            Listbox etc..)
	 */

	public boolean selectByValue(By locator, String value, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			s.selectByValue(value);
//			Thread.sleep(2000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				failureReport("Select ",
						"Option with value attribute --> " + value + ", is Not Select from the DropDown ---> " + locatorName);

			} else if (b && flag) {
				SuccessReport("Select ",
						"Option with value attribute --> " + value + ", is  Selected from the DropDown ---> " + locatorName);
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param visibletext
	 *            : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Year Dropdown, items
	 *            Listbox etc..)
	 */

	public boolean selectByVisibleText(By locator, String visibletext, String locatorName) throws Throwable {
		boolean flag = false;
		try {

			Select s = new Select(driver.findElement(locator));
//			Thread.sleep(2000);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				failureReport("Select --> ", visibletext + ", is Not Selected from the DropDown ---> " + locatorName);

			} else if (b && flag) {
				SuccessReport("Select --> ", visibletext + ",  is Selected from the DropDown ---> " + locatorName);
			}
		}
	}

	public boolean selectDropDownValue(By locator, By locatorOfOption, String visibletext, String locatorName)
			throws Throwable {
		System.out.println(".");
		boolean flag = false;
		Select s = new Select(driver.findElement(locator));
		try {
			int li = driver.findElements(locatorOfOption).size();
			List<WebElement> ss = driver.findElements(locatorOfOption);
			for (int i = 0; i < li; i++) {
				if (ss.get(i).getText().contains(visibletext)) {
					System.out.println(ss.get(0).getText());
					s.selectByVisibleText(ss.get(i).getText());
					flag = true;
					break;
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				failureReport("Select --> ", visibletext + ", is Not Select from the DropDown ---> " + locatorName);

			} else if (b && flag) {
				SuccessReport("Select --> ", visibletext + ",  is Selected from the DropDown ---> " + locatorName);
			}
		}
	}

	public boolean selectDropDownByClick(By locator, By locatorOfOption, String visibletext, String locatorName)
			throws Throwable {
		System.out.println(".");
		boolean flag = false;
		click(locator, "");
		try {
			int li = driver.findElements(locatorOfOption).size();
			List<WebElement> ss = driver.findElements(locatorOfOption);
			for (int i = 1; i < li; i++) {
				driver.findElement(locator).sendKeys(Keys.ARROW_DOWN);
				if (ss.get(i).getText().contains(visibletext)) {
					System.out.println(ss.get(i).getText());
					driver.findElement(locator).sendKeys(Keys.ENTER);
					flag = true;
					break;
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				failureReport("Select --> ", visibletext + ", is Not Select from the DropDown ---> " + locatorName);

			} else if (b && flag) {
				SuccessReport("Select --> ", visibletext + ", is Selected from the DropDown ---> " + locatorName);
			}
		}
	}

	/**
	 * Select the window by using getTitle().
	 * 
	 * @param windowTitle
	 *            Input as Title Name Contains of Text
	 */
	public void switchToWindowByTitle(String windowTitle) {
		try {
			driver.getTitle().contains(windowTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Switch to the newly opened Chrome Tab.
	 * 
	 */
	public void switchNewChromeTab() {
		try {
			for(String curWindow : driver.getWindowHandles()){
				driver.switchTo().window(curWindow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Close Chrome Tab.
	 * 
	 */
	public void closeChromeTab() {
		try {
			driver.close();
			for(String curWindow : driver.getWindowHandles()){
				driver.switchTo().window(curWindow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Function To get column count and print data in Columns
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @return: Returns no of columns.
	 * 
	 */
	public int getColumncount(By locator) throws Exception {

		WebElement tr = driver.findElement(locator);
		List<WebElement> columns = tr.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;

	}

	/**
	 * Function To get row count and print data in rows
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @return: returns no of rows.
	 */
	public int getRowCount(By locator) throws Exception {

		WebElement table = driver.findElement(locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	public boolean Alert() throws Throwable {
		boolean flag = false;
		boolean presentFlag = false;
		Alert alert = null;

		try {
			alert = driver.switchTo().alert();
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
		} finally {
			if (presentFlag) {
			} else if (b && flag) {
				SuccessReport("Alert :: ", "The Alert is handled successfully ");
			}
		}

		return presentFlag;
	}

	public boolean launchUrl(String url) throws Throwable {
		boolean flag = false;
		String Url1 = "";
		try {
			driver.navigate().to(url);
			if (url.length() >= 70)
				Url1 = url.substring(0, 70) + "...";
			else
				Url1 = url;
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (!flag) {
				// test.log(LogStatus.FAIL, "Launching URL ", "Failed to launch
				// " + Url1);
				failureReport("Launching URL :: ", "Failed to launch ---> " + Url1);
			} else if (b && flag) {
				// test.log(LogStatus.PASS, "Launching URL ", "Successfully
				// launched" + Url1);
				SuccessReport("Launching URL :: ", "Successfully launched ---> " + Url1);
			}
		}
	}

	
	// method for implicit wait
	public void ToDoAssigneeArrow(int sec) {
		try {
			Thread.sleep(1000 * sec);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	
	// method for explicit wait
	public void explicityWait(By locator) {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	// method for implicit wait
		public void implicityWait(int sec) {
			try {
				Thread.sleep(1000 * sec);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	
	
	// method for explicit wait for element to be invisible
	public void explicityWait_ElementInvisible(By locator) {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	// method for explicit wait for element to be visible
		public void explicityWait_ElementVisible(By locator) {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		

	@Parameters({ "browser" })
	public void AddStep(String strStepDes) throws Throwable {
		addStep(strStepDes);

	}

	public void scrollingToElementofAPage(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Check the expected value is available or not
	 * 
	 * @param expvalue
	 *            : Expected value of attribute
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param attribute
	 *            : Attribute name of element wish to assert
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:link text, label text
	 *            etc..)
	 * 
	 */
	public boolean assertValue(String expvalue, By locator, String attribute, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			AssertJUnit.assertEquals(expvalue, getAttribute(locator, attribute, locatorName));
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				failureReport("AssertValue :: ", locatorName + ", is not present in the page");
				return false;
			} else if (b & flag) {
				SuccessReport("AssertValue :: ", locatorName + ", is present in the page ");
			}
		}
		return flag;
	}
	
	
	/**
	 * Assert the matching of Expected and Actual Values
	 * 
	 */
	public boolean assertValueEqual(String expvalue, String actvalue) throws Throwable {

		boolean flag = false;
		try {
			AssertJUnit.assertEquals(expvalue, actvalue);
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				failureReport("AssertValue :: ", "Values are not equal");
				return false;
			} else if (b & flag) {
				SuccessReport("AssertValue :: ", "Values are equal");
			}
		}
		return flag;
	}
	

	/**
	 * Assert the not matching of Expected and Actual Values
	 * 
	 */
	public boolean assertValueNotEqual(String expvalue, String actvalue) throws Throwable {

		boolean flag = false;
		try {
			AssertJUnit.assertEquals(expvalue, actvalue);
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				SuccessReport("AssertValue :: ", "Values are not equal");

				return false;
			} else if (b & flag) {
				failureReport("AssertValue :: ", "Values are  equal");
			}
		}
		return flag;
	}
	/**
	 * Check the text is presnt or not
	 * 
	 * @param text
	 *            : Text wish to assert on the page.
	 * 
	 */
	public boolean assertTextPresent(String text) throws Throwable {
		boolean flag = false;
		try {
			Assert.assertTrue(isTextPresent(text));
			flag = true;
		} catch (Exception e) {

		} finally {
			if (!flag) {
				failureReport("AssertTextPresent :: ", text + ", is not present in the page ");
				return false;
			} else if (b & flag) {
				SuccessReport("AssertTextPresent :: ", text + ", is present in the page ");
			}
		}
		return flag;
	}

	/**
	 * Assert element present or not
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:Login Button, SignIn Link
	 *            etc..)
	 * 
	 */
	public boolean assertElementPresent(By by, String locatorName) throws Throwable {

		boolean flag = false;
		try {
			AssertJUnit.assertTrue(isElementPresent(by, locatorName));
//			Thread.sleep(1000);
			flag = true;

		} catch (Exception e) {

		} finally {
			if (!flag) {
				failureReport("AssertElementPresent :: ", locatorName + ", is not present in the page ");
				return false;
			} else if (b & flag) {
				SuccessReport("AssertElementPresent :: ", locatorName + ", is present in the page ");
			}
		}
		return flag;

	}

	/**
	 * Assert text on element
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param text
	 *            : expected text to assert on the element
	 * 
	 */

	public boolean assertText(By by, String text) throws Throwable {
		boolean flag = false;
		try {
			Assert.assertEquals(getText(by, text).trim(), text.trim());
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				failureReport("AssertText :: ", text + ", is not present in the element ");
				return false;

			} else if (b && flag) {
				SuccessReport("AssertText :: ", text + ", is  present in the element ");
			}
		}

	}

	/**
	 * Assert text on element
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param text
	 *            : expected text to assert on the element
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:link text, label text
	 *            etc..)
	 * 
	 */
	public boolean verifyText(By by, String text, String locatorName) throws Throwable {
		boolean flag = false;

		try {

			String vtxt = getText(by, locatorName).trim();
			vtxt.equals(text.trim());
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (!flag) {
				failureReport("VerifyText :: ", text + ", is not present in the location ---> " + locatorName);
				flag = true;
			} else if (b && flag) {
				SuccessReport("VerifyText :: ", text + ", is present in the location ---> " + locatorName);
				flag = false;
			}
		}
	}

	/**
	 * @return: return title of current page.
	 * 
	 * @throws Throwable
	 */

	public String getTitle() throws Throwable {

		String text = driver.getTitle();
//		if (b) {
//			SuccessReport("Title ", "Title of the page is " + text);
//		}
		return text;
	}

	/**
	 * Assert Title of the page.
	 * 
	 * @param title
	 *            : Expected title of the page.
	 * 
	 */
	public boolean assertTitle(String title) throws Throwable {
		boolean flag = false;

		try {
			By windowTitle = By.xpath("//title[contains(text(),'" + title + "')]");
			if (waitForTitlePresent(windowTitle)) {
				AssertJUnit.assertEquals(getTitle(), title);
				flag = true;
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		} finally {

			if (!flag) {
				failureReport("AsserTitle :: ", "Page title is not matched with --> " + title);
				return false;
			} else if (b && flag) {
				SuccessReport("AsserTitle :: ", " Page title is verified with --> " + title);
			}
		}

	}

	/**
	 * Verify Title of the page.
	 * 
	 * @param title
	 *            : Expected title of the page.
	 * 
	 */
	public boolean verifyTitle(String title) throws Throwable {

		boolean flag = false;

		try {
			getTitle().equals(title);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		}

		finally {
			if (!flag) {
				failureReport("VerifyTitle :: ", "Page title is not matched with ---> " + title);

			} else if (b && flag) {
				SuccessReport("VerifyTitle :: ", " Page title is verified with ---> " + title);

			}
		}
	}

	/**
	 * Verify text present or not
	 * 
	 * @param text
	 *            : Text wish to verify on the current page.
	 * 
	 */
	public boolean verifyTextPresent(String text) throws Throwable {
		boolean flag = false;
		;
		if (!(driver.getPageSource()).contains(text)) {

			failureReport("VerifyTextPresent :: ", text + ", is not present in the page ");
			flag = false;
		} else if (b && flag) {
			SuccessReport("VerifyTextPresent :: ", text + ", is present in the page ");
			flag = true;

		}
		return flag;
	}

	/**
	 * Get the value of a the given attribute of the element.
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param attribute
	 *            : Attribute name wish to assert the value.
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:label, SignIn Link etc..)
	 * 
	 * @return: String attribute value
	 * 
	 */

	public String getAttribute(By by, String attribute, String locatorName) throws Throwable {
		String value = "";
		if (isElementPresent(by, locatorName)) {
			value = driver.findElement(by).getAttribute(attribute);
		}
		return value;
	}

	/**
	 * Text present or not
	 * 
	 * @param text
	 *            : Text wish to verify on current page
	 * 
	 * @return: boolean value(true: if Text present, false: if text not present)
	 */

	public boolean isTextPresent(String text) throws Throwable {

		boolean value = false;
		if (driver.getPageSource().contains(text)) {
			value = true;
			SuccessReport("IsTextPresent :: ", "'" + text + "'" + " is present in the page ");
			flag = true;

		} else {
			System.out.println("is text " + text + " present  " + value);
			failureReport("IsTextPresent :: ", text + " is  not present in the page ");
			flag = false;
		}
		return value;
	}

	/**
	 * Text present or not
	 * 
	 * @param text
	 *            : Text wish to verify on current page
	 * 
	 * @return: boolean value(true: if Text present, false: if text not present)
	 */

	public boolean isTextPresentNegative(String text) throws Throwable {

		boolean value = false;
		if (driver.getPageSource().contains(text)) {
			value = true;
			flag = true;
		} else {
			System.out.println("is text " + text + " present  " + value);
			flag = false;
		}
		return value;
	}

	/**
	 * The innerText of this element.
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:label text, SignIn Link
	 *            etc..)
	 * 
	 * @return: String return text on element
	 * 
	 */

	public String getText(By locator, String locatorName) throws Throwable {
		ExplicitWaitOnElementToBeClickable(locator);
		String text = "";
		boolean flag = false;
		try {
			// if (isElementPresentNegative(locator, locatorName)) {
			text = driver.findElement(locator).getText();
			System.out.println("get text" + text);
			flag = true;
			// }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				failureReport("GetText :: ", " Unable to get Text from ---> " + locatorName);
			} else if (b && flag) {
				SuccessReport("GetText :: ", " Able to get Text from ---> " + text);
			}
		}
		return text;
	}

	public String getValue(By locator, String locatorName) throws Throwable {
		String text = "";
		boolean flag = false;
		try {
			if (driver.findElement(locator).isDisplayed()) {
				text = driver.findElement(locator).getAttribute("value");
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				failureReport("GetValue :: ", " Unable to get Text from ---> " + locatorName);
			} else if (b && flag) {
				SuccessReport("GetValue :: ", " Able to get Text from ---> " + locatorName);
			}
		}
		return text;
	}

	public int getElementsSize(By locator, String locatorName) throws Throwable {
		int text = 0;
		try {
			if (driver.findElement(locator).isDisplayed()) {
				text = driver.findElements(locator).size();
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return text;
	}

	/**
	 * Capture Screenshot
	 * 
	 * @param fileName
	 *            : FileName screenshot save in local directory
	 * 
	 */
	public void screenShot(String fileName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Click on the Link
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:SignIn Link, menu's
	 *            etc..)
	 */

	public boolean mouseHoverByJavaScript(By locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = driver.findElement(locator);
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				failureReport("MouseOver :: ", " MouseOver action is not performed on ---> " + locatorName);
			} else if (b && flag) {
				SuccessReport("MouseOver :: ", " MouserOver Action is Done on ---> " + locatorName);
			}
		}
	}

	public boolean JSClick(By locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			flag = true;
		}

		catch (Exception e) {

		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to Click on " + locatorName
						+ test.addScreenCapture(GetScreenShot.captureScreenshot(driver, locatorName)));
				FailNum++;
				return flag;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Able to Succesfully Click on " + locatorName);
				return flag;
			}
		}
		return flag;
	}

	public boolean JSEnter(By locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].value;", element);
			flag = true;
		}

		catch (Exception e) {

		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to enter " + locatorName
						+ test.addScreenCapture(GetScreenShot.captureScreenshot(driver, locatorName)));
				FailNum++;
				return flag;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Able to Succesfully enter " + locatorName);
				return flag;
			}
		}
		return flag;
	}

	/**
	 * This method wait selenium until element present on web page.
	 */
//	public void ImplicitWait() {
//
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//	}



	public boolean waitUntilTextPresents(By by, String expectedText, String locator) throws Throwable {
		wait = new WebDriverWait(driver, 10);
		boolean flag = false;

		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(by, expectedText));
			flag = true;
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				failureReport("WaitUntilTextPresent :: ",
						" Falied to locate element --> " + locator + ", with text ---> " + expectedText);
			} else if (b && flag) {
				SuccessReport(" WaitUntilTextPresent :: ",
						" Successfully located element --> " + locator + ", with text ---> " + expectedText);
			}

		}

	}


	/**
	 * This method wait selenium until visibility of Elements on WebPage.
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * @throws Throwable
	 * 
	 */

	public boolean waitForVisibilityOfElement(By by, String locator) throws Throwable {
		boolean flag = false;
//		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (!flag) {
				failureReport("WaitForVisibilityOfElement ", " Element " + locator + " is not visible");
			} else if (b && flag) {
				SuccessReport("WaitForVisibilityOfElement ", " Element " + locator + "  is visible");
			}
		}
	}

	/**
	 * This method wait driver until Invisibility of Elements on WebPage.
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 */
	public boolean waitForInVisibilityOfElement(By by, String locator) throws Throwable {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			flag = true;
			return flag;
		} catch (Exception e) {
			return false;
		}

	}

	public List<WebElement> getElements(By locator) {

		List<WebElement> ele = driver.findElements(locator);

		return ele;
	}

	public boolean assertTextMatching(By by, String text, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			String ActualText = getText(by, text).trim();
			if (ActualText.contains(text)) {
				flag = true;
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (!flag) {
				failureReport("Verify " + locatorName, text + " is not present in the element");
				return false;

			} else if (b && flag) {
				SuccessReport("Verify " + locatorName, text + " is  present in the element ");
			}
		}

	}

	public boolean isElementDisplayed(WebElement element) throws Throwable {
		boolean flag = false;
		for (int i = 0; i < 200; i++) {
			if (element.isDisplayed()) {
				flag = true;
				break;
			} else {
//				Thread.sleep(50);
			}
		}
		return flag;
	}

	public void executeJavaScriptOnElement(String script) {
		((JavascriptExecutor) driver).executeScript(script);
	}

	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

	public boolean hitKey(By locator, Keys keyStroke, String locatorName) throws Throwable {
		boolean flag = false;
		try {
//			Thread.sleep(1000);
			driver.findElement(locator).sendKeys(keyStroke);
//			Thread.sleep(1000);
			flag = true;
			return flag;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public Collection<WebElement> getWebElementsByTagInsideLocator(By locator, String tagName, String locatorName)
			throws Throwable {
		boolean flag = false;
		Collection<WebElement> elements;
		try {
			WebElement element = driver.findElement(locator);
			elements = element.findElements(By.tagName(tagName));
			flag = true;
		} catch (NoSuchElementException e) {
			throw e;
		} finally {
			if (!flag) {
				failureReport("Type ",
						"Data typing action is not perform on " + locatorName + " with data is " + tagName);
			}
		}
		return elements;
	}

	public void mouseOverElement(WebElement element, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				failureReport("MouseOver ", " MouseOver action is not perform on" + locatorName);

			} else {
				SuccessReport("MouseOver ", " MouserOver Action is Done on " + locatorName);
			}
		}
	}

	@Parameters({ "browser" })
	public void SuccessReport(String strStepName, String strStepDes) throws Throwable {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		String stepTime = sdf.format(date);
		int intReporterType = Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:

			break;
		case 2:

			test.log(LogStatus.PASS, strStepName + strStepDes);

			break;

		default:
			if (configProps.getProperty("OnSuccessScreenshot").equalsIgnoreCase("True")) {
				screenShot(TestEngine.filePath() + strStepDes.replace(" ", "_") + ".jpeg");
			}
			onSuccess(strStepName, strStepDes, stepTime);
			break;
		}
	}

	/**
	 * Used to take screenshot for verification purpose (On Demand)
	 * 
	 * @param strStepName
	 * @param strStepDes
	 * @throws Throwable
	 */
	public boolean SuccessReportWithScreenshot(String strStepName) throws Throwable {

		try {
			// Commented because results file size is more
			test.log(LogStatus.PASS,
					strStepName + test.addScreenCapture(GetScreenShot.captureScreenshot(driver, strStepName)));
			return true;
		} catch (Exception e) {
			failureReport("Screenshot on Demand ", "Failed to take screenshot on demand");
			e.printStackTrace();
			return false;
		}
	}

	public boolean FailureReportWithScreenshot(String strStepName) throws Throwable {

		try {
			// Commented because results file size is more
			test.log(LogStatus.FAIL, test.addScreenCapture(GetScreenShot.captureScreenshot(driver, strStepName)));
			FailNum = FailNum + 1;
			return true;
		} catch (Exception e) {
			failureReport("Screenshot on Demand ", "Failed to take screenshot on demand");
			e.printStackTrace();
			return false;
		}
	}

	public void failureReport(String strStepName, String strStepDes) throws Throwable {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		String stepTime = sdf.format(date);

		int intReporterType = Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag = true;
			break;
		case 2:
			test.log(LogStatus.FAIL, strStepName + strStepDes);
			FailNum = FailNum + 1;// added by me
			flag = true;
			break;

		default:
			flag = true;
			break;
		}

	}

	public void warningReport(String strStepName, String strStepDes) throws Throwable {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy hh mm ss SSS");
		String stepTime = sdf.format(date);
		int intReporterType = Integer.parseInt(configProps.getProperty("reportsType"));
		switch (intReporterType) {
		case 1:
			flag = true;
			break;
		case 2:
			screenShot(TestEngine.filePath() + "/" + "Screenshots" + "/" + strStepDes.replace(" ", "_") + ".jpeg");
			flag = true;
			onWarning(strStepName, strStepDes, stepTime);
			break;

		default:
			flag = true;
			screenShot(TestEngine.filePath() + "/" + "Screenshots" + "/" + strStepDes.replace(" ", "_") + ".jpeg");
			onWarning(strStepName, strStepDes, stepTime);
			break;
		}

	}

	public boolean isAlertPresent() {
		try {
			newAlert = driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}

	/**
	 * Used to Wait For Alert Present
	 * 
	 * @return boolean (True False)
	 */
	public boolean waitForAlertPresent() {
		boolean f = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			f = true;
		} catch (NoAlertPresentException Ex) {

		}
		return f;
	}

	/**
	 * Wait for an ElementPresent
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @return Whether or not the element is displayed
	 */
	public boolean waitForObject(By by, String locator, int time) throws Throwable {
		boolean flag = false;
		try {
			System.out.println("");
			for (int i = 0; i < time; i++) {
				if (driver.findElement(by).isDisplayed() == true) {
					flag = true;
					return flag;

				} else {
//					Thread.sleep(200);
					i = i + 200;
					if (i >= time) {
						flag = false;
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				failureReport("IsElementPresent", "Not Able to locate element " + locator);
				// + " Element is not present on the page");
			} else if (b && flag) {
				SuccessReport("IsElementPresent ", "Able to locate element " + locator);
			}
		}

		return flag;

	}

	public boolean runTimeDeleteCookies() throws AWTException {

		Set<Cookie> cookies = driver.manage().getCookies();

		System.out.println("Number of cookies in this site " + cookies.size());

		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " " + cookie.getValue());
			driver.manage().deleteCookieNamed(cookie.getName());
		}

		driver.navigate().refresh();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_DELETE);

		r.keyRelease(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_CONTROL);
		return b;

	}

	/**
	 * Get the value of a the given attribute of the element.
	 * 
	 * @param by
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param attribute
	 *            : Attribute name wish to assert the value.
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:label, SignIn Link etc..)
	 * 
	 * @return: String attribute value
	 * 
	 */

	public String getattributewait(By by, String attribute, String locatorName) throws Throwable {
		String value = "";
		if (waitUntilpresenceOfElementLocatedboolean(by, locatorName)) {
			value = driver.findElement(by).getAttribute(attribute);
		}
		return value;
	}

	/**
	 * Wait Until presence Of Element Located
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 */

	public boolean waitUntilpresenceOfElementLocatedboolean(By by, String locator) throws Throwable {
		wait = new WebDriverWait(driver, 10);
		boolean flag = false;

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));

			flag = true;
			return flag;

		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		} finally {
			if (!flag) {
				failureReport("waitUntilpresenceOfElementLocated ", " Failed to locate element " + locator);
			} else if (b && flag) {
				SuccessReport(" waitUntilpresenceOfElementLocated ", " Successfully located element " + locator);
			}

		}

	}

	/**
	 * ExplicitWaitOnTextToPresent :: It explicitly waits for mentioned
	 * stipulated time/text to be present on the given locator.
	 * 
	 * @param locator
	 * @param text
	 */
	//	@SuppressWarnings("deprecation")
	//	public void ExplicitWaitOnTextToPresent(By locator, String text) {
	//		try {
	//			WebDriverWait wait = new WebDriverWait(driver, 30);
	//			wait.until(ExpectedConditions.textToBePresentInElement(locator, text));
	//		} catch (Throwable e) {
	//		}
	//	}


	/**
	 * ExplicitWaitOnElementToBeClickable :: It explicitly waits for mentioned
	 * stipulated time/element to be clickable on the given locator.
	 * 
	 * @param WebElement
	 */

	public void ExplicitWaitOnElementToBeClickable(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Throwable e) {
		}
	}

	public String getDropdownSelectedValue(By locator) {
		String selected = "";
		try {
			ExplicitWaitOnElementToBeClickable(locator);
			Select selectOption = new Select(driver.findElement(locator));
			selected = selectOption.getFirstSelectedOption().getText();
		} catch (Exception e) {
		}
		return selected;
	}

	
	// Get the Text of a specific field using the xPath
	public String getXPathValue(By locator) {
		String selected = "";
		try {
			ExplicitWaitOnElementToBeClickable(locator);
//			Thread.sleep(7000);
			selected = driver.findElement(locator).getText();
		} catch (Exception e) {
		}
		return selected;
	}
	
	
	// Get the attribute value of a specific field using Xpath
	public String getXPathAttribute(By locator, String attribute) {
		String selected = "";
		try {
			ExplicitWaitOnElementToBeClickable(locator);
//			Thread.sleep(7000);
			selected = driver.findElement(locator).getAttribute(attribute);
			
		} catch (Exception e) {
		}
		return selected;
	}
	
	
	// Send the Key combination "Ctrl + C" from Keyboard
	public String sendKeys_CtrlC(By locator) {
		String selected = "";
		try {
			ExplicitWaitOnElementToBeClickable(locator);
//			Thread.sleep(7000);
			driver.findElement(locator).sendKeys(Keys.CONTROL + "c");
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

			Transferable contents = clipboard.getContents(null);
			boolean hasTransferableText = (contents != null)
					&& contents.isDataFlavorSupported(DataFlavor.stringFlavor);
			if (hasTransferableText) {
				try {
					selected = (String) contents.getTransferData(DataFlavor.stringFlavor);
				} catch (UnsupportedFlavorException | IOException ex) {
					System.out.println(ex);
					ex.printStackTrace();
				}
			}

		} catch (Exception e) {
		}
		return selected;
	}
		
	
	
	/**
	 * subtract days to date in java
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
				
		return cal.getTime();
	}
	
	

	public boolean deleteCookes() {
		boolean status = true;
		try {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();

		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public String getSelectdValue(By locator, String locatorName) throws Throwable {
		String selectedvalue = "";
		boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			selectedvalue = s.getFirstSelectedOption().getText();
			flag = true;
			return selectedvalue;
		} catch (Exception e) {

			return e.getStackTrace().toString();
		} finally {
			if (!flag) {
				failureReport("Get ", "Selected value is not getting from the DropDown" + locatorName);

			} else if (b && flag) {
				SuccessReport("Get ", "Successfully getting the selected value from the DropDown" + locatorName);
			}
		}
	}

	public String getAllSelectdValues(By locator, String locatorName) throws Throwable {
		StringBuilder selectedvalue = new StringBuilder();
		boolean flag = false;
		try {
			Select s = new Select(driver.findElement(locator));
			List<WebElement> allvalues = s.getAllSelectedOptions();
			for (WebElement each : allvalues) {
				selectedvalue.append(',').append(each).toString();

			}

		} catch (Exception e) {

		} finally {
			if (!flag) {
				failureReport("Get ", "Selected value is not getting from the DropDown" + locatorName);

			} else if (b && flag) {
				SuccessReport("Get ", "Successfully getting the selected value from the DropDown" + locatorName);
			}

		}

		return selectedvalue.toString();
	}

	/**
	 * Used to Scroll to the given locator
	 * 
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean JSScrollTo(By locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			// tableOfContentsDropDown("Set Default Path");

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void selectLinkText(String linkTextName) throws Throwable {
		boolean flag = false;
		try {
			driver.findElement(By.linkText(linkTextName)).click();
			;
			flag = true;
//			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		} finally {
			if (!flag)
				failureReport("Click", "Unable to clicked on " + linkTextName);
			else
				SuccessReport("Click", "Successfully clicked on " + linkTextName);

		}

	}

	/**
	 * Used to Write Execution Test Data into Log File
	 * 
	 * @param className
	 *            Name of the Class executing
	 * 
	 * @param str1
	 *            Parameter Description<Space>Parameter value
	 * @param str2
	 *            Parameter Description<Space>Parameter value
	 * @param str3
	 *            Parameter Description<Space>Parameter value
	 * @param str4
	 *            Parameter Description<Space>Parameter value
	 * @param str5
	 *            Parameter Description<Space>Parameter value
	 * @param str6
	 *            Parameter Description<Space>Parameter value
	 * @param str7
	 *            Parameter Description<Space>Parameter value
	 * @param str8
	 *            Parameter Description<Space>Parameter value
	 * @param str9
	 *            Parameter Description<Space>Parameter value
	 * @param str10
	 *            Parameter Description<Space>Parameter value
	 * @param str11
	 *            Parameter Description<Space>Parameter value
	 * @param str12
	 *            Parameter Description<Space>Parameter value
	 * @param str13
	 *            Parameter Description<Space>Parameter value
	 * @param str14
	 *            Parameter Description<Space>Parameter value
	 * @param str15
	 *            Parameter Description<Space>Parameter value
	 * @param str16
	 *            Parameter Description<Space>Parameter value
	 * @param str17
	 *            Parameter Description<Space>Parameter value
	 * @param str18
	 *            Parameter Description<Space>Parameter value
	 * @param str19
	 *            Parameter Description<Space>Parameter value
	 * @param str20
	 *            Parameter Description<Space>Parameter value
	 * @throws Exception
	 */
	public void writeExecutionDataIntoMap(String str1, String str2, String str3, String str4, String str5, String str6,
			String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14,
			String str15, String str16, String str17, String str18, String str19, String str20) throws Exception {
		try {

			executionData = new HashMap<String, String>();
			if (!str1.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str1.split("=")[0], str1.split("=")[1]);
			if (!str2.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str2.split("=")[0], str2.split("=")[1]);
			if (!str3.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str3.split("=")[0], str3.split("=")[1]);
			if (!str4.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str4.split("=")[0], str4.split("=")[1]);
			if (!str5.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str5.split("=")[0], str5.split("=")[1]);
			if (!str6.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str6.split("=")[0], str6.split("=")[1]);
			if (!str7.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str7.split("=")[0], str7.split("=")[1]);
			if (!str8.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str8.split("=")[0], str8.split("=")[1]);
			if (!str9.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str9.split("=")[0], str9.split("=")[1]);
			if (!str10.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str10.split("=")[0], str10.split("=")[1]);
			if (!str11.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str11.split("=")[0], str11.split("=")[1]);
			if (!str12.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str12.split("=")[0], str12.split("=")[1]);
			if (!str13.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str13.split("=")[0], str13.split("=")[1]);
			if (!str14.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str14.split("=")[0], str14.split("=")[1]);
			if (!str15.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str15.split("=")[0], str15.split("=")[1]);
			if (!str16.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str16.split("=")[0], str16.split("=")[1]);
			if (!str17.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str17.split("=")[0], str17.split("=")[1]);
			if (!str18.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str18.split("=")[0], str18.split("=")[1]);
			if (!str19.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str19.split("=")[0], str19.split("=")[1]);
			if (!str20.replace(" ", "").equalsIgnoreCase(""))
				executionData.put(str20.split("=")[0], str20.split("=")[1]);

		} catch (Exception e) {
			System.out.println(e);
		}

	}



	public void TAB(By locator) {
		try {
			driver.findElement(locator).sendKeys(Keys.TAB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Enter(By locator) {
		try {
			driver.findElement(locator).sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	// method to refresh page
	public void pageRefresh() {
		try {
//			Thread.sleep(3000);
			driver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public boolean Doubleclick(By locator, String locatorName) throws Throwable {

		ExplicitWaitOnElementToBeClickable(locator);
		boolean flag = false;
		try {

			Actions actions = new Actions(driver);
			WebElement elementLocator = driver.findElement(locator);
			actions.doubleClick(elementLocator).perform();
			flag = true;
//			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to Double-click on " + locatorName);
				FailNum = FailNum + 1;
				return true;
			} else if (b && flag) {
				test.log(LogStatus.PASS, " Successfully Double-click on " + locatorName);
			}
		}
		return flag;
	}



	public String getTheCurrentURL() throws Throwable {

		String getCurrentUrl = null;
		boolean flag = false;
		try {
			getCurrentUrl = driver.getCurrentUrl();		
			flag = true;
//			Thread.sleep(2000);


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (!flag) {
				test.log(LogStatus.FAIL, "Unable to getURL " + getCurrentUrl);
				FailNum = FailNum + 1;
			} else if (b && flag) {
				test.log(LogStatus.PASS, "Successfully got the URL " + getCurrentUrl);
			}
		}

		return getCurrentUrl;
	}


}
