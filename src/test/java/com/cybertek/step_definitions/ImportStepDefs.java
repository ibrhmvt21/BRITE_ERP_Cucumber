package com.cybertek.step_definitions;

import com.cybertek.pages.Import_CreateLocators;
import com.cybertek.utilities.BrowserUtils;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.text.ParseException;

public class ImportStepDefs {

    Import_CreateLocators impCrtObj = new Import_CreateLocators();

    @Then("User should not see import button")
    public void user_should_not_see_import_button() {
        Assert.assertFalse(
                impCrtObj.createText("//button").contains("Import"));
    }

    @Then("Create event button should not be visible")
    public void create_event_button_should_not_be_visible() {
        Assert.assertFalse(
                impCrtObj.createText("//button").contains("Create"));
    }

    @Then("Create event as a manager")
    public void create_event_as_a_manager() {
        impCrtObj.createBtn.click();

        String expectedName = "New Event";
        impCrtObj.eventName.click();
        impCrtObj.eventName.sendKeys(expectedName);


        impCrtObj.startDate.click();
        impCrtObj.startDate.sendKeys(impCrtObj.setStartDate());


        BrowserUtils.waitForClickablility(impCrtObj.endDate, 5);
        //loc.endDate.click();
        impCrtObj.endDate.sendKeys(impCrtObj.setEndDate());

        impCrtObj.confirmEvent.click();

        impCrtObj.eventsButton.click();
        String s1 = impCrtObj.existingName.getText();

        Assert.assertEquals(s1, expectedName);
    }

    @Then("Create event without name date time and verify error message")
    public void create_event_without_name_date_time_and_verify_error_message() {

        impCrtObj.createBtn.click();

        BrowserUtils.wait(5);
        impCrtObj.confirmEvent.click();

        BrowserUtils.waitForVisibility(impCrtObj.errorMessg, 5);
        Assert.assertTrue(impCrtObj.errorMessg.isDisplayed());
    }

    @Then("Edit created event by manager")
    public void edit_created_event_by_manager() {

        impCrtObj.randomEvent.click();

        BrowserUtils.waitForPageToLoad(5);
        String actualText = impCrtObj.editButton.getText();

        Assert.assertEquals(actualText, "Edit");
    }

    @Then("Verify Maximum Attendees option is available")
    public void verify_Maximum_Attendees_option_is_available() {
        BrowserUtils.waitForPageToLoad(5);

        impCrtObj.createBtn.click();

        String actualText = impCrtObj.maxAttend.getText();

        Assert.assertEquals(actualText, "Maximum Attendees");
    }

    @Then("Verify Upcoming Events dates")
    public void verify_Upcoming_Events_dates() throws ParseException {

        BrowserUtils.waitForPageToLoad(5);

        String actualDate1 = impCrtObj.upcomingDate1.getText();
        String actualDate2 = impCrtObj.upcomingDate2.getText();

        String actDate = (actualDate1 + " " + actualDate2);
        System.out.println(impCrtObj.todaysDate());


        int mes = impCrtObj.compareDates(impCrtObj.todaysDate(), actDate);

        Assert.assertTrue(mes == 0 || mes < 0);

    }

    @Then("Verify text contains expected attendees")
    public void verify_text_contains_expected_attendees() {

        BrowserUtils.waitForPageToLoad(5);

        String expcText = impCrtObj.numAttend.getText();


        System.out.println(expcText);
        Assert.assertTrue(expcText.contains("Expected attendees"));
    }

    @Then("Verify Cancel Event button is displayed")
    public void verify_Cancel_Event_button_is_displayed() {

        BrowserUtils.waitForPageToLoad(5);

        impCrtObj.randomEvent.click();

        String text = impCrtObj.cancelEvent.getText();

        Assert.assertTrue(text.contains("Cancel Event"));
    }

    @Then("Verify Error message is displayed when user tries to cancel an event")
    public void verify_Error_message_is_displayed_when_user_tries_to_cancel_an_event() {

        BrowserUtils.waitForPageToLoad(5);

        impCrtObj.randomEvent.click();

        impCrtObj.cancelEvent.click();

        String actText = impCrtObj.errorMessg2.getText();

        Assert.assertTrue(actText.contains("you are not allowed to modify"));
    }


}
