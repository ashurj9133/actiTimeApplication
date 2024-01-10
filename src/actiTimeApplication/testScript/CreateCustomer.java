package actiTimeApplication.testScript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actiTimeApplication.genericLib.BaseClass;
import actiTimeApplication.genericLib.CommonUtility;
 @Listeners(actiTimeApplication.genericLib.ListenerImplementation.class)
public class CreateCustomer extends BaseClass {
	@Test
   public void createCustomer() throws EncryptedDocumentException, IOException
   {
		String customername=du.getDataFromExcelsheet("sheet2",0,1);
		  int num=cu.getRandomNum();
		  customername=customername+num;
	   driver.findElement(By.id("container_tasks")).click();
	      
	      driver.findElement(By.cssSelector(".title.ellipsis ")).click();
	      
	      driver.findElement(By.className("createNewCustomer")).click();
	      driver.findElement(By.className("newNameField")).sendKeys(customername);
	      driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("he is new customer");
	      driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	     
	      cu.textToBePresentWait(driver,By.cssSelector(".titleEditButtonContainer>.title"), customername);
	      String ExpectedCustomerName=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
	      
	   
	      Assert.assertEquals(customername,ExpectedCustomerName);
	  	Reporter.log("TC pass",true);
	  
   }
}
