package StepDefinitions;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.Utility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC02_PostImage_Steps 
{

	String RemoteWebElement;
	WebDriver driver;

	@Given("User visits link {string}")
	public void user_visits_link(String URL) 
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Postimages — free image hosting / image upload";
		if(actualTitle.equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Title of given page is Matched");
		}
		else
		{
			System.out.println("Title didn't match");
		}

	}

	@When("He should upload a photo \\(browse photo, select type of image content, click upload it! button)")
	public void he_should_upload_a_photo_browse_photo_select_type_of_image_content_click_upload_it_button() throws Exception 
	{

		WebElement dest= driver.findElement(By.xpath("//span[@id='uploadFile']"));
		Utility.DropFile(new File("C:\\Users\\Somnath.Gaikwad\\Desktop\\passportsize.jpeg"),dest,0,0);

	}

	@Then("Should be verify image has uploaded successfully")
	public void should_be_verify_image_has_uploaded_successfully() 
	{

		driver.findElement(By.xpath("//div[@class='thumb']/a")).click();
		WebElement ImageFile = driver.findElement(By.xpath("//img[@id='main-image']"));
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		if (!ImagePresent)
		{
			System.out.println("Image not displayed.");
		}
		else
		{
			System.out.println("Image displayed.");
		}
		driver.quit();
	}

}
