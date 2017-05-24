package tyokoTest;

/**
 * Created by tyoko on 2017/4/6.
 */
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InboxSpec extends GmailTests {
    @Test
    public void showsNumberOfUnreadMessages() {
        $(By.xpath("//div[@role='navigation']")).find(withText("Inbox")).shouldBe(visible);
    }

    @Test
    public void inboxShowsUnreadMessages() {
        $$(byText("Gmail Team")).filter(visible).shouldHave(size(1));
        $$(byText("LastPass")).filter(visible).shouldHave(size(1));
        $$(byText("Pivotal Tracker")).filter(visible).shouldHave(size(1));
    }

    @Test
    public void userCanRefreshMessages() {
        $(by("title", "Refresh")).click();
    }
}
