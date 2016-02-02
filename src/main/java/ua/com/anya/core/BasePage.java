package ua.com.anya.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ua.com.anya.core.Asserts.assertThat;

public class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static WebElement $(WebElement element){
        return assertThat(visibilityOf(element), driver);
    }

    public static WebElement $(By locator){
        return assertThat(visibilityOfElementLocated(locator), driver);
    }

    public static WebElement $(String cssSelector){
        return assertThat(visibilityOfElementLocated(By.cssSelector(cssSelector)), driver);
    }

    public static List<WebElement> findElements(List<WebElement> elements, String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        for (WebElement element : elements) {
            list.add(element.findElement(By.cssSelector(locator)));
        }
        return list;
    }
}