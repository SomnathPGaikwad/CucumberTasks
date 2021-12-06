package StepDefinitions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC06_Flipkart_Steps 
{
	
	WebDriver driver;
	
	@Given("User visits page {string}")
	public void user_visits_page(String URL) 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe" );
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@When("He search product {string}")
	public void he_search_product(String product) 
	{
		
				//close popup window
				driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
				//search product
				driver.findElement(By.xpath("//input[@type='text']")).sendKeys(product,Keys.ENTER);
	}

	@Then("He should print product name with highest ratings")
	public void he_should_print_product_name_with_highest_ratings() 
	{
		driver.findElement(By.xpath("(//div[@class='_3FPh42'])[3]//div[@class='_4921Z t0pPfW']")).click();
		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement productNames = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_2kHMtA']/descendant::div[@class='_4rR01T'])[3]")));
		String productName = productNames.getText();
		System.out.println("product name is:"+productName);
		
		WebElement starRatings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='_2kHMtA'])[3]//span)[3]")));
		String starRating = starRatings.getText();
		System.out.println("star rating is:"+starRating);
		
		WebElement totalRatings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='_2kHMtA'])[3]//span)[6]")));
		String totalRating = totalRatings.getText();
		System.out.println("Total rating is:"+totalRating);
		
		driver.findElement(By.xpath("(//div[@class='_2kHMtA']/descendant::div[@class='_4rR01T'])[3]")).click();
		
	}

	@Then("should click on customer review link to get star rating of that product")
	public void should_click_on_customer_review_link_to_get_star_rating_of_that_product() 
	{
		
			Set<String> ids = driver.getWindowHandles();
			ArrayList<String> al=new ArrayList<String>(ids);
			driver.switchTo().window(al.get(1));
			
			WebDriverWait wait=new WebDriverWait(driver, 5);
			WebElement reviewLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gUuXy- _16VRIQ']")));
			reviewLink.click();
			
			int rowSize = driver.findElements(By.xpath("//div[@class='_13sFCC miQW6D ']//ul")).size();
			for(int i=1;i<=rowSize;i++)
			{
				int colSize = driver.findElements(By.xpath("//div[@class='_13sFCC miQW6D ']//ul["+i+"]/li")).size();
				for(int j=1;j<=colSize;j++)
				{
					 String text = driver.findElement(By.xpath("//div[@class='_13sFCC miQW6D ']//ul["+i+"]/li["+j+"]")).getText();
					 System.out.print(text+   "      ");
				}
				System.out.println();
			}
			driver.close();
			driver.switchTo().window(al.get(0));
			driver.quit();	
	}

}
