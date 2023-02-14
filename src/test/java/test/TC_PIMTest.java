package test;

import base.BasePage;
import base.CredentialsPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.TC_LoginPage;
import pages.TC_PIMPage;

import java.io.IOException;

@Test
public class TC_PIMTest extends BasePage {

    public void pimTest() throws InterruptedException, IOException, ParseException {
        TC_LoginPage login = new TC_LoginPage(driver);
        driver.get(loginurl);
        Thread.sleep(3000);

        CredentialsPage cred = new CredentialsPage();
        String username = cred.usernameCred();
        String password = cred.passcred();

        login.usernameMethod(username);
        login.passwordMethod(password);
        login.loginMethod();


        TC_PIMPage pim = new TC_PIMPage(driver);
        pim.pimMethod();
        pim.addButtonMethod();
        pim.addEmployeeMethod();

    }


}
