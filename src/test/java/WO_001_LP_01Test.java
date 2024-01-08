import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter "Inar" as username and "Academy" password.
4-) Click on the "Login" button.
5-) Verify that the user is successfully logged in.*/

public class WO_001_LP_01Test extends Hooks {

	@Test
	void loginTestWithValidInputs() throws InterruptedException {

		WebElement webOrderTab = driver.findElement(By.linkText("Weborder"));
		webOrderTab.click();

		WebElement userNameInput = driver.findElement(By.id("login-username-input"));
		userNameInput.sendKeys("Inar");

		WebElement passwordInput = driver.findElement(By.id("login-password-input"));
		passwordInput.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement headingMessage = driver.findElement(By.id("welcome-heading"));
		String headingText = headingMessage.getText();

		Assertions.assertEquals("Welcome, Inar!", headingText);
		Thread.sleep(2000);

	}

}
