package hooks;

import Baseclass.DriverFactory;
import ResusabilityFunctions.seleniumResuable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hook {

    private static ThreadLocal<String> threadBrowser = new ThreadLocal<>();

    public static void setBrowser(String browser) {
        threadBrowser.set(browser);
    }

    @Before
    public void setUp() {

        String browser = threadBrowser.get();
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        System.out.println("Launching browser: " + browser);

        // ✅ Start browser (headless-safe)
        DriverFactory.initDriver(browser);

        // ❌ DO NOT set window position/size in headless
        // Already handled via ChromeOptions --window-size

        // ✅ Open application
        DriverFactory.getDriver().get("https://www.flipkart.com");

        // Optional: close login popup
        try {
            DriverFactory.getDriver()
                .findElement(org.openqa.selenium.By.xpath("//button[contains(text(),'✕')]"))
                .click();
        } catch (Exception e) {
            // ignore if popup not present
        }
    }

    @After
    public void cleanup(Scenario scenario) {

        if (DriverFactory.getDriver() != null) {

            // attach screenshot only on failure
            if (scenario.isFailed()) {
                new seleniumResuable(DriverFactory.getDriver())
                        .attachscreenshot(scenario);
            }

            DriverFactory.quitDriver();
        }
    }
}
