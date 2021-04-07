import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Intro_and_Registration_screen {

    private WebDriver driver;
    private static WebDriverWait wait;

    public Intro_and_Registration_screen(WebDriver driver)throws IOException {
        this.driver = driver;

    }

        public void Click_on_entrance_registration()throws IOException{

            driver.manage().timeouts().implicitlyWait(10,
                    TimeUnit.SECONDS);
            System.out.println("Is displayed: " + driver.findElement(By.className("seperator-link")).isDisplayed());
            driver.findElement(By.className("seperator-link")).click();

        }

        public void To_register()throws IOException{

            System.out.println("Is displayed: " + driver.findElement(By.className("text-link")).isDisplayed());
            wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(By.className("text-link"))).click();
        }

        public void Enter_first_name()throws IOException{

            System.out.println("Is displayed: " + driver.findElement(By.id("ember1376")).isDisplayed());

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

            driver.findElement(By.cssSelector("input[placeholder=\"שם פרטי\"]")).sendKeys(generatedString);
        }

        public void Enter_email_address()throws IOException{
            System.out.println("Is displayed: " + driver.findElement(By.id("ember1379")).isDisplayed());


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

            driver.findElement(By.cssSelector("input[placeholder=\"מייל\"]")).sendKeys(generatedString+"@"+generatedString+".com");

        }

        public  void Enter_password_and_Re_enter_password()throws IOException{
            driver.manage().timeouts().implicitlyWait(10,
                    TimeUnit.SECONDS);
            System.out.println("Is displayed: " + driver.findElement(By.id("ember1382")).isDisplayed());
            System.out.println("Is displayed: " + driver.findElement(By.id("ember1385")).isDisplayed());


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

            driver.findElement(By.cssSelector("input[placeholder=\"סיסמה\"]")).sendKeys("1Aa"+generatedString);
            driver.findElement(By.cssSelector("input[placeholder=\"אימות סיסמה\"]")).sendKeys("1Aa"+generatedString);

        }

        public  void Press_register()throws IOException{
            driver.manage().timeouts().implicitlyWait(10,
                    TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("button[gtm=\"הרשמה ל-BUYME\"]")).click();

        }



}
