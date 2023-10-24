package PageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchProduct {
	
	WebDriver ldriver;
public SearchProduct(WebDriver rdriver) {
	ldriver= rdriver;
	PageFactory.initElements(rdriver,this);
	
}
@FindBy (xpath = "//input[@type=\"text\"]")
private WebElement searchinput;
@FindBy(xpath = "//div[@aria-label=\"iphone 13\"]")
private WebElement iphone13;
@FindBy(xpath = "//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/descendant::span[contains(text(),'Apple iPhone 13 (128GB) - Starlight')]")
private WebElement starlight;
@FindBy(xpath = "(//input[@name=\"submit.add-to-cart\"])[2]")
private WebElement addtocart;
@FindBy(xpath = "//div[@id=\"attach-added-to-cart-message\"]/descendant::h4[contains(text(),'Added to Cart')]")
private WebElement addedtocart;

public void enterproductinsearch(String prod) {
	searchinput.click();
	searchinput.sendKeys(prod);
}
public void clickiphone13dropdown() throws InterruptedException {
	Thread.sleep(2000);
	iphone13.click();
}
public void clickstarlight() throws InterruptedException {
	Thread.sleep(2000);
	Actions act= new Actions(ldriver);
	act.sendKeys(Keys.PAGE_DOWN).build().perform();
	Thread.sleep(1000);
	starlight.click();
//	Set<String> windowhandles=driver.getWindowHandles();
//	List<String>windowhandlesList=new ArrayList<>(windowhandles);
//	System.out.println("Total window number: "+ windowhandlesList.size()+"\n");
//	driver.switchTo().window(windowhandlesList.get(1));
}
public void clickaddtocart() throws InterruptedException {
	Thread.sleep(2000);
	addtocart.click();
	
}
public String verifyaddedtocart() throws InterruptedException {
	Thread.sleep(3000);
	String text= addedtocart.getText();
	return text;
	
	
}

}
