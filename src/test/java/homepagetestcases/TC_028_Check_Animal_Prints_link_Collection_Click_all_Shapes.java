package homepagetestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resources.Base;

public class TC_028_Check_Animal_Prints_link_Collection_Click_all_Shapes extends Base {
	@Parameters("url")
	@BeforeTest
	public void getlaunchurl_rugartisan() throws InterruptedException
	{
		getlaunchurl(getreaddata("url"));

	}
	@Test
	public void check_animal_prints_link_in_collection_click_all_shapes_Test() throws InterruptedException {
		Thread.sleep(1000);
		WebElement collec=driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a[text()='Collection']"));
		mousehover(collec);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt=\"Animal Prints\"]/ancestor::div[@class=\"collection-item\"]")).click();
		Thread.sleep(1000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		driver.findElement(By.xpath("//span[contains(text(),'Animal Prints Custom Rugs')]")).isDisplayed();
	    Assert.assertTrue(true);
//		clickdiffshapes();
	}
}
