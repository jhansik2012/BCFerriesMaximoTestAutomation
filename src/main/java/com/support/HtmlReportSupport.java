/**
 * @Author Venkata Vijay Raju P
 * @Date Dec 13, 2019
 */

package com.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.accelerators.TestEngine;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class HtmlReportSupport {

	public long iStartTime = 0;
	public long iEndTime = 0;
	public static long iTestStartTime = 0;
	public static long iTestEndTime = 0;
	public static double iTestExecutionTime = 0;
	public long iExecutionTime = 0;
	public static long iSuiteStartTime = 0;
	public static long iSuiteEndTime = 0;
	public static double iSuiteExecutionTime = 0;
	public ArrayList<Double> list = new ArrayList<Double>();
	public long startStepTime = 0;
	public long endStepTime = 0;
	public double stepExecutionTime = 0;
	public static String strTestName = "";
	static String startedAt = "";
	public static String tc_name = "";
	public static String packageName = "";
	public static Map<String, String> map = new LinkedHashMap<String, String>();
	public static Map<String, String> testdescrption = new LinkedHashMap<String, String>();
	public static Map<String, String> executionTime = new LinkedHashMap<String, String>();
	public String currentSuit = "";
	public int pCount = 0;
	public int fCount = 0;
	public static String key;
	public String value[];
	public static String rpTime;
	public static String browser;
	static String workingDir = System.getProperty("user.dir").replace(File.separator,"/");;
	public static int BFunctionNo = 0;
	public static int serialNo;
	public static Writer writer = null;
	public static String testCaseDescription;
	public static ConfiguratorSupport configProps = new ConfiguratorSupport("config.properties");
	public static File file;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String File_Html_RelativePath;
	public static String File_Html_RelativePath1;
	public static String absoultePath;
	public void createDetailedReport() throws Exception {

	}





	// Create a report file
	public void htmlCreateReport() throws Exception {

		// map.clear();
		File file = new File(TestEngine.filePath() + "/"+strTestName.split("-")[0]+"_"
				+rpTime+ ".html");// "Results.html"
		if (file.exists()) {
			file.delete();
		}

	}

	public void testHeader(String testName) {

		Writer writer = null;
		try {
			SimpleDateFormat rpDt = new SimpleDateFormat("hhmmss");
			rpTime = rpDt.format(new Date());
			strTestName = testName;

			File_Html_RelativePath=(TestEngine.filePath() + "/"+strTestName.split("-")[0]+"_"+rpTime+ ".html");

			extent = new ExtentReports(File_Html_RelativePath);

		} catch (Exception e) {

		} finally {
			try {

			} catch (Exception e) {

			}
		}
	}




	public static void copyLogos()
	{

//		File srcFolder = new File("logos");
		File srcFolder = new File(System.getProperty("user.dir") + File.separator + "src" 
				+ File.separator + "test" + File.separator + "resources" + File.separator +"logos");
		
		File destFolder = new File(TestEngine.filePath()+"/Screenshots");


		//make sure source exists
		if(!srcFolder.exists()){
			System.out.println("Directory does not exist.");
		}else{

			try{
				copyFolder(srcFolder,destFolder);
			}catch(IOException e){

			}
		}
	}

	public static void copyFolder(File src, File dest) throws IOException {

		if(src.isDirectory()){

			//if directory not exists, create it
			if(!dest.exists()){
				dest.mkdir();
//				System.out.println("Directory copied from " + src + "  to " + dest);
			}

			//list all the directory contents
			String files[] = src.list();

			for (String file : files) {
				//construct the src and dest file structure
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				//recursive copy
				if(srcFile.getAbsolutePath().contains("TestChart")){
					destFile=new File(destFile.getAbsolutePath().replace(File.separator+"Screenshots", ""));
					copyFolder(srcFile,destFile);
				}else{
					copyFolder(srcFile,destFile);
				}
			}

		}else{
			//if file, then copy it
			//Use bytes stream to support all file types
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest); 

			byte[] buffer = new byte[1024];

			int length;
			//copy the file content in bytes 
			while ((length = in.read(buffer)) > 0){
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
//			System.out.println("File copied from " + src + " to " + dest);
		}
	}

	//@Parameters({ "browser" })
	//@SuppressWarnings({ "rawtypes", "resource" })
	public static void createHtmlSummaryReport(String browser) throws Exception {

		System.out.println();
		System.out.println("createHtmlSummaryReport " + browser);
		if(TestEngine.buildNumer_Jenkins !=null  ){
			file = new File(TestEngine.filePath() + "/" + "Summary_Results_"
					+TestEngine.buildNumer_Jenkins+ ".html");// "SummaryReport.html"
		}
		else{
			file = new File(TestEngine.filePath() + "/" + "Summary_Results_"
					+TestEngine.rpSumDt+ ".html");// "SummaryReport.html"                
		}
		System.out.println("------------ "+file);
		try {
			if (!file.exists()) {
				writer = new FileWriter(file, true);
				//file.delete();

				writer.write("<!DOCTYPE html>");
				writer.write("<html> ");
				writer.write("<head> ");
				writer.write("<meta charset='UTF-8'> ");
				writer.write("<title>Automation Execution Results Summary</title>");


				writer.write("<script type='text/javascript'>");
				writer.write("window.onload = function () {");
				writer.write("var chart = new CanvasJS.Chart('chartContainer', {");

				writer.write("data: [");              
				writer.write("{");
				writer.write("type: 'column',");
				writer.write("dataPoints: [");
				writer.write("{ label: 'Total',  y: 200  },");         
				writer.write("{ label: 'Fail',  y: 100  },");
				writer.write("{ label: 'Skip',  y: 90  },");
				writer.write("{ label: 'Pass',  y: 50  }");
				writer.write("]");
				writer.write("}");
				writer.write("]");
				writer.write("});");
				writer.write("chart.render();");
				writer.write("}");
				writer.write("</script>");
				//String src1=TestEngine.filePath().replace("HTML", "")+"TestChart.js";
				//System.out.println(src+"/html/TestChart.js");
				writer.write("<script type='text/javascript' src='TestChart.js'>");
				writer.write("</script>");


				writer.write("<style type='text/css'>");
				writer.write("body {");
				writer.write("background-color: #FFFFFF; ");
				writer.write("font-family: Verdana, Geneva, sans-serif; ");
				writer.write("text-align: center; ");
				writer.write("} ");

				writer.write("small { ");
				writer.write("font-size: 0.7em; ");
				writer.write("} ");

				writer.write("table { ");
				writer.write("box-shadow: 9px 9px 10px 4px #BDBDBD;");
				writer.write("border: 0px solid #4D7C7B;");
				writer.write("border-collapse: collapse; ");
				writer.write("border-spacing: 0px; ");
				writer.write("width: 1000px; ");
				writer.write("margin-left: auto; ");
				writer.write("margin-right: auto; ");
				writer.write("} ");

				writer.write("tr.heading { ");
				writer.write("background-color: #041944;");
				writer.write("color: #FFFFFF; ");
				writer.write("font-size: 0.7em; ");
				writer.write("font-weight: bold; ");
				writer.write("background:-o-linear-gradient(bottom, #999999 5%, #000000 100%);                background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #999999), color-stop(1, #000000) );");
				writer.write("background:-moz-linear-gradient( center top, #999999 5%, #000000 100% );");
				writer.write("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#999999, endColorstr=#000000);  background: -o-linear-gradient(top,#999999,000000);");
				writer.write("} ");

				writer.write("tr.subheading { ");
				writer.write("background-color: #ffffff;");
				writer.write("color: #000000; ");
				writer.write("font-weight: bold; ");
				writer.write("font-size: 0.7em; ");
				writer.write("text-align: justify; ");
				writer.write("} ");

				writer.write("tr.section { ");
				writer.write("background-color: #A4A4A4; ");
				writer.write("color: #333300; ");
				writer.write("cursor: pointer; ");
				writer.write("font-weight: bold;");
				writer.write("font-size: 0.8em; ");
				writer.write("text-align: justify;");
				writer.write("background:-o-linear-gradient(bottom, #56aaff 5%, #e5e5e5 100%);                background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #56aaff), color-stop(1, #e5e5e5) );");
				writer.write("background:-moz-linear-gradient( center top, #56aaff 5%, #e5e5e5 100% );");
				writer.write("filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#56aaff, endColorstr=#e5e5e5); background: -o-linear-gradient(top,#56aaff,e5e5e5);");

				writer.write("} ");

				writer.write("tr.subsection { ");
				writer.write("cursor: pointer; ");
				writer.write("} ");

				writer.write("tr.content { ");
				writer.write("background-color: #FFFFFF; ");
				writer.write("color: #000000; ");
				writer.write("font-size: 0.7em; ");
				writer.write("display: table-row; ");
				writer.write("} ");

				writer.write("tr.content2 { ");
				writer.write("background-color:#;E1E1E1");
				writer.write("border: 1px solid #4D7C7B;");
				writer.write("color: #000000; ");
				writer.write("font-size: 0.7em; ");
				writer.write("display: table-row; ");
				writer.write("} ");

				writer.write("td, th { ");
				writer.write("padding: 5px; ");
				writer.write("border: 1px solid #4D7C7B; ");
				writer.write("text-align: inherit\0/; ");
				writer.write("} ");

				writer.write("th.Logos { ");
				writer.write("padding: 5px; ");
				writer.write("border: 0px solid #4D7C7B; ");
				writer.write("text-align: inherit /;");
				writer.write("} ");

				writer.write("td.justified { ");
				writer.write("text-align: justify; ");
				writer.write("} ");

				writer.write("td.pass {");
				writer.write("font-weight: bold; ");
				writer.write("color: green; ");
				writer.write("} ");

				writer.write("td.fail { ");
				writer.write("font-weight: bold; ");
				writer.write("color: red; ");
				writer.write("} ");

				writer.write("td.skip { ");
				writer.write("font-weight: bold; ");
				writer.write("color: orange; ");
				writer.write("} ");

				writer.write("td.done, td.screenshot { ");
				writer.write("font-weight: bold; ");
				writer.write("color: black; ");
				writer.write("} ");

				writer.write("td.debug { ");
				writer.write("font-weight: bold; ");
				writer.write("color: blue; ");
				writer.write("} ");

				writer.write("td.warning { ");
				writer.write("font-weight: bold; ");
				writer.write("color: orange; ");
				writer.write("} ");

				writer.write(".column:nth-child(1) .fill{");
				writer.write("background: green;");
				writer.write("height: 10%;");
				writer.write("}.column:nth-child(2) .fill{");
				writer.write("background: red;");
				writer.write("height: 10%;");
				writer.write("}.column:nth-child(3) .fill{");
				writer.write("background: orange;");
				writer.write("height: 10%;");



				writer.write("</style> ");

				writer.write("<script> ");
				writer.write("function toggleMenu(objID) { ");
				writer.write(" if (!document.getElementById) return;");
				writer.write(" var ob = document.getElementById(objID).style; ");
				writer.write("if(ob.display === 'none') { ");
				writer.write(" try { ");
				writer.write(" ob.display='table-row-group';");
				writer.write("} catch(ex) { ");
				writer.write("    ob.display='block'; ");
				writer.write("} ");
				writer.write("} ");
				writer.write("else { ");
				writer.write(" ob.display='none'; ");
				writer.write("} ");
				writer.write("} ");
				writer.write("function toggleSubMenu(objId) { ");
				writer.write("for(i=1; i<10000; i++) { ");
				writer.write("var ob = document.getElementById(objId.concat(i)); ");
				writer.write("if(ob === null) { ");
				writer.write("break; ");
				writer.write("} ");
				writer.write("if(ob.style.display === 'none') { ");
				writer.write("try { ");
				writer.write(" ob.style.display='table-row'; ");
				writer.write("} catch(ex) { ");
				writer.write("ob.style.display='block'; ");
				writer.write("} ");
				writer.write(" } ");
				writer.write("else { ");
				writer.write("ob.style.display='none'; ");
				writer.write("} ");
				writer.write(" } ");
				writer.write("} ");
				writer.write("</script> ");
				writer.write("</head> ");

				writer.write("<body> ");
				writer.write("</br>");


				writer.write("<table id='Logos'>");
				writer.write("<colgroup>");
				writer.write("<col style='width: 25%' />");
				writer.write("<col style='width: 25%' />");
				writer.write("<col style='width: 25%' />");
				writer.write("<col style='width: 25%' />");
				writer.write("</colgroup> ");
				writer.write("<thead> ");
				writer.write("<div id="+"chartContainer"+" style="+"height: 20px; width: 30%;"+"></div> ");

				writer.write("<tr class='content'>");
				writer.write("<th class ='Logos' colspan='2' >");
				writer.write("<img align ='left' src= ./Screenshots/bcferries.png></img>");
				writer.write("</th>");
				writer.write("<th class = 'Logos' colspan='2' > ");
				writer.write("<img align ='right' src= ./Screenshots/cigniti.png></img>");
				writer.write("</th> ");
				writer.write("</tr> ");

				writer.write("</thead> ");
				writer.write("</table> ");

				writer.write("<table id='header'> ");
				writer.write("<colgroup> ");
				writer.write("<col style='width: 25%' /> ");
				writer.write("<col style='width: 25%' /> ");
				writer.write("<col style='width: 25%' /> ");
				writer.write(" <col style='width: 25%' /> ");
				writer.write("</colgroup> ");
				writer.write("<thead> ");
				writer.write("<tr class='heading'> ");
				writer.write("<th colspan='5' style='font-family:Verdana; font-size:1.3em;'> ");
				if(TestEngine.buildNumer_Jenkins !=null  ){
					writer.write("Automation Execution Result Summary -BuildNumber : "+TestEngine.buildNumer_Jenkins);
				}
				else{
					writer.write("Execution Result Summary");
				}

				writer.write("</th> ");
				writer.write("</tr> ");
				writer.write("<tr class='subheading'> ");
				writer.write("<th>&nbsp;Date&nbsp;&&nbsp;Time&nbsp;:&nbsp;" + ""
						+ "</th> ");
				writer.write("<th> &nbsp;"+ReportStampSupport.dateTime()+"&nbsp;</th> ");
				writer.write("<th>&nbsp;OnError&nbsp;:&nbsp;</th> ");
				writer.write("<th>NextTestCase</th> ");



				//String ReportChartName=TestEngine.chartName;
				//            writer.write("<th rowspan='5'><div id='chartContainer' style='height: 200px; width: 200px'><img align ='left' style='height: 180px; width: 200px' src= ./Screenshots/"+ReportChartName+".jpg></div></th>");
				//writer.write("$('#barChart').click(function(){");
				//writer.write("$('#testSummaryTable').hide();");
				//writer.write("$('#moduleSummaryTable').show();");
				//writer.write("});");
				//writer.write("});");


				//writer.write("<th rowspan='5'><div id='chartContainer' style='height: 170px; width: 220px'></div></th>");
				writer.write("</tr> ");


				writer.write("<tr class='subheading'> ");
				writer.write("<th>&nbsp;Suite Executed&nbsp;:&nbsp;</th> ");

				writer.write("<th>"+TestEngine.suiteName+"</th> ");
				writer.write("<th>&nbsp;Browser&nbsp;:</th> ");
				writer.write("<th>"
						+ browser + "</th> ");
				writer.write("</tr> ");


				writer.write("<tr class='subheading'> ");
				writer.write("<th>&nbsp;Host Name&nbsp;:</th> ");
				writer.write("<th>" + 
						InetAddress.getLocalHost().getHostName()+ "</th> ");
				writer.write("<th>&nbsp;No.&nbsp;Of&nbsp;Threads&nbsp;:&nbsp;</th> ");
				writer.write("<th>"
						+ "1" + "</th> ");
				writer.write("</tr> ");

				writer.write("<tr class='subheading'> ");
				writer.write("<th colspan='4'> ");
				writer.write("&nbsp;Environment -  " + TestEngine.propertyManager.get("Environment") + "");
				writer.write("</th> ");
				writer.write("</tr> ");
				writer.write("</thead> ");
				writer.write("</table> ");
				writer.write("<table id='main'> ");
				writer.write("<colgroup> ");
				writer.write("<col style='width: 5%' /> ");
				writer.write("<col style='width: 30%' /> ");
				writer.write("<col style='width: 15%' /> ");
				writer.write("<col style='width: 30%' /> ");
				writer.write("<col style='width: 10%' /> ");
				writer.write("<col style='width: 10%' /> ");
				writer.write("</colgroup> ");
				writer.write("<thead> ");
				writer.write("<tr class='heading'> ");
				writer.write("<th>S.NO</th> ");
				writer.write("<th>Test Case Name</th> ");
				writer.write("<th>Module</th> ");
				writer.write("<th>Test Case ID</th> ");
				writer.write("<th>Time</th> ");
				writer.write("<th>Result</th> ");
				writer.write("</tr> ");
				writer.write("</thead> ");
				writer.write("<tbody> ");
			}

			Iterator<Entry<String, String>> iterator1 = map.entrySet().iterator();
			serialNo = serialNo+1;

			while (iterator1.hasNext()) {
				//writer = new FileWriter(file, true);
				if(writer.equals(null)){
					writer = new FileWriter(file, true);

				}




				@SuppressWarnings("rawtypes")
				Map.Entry mapEntry1 = (Map.Entry) iterator1.next();
				key = mapEntry1.getKey().toString();
				String value = (String) mapEntry1.getValue();
				//                                                if(key.contains(tc_name.replace("-" + browser, ""))){
				//serialNo = serialNo+1;
				writer.write("<tr class='content2' >  ");
				writer.write("<td class='justified'>" + serialNo + "</td>");

				String testCaseLink=key.replace("-"+browser, "")+"_"+rpTime;
				if(testCaseLink.trim().length()>60)
					testCaseLink=testCaseLink.substring(0, 51)+rpTime+"...";
				
				
				if (TestEngine.testResults.get(key).equals("PASS")) {
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[0] +"</td>");
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[1] +"</td>");
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[2] +"</td>");
					//                                                                                writer.write("<td class='justified'><a href='"+key.replace("-"+browser, "")+"_"+rpTime+ ".html#'"+ "' target='_blank'>" +testCaseLink+ "</a></td>");
					//.substring(0,key[1].indexOf("-"))
				} else if(TestEngine.testResults.get(key).equals("FAIL")){
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[0] +"</td>");
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[1] +"</td>");
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[2] +"</td>");
					//                                                                                writer.write("<td class='justified'><a href='"+key.replace("-"+browser, "")+"_"+rpTime+ ".html#'"+ "' target='_blank'>" +testCaseLink+ "</a></td>");
					// .substring(0,key[1].indexOf("-"))
				}else if(TestEngine.testResults.get(key).equals("SKIP")){
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[0] +"</td>");
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[1] +"</td>");
					writer.write("<td class='justified' style='text-align:center'>" + TestEngine.testResultsData.get(key)[2] +"</td>");
				}


