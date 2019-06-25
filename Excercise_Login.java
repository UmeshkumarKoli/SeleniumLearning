package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excercise_Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium\\eclipse-jee-luna-R-win32-x86_64\\eclipse-jee-luna-R-win32-x86_64\\eclipse\\cd\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("unameSignin")).sendKeys("Umeshkoli");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		//Test 1 - enter less than 8 character and check failed message
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals("Failed! please enter strong password"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		alert.accept();
		
		//Test 2 - enter more than 8 character and check success message
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		alert=driver.switchTo().alert();
		if(alert.getText().equals("Success!"))
			System.out.println("Test pass");
		else
			System.out.println("Test fail");
		alert.accept();
		
		driver.close();
		driver.quit();
	}

}
