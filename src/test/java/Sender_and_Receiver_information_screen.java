import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Sender_and_Receiver_information_screen {
    private ChromeDriver driver;

    public Sender_and_Receiver_information_screen(ChromeDriver driver) throws IOException {
        this.driver = driver;
    }

    public void Press_button_to_somebody_else()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("div[gtm=\"למישהו אחר\"]")).click();

    }

    public void Enter_receiver_name()throws IOException{

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[data-parsley-required-message=\"מי הזוכה המאושר? יש להשלים את שם המקבל/ת\"]")).sendKeys(generatedString);
    }

    public void Pick_an_event()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("span[alt=\"לאיזה אירוע?\"]")).click();
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElements(By.cssSelector("li[class=\"ember-view bm-select-option\"]")).get(2).click();
    }

    public void Enter_a_blessing()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("span[class=\"textarea-clear-all \"]")).click();
        driver.findElement(By.cssSelector("textarea[rows=\"4\"]")).sendKeys("Happy Birthday !!! Health & Happiness");

    }

    public void Upload_a_picture()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        String img_path = "C:\\Users\\Elad\\Downloads\\img2.JPG";
        WebElement  element = driver.findElement(By.cssSelector("input[type='file']"));
        element.sendKeys(img_path);
    }

    public void Press_button_after_payment()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

    }

    public void Pick_sms()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("svg[gtm=\"method-sms\"]")).click();
    }

    public void Enter_phone_number()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        int leftLimit = 48; // letter '0'
        int rightLimit = 57; // letter '9'
        int targetStringLength = 7;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        System.out.println(generatedString);

        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("input[id=\"sms\"]")).sendKeys("054"+generatedString);
        Random random1 = new Random();
        StringBuilder buffer1 = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int random1LimitedInt = leftLimit + (int)
                    (random1.nextFloat() * (rightLimit - leftLimit + 1));
            buffer1.append((char) random1LimitedInt);
        }
        String generatedString1 = buffer1.toString();

        System.out.println(generatedString1);

        driver.findElement(By.xpath("//*[@id=\"ember2098\" and @data-parsley-mobile=\"mobile\"]")).sendKeys("054"+generatedString1);

    }

}