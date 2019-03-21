package com.cybertek.step_definitions;

import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Then;

import java.util.List;

public class BackendStepDefinitions {


    @Then("created events on events module should match database records")
    public void created_events_on_events_module_should_match_database_records() {




        String sql = "SELECT * FROM event_event;";
        List<Object> names = DatabaseUtility.getColumnData(sql,"name");
        System.out.println(names);
    }




}
