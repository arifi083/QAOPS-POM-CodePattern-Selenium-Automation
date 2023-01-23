package testcases;
import com.org.baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utlis.TimeOut;

import java.io.IOException;

public class LoginTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    //create constructor for LoginTest

    public LoginTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException {
        setUp();
        loginPage=new LoginPage();
    }

    @Test(priority = 3)
    public void loginWithValidCredentials() throws IOException, InterruptedException {

        homePage=new LoginPage()
                .login(getUserName(),getPassword());
        //assert dashboard
        System.out.println("valid test case");
        Assert.assertTrue(homePage.dashboardText());


    }



    //negative testing
    //    @Test(priority =1)
    //    public void loginWithInvalidCredentials() throws IOException, InterruptedException {
    //
    //        loginPage = loginPage
    //                .blankLogin(LoremIpsum.getInstance().getFirstName(),getPassword());
    //        //assert dashboard
    //        Assert.assertTrue(loginPage.verifyCreds());
    //
    //
    //    }


    //    @Test(dataProvider = "getDataProviderData")
    //    public void loginWithInValidCredentials(String userName, String password) throws IOException, InterruptedException {
    //
    //       loginPage= loginPage
    //               .blankLogin(userName,password);
    //       Assert.assertTrue(loginPage.verifyCreds());
    //
    //    }


    //    @DataProvider
    //    public Object[][] getDataProviderData(){
    //        return new Object[][]{{LoremIpsum.getInstance().getFirstName(),getPassword()}};
    //    }

    @Test(dataProvider = "GetExcelData-DataProvider")
    public void loginWithInValidCredentials(String userName, String password) throws IOException, InterruptedException {

        loginPage= loginPage
                .blankLogin(userName,password);
        System.out.println("invalid test case");
        Assert.assertTrue(loginPage.verifyCreds());

    }

    @DataProvider(name="GetExcelData-DataProvider")
    public Object[][] getDataProviderDataFromExcel(){
        return TimeOut.getTestData("Sheet1");

    }



    @Test(priority =2)
    public void loginWithPartialCredentials() throws IOException, InterruptedException {

        loginPage = loginPage
                .partialValidCreds(getUserName());
        //assert dashboard
        System.out.println("partial test case");
        Assert.assertTrue(loginPage.verifyPartialCreds());


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}