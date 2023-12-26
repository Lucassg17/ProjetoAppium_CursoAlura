package com.alura.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverConfig {
    public final AndroidDriver driver;
    public AppiumDriverConfig() throws MalformedURLException {
        //classes do appium - Appium driver para conversar com o meu emulador
        //wd/hub é a rota para se conectar

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus_4_API_34");
        options.setApp("C:\\Users\\Lucas Gomes\\ProjetoAppium\\AluraAppium\\src\\main\\resources\\alura_esporte.apk");

        URL urlConexao = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(urlConexao, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(13));
    }
}
