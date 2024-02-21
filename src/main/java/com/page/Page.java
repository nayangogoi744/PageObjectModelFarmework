package com.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.base.TopMenu;
import com.pages.LandingPage;
import com.pages.SignInPage;

import listeners.CustomListeners;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.MonitoringMail;


public class Page {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static TopMenu topmenu;
	public static Properties prop = new Properties();
	public static Properties element = new Properties();
	public static FileInputStream fis;
	public static FileInputStream ele;
	public static Logger log = LogManager.getLogger();

    public static ExtentReports extent = ExtentManager.getInstance(); 
    public static ExcelReader excel = new ExcelReader("\\src\\test\\resources\\com\\excel\\testdatasheet.xlsx"); 
    public static MonitoringMail mail = new MonitoringMail();
    public static String browser;
    public static SignInPage signin;
	public static LandingPage lp;
	
    @BeforeSuite
	public void SetupPage() throws IOException{
    	if(driver == null) {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\properties\\config.properties");
			ele = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\properties\\elements.properties");
			prop.load(fis);
			element.load(ele);
	
			/*
			 * if(TestConfig.password == null) { appPassword = System.getenv("password");
			 * TestConfig.password=appPassword; }
			 */
		if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()) {
			browser = System.getenv("browser");
		}else {
			browser = prop.getProperty("browser");
		}
		
		prop.setProperty("browser", browser);
		
		if(prop.getProperty("browser").equals("chrome")) {
			/*
			 * Map<String, Object> prefs = new HashMap<String,Object>();
			 * prefs.put("profile.default_content_setting_values.notification", false);
			 * prefs.put("credentials_enable_service", false);
			 * prefs.put("profiles.password_manager_enabled", false); ChromeOptions options
			 * = new ChromeOptions(); options.setExperimentalOption("prefs", prefs);
			 * options.addArguments("--disable-extensions");
			 * options.addArguments("--disable-infobars");
			 */
			System.out.println("Browser is chrome");
			driver = new ChromeDriver();
			
			
			
		}
		else if(prop.getProperty("browser").equals("firefox")){
			System.out.println("Browser is firefox");
			driver = new FirefoxDriver();
			
		}
		else {
			
		}
		driver.get("https://magento.softwaretestingboard.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		topmenu = new TopMenu();
		
		}
	}
    @AfterSuite
	public void tearDown() {
		System.out.println("Inside teardown");
		extent.flush();
		driver.quit();
	}
	
    public static void click(WebElement link) {
		link.click();
		CustomListeners.test.log(Status.INFO, "Clicked "+link);
		
	}
    public static void type(WebElement link,String value) {
		link.sendKeys(value);
		CustomListeners.test.log(Status.INFO, "Typed "+value+" in" +link);
	}
    
    public static void clear(WebElement link) {
		link.clear();
		CustomListeners.test.log(Status.INFO, "Clear "+link);
	}
//	public static void click(String locator) {
//		if(locator.endsWith("_XPATH")) {
//			driver.findElement(By.xpath(element.getProperty(locator))).click();
//		}else if(locator.endsWith("_CSS")){
//			driver.findElement(By.cssSelector(element.getProperty(locator))).click();
//		}else if(locator.endsWith("_ID")) {
//			driver.findElement(By.id(element.getProperty(locator))).click();
//		}
//		
//		log.info("Clicking on " +locator);
//		//test.info("Clicking on " +locator);
//		CustomListeners.test.log(Status.INFO, "Clicking on " +locator);
//	}
	
//	public static void type(String locator,String value) {
//		if(locator.endsWith("_XPATH")) {
//			driver.findElement(By.xpath(element.getProperty(locator))).sendKeys(value);
//		}else if(locator.endsWith("_CSS")){
//			driver.findElement(By.cssSelector(element.getProperty(locator))).sendKeys(value);
//		}else if(locator.endsWith("_ID")) {
//			driver.findElement(By.id(element.getProperty(locator))).sendKeys(value);
//		}
//		
//		
//		log.info("Typying " +value+ " in " +locator);
//		//test.info("Typying " +value+ " in " +locator);
//		CustomListeners.test.log(Status.INFO, "Typying " +value+ " in " +locator);
//	}
	
//	public static void select(String locator, String value) {
//		WebElement dropbox = null;
//		if(locator.endsWith("_XPATH")) {
//			dropbox = driver.findElement(By.xpath(element.getProperty(locator)));
//		}else if(locator.endsWith("_CSS")){
//			dropbox =  driver.findElement(By.cssSelector(element.getProperty(locator)));
//		}else if(locator.endsWith("_ID")) {
//			dropbox =  driver.findElement(By.id(element.getProperty(locator)));
//		}
//		
//		Select se = new Select(dropbox);
//		se.selectByVisibleText(value);
//		log.info("Selected " +value+ " in " +locator);
//		//test.info("Selected " +value+ " in " +locator);
//		CustomListeners.test.log(Status.INFO,"Selected " +value+ " in " +locator);
//	}
//	
	public static boolean isElementPresent(String locator) {

		try {
		if(locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(element.getProperty(locator))).click();
		}else if(locator.endsWith("_CSS")){
			driver.findElement(By.cssSelector(element.getProperty(locator))).click();
		}else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(element.getProperty(locator))).click();
		}
		}catch(Exception e) {
			log.info("Element not found" +locator);
			CustomListeners.test.log(Status.INFO,"Element not found " +locator);
			return false;	
		}
		
		log.info("Finding an element " +locator);
		CustomListeners.test.log(Status.INFO,"Element found " +locator);
		return true;
	}
}
