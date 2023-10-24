package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Applyfilters_add_to_wishlist {
	WebDriver ldriver;
	public Applyfilters_add_to_wishlist(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	@FindBy (xpath = "//input[@type=\"text\"]")
	private WebElement searchinput;
}
