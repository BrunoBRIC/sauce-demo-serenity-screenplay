package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {

    // ========== INFORMACIÓN DE ENVÍO ==========

    public static final Target EMAIL_FIELD = Target.the("Campo email")
            .located(By.xpath("//input[@id='customer-email']"));

    public static final Target FIRST_NAME_FIELD = Target.the("Campo nombre")
            .located(By.xpath("//input[@name='firstname']"));

    public static final Target LAST_NAME_FIELD = Target.the("Campo apellido")
            .located(By.xpath("//input[@name='lastname']"));

    public static final Target STREET_ADDRESS_FIELD = Target.the("Campo dirección")
            .located(By.xpath("//input[@name='street[0]']"));

    public static final Target CITY_FIELD = Target.the("Campo ciudad")
            .located(By.xpath("//input[@name='city']"));

    public static final Target STATE_DROPDOWN = Target.the("Dropdown estado")
            .located(By.xpath("//select[@name='region_id']"));

    public static final Target ZIP_CODE_FIELD = Target.the("Campo código postal")
            .located(By.xpath("//input[@name='postcode']"));

    public static final Target COUNTRY_DROPDOWN = Target.the("Dropdown país")
            .located(By.xpath("//select[@name='country_id']"));

    public static final Target PHONE_FIELD = Target.the("Campo teléfono")
            .located(By.xpath("//input[@name='telephone']"));

    // ========== MÉTODOS DE ENVÍO ==========

    public static final Target SHIPPING_METHOD_RADIO = Target.the("Método de envío")
            .located(By.xpath("//input[@type='radio' and @name='shipping_method']"));

    public static final Target FLAT_RATE_SHIPPING = Target.the("Envío tarifa plana")
            .located(By.xpath("//input[@value='flatrate_flatrate']"));

    public static final Target NEXT_BUTTON = Target.the("Botón siguiente")
            .located(By.xpath("//button[@data-role='opc-continue']"));

    // ========== MÉTODOS DE PAGO ==========

    public static final Target PAYMENT_METHOD_RADIO = Target.the("Método de pago")
            .located(By.xpath("//input[@type='radio' and @name='payment[method]']"));

    public static final Target CHECK_MONEY_ORDER = Target.the("Check/Money Order")
            .located(By.xpath("//input[@id='checkmo']"));

    public static final Target BILLING_SAME_AS_SHIPPING = Target.the("Usar misma dirección de facturación")
            .located(By.xpath("//input[@id='billing-address-same-as-shipping-checkmo']"));

    // ========== FINALIZAR COMPRA ==========

    public static final Target PLACE_ORDER_BUTTON = Target.the("Botón Place Order")
            .located(By.xpath("//button[@title='Place Order']"));

    public static final Target BTN_PLACE_ORDER = Target.the("Boton realizar pedido")
            .located(By.xpath("//button[contains(@class,'checkout')]//span[text()='Place Order']"));

    public static final Target PLACE_ORDER_ALT = Target.the("Place Order alternativo")
            .located(By.xpath("//button[@data-role='review-save']"));

    // ========== VALIDACIÓN DE COMPRA ==========

    public static final Target SUCCESS_MESSAGE = Target.the("Mensaje de éxito")
            .located(By.xpath("//span[text()='Thank you for your purchase!']"));

    public static final Target SUCCESS_PAGE_TITLE = Target.the("Título página de éxito")
            .located(By.xpath("//h1[text()='Thank you for your purchase!']"));

    public static final Target ORDER_NUMBER = Target.the("Número de orden")
            .located(By.xpath("//a[@class='order-number']/strong"));

    public static final Target ORDER_CONFIRMATION = Target.the("Confirmación de orden")
            .located(By.xpath("//p[contains(text(),'Your order number is')]"));

    // ========== RESUMEN DEL PEDIDO ==========

    public static final Target ORDER_SUMMARY = Target.the("Resumen del pedido")
            .located(By.xpath("//div[@class='opc-block-summary']"));

    public static final Target ITEM_IN_CART = Target.the("Item en el carrito")
            .located(By.xpath("//strong[@class='product-item-name']"));

    public static final Target ITEM_PRICE = Target.the("Precio del item")
            .located(By.xpath("//span[@class='cart-price']"));

    public static final Target ORDER_TOTAL = Target.the("Total del pedido")
            .located(By.xpath("//tr[@class='grand totals']//span[@class='price']"));
}