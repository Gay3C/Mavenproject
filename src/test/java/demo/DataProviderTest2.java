package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import util.DataProviderHolder1;

public class DataProviderTest2 {
	
	@Test(dataProvider = "StuLogin1" , dataProviderClass = DataProviderHolder1.class)
	
	public void VerifyvalidLogin(String userName, String password) {
		System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.close();
		
	}
	
    
}
