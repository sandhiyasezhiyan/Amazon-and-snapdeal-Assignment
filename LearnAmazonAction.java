package LearnActionclassAssignment;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnAmazonAction {
public static void main(String[] args) throws IOException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
   WebElement printprice =  driver.findElement(By.xpath("//span[contains(@class,'a-size-medium a-color-base')]"));
   String printprc = printprice.getText();
   System.out.println("the first displayed the product is:"+printprc);
   
   WebElement cost = driver.findElement(By.xpath("//span[@class='a-price-symbol']/following-sibling::span"));
   String costprice = cost.getText();
   System.out.println("the price of the product is" +costprice);
    
    WebElement customerrating = driver.findElement(By.xpath("//span[text()='14']"));
    String custrat=customerrating.getText();
    System.out.println("the rating of the first product" +custrat);
    
    printprice.click();
    
    //get the number of windows
    Set<String> windowhandles= driver.getWindowHandles();
    List<String> window1 = new ArrayList<String>(windowhandles);
    driver.switchTo().window(window1.get(1));
    
    File ScreenshotAs = driver.getScreenshotAs(OutputType.FILE);
    File ss = new File("./Screenshots/img3.png");
    FileUtils.copyFile(ScreenshotAs,ss);
    
    driver.findElement(By.id("add-to-cart-button")).click();
    
    WebElement subtotal = driver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price')]//span[1]"));
    String subtotal1 = subtotal.getText();
    System.out.println(subtotal1);
    String replace = subtotal1.replace(".00","");
    String priceamt = replace.trim();
    if(subtotal1.equals(priceamt)) {
    	System.out.println("verified");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       
   
}
}
