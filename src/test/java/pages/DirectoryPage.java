package pages;

import com.org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DirectoryPage extends BaseClass {
    protected static final FluentWait fluentwait = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofMillis(200))
            .ignoring(Exception.class);
    protected static final WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

    public DirectoryPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath="//a[normalize-space()='Directory']")
    WebElement directory;

    @FindBy(xpath="//h5[normalize-space()='Directory']")
    WebElement directoryTitlePage;

    @FindBy(xpath="//button[normalize-space()='Search']")
    WebElement searchBtn;

    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    WebElement typeName;

    @FindBy(xpath="//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]")
    WebElement locationLink;

    @FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement loggesUserIcon;

    @FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement logoutLink;


    public DirectoryPage clickDirectoryPage(){
        directory.isDisplayed();
        return this;
    }

    public boolean hasDirectoryPage(){
        return directoryTitlePage.isDisplayed();
    }

    public DirectoryPage clickDirectoryLink() throws InterruptedException{
        directory.click();
        typeName.sendKeys("Ch");
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']"));  //oxd-select-dropdown --positon-bottom\
        System.out.println("Total Name List"+" "+list.size());
        list.get(0).click();
        Thread.sleep(3000);

//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getText());
//            list.get(1).click();
//            Thread.sleep(3000);
//            break;
//        }
        return this;
    }

    public DirectoryPage locationSearch() throws InterruptedException{
        wait.until(ExpectedConditions.elementToBeClickable(locationLink));
        locationLink.click();
        List<WebElement>locationList = driver.findElements(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']"));
        System.out.println("Total location list" +" "+locationList.size());
        locationList.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
        Thread.sleep(3000);
        String myStr ="Ch";
        String a = String.valueOf(myStr.charAt(0)) + String.valueOf(myStr.charAt(1));
        List<WebElement>l = driver.findElements(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header --break-words']"));
        if(l.size()>0){
            System.out.println("Text"+" "+a+"is present");
        }
        else{
            System.out.println("Text"+" "+a+"is not present");
        }
        return this;
    }

    public LoginPage logOutLink() throws InterruptedException, IOException {
        loggesUserIcon.click();
        Thread.sleep(3000);
        logoutLink.click();
        return new LoginPage();

    }


}
