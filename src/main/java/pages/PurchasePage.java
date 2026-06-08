package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PurchasePage{
WebDriver driver;
By pageHeader=By.xpath("//h2[text()='Your flight from TLV to SFO has been reserved.']");
By totalCost=By.xpath("//p[contains(text(),'Total Cost')]");
By name=By.id("inputName");
By address=By.id("address");
By city=By.id("city");
By state=By.id("state");
By zip=By.id("zipCode");
By cardType=By.id("cardType");
By cardNumber=By.id("creditCardNumber");
By month=By.id("creditCardMonth");
By year=By.id("creditCardYear");
By nameOnCard=By.id("nameOnCard");
By purchaseButton=By.xpath("//input[@value='Purchase Flight']");
public PurchasePage(WebDriver driver){
this.driver=driver;
}
public void verifyPurchasePage(){
Assert.assertTrue(driver.findElement(totalCost).isDisplayed(),"Total cost not displayed");
}
public void enterPersonalDetails(String n,String a,String c,String s,String z){
driver.findElement(name).sendKeys(n);
driver.findElement(address).sendKeys(a);
driver.findElement(city).sendKeys(c);
driver.findElement(state).sendKeys(s);
driver.findElement(zip).sendKeys(z);
}
public void enterPaymentDetails(String cn,String m,String y,String noc){
driver.findElement(cardNumber).sendKeys(cn);
driver.findElement(month).clear();
driver.findElement(month).sendKeys(m);
driver.findElement(year).clear();
driver.findElement(year).sendKeys(y);
driver.findElement(nameOnCard).sendKeys(noc);
}
public void clickPurchaseFlight(){
driver.findElement(purchaseButton).click();
}
}