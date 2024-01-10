package actiTimeApplication.testScript;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import actiTimeApplication.genericLib.BaseClass;

public class Alertpopup2 extends BaseClass {
	@Test
 public void handleAlert() throws EncryptedDocumentException, IOException 
 {
	
	 driver.findElement(By.xpath("//div[contains(@class,'popup_menu_button_settings ')]")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelsheet("sheet2",1,1));
	driver.findElement(By.xpath("//td[@id='ButtonPane']/input[2]")).click();
	String msg=cu.getAlertMsg(driver);
	Reporter.log(msg,true);
	//System.out.println(msg);
	cu.clickAlertOk(driver);
	
	
 }
}
