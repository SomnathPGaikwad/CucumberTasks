package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC11_ExcellSheet_Steps 
{

	String fileName;
	HSSFWorkbook workbook;
	HSSFSheet sheet;

	@Given("User create ExcellSheet")
	public void user_create_excell_sheet() throws IOException
	{

		try
		{
			fileName="D:\\Data.xls";
			workbook=new HSSFWorkbook();
			sheet=workbook.createSheet("Sheet1");
			HSSFRow rowhead=sheet.createRow((short)0);
			rowhead.createCell(0).setCellValue("URL");
			rowhead.createCell(1).setCellValue("BrowserValue");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@When("He write URL and BrowserValue into the ExcellSheet")
	public void he_write_url_and_browser_value_into_the_excell_sheet() throws IOException 
	{

		try
		{
			HSSFRow row=sheet.createRow((short)1);
			row.createCell(0).setCellValue("https://www.Amazon.com/");
			row.createCell(1).setCellValue("chrome");
			FileOutputStream fileOut=new FileOutputStream(fileName);
			workbook.write(fileOut);
			workbook.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	Sheet sheet1;
	WebDriver driver;

	@Then("Should read URL from ExcellSheet to open the given URL into the Browser")
	public void should_read_url_from_excell_sheet_to_open_the_given_url_into_the_browser() throws Exception
	{

		FileInputStream file=new FileInputStream("D:\\Data.xls");
		sheet1 = WorkbookFactory.create(file).getSheet("Sheet1");
		String URL = sheet1.getRow(1).getCell(0).getStringCellValue();

		String browser = sheet1.getRow(1).getCell(1).getStringCellValue();
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			throw new Exception("Incorrect Browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		driver.quit();

	}

}
