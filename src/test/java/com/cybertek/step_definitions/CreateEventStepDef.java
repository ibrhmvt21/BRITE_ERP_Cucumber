package com.cybertek.step_definitions;

import com.cybertek.pages.Import_CreateLocators;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ExcelUtil;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CreateEventStepDef {


    Import_CreateLocators impObj = new Import_CreateLocators();

    @Then("Create event with external data and verify event created")
    public void create_event_with_external_data() throws ParseException {

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

            DateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy"); // for parsing input
            DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  // for formatting output
            String inputDate = event.get("Start Date");
            Date d = df1.parse(inputDate);
            String outputDate = df2.format(d);

            impObj.startDate.sendKeys(outputDate);


            DateFormat df01 = new SimpleDateFormat("dd-MMM-yyyy"); // for parsing input
            DateFormat df02 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  // for formatting output
            String inputDate2 = event.get("End Date");
            Date d2 = df01.parse(inputDate);
            String outputDate2 = df02.format(d2);

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



}
