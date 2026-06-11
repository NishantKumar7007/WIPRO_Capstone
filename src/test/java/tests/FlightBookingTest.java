package tests;
import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utils.ExcelUtils;
import utils.ExtentReportManager;

@Listeners(TestListener.class)
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

        driver.get("https://blazedemo.com/");

        homePage = new HomePage(driver);
        flightsPage = new FlightsPage(driver);
        purchasePage = new PurchasePage(driver);
        confirmationPage = new ConfirmationPage(driver);

        extent = ExtentReportManager.getReportInstance();
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() {

        ExcelUtils.setExcelFile(
                "src/test/resources/testdata.xlsx",
                "FlightData");

        int rows = ExcelUtils.getRowCount();

        Object[][] data = new Object[rows][12];

        for (int i = 1; i <= rows; i++) {

            for (int j = 0; j < 12; j++) {

                data[i - 1][j] = ExcelUtils.getCellData(i, j);
            }
        }

        return data;
    }

    @Test(dataProvider = "excelData")
    public void verifyEndToEndFlightBooking(String departure,String destination,
                            String name,String address,String city, String state,
                            String zip,  String cardNumber, String month, String year, String nameOnCard,      
                            String flightIndexValue) {              
                                          

        test = extent.createTest(
                "Flight Booking Test - " + departure + " to " + destination);

        System.out.println("Running test for: " + departure + " to " + destination);

        int flightIndex = Integer.parseInt(flightIndexValue);

        homePage.selectDeparture(departure);

        homePage.selectDestination(destination);

        homePage.clickFindFlights();

        test.pass("Flight Search Completed");

        flightsPage.verifyFlightsDisplayed();

        test.pass("Flights List Displayed");

        flightsPage.chooseFlightByIndex(flightIndex);

        test.pass("Flight Selected");

        purchasePage.verifyPurchasePage();

        test.pass("Purchase Page Displayed");

        purchasePage.enterPersonalDetails(name,address,city,state,zip);
              
        test.pass("Personal Details Entered");

        purchasePage.enterPaymentDetails(cardNumber,month, year,nameOnCard);

        test.pass("Payment Details Entered");

        purchasePage.clickPurchaseFlight();

        test.pass("Purchase Flight Button Clicked");

        confirmationPage.verifyBookingSuccess();

        test.pass("Booking Completed Successfully");

        takeScreenshot("BookingConfirmed_" + departure + "_to_" + destination);
    }

    @AfterMethod
    public void closeApp() {

        extent.flush();

        tearDown();
    }
}