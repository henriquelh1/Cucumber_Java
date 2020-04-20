package CucumberFramework.Steps;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ContactUs {
	WebDriver driver;
	
	@After
	public void tearDown() {
		driver.quit();
	}
		
	@Given("^I access webdriveruniversity1$")
	public void i_access_webdriveruniversity() throws Throwable {
		System.setProperty("webdriver.chrome.driver",   "C:\\Users\\luis_marreiros\\Desktop\\Cucumber\\WebDriverUniversity\\src\\test\\java\\CucumberFramework\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.get("http://www.webdriveruniversity.com");
	}

	@When("^I click on the contact1$")
	public void i_click_on_the_login_contact_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"contact-us\"]/div/div[1]/h1")).click();
		Thread.sleep(3000);
	}

	@And("^I enter first name1$")
	public void i_enter_first_name() throws Throwable {
		@SuppressWarnings("unused")
		String winHandlerBefore = driver.getWindowHandle();

		for(String winHandler: driver.getWindowHandles()) {
			driver.switchTo().window(winHandler);
		}
		
		driver.findElement(By.name("first_name")).sendKeys("Luis");
	}

	@And("^I enter last name1$")
	public void i_enter_last_name() throws Throwable {
		driver.findElement(By.name("last_name")).sendKeys("Silva"); 
	}

	@And("^I enter an email address1$")
	public void i_enter_an_email_address() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("luis@gmail.com"); 
	}
	@And("^I enter an email address2$")
	public void i_enter_an_email_address2() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("lulw"); 
	}
	@And("^I enter comments1$")
	public void i_enter_comment() throws Throwable {
		driver.findElement(By.name("message")).sendKeys("ksnkanksnknknas"); 
	}
	@And("^I click on the submit button1$")
	public void i_click_on_the_submit_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	}
	
	@Then("^confirmation$")
	public void confirmation() throws Throwable {
		
		String alert =driver.findElement(By.id("contact_reply")).getText();
		Assert.assertEquals("Thank You for your Message!", alert);
		
	}
	@Then("^invalid confirmation$")
	public void confirmation2() throws Throwable {
		System.out.println("Pos assert aquiiiiiiiiiiiiiiii");
		String text = driver.findElement(By.tagName("body")).getText();
		System.out.println("AQUIIIIIIIIIIIIDKDNKDNKDNDNKDKNDd"+text);
		assertEquals(text, "Error: Invalid email address");
		
	}
	
}