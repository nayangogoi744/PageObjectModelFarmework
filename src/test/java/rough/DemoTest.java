package rough;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.Page;

import utilities.ExcelReader;

public class DemoTest extends Page{

	@Test(priority = 1,dataProvider ="dp")
	public void test(String email,String password,String verifytext,String firstname, String lastname,String newpassword) {
		System.out.println(email);
	}
	@DataProvider(name="dp") 
	  public Object[][] userData() throws IOException{ 
		  Object[][] arrayObject = ExcelReader.getExcelData("SignInData"); 
		  return arrayObject; 
	 }
}
