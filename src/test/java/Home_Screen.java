import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Home_Screen {
    private static WebDriver driver;

    public Home_Screen(ChromeDriver driver)throws IOException {
        this.driver = driver;
    }

    public void Pick_price_point()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        System.out.println("size = "+driver.findElements(By.xpath("//*[@id='ember927']")).size());
        driver.findElement(By.xpath("//span[.='סכום']")).click();
        driver.findElements(By.className("active-result")).get(1).click();

    }


    public void Pick_region()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[.='אזור']")).click();
        driver.findElements(By.className("active-result")).get(1).click();
    }

    public void Pick_category()throws IOException{
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[.='קטגוריה']")).click();
        driver.findElements(By.className("active-result")).get(1).click();
    }

    public void find_me_a_present()throws IOException {
        driver.manage().timeouts().implicitlyWait(10,
                TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[rel=\"nofollow\"]")).click();

    }

}
