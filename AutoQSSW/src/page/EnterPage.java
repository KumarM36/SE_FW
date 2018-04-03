package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import generic.AutoUtil;
import generic.IAutoConst;
import junit.framework.Assert;

public class EnterPage {
@FindBy(xpath="//div[contains(text(),'Help')]")
private WebElement help;
@FindBy(linkText="About your actiTIME")
private WebElement aboutAT;
@FindBy(xpath="//Span[@class='productVersion']")
private WebElement version;
public EnterPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}
public void clickHelp(){
	help.click();
}
public void verifyproductversion(String eVersion){
	String aVersion=version.getText();
	Assert.assertEquals(aVersion, eVersion);
}
public void VerifyHomePageIsDisplayed(WebDriver driver, String eTitle){
	String strETO=AutoUtil.getproperty(IAutoConst.CONFIG_PATH,"ETO" );
	long ETO=Long.parseLong(strETO);
	WebDriverWait wait=new WebDriverWait(driver,ETO);
try {
	wait.until(ExpectedConditions.titleIs(eTitle));
	Reporter.log("Home page is Displayed",true);
	}
catch (Exception e){
	Reporter.log("Home page is Not Displayed",true);
	Assert.fail();
}
}
}
