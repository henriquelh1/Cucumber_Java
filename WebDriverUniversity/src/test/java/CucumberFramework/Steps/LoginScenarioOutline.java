package CucumberFramework.Steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class LoginScenarioOutline extends DriverFactory{
	
	String parentWindowHandle;
	
	
	
	@Given("^user navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String url) throws Throwable {
		
		driver.get(url);  //http://www.webdriveruniversity.com/
		parentWindowHandle=driver.getWindowHandle();
	}

	@When("^user clicks on the login portal button$")
	public void user_clicks_on_the_login_portal_button() throws Throwable {
		WebElement element = driver.findElement(By.id("login-portal"));  
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("arguments[0].click();",element);
	}

	@And("^user enters the \"([^\"]*)\" username$")
	public void user_enters_the_username(String username) throws Throwable {
		//tab code
		Thread.sleep(2000);
		for (String windHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windHandle);
		}
		//send username keys
		
	
		driver.findElement(By.id("text")).sendKeys(username);

	}

	@And("^user enters the \"([^\"]*)\" password$")
	public void user_enter_the_password(String password) throws Throwable {
		driver.findElement(By.id("password")).sendKeys(password);	
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("^the user should be presented with the following prompt alert \"([^\"]*)\"$")
	public void the_user_should_be_presented_with_the_following_prompt_alert(String message) throws Throwable {
		Alert alert = driver.switchTo().alert(); //Alert	
		assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""), message.toLowerCase().replaceAll("\\s", ""));
		
		driver.switchTo().alert().dismiss();
		driver.close();
		driver.switchTo().window(parentWindowHandle );
		
		
	}
}
