package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import stepDefination.PageObjects;

public class loginTest {

	public static WebDriver driver;
	PageObjects po;

	@Given("^Navigate to Home page$")
	public void Homepage() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		po = new PageObjects(driver);
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@When("^user enters username and password$")
	public void pwd() {
		po.signin.click();
		po.username.sendKeys("lalitha");
		po.password.sendKeys("Password123");
		po.login.click();
	}

	@Then("^user logged in successfully$")
	public void loginsucessfully() {
		System.out.println("user login successfully");
	}

	@When("Larry searches below products in the search box:")
	public void larry_searches_below_products_in_the_search_box(DataTable datatable) {
		List<String> product = datatable.asList(String.class);
		// throw new cucumber.api.PendingException();
		for (String s : product) {
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		}

	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void entersunamepwd(String uname, String pwd) {
		po.signin.click();
		po.username.sendKeys(uname);
		po.password.sendKeys(pwd);
		po.login.click();
	}

	@Then("product should be added in the cart if available")
	public void product_should_be_added_if_available_in_TestMeApp() {

	}
}
