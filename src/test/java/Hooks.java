import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {

	protected static WebDriver driver;

	@BeforeAll
	public static void setUpBeforeTest() {

		String browser = System.getProperty("browserType", "chrome");

		switch (browser.toLowerCase()) {
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "chrome":
			default:
				driver = new ChromeDriver();
				break;
		}
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		if (browser.equalsIgnoreCase("firefox")) {
			driver.navigate().refresh();
		}
	}

	@AfterAll
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
