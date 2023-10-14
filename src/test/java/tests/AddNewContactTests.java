package tests;

import manager.ProviderData;
import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddNewContactTests extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if(!app.getHelperUser().isLogged()) app.getHelperUser().login(
                User.builder()
                        .email("love@gmail.com")
                        .password("abC250712#")
                        .build()

        );
    }


    @Test(invocationCount = 5, groups = {"positive", "smoke"})
    public  void addNewContactPositive (){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("John")
                .lastName("Silver")
                .phone("12345678"+i)
                .email("john_"+i+"@gmail.com")
                .address("Rehovot")
                .description("Pirate")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }
    @Test(invocationCount = 5, groups = {"positive", "smoke"}, dataProvider = "NewContactDTO", dataProviderClass = ProviderData.class)
    public  void addNewContactPositiveNewContactDTO (Contact contact){

        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperContact().isContactCreated(contact));
    }

}
