import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver_singleton {
    private static ChromeDriver instance = null;

    private Driver_singleton() { }


    public static ChromeDriver getInstance() {
//        System.out.println(driver1 == null);
        if (instance == null) {
//            System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Elad\\drivers\\ChromeDriver.exe");
             instance = new ChromeDriver();
//            System.out.println(instance);

        }
        return instance;

    }
}


