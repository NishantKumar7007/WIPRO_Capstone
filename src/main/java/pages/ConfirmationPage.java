package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage{
WebDriver driver;
By confirmationMessage=By.xpath("//h1[text()='Thank you for your purchase today!']");
public ConfirmationPage(WebDriver driver){
this.driver=driver;
}
public void verifyBookingSuccess(){
Assert.assertTrue(driver.findElement(confirmationMessage).isDisplayed(),"Booking confirmation not displayed");
System.out.println("Flight booking completed successfully");
}
}