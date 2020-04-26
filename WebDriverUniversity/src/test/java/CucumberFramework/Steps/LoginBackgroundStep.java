package CucumberFramework.Steps;





import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class LoginBackgroundStep extends DriverFactory {
	
	
	String parentWindowHandle;
	
	
	@Given("^I access webdriveruniversity$")
	public void i_access_webdriveruniversity() throws Throwable {
	
			driver.get("http://www.webdriveruniversity.com");
			parentWindowHandle=driver.getWindowHandle();
	}

	@When("^I click on the login portal button$")
	public void i_click_on_the_login_portal_button() throws InterruptedException  {
		
		WebElement element = driver.findElement(By.id("login-portal"));  
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();",element);
		
	}

	@When("^I enter username$")
	public void i_enter_username() throws InterruptedException  {
		Thread.sleep(2000);
		@SuppressWarnings("unused")
		
		String winHandlerBefore = driver.getWindowHandle();
			for(String winHandler: driver.getWindowHandles()) {
				driver.switchTo().window(winHandler);
		}
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text")));
			driver.findElement(By.id("text")).sendKeys("webdriver");
	}

	@When("^I enter a \"([^\"]*)\" password$")
	public void i_enter_a_password(String password)  {
	driver.findElement(By.id("password")).sendKeys(password); 
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button()  {
	driver.findElement(By.id("login-button")).click();
	}
	
	@Then("^I should be presented wit a successful validation alert$")
	public void i_should_be_presented_wit_a_successful_validation_alert()  {
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "validation succeeded");
	driver.switchTo().alert().dismiss();
	driver.close();
	driver.switchTo().window(parentWindowHandle );
	
	}

	@Then("^I should be presented with a unsuccessful validation alert$")
	public void i_should_be_presented_wit_a_unsuccessful_validation_alert()  {
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "validation failed");
	driver.switchTo().alert().dismiss();
	driver.close();
	driver.switchTo().window(parentWindowHandle );
	
	}
	
}
