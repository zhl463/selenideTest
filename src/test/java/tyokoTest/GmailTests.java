package tyokoTest;

/**
 * Created by tyoko on 2017/4/6.
 */
import base.Highlighter;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.codeborne.selenide.Condition.disappears;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public abstract class GmailTests {
    private static String gmailUsername = System.getProperty("gmail.username", "tyoko463@gmail.com");
    private static String gmailPassword = System.getProperty("gmail.password", "hl6689513");

    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();

    @BeforeClass
    public static void openInbox() {
        timeout = 10000;
        baseUrl = "http://gmail.com";
        startMaximized = false;
        addListener(new Highlighter());
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        System.setProperty("selenide.browser", "chrome");
        Configuration.browser="chrome";
        open("/");
        login();
        waitUntilPagesIsLoaded();
    }

    protected static void waitUntilPagesIsLoaded() {
        $(byText("Loading")).waitUntil(disappears, 20000);
    }

    @AfterClass
    public static void logout() {
        closeWebDriver();
    }

    private static void login() {
        $("#Email").val(gmailUsername).pressEnter();
        $("#Passwd").val(gmailPassword);
        $("#signIn").click();
        $(".error-msg").waitUntil(disappears, 2000);
    }
}