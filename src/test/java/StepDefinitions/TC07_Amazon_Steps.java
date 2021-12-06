package StepDefinitions;

import java.util.ArrayList;
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

public class TC07_Amazon_Steps
{

	WebDriver driver;
	ArrayList<String> list;

	@Given("User visits {string}")
	public void user_visits(String URL)
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("User search product as {string}")
	public void user_search_product_as(String product)
	{

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(product,Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Smartphones']")).click();

	}

	@Then("He should sort the result according to price-Low To High")
	public void he_sort_the_result_according_to_price_low_to_high() throws InterruptedException
	{
		
		Actions act=new Actions(driver);

		WebElement sort=driver.findElement(By.xpath("//select[@id='s-result-sort-select']"));
		act.click(sort).perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.xpath("//span[@class='a-icon-alt']/ancestor::div[@class='a-section a-spacing-none a-spacing-top-micro']/preceding-sibling::div//a")).click();

	}

	@Then("Should select first rating product to get star ratings of that product")
	public void should_select_first_rating_product_to_get_star_ratings_of_that_product() 
	{

		list=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));

		WebDriverWait wait=new WebDriverWait(driver, 5);
		WebElement ratings =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='averageCustomerReviews']/descendant::span[@id='acrCustomerReviewText'])[1]")));
		ratings.click();

		int rowSize = driver.findElements(By.xpath("(//table[@id='histogramTable']//tr)")).size();

		for(int i=1;i<=rowSize;i++)
		{
			int colSize = driver.findElements(By.xpath("(//table[@id='histogramTable']//tr["+i+"]/td)")).size();

			for(int j=1;j<=colSize;j++)
			{
				String text = driver.findElement(By.xpath("(//table[@id='histogramTable']//tr["+i+"]/td["+j+"])")).getText();
				System.out.print(text+" ");
			}
			System.out.println();
		}
		driver.close();
		driver.switchTo().window(list.get(0));
		driver.quit();
	}

}
