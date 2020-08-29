package com.egov.base;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.cucumber.CucumberRunner;
import com.intuit.karate.cucumber.KarateStats;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@KarateOptions(features = "classpath:com/user/demo", tags = { "@user-delete" })
public class KarateTest {

	@BeforeClass
	public static void before() {

	}

	@Test
	public void testParallel() {
		// System.setProperty("karate.env", "qa");
		// System.setProperty("locale", "pb");
		String karateOutputPath = "target/surefire-reports";
		KarateStats stats = CucumberRunner.parallel(getClass(), 1, karateOutputPath);
		generateReport(karateOutputPath);
		assertTrue("there are scenario failures", stats.getFailCount() == 0);
	}

	private static void generateReport(String karateOutputPath) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date);

		Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] { "json" }, true);
		List<String> jsonPaths = new ArrayList(jsonFiles.size());
		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		Configuration config = new Configuration(new File("target/" + currentDate), "Functional Test");
		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
		reportBuilder.generateReports();
	}

	public static String converToString(String conValue) {
		return conValue.replaceAll("\"", "");
	}
}