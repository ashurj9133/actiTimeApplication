package actiTimeApplication.genericLib;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	public int getRandomNum()
	   {
		   Random r=new Random();
		   int num=r.nextInt(10000);
		   return num;
	   }
	public void getFetchData(WebElement dropdown,String visibleText)
	{
		Select s=new Select(dropdown);
	    s.selectByVisibleText(visibleText);
	    
	}
	// Class AlertPopup(fetch the msg of alertpopup)
	public String getAlertMsg(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		return msg;
	}
	//class AlertPop(click OK on cancel button)
	public void clickAlertOk(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public void textToBePresentWait(WebDriver driver,By locator,String value)
	{
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,value));
	}
}
