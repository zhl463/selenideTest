package webTestCases;

import com.codeborne.selenide.Condition;
import org.junit.Test;
import pageObj.PageRegister;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by apple on 2017/5/23.
 */
public class RegisterTC extends BaseJdTC {
    long time=System.currentTimeMillis()/100;
    @Test
    public void registerTest(){
        open("https://reg.jd.com/reg/person");
        $(PageRegister.accountLable).sendKeys("zhl"+time);
        $(PageRegister.passedLable).sendKeys("a123456..");
        $(PageRegister.varifyPwdLable).sendKeys("a123456..");
        $(PageRegister.phoneLable).sendKeys(time+"");
        $(PageRegister.autoCodeLable).sendKeys("1243");
        $(PageRegister.phoneCodeLable).sendKeys("4322");
        $(PageRegister.registerBtn).click();

        $(PageRegister.phoneCodeErr).should(Condition.appear);


    }
}
