package com.sample.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static volatile DriverFactory instance;
    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<>();

    private DriverFactory() {
    }

    public final void setDriver(String browser) throws IllegalAccessException {
        switch (browser) {
            case "chrome":
                tDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tDriver.set(new FirefoxDriver());
                break;
            case "edge":
                tDriver.set(new EdgeDriver());
                break;
            default:
                throw new IllegalAccessException("UnSupported browser : " + browser);
        }
    }

    public static DriverFactory getInstance() throws IllegalAccessException {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        return tDriver.get();
    }

    public static void quitBrowser() {
        if (tDriver.get() != null) {
            tDriver.get().quit();
            tDriver.remove();
        }
    }
}