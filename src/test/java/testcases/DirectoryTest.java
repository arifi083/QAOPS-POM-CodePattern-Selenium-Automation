package testcases;

import com.org.baseclass.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DirectoryPage;
import pages.HomePage;
import pages.LoginPage;
import utlis.TimeOut;

import java.io.IOException;

public class DirectoryTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    DirectoryPage directoryPage;
    public DirectoryTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void initialization() throws IOException, InterruptedException {
        setUp();
        homePage=new LoginPage()
                .login(getUserName(),getPassword());
        directoryPage = new DirectoryPage();
    }

    //Write testcases
    @Test
    public void verifyDirectoryPage() throws InterruptedException, IOException {
        directoryPage = directoryPage
                .clickDirectoryLink();
        Assert.assertTrue(directoryPage.hasDirectoryPage());
        directoryPage = directoryPage
                .locationSearch();
        loginPage = directoryPage
                .logOutLink();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
