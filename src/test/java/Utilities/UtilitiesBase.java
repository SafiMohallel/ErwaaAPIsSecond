package Utilities;

import java.io.File;
import java.util.Collections;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;

public class UtilitiesBase {
	public static void generateReport(String projectName, List<String> jsonFiles) {
		File reportOutputDirectory = new File("target");
		String buildNumber = "1";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		configuration.addClassifications("Platform", "Ubuntu");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/1.0");
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
	}
}