//				System.out.println(TestEngine.tstData.get("TestCaseDescription"));

				//writer.write("<td class='justified'>"+ TestEngine.testDescription.get(key[1])+ "</td>");
				//                                                                writer.write("<td class='justified'>"+ testCaseLink+ "</td>");

				if(TestEngine.testResults.get(key).equals("PASS")) {
					writer.write("<td>" + executionTime.get(key)+ " Seconds</td>");
					writer.write("<td class='pass'><a href="+"./"+TestEngine.testResultsData.get(key)[3]+".html#"+"' target='_blank'>"+ 
							"<img src="+"./Screenshots/passed.ico width='18' height='18'>" + "</a></td>");
					//            File_Html_RelativePath
				}else if(TestEngine.testResults.get(key).equals("FAIL")) {
					writer.write("<td>" + executionTime.get(key)+ " Seconds</td>");
					writer.write("<td class='fail'><a href="+"./"+TestEngine.testResultsData.get(key)[3]+".html#"+"' target='_blank'>"+ 
							"<img src="+"./Screenshots/failed.ico width='18' height='18'>" + "</a></td>");
				}else {
					writer.write("<td>" + executionTime.get(key)+"</td>");
					writer.write("<td class='skip'><img src="+"./Screenshots/warning.ico width='15' height='15'></td>");
				}
				writer.write("</tr>");
				writer.write("</tbody> ");
				serialNo = serialNo + 1;
			}
			writer.flush();
			//writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			writer.flush();
			//writer.close();
		}finally{
			System.out.println();
		}

	}
	
}
