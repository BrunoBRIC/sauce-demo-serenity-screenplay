package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailPage extends PageObject {

    public static final Target SIZE_SELECTOR = Target.the("Selector de tallas")
            .located(By.xpath("//div[@class='swatch-attribute size']"));

    public static final Target SIZE_M = Target.the("Talla M")
            .located(By.xpath("//div[@option-label='M']"));

    public static final Target SIZE_L = Target.the("Talla L")
            .located(By.xpath("//div[@option-label='L']"));

    public static final Target SIZE_S = Target.the("Talla S")
            .located(By.xpath("//div[@option-label='S']"));

    public static final Target SIZE_OPTION = Target.the("Opción de talla")
            .locatedBy("//div[@class='swatch-option text' and @option-label='{0}']");

    // ========== SELECTORES DE COLOR ==========

    public static final Target COLOR_SELECTOR = Target.the("Selector de colores")
            .located(By.xpath("//div[@class='swatch-attribute color']"));

    public static final Target COLOR_BLUE = Target.the("Color azul")
            .located(By.xpath("//div[@option-label='Blue']"));

    public static final Target COLOR_BLACK = Target.the("Color negro")
            .located(By.xpath("//div[@option-label='Black']"));

    public static final Target COLOR_GRAY = Target.the("Color gris")
            .located(By.xpath("//div[@option-label='Gray']"));

    public static final Target COLOR_OPTION = Target.the("Opción de color")
            .locatedBy("//div[@class='swatch-option color' and @option-label='{0}']");

    // ========== BOTÓN AGREGAR AL CARRITO ==========

    public static final Target BTN_ADD_TO_CART = Target.the("Botón agregar al carrito")
            .located(By.xpath("//button[@id='product-addtocart-button']"));

    public static final Target BTN_ADD_TO_CART_ALT = Target.the("Botón agregar alternativo")
            .located(By.xpath("//button[@title='Add to Cart']"));

    // ========== CANTIDAD ==========

    public static final Target QUANTITY_INPUT = Target.the("Campo cantidad")
            .located(By.xpath("//input[@id='qty']"));

    // ========== CONFIRMACIONES ==========

    public static final Target SUCCESS_MESSAGE = Target.the("Mensaje de éxito")
            .located(By.xpath("//div[@data-ui-id='message-success']"));

    public static final Target CART_COUNTER = Target.the("Contador del carrito")
            .located(By.xpath("//span[@class='counter-number']"));

}