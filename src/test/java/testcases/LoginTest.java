package testcases;

import com.org.baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;

public class LoginTest extends BaseClass {
    LoginPage loginPage;
    HomePage homepage;
    //create constructor for LoginTest

    public LoginTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage=new LoginPage();
    }

    @Test
    public void loginWithValidCredentials() throws IOException, InterruptedException {

        homepage =new LoginPage()
                .login(getUserName(),getPassword());
        //assert dashboard
        Assert.assertTrue(homepage.dashboardText());


    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
