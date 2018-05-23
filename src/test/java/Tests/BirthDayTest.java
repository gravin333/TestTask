package Tests;

import Pages.FormPage;
import Pages.TestFrame;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BirthDayTest extends TestFrame {

    //тесткейсы лежать по пути ./TestCases/BirthDayCell/README.md

    FormPage form = null;

    @Test
    public void setCorrectBirthdayDate(){
        form = new FormPage(driver);
        form.setCurrentDate();
        Assert.assertTrue(form.birthDayIsCorrect());
    }

    @Test
    public void setIncorrectBirthdayDate(){
        form = new FormPage(driver);
        form.setCurrentDate();
        form.clearCurrentDateField();
        Assert.assertFalse(form.birthDayIsCorrect());
    }
}
