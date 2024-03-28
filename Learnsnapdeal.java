package LearnActionclassAssignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Learnsnapdeal {
public static void main(String[] args) throws IOException {
	ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.snapdeal.com/");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //Locate the element
    WebElement men = driver.findElement(By.xpath("//span[@class='catText']"));
    //instantiate Actions
    Actions builder =new Actions(driver);
    builder.moveToElement(men).perform();
    WebElement sportsshoes = driver.findElement(By.className("linkTest"));
    sportsshoes.click();
    
    WebElement countshoes = driver.findElement(By.xpath("//div[@class='category-name-wrapper clearfix ']//span"));
   String shoescount=  countshoes.getText();
   System.out.println(shoescount);
   
   WebElement trainingshoes = driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]"));
   trainingshoes.click();
   
   WebElement pricelowtohigh = driver.findElement(By.className("sort-selected"));
   builder.moveToElement(pricelowtohigh).click().perform();
   String option ="Price Low To High";
   WebElement customoption = driver.findElement(By.xpath("(//li[@data-index='1'])[2]"));
   customoption.click();
   
   
   List<WebElement> price = driver.findElements(By.xpath("(//div[@class='lfloat marR10']//span)[2]"));
   List<Integer> pricelist = new ArrayList<Integer>();
   for(WebElement each:price) {
	   String s = each.getText();
	   String s1 = s.replaceAll("[^0-9]", "");
	   int s2 = Integer.parseInt(s1);
	   pricelist.add(s2);
   }
   System.out.println(pricelist);
   
   int count=0;
   for(int i=0;i<pricelist.size()-1;i++) {
	   if(pricelist.get(i)>pricelist.get(i+1)) {
		   System.out.println("the prices are not sortedin order");
		   count++;
		   break;
	   }
   }
   if(count==0) 
	   System.out.println("the prices are in sorted order");
 //enter price values
 		WebElement web1 = driver.findElement(By.xpath("//div[@class='price-text-box']"));
 		builder.scrollToElement(web1).perform();
 		
 		driver.findElement(By.xpath("//input[@name='fromVal']")).clear();
 		driver.findElement(By.xpath("//input[@name='fromVal']")).sendKeys("600");
 		
 		driver.findElement(By.xpath("//input[@name='toVal']")).clear();
 		driver.findElement(By.xpath("//input[@name='toVal']")).sendKeys("800");
 		
 		//click go
 		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
 		
 		//move to element colour
 		WebElement web4 = driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[1]"));
 		builder.scrollToElement(web4).perform();
 		
 		//choose colour 
 		WebElement ele6 = driver.findElement(By.xpath("(//div[@class='sdCheckbox filters-list '])[1]"));
 		builder.scrollToElement(ele6).click(ele6).perform();
 		
 		
 		//display filters
 		String filter1 = driver.findElement(By.xpath("(//div[@class='navFiltersPill'])[1]")).getText();
 		String filter2 = driver.findElement(By.xpath("(//div[@class='navFiltersPill'])[2]")).getText();
 		System.out.println("Filter1: " + filter1);
 		System.out.println("Filter2: " + filter2);
 		
 		//verify filters
 		if(filter1.contains("Price") && (filter2.contains("Black")))
 			System.out.println("Apllied filters price and colour are verified");
 		
 		//hover mouse on image
 		WebElement ele7 = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
 		builder.moveToElement(ele7).perform();
 		
 		//click quick view
 		driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
 		
 		//Set<String> windowSet = driver.getWindowHandles();
 		//List<String> windowList = new ArrayList<String>(windowSet);
 		//driver.switchTo().window(windowList.get(1));
 			
 		//display shoe price and discount
 		String shoePrice = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
 		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
 		
 		System.out.println("Shoe Price: " + shoePrice + "Discount: " + discount);
 		
 		//snapshot
 		WebElement webe1 = driver.findElement(By.xpath("(//img[@class='cloudzoom'])[1]"));
 		File source = webe1.getScreenshotAs(OutputType.FILE);
 		File destination = new File("./priyaScreenshots/shoePic2.png");
 		FileUtils.copyFile(source, destination);
 		
   
   

   


   
   
   
	   
   
  
   
  
   
    
}
}
