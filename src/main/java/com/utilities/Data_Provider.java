/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

package com.utilities;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accelerators.Configuration;
import com.accelerators.TestEngine;

import jxl.Sheet;
import jxl.Workbook;

public class Data_Provider {

	public static String[][] getTableArray(String sheetName) throws Exception{
			
		
//		System.out.println("Data_Provider || getTableArray");
		
		
		try{

			//			Workbook workbook = Workbook.getWorkbook(new File("Data"+File.separator+Configuration.GetProperty("CurrentApplication")+File.separator+"TestData.xlsx"));
			String filePath = System.getProperty("user.dir") + File.separator + "src" + 
					File.separator + "test" + File.separator + "resources" + File.separator + 
					"data" + File.separator + Configuration.GetProperty("CurrentApplication") + 
					File.separator + "TestData.xlsx";
			//			String filePath= "C:\\Users\\e001236\\eclipse-workspace\\FrameWork_POC\\CredentialManager.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(filePath);	

			
//			System.out.println("filePath == " + filePath);
//			System.out.println("sheetName == " + sheetName);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells();

			String[][] tabArray=new String[rows-1][cols];
			for (int i=1;i<rows;i++){
				for (int j=0;j<cols;j++){
					//					tabArray[i-1][j]=sheet.getCell(j,i).getContents();
					tabArray[i-1][j]=sheet.getRow(0).getCell(i).getStringCellValue();
				}
			}

			workbook.close();
			return(tabArray);
		}
		catch (Exception e) {
			System.out.println(e+Thread.currentThread().getStackTrace()[1].getClassName()+" dataprovider");
			return null;
		}

	}
	public static HashMap<String,String> getTestData(String sheetName, String executeTCName) throws Exception{//, String executeTCName, String executeStatus

//		System.out.println("Data_Provider || getTestData");
		
		
		try{
//			System.out.println(TestEngine.application);
			HashMap<String,String> data=new HashMap<String,String>();

			String filePath = System.getProperty("user.dir") + File.separator + "src" + 
					File.separator + "test" + File.separator + "resources" + File.separator + 
					"data" + File.separator + TestEngine.application + File.separator + "TestData.xlsx";
			
			
			
//			System.out.println("filePath == " + filePath);
//			System.out.println("sheetName == " + sheetName);

			//			Workbook workbook = Workbook.getWorkbook(new File(filePath));

			XSSFWorkbook workbook = new XSSFWorkbook(filePath);	
			String[]  tdata=null;
			//			Sheet sheet = workbook.getSheet(sheetName);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells(); 
			
//			
//			System.out.println("rows == " + rows);
//			System.out.println("cols == " + cols);
			

			String[]  tabHeader=new String[cols];
			for (int i=0;i<cols;i++){
				//				tabHeader[i]=sheet.getCell(i,0).getContents();
				tabHeader[i] = sheet.getRow(0).getCell(i).getStringCellValue();
//				System.out.println("tabHeader[i] == " + tabHeader[i]);
			}


			for (int i=1;i<rows;i++){ 
				//				if(sheet.getCell(0,i).getContents().equalsIgnoreCase("Yes") && sheet.getCell(1,i).getContents().equalsIgnoreCase(executeTCName)){ //matching key;
				//				if(sheet.getCell(1,i).getContents().equalsIgnoreCase(executeTCName)){ //matching key;

				
//				System.out.println("sheet.getRow(i).getCell(1).getStringCellValue() == " + sheet.getRow(i).getCell(1).getStringCellValue());
				
				
				if(sheet.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(executeTCName)){
					tdata=new String[cols];

					for (int j=0;j<cols;j++){

						//				    	 	if(sheet.getCell(j,i).getContents().equalsIgnoreCase("n/a")){

						if(sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase("n/a")){
							tdata[j]="";
						}else{
							//				    	 		tdata[j]=sheet.getCell(j,i).getContents();
							tdata[j]=sheet.getRow(i).getCell(j).getStringCellValue();
//							System.out.println("tdata[j] == " + tdata[j]);
						}

					}				     

					break; 
				}
			}
			for(int i=0;i<tabHeader.length;i++){
				data.put(tabHeader[i], tdata[i]);
			}	     	 
			
			
//			System.out.println("data == " + data);
			
			
			workbook.close();
			return data;

		}
		catch (Exception e) {
			System.out.println(e+Thread.currentThread().getStackTrace()[1].getClassName()+" dataprovider");
			return null;
		}

	}
	
}
