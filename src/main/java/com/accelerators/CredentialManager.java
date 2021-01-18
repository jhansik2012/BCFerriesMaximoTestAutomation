/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

package com.accelerators;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Sheet;
import jxl.Workbook;

public class CredentialManager {

	public static HashMap<String,String> getProperty(String environmentName) throws Exception{
		HashMap<String,String> data=new HashMap<String,String>();
		try{
			
//			System.out.println(environmentName);
			
			
			String filePath=System.getProperty("user.dir")+File.separator+"CredentialManager.xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook(filePath);			
			XSSFSheet sheet = workbook.getSheet(environmentName);
			
			int rows = sheet.getPhysicalNumberOfRows();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells(); 
			
			if(cols>2)
				System.out.println("Number of Columns are more than 2");
			
			for(int i=1;i<rows;i++){
				
				try {
					
					String propertyName= sheet.getRow(i).getCell(0).getStringCellValue();
					String propertyValue= sheet.getRow(i).getCell(1).getStringCellValue();
					
					
					
					if(!propertyName.isEmpty() || !propertyValue.isEmpty())
						data.put(propertyName,propertyValue);
					
					
//					System.out.println(data);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			workbook.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Environment Name not Matched");
			return null;
		}
		return data;		
	}	
	
}
