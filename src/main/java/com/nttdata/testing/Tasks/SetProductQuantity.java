package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.MenClothesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class SetProductQuantity implements Task {

    private String cantidad;

    public SetProductQuantity(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Intentar con el campo principal de cantidad
            actor.attemptsTo(
                    WaitUntil.the(MenClothesPage.QUANTITY_FIELD, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(10).seconds(),
                    Clear.field(MenClothesPage.QUANTITY_FIELD),
                    Enter.theValue(cantidad).into(MenClothesPage.QUANTITY_FIELD)
            );

            System.out.println("✅ Cantidad configurada: " + cantidad);

        } catch (Exception e) {
            // Si falla, intentar con selectores alternativos
            try {
                actor.attemptsTo(
                        Clear.field(MenClothesPage.QUANTITY_INPUT),
                        Enter.theValue(cantidad).into(MenClothesPage.QUANTITY_INPUT)
                );
            } catch (Exception e2) {
                actor.attemptsTo(
                        Clear.field(MenClothesPage.QTY_FIELD_ALT1),
                        Enter.theValue(cantidad).into(MenClothesPage.QTY_FIELD_ALT1)
                );
            }
        }
    }

    public static Performable to(String cantidad) {
        return new SetProductQuantity(cantidad);
    }
}