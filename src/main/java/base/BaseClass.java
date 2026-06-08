package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;

    public void setup() {

        String executionMode = System.getProperty("executionMode", "local");

        if (executionMode.equalsIgnoreCase("jenkins")) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);

        } else {

            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://blazedemo.com/");
    }

    public void takeScreenshot(String fileName) {

        try {

            File folder = new File("Screenshots");

            if (!folder.exists()) {
                folder.mkdir();
            }

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File dest =
                    new File("Screenshots/" + fileName + ".png");

            FileUtils.copyFile(src, dest);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}