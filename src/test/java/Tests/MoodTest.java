package Tests;

import Pages.FormPage;
import Pages.TestFrame;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodTest extends TestFrame {

    //тесткейсы лежать по пути ./TestCases/MoodCell/README.md

    FormPage form = null;

    @Test
    public void checkMoodAsPerfect(){
        form = new FormPage(driver);
        form.setMood(0);
        Assert.assertTrue(form.moodIsCorrect());
    }

    @Test
    public void checkAndUncheckMoodAsPerfect(){
        form = new FormPage(driver);
        form.setMood(0);
        form.setMood(0);
        Boolean result = form.moodIsCorrect();
        Assert.assertFalse(result);
    }

    @Test
    public void checkMoodAsGood(){
        form = new FormPage(driver);
        form.setMood(1);
        Assert.assertTrue(form.moodIsCorrect());
    }

    @Test
    public void checkAndUncheckMoodAsGood(){
        form = new FormPage(driver);
        form.setMood(1);
        form.setMood(1);
        Assert.assertFalse(form.moodIsCorrect());
    }

    @Test
    public void checkMoodAsNormal(){
        form = new FormPage(driver);
        form.setMood(2);
        Assert.assertTrue(form.moodIsCorrect());
    }

    @Test
    public void checkAndUncheckMoodAsNormal(){
        form = new FormPage(driver);
        form.setMood(2);
        form.setMood(2);
        Assert.assertFalse(form.moodIsCorrect());
    }

    @Test
    public void checkMoodAsOK(){
        form = new FormPage(driver);
        form.setMood(3);
        Assert.assertTrue(form.moodIsCorrect());
    }

    @Test
    public void checkAndUncheckMoodAsOK(){
        form = new FormPage(driver);
        form.setMood(3);
        form.setMood(3);
        Assert.assertFalse(form.moodIsCorrect());
    }

    @Test
    public void checkMoodAsBad(){
        form = new FormPage(driver);
        form.setMood(4);
        Assert.assertTrue(form.moodIsCorrect());
    }

    @Test
    public void checkAndUncheckMoodAsBad(){
        form = new FormPage(driver);
        form.setMood(4);
        form.setMood(4);
        Assert.assertFalse(form.moodIsCorrect());
    }

    @Test
    public void checkMoodAsDifferent(){
        form = new FormPage(driver);
        form.setMood(5);
        Assert.assertTrue(form.differentMoodFieldIsFocused());
        Assert.assertFalse(form.moodIsCorrect());
    }

    @Test
    public void checkAndUncheckMoodAsDifferent(){
        form = new FormPage(driver);
        form.setMood(5);
        form.setMood(5);
        Assert.assertFalse(form.differentMoodFieldIsFocused());
        Assert.assertFalse(form.moodIsCorrect());
    }

}
