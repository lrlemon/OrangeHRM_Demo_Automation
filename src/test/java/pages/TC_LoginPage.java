package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC_LoginPage {
    public WebDriver driver;

    public By userNamePath = By.xpath("//input[@name='username']");
    public By passwordPath = By.xpath("//input[@type='password']");
    public By loginPath = By.xpath("//button[@type='submit']");
    public TC_LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void usernameMethod(String uname){
        System.out.println("Signing start....");
        driver.findElement(userNamePath).sendKeys(uname);
    }

    public void passwordMethod(String pass){

        driver.findElement(passwordPath).sendKeys(pass);
    }


    public void loginMethod(){
        driver.findElement(loginPath).click();
    }



}
