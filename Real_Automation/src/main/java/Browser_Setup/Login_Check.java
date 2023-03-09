package Browser_Setup;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Check {
	
	
	
  public WebDriver driver;
  public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static File Conf;
	public static ExtentTest Test;
   
	@Given("Move to saucedemo login page")
	public void move_to_saucedemo_login_page() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		String getloginurl= driver.getCurrentUrl();
		String LoginActUrl= "https://www.saucedemo.com/";
		
		getloginurl.equals(LoginActUrl);
		
	}
	@When("enter login credentials")
	public void enter_login_credentials(DataTable arg1) {
		List<Map<String,String>>kayval=arg1.asMaps(String.class,String.class);
		
		
        String Username= kayval.get(0).get("Username");
        String Password=kayval.get(0).get("Password");
        
        System.out.println(Username+","+Password);
		driver.findElement(By.id("user-name")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("login-button")).click();
		
		
		
	}
	@Then("click login button ensure page mooved to dashboard")
	public void click_login_button_ensure_page_mooved_to_dashboard() {
		   System.out.println("Final");
		   
		 //Verify Url
			String Assurl ="https://www.saucedemo.com/inventory.html";
			String URL=driver.getCurrentUrl();
			Assurl.equalsIgnoreCase(URL);
	}

}
