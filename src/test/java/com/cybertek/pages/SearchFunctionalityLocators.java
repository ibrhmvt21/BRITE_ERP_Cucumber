package com.cybertek.pages;


import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFunctionalityLocators {
    public SearchFunctionalityLocators() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "div[class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement removeDefaultFilter;

    @FindBy(css = "input[class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(css = "div[class='o_kanban_view o_event_kanban_view o_kanban_ungrouped']")
    public WebElement allUpcominEvents;

    @FindBy(xpath = "//div[@class='o_kanban_view o_event_kanban_view o_kanban_ungrouped']//div[9]")
    public WebElement Event_1;

    @FindBy(css = "span[title='Advanced Search...']")
    public WebElement advanceSearch;

    @FindBy(xpath = "(//span[@class='caret'])[1]")
    public WebElement filterButton;

    @FindBy(xpath = "(//span[@class='caret'])[2]")
    public WebElement groupedby;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_group_by_menu']//li[5]")
    public WebElement EndDate;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ul/li[6]/a")
    public WebElement addCostomgroups;

    @FindBy(css = "select[class='o_input o_add_group o_group_selector']")
    public WebElement selections;

    @FindBy(css = "button[class='btn btn-primary btn-sm o_add_group o_select_group']")
    public WebElement apply;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_filters_menu']//li[4]")
    public WebElement confirmedEvents;

    @FindBy(xpath = "//span[contains(text(),'Event Categories')]")
    public WebElement EvenCategories;

    @FindBy(xpath = "//div[1]/div[2]/div[1]/div[1]/button[1]")
    public WebElement create;

    @FindBy(xpath = "//div[1]/div[1]/h1[1]/input[1]")
    public WebElement eventCategories;
    @FindBy(xpath = "//div[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
    public WebElement userdefaulttime;
    @FindBy(xpath = "(//button[@type='button'][contains(text(),'Save')])[1]")
    public WebElement save;

    @FindBy(xpath = "//td[contains(text(),'Food')]")
    public WebElement food;
    @FindBy(xpath = "//span[@name='name']")
    public WebElement expectedresult;


}
