package com.nttdata.testing.Pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class MenClothesPage extends PageObject {
    public static final Target QUANTITY_FIELD = Target.the("Campo cantidad")
            .located(By.xpath("//input[@id='qty']"));

    public static final Target QUANTITY_INPUT = Target.the("Input de cantidad")
            .located(By.xpath("//input[@name='qty']"));

    public static final Target QUANTITY_SPINNER = Target.the("Selector de cantidad")
            .located(By.xpath("//input[@title='Qty']"));

    // Botones para aumentar/disminuir cantidad
    public static final Target QUANTITY_PLUS = Target.the("Aumentar cantidad")
            .located(By.xpath("//button[@class='increase items-count']"));

    public static final Target QUANTITY_MINUS = Target.the("Disminuir cantidad")
            .located(By.xpath("//button[@class='reduce items-count']"));

    // Alternativas para el campo de cantidad
    public static final Target QTY_FIELD_ALT1 = Target.the("Cantidad alternativo 1")
            .located(By.xpath("//div[@class='field qty']//input"));

    public static final Target QTY_FIELD_ALT2 = Target.the("Cantidad alternativo 2")
            .located(By.xpath("//input[contains(@class,'qty')]"));

    public static final Target TXT_BUSCAR = Target.the("Barra de busqueda")
            .located(By.id("search"));

    public static final Target ICN_BUSCAR = Target.the("Icono para buscar")
            .located(By.xpath("//button[contains(@class, 'search') and span[text()='Search']]"));

    public static final Target ITM_SHIRT = Target.the("Item Shirt")
            .located(By.xpath("//li[contains(@class, 'product-item') and .//a[contains(text(), 'Proteus Fitness Jackshirt')]]"));

    public static final Target ITM_TALLA = Target.the("Item Talla de ropa")
            .located(By.xpath("//div[@option-label='L']"));

    public static final Target ITM_COLOR_PRENDA = Target.the("Color de la prenda")
            .located(By.xpath("//div[@option-label='Blue']"));

    public static final Target BTN_AGREGAR_CARRITO = Target.the("Boton Agregar producto al carrito")
            .located(By.xpath("//button[span[text()='Add to Cart']]"));

    public static final Target ITM_CARRITO = Target.the("Items agregados al carrito")
            .located(By.xpath("//div[@data-block='minicart']//span[@class='counter qty']//span[@class='counter-number']"));

    public static final Target IRCARRITO = Target.the("Items agregados al carrito")
            .located(By.xpath("//*[@class='action showcart']"));


    public static final Target PROCESO = Target.the("Items agregados al carrito")
            .located(By.xpath("//*[@title='Proceed to Checkout']"));


    public static final Target CHECK = Target.the("Items agregados al carrito")
            .located(By.xpath("//*[@name='ko_unique_1']"));
    public static final Target BRNNEXT = Target.the("Items agregados al carrito")
            .located(By.xpath("//span[text()='Next']"));
    public static final Target CONFIRMAR = Target.the("Items agregados al carrito")
            .located(By.xpath("//span[text()='Place Order']"));

    public static final Target TEXTO = Target.the("Items agregados al carrito")
            .located(By.xpath("//span[text()='Thank you for your purchase!']"));
}
