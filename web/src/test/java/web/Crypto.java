package web;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Crypto {

	public static void main(String[] args) throws Exception  {
		
		//Launch Web Page
		System.setProperty("webdriver.chrome.driver", "C:\\Auto\\Driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://myvip.avatrade.com/?wtrelogin=1");
		d.manage().window().maximize();
		
		//Login
		Thread.sleep(5000);
		d.findElement(By.id("logEmailInput")).sendKeys("john.lingam1997@gmail.com");
		d.findElement(By.id("password")).sendKeys("Love4all");
		d.findElement(By.id("AvasWidgetLoginSubmit")).click();
		
		//Select CRYPTO option
		Thread.sleep(10000);
		d.findElement(By.xpath("//a[@href='/trade/crypto']")).click();
				
		Thread.sleep(10000);
		Actions a =new Actions(d);
		Boolean eFlag;
		ArrayList<String> al= new ArrayList<String>();

		//Loop to click Star Icon
		for (int i=1;i<20;i++) {
			String rTxt = "//table[contains(@class,'watchlist')]/tbody/tr[" + i + "]";		
			try {
				eFlag = false; 
				d.findElement(By.xpath(rTxt + "/td[6]/div/div[2]")).click();	
			} catch (Exception e) {
				eFlag = true;
				a.moveToElement(d.findElement(By.xpath(rTxt + "/td[1]"))).click().sendKeys(Keys.ARROW_DOWN).build().perform();
				System.out.println(e.getMessage());
				try {
					eFlag = false; 
					d.findElement(By.xpath(rTxt + "/td[6]/div/div[2]")).click();	
					a.moveToElement(d.findElement(By.xpath(rTxt + "/td[1]"))).click().sendKeys(Keys.ARROW_UP).build().perform();
				} catch (Exception ex) {
					eFlag = true;
				}
			}
			
			if (!eFlag) {
				al.add(d.findElement(By.xpath(rTxt + "/td[1]")).getText());
			}
		}
		
		//Click Favorite Option
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[@href='/trade/745379']")).click();
		Thread.sleep(3000);
		
		ArrayList<String> aln= new ArrayList<String>();
		int rCount = d.findElements(By.xpath("//table[contains(@class,'watchlist')]/tbody/tr")).size();
		for (int i=1;i<=rCount;i++) {
			try {
				String rTxt = "//table[contains(@class,'watchlist')]/tbody/tr[" + i + "]";
				aln.add(d.findElement(By.xpath(rTxt + "/td[1]")).getText());
				a.moveToElement(d.findElement(By.xpath(rTxt + "/td[1]"))).click().sendKeys(Keys.ARROW_DOWN).build().perform();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
        System.out.println("Selected Values from CRYPTO:");

        String str_Array[]=al.toArray(new String[al.size()]);
        for(String ary: str_Array){
        System.out.print(ary + " ");
        }
        
        System.out.println("");
        System.out.println("Available Values from Favorite Section");
        
        String str_Array2[]=aln.toArray(new String[aln.size()]);
        for(String ary: str_Array2){
        System.out.print(ary + " ");
        }
		
	}
}
