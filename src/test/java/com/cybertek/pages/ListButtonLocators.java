

package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ListButtonLocators {
    public ListButtonLocators() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath="//div[@class='btn-group btn-group-sm o_cp_switch_buttons']//button[3]")
    public WebElement listbutton;

    @FindBy(xpath="//div[@class='btn-group btn-group-sm o_cp_switch_buttons']//button[4]")
    public WebElement pivotButton;

    @FindBy(xpath="//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement cross;

    @FindBy(xpath="//*[@class='o_pager_limit']")
    public WebElement number;



}
