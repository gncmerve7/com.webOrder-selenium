import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/*
    1-) Open the URL
    2-) Click "WebOrder" button on top bar.
    3-) Enter valid username "Inar" and password "Academy".
    4-) Navigate to the view all order page.
    5-) Click "Add More Data" "8" times.
    6-) Click 1st, 3rd and 5th orders checkbox's.
    7-) Click "Delete All" button.
    8-) Verify the orders are deleted.*/

public class WO_012_VAO_03Test extends Hooks {

	@Test
	void deleteAllTabFunctionality() throws InterruptedException {

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
		for (int i = 0; i < 8; i++) {
			addButton.click();
		}
		Thread.sleep(3000);

		WebElement checkFirstTab = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/input[1]"));
		checkFirstTab.click();
		Thread.sleep(5000);

		WebElement checkThirdTab = driver.findElement(By.xpath("//tbody/tr[3]/td[1]/div[1]/input[1]"));
		checkThirdTab.click();
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);

		WebElement checkFifthTab = driver.findElement(By.xpath("//tbody/tr[5]/td[1]/div[1]/input[1]"));
		checkFifthTab.click();
		Thread.sleep(5000);

		WebElement deleteTab = driver.findElement(By.xpath(" //button[contains(text(),'Delete')]"));
		deleteTab.click();
		Thread.sleep(5000);

		// List<WebElement> checkedBox =
		// driver.findElements(By.xpath("//input[@class='form-check-input'][1]"));
		// Thread.sleep(3000);

	}

}
