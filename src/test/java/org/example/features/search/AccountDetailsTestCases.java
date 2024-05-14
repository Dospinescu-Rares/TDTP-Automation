package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import org.example.steps.serenity.AccountDetailsSteps;


@RunWith(SerenityRunner.class)
public class AccountDetailsTestCases {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public AccountDetailsSteps user;

    private final EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private final String email = environmentVariables.getProperty("test.email");
    private final String password = environmentVariables.getProperty("test.password");
    private final String addressDetailsPage = "https://magento.softwaretestingboard.com/customer/address/index/";

    @Before
    public void setup() {
        user.is_the_home_page();
        user.login(email, password);
        webdriver.get(addressDetailsPage);
        user.clickChangeBillingAddressButton();
    }

    @Test
    public void EmptyFirstName() {
        user.changeFirstName("");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void NumericFirstName() {
        user.changeFirstName("1234");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidFirstName() {
        user.changeFirstName("Mary-Anne");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyLastName() {
        user.changeLastName("");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void NumericLastName() {
        user.changeLastName("5678");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidLastName() {
        user.changeLastName("O'Connor");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyCompany() {
        user.changeCompany("");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidCompany() {
        user.changeCompany("Google");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyPhoneNumber() {
        user.changePhoneNumber("");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void SingleDigitPhoneNumber() {
        user.changePhoneNumber("0");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void SpecialCharacterPhoneNumber() {
        user.changePhoneNumber("%");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidPhoneNumber() {
        user.changePhoneNumber("1234567890");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyStreetAddress() {
        user.changeStreet("");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void SpecialCharacterStreetAddress() {
        user.changeStreet("&");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidStreetAddress() {
        user.changeStreet("123 Main Street, Apt 5B");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyCity() {
        user.changeCity("");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidCity() {
        user.changeCity("Rosario");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyStateOrProvince() {
        user.changeStateOrProvince("");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidStateOrProvince() {
        user.changeStateOrProvince("Santa Fe");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyZipOrPostalCode() {
        user.changeZipOrPostalCode("");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void SpecialCharacterZipOrPostalCode() {
        user.changeZipOrPostalCode("@");
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidZipOrPostalCode() {
        user.changeZipOrPostalCode("2000");
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }

    @Test
    public void EmptyCountry() {
        user.changeCountry(0);
        user.submit();

        user.shouldNotBeOnPage(addressDetailsPage);
    }

    @Test
    public void ValidCountry() {
        user.changeCountry(11);
        user.submit();

        user.shouldBeOnPage(addressDetailsPage);
    }
}