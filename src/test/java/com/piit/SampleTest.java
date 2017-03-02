package com.piit;

//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fuadkhan on 3/1/2017.
 */
public class SampleTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception{
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "47.0");
//       System.setProperty("webdriver.gecko.driver","C:\\Users\\Fuadkhan\\Desktop\\geckodriver.exe");
        driver = new RemoteWebDriver(new URL("https://fuadkhan:7f56114c-06b2-46e4-bdd5-bfe48b1e5c7a@ondemand.saucelabs.com:443/wd/hub"),caps);
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void loginPnt()throws Exception{
        driver.get("http://forum.piit.us/");
        driver.findElement(By.xpath(".//*[@id='frmLogin']/div/div[3]/dl/dd[1]/input")).sendKeys("testuser");
        driver.findElement(By.xpath(".//*[@id='frmLogin']/div/div[3]/dl/dd[2]/input")).sendKeys("tset123");
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='frmLogin']/div/div[3]/p/input")).click();

    }

}
