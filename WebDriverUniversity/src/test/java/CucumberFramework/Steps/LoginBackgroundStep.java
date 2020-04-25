package CucumberFramework.Steps;


import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginBackgroundStep {
	
	WebDriver driver;
	String parentWindowHandle;
	
	
	@Given("^I access webdriveruniversity$")
	public void i_access_webdriveruniversity() throws Throwable {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath()+  "\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.get("http://www.webdriveruniversity.com");
			parentWindowHandle=driver.getWindowHandle();
	}

	@When("^I click on the login portal button$")
	public void i_click_on_the_login_portal_button() throws Throwable {
		
		driver.findElement(By.id("login-portal")).click();
	}

	@When("^I enter username$")
	public void i_enter_username() throws Throwable {
		@SuppressWarnings("unused")
		String winHandlerBefore = driver.getWindowHandle();

			for(String winHandler: driver.getWindowHandles()) {
				driver.switchTo().window(winHandler);
			}
		driver.findElement(By.id("text")).sendKeys("webdriver");
	}

	@When("^I enter a \"([^\"]*)\" password$")
	public void i_enter_a_password(String password) throws Throwable {
	driver.findElement(By.id("password")).sendKeys(password); 
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
	driver.findElement(By.id("login-button")).click();
	}
	
	@Then("^I should be presented wit a successful validation alert$")
	public void i_should_be_presented_wit_a_successful_validation_alert() throws Throwable {
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "validation succeeded");
	driver.switchTo().alert().dismiss();
	driver.close();
	driver.switchTo().window(parentWindowHandle );
	driver.close();
	
	}

	@Then("^I should be presented with a unsuccessful validation alert$")
	public void i_should_be_presented_wit_a_unsuccessful_validation_alert() throws Throwable {
	Alert alert = driver.switchTo().alert();
	Assert.assertEquals(alert.getText(), "validation failed");
	driver.switchTo().alert().dismiss();
	driver.close();
	driver.switchTo().window(parentWindowHandle );
	driver.close();
	}
	
}
