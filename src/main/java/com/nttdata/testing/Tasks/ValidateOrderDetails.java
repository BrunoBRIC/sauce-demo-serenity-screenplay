package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CheckoutPage;
import com.nttdata.testing.questions.RegisterQuestion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class ValidateOrderDetails implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Validar que los detalles del pedido sean correctos
        actor.should(
                seeThat("El resumen del pedido es visible",
                        RegisterQuestion.visibleEn(CheckoutPage.ORDER_SUMMARY))
        );

        actor.should(
                seeThat("El item está en el carrito",
                        RegisterQuestion.visibleEn(CheckoutPage.ITEM_IN_CART))
        );

        actor.should(
                seeThat("El total del pedido es visible",
                        RegisterQuestion.visibleEn(CheckoutPage.ORDER_TOTAL))
        );
    }

    public static Performable now() {
        return new ValidateOrderDetails();
    }
}