package CommonLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	public WebDriver driver;
	public void firefox(String URL) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		
	}

}
