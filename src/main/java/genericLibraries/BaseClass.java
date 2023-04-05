package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactUsPage;
import pomPages.HomePage;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoAppPage;
import pomPages.TestingPage;

public class BaseClass {
	protected WebDriverUtility web;
	protected PropertiesFileUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillraryDemoAppPage demoapp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected ContactUsPage contact;
//	@BeforeSuite
//	@BeforeTest
	@BeforeClass
	public void classConfiguration() {
		
		web=new WebDriverUtility();
		property=new PropertiesFileUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		
		property.propertyConfig(IConstantPath.PROPERTIES_PATH);
		String browser=property.fetchProperty("browser");
		String url=property.fetchProperty("url");
		long time=Long.parseLong(property.fetchProperty("time"));
		driver=web.openApplication(browser, url, time);
	}
	@BeforeMethod
	public void methodConfiguration() {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		home=new HomePage(driver);
		demoapp=new SkillraryDemoAppPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPage(driver);
		contact=new ContactUsPage(driver);
		
		Assert.assertTrue(home.getLogo().isDisplayed());
	}
	@AfterMethod
	public void methodTearDown() {
		excel.closeWorkBook();
	}
	
	@AfterClass
	public void classTearDown() {
		web.quitBrowser();
	}
//	@AfterTest
//	@AfterSuite
	

}
