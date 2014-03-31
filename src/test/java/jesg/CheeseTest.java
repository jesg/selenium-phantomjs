package jesg;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheeseTest {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new PhantomJSDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testCheese() {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("cheese");
        driver.findElement(By.name("btnG")).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .titleContains("cheese"));
    }

}
