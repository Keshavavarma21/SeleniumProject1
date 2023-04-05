package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class Test1 extends BaseClass {
	@Test
	public void test1() {
		SoftAssert soft=new SoftAssert();
		
		home.clickGearsTab();
		home.clickSkillraryDemoApp();
		
		web.handleChildBrowser();
		soft.assertEquals(demoapp.getPageHeader(), "SkillRary-ECommerce");
		
		demoapp.mouseHoverToCourse(web);
		demoapp.clickSeleniumTraining();
		soft.assertEquals(selenium.getPageHeader(),"Selenium Training" );
		
		selenium.doubleClickAdd(web);
		selenium.clickAddToCart();
		web.handleAlert("ok");
		
		soft.assertEquals(selenium.getItemAddedToCartMessage(),"");
		soft.assertAll();
		
	}

}
