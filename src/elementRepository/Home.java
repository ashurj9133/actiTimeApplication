package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	 
	 
	 @FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	 public  WebElement getlogoutLink()
	 {
		 return logoutLink;
	 }
	 public void logoutApp() {
		 getlogoutLink().click();
	 }
}
