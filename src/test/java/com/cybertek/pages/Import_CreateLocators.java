package com.cybertek.pages;


import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Import_CreateLocators extends BrowserUtils {


        public Import_CreateLocators() {
            PageFactory.initElements(Driver.getDriver(), this);
        }


        @FindBy(xpath = "//button[@accesskey='c']")
        public WebElement createBtn;

        @FindBy(xpath = "//input[@name='date_begin']")
        public WebElement startDate;

        @FindBy(xpath = "//input[@name='name']")
        public WebElement eventName;

        @FindBy(xpath = "//input[@name='date_end']")
        public WebElement endDate;

        @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight']")
        public WebElement confirmEvent;

        @FindBy(xpath = "//a[@href='/web#menu_id=128&action=142']")
        public WebElement eventsButton;

        @FindBy(xpath = "(//h4[@class='o_kanban_record_title']/span)[1]")
        public WebElement existingName;

        @FindBy(xpath = "//div[@class='o_notification_manager']/div")
        public WebElement errorMessg;

        @FindBy(xpath = "//div[@class='o_dialog_warning modal-body']")
        public WebElement getErrorMessg3;

        @FindBy(xpath = "//button[@accesskey='a']")
        public WebElement editButton;

        @FindBy (xpath = "(//div[@class='o_kanban_view o_event_kanban_view o_kanban_ungrouped']/div)[1]")
        public WebElement randomEvent;

        @FindBy(xpath = "(//td[@class='o_td_label'])[12]/label")
        public WebElement maxAttend;

        @FindBy(xpath = "//input[@class='o_radio_input' and @data-value='limited']")
        public WebElement limitedAtt;

        @FindBy(xpath = "(//div[@class='o_event_left'])[1]/div")
        public WebElement upcomingDate1;

        @FindBy(xpath = "(//div[@class='o_event_left'])[1]/div[2]")
        public WebElement upcomingDate2;

        @FindBy(xpath = "(//div[@class='o_event_right'])[1]/h4[2]")
        public WebElement numAttend;

       @FindBy(xpath ="(//button[@class='btn btn-sm btn-default'])")
        public WebElement cancelEvent;

       @FindBy (xpath = "(//div[@class='o_dialog_warning modal-body'])")
       public WebElement errorMessg2;

       @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
       public WebElement organizer;

        @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[2]")
        public WebElement location;

        @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[4]")
        public WebElement responsible;

        @FindBy(xpath = "(//button[@class='btn btn-sm btn-primary'])[1]")
        public WebElement confirm1;

        @FindBy(xpath = "(//div[@class='o_form_sheet'])[1]")
        public WebElement emptyField;

        @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[5]")
        public WebElement category;

        @FindBy(xpath = "(//input[@class='o_field_integer o_field_number o_field_widget o_input'])")
        public WebElement minAttende;

        @FindBy(xpath = "(//button[@class='btn btn-sm btn-default oe_highlight'])[2]")
        public  WebElement finishEvent;

        @FindBy(xpath = "//span[@name='name']")
        public WebElement confirmText;

        @FindBy(xpath = "//button[@accesskey='s']")
        public WebElement saveBtn;

        @FindBy(xpath = "//input[@name='seats_max']")
        public WebElement maxSeats;

        @FindBy(xpath = "//button[@accesskey='j']")
        public WebElement discard;

        @FindBy(xpath = "//button[@class='btn btn-sm btn-primary']")
        public WebElement okBtn;


        public List<String> createText(String xPath){
                List <WebElement> allBtnz=Driver.getDriver().findElements(By.xpath(xPath));

                List <String> text=new ArrayList<>();

                for(int i=0; i<allBtnz.size(); i++) {
                        text.add(allBtnz.get(i).getText());
                }
                return text;
        }

        public String setEndDate() {
                DateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                Date date = new Date();

                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.DATE, 2);

                Date currentDatePlusTwo = c.getTime();
                String futureDate = form.format(currentDatePlusTwo);
                return futureDate;
        }

        public String setStartDate() {
                DateFormat form = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
                Date date = new Date();

                Calendar c = Calendar.getInstance();
                c.setTime(date);
                c.add(Calendar.HOUR, 1);

                Date currentDatePlusOne = c.getTime();
                String futureDate = form.format(currentDatePlusOne);
                return futureDate;
        }

        public String todaysDate(){
                DateFormat today=new SimpleDateFormat("dd MMM yyyy");
                Date date =new Date();
                String today2= today.format(date);

                return today2;
        }

        public int compareDates(String date1, String date2) throws ParseException {
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
                Date dat1 = sdf.parse(date1);
                Date dat2 = sdf.parse(date2);

                if (dat1.compareTo(dat2) > 0) {
                        String s1 =("Today's date is after Event date");
                        return 1;

                } else if (dat1.compareTo(dat2) < 0) {
                        String s2= ("Today's date is before Event date");
                        return -1;

                } else  {
                        String s3= ("Today's date is equal to Event date");
                        return 0;
                }

        }

        public String formatDate(String inputDate)  {

            DateFormat df1 = new SimpleDateFormat("dd-MMM-yyyy"); // for parsing input
            DateFormat df2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  // for formatting output

            Date d = null;
            try {
                d = df1.parse(inputDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String outputDate = df2.format(d);

            return outputDate;
        }

}
