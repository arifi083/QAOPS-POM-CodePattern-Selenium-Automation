package pages;

import com.org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);


    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
    @FindBy(xpath="//input[@name=\"username\"]")
    WebElement hrmUserName;

    @FindBy(xpath="//input[@name=\"password\"]")
    WebElement hrmPassword;
    @FindBy(css ="button[type=\"submit\"]")
    WebElement loginBtn;

    @FindBy(xpath ="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement blankCredVerify;

    @FindBy(xpath="(//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[1]")
    WebElement partialCred;

    //create constructor
    public LoginPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    //create a method to execute login panel
    public HomePage login(String username, String password) throws IOException, InterruptedException {
        hrmUserName.isDisplayed();
        hrmUserName.sendKeys(username);
        Thread.sleep(2000);
        hrmPassword.isDisplayed();
        hrmPassword.sendKeys(password);
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(5000);
        return new HomePage();

    }

    public LoginPage blankLogin(String username, String password) throws IOException, InterruptedException {
        hrmUserName.isDisplayed();
        hrmUserName.sendKeys(username);
        hrmPassword.isDisplayed();
        Thread.sleep(2000);
        hrmPassword.sendKeys(password);
        Thread.sleep(1000);
        loginBtn.click();
        Thread.sleep(5000);
        return this;

    }

    public LoginPage partialValidCreds(String username) throws IOException, InterruptedException {
        hrmUserName.isDisplayed();
        hrmUserName.sendKeys(username);
        Thread.sleep(2000);
        loginBtn.click();
        Thread.sleep(5000);
        return this;

    }


    public boolean verifyCreds(){
        try{
            fluentwait.until(ExpectedConditions.visibilityOf(blankCredVerify));
            return true;
        } catch (Exception E){
            return false;
        }
    }

    public boolean verifyPartialCreds(){
        try{
            fluentwait.until(ExpectedConditions.visibilityOf(partialCred));
            return true;
        } catch (Exception E){
            return false;
        }
    }




}
