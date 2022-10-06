package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;
	public String testURL;
	public String wrong_id;
	public String correct_id;
	public String pswd;
	public String projectDirectory = System.getProperty("user.dir");

	public WebDriver webDriverStart() throws IOException {
		fis = new FileInputStream(projectDirectory + "\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		testURL = prop.getProperty("url");
		wrong_id = prop.getProperty("wrongid");
		correct_id = prop.getProperty("correctid");
		pswd = prop.getProperty("pswd");
		driver = WebDriverManager.chromedriver().create();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.manage().window().maximize();

		return driver;
	}

	public String getScreenshot(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = projectDirectory + "\\reports\\" + methodName + ".png";
		FileUtils.copyFile(source, new File(dest));
		return dest;

	}

}
