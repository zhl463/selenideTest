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
    
    //    开始前的准备
    @Before
    public void setUp() throws Exception{
        
        //更改浏览器为chrome
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        System.setProperty("selenide.browser","chrome");
        Configuration.browser="chrome";
//        打开url地址
        open("https://passport.jd.com/new/login.aspx");
    }

//    开始测试

    @Test
    public void testLoginFailure(){
        addListener(new Highlighter());//添加高亮的监控
        

        //highlight($(byText("账户登录")).should(Condition.appear));
        $(byText("账户登录")).click();
        $("#loginname").setValue("test123@163.com");
        $("#nloginpwd").setValue("test123");
        $("#loginsubmit").click();

        $(".msg-error").should(Condition.appear);
        $(".msg-error").should(Condition.matchText("账户名与密码不匹配，请重新输入"));
    }


}
