package actiTimeApplication.genericLib;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import elementRepository.Home;
import elementRepository.Login;

public class BaseClass {
  public  WebDriver driver;
  public static WebDriver ListenerDriver;
  
    public CommonUtility cu=new CommonUtility();
    public DataUtility du=new DataUtility();
    //@Parameters("browser")
    @BeforeClass(alwaysRun=true)
    public void launchBrowser()
    {
    	
       driver=new ChromeDriver();
    	ListenerDriver=driver;
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
//    @Parameters({"url","username","password"})
//    @BeforeMethod(alwaysRun=true)
//    public void login(String url,String username,String password) throws IOException
//    {
//    	driver.get(url);
//        driver.findElement(By.id("username")).sendKeys(username);
//        driver.findElement(By.name("pwd")).sendKeys(password);
//        driver.findElement(By.id("keepLoggedInCheckBoxContainer")).click();
//        driver.findElement(By.id("loginButton")).click();	
//    }
    @BeforeMethod(alwaysRun=true)
    public void login() throws IOException
    {
    	driver.get(du.getDataFromProperties("url"));
    	Login l=new Login(driver);
       l.loginApp(du.getDataFromProperties("username"),du.getDataFromProperties("password"));
        
        //driver.findElement(By.id("keepLoggedInCheckBoxContainer")).click();
        	
    }  
    @AfterMethod(alwaysRun=true)
    public void logout()
    {
    	Home h=new Home(driver);
    	h.logoutApp();
    }
    @AfterClass(alwaysRun=true)
    public void closeBrowser()
    {
    	driver.quit();
    }
}
