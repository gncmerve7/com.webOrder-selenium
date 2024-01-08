import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

/*
    1-) Open the URL
    2-) Click "WebOrder" button on top bar.
    3-) Enter valid username "Inar" and password "Academy".
    4-) Navigate to the view all order page.
    5-) Click "Add More Data" "6" times.
    6-) Click "Check All" button.
    7-) Verify all orders selected.
    8-) Click "Uncheck All" button.
    9-) Verify all orders are unselected.*/

public class WO_011_VAO_02Test extends Hooks {

	@Test
	void uncheckAllTabFunctionality() throws InterruptedException {

		WebElement webOrderTab = driver.findElement(By.linkText("Weborder"));
		webOrderTab.click();
		Thread.sleep(2000);

		WebElement usernameInput = driver.findElement(By.id("login-username-input"));
		usernameInput.sendKeys("Inar");
		WebElement passwordInput = driver.findElement(By.id("login-password-input"));
		passwordInput.sendKeys("Academy");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement viewAllOrdersTab = driver.findElement(By.linkText("View all orders"));
		viewAllOrdersTab.click();
		WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
		for (int i = 0; i < 6; i++) {
			addButton.click();
		}

		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);

		WebElement checkAllTab = driver.findElement(By.xpath(" //button[contains(text(),'Check All')]"));
		checkAllTab.click();

		List<WebElement> checkedboxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));
		checkAllTab.click();
		for (WebElement each : checkedboxes) {
			Assertions.assertTrue(each.isSelected());
		}
		Thread.sleep(3000);

		WebElement uncheckAllTab = driver.findElement(By.xpath(" //button[contains(text(),'Uncheck All')]"));
		uncheckAllTab.click();
		Thread.sleep(3000);


		List<WebElement> uncheckedboxes = driver.findElements(By.xpath("//input[@class='form-check-input']"));
		for (WebElement each : uncheckedboxes) {
			Assertions.assertFalse(each.isSelected());
		}
	}
}