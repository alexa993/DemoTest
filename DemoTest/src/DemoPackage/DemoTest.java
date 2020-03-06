package DemoPackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {
	
	private WebDriver driver;
	String url = "https://www.desmos.com/scientific";
	JavascriptExecutor js;
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\QATests\\chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMethod1() {
		driver.get(url);
		System.out.println("This is: " + driver.getTitle());
		
		
		WebElement num3 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[3]/div[7]/span"));
		num3.click();
		
		WebElement plus = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[4]/div[8]/span"));
		plus.click();
		
		num3.click();
		
		WebElement equal = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[4]/div[9]/span"));
		equal.click();
		
		WebElement calculate = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[5]/div[2]/div[1]/span[2]/span[2]"));
		String result = calculate.getText();
		
		
		Assert.assertEquals(result, "6");
			
	}
	
	
	
	@Test 
	public void testMethod2() {
		driver.navigate().to(url);
		Assert.assertEquals(driver.getTitle(),"Desmos | Scientific Calculator");
	}

	@Test
	public void testMethod3() {
		
		
		
		driver.navigate().to(url);
		//+
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[4]/div[8]/span"));
		element1.click();
		
		//-
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[3]/div[8]/span"));
		element2.click();
		
		// /
		WebElement element3 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[1]/div[8]/span"));
		element3.click();
		
		// *
		WebElement element4 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[2]/div[8]/span"));
		element4.click();
		
		
		boolean actVal1 = element1.isDisplayed();
		boolean actVal2 = element2.isDisplayed();
		boolean actVal3 = element3.isDisplayed();
		boolean actVal4 = element4.isDisplayed();
		
		
		if(actVal1) {
			System.out.println("Button + works fine!");
		}else {
			System.out.println("Button + doesn't work!");
		}
		if(actVal2) {
			System.out.println("Button - works fine!");
		}else {
			System.out.println("Button - doesn't work!");
		}
		if(actVal3) {
			System.out.println("Button / works fine!");
		}else {
			System.out.println("Button / doesn't work!");
		}
		if(actVal4) {
			System.out.println("Button * works fine!");
		}else {
			System.out.println("Button * doesn't work!");
		}
	}
		
		/*
		Assert.assertEquals(actVal1, "+");
		Assert.assertEquals(actVal2, "-");
		Assert.assertEquals(actVal3, "/");
		Assert.assertEquals(actVal4, "*" );*/
	
	
	@Test
	public void testMethod4() {
		driver.navigate().to(url);
		
		WebElement inputTag = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[4]/div/div[2]/span[1]"));
		WebElement clearAllBtn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[1]/div/div[7]"));
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[4]/div/div[2]/span[2]"));
		
		Actions build = new Actions(driver);
		Actions type = build.sendKeys(inputTag, "2222");
		type.perform();
		
		System.out.println(textArea.getText());
		
		if(clearAllBtn.isEnabled() && !textArea.getText().isEmpty()) {
			clearAllBtn.click();
			System.out.println("Clear: " + textArea.getText());
		}else {
			System.out.println("Error");
		}
	}
	
	@Test
	public void testMethod5() {
		
		driver.navigate().to(url);
		
		WebElement rad = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[1]/div/div[4]/div[1]"));
		WebElement deg = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[1]/div/div[4]/div[2]"));
		WebElement btn = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[1]/div/div[4]/div[3]"));
		btn.click();
		if(btn.isSelected()) {
			System.out.println("Rad" + rad.isDisplayed());
		}else {
			System.out.println("Deg" + deg.isDisplayed());
		}
	
	}
	
	@Test
	public void testMethod6() {
		
		driver.navigate().to(url);
		
		
		WebElement textArea = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[4]/div/div[2]/span[1]"));
		WebElement textArea1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[4]/div/div[2]/span[2]"));
		Actions build = new Actions(driver);
		Actions type = build.sendKeys(textArea, "2+2");
		type.perform();
		System.out.println(textArea1.getText());
		
		Actions type1 = build.sendKeys(textArea1, Keys.BACK_SPACE);
		Actions type2 = build.sendKeys(textArea1, Keys.BACK_SPACE);
		Actions type3 = build.sendKeys(textArea1, Keys.BACK_SPACE);
		type1.perform();
		type2.perform();
		type3.perform();
		System.out.println("Summary:" +  textArea1.getText());
		
		boolean actVal = textArea1.getText().isEmpty();
		Assert.assertTrue(actVal);
		
		
	
		
	}
	
	@Test
	public void testMethod7() {
		driver.navigate().to(url);
		
		WebElement textButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[1]/div/div[2]"));
		WebElement textArea =  driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[4]/div/div[2]/span[1]"));
		WebElement textArea1 = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div[1]/div[4]/div/div[2]/span[2]"));
		
		textButton.click();
		Actions build = new Actions(driver);
		Actions type = build.sendKeys(textArea,"Aleksa Stevovic",Keys.ENTER);
		
		type.perform();
		String text = textArea1.getText();
		System.out.println(text);
		
		
		Assert.assertEquals(text, "Aleksa Stevovic");
		
	}
	@Test
	public void testMethod8() throws InterruptedException {
		driver.navigate().to(url);
		driver.manage().window().fullscreen();
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[3]/div[2]/div/div/div[3]/div[7]/span"));

		Actions build = new Actions(driver);
		build.moveToElement(element).clickAndHold().perform();
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.close();
		driver.quit();
	}
}
