package PageObjects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting 
{
	public static void generateJVMReport() 
	{
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/Cucumber.json");
		String projectName = "CucumberTask";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		ReportBuilder reportBuilder=new ReportBuilder(jsonFiles,configuration);
		reportBuilder.generateReports();
	}
}
