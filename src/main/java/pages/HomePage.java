package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    By departure = By.name("fromPort");
    By destination = By.name("toPort");
    By findFlights = By.xpath("//input[@value='Find Flights']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDeparture(String departureCity) {
        new Select(driver.findElement(departure))
                .selectByVisibleText(departureCity);
    }

    public void selectDestination(String destinationCity) {
        new Select(driver.findElement(destination))
                .selectByVisibleText(destinationCity);
    }

    public void clickFindFlights() {
        driver.findElement(findFlights).click();
    }
}