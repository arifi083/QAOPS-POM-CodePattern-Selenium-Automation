package pages;

import com.org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends BaseClass {
    @FindBy(xpath="(//p[normalize-space()='My Actions'])[1]")
    WebElement dashboardVerifyText;

    //create constructor of HomePage
    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    //assert dashboard
    public boolean dashboardText(){
        return dashboardVerifyText.isDisplayed();
    }


}
