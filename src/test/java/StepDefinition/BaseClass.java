package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.Loginpage;
import PageObject.SearchProduct;


/*Parent Class*/
public class BaseClass {
	public WebDriver driver;
	public Loginpage loginpage;
	public SearchProduct searchproduct;
	public static Logger Log;
	public Properties readConfig;
	// generate unique email id 
	public String generateEmailid() {
		return (RandomStringUtils.randomAlphabetic(5));
	}
}
