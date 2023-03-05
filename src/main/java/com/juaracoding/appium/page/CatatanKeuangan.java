package com.juaracoding.appium.page;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CatatanKeuangan {

    public AndroidDriver<MobileElement> driver;

    public CatatanKeuangan(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    // Locator
    @AndroidFindBy (id = "com.chad.financialrecord:id/fabMenu")
    private MobileElement btnTambahtransaksi;
    @AndroidFindBy (id = "com.chad.financialrecord:id/spCategory")
    private MobileElement listKategori;
    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement pendidikan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement btnJumah;

    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement btnKetereangan;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSimpan;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnIncome;

    // locator result
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private MobileElement result1;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    private MobileElement result2;


    //tambah pemasukan
    public void tambahPengeluaran(){
        btnTambahtransaksi.click();
        listKategori.click();
        delay(2);
        pendidikan.click();
        btnJumah.sendKeys("5000000");
        btnKetereangan.sendKeys("Bootcam");
        btnSimpan.click();

    }
    public void tambahPemasukan(){
        btnTambahtransaksi.click();
        btnIncome.click();
        btnJumah.sendKeys("8000000");
        btnKetereangan.sendKeys("Gaji");
        btnSimpan.click();
    }


    public String getTxtResult1() {
        return result1.getText();
    }

    public  String getTxtResult2(){
        return  result2.getText();
    }



    static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
