package CucumberFramework.Steps;

import static org.junit.Assert.assertEquals;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginScenarioOutline {
	WebDriver driver;
	String parentWindowHandle;
	
	@Given("^user navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String url) throws Throwable {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath()+  "\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get(url);  //http://www.webdriveruniversity.com/
		parentWindowHandle=driver.getWindowHandle();
	}

	@When("^user clicks on the login portal button$")
	public void user_clicks_on_the_login_portal_button() throws Throwable {
		
		driver.findElement(By.id("login-portal")).click();
	}

	@And("^user enters the \"([^\"]*)\" username$")
	public void user_enters_the_username(String username) throws Throwable {
		//tab code
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
		driver.close();
		
	}
}