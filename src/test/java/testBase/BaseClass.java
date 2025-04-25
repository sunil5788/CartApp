package testBase;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Properties pr;

	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws Exception {

		// Loding the file
		FileReader file = new FileReader(
				"C:/Users/supritha sunil/eclipse-workspace/CartApp/src/test/resources/config.properties");
		pr = new Properties();
		pr.load(file);

		// Seleium Grid
		if (pr.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilites = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				capabilites.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilites.setPlatform(Platform.MAC);
			} else {
				System.out.println("No Operating system found");
				return;
			}

			switch (br.toLowerCase()) {
			case "chrome":
				capabilites.setBrowserName("chrome");
				break;
			case "edge":
				capabilites.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilites);

		}

		if (pr.getProperty("execution_env").equalsIgnoreCase("local")) {

			switch (br.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid Browser Name");
				return;
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(pr.getProperty("appURL"));
	}

	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void tearDown() {
		driver.quit();
	}

	public String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;

	}

	public String randomNumber() {
		String genaratedNumber = RandomStringUtils.randomNumeric(10);
		return genaratedNumber;
	}

	public String randomPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String genaratedNumber = RandomStringUtils.randomNumeric(10);
		return generatedString + "$" + genaratedNumber;

	}

	public String captureScreen(String tname) throws Exception {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourefile = screenshot.getScreenshotAs(OutputType.FILE);

		String targetfilePath = System.getProperty("user.dir") + "\\screenshots" + tname + timeStamp + ".png";
		File targetfile = new File(targetfilePath);

		sourefile.renameTo(targetfile);

		return targetfilePath;

	}

}
