package ResusabilityFunctions;

import java.io.File;
import java.util.List;
import java.util.Set;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Scenario;

public class seleniumResuable  {
    
	private WebDriver driver;
	private Actions act;

	public seleniumResuable() {
		this.driver = Baseclass.DriverFactory.getDriver();
	}
	public seleniumResuable(WebDriver driver) {
		this.driver =driver;
	}

	public void entervalue(WebElement element, String text) {
		try {
			element.sendKeys(text);
			//logger.info("**************** Enter Value *****************");

		} catch (Exception e) {
			System.out.println("No such Element exception");

		}
	}

	public void Click(WebElement element) {
		try {
			element.click();
			//logger.info("***************** Clicked button *****************");

		} catch (Exception e) {
			System.out.println("No such Element exception");
		}
	}

	public void gettitle() {
		try {
			System.out.println(driver.getTitle());
		} catch (Exception e) {
			System.out.println("Not found get title");
		}
	}

	public void screenshot(String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (Exception e) {
			System.out.println("screenshot not capture");
		}
	}

	public void MultipleGettext(List<WebElement> element) {
		List<WebElement> text = element;
		System.out.println(text.size());

		for (WebElement textcount : text) {
			String totallist = textcount.getText();
			System.out.println("*************************************************");
			System.out.println(totallist);
		}
	}

	public void Getvalue(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public void dropdown(WebElement element, String text) {
		Select drp = new Select(element);
		drp.selectByValue(text);
	}

	public void scrolldown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void waits() throws Throwable {
		Thread.sleep(2000);
	}

	public void mousehover(WebElement element) {
		act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void moveelement(WebElement element) {
		act.moveToElement(element).click().perform();
	}

	public void highlightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}
	public  void windowhandling(WebElement element) {
		
		String parentwindow = driver.getWindowHandle();
		//element.click();
		System.out.println(parentwindow);
		
		Set<String> allwindow = driver.getWindowHandles();
		System.out.println(allwindow.size());
		for(String chilwindow: allwindow) {
			driver.switchTo().window(chilwindow);
			System.out.println(chilwindow);
			
		}
		  }
	
		public void attachscreenshot(Scenario cucumberscenario) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			cucumberscenario.attach(screenshot, "image/png", "FlipkartAutomation");
			
		}
		public void closeapp() {
			driver.quit();
			System.out.println("close browser");
		}
		public void navigateback() {
			driver.navigate().back();
			}
}