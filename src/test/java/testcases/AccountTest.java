package testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.Page;
import com.pages.myaccount.ChangePasswordPage;
import com.pages.myaccount.EditAccountPage;
import com.pages.myaccount.MyAccountPage;

import utilities.ExcelReader;

public class AccountTest extends Page{

	@Test(priority = 2,dataProvider ="dp")
	public void accountTest(String email,String password,String verifytext,String firstname, String lastname,String newpassword) {
		MyAccountPage mp = lp.goToMyAccount();
		EditAccountPage ep = mp.editContactInfo();
		mp = ep.changeAccInfo(firstname);
		ChangePasswordPage cp = mp.clickchangePassword();
		signin = cp.changePassword(password, newpassword);
		signin.createAnAccount();
	}
	
	@DataProvider(name="dp") 
	  public Object[][] userData() throws IOException{ 
		  Object[][] arrayObject = ExcelReader.getExcelData("SignInData"); 
		  return arrayObject; 
	 }
}
