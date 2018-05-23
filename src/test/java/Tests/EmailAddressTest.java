package Tests;

import Pages.FormPage;
import Pages.TestFrame;
import org.testng.Assert;
import org.testng.annotations.*;

public class EmailAddressTest extends TestFrame {

    //тесткейсы лежать по пути ./TestCases/EmailCell/README.md


    FormPage form = null;

    @Test(priority = 1)
    public void setCorrectEmail(){
        form = new FormPage(driver);
        form.setEmail("gravin1904@gmail.com");
        Assert.assertTrue(form.emailIsCorrect());
    }

    @Test
    public void setCorrectEmailWithTwoDomainsName(){
        form = new FormPage(driver);
        form.setEmail("gravin1904@gmail.com.ua");
        Assert.assertTrue(form.emailIsCorrect());
    }

    @Test(priority = 2)
    public void setIncorrectEmail(){
        form = new FormPage(driver);
        form.setEmail("gravin1904@");
        Assert.assertFalse(form.emailIsCorrect());
    }

    @Test
    public void setEmailWithTwoATs(){
        form = new FormPage(driver);
        form.setEmail("gravin1904@@gmail.com");
        Assert.assertFalse(form.emailIsCorrect());
    }

    @Test
    public void setEmailWithTwoDots(){
        form = new FormPage(driver);
        form.setEmail("gravin1904@gmail..com");
        Assert.assertFalse(form.emailIsCorrect());
    }
}
