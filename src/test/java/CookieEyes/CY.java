package CookieEyes;

import javax.swing.text.Style;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Inputs.URL;
import Locators.LoginElements;

public class CY {
	
	Browser br=new Browser();
	URL url=new URL();
	LoginElements log=new LoginElements();
	
	@Test(priority=1)
	public void verify_waveurl() throws InterruptedException {
		
		br.firefox(url.cookieyes_url);
		Thread.sleep(2000);
		
	}
	
	@Test(priority=2)
	public void isenable_ispresent1() {
		
		
		boolean eleEnabled= br.driver.findElement(By.xpath(log.enab)).isEnabled();
		boolean eleSelected= br.driver.findElement(By.xpath(log.enab)).isDisplayed();
		boolean elePresent = br.driver.findElement(By.xpath(log.enab)).isSelected();
		
//		String actual_result=eleEnabled.toString();
		System.out.println(eleEnabled);
		System.out.println(eleSelected);
		System.out.println(elePresent);
	}
	
	@Test(priority=3)
	public void isenable_ispresent2() throws Throwable {
		
		br.driver.findElement(By.xpath(log.enab_button)).click();
		String attr=br.driver.findElement(By.xpath(log.email_verify)).getAttribute("role");
		System.out.println(attr);
		
	}
	
	@Test(priority=4)
	public void de_Select() {
		
		br.driver.findElement(By.xpath(log.email)).sendKeys(url.email);
		br.driver.findElement(By.xpath(log.password)).sendKeys(url.password);
		
	}
	
	

}
