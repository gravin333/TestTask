package Pages;

import Hepler.SupportActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataPicker extends Page {

    SupportActions actions = null;

    public DataPicker(AppiumDriver driver) {
        super(driver);
        actions = new SupportActions(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //изменение контекста аппиума для работы с нативными  контролами
        actions.changeContextToNATIVE_APP();
    }

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement setBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button2']")
    private WebElement cancelBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='android:id/button3']")
    private WebElement clearBtn;

    @FindBy(id = "android:id/date_picker_header_year" )
    private WebElement yearListId;

    @FindBy(id = "android:id/date_picker_year_picker")
    private WebElement listOfYears;

    public void clickSet(){
        setBtn.click();
        //изменение контекста аппиума
        actions.changeContextToCHROMIUM();
    }

    public void openYearListAndSelectYear(String year){
        yearListId.click();
        driver.findElement(By.name(year)).click();
    }

    public void clickClear(){
        clearBtn.click();
        //изменение контекста аппиума
        actions.changeContextToCHROMIUM();
    }

}
