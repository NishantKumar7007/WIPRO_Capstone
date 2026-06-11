package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FlightsPage {
    WebDriver driver;

    By flightsTable = By.xpath("//table[@class='table']");
    By chooseFlights = By.xpath("//input[@value='Choose This Flight']");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyFlightsDisplayed() {
        Assert.assertTrue(driver.findElement(flightsTable).isDisplayed(), "Flights list not displayed");
        System.out.println("Flights displayed successfully");
    }

    public void chooseFlightByIndex(int index) {
        List<WebElement> flights = driver.findElements(chooseFlights);

        if (index < 1 || index > flights.size()) {
            throw new RuntimeException("Invalid flight index: " + index);
        }

        System.out.println("Selecting Flight Index: " + index);
        flights.get(index - 1).click();
    }
}