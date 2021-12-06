package TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import PageObjects.Reporting;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "C:\\Users\\Somnath.Gaikwad\\eclipse-workspace\\CucumberTask\\src\\test\\resource\\FeatureFiles",                          	
glue= {"StepDefinitions"},
tags="@tag13",
monochrome=true,
plugin="json:target/Cucumber.json")


public class MyTestRunner extends AbstractTestNGCucumberTests
{

	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

	@AfterSuite
	public void generateReport() 
	{
		Reporting.generateJVMReport();
	}

}
