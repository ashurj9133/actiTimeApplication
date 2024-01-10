package actiTimeApplication.testScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import actiTimeApplication.genericLib.BaseClass;

public class DropDownHandlling extends BaseClass {
@Test	
public void customerCreation()
{
	driver.findElement(By.xpath("//div[contains(@class,'popup_menu_button_settings')]")).click();
    driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']")).click();
    WebElement usergroups=driver.findElement(By.id("userGroupNamingCodeSelect"));
    
    cu.getFetchData(usergroups,"Location");
    String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
    Reporter.log(msg,true);
   // System.out.println(msg);
   
}
}
