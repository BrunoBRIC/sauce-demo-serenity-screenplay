package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class NavigateToSection implements Task {

    private String seccion;
    private String categoria;

    public NavigateToSection(String seccion, String categoria) {
        this.seccion = seccion;
        this.categoria = categoria;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            System.out.println("Navegando a: " + seccion + " -> " + categoria);

            // Esperar que la página esté cargada
            Thread.sleep(2000);

            if (seccion.equals("Men")) {
                // Hover sobre el menú Men
                actor.attemptsTo(
                        WaitUntil.the(ProductsPage.MEN_MENU, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(15).seconds(),
                        MoveMouse.to(ProductsPage.MEN_MENU),
                        MoveMouse.to(ProductsPage.Tops)

                );

                // Esperar a que aparezca el submenu
                Thread.sleep(1000);

                if (categoria.equals("Jackets")) {
                    actor.attemptsTo(
                            WaitUntil.the(ProductsPage.JACKETS_SUBMENU, WebElementStateMatchers.isClickable())
                                    .forNoMoreThan(10).seconds(),
                            Click.on(ProductsPage.JACKETS_SUBMENU)
                    );
                } else if (categoria.equals("Hoodies")) {
                    actor.attemptsTo(
                            WaitUntil.the(ProductsPage.HOODIES_SUBMENU, WebElementStateMatchers.isClickable())
                                    .forNoMoreThan(10).seconds(),
                            Click.on(ProductsPage.HOODIES_SUBMENU)
                    );
                }
            }

            // Esperar a que carguen los productos
            actor.attemptsTo(
                    WaitUntil.the(ProductsPage.PRODUCT_GRID, WebElementStateMatchers.isVisible())
                            .forNoMoreThan(15).seconds()
            );

            System.out.println("Navegación completada exitosamente");

        } catch (Exception e) {
            System.err.println("Error en navegación: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error navegando a " + seccion + " -> " + categoria, e);
        }
    }

    public static Performable withData(String seccion, String categoria) {
        return new NavigateToSection(seccion, categoria);
    }
}