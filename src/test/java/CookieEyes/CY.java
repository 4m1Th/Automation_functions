package CookieEyes;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import CommonLib.Browser;
import Inputs.URL;
import Locators.LoginElements;
import Locators.dropdown;

public class CY {
	
	Browser br=new Browser();
	URL url=new URL();
	LoginElements log=new LoginElements();
	dropdown log2=new dropdown();
	
	@Test(priority=1)
	public void verify_waveurl() throws InterruptedException {
		
		br.firefox(url.cookieyes_url);
		Thread.sleep(2000);
		
	}
	
//	@Test(priority=2)
//	public void isenable_ispresent1() {
//		
//		
//		boolean eleEnabled= br.driver.findElement(By.xpath(log.enab)).isEnabled();
//		boolean eleSelected= br.driver.findElement(By.xpath(log.enab)).isDisplayed();
//		boolean elePresent = br.driver.findElement(By.xpath(log.enab)).isSelected();
//		
////		String actual_result=eleEnabled.toString();
//		System.out.println(eleEnabled);
//		System.out.println(eleSelected);
//		System.out.println(elePresent);
//	}
//	
//	@Test(priority=3)
//	public void isenable_ispresent2() {
//		
//		br.driver.findElement(By.xpath(log.enab_button)).click();
//		String attr=br.driver.findElement(By.xpath(log.email_verify)).getAttribute("role");
//		System.out.println(attr);
//		
//	}
	
	@Test(priority=2)
	public void login() throws InterruptedException {
		
		br.driver.findElement(By.xpath(log.email)).sendKeys(url.email);
		br.driver.findElement(By.xpath(log.password)).sendKeys(url.password);
		br.driver.findElement(By.xpath(log.enab_button)).click();
		Thread.sleep(2000);
		
	}
	
//	@Test(priority=3)
//	public void de_select() throws InterruptedException {
//		
//		br.driver.navigate().to(url.consent_banner);
//		Thread.sleep(4000);
//		br.driver.findElement(By.xpath(log2.drop)).click();
//		Thread.sleep(2000);
//		WebElement elementdrop = br.driver.findElement(By.xpath(log2.drop));
//		List<WebElement> dropdownvalues = br.driver.findElements(By.xpath(log2.drop));
//		for(WebElement value:dropdownvalues)
//		{ 
//		  String pcvalues=value.getText();
//		  System.out.println("value names" + pcvalues);
//		 }
//		
//	}
//	
	@Test(priority=3)
	public void WindowHandling() throws Exception {
        String parentWindow = br.driver.getWindowHandle();
        System.out.println("tittle = "+br.driver.getTitle());
        Thread.sleep(3000);
        br.driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[6]/a")).click();
        Thread.sleep(3000);
        Set<String> allWindowHandles = br.driver.getWindowHandles();
        //Switching control to privacy policy window
        for(String handles: allWindowHandles) {
            if(!parentWindow.equals(handles)) {
                br.driver.switchTo().window(handles);
                System.out.println("window switched");
                break;
            }
        }
        String privacyPolicyWindowTittleActual = br.driver.getTitle();
        System.out.println("tittle = "+ privacyPolicyWindowTittleActual );
        String privacyPolicyWindowTittleExpected = "CookieYes | Privacy Policy Generator";
        //verifying that driver's control switched to privacy policy window.
        Assert.assertEquals(privacyPolicyWindowTittleActual, privacyPolicyWindowTittleExpected);

        //switching control to main window
        for(String handles: allWindowHandles) {
            if(parentWindow.equals(handles)) {
                br.driver.switchTo().window(handles);
                System.out.println("window switched");
                break;
            }
        }
        privacyPolicyWindowTittleActual = br.driver.getTitle();
        System.out.println("tittle = "+ privacyPolicyWindowTittleActual );
        privacyPolicyWindowTittleExpected = "CookieYes";
        //verifying that we are in privacy policy window now.
        Assert.assertEquals(privacyPolicyWindowTittleActual, privacyPolicyWindowTittleExpected);
        //br.takeSnapShot(br.driver, input.screenshot1);
    }

}
