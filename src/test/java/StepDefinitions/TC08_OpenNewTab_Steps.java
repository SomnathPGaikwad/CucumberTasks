package StepDefinitions;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC08_OpenNewTab_Steps 
{	
	
	WebDriver driver;
	WebElement link;
	ArrayList<String> tabs;
	
	@Given("User initialise browser to search link as {string}")
	public void user_initialise_browser_to_search_link_as(String URL) 
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

	}
	
	@When("He search product as {string}")
	public void he_search_product_as(String product) throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(product,Keys.ENTER);
	    link = driver.findElement(By.xpath("(//div[@class='TbwUpd NJjxre']/ancestor::a)[1]"));
	    
	}
	
	@Then("Result link open in new tab")
	public void result_link_open_in_new_tab() throws InterruptedException 
	{
		
		String keyString = Keys.CONTROL+Keys.SHIFT.toString()+Keys.ENTER.toString();
		link.sendKeys(keyString);
		Set<String> allWindows = driver.getWindowHandles();
		tabs=new ArrayList<String>(allWindows);
		
	}

	@And("Should close current tab to move the focus back to result tab.")
	public void should_close_current_tab_to_move_the_focus_back_to_result_tab() throws InterruptedException
	{
		
		driver.switchTo().window(tabs.get(1));
		
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		driver.quit();
		
	}
}
