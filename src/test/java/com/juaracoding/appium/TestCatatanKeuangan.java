package com.juaracoding.appium;

import com.juaracoding.appium.page.CatatanKeuangan;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCatatanKeuangan {
    private static AndroidDriver<MobileElement> driver;
    private CatatanKeuangan catatanKeuangan;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_2_API_24");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        capabilities.setCapability("autoGrantPermissions","true");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        MobileElement tombolTutup = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"TUTUP\")");
        tombolTutup.click();
    }
    @BeforeMethod
    public void pageObject(){
        catatanKeuangan = new CatatanKeuangan(driver);
    }

    @Test(priority = 1)
    public void testinputPengeluaran(){
        catatanKeuangan.tambahPengeluaran();
        System.out.println("Hasil = "+catatanKeuangan.getTxtResult2());
        Assert.assertEquals(catatanKeuangan.getTxtResult2(),"5.000.000");
    }
    @Test(priority = 2)
    public void testinputPemasukan(){
        catatanKeuangan.tambahPemasukan();
        System.out.println("Hasil = "+catatanKeuangan.getTxtResult1());
        Assert.assertEquals(catatanKeuangan.getTxtResult1(),"8.000.000");
    }
    @AfterClass
    public void closeApp() {
        driver.quit();
    }

}
