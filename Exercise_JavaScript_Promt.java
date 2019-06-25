package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_JavaScript_Promt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String expectedOut="Hello Umesh! How are you today?";
		String expectedOut_Cancel="User cancelled the prompt.";
		System.setProperty("webdriver.chrome.drive", "F:\\Selenium\\eclipse-jee-luna-R-win32-x86_64\\eclipse-jee-luna-R-win32-x86_64\\eclipse\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		
		//Test1_accept prompt message
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		Alert alert= driver.switchTo().alert();
		alert.sendKeys("Umesh");
		alert.accept();
		
		String str= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(str.equals(expectedOut)){
			System.out.println("Test Pass");
		}
		else
			System.out.println("Test fail");
		
		//Test2_dismiss prompt message
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		alert= driver.switchTo().alert();
		alert.sendKeys("Umesh");
		alert.dismiss();
		
		str= driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if(str.equals(expectedOut_Cancel)){
			System.out.println("Test Pass");
		}
		else
			System.out.println("Test fail");
		driver.close();
		driver.quit();
	}

}
