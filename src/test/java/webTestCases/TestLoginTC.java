package webTestCases;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import pageObj.PageJdIndex;
import pageObj.PageLogin;

import static base.Highlighter.highlight;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by apple on 2017/5/23.
 */
public class LoginTC extends BaseJdTC {
    String loginName="test123@163.com";
    String passwd="test123";
//    开始测试

    @Test
    public void testLoginFailure(){
        highlight($(PageJdIndex.loginTX)).should(Condition.appear);
        $(PageJdIndex.loginTX).click();

        loginFlow(loginName,passwd+"9");

        $(PageLogin.loginErr).should(Condition.appear);
        $(PageLogin.loginErr).should(Condition.matchText("账户名与密码不匹配，请重新输入"));
    }


}
