package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class AddUserPage {

    private WebDriver driver;

    private By firstName = By.name("FirstName");
    private By lastName = By.name("LastName");
    private By userName = By.name("UserName");
    private By password = By.cssSelector("input[name='Password']");
    private By radioButton = By.xpath("//input[@name='optionsRadios']");
    private By roleSelection = By.name("RoleId");
    private By email = By.name("Email");
    private By cellPhone = By.name("Mobilephone");

    private By saveButton = By.xpath("//button[@class='btn btn-success']");



    public AddUserPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterFirstName(String FirstName){
        driver.findElement(firstName).sendKeys(FirstName);
    }

    public void enterLastName(String LastName){
        driver.findElement(lastName).sendKeys(LastName);
    }

    public void enterUserName(String UserName){
        driver.findElement(userName).sendKeys(UserName);
    }

    public void enterPassword(String Password){
        driver.findElement(password).sendKeys(Password);
    }

    public void enterEmail(String Email){
        driver.findElement(email).sendKeys(Email);
    }

    public void enterCellphone(String Cellphone){
        driver.findElement(cellPhone).sendKeys(Cellphone);
    }

    public void clickRadioButton(Integer ValueOfRadioButton){
       int a = driver.findElements(radioButton).size();
       driver.findElements(radioButton).get(ValueOfRadioButton.intValue()).click();}

    public void clickRoleButton(String Role){
    Select rollDropDown = new Select(driver.findElement(roleSelection));
    rollDropDown.selectByVisibleText(Role);}

    public void clickSaveButton() {driver.findElement(saveButton).click();}

}
