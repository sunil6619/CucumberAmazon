package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageObject.Loginpage;
import PageObject.SearchProduct;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


/*child class of Base class*/
public class StepDef extends BaseClass{

	//@Before ("@Sanity") conditional hooks 
	@Before	(order =2)
	public void setup() {
		//initialise logger
		Log= LogManager.getLogger("StepDef");
		readConfig=new Properties(); 
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Log.info("Set up executed");
	}
	//before can be used multiple times and by default these will run alphabetically
	// if we need to give run as per our need then need to give value to this
	// order value lower will execute first
	//@Before ("@regression") conditional hooks 
	@Before	(order=1)
	public void setup2() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
		
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		loginpage= new Loginpage(driver);
		searchproduct= new SearchProduct(driver);
		Log.info("Chrome browser launched");

	}

	@When("User opens  URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		Log.info("URL launched");

	}

	@When("User Clicks on Sign in")
	public void user_clicks_on_sign_in() {
		loginpage.clicksigininbutton();
		Log.info("Clicked Sign in ");
	}

	@Then("User should get sign in box")
	public void user_should_get_sign_in_box() {
    loginpage.signinbox();
	Log.info("Got sigin box ");
	}

	@When("User enters Email as {string}")
	public void user_enters_email_as(String email) {
    loginpage.enteremail(email);
    
	}

	@When("User click on continue")
	public void user_click_on_continue() {
		loginpage.clickoncontinue();
	}

	@Then("User should get box to enter password")
	public void user_should_get_box_to_enter_password() {
    loginpage.passwordboxverify();
	}

	@When("User enters Password as {string}")
	public void user_enters_password_as(String pswd) {
		loginpage.enterpassword(pswd);
	}

	@When("Click on Login")
	public void click_on_login() {
    loginpage.clickonsigin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedtitle) {
    String actualtitle=driver.getTitle();
    
    if(actualtitle.equals(expectedtitle)) {
    	
    	Assert.assertTrue(true);//pass
    }
    else {
    	Assert.assertTrue(false);//fail
    }
//    Assert.assertEquals(expectedtitle,actualtitle);
	}

	@Then("Close browser")
	public void close_browser() {
    driver.close();
	}

	/////////Search Product///////////////
	
	@When("Search Product {string}")
	public void search_product(String product) {
		searchproduct.enterproductinsearch(product);
	}

	@When("From suggestions click iphone {int}")
	public void from_suggestions_click_iphone(Integer int1) throws InterruptedException {
		searchproduct.clickiphone13dropdown();
	}

	@When("Click on Apple iPhone {int} \\(128GB) - Starlight and verify")
	public void click_on_apple_i_phone_128gb_starlight_and_verify(Integer int1) throws InterruptedException {
	   searchproduct.clickstarlight();
	}

	@When("Click on Add to Cart")
	public void click_on_add_to_cart() throws InterruptedException {
		Set<String> windowhandles=driver.getWindowHandles();
		List<String>windowhandlesList=new ArrayList<>(windowhandles);
		System.out.println("Total window number: "+ windowhandlesList.size()+"\n");
		driver.switchTo().window(windowhandlesList.get(1));
		Actions act = new Actions(driver);
	       act.sendKeys(Keys.PAGE_DOWN).build().perform();
	       Thread.sleep(2000);
		searchproduct.clickaddtocart();
		
	    
	}

	@Then("Added to cart box should appear")
	public void added_to_cart_box_should_appear() throws InterruptedException {
		Thread.sleep(2000);
		String actualcartmsg=searchproduct.verifyaddedtocart();
		System.out.println(actualcartmsg);
		String expectedmsg="Added to Cart";
		Assert.assertEquals(expectedmsg,actualcartmsg);
	
		
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario){

//		if(scenario.isFailed())
//		{
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		//attach image file report(data, media type, name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
//		}
	}
	
	// taking screenshot of failed test cases 
	//@After
	public void teardown3(Scenario sc) throws IOException {
		System.out.println("Tear down method executed");
		if (sc.isFailed()==true) {
			//Convert web driver object to TakeScreenshot
			
			String filepath="S:\\Eclipse 2\\Rugartisan0\\Screenshot\\test1.png";
			TakesScreenshot srcShot=((TakesScreenshot)driver);
			//Call getScreenshot method to create image file
			File SrcFile=srcShot.getScreenshotAs(OutputType.FILE);
			//Move image to new Destination
			File DestFile=new File(filepath);
			//Copy file to destination
			FileUtils.copyFile(SrcFile,DestFile);
			
		}
		driver.close();
		
	}
	
	
	
	@After(order =1)
	public void teardown() {
		driver.close();
		
	}
	
	//after can be used multiple times and by default these will run alphabetically
		// if we need to give run as per our need then need to give value to this
		// order value higher will execute first
//	@After(order=2)
//	public void teardown2() {
//		driver.close();
		
	}
	//step hoo
//	@BeforeStep
//	public void beforestepmethod(){
//		System.out.println("before step method");
//	}
	
//	@AfterStep
//	public void afterstepmethod(){
//		System.out.println("after step method");
//	}
	
	
