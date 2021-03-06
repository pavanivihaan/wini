package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoinMarketCap {

	public static void main(String[] args) throws InterruptedException {		
				
				//WebDriverManager.chromedriver().browserVersion("98.0.4758.102").setup();
				WebDriverManager.chromedriver().setup();
				
				//Launch Web Page
				//System.setProperty("webdriver.chrome.driver", "C:\\Auto\\Driver\\chromedriver.exe");
				WebDriver d = new ChromeDriver();
				d.get("https://coinmarketcap.com");
				d.manage().window().maximize();
				
				//Login
				Thread.sleep(5000);
				//int rows= d.findElements(By.xpath("//*[@id=\"__next\"]/div/div[1]/div[2]/div/div/div[5]/table/tbody/tr")).size();
				int rows= d.findElements(By.xpath("//div[@class='grid']//table/tbody/tr")).size();
                System.out.println(rows);
                
                d.close();

	}

}
