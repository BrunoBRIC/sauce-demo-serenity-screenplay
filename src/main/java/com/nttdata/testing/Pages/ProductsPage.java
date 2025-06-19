
package com.nttdata.testing.Pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage extends PageObject {

    // ========== MENU PRINCIPAL ==========

    public static final Target MEN_MENU = Target.the("Menu de hombres")
            .located(By.xpath("//span[text()='Men']"));

    public static final Target MEN_MENU_ALT = Target.the("Menu de hombres alternativo")
            .located(By.xpath("//a[@id='ui-id-5']//span[text()='Men']"));

    // ========== SUBMENUS ==========

    public static final Target Tops = Target.the("Tops")
            .located(By.xpath("//li[3]//span[text()='Tops']"));

    public static final Target JACKETS_SUBMENU = Target.the("Submenu de chaquetas")
            .located(By.xpath("//li[3]//span[text()='Jackets']"));

    public static final Target JACKETS_SUBMENU_ALT = Target.the("Submenu chaquetas alternativo")
            .located(By.xpath("//a[contains(@href,'jackets')]"));

    public static final Target HOODIES_SUBMENU = Target.the("Submenu de hoodies")
            .located(By.xpath("//a[text()='Hoodies & Sweatshirts']"));

    public static final Target HOODIES_SUBMENU_ALT = Target.the("Submenu hoodies alternativo")
            .located(By.xpath("//a[contains(@href,'hoodies')]"));

    // ========== PRODUCTOS ==========

    public static final Target PRODUCT_GRID = Target.the("Grilla de productos")
            .located(By.xpath("//ol[@class='products list items product-items']"));

    public static final Target FIRST_PRODUCT = Target.the("Primer producto disponible")
            .located(By.xpath("(//ol[@class='products list items product-items']//li[@class='item product product-item'])[1]//a[@class='product-item-link']"));

    public static final Target FIRST_PRODUCT_ALT = Target.the("Primer producto alternativo")
            .located(By.xpath("(//div[@class='product-item-info'])[1]//a"));

    public static final Target PRODUCT_ITEMS = Target.the("Items de productos")
            .located(By.xpath("//li[@class='item product product-item']"));

    // ========== LOADING Y ESTADOS ==========

    public static final Target LOADING_MASK = Target.the("Máscara de carga")
            .located(By.xpath("//div[@class='loading-mask']"));

    public static final Target PAGE_TITLE = Target.the("Título de la página")
            .located(By.xpath("//h1[@class='page-title']"));
}