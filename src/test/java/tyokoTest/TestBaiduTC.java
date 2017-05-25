package tyokoTest;

import base.Highlighter;
import com.codeborne.selenide.Configuration;

import org.junit.Before;
import org.junit.Test;


import static base.Highlighter.highlight;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.addListener;



/**
 * Created by tyoko on 2017/2/17.
 */
public class TestBaiduTC {
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        System.setProperty("selenide.browser", "chrome");
        Configuration.browser="chrome";

//        System.setProperty("webdriver.chrome.driver", Constants.GETCHROMEDRIVERPATH_STRING);
        open("http://www.baidu.com");

    }

    @Test
    public void setValueTest() throws Exception {
        addListener(new Highlighter());
//        sleep(2000);
        $("#kw").setValue("selenide").pressEnter();
        $("#kw").append(" test").pressEnter();
        highlight($("#kw")).should(appear);
        sleep(2000);


    }
    

    @After
    public void tearDown() throws Exception {
        closeWebDriver();
    }

}
