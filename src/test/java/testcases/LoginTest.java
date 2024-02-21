package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.page.Page;
import com.pages.HomePage;
import com.pages.LandingPage;
import com.pages.SignInPage;
import com.pages.myaccount.ChangePasswordPage;
import com.pages.myaccount.CreateNewAccountPage;
import com.pages.myaccount.EditAccountPage;
import com.pages.myaccount.MyAccountPage;

public class LoginTest extends Page{
	SignInPage signin;
	LandingPage lp;
	@Test(priority = 1)
	public void loginTest() throws InterruptedException {
		HomePage homepage = new HomePage();
		signin = homepage.goToSignInPage();
		lp = signin.performSignIn("nayangogoi744@gmail.com","SAG*@dem01234");
		lp.verifyWelcomeTxtPresent("Welcome");
		Assert.assertTrue(false);
		//.info("Test executed");
		//TopMenu.topmenu.goToMenSection();
		
	}
	@Test(priority = 2)
	public void changeAccInformation() {
		MyAccountPage mp = lp.goToMyAccount();
		EditAccountPage ep = mp.editContactInfo();
		mp = ep.changeAccInfo("Nayan Jyoti");
		ChangePasswordPage cp = mp.clickchangePassword();
		signin = cp.changePassword("SAG*@dem01234", "SAG*@dem01234");
		CreateNewAccountPage cacc = signin.createAnAccount();
	}

}
