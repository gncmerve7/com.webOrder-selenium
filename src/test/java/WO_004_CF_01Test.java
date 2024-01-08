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
5-) Select "HomeDecor" from Product dropdown.
6-) Enter "5" as quantity number.
7-) Enter "15" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify that the total amount is successfully displayed.*/

public class WO_004_CF_01Test extends Hooks {

	@Test
	void calculationFunctionalityTest() throws InterruptedException {

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
		homeProduct.selectByVisibleText("HomeDecor");

		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys("5");
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys("15");

		WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
		calculateButton.click();
		Thread.sleep(3000);
		WebElement totalBox = driver.findElement(By.id("totalInput"));

		Assertions.assertEquals("637.5", totalBox.getText());
	}

}
