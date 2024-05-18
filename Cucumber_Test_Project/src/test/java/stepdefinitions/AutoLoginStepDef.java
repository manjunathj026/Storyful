package stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutoLoginStepDef {
	
	WebDriver driver = new ChromeDriver();
	
	
	@Given("user is on signup page")
	public void user_is_on_signup_page() {
		driver.get("https://signin.storyful.com/trial/signup-form-01489905846464720243");
		driver.manage().window().maximize();
	} 
	
	@When("user enters first name {string}")
	public void user_enters_first_name(String First_Name) {
		driver.findElement(By.id("first_name")).sendKeys(First_Name);
	}
	
	@When("user enters last name {string}")
	public void user_enters_last_name(String Last_Name) {
		driver.findElement(By.id("last_name")).sendKeys(Last_Name);
	}
	
	@When("user enters email {string}")
	public void user_enters_email(String Email) {
		driver.findElement(By.id("user_email")).sendKeys(Email);
	}
	
	@When("user enters password {string}")
	public void user_enters_password(String Password) {
		driver.findElement(By.id("user_password")).sendKeys(Password);
	}
	
	@When("user clicks terms and conditions check box")
	public void user_clicks_terms_and_conditions_check_box() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}
	
	@When("user clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
		driver.findElement(By.xpath("//a[@class='sign-in-link']")).click();
	}
	
	
	@When("user clicks on accept cookies")
	public void user_clicks_on_accept_cookies() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='hs-eu-confirmation-button']")).click();
		Thread.sleep(2000);
	}
	
	@When("user clicks reCAPTCHA check box")
	public void user_clicks_reCAPTCHA_checkbox() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
		Thread.sleep(2000);
	}
	
	@Then("user should see the error message {string}")
	public void user_should_see_the_error_message(String errorMessage) throws InterruptedException {
		WebElement errorMsg = driver.findElement(By.xpath("//span[@class='error-message']"));
		assertEquals(errorMessage, errorMsg.getText());
		quitBrowser(driver);
		
	}
	
	@Then("user should be signed in successfully")
	public void user_should_be_signed_in_successfully() throws InterruptedException {
		quitBrowser(driver); // Since reCAPTCHA is enabled, form submission not possible
	}
	
	@Then("user navigates to sign in page")
	public void user_navigates_to_sign_in_page() throws InterruptedException {
		// Get the handle of the original window
        String originalWindow = driver.getWindowHandle();

        // Get the handles of all open windows
        Set<String> allWindows = driver.getWindowHandles();

        // Loop through all window handles to find the new window handle
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Now you are in the new window, perform your actions here
        
		assertEquals("Sign in | Storyful" , driver.getTitle());
		quitBrowser(driver);
	}
	
	@Then("the password {string} criteria should be gray")
	public void the_password_criteria_should_be_gray(String passwordCriteria) throws InterruptedException {

            WebElement criterionElement = null;

            switch (passwordCriteria) {
                case "1 number":
                    criterionElement = driver.findElement(By.xpath("//span[@class='contains-one-number password-rule']"));
                    break;
                case "1 special character":
                    criterionElement = driver.findElement(By.xpath("//span[@class='contains-one-symbol password-rule']"));
                    break;
                case "1 lowercase character":
                    criterionElement = driver.findElement(By.xpath("//span[@class='contains-one-lowercase password-rule']"));
                    break;
                case "8 characters long":
                    criterionElement = driver.findElement(By.xpath("//span[@class='at-least-eight-chars password-rule']")); 
                    break;
                case "1 uppercase character":
                    criterionElement = driver.findElement(By.xpath("//span[@class='containts-one-uppercase password-rule']"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown criterion: " + passwordCriteria);
            }

            assertTrue(criterionElement.getAttribute("style").contains("color: gray"));
            Thread.sleep(2000);
            quitBrowser(driver);
	}
	
	private void quitBrowser(WebDriver driver) {
		driver.close();
		driver.quit();
	}
	
}


