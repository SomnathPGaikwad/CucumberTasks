package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC05_VerifySnapdealProduct_Steps 
{

	WebDriver driver;
	int range;

	@Given("User visits {string} to search for {string}")
	public void user_visits_to_search_for(String URL, String product) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id='inputValEnter']")).sendKeys(product);
		driver.findElement(By.xpath("//span[@class='searchTextSpan']")).click();
		
	}


	

	@When("He should change the slider between 1K to 5K to check products")
	public void he_should_change_the_slider_between_1k_to_5k_to_check_products() throws InterruptedException 
	{

		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement inp1 = driver.findElement(By.xpath("//input[@name='fromVal']"));
		inp1.clear();
		inp1.sendKeys("1000");

		WebElement slider1 = driver.findElement(By.xpath("(//div[@class='filter-inner']//descendant::a)[1]"));
		js.executeScript("arguments[0].setAttribute('style','left: 16.4116%;')", slider1);
		Thread.sleep(2000);

		WebElement inp2 = driver.findElement(By.xpath("//input[@name='toVal']"));
		inp2.clear();
		inp2.sendKeys("5000");

		WebElement slider2 = driver.findElement(By.xpath("(//div[@class='filter-inner']//descendant::a)[2]"));
		js.executeScript("arguments[0].setAttribute('style','left: 90.1715%;')", slider2);

		driver.findElement(By.xpath("//div[contains(@class,'price-go')]")).click();
		Thread.sleep(2000);
	
		List<WebElement> prices =driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for(WebElement price:prices)
		{
		String value = price.getText().replaceAll("[^0-9]", "");
		range=Integer.parseInt(value);
		}
		
	}


	@Then("Should be verify that product falls between the range") 
	public void should_be_verify_that_product_falls_between_the_range() 

	{
		
		if(1000 <= range && range <= 5000)
		{
			System.out.println("product is fall between range");
		}
		else
		{
			System.out.println("product is not fall between range");
		}
		driver.quit();
		
	}	
}
