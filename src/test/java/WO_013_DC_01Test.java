import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click on to "Add More Data" "1" time.
6-)Click on to rectangle button at the end.
7-)Click on to "Calculate" button.
8-)Verify to the total amount before calculation equal to the total amount after calculation.
*/

public class WO_013_DC_01Test extends Hooks {

    @Test
    void completedOrderTotalDisplayFailiure() throws InterruptedException {

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
        Thread.sleep(3000);
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add More Data')]"));
        addButton.click();
        Thread.sleep(3000);
        WebElement orderInformation = driver.findElement(By.xpath("//tbody/tr[1]/td[13]/a[1]/*[1]"));
        orderInformation.click();
        Thread.sleep(3000);


        WebElement totalDisplayedBeforeCalculation = driver.findElement(By.id("totalInput"));
        String totalBefore = totalDisplayedBeforeCalculation.getAttribute("value");
        System.out.println(totalBefore);
		Thread.sleep(3000);

        WebElement calculateButton = driver.findElement(By.xpath("//button[contains(text(),'Calculate')]"));
		calculateButton.click();
        Thread.sleep(3000);

        WebElement totalDisplayedAfterCalculation = driver.findElement(By.id("totalInput"));
        Thread.sleep(3000);
        String totalAfter =  totalDisplayedAfterCalculation.getAttribute("value"); // ***
		Assertions.assertEquals(totalAfter, totalBefore);
        Thread.sleep(3000);
    }
}
