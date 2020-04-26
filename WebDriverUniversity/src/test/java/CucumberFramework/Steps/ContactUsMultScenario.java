package CucumberFramework.Steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ContactUsMultScenario extends DriverFactory {
	
	
	String parentWindowHandle;
	
	
		
	@Given("^I access webdriveruniversity1$")
	public void i_access_webdriveruniversity() throws Throwable {
		
		MasterHooks.driver.get("http://www.webdriveruniversity.com");
		
		
		 parentWindowHandle = driver.getWindowHandle();
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
	
	@And("^I enter comments using data table$")
	public void i_enter_comment(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		driver.findElement(By.name("message")).sendKeys(data.get(0).get(1)); 
		//driver.findElement(By.name("message")).sendKeys(data.get(1).get(0)); 
	}
	
	@And("^I enter comments1$")
	public void i_enter_comment() throws Throwable {
		
		driver.findElement(By.name("message")).sendKeys("Test Test Test Test Test"); 
		
	}
	@And("^I click on the submit button1$")
	public void i_click_on_the_submit_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
	}
	
	@And("^I click on the reset button$")
	public void i_click_on_the_reset_button() throws Throwable {
		driver.findElement(By.xpath("//input[@value='RESET']")).click();
		
	}
	
	@Then("^confirmation$")
	public void confirmation() throws Throwable {
		
		String alert =driver.findElement(By.id("contact_reply")).getText();
		Assert.assertEquals("Thank You for your Message!", alert);
		//driver.close();
		driver.switchTo().window(parentWindowHandle );
		
	}
	
	@Then("^invalid confirmation$")
	public void confirmation2() throws Throwable {
		
		String text = driver.findElement(By.tagName("body")).getText();
		assertEquals(text, "Error: Invalid email address");	
		//driver.close();
		driver.switchTo().window(parentWindowHandle );
		
	}
	
	@Then("^empty confirmation$")
	public void empty_confirmartion() throws Throwable {
		
	 	Assert.assertFalse("Field is not empy", 
	 			!driver.findElement(By.name("first_name")).getAttribute("value").equals("") || 
	 			!driver.findElement(By.name("last_name")).getAttribute("value").equals("") || 
	 			!driver.findElement(By.name("email")).getAttribute("value").equals("") || 
	 			!driver.findElement(By.name("message")).getAttribute("value").equals("") 
	 					);
	 	//driver.close();
		driver.switchTo().window(parentWindowHandle );
		
	 
	}
	
}
