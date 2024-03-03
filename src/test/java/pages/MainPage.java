package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver){
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
    }
    public <T extends BasePage> T openTopMenu(String topMenuItem){
        WebElement menuItem = driver.findElement(By.xpath("//a[contains(text(),'"+topMenuItem+"')]")))
        menuItem.click();
        switch (topMenuItem){
            case "HOME":
                return (T) new HomePage(driver); // new HomePage(driver): Это оператор создания нового объекта класса HomePage.
            // Здесь driver передается в качестве аргумента конструктору класса HomePage.
            // пример использования обобщенного программирования в Java // (T):
            // Это оператор приведения типа (type casting). В данном случае (T) означает,
            // что мы приводим созданный объект к типу T.
            case "SEARCH":
                return (T) new SearchPage(driver);
            case "LETTHECARWORK":
                return (T) new LetTheCarWorkPage(driver);
            case "TERMSOFUSE":
                return (T) new TermsOfUsePage(driver);
            case "SIGNUP":
                return (T) new SignUpPage(driver);
            case "LOGIN":
                return (T) new LoginPage(driver);

            default:throw new IllegalArgumentException("Something wrong"+ topMenuItem);

        }
    }
}
