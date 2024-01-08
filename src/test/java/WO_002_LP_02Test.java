import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
4-) Click on the "Login" button
5-) Verify that the appropriate error message is displayed.*/

public class WO_002_LP_02Test {

	@Test
	public void loginTestWithInvalidInputs() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");

		WebElement webOrderTab = driver.findElement(By.linkText("Weborder"));
		webOrderTab.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement userNameInput = driver.findElement(By.id("login-username-input"));
		userNameInput.sendKeys("Inar");
		WebElement passwordInput = driver.findElement(By.id("login-password-input"));
		passwordInput.sendKeys("Acdmy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		WebElement usernameAlert = driver.findElement(By.id("username-error-alert"));
		Assertions.assertEquals("Invalid username", usernameAlert.getText());
		WebElement passwordAlert = driver.findElement(By.id("password-error-alert"));
		Assertions.assertEquals("Invalid password", passwordAlert.getText());

		Thread.sleep(2000);
		driver.close();
	}

}
