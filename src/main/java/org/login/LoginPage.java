package org.login;

import java.util.List;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Baseclass   {

	public LoginPage() {
           PageFactory.initElements(driver, this);
     }
	
	
	@FindBy(id="email")
	private  WebElement txtusername;
		  
	@FindBy(id="pass")
     private WebElement password;
	
	@FindBy(name="login")
	private WebElement btn;

	public WebElement getTxtusername() {
		return txtusername;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getBtn() {
		return btn;
	}
	
	}
	
	
	

