package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_JavaScriptConfirmation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String ExpectedOutput_Ok="You pressed OK!";
		String ExpectedOutput_Cancel="You pressed Cancel!";
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\eclipse-jee-luna-R-win32-x86_64\\eclipse-jee-luna-R-win32-x86_64\\eclipse\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		//Test1 to accept and check string
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		String str= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (str.equals(ExpectedOutput_Ok))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		
		//Test2 to dismiss and check string
		driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")).click();
		//Test1 to accept and check string
		alert.dismiss();
		str= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (str.equals(ExpectedOutput_Cancel))
			System.out.println("Test Pass");
		else
			System.out.println("Test Fail");
		driver.close();
		driver.quit();
		
	}

}
