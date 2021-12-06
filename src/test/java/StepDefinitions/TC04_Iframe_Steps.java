package StepDefinitions;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC04_Iframe_Steps 
{
	
	WebDriver driver;

	@Given("User is redirect on given URL as {string}")
	public void user_is_redirect_on_given_url_as(String URL) 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
	}

	@When("He should switch to text area to get text")
	public void he_should_switch_to_text_area_to_get_text() throws InterruptedException 
	{
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);

	}

	@Then("Should be get text of first line")
	public void should_be_get_text_of_first_line() throws TimeoutException, InterruptedException 
	{

		WebElement firstLineText =driver.findElement(By.xpath("//h2[text()='My First JavaScript']"));
		System.out.println(firstLineText.getText());
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.switchTo().defaultContent();
		driver.quit();

	}


}

