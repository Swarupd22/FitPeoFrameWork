package com.sample.suites;

import com.sample.pages.FitPeoPage;
import com.sample.utils.DriverFactory;
import org.testng.annotations.*;

public class FitPeoTest {

    DriverFactory driverFactory;

    {
        try {
            driverFactory = DriverFactory.getInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    FitPeoPage fitPage = new FitPeoPage();

    @BeforeTest
    public void setUp() throws IllegalAccessException {
        driverFactory.setDriver("chrome");
        fitPage.openURL("https://www.fitpeo.com/");
    }

    @Test(priority = 0)
    public void openRevenueCalcPage() throws IllegalAccessException {
        fitPage.openRevenueCalc();
    }

    @Test(priority = 1)
    public void adjustSlider() {
        try {
            fitPage.scrollSlider();

            fitPage.clearText();

            Thread.sleep(3000);

            fitPage.sendText("560");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void checkBox() throws IllegalAccessException {
        fitPage.scrollUntilElementIsVisibleChkBox1();
        fitPage.selectCheckBox1();

        fitPage.selectCheckBox2();

        fitPage.scrollUntilElementIsVisibleChkBox3();
        fitPage.selectCheckBox3();

        fitPage.scrollUntilElementIsVisibleChkBox4();
        fitPage.selectCheckBox4();

        fitPage.estimationValidation("$110700");
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        DriverFactory.quitBrowser();
    }
}
