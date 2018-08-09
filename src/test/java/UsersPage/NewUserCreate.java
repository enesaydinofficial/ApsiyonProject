package UsersPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

import static KeywordLayer.Command.*;

public class NewUserCreate {

    private static By Users = By.id("kisiler");
    private static By NewButton = By.cssSelector("[datasourcetype='Profile'] .mat-raised-button");
    private static By ApsiyonLoadingVideo = By.id("myVideo");
    private static By NameAndSurname = By.cssSelector("[placeholder='Adı Soyadı']");
    private static By TCNo = By.cssSelector("[placeholder='TC kimlik no']");
    private static By PhoneNumber1 = By.cssSelector("[placeholder='Telefon numarası (Varsayılan)']");
    private static By PhoneNumber2 = By.cssSelector("[placeholder='Telefon numarası (İkincil)']");
    private static By Email1 = By.cssSelector("[placeholder='E-Posta (Varsayılan)']");
    private static By Email2 = By.cssSelector("[placeholder='E-Posta (İkincil)']");
    private static By Addresses = By.cssSelector("[placeholder='Adres']");
    private static By VehiclePlateNumber = By.cssSelector("[placeholder='Araç Plakası']");
    private static By Job = By.cssSelector("[placeholder='Meslek']");
    private static By EducationStatus = By.cssSelector("[aria-label='Öğrenim Durumu']");
    private static By LicenseOption = By.cssSelector("mat-option.mat-option:nth-child(4)");
    private static By GirlCheckBox = By.cssSelector("#mat-radio-2  > label > div:nth-child(1)");
    private static By MenCheckBox = By.cssSelector("#mat-radio-3  > label > div:nth-child(1)");
    private static By OpeningBalanceEntry = By.className("mat-checkbox-layout");
    private static By Save = By.xpath("//span[contains(text(), 'Kaydet')]");

    @When("^Apsiyon System User Create$")
    public static void apsiyonUserCreate(DataTable UserInfo) throws Exception {
        List<List<String>> userinfo = UserInfo.raw();

        // Wait Apsiyon Video
        WaitElementNotVisible(ApsiyonLoadingVideo);

        // Users Button and New Button Click
        WaitElementToBeClickable(Users);
        Click(Users);
        WaitElementToBeClickable(NewButton);
        Click(NewButton);

        // User Create Form Filling
        WaitElementVisible(NameAndSurname);
        SendKeys(NameAndSurname, userinfo.get(0).get(1)); // Username and Surname
        SendKeys(TCNo, userinfo.get(1).get(1)); // TC No
        SendKeys(PhoneNumber1, userinfo.get(2).get(1)); // Phone Number 1
        SendKeys(PhoneNumber2, userinfo.get(3).get(1)); // Phone Number 2
        SendKeys(Email1, userinfo.get(4).get(1)); // E-Mail 1
        SendKeys(Email2, userinfo.get(5).get(1)); // E-Mail 2
        SendKeys(Addresses, userinfo.get(6).get(1)); // Addresses
        ScrollToElement(VehiclePlateNumber);
        SendKeys(VehiclePlateNumber, userinfo.get(8).get(1)); // Job
        SendKeys(Job, userinfo.get(7).get(1)); // Plate Number
        Click(EducationStatus);
        WaitElementToBeClickable(LicenseOption);
        Click(LicenseOption);

        if (userinfo.get(9).get(1).equals("Men")) {
            Click(MenCheckBox);
        } else if (userinfo.get(9).get(1).equals("Girl")) {
            Click(GirlCheckBox);
        }


        if (userinfo.get(10).get(1).equals("true")) {
            WaitElementToBeClickable(OpeningBalanceEntry);
            Click(OpeningBalanceEntry);
        }

        // Form Save
        WaitElementToBeClickable(Save);
        Click(Save);

    }
}
