package Tests;

import Pages.FormPage;
import Pages.TestFrame;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NameTest extends TestFrame {

    //тесткейсы лежать по пути ./TestCases/NameCell/README.md

    FormPage form = null;

    @Test
    public void setNormalName(){
        form = new FormPage(driver);
        form.setName("Vladimir");
        Assert.assertTrue(form.nameIsCorrect());
    }

    @Test
    public void setNameWithNineteenSymbols(){
        form = new FormPage(driver);
        form.setName("1234567890123456789");
        Assert.assertTrue(form.nameIsCorrect());
    }

    @Test
    public void setNameWithTwentiethSymbols(){
        form = new FormPage(driver);
        form.setName("12345678901234567890");
        Assert.assertTrue(form.nameIsCorrect());
    }

    @Test
    public void setNameWithTwentyOneSymbols(){
        form = new FormPage(driver);
        form.setName("123456789012345678901");
        Assert.assertFalse(form.nameIsCorrect());
    }

}
