package tyokoTest;

/**
 * Created by tyoko on 2017/4/6.
 */
import org.junit.Test;
import org.openqa.selenium.By;

import static base.Highlighter.highlight;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;



public class NewMailSpec extends GmailTests {
    @Test
    public void userCanComposeEmail() {
        $(byText("写邮件")).click();
        waitUntilPagesIsLoaded();
        $(By.name("to")).val("andrei.solntsev@gmail.com").pressTab();
        $(by("placeholder", "Subject")).val("Devoxx demo").pressTab();

        $(".editable").val("We are not afraid of ajax anymore.").pressEnter();
        $(byText("Send")).click();

        $(withText("Your message has been sent.")).shouldBe(visible);
        $(byText("Undo")).click();
        // highlight($(byText("Sending has been undone.")).should(appear));

        $(".editable").should(appear).append("Hello from Antwerp").pressEnter().pressEnter();

        $(byText("Send")).click();
        highlight($(withText("Your message has been sent.")).should(appear));
        highlight($(byText("Undo")).should(appear)).waitUntil(disappears, 12000);

        assertUserCanSeeSentEmails();
    }

    private void assertUserCanSeeSentEmails() {
        $(byText("Sent Mail")).click();
        highlight($(byText("Devoxx demo")).shouldBe(visible));
    }
}
