package actiTimeApplication.testScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider {
	
	@Test(dataProvider="loginData")
	public void login(String username,String password)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ashutosh\\Desktop\\Selenium\\Drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actiTime.com/login.do");
	      driver.findElement(By.id("username")).sendKeys(username);
	      driver.findElement(By.name("pwd")).sendKeys(password);
	}
	@DataProvider
	public Object[][]loginData()
	{
//		Object[][] data=new Object[2][2];
//		data[0][0]="admin";
//		data[0][1]="manager";
//		data[1][0]="admin";
//		data[1][1]="manager1";
		
		Object[][] data=new Object[][] {    //above code and this code is same, here semi colon hoga last me
			{"admin","manager"},                                       //staring me semicolon nhi hoga
			{"admin","manager1"}
		};
		
		return data;
	}
}
