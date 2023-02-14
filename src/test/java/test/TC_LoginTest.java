package test;

import base.BasePage;

import base.CredentialsPage;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;
import pages.TC_LoginPage;

public class TC_LoginTest extends BasePage {
    @Test
    public void loginTest() throws InterruptedException {

        TC_LoginPage login = new TC_LoginPage(driver);
        driver.get(loginurl);
        Thread.sleep(3000);

        CredentialsPage cred = new CredentialsPage();
        String username = cred.usernameCred();
        String password = cred.passcred();

        login.usernameMethod(username);
        login.passwordMethod(password);
        login.loginMethod();






    }
}
