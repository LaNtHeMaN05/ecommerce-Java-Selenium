package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport extends BaseClass {

	ExtentReports er;
	ExtentSparkReporter esr;


	public ExtentReports getReports() {
		String reportDestination = projectDirectory + "\\reports\\index.html";
		esr = new ExtentSparkReporter(reportDestination);

		esr.config().setDocumentTitle("E-commerce WebSite E2E Test");

		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("LAN", "SDET");

		return er;
	}

}
