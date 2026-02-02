package Baseclass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        // ✅ SAFETY: default browser
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // ✅ MANDATORY FOR JENKINS
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--remote-allow-origins=*");

            // optional but recommended
            options.addArguments("--window-size=1920,1080");

            tlDriver.set(new ChromeDriver(options));

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");

            tlDriver.set(new EdgeDriver(options));
        }

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            try {
                tlDriver.get().quit();
            } catch (Exception e) {
                System.out.println("Error quitting driver: " + e.getMessage());
            } finally {
                tlDriver.remove();
            }
        }
    }
}
