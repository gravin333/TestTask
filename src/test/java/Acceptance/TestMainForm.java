package Acceptance;

import Pages.AnswerPage;
import Pages.FormPage;
import Pages.TestFrame;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMainForm extends TestFrame {

    FormPage formPage = null;
    AnswerPage answerPage = null;

    @Test()
    public void setFormCorrectlyAndSend(){
        formPage = new FormPage(driver);
        formPage.setEmail("gravin1904@gmail.com");
        formPage.setCurrentDate();
        formPage.setName("Vladimir");
        formPage.setGender(1);
        formPage.setDifferentMoodDescription("All is OK");
        answerPage = formPage.sendForm();
        answerPage.OnAnswerPage();
        formPage = answerPage.goToFormPage();
    }

    @Test
    public void sendEmptyForm(){
        formPage = new FormPage(driver);
        formPage.sendForm();
        Assert.assertFalse(formPage.emailIsCorrect());
        Assert.assertFalse(formPage.birthDayIsCorrect());
        Assert.assertFalse(formPage.nameIsCorrect());
        Assert.assertFalse(formPage.genderIsCorrect());
        Assert.assertFalse(formPage.moodIsCorrect());
    }

}
