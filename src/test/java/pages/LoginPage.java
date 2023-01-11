package pages;

import com.org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends BaseClass {
    @FindBy(xpath="//input[@name=\"username\"]")
    WebElement hrmUserName;

    @FindBy(xpath="//input[@name=\"password\"]")
    WebElement hrmPassword;
    @FindBy(css ="button[type=\"submit\"]")
    WebElement loginBtn;

    //create constructor
    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    //create a method to execute login panel
    public HomePage login(String username, String password) throws IOException, InterruptedException {
        hrmUserName.isDisplayed();
        hrmUserName.sendKeys(username);
        hrmPassword.isDisplayed();
        hrmPassword.sendKeys(password);
        loginBtn.click();
        Thread.sleep(12000);
        return new HomePage();

    }


}
