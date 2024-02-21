package rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int row = 0;
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\excel\\testdatasheet.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("SignInData");
		Iterator<Row> itr = sheet.rowIterator();
		while(itr.hasNext()) {
			itr.next();
			row++;
			System.out.println(row);
		}
		
		System.out.println("Total row " + row);
	}

}
