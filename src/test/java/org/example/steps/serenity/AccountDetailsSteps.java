package org.example.steps.serenity;

import org.example.pages.AccountDetailsPages;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;


public class AccountDetailsSteps {
    private AccountDetailsPages pages;

    @Step
    public void is_the_home_page() {
        pages.open();
    }

    @Step
    public void login(String email, String password) {
        pages.login(email, password);
    }

    @Step
    public void clickChangeBillingAddressButton()
    {
        pages.clickChangeBillingAddressButton();
    }

    @Step
    public void changeFirstName(String firstName) {
        pages.changeFirstName(firstName);
    }

    @Step
    public void changeLastName(String lastName) {
        pages.changeLastName(lastName);
    }

    @Step
    public void changeCompany(String company) {
        pages.changeCompany(company);
    }

    @Step
    public void changePhoneNumber(String phoneNumber) {
        pages.changePhoneNumber(phoneNumber);
    }

    @Step
    public void changeStreet(String street) {
        pages.changeStreet(street);
    }

    @Step
    public void changeCity(String city) {
        pages.changeCity(city);
    }

    @Step
    public void changeStateOrProvince(String stateOrProvince) {
        pages.changeStateOrProvince(stateOrProvince);
    }

    @Step
    public void changeZipOrPostalCode(String zipOrPostalCode) {
        pages.changeZipOrPostalCode(zipOrPostalCode);
    }

    @Step
    public void changeCountry(int country) {
        pages.changeCountry(country);
    }

    @Step
    public void submit() {
        pages.submit();
    }

    @Step
    public void shouldBeOnPage(String expectedUrl) {
        String currentUrl = pages.getCurrentUrl();
        assertThat("Verify current URL", currentUrl, equalTo(expectedUrl));
    }

    @Step
    public void shouldNotBeOnPage(String expectedUrl) {
        String currentUrl = pages.getCurrentUrl();
        assertThat("Verify current URL", currentUrl, not(equalTo(expectedUrl)));
    }
}