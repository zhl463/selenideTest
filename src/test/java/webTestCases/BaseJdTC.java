package webTestCases;


import base.Highlighter;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static base.Highlighter.highlight;
import static com.codeborne.selenide.Configuration.reportsUrl;
import static com.codeborne.selenide.Configuration.startMaximized;

import com.codeborne.selenide.testng.annotations.Report;
import org.junit.After;
import org.junit.Before;
import pageObj.PageLogin;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

/**
 * Created by apple on 2017/5/23.
 */
public class BaseJdTC {
//    声明基础url
    private String baseUrl="http://www.jd.com";
//    开始前的准备
    @Before
    public void beforeOpen(){
        addListener(new Highlighter());//添加高亮的监控
        //更改浏览器为chrome
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        System.setProperty("selenide.browser","chrome");
        Configuration.browser="chrome";
//        最大化窗口
        startMaximized=false;
//        打开url地址
        open(baseUrl);
    }
//    结束
    @After
    public void closeBrowser(){
        closeWebDriver();
    }


    //    正常登录流程
    public static void loginFlow(String name,String pwd){
        highlight($(byText(PageLogin.loginText)).should(Condition.appear));
        $(byText(PageLogin.loginText)).click();
        $(PageLogin.loginNameLable).sendKeys(name);
        $(PageLogin.loginPwdLable).sendKeys(pwd);
        $(PageLogin.loginBtn).click();
    }
}
