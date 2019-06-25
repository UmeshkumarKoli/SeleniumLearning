package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise_Registration {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdrive.chrome.drive", "F:\\Selenium\\eclipse-jee-luna-R-win32-x86_64\\eclipse-jee-luna-R-win32-x86_64\\eclipse\\cd\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Registration")).click();
		Thread.sleep(3000);
		
		// Test Name field
		WebElement fullName= driver.findElement(By.id("fullName"));
		fullName.sendKeys("Umesh123");
		WebElement submitButton=driver.findElement(By.xpath("//button[@id='btnsubmitsignUp']"));
		submitButton.click();
		Alert alert=driver.switchTo().alert();
		if(alert.getText().equals("Numeric value not allowed in fullname field")){
			System.out.println("Test \"Name Field with numeric data validation\" : Pass");
		}
		else
			System.out.println("Test \"Name Field with numeric data validation\" : Fail");
		alert.accept();
		
		//Test address field
		fullName.clear();
		fullName.sendKeys("UmeshKoli");
		submitButton.click();
		alert=driver.switchTo().alert();
		if(alert.getText().equals("address cannot be blank")){
			System.out.println("Test \"address Field with blank data validation\" : Pass");
		}
		else
			System.out.println("Test \"address Field with blank data validation\" : Fail");
		alert.accept();
		
		//Test email address field with correct data and blank email address
		WebElement address= driver.findElement(By.xpath("//input[@id='address']"));
		address.sendKeys("Wakad");
		submitButton.click();
		alert=driver.switchTo().alert();
		if(alert.getText().equals("Please enter email id")){
			System.out.println("Test \"email address Field with blank data validation\" : Pass");
		}
		else
			System.out.println("Test \"email address Field with blank data validation\"Fail");
		alert.accept();
		
		//Test email address field with correct data and blank email address
		WebElement emailAddress= driver.findElement(By.xpath("//input[@id='address']"));
		emailAddress.sendKeys("umeshkumar.koli");
		submitButton.click();
		alert=driver.switchTo().alert();
		if(alert.getText().equals("Please enter email id")){
			System.out.println("Test \"email address Field with blank data validation\" : Pass");
		}
		else
			System.out.println("Test \"email address Field with blank data validation\"Fail");
		alert.accept();
		
	}

}
