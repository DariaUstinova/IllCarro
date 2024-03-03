package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//input[@id='city']")  //?????????
    WebElement cityField;
    @FindBy(xpath = "//input[@class='ng-untouched ng-pristine ng-valid']")  //??????????
    WebElement datesField;
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Search']")
    WebElement searchButton;

    public SearchPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }
    public SearchPage fillCityField(String city){
        cityField.sendKeys();
        return this;
    }
    public SearchPage fillDatesField(String dates){
       datesField.sendKeys();
        return this;
    }
    public BasePage clickSearchButton(){
        searchButton.click();
        Alert alert = getAlertIfPresent();
        if (alert != null) {
            alert.accept();
            return new HomePage(driver); //?????????????
        } else {
            return new SearchPage(driver);
        }
    }
    private Alert getAlertIfPresent(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
            return wait.until(ExpectedConditions.alertIsPresent());
        }
        catch(TimeoutException e){
            System.out.println("Alert issue " +e);
            return null;
        }
    }

}
