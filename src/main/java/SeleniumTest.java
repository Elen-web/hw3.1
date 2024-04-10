import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elen Balyan\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        String sutUrl = "https://www.selenium.dev/";
        driver.get(sutUrl);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

       // driver.manage().window().maximize();

        driver.manage().window().fullscreen();

        WebElement element = driver.findElement(By.id("Layer_1"));
        element.click();

        WebElement sponsorImage = driver.findElement(By.className("w-100"));
        String imageUrl = sponsorImage.getAttribute("src");
        System.out.println("Image URL: " + imageUrl);

        WebElement aboutButton = driver.findElement(By.linkText("About"));
        aboutButton.click();


        WebElement logo = driver.findElement(By.cssSelector("img.w-100.shadow-1-strong.rounded.selenium-backer-logo[src='/images/sponsors/saucelabs.png']"));
        boolean isDisplayed = logo.isDisplayed();
        System.out.println("Is logo displayed? " + isDisplayed);
        assert isDisplayed;


        List<WebElement> elements = driver.findElements(By.className("selenium-button"));
        for (WebElement Element : elements) {
            System.out.println( Element.getText());
            assert(Element.getText().equals("Send keys"));
        }

        WebElement imageElement = driver.findElement(By.xpath("//img[contains(@src, '/images/sponsors/Avo_logo.png')]"));
        String srcAttributeValue = imageElement.getAttribute("src");
        System.out.println("Image Source: " + srcAttributeValue);


        driver.quit();
    }
}
