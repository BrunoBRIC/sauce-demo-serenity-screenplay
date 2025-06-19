package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ConfigureProduct implements Task {

    private final String talla;
    private final String color;

    public ConfigureProduct(String talla, String color) {
        this.talla = talla;
        this.color = color;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductDetailPage.SIZE_OPTION.of(talla)),
                Click.on(ProductDetailPage.COLOR_OPTION.of(color))
        );
    }

    public static Performable withData(String talla, String color) {
        return new ConfigureProduct(talla, color);
    }
}
