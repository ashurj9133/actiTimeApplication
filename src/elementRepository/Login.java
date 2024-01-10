package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="username")
   private WebElement usernameTB;
	
	@FindBy(name="pwd")
   private WebElement passwordTB;
	
	@FindBy(id="loginButton")
   private WebElement loginButton;
	
	public WebElement getUsernameTB()
	{
		return usernameTB;
	}
	public WebElement getPasswordTB()
	{
		return passwordTB;
	}
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	
	public void loginApp(String username,String password)
	{
		getUsernameTB().sendKeys(username);
		getPasswordTB().sendKeys(password);
		getLoginButton().click();
	}
}
