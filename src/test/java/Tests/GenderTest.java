package Tests;

import Pages.FormPage;//label[@class='docssharedWizToggleLabeledContainer freebirdFormviewerViewItemsCheckboxContainer']
import Pages.TestFrame;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GenderTest extends TestFrame {

    //тесткейсы лежать по пути ./TestCases/GenderCell/README.md

    FormPage form = null;

    @Test(priority = 1)
    public void setMaleGender(){
        form = new FormPage(driver);
        form.setGender(1);
        Assert.assertTrue(checkContainer());
    }

    @Test(priority = 1)
    public void setFemaleGender(){
        form = new FormPage(driver);
        form.setGender(2);
        Assert.assertTrue(checkContainer());
    }

    @Test(priority = 2)
    public void setMaleAndSetEmptyGender(){
        form = new FormPage(driver);
        form.setGender(1);
        form.setGender(0);
        Assert.assertFalse(checkContainer());
    }

    @Test(priority = 2)
    public void setFemaleAndSetEmptyGender(){
        form = new FormPage(driver);
        form.setGender(2);
        form.setGender(0);
        Assert.assertFalse(checkContainer());
    }

    private boolean checkContainer(){
        return form.genderIsCorrect();
    }
}
