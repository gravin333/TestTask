package Pages;

import Hepler.SupportActions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnswerPage extends Page {
    SupportActions actions = null;
    public AnswerPage(AppiumDriver<WebElement> driver) {
        super(driver);
        actions = new SupportActions(driver);
    }

    @FindBy(xpath = "//div[@class='freebirdFormviewerViewResponseLinksContainer']")
    private WebElement sendOneMoreAnswerBtn;

    @FindBy(xpath = "//div[@class='freebirdFormviewerViewResponseConfirmContentContainer']")
    private WebElement answerFormContainer;

    public boolean OnAnswerPage(){
        actions.waitForElement(answerFormContainer,5);
        return answerFormContainer.isDisplayed();
    }


    public FormPage goToFormPage(){
        sendOneMoreAnswerBtn.click();
        return new FormPage(driver);
    }
}
