package tests;

import manager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {






   @Test
   public void registrationPositiveTest() {
       //open login form
       app.getHelperUser().openLoginRegistrationForm();
       //  wd.findElement(By.xpath("//*[.='LOGIN']")).click();
       //fill login form
       app.getHelperUser().fillLoginRegistrationForm("bsk_" + app.getHelperUser().random() + "@gmail.com", "abC121314#");
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
       app.getHelperUser().submitRegistration();
       //  wd.findElement(By.xpath("//button[2]")).click();
       //assert
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));


       //   Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);


   }

}