package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class TC12_Goibibo_Steps 
{

	WebDriver driver;

	@Given("User visits link as {string}")
	public void user_visits_link_as(String URL) 
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@When("He selects Origin as {string} Destination as {string}")
	public void he_selects_origin_as_destination_as(String Origin, String Destination) throws InterruptedException 
	{	

		Actions act=new Actions(driver);

		WebElement element1 =driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		act.click(element1).sendKeys(Origin).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();

	
		WebElement element2=driver.findElement(By.xpath("//input[@id='gosuggest_inputDest']"));
		act.click(element2).sendKeys(Destination).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();

	
		driver.findElement(By.xpath("//input[@id='departureCalendar']")).click();
		WebElement element3 = driver.findElement(By.xpath("//div[@id='fare_20211120']"));
		act.moveToElement(element3).click().perform();


		driver.findElement(By.xpath("//button[@value='Search']")).click();

	}

	@Then("Should be redirect to the next page to click on the most cheapest flight")
	public void should_be_redirect_to_the_next_page_to_click_on_the_most_cheapest_flight() 
	{  

		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement element4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='cheapest dF alignItemsCenter']")));
		element4.click();
		driver.findElement(By.xpath("(//button[text()='VIEW FARES'])[2]")).click();
		driver.findElement(By.xpath("//input[@value='BOOK']")).click();
		
		driver.quit();

	}
}
