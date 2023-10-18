package tests;

import manager.ProviderData;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }



   @Test(groups = {"positive"})
   public void registrationPositiveTest() {
       int i = (int)(System.currentTimeMillis()/1000)%3600;
       String email = "jessy"+ i +"@gmail.com";
       String password = "abC121212#";
       User user = new User("jessy"+ i +"@gmail.com", "abC121212#");
       //open login form
       app.getHelperUser().openLoginRegistrationForm();
       //  wd.findElement(By.xpath("//*[.='LOGIN']")).click();
       //fill login form
       app.getHelperUser().fillRegistrationForm(user);
       //int i = (int) (System.currentTimeMillis() / 1000) % 360;
       app.getHelperUser();

       //WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
       //emailInput.click();
       //emailInput.clear();
       //emailInput.sendKeys("bsk_" + i + "@gmail.com");

       //  WebElement passInput = wd.findElement(By.xpath("//input[2]"));
       //  passInput.click();
       //  passInput.clear();
       //    passInput.sendKeys("abC250712#");

       //click on button registration
       logger.info("registrationPositiveTest starts with:"+ email+ " and "+ password );
       app.getHelperUser().submitRegistration();
       //  wd.findElement(By.xpath("//button[2]")).click();
       //assert
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));


       //   Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);


   }
    @Test(groups = {"positive"}, dataProvider = "registrationCSV", dataProviderClass = ProviderData.class)
    public void registrationPositiveTestCSV(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillRegistrationForm(email, password);
                // fillLoginRegistrationForm(email, password);
        app.getHelperUser().submitRegistration();
        logger.info("registrationPositiveTest starts with:" + email + " & " + password);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
    }









}