package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@DefaultUrl("https://magento.softwaretestingboard.com/customer/account/login")
public class AccountDetailsPages extends PageObject {
    @FindBy(id = "email")
    private WebElementFacade emailInput;

    @FindBy(id = "pass")
    private WebElementFacade passwordInput;

    @FindBy(id = "send2")
    private WebElementFacade signInButton;

    @FindBy(xpath = "//span[contains(., 'Change Billing Address')]")
    private WebElementFacade changeBillingAddressButton;

    @FindBy(xpath = "//span[contains(., 'Save Address')]")
    private WebElementFacade submitButton;

    @FindBy(id = "firstname")
    private WebElementFacade firstNameInput;

    @FindBy(id = "lastname")
    private WebElementFacade lastNameInput;

    @FindBy(id = "company")
    private WebElementFacade companyInput;

    @FindBy(id = "telephone")
    private WebElementFacade phoneNumberInput;

    @FindBy(id = "street_1")
    private WebElementFacade street1Input;

    @FindBy(id = "street_2")
    private WebElementFacade street2Input;

    @FindBy(id = "street_3")
    private WebElementFacade street3Input;

    @FindBy(id = "city")
    private WebElementFacade cityInput;

    @FindBy(id = "region")
    private WebElementFacade stateOrProvinceInput;

    @FindBy(id = "zip")
    private WebElementFacade zipOrPostalCodeInput;

    @FindBy(id = "country")
    private WebElementFacade countryDropdown;

    public void login(String email, String password) {
        emailInput.type(email);
        passwordInput.type(password);
        signInButton.click();
    }

    public void clickChangeBillingAddressButton() {
        changeBillingAddressButton.click();
    }

    public void changeFirstName(String firstName) {
        firstNameInput.type(firstName);
    }

    public void changeLastName(String lastName) {
        lastNameInput.type(lastName);
    }

    public void changeCompany(String company) {
        companyInput.type(company);
    }

    public void changePhoneNumber(String phoneNumber) {
        phoneNumberInput.type(phoneNumber);
    }

    public void changeStreet(String street) {
        street1Input.type("");
        street2Input.type("");
        street3Input.type("");
        street1Input.type(street);
    }

    public void changeCity(String city) {
        cityInput.type(city);
    }

    public void changeStateOrProvince(String stateOrProvince) {
        stateOrProvinceInput.type(stateOrProvince);
    }

    public void changeZipOrPostalCode(String zipOrPostalCode) {
        zipOrPostalCodeInput.type(zipOrPostalCode);
    }

    public void changeCountry(int option) {
        Select select = new Select(countryDropdown);
        select.selectByIndex(option);
    }

    public void submit() {
        submitButton.click();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}