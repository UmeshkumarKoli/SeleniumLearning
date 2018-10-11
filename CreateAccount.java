import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

	public static void main(String[] args) {
		
		String url="http://www.automationpractice.com";
		
		ChromeOptions o = new ChromeOptions();
		String [] s = new String[] {"--start-maximized"};//"disable-extensions",
		String exePath= "F:\\Sel_Web_drive\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);	
		o.addArguments(s);
		
		WebDriver driver = new ChromeDriver(o);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.className("login")).click();
		WebElement email= driver.findElement(By.id("email_create"));
		email.clear();
		email.sendKeys("umeshmastkoli@gmail.com");
		email.submit(); // If we use sumbit we dont need to identify object(//driver.findElement(By.id("SubmitCreate")).click()) and click on it.
		WebDriverWait w = new WebDriverWait(driver, 100);
		WebElement radio_title = w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("id_gender1"))));
		radio_title.click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Umeshkumar");
		driver.findElement(By.id("customer_lastname")).sendKeys("Koli");
		driver.findElement(By.id("passwd")).sendKeys("Password@123#");
		driver.findElement(By.id("days")).sendKeys("2");
		driver.findElement(By.id("months")).sendKeys("June");
		driver.findElement(By.id("years")).sendKeys("1986");
		if (driver.findElement(By.id("newsletter")).isSelected()== false) {
			driver.findElement(By.id("newsletter")).click();			
		}
		if (driver.findElement(By.id("optin")).isSelected()== false) {
			driver.findElement(By.id("optin")).click();			
		}
		
		driver.findElement(By.id("company")).sendKeys("ifm electronic");
		driver.findElement(By.id("address1")).sendKeys("wakad,Pune");
		driver.findElement(By.id("city")).sendKeys("Pune");
		driver.findElement(By.id("id_state")).sendKeys("Texas");
		driver.findElement(By.id("postcode")).sendKeys("411057");
		driver.findElement(By.id("phone_mobile")).sendKeys("+91-9123456789");
		WebElement Alias= driver.findElement(By.id("alias"));
		Alias.clear();
		Alias.sendKeys("umeshkumar.koli86");
		driver.findElement(By.id("submitAccount")).submit();
		
		driver.close();
		driver.quit();
		 
	}

}
