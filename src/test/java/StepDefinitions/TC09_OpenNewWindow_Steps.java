package StepDefinitions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC09_OpenNewWindow_Steps {
	WebDriver driver;
	WebElement link ;
	ArrayList<String> list;
	int count;
	@Given("Open google search and perform a search.")
	public void open_google_search_and_perform_a_search() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");

		
	}

	@When("Open the first search link in new windows.")
	public void open_the_first_search_link_in_new_windows() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Dell",Keys.ENTER);
		link = driver.findElement(By.xpath("(//div[@class='TbwUpd NJjxre'])[1]"));
		Actions newwin=new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(2000);
		list=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		
		
	}
	

	@Then("Close the current window to move the focus back to result tab.")
	public void close_the_current_window_to_move_the_focus_back_to_result_tab() throws InterruptedException {
		driver.close();
		driver.switchTo().window(list.get(0));
		driver.quit();
	}
	
}
