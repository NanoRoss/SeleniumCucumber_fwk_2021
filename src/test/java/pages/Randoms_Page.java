package pages;

import org.openqa.selenium.WebElement;

import java.security.SignatureSpi;
import java.util.ArrayList;
import java.util.List;

public class Randoms_Page extends BasePage {

    ////////////////////////////////  Scenario: I want to validate that a text is present inside the list

    private String CategoryDropdown_cmb = "//select[@id='testingDropdown']";

    public Randoms_Page() {
        super(driver);
    }

    public void navigateToLocatorSite(String URL){
        navigateTo(URL);
    }

    public void selectDropdown_Manual(){
        selectFromDropdown_ByValue(CategoryDropdown_cmb,"Manual");
    }

    public String validateDropdownSelection_Manual(){ return ValueFromAttribute(CategoryDropdown_cmb,"value");
    }

    ////////////////////////////////  Scenario: I want to validate that a text is present inside the list

    private String SearchText = "//body/form[1]/input[1]";
    private String ListResults = "name";

    public void navigateToListSite(String URL){
        navigateTo(URL);
    }

    public void enterSearchCriteria(String state) throws InterruptedException {
        Thread.sleep(700);
        write(SearchText,state);
        Thread.sleep(1000);

    }

    public List<String> getAllSearchResults(){

        List<WebElement> list = AllElementsInList(ListResults);
        List<String> WebElementsinStringList = new ArrayList<String>();

        for (int i=0;i<list.size();i++){
            WebElementsinStringList.add(list.get(i).getText());
        }

        return WebElementsinStringList;

    }










}
