package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    
    private WebDriver driver;

    private By addUserButton = By.xpath("//button[@class='btn btn-link pull-right']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public AddUserPage clickAddUser() {
        driver.findElement(addUserButton).click();
        return new AddUserPage(driver);

    }
}
