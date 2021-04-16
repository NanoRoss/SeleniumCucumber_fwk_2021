package stepDefinitions;


import cucumber.api.java.en.*;
import org.junit.Assert;
import pages.BasePage;
import pages.Randoms_Page;

import java.util.List;

public class Randoms_Steps  {

Randoms_Page randoms_page = new Randoms_Page();

   ////// Scenario: As a user i do an accion to validate Dropdowns.

    @Given("^Navigate To web with Dropdown$")
    public void navigate_To_web_with_Dropdown() {
        randoms_page.navigateToLocatorSite("https://www.testandquiz.com/selenium/testing.html");
    }

    @When("^select a specific value on Dropdown$")
    public void select_a_specific_value_on_Dropdown() {
        randoms_page.selectDropdown_Manual();
    }

    @Then("^The selected value is the expected value$")
        public void The_selected_value_is_the_expected_value(){
        Assert.assertEquals(randoms_page.validateDropdownSelection_Manual(),"Manual");
    }


    ////// Scenario: I want to validate that a text is present inside the list


    @Given("^i navigate to the list page$")
    public void i_navigate_to_the_list_page() {
        randoms_page.navigateToListSite("http://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    @When("^i search (.*) in the list$")
    public void i_search_the_list(String state) throws InterruptedException {
        randoms_page.enterSearchCriteria(state);
    }

    @Then("^i can find (.*) in the resoult list$")
    public void i_can_find_the_text_in_the_list(String city) {
        List<String> list = randoms_page.getAllSearchResults();

        boolean textIsThere = false;

        if (list.contains(city)){
            textIsThere = true;
        }


        System.out.println(textIsThere +"------------" + list.toString());
        Assert.assertTrue("The Value does not exist",textIsThere);
    }



}
