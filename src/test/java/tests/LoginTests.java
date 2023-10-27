package tests;

import manager.NGListner;
import manager.ProviderData;
import model.Contact;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//import model.User;

@Listeners(NGListner.class)
public class LoginTests extends TestBase {

    // WebDriver wd;


    @Test(groups = {"positive"})
    public void loginPositiveTest() {

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

        app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());


        //click on button login
        // wd.findElement(By.xpath("//button[1]")).click();
        app.getHelperUser().submitLogin();
        //assert
        //   app.getHelperUser().pause(3000);
        //Assert.assertTrue(wd.findElements(By.tagName("button")).size() > 0);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));


    }

    @Test (groups = {"positive"})
    public void loginPositiveTestModel() {
        Contact contact = Contact.builder().build();

      //  User user = User.builder().email("love@gmail.com")
        //        .password("abC250712#").build();
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());

        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));


        }
    @Test (groups = {"positive"})
    public void loginPositiveTestProps() {


        //  User user = User.builder().email("love@gmail.com")
        //        .password("abC250712#").build();
        app.getHelperUser().openLoginRegistrationForm();

        app.getHelperUser().fillLoginRegistrationForm(app.getEmail(), app.getPassword());

        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(3000);

        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));


    }
    @Test(groups = {"positive"}, dataProvider = "userDTO", dataProviderClass = ProviderData.class)
    public void loginPositiveUserDTO(User user){
        // open login form
        app.getHelperUser().openLoginRegistrationForm();
        // fill login form
        app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
        // click on button login
        app.getHelperUser().submitLogin();
        // assert
        app.getHelperUser().pause(3000);
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.tagName("button")));
        app.getHelperUser().logout();
    }

        @Test(groups = {"negative", "smoke"})
        public void loginNegativeTestWrongEmail () {
            User user = new User("lovegmail.com", "abC250712#");

            //open login form
            app.getHelperUser().openLoginRegistrationForm();
            //  wd.findElement(By.xpath("//*[.='LOGIN']")).click();
            //fill login form
            app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
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
        @Test(groups = {"negative"})
        public void loginNegativeTestWrongPassword() {
            User user = new User("love@gmail.com", "abC121314");
            app.getHelperUser().openLoginRegistrationForm();
            app.getHelperUser().fillLoginRegistrationForm(user.getEmail(), user.getPassword());
            app.getHelperUser().submitLogin();
            Assert.assertTrue(app.getHelperUser().isAlertPresent());
        }
    }


