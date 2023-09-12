package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

  // WebDriver wd;


    @Test
   public void loginPositiveTest(){
        User user = new User("love@gmail.com", "abC250712#");
            app.getHelperUser().openLoginRegistrationForm();
        //open login form
       // wd.findElement(By.xpath("//*[.='LOGIN']")).click();

        //fill login form
       // WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
      //  emailInput.click();
        //emailInput.clear();
       // emailInput.sendKeys("love@gmail.com");

       // WebElement passInput = wd.findElement(By.xpath("//input[2]"));
       // passInput.click();
       // passInput.clear();
       // passInput.sendKeys("abC250712#");

        app.getHelperUser().fillLoginRegistrationForm(user);


        //click on button login
       // wd.findElement(By.xpath("//button[1]")).click();
       app.getHelperUser().submitLogin();
        //assert
     //   app.getHelperUser().pause(3000);
        //Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
     Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));




    }
     @Test
   public void loginNegativeTestWrongEmail() {

        //open login form
         app.getHelperUser().openLoginRegistrationForm();
      //  wd.findElement(By.xpath("//*[.='LOGIN']")).click();
        //fill login form
         app.getHelperUser().fillLoginRegistrationForm("lovegmail.com", "abC250712#");
        //WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
        //emailInput.click();
        //emailInput.clear();
        //emailInput.sendKeys("lovegmail.com");

       // WebElement passInput = wd.findElement(By.xpath("//input[2]"));
        //passInput.click();
      //  passInput.clear();
       // passInput.sendKeys("abC250712#");

        //click on button login
         app.getHelperUser().submitLogin();
       // wd.findElement(By.xpath("//button[1]")).click();
        //assert
      //  pause(3000);
      //  Assert.assertTrue(isAlertPresent());
         Assert.assertTrue(app.getHelperUser().isAlertPresent());

     }
    @Test
     public void loginNegativeTestWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("love@gmail.com", "abC121314");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent());
    }
}

