package frontend;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Keys;

public class ActionClass {

	WebDriver driver = DriverSetup.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));

	public String[] approveOrder() {

		String[] data = new String[2];
		driver.get(Keys.approvalURL);
		login();

		try {
			data[0] = wait
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@class='Amount_amountContainer_mzWS-']/span")))
					.getText();
		} catch (Exception e) {
			e.printStackTrace();
			data[0] = "NO DATA FIND";
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='payment-submit-btn']")))
				.click();
		wait.until(ExpectedConditions.urlContains("google"));
		data[1] = driver.getCurrentUrl();
		driver.quit();
		return data;
	}

	public void login() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).clear();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Keys.persAccMail);
		driver.findElement(By.xpath("//button[@id='btnNext']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")))
				.sendKeys(Keys.persAccPass);

		driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
	}

}
