package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class ProceedToCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Ir al carrito y proceder al checkout
        actor.attemptsTo(
                Click.on(CartPage.CART_ICON),
                WaitUntil.the(CartPage.VIEW_CART_LINK, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                Click.on(CartPage.VIEW_CART_LINK),
                WaitUntil.the(CartPage.PROCEED_CHECKOUT_BTN, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                Click.on(CartPage.PROCEED_CHECKOUT_BTN)
        );
    }

    public static Performable now() {
        return new ProceedToCheckout();
    }
}