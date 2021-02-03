package WebSchool_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox_Student_Admission {
	public String baseUrl = "https://grips.web-school.us/index.php/user/login";
    //String driverPath = "C:\\geckodriver.exe";
    public ChromeDriver driver ; 
    

  @BeforeMethod
  public void login() {
	  WebElement weUsername = driver.findElementByXPath("//*[@id=\"UserLogin_username\"]");
	  weUsername.sendKeys("admin");
	  
	  WebElement wePassword = driver.findElementById("UserLogin_password");
	  wePassword.sendKeys("admin123"); 
	  
	  weUsername.submit();

  }

  @Test(priority = 0)
  public void verifyHomepageTitle(){
      String expectedTitle = "School ERP";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
	  Reporter.log("Home page title is verified");

  }
  
  @Test(priority = 1)
  public void student_admission(){

  }
  
  @AfterMethod
  public void logout ( ) {
	  WebElement logoutDropDown = driver.findElement(By.xpath("//img[contains(@src,'/css/assets/images/placeholder.jpg')]"));
	  Assert.assertNotNull(logoutDropDown);
	  logoutDropDown.click();
	  
	  WebElement logout = driver.findElementByXPath("//*[@id=\"navbar-mobile\"]/ul[2]/li[2]/ul/li[2]/a");
	  logout.click();
}

  @BeforeTest
  public void launch_browser() {
	  System.out.println("launching browser"); 
      driver = new ChromeDriver();
      driver.get(baseUrl);
  }

  @AfterTest
  public void terminate_browser() {
	  // close browser driver
	  driver.close();
  }

}