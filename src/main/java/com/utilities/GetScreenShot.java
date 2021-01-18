/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

package com.utilities;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.accelerators.TestEngine;
import com.support.HtmlReportSupport;

public class GetScreenShot {

	public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException{

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		//		String destination = System.getProperty("user.dir")+ "/" + TestEngine.filePath() + "/Screenshots/" + screenshotName + dateName
		//				+ ".png";

		String destination = "./Screenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(System.getProperty("user.dir")+ "/" + TestEngine.filePath() + "/Screenshots/" + screenshotName + dateName
				+ ".png");
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	public static String captureScreenshotAlert(WebDriver driver, String screenshotName) throws 
	IOException, AWTException, InterruptedException{

		try {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			Robot robot = new Robot();
			// create rectangle for full screenshot
			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			// capture screen of the desktop
			BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

			String destination1 = System.getProperty("user.dir")+ "/" + TestEngine.filePath() +"./Screenshots/" 
					+ screenshotName + dateName;


			ImageIO.write(screenFullImage, "png", new File(destination1));

			//FileUtils.copyFile(screenFullImage, new File(screenPath));
			File file = new File(destination1);
			String absoultePath = file.getCanonicalPath();
			Thread.sleep(2000);
			return destination1;			
		}


		catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotName; 
	} 
	
}
