package StepDefinitions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC10_ExcellFile_Steps 
{	
	
	String fileName;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	
	@Given("User create ExcellFile")
	public void user_create_excell_file() 
	{
		try
		{
		fileName="D:\\Data1.xls";
		workbook=new HSSFWorkbook();
		sheet=workbook.createSheet("Sheet2");
		HSSFRow rowhead=sheet.createRow((short)0);
		rowhead.createCell(0).setCellValue("Name");
		rowhead.createCell(1).setCellValue("EmailID");
		rowhead.createCell(2).setCellValue("MobileNo");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@When("He enter credentials into the ExcellFile")
	public void he_enter_credentials_into_the_excell_file() 
	{
		
		try
		{
		HSSFRow row=sheet.createRow((short)1);
		row.createCell(0).setCellValue("Somnath Gaikwad");
		row.createCell(1).setCellValue("somnath123@gmail.com");
		row.createCell(2).setCellValue("1234567890");
		FileOutputStream fileOut=new FileOutputStream(fileName);
		workbook.write(fileOut);
		workbook.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	Sheet sheet2;
	@Then("Should read credentials from ExcellFile to see the result in console")
	public void should_read_credentials_from_excell_file_to_see_the_result_in_console() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file=new FileInputStream("D:\\Data1.xls");
		sheet2= WorkbookFactory.create(file).getSheet("Sheet2");
		String Name = sheet2.getRow(1).getCell(0).getStringCellValue();
		String EmailID = sheet2.getRow(1).getCell(1).getStringCellValue();
		String MobileNo = sheet2.getRow(1).getCell(2).getStringCellValue();
		System.out.println("Name is:"+Name);
		System.out.println("EmailId is:"+EmailID);
		System.out.println("MobileNo is:"+MobileNo);
		
	}
}
