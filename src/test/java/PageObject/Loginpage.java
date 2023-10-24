package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class Loginpage {

	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy(xpath = "//div[@id=\"nav-signin-tooltip\"]/descendant::span")
    private WebElement signinbutton;
	@FindBy(xpath = "//h1[contains(text(),'Sign ')]")
    private WebElement signinbox;
	@FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement email;
	@FindBy(xpath = "//input[@id=\"continue\"]")
    private WebElement continuebutton;
	@FindBy(xpath = "//label[contains(text(),'Password')]")
    private WebElement passwordbox;
	@FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement password;
	@FindBy(xpath = "//input[@id=\"signInSubmit\"]")
	private WebElement signin;
	
	public void clicksigininbutton() {
		signinbutton.click();
	}
	
	
	public void signinbox() {
		String text=signinbox.getText();
		Assert.assertEquals("Sign in",text);
	}
	public void enteremail(String emailaddress) {
		email.sendKeys(emailaddress);
	}
	public void clickoncontinue() {
		continuebutton.click();
	}
	public void  passwordboxverify(){
		String text=passwordbox.getText();
		Assert.assertEquals("Password",text);
	}
	
	public void enterpassword(String pswd) {
		password.sendKeys(pswd);
	}
	public void clickonsigin() {
		signin.click();
		
	}
}
