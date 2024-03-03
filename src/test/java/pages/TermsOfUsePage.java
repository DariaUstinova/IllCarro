package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TermsOfUsePage extends BasePage{

    @FindBy(xpath = "a[href='https://ilcarro.xyz/']")
    WebElement termsAndCondLink;
    @FindBy(xpath = "//a[normalize-space()='Privacy Policy']")
    WebElement privacyPolicyLink;

    public TermsOfUsePage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }
public BasePage clickByTermsAndConditionsLink(){
        termsAndCondLink.click();
        return new TermsandCondPage(driver);
}
public BasePage clickByPrivacyPolicyLink(){
        privacyPolicyLink.click();
        return new PrivacyPolicyPage(driver);
}
}
