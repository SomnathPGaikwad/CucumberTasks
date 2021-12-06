package StepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC03_VerifySnapdealCategories_Steps 
{
	
	WebDriver driver;
	List<String> categories;
	List<String> list;
	
	@Given("User visits to {string}")
	public void user_visits_to(String URL)
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}

	@When("He store all the categories of product")
	public void he_store_all_the_categories_of_product() 
	{
		
		driver.findElement(By.xpath("(//div[@id='leftNavMenuRevamp']/descendant::li)[15]")).click();	
		List<WebElement> category = driver.findElements(By.xpath("//div[@id='SMWrapr']//descendant::div[@id]"));
		categories=new ArrayList<String>();
		for(WebElement e:category)
		{
			categories.add(e.getText().replaceAll("[View More > View All +]", ""));
		
		}
//		System.out.println("all categories are:"+categories);
		
	}

	@Then("He should navigate to some different page in snapdeal")
	public void he_should_navigate_to_some_different_page_in_snapdeal()
	{
		
		driver.findElement(By.xpath("//div[@class='SmBox1']//descendant::li[3]")).click();
		
		List<WebElement> electronic = driver.findElements(By.xpath("//div[@id='SMTVTab']"));
		list=new ArrayList<String>();
		
		for(WebElement e1:electronic)
		{
			list.add(e1.getText().replaceAll("[View All +]", ""));
		}
//		System.out.println("particular category is:"+list);
	
	}
	
	@Then("Should be verify that the list of categories did not change")
	public void should_be_verify_that_the_list_of_categories_did_not_change() 
	{
		
		if(categories.containsAll(list))
		{
			System.out.println("list of categories did not change");
		}
		else
		{
			System.out.println("list of categories are change");
		}
		driver.quit();
		
	}
}
