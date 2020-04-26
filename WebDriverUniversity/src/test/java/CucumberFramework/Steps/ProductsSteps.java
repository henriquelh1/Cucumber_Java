package CucumberFramework.Steps;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductsSteps {
	WebDriver driver;
	String parentWindowHandle;
	
	
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws Throwable {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath()+  "\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.get(url);
			parentWindowHandle=driver.getWindowHandle();
			
	}

	@When("^user clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String locator)  throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id(locator)).click();
	   
	}

	@Then("^user should be presented with a promo alert$")
	public void user_should_be_presented_with_a_promo_alert() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Close']")).click();
		
	}
	    
	

}
