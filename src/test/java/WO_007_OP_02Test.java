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
5-) Select "FamilyAlbum" from Product dropdown.
6-) Enter "3" as quantity number.
7-) Enter "17" as discount percentage.
8-) Enter "Inar Academy" as Name.
9-) Enter "1100 Congress Ave" as Street.
10-) Enter "Austin" as City.
11-) Enter "TX" State.
12-) Enter "78701" as Zip Code(number).
13-) Select "Mastercard" as Card Type.
14-) Enter "5162738261027163" as Card Number.
15-) Enter "11/28" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the invalid Product Information error message is displayed. */

public class WO_007_OP_02Test extends Hooks {

	@Test
	void orderPlacementTestWithoutCalculation() throws InterruptedException {

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
		homeProduct.selectByIndex(1);
		WebElement quantityBox = driver.findElement(By.id("quantityInput"));
		quantityBox.sendKeys("3");
		WebElement discountBox = driver.findElement(By.id("discountInput"));
		discountBox.sendKeys("17");
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
		zipBox.sendKeys("78701");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(1000);

		WebElement selectCardType = driver.findElement(By.id("mastercard"));
		selectCardType.click();
		WebElement cardNumBox = driver.findElement(By.id("cardNumber"));
		cardNumBox.sendKeys("5162738261027163");
		WebElement expireDateBox = driver.findElement(By.id("expiryDate"));
		expireDateBox.sendKeys("11/28");
		WebElement processButton = driver.findElement(By.xpath("//button[contains(text(),'Process')]"));
		processButton.click();

		Thread.sleep(4000);
		js.executeScript("window.scroll(0,-1000)");
		Thread.sleep(4000);
		WebElement displayedMessage = driver
			.findElement(By.xpath("//em[contains(text(),'Fix errors in Product Information')]"));//
		// Assertions.assertEquals("Fix errors in Product Information",
		// displayedMessage.toString());
		Assertions.assertEquals("Fix errors in Product Information", displayedMessage.getText());

	}

}
