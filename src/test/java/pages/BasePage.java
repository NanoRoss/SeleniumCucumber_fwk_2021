package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected static WebDriver driver;    //Tenemos una instancia del WebDriver compartida con todas las clases. En todas las intancias de la clase BasePage la variable driver será la misma ya que existe a nivel de clase, no existe por separado para cada instancia.
    private  static WebDriverWait wait;
    private static Actions actions;

    static {                                                    //Bloque Estatico para definir variables Estaticas
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);   //Declaro el Objeto Driver de tipo Chromedriver.
    }


    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // En todos los steps del fwk esperará 10 seg.
    }

    public static void navigateTo(String URL){
        driver.get(URL);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public String textForElement(String locator){
        return Find(locator).getText();
    }

    public void selectFromDropdown_ByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdown_ByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdown_ByText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOberElement(String locator){
        actions.moveToElement(Find(locator));
    }

    public void doubleClik(String locator){
        actions.doubleClick(Find(locator));
    }

    public void rigthClik(String locator){
        actions.contextClick(Find(locator));
    }

    public void swichToIframe(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void swichToParentframe(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
    public void AceptAlert(){
        driver.switchTo().alert().accept();
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public String ValueFromAttribute(String locator, String attribute){
        return Find(locator).getAttribute(attribute);
    }

    public boolean elementIsEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public List<WebElement> AllElementsInList(String locator){
        return driver.findElements(By.className(locator));
    }



    /**
     * -----------------------------------------------------------------------------------------------------
     * 1  -Creo OBJETOS ESTATICOS WebDriver(protected) y WebDriverWait(privat).
     * 2  -En un Bloque Estatico:
     * 2.1   -Creo Objeto chromeOptions
     * 2.2   -Declaro el Objeto Driver como de tipo ChromeDriver y como parametro le paso las chromeOptions.
     * 3  -El Constructor de la Clase BasePage requiere como parametro un objeto driver
     * 3.1   -Igualo el driver que recive el constructor con el de declarado mi clase estatica.
     * 3.2   -Declaro el Objeto wait y como parametro le paso las el driver y los segundos de espera.
     * -----------------------------------------------------------------------------------------------------
     */



}
