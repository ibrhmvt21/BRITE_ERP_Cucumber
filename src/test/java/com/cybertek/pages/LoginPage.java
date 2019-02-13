package com.cybertek.pages;


import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BrowserUtils {

	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//a[@href='/web?db=BriteErpDemo']")
	public WebElement homepage;

	@FindBy(id = "login")
	public WebElement email;

	@FindBy(id = "password")
	public WebElement pwd;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement loginBtn;

	@FindBy(xpath = "//a[@data-menu='124']")
	public WebElement EventsModule;




	}

