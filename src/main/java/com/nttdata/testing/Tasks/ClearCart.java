package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import org.openqa.selenium.By;
import net.serenitybdd.screenplay.targets.Target;

public class ClearCart implements Task {

    public static final Target REMOVE_ITEM = Target.the("Remover item del carrito")
            .located(By.xpath("//a[@title='Remove item']"));

    public static final Target CONFIRM_REMOVE = Target.the("Confirmar remover")
            .located(By.xpath("//button[@class='action-primary action-accept']"));

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            // Ir al carrito
            actor.attemptsTo(
                    Click.on(CartPage.CART_ICON),
                    WaitUntil.the(CartPage.VIEW_CART_LINK, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(5).seconds(),
                    Click.on(CartPage.VIEW_CART_LINK)
            );

            // Remover items si existen
            actor.attemptsTo(
                    WaitUntil.the(REMOVE_ITEM, WebElementStateMatchers.isPresent())
                            .forNoMoreThan(3).seconds(),
                    Click.on(REMOVE_ITEM),
                    Click.on(CONFIRM_REMOVE)
            );

            Thread.sleep(2000); // Esperar que se actualice

        } catch (Exception e) {
            System.out.println("Carrito ya está vacío o error al limpiar: " + e.getMessage());
        }
    }

    public static Performable now() {
        return new ClearCart();
    }
}
