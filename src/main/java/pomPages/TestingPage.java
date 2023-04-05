package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {
//Declaration 
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	@FindBy(xpath="//img[@id='Selenium Training']")
	private WebElement seleniumTrainingImage;
	
	@FindBy(id="cartArea")
	private WebElement cartArea;
	
	@FindBy(xpath="//ul[@class='list-socialicons']/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	//initialization
	public TestingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	/**
	 * 
	 */
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public WebElement getSeleniumTrainingImage() {
		return seleniumTrainingImage;
	}
	
	public WebElement getCartArea() {
		return cartArea;
	}
	
	public void clickFacebookIcon() {
		facebookIcon.click();
	}
	
	
	public WebElement getFacebookIcon() {
		return facebookIcon;
	}
	
	
	

	
}

