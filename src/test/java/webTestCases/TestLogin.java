package webTestCases;

import base.Highlighter;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObj.PageJdIndex;
import pageObj.PageLogin;

import static base.Highlighter.highlight;
import static com.codeborne.selenide.Configuration.startMaximized;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

/**
 * Created by apple on 2017/5/23.
 */
public class TestLogin extends BaseJdTC {
    String loginName="test123@163.com";
    String passwd="test123";

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
        highlight($(byText("账户登录")).should(Condition.appear));
        $(byText("账户登录")).click();
        $("#loginname").sendKeys(name);
        $("#nloginpwd").sendKeys(pwd);
        $("#loginsubmit").click();
    }
//    开始测试

    @Test
    public void testLoginFailure(){
        highlight($(".link-login")).should(Condition.appear);
        $(".link-login").click();

        loginFlow(loginName,passwd+"9");

        $(".msg-error").should(Condition.appear);
        $(".msg-error").should(Condition.matchText("账户名与密码不匹配，请重新输入"));
    }


}
