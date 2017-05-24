package meituanTest;

import base.Highlighter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

/**
 * Created by tyoko on 2017/4/7.
 */
public abstract class MeituanTests {

    @Rule
    public ScreenShooter screenShooter=ScreenShooter.failedTests();



    @BeforeClass
    public static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        System.setProperty("selenide.browser", "chrome");
        Configuration.browser="chrome";
        timeout=20000;
        baseUrl="http://meituan.com";
        startMaximized=false;
        addListener(new Highlighter());

        open("/");
    }

    @AfterClass
    public static void closeBrowser(){
        closeWebDriver();
    }

    protected void waitUntilIsLoaded(){

    }
}
