package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LetTheCarWorkPage extends BasePage{

    @FindBy(xpath = "//input[@id='pickUpPlace']")
    WebElement locationField;
    @FindBy(xpath = "//input[@id='make']")
    WebElement manufactureField;
    @FindBy(xpath = "//input[@id='model']")
    WebElement modelField;
    @FindBy(xpath = "//input[@id='year']")
    WebElement yearField;
    @FindBy(xpath = "//select[@id='fuel']")
    WebElement fuelField;
    @FindBy(xpath = "//input[@id='seats']")
    WebElement seatsField;
    @FindBy(xpath = "//input[@id='class']")
    WebElement carClassField;
    @FindBy(xpath = "//label[@for='serialNumber']")
    WebElement carRegistrationNumberField;
    @FindBy(xpath = "//input[@id='price']")
    WebElement priceField;
    @FindBy(xpath = "//textarea[@id='about']")
    WebElement aboutField;//??????????????????
    @FindBy(xpath = "//label[normalize-space()='Add photos of your car']")
    WebElement photosOfYourCarField;//???????????
    @FindBy(xpath = "")
    WebElement submitButton;

    public LetTheCarWorkPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20), this);
    }

    public LetTheCarWorkPage fillLocationField(String location){    //????????????????
        locationField.sendKeys(location);
        return this;
    }
    public LetTheCarWorkPage fillManufactureField(String manufacture){    //????????????????
        manufactureField.sendKeys(manufacture);
        return this;
    }
    public LetTheCarWorkPage fillModelField(String model){
       modelField.sendKeys(model);
        return this;
    }
    public LetTheCarWorkPage fillYearField(String year){    //????????????????
        yearField.sendKeys(year);
        return this;
    }
    public LetTheCarWorkPage fillFuelField(String fuel){    //?????????????????
        fuelField.sendKeys(fuel);
        return this;
    }
    public LetTheCarWorkPage fillSeatsField(String seats){  //???????????
        seatsField.sendKeys(seats);
        return this;
    }
    public LetTheCarWorkPage fillCarClassField(String carClass){
        carClassField.sendKeys(carClass);
        return this;
    }
    public LetTheCarWorkPage fillCarRegistrationNumberField(String carRegistrationNumber){
        carRegistrationNumberField.sendKeys(carRegistrationNumber);
        return this;
    }
    public LetTheCarWorkPage fillPriceField(String price){
        priceField.sendKeys(price);
        return this;
    }
    public LetTheCarWorkPage fillAboutField(String about){  //?????????????????
        aboutField.sendKeys(about);
        return this;
    }
    public LetTheCarWorkPage fillPhotosOfYourCarField(String photosOfYourCar){  //???????????????
        photosOfYourCarField.sendKeys(photosOfYourCar);
        return this;
    }
    public BasePage clickBySubmitButton(){
        submitButton.click();
        Alert alert = getAlertIfPresent();
        if (alert != null) {
            alert.accept();
            return new HomePage(driver); //???new page???
        } else {
            return new LetTheCarWorkPage(driver);
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
