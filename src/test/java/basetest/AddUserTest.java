package basetest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddUserPage;


public class AddUserTest extends BaseTests {

    @Test(priority = 1,dataProvider = "AddUserData")
    public void addUserTest(String fName,String lName,String uName, String pWord,Integer ValueOfRadioButton,String Role,String eMail, String cPhone){

        AddUserPage addUserTest = homePage.clickAddUser();
        addUserTest.enterFirstName(fName);
        addUserTest.enterLastName(lName);
        addUserTest.enterUserName(uName);
        addUserTest.enterPassword(pWord);
        addUserTest.clickRadioButton(ValueOfRadioButton);
        addUserTest.clickRoleButton(Role);
        addUserTest.enterEmail(eMail);
        addUserTest.enterCellphone(cPhone);
        addUserTest.clickSaveButton();

    }

    @DataProvider()
    public Object[][] AddUserData() {
        Object[][] data = new Object[3][8];

        data[0][0] = "FName1";data[0][1] = "LName1";data[0][2] = "User1";data[0][3] = "Pass1";data[0][4] = 0;data[0][5] = "Sales Team";data[0][6] = "sales@test.co.za";data[0][7] = "0215562722";
        data[1][0] = "FName2";data[1][1] = "LName2";data[1][2] = "User2";data[1][3] = "Pass2";data[1][4] = 1;data[1][5] = "Customer";data[1][6] = "customer@test.co.za";data[1][7] = "0215562723";
        data[2][0] = "FName3";data[2][1] = "LName3";data[2][2] = "User3";data[2][3] = "Pass3";data[2][4] = 0;data[2][5] = "Admin";data[2][6] = "admin@test.co.za";data[2][7] = "0215562724";

        return data;
    }
}
