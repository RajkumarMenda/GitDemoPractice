package rajtechlearning.ExtentReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {

	ExtentReports extent;

	@BeforeTest
	public void config() {
		// ExtentReports and ExtentSparkReporter -> Main classes
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results"); // Report Name
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rajkmar"); // TesterName
	}

	@Test
	public void initialDemo() {

		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();
		test.fail("Result do not match");

		extent.flush(); // To Say the Test is Done to generate the report
	}
}
