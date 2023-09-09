package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd){
        super(wd);

    }
    public boolean isLogged(){ //проверка на залogiнился ли я
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }
    public void logout(){
        click(By.xpath("//*[.='Sign Out']"));
        // Sign Out

    }
    public void openLoginRegistrationForm(){
        wd.findElement(By.xpath("//*[.='LOGIN']")).click();
    }
    public void submitLogin(){
        wd.findElement(By.xpath("//button[1]")).click();
    }
    public void submitRegistration(){
        wd.findElement(By.xpath("//button[2]")).click();
    }
    public void fillLoginRegistrationForm(String email, String password) {
        type(By.xpath("//input[1]"), email);
        type(By.xpath("//input[2]"), password);
    }


}
