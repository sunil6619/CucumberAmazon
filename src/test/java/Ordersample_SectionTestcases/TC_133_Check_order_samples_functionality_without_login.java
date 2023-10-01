package Ordersample_SectionTestcases;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resources.Base;

public class TC_133_Check_order_samples_functionality_without_login extends Base {
	@Parameters ("url")
	@BeforeTest
	
	public void launchurl_rugartisan() throws InterruptedException {
		
		getlaunchurl(getreaddata("url"));
	}
	
	@Test

	public void check_order_sample_functionality_without_login_Test() throws InterruptedException, AWTException {
		Thread.sleep(1000);
		 WebElement collection=driver.findElement(By.xpath("//div[@class=\"collapse navbar-collapse\"]/child::ul/child::li/child::a[@href=\"/collections\"]"));
		 mousehover(collection);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//div[@class=\"collection-item\"]/child::a/img[@alt=\"Field of Flowers\"]")).click();
		 Thread.sleep(1000);
		List<WebElement> customize=driver.findElements(By.xpath("//span[contains (text(),'Custom Sizes')]"));
		WebElement first=customize.get(0);
		first.click();
		zoomin();
		WebElement ordersamples=driver.findElement(By.xpath("//span[contains(text(),'Order Yarn Color Samples')]"));
		ordersamples.click();
		Thread.sleep(2000);
		WebElement widthft=driver.findElement(By.xpath("//div[@class=\"rug-size cs_feet\"]/descendant::input[@name=\"width[feet]\"]"));
		widthft.sendKeys("6");
		Thread.sleep(1000);
		WebElement lengthft=driver.findElement(By.xpath("//div[@class=\"rug-size cs_feet\"]/descendant::input[@name=\"length[feet]\"]"));
		lengthft.sendKeys("8");
		Thread.sleep(1000);
		WebElement ordersamplesbutton=driver.findElement(By.xpath("//input[@type=\"submit\"]"));
		ordersamplesbutton.isDisplayed();
		Assert.assertTrue(true);
		ordersamplesbutton.click();
		Thread.sleep(1000);
		WebElement emailpopup=driver.findElement(By.xpath("//label[contains(text(),'provide your email')]"));
		String text=emailpopup.getText();
		Assert.assertEquals("*Please provide your email to save your changes",text);
		
}}
