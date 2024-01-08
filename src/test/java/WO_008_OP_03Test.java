import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "MyMoney" from Product dropdown.
6-) Enter "8" as quantity number.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "92@#83" as Zip Code.
14-) Select "American Express" as Card Type.
15-) Enter "342738261027163" as Card Number.
16-) Enter "01/28" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the invalid Zip Code error message is displayed.*/

public class WO_008_OP_03Test extends Hooks {

	@Test
	void orderPlacementTestWithInvalidZipCode() throws InterruptedException {

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
		homeProduct.selectByVisibleText("MyMoney");
		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys("8");
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys("20");
		WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
		calculateButton.click();
		Thread.sleep(3000);

		WebElement nameBox = driver.findElement(By.xpath("//input[@placeholder='Enter your name']"));
		nameBox.sendKeys("Inar Academy");
		WebElement streetBox = driver.findElement(By.id("street"));
		streetBox.sendKeys("1100 Congress Ave");
		WebElement cityBox = driver.findElement(By.id("city"));
		cityBox.sendKeys("Austin");
		WebElement stateBox = driver.findElement(By.id("state"));
		stateBox.sendKeys("TX");
		WebElement zipBox = driver.findElement(By.id("zip"));
		zipBox.sendKeys("92@#83");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);

		WebElement selectCardType = driver.findElement(By.id("amex"));
		selectCardType.click();
		WebElement cardNumBox = driver.findElement(By.id("cardNumber"));
		cardNumBox.sendKeys("342738261027163");
		WebElement expireDateBox = driver.findElement(By.id("expiryDate"));
		expireDateBox.sendKeys("11/28");
		WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
		processButton.click();

		Thread.sleep(4000);
		WebElement displayedMessage = driver.findElement(By.xpath("//div[@role='alert']"));
		Assertions.assertEquals("Invalid zip code!.", displayedMessage.getText());

	}

}
