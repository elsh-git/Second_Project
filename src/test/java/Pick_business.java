import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Pick_business {
    private WebDriver driver;

    public Pick_business(WebDriver driver)throws IOException {
        this.driver = driver;
    }
    public void Assert_website_URL()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://buyme.co.il/search?budget=1&category=204&region=13" );
    }
    public void Pick_buisness()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("img[title=\"שגב\"]")).click();

    }
    public void Enter_or_choose_price()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[placeholder=\"הכנס סכום\"]")).sendKeys("500");

    }
    public void Press_to_choose()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("button[gtm=\"בחירה\"]")).click();

    }



}
