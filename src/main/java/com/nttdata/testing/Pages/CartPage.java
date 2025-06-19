package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {

    // ========== ELEMENTOS DEL CARRITO ==========

    public static final Target CART_ICON = Target.the("Icono del carrito")
            .located(By.xpath("//a[@class='action showcart']"));

    public static final Target CART_COUNTER = Target.the("Contador del carrito")
            .located(By.xpath("//span[@class='counter-number']"));

    public static final Target VIEW_CART_LINK = Target.the("Ver carrito")
            .located(By.xpath("//a[text()='View and Edit Cart']"));

    public static final Target PROCEED_CHECKOUT_BTN = Target.the("Proceder al checkout")
            .located(By.xpath("//button[@data-role='proceed-to-checkout']"));

    public static final Target PROCEED_CHECKOUT_BTN_ALT = Target.the("Proceder al checkout alternativo")
            .located(By.xpath("//button[contains(@class,'checkout')]"));

    public static final Target CHECKOUT_BUTTON = Target.the("Boton checkout")
            .located(By.xpath("//button[@title='Proceed to Checkout']"));

    // Elementos de productos en el carrito
    public static final Target CART_ITEMS = Target.the("Items del carrito")
            .located(By.xpath("//tbody[@class='cart item']"));

    public static final Target PRODUCT_NAME_IN_CART = Target.the("Nombre del producto en carrito")
            .located(By.xpath("//strong[@class='product-item-name']/a"));

    public static final Target PRODUCT_PRICE = Target.the("Precio del producto")
            .located(By.xpath("//span[@class='cart-price']//span[@class='price']"));

    public static final Target SUBTOTAL = Target.the("Subtotal")
            .located(By.xpath("//tr[@class='totals sub']//span[@class='price']"));

    public static final Target TOTAL = Target.the("Total")
            .located(By.xpath("//tr[@class='grand totals']//span[@class='price']"));
}
