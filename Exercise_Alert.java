package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("WebDriver.Chrome.driver", "F:\\Selenium\\eclipse-jee-luna-R-win32-x86_64\\eclipse-jee-luna-R-win32-x86_64\\eclipse\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals("You must be TechnoCredits student!!")){
			System.out.println("Test pass");
		}
		else
			System.out.println("Test fail");
		alert.accept();
		driver.close();
		driver.quit();
	}

}
