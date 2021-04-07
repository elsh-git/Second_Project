import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main_test {
    private static ChromeDriver driver;
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test = extent.createTest("buyme-Test","Test-To-Website");




    @BeforeClass
    public void runOnceBeforeClass() throws Exception {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyMMddHHmmss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\"+strDate+"-BuymeTest.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Buyme sanity test","this test check my sanity while trying to find all the relevant commands to this test");
        String type = getData("browserType");
        if (type.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elad\\drivers\\ChromeDriver.exe");
            driver = Driver_singleton.getInstance();
        }
        driver.manage().window().maximize();
        driver.get("https://www.buyme.co.il");
        test.log(Status.PASS,"Grate Success - we entered the site");
    }


    @Test(priority = 1)
    public void test_registration_screen()throws IOException{

        Intro_and_Registration_screen intro_and_registration_screen = new Intro_and_Registration_screen(driver);
        try {

            intro_and_registration_screen.Click_on_entrance_registration();
            test.log(Status.PASS,"Grate Success ! - we clicked on entrance registration ");
          intro_and_registration_screen.To_register();
            test.log(Status.PASS,"Grate Success ! - we clicked to register ");
        intro_and_registration_screen.Enter_first_name();
            test.log(Status.PASS,"Grate Success ! - we entered an awesome first name ");
            intro_and_registration_screen.Enter_email_address();
            test.log(Status.PASS,"Grate Success ! - we entered an awesome email address ");
            intro_and_registration_screen.Enter_password_and_Re_enter_password();
            test.log(Status.PASS,"Grate Success ! - we entered twice an awesome password ");

            intro_and_registration_screen.Press_register();
            test.log(Status.PASS,"Grate Success ! - we clicked register ");

        }
        catch (Exception e){
            test.log(Status.FAIL,"Oh NO! - we failed on the registration process");
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("Oh NO! - we failed on the registration process", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        }

        }

    @Test(priority = 2)
    public void test_home_screen()throws IOException{
//
        Home_Screen home_screen = new Home_Screen(driver);
        try {
            home_screen.Pick_price_point();
            test.log(Status.PASS, "Grate Success ! - we picked Price");
            home_screen.Pick_region();
            test.log(Status.PASS, "Grate Success ! - we picked region");
            home_screen.Pick_category();
            test.log(Status.PASS, "Grate Success ! - we picked category");
            home_screen.find_me_a_present();
            test.log(Status.PASS, "Grate Success ! - we clicked and find a present");
}
        catch (Exception e){
            test.log(Status.FAIL,"Oh NO! - we failed to find a present");
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("Oh NO! - we failed to find a present", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow + "Buyme-ScreenShot")).build());
        }

    }

    @Test(priority = 3)
    public void test_pick_business()throws IOException{
        Pick_business pick_business = new Pick_business(driver);
        try {
            pick_business.Assert_website_URL();
            test.log(Status.PASS, "Grate Success ! - we Assert website URL");
            pick_business.Pick_buisness();
            test.log(Status.PASS, "Grate Success ! - we picked business");
            pick_business.Enter_or_choose_price();
            test.log(Status.PASS, "Grate Success ! - we Entered price");
            pick_business.Press_to_choose();
            test.log(Status.PASS, "Grate Success ! - we Pressed to choose");
        }
        catch (Exception e){
            test.log(Status.FAIL,"Oh NO!- we failed to pick business");
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("Oh NO!- we failed to pick business", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }

    @Test(priority = 4)
    public void test_receiver_information_screen() throws IOException {
        Sender_and_Receiver_information_screen sender_and_receiver_information_screen = new Sender_and_Receiver_information_screen(driver);
        try {
            sender_and_receiver_information_screen.Press_button_to_somebody_else();
            test.log(Status.PASS, "Grate Success ! - we Pressed to somebody else");
            sender_and_receiver_information_screen.Enter_receiver_name();
            test.log(Status.PASS, "Grate Success ! - we Entered receiver name");
            sender_and_receiver_information_screen.Pick_an_event();
            test.log(Status.PASS, "Grate Success ! - we Picked an event");
            sender_and_receiver_information_screen.Enter_a_blessing();
            test.log(Status.PASS, "Grate Success ! - we Entered a blessing");
            sender_and_receiver_information_screen.Upload_a_picture();
            test.log(Status.PASS, "Grate Success ! - we Uploaded a picture");
            sender_and_receiver_information_screen.Press_button_after_payment();
            test.log(Status.PASS, "Grate Success ! - we Pressed on after payment");
            sender_and_receiver_information_screen.Pick_sms();
            test.log(Status.PASS, "Grate Success ! - we Picked sms");
            sender_and_receiver_information_screen.Enter_phone_number();
            test.log(Status.PASS, "Grate Success ! - we Entered phone number");

        } catch (Exception e) {
            test.log(Status.FAIL,"NOOOO! - we failed on the last screen ");
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("NOOOO! - we failed on the last screen", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        }
    }
    @AfterClass
    public void afterClass(){
        //End test and save data into report file
        extent.flush();
    }

    private static String getData (String keyName) throws Exception {
        ClassLoader classLoader = Main_test.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }

}
