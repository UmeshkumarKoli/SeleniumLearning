import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OnlineOrderTShirt {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions o = new ChromeOptions();
		String [] s = new String[] {"--start-maximized"};//"disable-extensions",
        o.addArguments(s);	
        
        //ChromeDrive should be compatible with chrome version
        System.setProperty("webdriver.chrome.driver", "F:\\appium\\adt\\adt-bundle-windows-x86_64-20140702\\eclipse\\chromedriver.exe");
        ChromeDriver driver= new ChromeDriver();
        
		driver.get("http://automationpractice.com/index.php");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]/span")));
		/*P1: //*[@id="center_column"]/ul/li[1]
		P2: //*[@id="center_column"]/ul/li[2]
		P3: //*[@id="center_column"]/ul/li[3]
			//*[@id="center_column"]/ul/li[4]
			 * 
			 * //*[@id="center_column"]/ul
			 */
	    
	    List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul"));
	    java.util.Iterator<WebElement> i = listOfProducts.iterator();
	    while(i.hasNext()) {
	        WebElement row = i.next();
	        System.out.println(row.getText());
	    } 
	    
	  //*[@id="center_column"]/ul/li[1]/div/div[2]/div[2]/a[1]/span
	    Actions builder = new Actions(driver);
	    
	    
	    //*[@id="center_column"]/ul/li[1]/div/div[1]/div/a[1]/img
	    builder.moveToElement(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")));
	    WebElement w = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span"));
	    w.click();
	    WebElement proceedToCheckoutPopUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")));
	    proceedToCheckoutPopUp.click();
	    WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")));
	    proceedToCheckout.click();
	    WebElement emailAddress = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
	    emailAddress.sendKeys("Umeshmastkoli@gmail.com");
	    driver.findElement(By.id("passwd")).sendKeys("ifm@123#");
	    driver.findElement(By.id("SubmitLogin")).click();
	    
	    WebElement ProceedToShipping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")));
	    ProceedToShipping.click();
	    
	    WebElement ProceedToPayment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/p/button/span")));
	    driver.findElement(By.id("cgv")).click();
	    ProceedToPayment.click();
	    
	    WebElement Payment = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")));
	    Payment.click();
	    
	    WebElement ConfirmOrder = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cart_navigation\"]/button/span")));
	    ConfirmOrder.click();
	    
	    Thread.sleep(1000);
	 
	    System.out.println("Before Assert : "+ driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText());
	    Assert.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText());
	    
	   driver.close();
	   driver.quit();
	}

}
