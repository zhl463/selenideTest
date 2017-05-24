package meituanTest;

import base.Highlighter;
import com.codeborne.selenide.Condition;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


/**
 * Created by tyoko on 2017/4/7.
 */
public class ReadNet extends MeituanTests {

    @Test
    public void testLoading(){
        sleep(2000);
        $("#J-login").should(Condition.text("登录")).isDisplayed();
        Highlighter.highlight($("#J-login")).should(Condition.exist);
    }

    @Test
    public void testNavbarNum(){
        $$(".navbar__item-w ").shouldHaveSize(4);
        $$(".navbar__item-w ").get(0).should(Condition.text("首页")).isDisplayed();
    }
}
