package com.sample.pages;

import com.sample.ccl.WebActions;
import org.openqa.selenium.By;

public class FitPeoPage {
    WebActions action = new WebActions();
    By revenueCalcButton = By.xpath("//div[text()='Revenue Calculator']");

    By slider = By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']");

    By textField = By.xpath("//input[@id=':r0:']");

    By checkBox1 = By.xpath("//span[text()='57']");

    By checkBox2 = By.xpath("//span[text()='19.19']");

    By checkBox3 = By.xpath("//span[text()='63']");

    By checkBox4 = By.xpath("//span[text()='15']");

    By totalEstimate = By.xpath("//p[@class='MuiTypography-root MuiTypography-body2 inter css-1xroguk'][4]//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj']");


    public void openURL(String URL) throws IllegalAccessException {
        action.openURL(URL);
        action.implicitWait();
        action.maximizeWindow();
    }

    public void openRevenueCalc() throws IllegalAccessException {
        action.Click(revenueCalcButton);
    }

    public void scrollUpToElementSlider() throws IllegalAccessException {
        action.scroll_up(slider);
    }

    public void scrollUpToElementTxtField() throws IllegalAccessException {
        action.scroll_up(textField);
    }

    public void clearText() throws IllegalAccessException {
        action.clear(textField);
    }

    public void sendText(String txt) throws IllegalAccessException {
        action.sendKeys(textField, txt);
    }

    public void scrollSlider() throws IllegalAccessException {
        action.clickAndHoldMoveByOffSet(slider, 94, 0);
    }

    public void selectCheckBox1() throws IllegalAccessException {
        action.Click(checkBox1);
    }

    public void scrollUntilElementIsVisibleChkBox1() throws IllegalAccessException {
        action.scroll_up(checkBox1);
    }

    public void selectCheckBox2() throws IllegalAccessException {
        action.Click(checkBox2);
    }

    public void selectCheckBox3() throws IllegalAccessException {
        action.Click(checkBox3);
    }

    public void scrollUntilElementIsVisibleChkBox3() throws IllegalAccessException {
        action.scroll_up(checkBox3);
    }

    public void scrollUntilElementIsVisibleChkBox4() throws IllegalAccessException {
        action.scroll_up(checkBox4);
    }

    public void selectCheckBox4() throws IllegalAccessException {
        action.Click(checkBox4);
    }

    public void estimationValidation(String txt) throws IllegalAccessException {
        action.totalEstimationValidation(totalEstimate, txt);
    }
}