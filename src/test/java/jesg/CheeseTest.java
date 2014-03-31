package jesg;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheeseTest {
    
    private static PhantomJSDriverService PHANTOMJS_SERVICE;
    private WebDriver driver;
    
    @BeforeClass
    public static void before() throws IOException{
        PHANTOMJS_SERVICE = PhantomJSDriverService.createDefaultService();
        PHANTOMJS_SERVICE.start();
    }
    
    @AfterClass
    public static void cleanUp(){
        PHANTOMJS_SERVICE.stop();
    }

    @Before
    public void setUp() throws Exception {
        driver = new PhantomJSDriver(PHANTOMJS_SERVICE, DesiredCapabilities.phantomjs());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testCheese() {
        query("cheese");
    }
    
    @Test
    public void test42() {
        query("42");
    }
    
    private void query(String query) {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.name("btnG")).click();
        (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .titleContains(query));
    }
}
