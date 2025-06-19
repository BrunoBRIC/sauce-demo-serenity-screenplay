package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class FillCheckoutForm implements Task {

    private String email;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String zipCode;
    private String phone;

    public FillCheckoutForm(String email, String firstName, String lastName,
                            String street, String city, String zipCode, String phone) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Llenar información de envío
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.EMAIL_FIELD, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(CheckoutPage.EMAIL_FIELD),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(street).into(CheckoutPage.STREET_ADDRESS_FIELD),
                Enter.theValue(city).into(CheckoutPage.CITY_FIELD),
                SelectFromOptions.byVisibleText("New York").from(CheckoutPage.STATE_DROPDOWN),
                Enter.theValue(zipCode).into(CheckoutPage.ZIP_CODE_FIELD),
                SelectFromOptions.byVisibleText("United States").from(CheckoutPage.COUNTRY_DROPDOWN),
                Enter.theValue(phone).into(CheckoutPage.PHONE_FIELD)
        );

        // Seleccionar método de envío
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FLAT_RATE_SHIPPING, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(5).seconds(),
                Click.on(CheckoutPage.FLAT_RATE_SHIPPING),
                Click.on(CheckoutPage.NEXT_BUTTON)
        );

        // Seleccionar método de pago
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CHECK_MONEY_ORDER, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.CHECK_MONEY_ORDER)
        );
    }

    public static Performable withData(String email, String firstName, String lastName,
                                       String street, String city, String zipCode, String phone) {
        return new FillCheckoutForm(email, firstName, lastName, street, city, zipCode, phone);
    }

    public static Performable withDefaultData() {
        return new FillCheckoutForm(
                "test@example.com",
                "John",
                "Doe",
                "123 Main Street",
                "New York",
                "10001",
                "555-1234567"
        );
    }
}