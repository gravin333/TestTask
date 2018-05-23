package Pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Timer;

/**
 * Класс для работы с формой https://goo.gl/forms/t16Uov7ZHXCrB2ZE2
 */
public class FormPage extends Page {

    /**
     * Instantiates a new Form page.
     *
     * @param driver the driver
     */
    public FormPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        //заходим на страницу сразу при вызове конструктора
        goToPage();
    }

    /**
     * Переход на страницу https://goo.gl/forms/t16Uov7ZHXCrB2ZE2
     */
    public void goToPage() {
        driver.get("https://goo.gl/forms/t16Uov7ZHXCrB2ZE2");
    }

    //--------------------------------Елементы страницы для фабрики, начало---------------------------------------------

    @FindBy(xpath = "//div[@jsname='ibnC6b' and @data-validation-operation='102']")
    private WebElement emailContainer;

    @FindBy(xpath = "//input[@name='emailAddress' and @type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//div[@jsname='ibnC6b'and @jscontroller='qDmeqc']")
    private WebElement birthdayContainer;

    @FindBy(xpath = "/html/body[@class='freebirdLightBackground']/div[@class='freebirdFormviewerViewFormContentWrapper']/div[@class='freebirdFormviewerViewCenteredContent']" +
            "/form[@id='mG61Hd']" +
            "/div[@class='freebirdFormviewerViewFormCard']" +
            "/div[@class='freebirdFormviewerViewFormContent ']" +
            "/div[@class='freebirdFormviewerViewItemList']/div[@class='freebirdFormviewerViewItemsItemItem'][1]" +
            "/div[@class='freebirdFormviewerViewItemsDateDateInput']")
    private WebElement birthdayField;

    @FindBy(xpath = "//div[@jsname='ibnC6b' and @data-item-id='1645109785']")
    private WebElement nameContainer;

    @FindBy(xpath = "//input[@class='quantumWizTextinputPaperinputInput exportInput' and @name='entry.1375459729']")
    private WebElement nameField;

    @FindBy(xpath = "//div[@jscontroller='jmDACb' and @jsname='ibnC6b']")
    private WebElement genderContainer;

    @FindBy(xpath = "//div[@class='quantumWizMenuPaperselectEl docssharedWizSelectPaperselectRoot freebirdFormviewerViewItemsSelectSelect freebirdThemedSelectDarkerDisabled isOpen']")
    private WebElement genderListIsOpen;

    @FindBy(xpath = "//div[@jscontroller='hIYTQc' and @jsname='ibnC6b']")
    private WebElement moodContainer;

    @FindBy(xpath = "//div[@class='quantumWizButtonPaperbuttonEl quantumWizButtonPaperbuttonFlat quantumWizButtonPaperbuttonDark quantumWizButtonPaperbutton2El2 freebirdFormviewerViewNavigationSubmitButton']")
    public WebElement sendButton;

    @FindBy(xpath = "//div[@class='quantumWizMenuPaperselectOptionList']" +
            "/div[@class='quantumWizMenuPaperselectOption freebirdThemedSelectOptionDarkerDisabled exportOption isSelected isPlaceholder']")
            public WebElement genderBtn;

    @FindBy(xpath = "//div[@class='quantumWizMenuPaperselectEl docssharedWizSelectPaperselectRoot freebirdFormviewerViewItemsSelectSelect freebirdThemedSelectDarkerDisabled']")
    private WebElement setGenderBtn;

    @FindBy(xpath = "//input[@class='quantumWizTextinputSimpleinputInput exportInput']")
    private WebElement diffMoodField;

    @FindBy(xpath = "//div[@jsname='M2UYVd']")
    private WebElement sendFormBtn;

    //--------------------------------Елементы страницы для фабрики, конец----------------------------------------------


    /**
     * метод для записи текста в поле имейла
     *
     * @param emailAddress the email address
     */
    public void setEmail(String emailAddress){
        emailField.click();
        emailFieldIsFocused();
        driver.getKeyboard().sendKeys(emailAddress);
    }


    /**
     * метод для выбора текущей даты в датапикере
     */
    public void setCurrentDate(){
        clickOnBirthDayField();
        DataPicker dataPicker = new DataPicker(driver);
        dataPicker.clickSet();
    }

    /**
     * очистка поля от даты с помощью датапикера
     */
    public void clearCurrentDateField(){
        clickOnBirthDayField();
        DataPicker dataPicker = new DataPicker(driver);
        dataPicker.clickClear();
    }

    /**
     * Click on birth day field.
     */
    public void clickOnBirthDayField(){
        birthdayField.click();
    }

    /**
     * проверка ячейки даты на валидность
     *
     * @return the boolean
     */
    public boolean birthDayIsCorrect(){
        return cellIsCorrect(birthdayContainer);
    }

    /**
     * метод для записи текста в поле имени
     *
     * @param name the name
     */
    public void setName(String name){
        nameField.click();
        nameFieldIsFocused();
        driver.getKeyboard().sendKeys(name);
    }

    /**
     * вызов списка "пол" и выбор пункта по позиции от 0 до 2
     *
     * @param position the position
     */
    public void setGender(int position) {
        setGenderBtn.click();
        //ожидание и поздний поиск елемента, елементы создаються после нажатия на контрол
        actions.waitForElement(genderListIsOpen,5);
        List<WebElement> elements =  driver.findElements(By.xpath("//div[@class='exportSelectPopup quantumWizMenuPaperselectPopup']/div[@jsname='wQNmvb']"));
        WebElement el = elements.get(position);
        el.click();
    }

    /**
     * получение списка чекбоктов настрония и выбор по позиции от 0 до 6
     *
     * @param position the position
     */
    public void setMood(int position){
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='exportLabelWrapper']"));
        elements.get(position).click();
    }


    /**
     * общий метод для проверки елемента на наличие HasError в атрибуте class
     *
     * @return the boolean
     */
    private boolean cellIsCorrect(WebElement element){
        if(!element.getAttribute("class").contains("HasError")) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * проверка ячейки имейла на наличие HasError
     *
     * @return the boolean
     */
    public boolean emailIsCorrect(){
        return cellIsCorrect(emailContainer);
    }

    /**
     * проверка ячейки имени на наличие HasError
     *
     * @return the boolean
     */
    public boolean nameIsCorrect() {
        return cellIsCorrect(nameContainer);
    }

    /**
     * проверка ячейки "пол" на наличие HasError
     *
     * @return the boolean
     */
    public boolean genderIsCorrect(){
        return cellIsCorrect(genderContainer);
    }

    /**
     * проверка ячейки настроения на наличие HasError
     *
     * @return the boolean
     */
    public boolean moodIsCorrect(){
        return cellIsCorrect(moodContainer);
    }

    /**
     * проверка ячейки "другое" на наличие HasError
     *
     * @return the boolean
     */
    public boolean differentMoodFieldIsFocused() {
        return driver.findElement(By.xpath("//div[@class='quantumWizTextinputSimpleinputEl freebirdThemedInput freebirdFormviewerViewItemsCheckboxOtherInputElement isFocused']")).isDisplayed();
    }

    /**
     * провека поля "имя" на фокус
     *
     * @return the boolean
     */
    public boolean nameFieldIsFocused(){
        return driver.findElement(By.xpath("//div[@class='quantumWizTextinputPaperinputEl freebirdFormviewerViewItemsTextShortText freebirdThemedInput modeLight isFocused']")).isDisplayed();
    }

    /**
     * провека поля "имейл" на фокус
     *
     * @return the boolean
     */
    public boolean emailFieldIsFocused(){
        return driver.findElement(By.xpath("//div[@class='quantumWizTextinputPaperinputEl freebirdFormviewerViewItemsTextShortText freebirdFormviewerViewItemsTextEmail freebirdThemedInput modeLight isFocused']")).isDisplayed();
    }

    /**
     *  выбор поля для ввода настроения "другое" и запись текста в поле
     *
     * @param descriptionMood the description mood
     */
    public void setDifferentMoodDescription(String descriptionMood) {
        diffMoodField.click();
        differentMoodFieldIsFocused();
        driver.getKeyboard().sendKeys(descriptionMood);
    }

    /**
     * отправка формы
     *
     * @return the answer page
     */
    public AnswerPage sendForm() {
        sendFormBtn.click();
        return new AnswerPage(driver);
    }

    /**
     * проверка формы записаной в базу
     */
    public void checkDataBase() {
        // getDataBase() получить данные с таблицы
        // compare() сравнить правильность данных
    }
}
