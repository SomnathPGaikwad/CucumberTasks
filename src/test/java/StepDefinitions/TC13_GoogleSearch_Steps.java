package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC13_GoogleSearch_Steps 
{

	WebDriver driver;

	@Given("User is on google search Page")
	public void user_is_on_google_search_page() 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

	}

	@When("He searches for text as {string}")
	public void he_searches_for_text_as(String text) 
	{

		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(text,Keys.ENTER);

	}

	@Then("He should be verify title of result page") 
	public void he_should_be_verify_title_of_result_page() 
	{		

		String actTitle = driver.getTitle();
		String expTitle = "Title Of Page";
		driver.quit();
		Assert.assertEquals(actTitle, expTitle);
		
	}

}
