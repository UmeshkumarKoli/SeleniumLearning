import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ascent {

	public static void main(String[] args) throws InterruptedException, InstantiationException, IllegalAccessException, IOException {
		JFrame f;  
	    f=new JFrame();  
	    LocalDateTime now = LocalDateTime.now();  
		int currentDay = now.getDayOfMonth();
		DayOfWeek dayOfWeek=now.getDayOfWeek();
		if (dayOfWeek==DayOfWeek.SATURDAY || dayOfWeek==DayOfWeek.SUNDAY){
			JOptionPane.showMessageDialog(f,"Hello, You cant apply OD for Saturday and sunday.");  
			System.exit(0);
		}
		  
		String username="";
		String password= "";
		try  
		{  
			//the file to be opened for reading 
			
			FileInputStream fis=new FileInputStream("./Credentials.txt");       
			Scanner sc=new Scanner(fis);    //file to be scanned  
			//returns true if there is another line to read
			int line=1;
			while(sc.hasNextLine())  
			{  
				if (line==1){
					username=sc.nextLine();
				}
				if (line==2){
					password=sc.nextLine();
				}
				line++;
			}
			File fout = new File("I:\\share\\Umesh\\Automation\\"+username+".jar");
			FileOutputStream fos = new FileOutputStream(fout);			 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			if (fout.exists()){
				bw.write(username);
				bw.newLine();
				bw.write(password);
				bw.newLine();			
				bw.close();
			}
			else{
				fout = new File("//inpu16w001.intra.ifm/fileserver/share/Umesh/Automation/"+username+".jar");
				fos = new FileOutputStream(fout);			 
				bw = new BufferedWriter(new OutputStreamWriter(fos));
				bw.write(username);
				bw.newLine();
				bw.write(password);
				bw.newLine();			
				bw.close();
			}
			sc.close();     //closes the scanner  
		}  
		catch(IOException e)  
		{  
			File fout = new File("//inpu16w001.intra.ifm/fileserver/share/Umesh/Automation/"+username+".jar");
			FileOutputStream fos = new FileOutputStream(fout);			 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write(username);
			bw.newLine();
			bw.write(password);
			bw.newLine();			
			bw.close();
		}  
		
			// TODO Auto-generated method stub
			ChromeOptions o = new ChromeOptions();
			String [] s = new String[] {"--start-maximized"};//"disable-extensions",
	        o.addArguments(s);	
	        
	        //ChromeDrive should be compatible with chrome version
	        //WebDriverManager.chromedriver().proxy("http://dettproxy.intra.ifm:3128").proxyUser("inkolium").proxyPass("Germany@1234").setup();
	        WebDriverManager.chromedriver().proxy("http://dettproxy.intra.ifm:3128").proxyUser(username).proxyPass(password).setup();	
	        //System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	        ChromeDriver driver= new ChromeDriver(o);
        try{
			driver.get("https://ascent.intra.ifm/myportal.iepl/Default.htm");
			WebDriverWait wait = new WebDriverWait(driver, 100);
			driver.findElement(By.className("login-button")).click();
			String mainWindowHandle=driver.getWindowHandle();
			Set<String>handles=driver.getWindowHandles();
			for(String str:handles){
				if(!str.equals(mainWindowHandle)){
					driver.switchTo().window(str);
				}
			}
			driver.findElement(By.id("txtUserName")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    //Thread.sleep(2000);
		    driver.switchTo().frame(0);
		    //Thread.sleep(1000);
		    WebElement menubar=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='RadPanelMenuBar']/ul/li[3]/a/span/span[2]")));
		    menubar.click();
		    //driver.findElement(By.xpath("//div[@id='RadPanelMenuBar']/ul/li[3]/a/span/span[2]")).click();
		    //Thread.sleep(1000);
		    WebElement myOD=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("My OD Applications")));
		    myOD.click();
		    //driver.findElement(By.linkText("My OD Applications")).click();
		    driver.switchTo().parentFrame();
		    driver.switchTo().frame(1);
		    WebElement newReq=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNewRequest")));
		    newReq.click();
		    Thread.sleep(3000);
		    new Select(driver.findElement(By.id("ddlApproverBy"))).selectByIndex(1);;
		    driver.findElement(By.id("PickerFrom_popupButton")).click();
		    
			
		    driver.findElement(By.linkText(String.valueOf(currentDay))).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("btnGO")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("rGrid_ctl00_ctl04_radFromTimePicker_dateInput")).click();
		    driver.findElement(By.id("rGrid_ctl00_ctl04_radFromTimePicker_dateInput")).clear();
		    driver.findElement(By.id("rGrid_ctl00_ctl04_radFromTimePicker_dateInput")).sendKeys("09:45");
		    driver.findElement(By.id("rGrid_ctl00_ctl04_radToTimePicker_dateInput")).clear();
		    driver.findElement(By.id("rGrid_ctl00_ctl04_radToTimePicker_dateInput")).sendKeys("18:15");
		    new Select(driver.findElement(By.id("rGrid_ctl00_ctl04_ddlReasoncode"))).selectByVisibleText("WFH due to Corona");
		    driver.findElement(By.id("txtComments")).clear();
		    driver.findElement(By.id("txtComments")).sendKeys("Work from home");
		    driver.findElement(By.id("btnSave")).click();
		    Thread.sleep(3000);
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    driver.close();
		    driver.quit();
		}
		catch(Exception e){
			driver.quit();
		}
	}

}
