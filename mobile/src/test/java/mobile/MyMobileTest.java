package mobile;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MyMobileTest {

	static AppiumDriver<MobileElement> d;
	
	public static void main(String[] args) {
		try {
			openCalc();
			startChat();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void openCalc() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "D1AGAD57C0502143");
		cap.setCapability("platformName", "android");
		cap.setCapability("platformVersion", "9");
		cap.setCapability("appPackage", "com.whatsapp");
		cap.setCapability("appActivity", ".Main");
		cap.setCapability("noReset", true);	
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");		
		d = new AppiumDriver<MobileElement>(url, cap);		
		System.out.println("Application Started...");
	}
	
	public static void startChat() throws Exception {
		
		//MobileElement photo = d.findElement(By.id("com.whatsapp:id/contact_photo"));
		//photo.click();
		
		//MobileElement search = d.findElement(By.id("com.whatsapp:id/menuitem_search"));
		//search.click();
		
		//MobileElement menulist = d.findElement(By.id("com.whatsapp:id/menuitem_overflow"));
		//menulist.click();
		
		//MobileElement msgcount = d.findElement(By.id("com.whatsapp:id/conversations_row_message_count"));
		//System.out.println("Message Count is:");
		//System.out.println(msgcount.getText());
		
		MobileElement firstChat = d.findElement(By.id("contact_row_container"));
		firstChat.click();
		
		/*
		MobileElement txtBox = d.findElement(By.id("com.whatsapp:id/entry"));
		txtBox.click();
		txtBox.sendKeys("hi");
		
		MobileElement btnSend = d.findElement(By.id("com.whatsapp:id/send"));
		btnSend.click();
		
		*/
		Thread.sleep(3000);
		MobileElement lnkattach = d.findElement(By.id("com.whatsapp:id/input_attach_button"));
		lnkattach.click();
		
		//MobileElement clickDocs = d.findElement(By.id("com.whatsapp:id/pickfiletype_document_holder"));
		//clickDocs.click();
		
		Thread.sleep(3000);
		MobileElement clickPics = d.findElement(By.id("com.whatsapp:id/pickfiletype_gallery_holder"));
		clickPics.click();
		
		Thread.sleep(3000);
		MobileElement clickCamera = d.findElement(By.id("com.whatsapp:id/thumbnail"));
		clickCamera.click();
		
		Thread.sleep(3000);
		MobileElement clickPhoto = d.findElement(By.xpath("(//android.widget.ImageView[@content-desc='Photo'])[1]"));
		clickPhoto.click();

		Thread.sleep(3000);
		MobileElement btnSend = d.findElement(By.id("com.whatsapp:id/send"));
		btnSend.click();
		
		System.out.println("Image sent successfully!!");
		
	}

}
