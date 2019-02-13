package com.cybertek.pages;

import com.cybertek.utilities.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventCats_Locators {

    public EventCats_Locators() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Import')]")
    public WebElement importButton;

    @FindBy(xpath = "//a[@href='/web#menu_id=127&action=139']")
    public WebElement eventCat;

    @FindBy(xpath = "//td[.='Online']")
    public WebElement online;

    @FindBy(xpath = "//h2[.='Location']")
    public WebElement location;

    @FindBy(xpath = "//h2[.='Communication']")
    public WebElement communication;

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createButton;

    @FindBy(xpath = "//li[.='Event Categories']")
    public WebElement eventCatText;

    @FindBy(xpath = "//title[contains(text(),'Event Categories - Odoo')]")
    public WebElement ecTitle;

}
