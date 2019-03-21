package com.cybertek.step_definitions;

import com.cybertek.pages.Import_CreateLocators;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateEventStepDef {


    Import_CreateLocators impObj = new Import_CreateLocators();

    @Then("Create event with external data and verify event created")
    public void create_event_with_external_data()  {

        impObj.createBtn.click();

        String file = "./src/test/resources/test_data/TestDataERP.xlsx";
        String sheet = "BRIT-4405";
        ExcelUtil eventData = new ExcelUtil(file, sheet);

        for (Map<String, String> event : eventData.getDataList()) {


            impObj.eventName.sendKeys(event.get("Event_Name"));

            impObj.organizer.clear();
            impObj.organizer.sendKeys(event.get("Organizer"));
            impObj.emptyField.click();
            impObj.confirm1.click();

            impObj.location.clear();
            impObj.location.sendKeys(event.get("Location"));
            impObj.emptyField.click();
            impObj.confirm1.click();

            impObj.responsible.clear();
            impObj.responsible.sendKeys(event.get("Responsible"));
            impObj.emptyField.click();


            String outputDate=impObj.formatDate(event.get("Start Date"));

            impObj.startDate.sendKeys(outputDate);


            String outputDate2=impObj.formatDate(event.get("End Date"));

            impObj.endDate.sendKeys(outputDate2);

            impObj.category.sendKeys(event.get("Category"));

            impObj.minAttende.sendKeys(event.get("Minimum Attendees"));

            BrowserUtils.waitForClickablility(impObj.confirmEvent, 5);
            impObj.confirmEvent.click();

            BrowserUtils.waitForClickablility(impObj.finishEvent, 5);
            impObj.finishEvent.click();

            BrowserUtils.wait(5);

            String actualText= impObj.confirmText.getText();
            String expectedText=event.get("Event_Name");

            Assert.assertEquals("Verify Event Created",expectedText,actualText);

            impObj.saveBtn.click();

            impObj.createBtn.click();

            BrowserUtils.wait(5);

        }

    }
    @Then("Create event with only required field data")
    public void create_event_with_only_required_field_data() {
        impObj.createBtn.click();

        String file = "./src/test/resources/test_data/TestDataERP.xlsx";
        String sheet = "BRIT-4406";
        ExcelUtil eventData = new ExcelUtil(file, sheet);

        for (Map<String, String> event : eventData.getDataList()) {

            impObj.eventName.sendKeys(event.get("Event_Name"));

            String outputDate=impObj.formatDate(event.get("Start Date"));

            impObj.startDate.sendKeys(outputDate);


            String outputDate2=impObj.formatDate(event.get("End Date"));

            impObj.endDate.sendKeys(outputDate2);

            BrowserUtils.waitForClickablility(impObj.confirmEvent, 5);
            impObj.confirmEvent.click();

            BrowserUtils.waitForClickablility(impObj.finishEvent, 5);
            impObj.finishEvent.click();

            String actualText= impObj.confirmText.getText();
            String expectedText=event.get("Event_Name");

            Assert.assertEquals("Verify Event Created",expectedText,actualText);

            impObj.saveBtn.click();

            impObj.createBtn.click();
        }
    }
    @Then("Create event with limited attendees")
    public void create_event_with_limited_attendees() {
        impObj.createBtn.click();

        String file = "./src/test/resources/test_data/TestDataERP.xlsx";
        String sheet = "BRIT-4407";
        ExcelUtil eventData = new ExcelUtil(file, sheet);

        for (Map<String, String> event : eventData.getDataList()) {
            impObj.eventName.sendKeys(event.get("Event_Name"));

            String outputDate=impObj.formatDate(event.get("Start Date"));

            impObj.startDate.sendKeys(outputDate);


            String outputDate2=impObj.formatDate(event.get("End Date"));

            impObj.endDate.sendKeys(outputDate2);

            if (!impObj.limitedAtt.isSelected())
            impObj.limitedAtt.click();

            impObj.maxSeats.sendKeys(event.get("Maximum Attendees"));

            BrowserUtils.waitForClickablility(impObj.confirmEvent, 5);
            impObj.confirmEvent.click();

            BrowserUtils.waitForClickablility(impObj.finishEvent, 5);
            impObj.finishEvent.click();

            String actualText= impObj.confirmText.getText();
            String expectedText=event.get("Event_Name");

            Assert.assertEquals("Verify Event Created",expectedText,actualText);

            impObj.saveBtn.click();

            impObj.createBtn.click();
        }
    }

    @Then("Create event with missing data")
    public void create_event_with_missing_data() {
        impObj.createBtn.click();

        String file = "./src/test/resources/test_data/TestDataERP.xlsx";
        String sheet = "BRIT-4408";
        ExcelUtil eventData = new ExcelUtil(file, sheet);

        for (Map<String, String> event : eventData.getDataList()) {
            impObj.eventName.sendKeys(event.get("Event_Name"));

            String outputDate=impObj.formatDate(event.get("Start Date"));

            impObj.startDate.sendKeys(outputDate);


            String outputDate2=impObj.formatDate(event.get("End Date"));

            impObj.endDate.sendKeys(outputDate2);

            BrowserUtils.waitForClickablility(impObj.confirmEvent, 5);
            impObj.confirmEvent.click();

            BrowserUtils.waitForVisibility(impObj.errorMessg, 5);
            Assert.assertTrue(impObj.errorMessg.isDisplayed());

            impObj.discard.click();

            impObj.okBtn.click();

            BrowserUtils.waitForClickablility(impObj.createBtn, 5);
            impObj.createBtn.click();
        }
    }
    @Then("Create event with conflicting time frame")
    public void create_event_with_conflicting_time_frame() {
        impObj.createBtn.click();

        String file = "./src/test/resources/test_data/TestDataERP.xlsx";
        String sheet = "BRIT-4409";
        ExcelUtil eventData = new ExcelUtil(file, sheet);

        for (Map<String, String> event : eventData.getDataList()) {
            impObj.eventName.sendKeys(event.get("Event_Name"));

            String outputDate=impObj.formatDate(event.get("Start Date"));

            impObj.startDate.sendKeys(outputDate);


            String outputDate2=impObj.formatDate(event.get("End Date"));

            impObj.endDate.sendKeys(outputDate2);


            BrowserUtils.waitForClickablility(impObj.confirmEvent, 5);
            impObj.confirmEvent.click();

            BrowserUtils.waitForVisibility(impObj.getErrorMessg3, 5);
            Assert.assertTrue(impObj.getErrorMessg3.isDisplayed());

            impObj.okBtn.click();

            impObj.discard.click();

            impObj.okBtn.click();

            BrowserUtils.waitForClickablility(impObj.createBtn, 5);
            impObj.createBtn.click();
        }
    }
}
