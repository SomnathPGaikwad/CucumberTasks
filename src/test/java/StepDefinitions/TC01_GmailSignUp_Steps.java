package StepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC01_GmailSignUp_Steps 
{	
	
	WebDriver driver;
	
	@Given("User is on {string}")
	public void user_is_on(String URL) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
	}
	
	@When("He enters {string} in firstname field, {string} in lastname field")
	public void he_enters_in_firstname_field_in_lastname_field(String FirstName, String LastName) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
		first.sendKeys(FirstName);

		WebElement last = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='lastName']")));
		last.sendKeys(LastName);
		
	}

	@When("He enters {string} in username field")
	public void he_enters_in_username_field(String UserName) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Username']")));
		user.sendKeys(UserName);

	}

	@Then("Should enters {string} in password field")
	public void should_enters_in_password_field(String Password) 
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Passwd']")));
		password.sendKeys(Password);

		WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='ConfirmPasswd']")));
		confirm.sendKeys(Password);
		
	}

	@Then("clicks next button")
	public void clicks_next_button() 
	{
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]")));
		nextButton.click();
	
	}
	       
	@Then("Should gets output message to verify user is successfully Logged in or not")
	public void should_gets_output_message_to_verify_user_is_successfully_logged_in_or_not() 
	{
	
		List<String> value=new ArrayList<String>();
		List<WebElement> messages = driver.findElements(By.xpath("//div[@jsname='B34EJ'][normalize-space()]"));
		for(WebElement message:messages)
		{
			value.add(message.getText());
		}
		
		for(int i=0;i<value.size();i++)
		{
			System.out.println("Outcome is :"+value.get(i).replace("[^a-zA-Z]" , ""));
		}
		driver.quit();
		
	}
	
}
