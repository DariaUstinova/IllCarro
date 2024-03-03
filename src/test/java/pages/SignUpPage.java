package pages;

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

public class SignUpPage extends BasePage {
    @FindBy(xpath = "//input[@id='name']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "///label[@for='email']")
    WebElement emailField;
    @FindBy(xpath = "//label[@for='password']")
    WebElement passwordField;
    @FindBy(xpath = "//label[contains(text(),'I agree to the')]")
    WebElement checkbox;
    @FindBy(xpath = "//button[contains(text(),'Y’alla!')]")
    WebElement yallaButton;
    @FindBy(xpath = "//span[@class='navigator']")
    WebElement alreadyRegisteredLink;

    public SignUpPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public SignUpPage fillnameField(String name) {
        nameField.sendKeys(name);
        return this;
    }

    public SignUpPage filllastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public SignUpPage fillEmailField(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage fillPasswordField(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public BasePage clickByYallaButton(){
        if(checkbox!=null) { //checkbox???
            yallaButton.click();
            Alert alert = getAlertIfPresent();
            if (alert != null) {
                alert.accept();
                return new HomePage(driver);
            } else {
                return new SignUpPage(driver);
            }
        } else  {
            return new SignUpPage(driver);
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

    public BasePage clickByAlreadyRegisteredLink(){
        alreadyRegisteredLink.click();
        return new LoginPage(driver);
    }
}
