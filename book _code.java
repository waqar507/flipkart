package flipkart_mobile;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class book {

	public static void main(String[] args) throws InterruptedException {
		
		Date start =null, end =null;
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "https://www.flipkart.com/poco-m2-pro-green-greener-64-gb/p/itm5de3b6eb57ab4?pid=MOBFT7MKFHTAPDYD&lid=LSTMOBFT7MKFHTAPDYDLRJC1B&marketplace=FLIPKART&srno=s_1_3&otracker=AS_QueryStore_OrganicAutoSuggest_2_7_na_na_ps&otracker1=AS_QueryStore_OrganicAutoSuggest_2_7_na_na_ps&fm=SEARCH&iid=f1d8922d-c550-4bc7-953a-e94647dbe2c2.MOBFT7MKFHTAPDYD.SEARCH&ppt=sp&ppn=sp&ssid=j09q5zm5ls0000001594638691406&qH=52a0feaaf08fda5b";
		//String url = "https://www.flipkart.com/samsung-galaxy-a31-prism-crush-blue-128-gb/p/itmca37dc47f1c6a?pid=MOBFRZZHH4WHKZCW&lid=LSTMOBFRZZHH4WHKZCWSOSBOT&marketplace=FLIPKART&srno=s_1_1&otracker=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_1_6_na_na_na&fm=SEARCH&iid=b763e359-dea8-46ad-940f-622f8ea66938.MOBFRZZHH4WHKZCW.SEARCH&ppt=sp&ppn=sp&ssid=sfkndrefb40000001594640233105&qH=0258c7d48242959a";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		
	
		login(driver);
		Thread.sleep(1000);
		start = new Date();
		System.out.println(start.toLocaleString());
		
		boolean enabled = false;
		
		while (enabled != true) {
			try {
				check(driver);
				enabled = true;
							
			} catch (NoSuchElementException obj) {
				Thread.sleep(500);
				System.out.println("Waiting 0.5 seconds!!!");
				driver.get(driver.getCurrentUrl());
				continue;
			}
		}
		
		if(enabled) {
			driver.findElement(By.xpath("//button[text()='CONTINUE']")).click();
			Thread.sleep(2000);
			
			WebElement cvv = driver.findElement(By.cssSelector("input[type='password']"));
			if(cvv.isDisplayed() && cvv.isEnabled()) {
				System.out.println("CVV Field is active");
				System.out.println(cvv.getTagName());
				cvv.sendKeys("705");
				
				driver.findElement(By.xpath("//button[text()='Continue']")).click();
			}
			
		}
		
		end = new Date();
		System.out.println(end.toLocaleString());
		System.out.println("Difference: " + (end.getSeconds() - start.getSeconds()));
		
	}

	public static void check(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("pincodeInputId")).sendKeys("110092");
		Thread.sleep(200);
		driver.findElement(By.xpath("//span[text()='Check']")).click();
		System.out.println("Pincode has been set !!!");
		Thread.sleep(900);
		
		WebElement buy_now = driver.findElement(By.cssSelector("button[class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']"));
		/*while(!buy_now.isEnabled()) {
			driver.get(driver.getCurrentUrl());
		}*/
		if (buy_now.isEnabled()) {
			System.out.println("Clicking 'Buy Now' Button");
			buy_now.click();
			Thread.sleep(1000);
						
		} else {
			System.out.println("Button Disabled");
			driver.get(driver.getCurrentUrl());
			buy_now = driver.findElement(By.cssSelector("button[class='_2AkmmA _2Npkh4 _2kuvG8 _7UHT_c']"));
			buy_now.click();
		}

	}

	public static void login(WebDriver driver) throws InterruptedException {

		driver.findElement(By.cssSelector("a[class='_3Ep39l']")).click();
		driver.findElement(By.cssSelector("div[class='_39M2dM JB4AMj'] input[type='text']"))
				.sendKeys("9717306864");
		driver.findElement(By.cssSelector("div[class='_39M2dM JB4AMj'] input[type='password']"))
				.sendKeys("mubeen.1990");
		driver.findElement(By.cssSelector("div[class='_1avdGP'] button")).click();
		Thread.sleep(5000);
	}
}
