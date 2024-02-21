package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.page.Page;
import com.pages.HomePage;
import com.pages.LandingPage;
import com.pages.SignInPage;
import com.pages.myaccount.ChangePasswordPage;
import com.pages.myaccount.CreateNewAccountPage;
import com.pages.myaccount.EditAccountPage;
import com.pages.myaccount.MyAccountPage;

import utilities.ExcelReader;

public class LoginTest extends Page{

	SignInPage signin;
	LandingPage lp;
	
	//@Test
	@Test(priority = 1,dataProvider ="dp")
	public void loginTest(String email,String password,String verifytext,String firstname, String lastname,String newpassword) throws InterruptedException {
	//public void loginTest() throws InterruptedException {
		HomePage homepage = new HomePage();
		signin = homepage.goToSignInPage();
		lp = signin.performSignIn("nayangogoi744@gmail.com","SAG*@dem01234");
		lp.verifyWelcomeTxtPresent("Welcome");
		Assert.assertTrue(false);
		MyAccountPage mp = lp.goToMyAccount();
		EditAccountPage ep = mp.editContactInfo();
		mp = ep.changeAccInfo("Nayan Jyoti");
		ChangePasswordPage cp = mp.clickchangePassword();
		signin = cp.changePassword("SAG*@dem01234", "SAG*@dem01234");
		signin.createAnAccount();
		
	}
//	
//	@Test(priority = 1,dataProvider ="dp")
//	public void test(String email,String password,String verifytext,String firstname, String lastname,String newpassword) {
//		System.out.println(email);
//	}
	@DataProvider(name="dp") 
	  public Object[][] userData() throws IOException{ 
		  Object[][] arrayObject = ExcelReader.getExcelData("SignInData"); 
		  return arrayObject; 
	 }
	


}
