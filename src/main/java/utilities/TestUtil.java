package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.page.Page;


public class TestUtil extends Page{

	public static String screenShotPath;
	public static String screenShotName;
	
	public static void captureScreenShot() throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName+""));
	}
	
	public static boolean isTestRunnable(String testName) throws IOException {
		String sheetName="testCasesMode";
		int rows = excel.getRowCount(sheetName);
		int columns = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows][columns];
		data = excel.getExcelData(sheetName);
		
		
		for(int i=0;i<rows-1;i++) {
			for(int j=0;j<columns;j++) {
				//System.out.print(data[i][j]);
				if(data[i][j].equals(testName)) {
					if(data[i][j+1].equals("Y")) {
						return true;
					}else {
						return false;
					}
					
				}
			}
}
		return false;
	}
	

}

