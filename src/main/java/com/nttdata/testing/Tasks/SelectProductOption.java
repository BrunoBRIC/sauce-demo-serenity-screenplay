package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.ProductDetailPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class SelectProductOption implements Task {

    private String optionType;
    private String optionValue;

    public SelectProductOption(String optionType, String optionValue) {
        this.optionType = optionType;
        this.optionValue = optionValue;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            if (optionType.equals("size")) {
                selectSize(actor, optionValue);
            } else if (optionType.equals("color")) {
                selectColor(actor, optionValue);
            }
        } catch (Exception e) {
            System.err.println("Error seleccionando " + optionType + ": " + optionValue);
            throw new RuntimeException(e);
        }
    }

    private void selectSize(Actor actor, String size) {
        switch (size.toUpperCase()) {
            case "M":
                actor.attemptsTo(
                        WaitUntil.the(ProductDetailPage.SIZE_M, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(5).seconds(),
                        Click.on(ProductDetailPage.SIZE_M)
                );
                break;
            case "L":
                actor.attemptsTo(
                        WaitUntil.the(ProductDetailPage.SIZE_L, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(5).seconds(),
                        Click.on(ProductDetailPage.SIZE_L)
                );
                break;
            case "S":
                actor.attemptsTo(
                        WaitUntil.the(ProductDetailPage.SIZE_S, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(5).seconds(),
                        Click.on(ProductDetailPage.SIZE_S)
                );
                break;
            default:
                // Usar selector dinámico
                actor.attemptsTo(
                        Click.on(ProductDetailPage.SIZE_OPTION.of(size))
                );
        }
    }

    private void selectColor(Actor actor, String color) {
        switch (color) {
            case "Blue":
                actor.attemptsTo(
                        WaitUntil.the(ProductDetailPage.COLOR_BLUE, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(5).seconds(),
                        Click.on(ProductDetailPage.COLOR_BLUE)
                );
                break;
            case "Black":
                actor.attemptsTo(
                        WaitUntil.the(ProductDetailPage.COLOR_BLACK, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(5).seconds(),
                        Click.on(ProductDetailPage.COLOR_BLACK)
                );
                break;
            case "Gray":
                actor.attemptsTo(
                        WaitUntil.the(ProductDetailPage.COLOR_GRAY, WebElementStateMatchers.isClickable())
                                .forNoMoreThan(5).seconds(),
                        Click.on(ProductDetailPage.COLOR_GRAY)
                );
                break;
            default:
                // Usar selector dinámico
                actor.attemptsTo(
                        Click.on(ProductDetailPage.COLOR_OPTION.of(color))
                );
        }
    }

    public static Performable size(String size) {
        return new SelectProductOption("size", size);
    }

    public static Performable color(String color) {
        return new SelectProductOption("color", color);
    }
}