import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "ScreenSaver" from Product dropdown.
6-) Leave blank the quantity box.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify the invalid Quantity error message is displayed.*/

public class WO_005_CF_02Test extends Hooks {

	@Test
	void calculationFunctionalityTestWithInvalidInput() throws InterruptedException {

		WebElement webOrderTab = driver.findElement(By.linkText("Weborder"));
		webOrderTab.click();
		Thread.sleep(2000);

		WebElement usernameInput = driver.findElement(By.id("login-username-input"));
		usernameInput.sendKeys("Inar");
		WebElement passwordInput = driver.findElement(By.id("login-password-input"));
		passwordInput.sendKeys("Academy");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement orderTab = driver.findElement(By.linkText("Order"));
		Thread.sleep(2000);
		orderTab.click();

		WebElement selectProduct = driver.findElement(By.id("productSelect"));
		Select homeProduct = new Select(selectProduct);
		homeProduct.selectByVisibleText("ScreenSaver");

		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys(" ");
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys("20");

		WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
		calculateButton.click();
		Thread.sleep(3000);
		WebElement invalidInputAlert = driver.findElement(By.id("quantityValidateError"));

		Assertions.assertEquals("Field 'Quantity' must be greater than zero.", invalidInputAlert.getText());
	}

}