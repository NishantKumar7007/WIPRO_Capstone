package tests;
import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

public class FlightBookingTest extends BaseClass {

    HomePage homePage;
    FlightsPage flightsPage;
    PurchasePage purchasePage;
    ConfirmationPage confirmationPage;

    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void launchApp() {

        setup();

        homePage = new HomePage(driver);
        flightsPage = new FlightsPage(driver);
        purchasePage = new PurchasePage(driver);
        confirmationPage = new ConfirmationPage(driver);

        ExcelUtils.setExcelFile(
                "src/test/resources/testdata.xlsx",
                "FlightData");

        extent = ExtentReportManager.getReportInstance();

        test = extent.createTest("Flight Booking Test");
    }

    @Test
    public void verifyEndToEndFlightBooking() {

        int rows = ExcelUtils.getRowCount();

        for (int i = 1; i <= rows; i++) {

            driver.get("https://blazedemo.com/");

            test.info("Executing Row : " + i);

            String departure = ExcelUtils.getCellData(i, 0);
            String destination = ExcelUtils.getCellData(i, 1);
            String name = ExcelUtils.getCellData(i, 2);
            String address = ExcelUtils.getCellData(i, 3);
            String city = ExcelUtils.getCellData(i, 4);
            String state = ExcelUtils.getCellData(i, 5);
            String zip = ExcelUtils.getCellData(i, 6);
            String cardNumber = ExcelUtils.getCellData(i, 7);
            String month = ExcelUtils.getCellData(i, 8);
            String year = ExcelUtils.getCellData(i, 9);
            String nameOnCard = ExcelUtils.getCellData(i, 10);

            int flightIndex =
                    Integer.parseInt(
                            ExcelUtils.getCellData(i, 11));

            homePage.selectDeparture(departure);

            homePage.selectDestination(destination);

            homePage.clickFindFlights();

            test.pass("Flight Search Completed");

            flightsPage.verifyFlightsDisplayed();

            flightsPage.chooseFlightByIndex(flightIndex);

            test.pass("Flight Selected");

            purchasePage.verifyPurchasePage();

            purchasePage.enterPersonalDetails(name, address, city, state, zip);
                    
            purchasePage.enterPaymentDetails(cardNumber, month, year, nameOnCard);
                
            purchasePage.clickPurchaseFlight();

            confirmationPage.verifyBookingSuccess();

            takeScreenshot("BookingConfirmed_Row_" + i);

            test.pass(
                    "Booking Completed Successfully For Row : "
                            + i);
        }
    }

    @AfterMethod
    public void closeApp() {

        extent.flush();

        tearDown();
    }
}