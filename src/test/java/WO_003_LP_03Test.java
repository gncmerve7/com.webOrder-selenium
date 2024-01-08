import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Click "Logout" button.
5-) Verify logout successfully.*/

public class WO_003_LP_03Test extends Hooks {

	@Test
	void logoutFunctionalityTest() throws InterruptedException {

		WebElement webOrderTab = driver.findElement(By.linkText("Weborder"));
		webOrderTab.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		Thread.sleep(3000);
		WebElement usernameInput = driver.findElement(By.id("login-username-input"));
		usernameInput.sendKeys("Inar");
		WebElement passwordInput = driver.findElement(By.id("login-password-input"));
		passwordInput.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

		WebElement logoutButton = driver.findElement(By.id("logout-button"));
		Thread.sleep(4000);
		logoutButton.click();
		Thread.sleep(4000);

		String currentUrl = driver.getCurrentUrl();
		Assertions.assertEquals("https://InarAcademy:Fk160621.@test.inar-academy.com/weborder", currentUrl);
	}

}
