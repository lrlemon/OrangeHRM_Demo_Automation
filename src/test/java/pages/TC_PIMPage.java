package pages;

import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TC_PIMPage {
    WebDriver driver;

    String writeFirstName,writeMidName,writeLastName;
    String  readFirstName,readMidName,readLastName;
    String  readFirstName2,readMidName2,readLastName2;



    public By pimPath = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']");
    public By addPath = By.className("oxd-button--secondary");
    public By firstNamePath = By.xpath("//input[@name='firstName']");
    public By middleNamePath = By.xpath("//input[@name='middleName']");
    public By lastNamePath = By.xpath("//input[@name='lastName']");
    public By savePath = By.xpath("//button[normalize-space()='Save']");



    public TC_PIMPage(WebDriver driver) {
        this.driver = driver;
    }


    public void pimMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(pimPath).click();
    }
    public void addButtonMethod() throws InterruptedException {
        Thread.sleep(2000);
        List <WebElement> addbuttonindex = driver.findElements(addPath);
        addbuttonindex.get(1).click();
    }
    public void addEmployeeMethod() throws IOException, ParseException, InterruptedException {


        Faker faker = new Faker();
        //for random data into json file
        for(int i=0;i<=3;i++){
            writeFirstName = faker.name().firstName();
            writeMidName = faker.name().nameWithMiddle();
            writeLastName = faker.name().lastName();
            //System.out.println("Firstname : "+writeFirstName+"\tMiddleName : "+writeMidName +"\tLastName : "+writeLastName);

            String writeFilePath = "./src/test/Users.json";
            JSONParser writeParser = new JSONParser();
            Object obj;
            obj = writeParser.parse(new FileReader(writeFilePath));
            JSONArray writejsonArray = (JSONArray) obj;
            JSONObject writejsonObject = new JSONObject();
            writejsonObject.clear();

            writejsonObject.put("FirstName",writeFirstName);
            writejsonObject.put("MiddleName",writeMidName);
            writejsonObject.put("LastName",writeLastName);

            writejsonArray.add(writejsonObject);

            FileWriter file = new FileWriter(writeFilePath);
            file.write(writejsonArray.toJSONString());
            file.flush();
            file.close();
        }

        //for read all data from json file
        String filePath = "./src/test/Users.json";
        JSONParser readjsonParser = new JSONParser();
        FileReader fileReader = new FileReader(filePath);
        Object object = readjsonParser.parse(fileReader);

        JSONArray readjsonArray = (JSONArray) object;
        for(int i=0;i<readjsonArray.size();i++){
            JSONObject readjsonObject = (JSONObject) readjsonArray.get(i);
            readFirstName = (String) readjsonObject.get("FirstName");
            readMidName = (String) readjsonObject.get("MiddleName");
            readLastName = (String) readjsonObject.get("LastName");

            //System.out.println("FirstName : "+readFirstName+"\t\tMiddleName : "+readMidName+"\t\tLastName : "+readLastName);
        }
        //for read the first object of array
        for(int i=0;i<1;i++){
            JSONObject readjsonObject = (JSONObject) readjsonArray.get(0);
            readFirstName2 = (String) readjsonObject.get("FirstName");
            readMidName2 = (String) readjsonObject.get("MiddleName");
            readLastName2 = (String) readjsonObject.get("LastName");
        }
        System.out.println("FirstName : "+readFirstName2+"\t\tMiddleName : "+readMidName2+"\t\tLastName : "+readLastName2);
        System.out.println("Saved Data");
        Thread.sleep(2000);
        driver.findElement(firstNamePath).sendKeys(readFirstName2);
        driver.findElement(middleNamePath).sendKeys(readMidName2);
        driver.findElement(lastNamePath).sendKeys(readLastName2);
        driver.findElement(savePath).click();
    }



}
