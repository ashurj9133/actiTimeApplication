package actiTimeApplication.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
   @Override
   public void onTestFailure(ITestResult result)
   {
	   String TcName=result.getName();
	   TakesScreenshot ts=(TakesScreenshot)BaseClass.ListenerDriver;
	   
	   File src=ts.getScreenshotAs(OutputType.FILE);
	   File trg=new File("C:\\Users\\ashutosh\\Desktop\\Selenium\\actiTimeApplication\\screenshot2"+TcName+" .png");
	   try {
		   FileHandler.copy(src,trg);
	   }
	   catch(IOException e)
	   {}
   }
}
